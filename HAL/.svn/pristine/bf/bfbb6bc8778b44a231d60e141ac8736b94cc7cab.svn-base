<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetailSen"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Properties"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Calendar"%><script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
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
function CheckAll(chk)
{
for (var i=0;i < document.sampleCollection.elements.length;i++)
	{
		var e = document.sampleCollection.elements[i];
		
		if (e.type == "checkbox")
		{
			e.checked = chk.checked;
		}
	}
}
 function goBack(){
 	window.location.href='/hms/hms/investigation?method=searchPatientForResultValidationLab';
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
	String time = (String)utilMap.get("currentTimeWithoutSc");
	String userName = "";
	String resultId = "";
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
	if(map.get("resultId") !=null){
		resultId = (String)map.get("resultId");
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


	DgResultEntryHeader dgResultEntryHeader= new DgResultEntryHeader();
	if(resultList != null && resultList.size() >0) {
		dgResultEntryHeader = (DgResultEntryHeader) resultList.get(0);
	}

	DgResultEntryHeader dgresultHeader=new DgResultEntryHeader();
	if(resultList != null && resultList.size() >0){
		dgresultHeader = (DgResultEntryHeader) resultList.get(0);

	}
	 
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
<form name="sampleCollection" method="post" action="">
<div class="titleBg"><h2>Result Validation</h2></div>
<%
String subDept = "";

int SubChargeId=0;
int mainChargeId=0;
		for(DgResultEntryDetail dgDetail :dgResultDtSet){
			if(dgDetail.getInvestigation() != null){
			subDept = dgDetail.getInvestigation().getSubChargecode().getSubChargecodeName();
			SubChargeId=dgDetail.getInvestigation().getSubChargecode().getId();
			mainChargeId=dgDetail.getInvestigation().getMainChargecode().getId();
%> <%
 			}
 		}%>
 <div class="Block">
 <!--<label> Lab</label>
 <label	class="value" name="<%=MAIN_CHARGECODE_NAME %>"><%=deptName%></label>
<label>Modality</label>
<label	name="<%=SUB_CHARGECODE_NAME %>" class="value"><%=subDept%></label>
--><input name="<%=SUB_CHARGECODE_ID %>" id="<%= SUB_CHARGECODE_ID%>"
	type="hidden" value="<%=SubChargeId %>" />
	<input	name="<%=MAIN_CHARGECODE_ID %>" id="<%= MAIN_CHARGECODE_ID%>"
	type="hidden" value="<%=mainChargeId %>" />
</div>
<div class="Clear"></div>
<div class="Block">
<label>Result Date</label>
<%if(dgresultHeader.getResultDate() != null){ %>
<label	class="value"><%=HMSUtil.convertDateToStringWithoutTime(dgresultHeader.getResultDate())%></label>
<%}else{ %>
<label class="value">-</label> <%} %>
<label>Time</label>
<%if(dgresultHeader.getResultTime() != null){ %>
<label class="value"><%=dgresultHeader.getResultTime()%></label>
<%}else{ %>
<label class="value">-</label> <%} %>
<!--<label class="medium">Req. No.</label>
<%if(dgresultHeader.getSampleCollectionHeader().getOrder() != null){ %>
<label class="valueMedium"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getOrderNo()%></label>
<%}else{ %>
<label class="valueMedium">-</label> <%} %>
-->
<label>Result Entered By</label> 
<%if(dgresultHeader.getEmployee() != null){ %>
<label class="value"><%=dgresultHeader.getEmployee().getFirstName()+" "+(dgresultHeader.getEmployee().getMiddleName()!=null?dgresultHeader.getEmployee().getMiddleName():"")+" "+(dgresultHeader.getEmployee().getLastName()!=null?dgresultHeader.getEmployee().getLastName():"")%></label>
<%}else{ %> <label class="value">-</label> <%} %>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<h4>Patient Details</h4>
<div class="Block">
<!--<label>HIN No.</label>
<label	class="value"><%=dgResultEntryHeader.getPatient().getHinNo() %></label>

-->
<label>Employee No.</label> 
<%
	if(dgResultEntryHeader.getPatient().getServiceNo() != null && !(dgResultEntryHeader.getPatient().getServiceNo().equals(""))){
%>
<label class="value"><%=dgResultEntryHeader.getPatient().getServiceNo()%></label>
<%}else{ %> 
<label class="value">-</label> 
<%}%>
<%
		String middleName = "";
		String lastName = "";
		if(dgResultEntryHeader.getPatient().getPMiddleName() != null){
			middleName = dgResultEntryHeader.getPatient().getPMiddleName();
		}
		if(dgResultEntryHeader.getPatient().getPLastName() != null){
			lastName = dgResultEntryHeader.getPatient().getPLastName();
		}
		
		%> 
<label>Patient Name</label> 
<label class="value"><%=dgResultEntryHeader.getPatient().getPFirstName()+" "+middleName+" "+lastName%></label>

<label>Relation</label>
<%
	if(dgResultEntryHeader.getPatient().getRelation() != null){
%>
<label class="value"><%=dgResultEntryHeader.getPatient().getRelation().getRelationName()%></label>
<%}else{ %> 
<label class="value">-</label>
<% }%>
<div class="Clear"></div>


<label>Employee Name</label> 
<%
	if(dgResultEntryHeader.getPatient().getSFirstName() != null  && !(dgResultEntryHeader.getPatient().getSFirstName().equals(""))){
	
		String sMiddleName = "";
		String sLastName = "";
		if(dgResultEntryHeader.getPatient().getSMiddleName() != null){
			sMiddleName = dgResultEntryHeader.getPatient().getSMiddleName();
		}
		if(dgResultEntryHeader.getPatient().getSLastName() != null){
			sLastName = dgResultEntryHeader.getPatient().getSLastName();
		}
%> 
<label class="value"><%=dgResultEntryHeader.getPatient().getSFirstName()+" "+sMiddleName+" "+sLastName%></label>
<%}else{ %> 
<label class="value">-</label> 
<% }%> 


<%
		
	    
	    
	       int PatientAge=0;
					
			if(dgResultEntryHeader.getPatient().getDateOfBirth() != null)
			{
				Date date_of_birth= dgResultEntryHeader.getPatient().getDateOfBirth();		
				
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

<label>Gender</label>
<label class="value"><%= dgResultEntryHeader.getPatient().getSex().getAdministrativeSexName()%></label>

<div class="Clear"></div>
<label>Clinical Notes</label> 
<%if(dgResultEntryHeader.getSampleCollectionHeader().getOrder().getClinicalNote() != null){ %>
<label class="valueLarge"><%=dgResultEntryHeader.getSampleCollectionHeader().getOrder().getClinicalNote() %></label>
<%}else{ %>
<label class="valueLarge">-</label>
<%} %> 

<%
if(dgResultEntryHeader.getInpatient() != null){
%> <input type="hidden" name="<%=INPATIENT_ID %>"	value="<%=dgResultEntryHeader.getInpatient().getId()%>" /> 
   <input  type="hidden" name="<%=ORDER_NO %>"  value="<%=dgResultEntryHeader.getSampleCollectionHeader().getOrder().getOrderNo() %>" />
<%} else{%>
<input	type="hidden" name="<%=INPATIENT_ID %>" value="" /> 
<%} %> 
<input	type="hidden" name="<%=DEPARTMENT_ID %>"	value="<%=dgResultEntryHeader.getDepartment().getId()%>" /> 
<input	type="hidden" name="<%=HIN_ID %>"	value="<%=dgResultEntryHeader.getPatient().getId() %>" /> 
<input	type="hidden" name="<%=HIN_NO %>"	value="<%=dgResultEntryHeader.getPatient().getHinNo() %>" />
<input  type="hidden" name="<%=ORDER_NO %>"  value="<%=dgResultEntryHeader.getSampleCollectionHeader().getOrder().getOrderNo() %>" />
<input  type="hidden" name="orderId"  value="<%=dgResultEntryHeader.getSampleCollectionHeader().getOrder().getId() %>" />
</div>
<div class="Clear"></div>
<!--Block Two Ends-->  <!-- Block Three Starts -->
<h4>Result Updation Details</h4>
<div class="Block">
<%if(dgresultHeader.getEmployee() != null) {
	String mname=" ";
	String lname=" ";
	if(dgResultEntryHeader.getEmployee().getMiddleName()!=null)
	{
		mname=dgResultEntryHeader.getEmployee().getMiddleName();
	}
	if(dgResultEntryHeader.getEmployee().getLastName()!=null)
	{
		lname=dgResultEntryHeader.getEmployee().getLastName();
	}%>
<input type="hidden" id="<%=RESULT_ENTERED_BY %>"	name="<%=RESULT_ENTERED_BY %>"	value="<%=dgresultHeader.getEmployee().getFirstName() %>" />
<%}else { %> 
<input type="hidden" id="<%=RESULT_ENTERED_BY %>"	name="<%=RESULT_ENTERED_BY %>" value="0" /> 
<%} %>

<div class="Clear"></div>
<input type="hidden" name="<%=RESULT_NO %>"	value="<%=dgResultEntryHeader.getResultNo() %>" /> 
<label>Updation Date</label>	
<label class="value"><%=date%></label>
<label> Time</label> 
<label	class="value"><%=time%></label> 

<label> Updation By <span>*</span></label> 
<%

Users user = (Users)session.getAttribute("users");
Integer empId =user.getEmployee().getId();
%>

<label class="value"><%=user.getEmployee().getFirstName() %></label>

	<input	type="hidden" name="resultUpdatedBy" id="resultUpdatedBy" value="<%=empId%>" />
<%--<select id="<%=RESULT_VALIDATED_BY %>"	name="<%= RESULT_VALIDATED_BY %>"	validate="Report Validated By,string,yes" tabindex=1>
	<option value="">Select</option>
	<%
		Users user = (Users)session.getAttribute("users");
		Integer userId =user.getEmployee().getId();
		String mname=" ";
			for (MasEmployee masEmployeecode : employeeList) {
				if(masEmployeecode.getEmpCategory() != null){
					if( masEmployeecode.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor) ){
				if (userId .equals(masEmployeecode.getId())) {
					if(masEmployeecode.getMiddleName()!=null)
					{
						mname=masEmployeecode.getMiddleName();
					}
		%>
	<option value="<%=masEmployeecode.getId ()%>" selected="selected"><%=masEmployeecode.getEmployeeCode()%>
	- <%=masEmployeecode.getFirstName()%> <%=mname%>
	<%=masEmployeecode.getLastName()%></option>
	<%}else{ %>
	<option value="<%=masEmployeecode.getId ()%>"><%=masEmployeecode.getEmployeeCode()%>
	- <%=masEmployeecode.getFirstName()%> <%=mname%>
	<%=masEmployeecode.getLastName()%></option>
	<%	}}	}}	%>
</select> --%>

<div class="Clear"></div>
<input type=hidden value=0 name=pagecounter2 /> 
<input type="hidden"	name="pageNo" id="pageNo" value="<%=pageNo%>" />
</div>
<!-- Block Three Ends -->
<div class="Clear"></div>
<!-- Table Starts --> 
<%if(deptType.equalsIgnoreCase("DIAG")){ %>
<label	style="width: auto; padding-left: 10px; padding-top: 0px; color: #AC1400;">
(In Result Column: Special Characters like (,-,@ etc) are not allowed
only numeric values can be entered.) </label>
<%} %>
<div class="cmntable">
<table id="chargeDetails" width="100%" cellpadding="0" cellspacing="0">

	<tr>
		<th width="7%">Sl No.</th>
		<th width="7%">Investigation</th>
		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<th width="7%">Sample</th>
		<%} %>
		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<th width="10%">Result</th>
		<%} %>
		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<th width="10%">Units</th>
		<%} %>
		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<th width="10%">Normal Range</th>
		<%} %>

		<th width="4%"> Remarks</th>

		<th width="4%"><input type="checkbox" name="checkall" value="Validate All" id="addbutton" class="radioCheck"	onclick="CheckAll(this);"  /> Validate </th>
	</tr>
		<% 
    int index = 0;
    int indexForSingle = 0;
    int indexForMultiple = 0;
    
    for(DgResultEntryHeader dgResultEntryHeader2 : resultList){ 
 		if(dgResultEntryHeader2.getResultType() != null && dgResultEntryHeader2.getResultType().equalsIgnoreCase("S")){
 			DgResultEntryDetailSen dgDetail = dgResultEntryHeader2.getDgResultEntryDetailSen().iterator().next();
 			%>
		<tr>
			<td><%=index+1 %></td>
			<td>
	<%
	  if(dgDetail.getInvestigation() !=null){ 
	     %> 
	 <label name="<%=INVESTIGATION_NAME %>"><%=dgDetail.getInvestigation().getInvestigationName() %>	</label> 
	 <%}else { %> 
	 <label style="font-weight: bold;">-</label> 
	 <%} %>
	</td>
	<td>&nbsp;</td>
	<td><input name="resultIdSensitive"	id="resultIdSensitive<%=index%>" type="hidden"	value="<%=dgDetail.getResultEntry().getId()%>" /> 
	<input	type="button" class="cmnButton" style="width: auto;"	value="Click Here To validate Result" onclick="openSensitiveScreen('<%=index%>');" align="right" /></td>
	<td></td>
	</tr>

	<%	}else{
		   	DgResultEntryDetail dgDetail = dgResultEntryHeader2.getDgResultEntryDetails().iterator().next();

	    	if(dgDetail.getInvestigation().getInvestigationType().equals("s")){
				
			    %>
		<tr>
			<td><%=index+1 %></td>
			<td width="7%">
			<%if(dgDetail.getInvestigation() !=null){  %> 
			<input type="hidden" name="<%=RESULT_ID_SINGLE_VALUE %>" id="<%= RESULT_ID_SINGLE_VALUE%>"	value="<%=dgResultEntryHeader2.getId() %>" /> 
			<input	name="chargeCodeCodeForPerticularTest"	id="chargeCodeCodeForPerticularTest<%=index+1%>"value=<%= dgDetail.getInvestigation().getChargeCode().getChargeCodeCode()%>		type="hidden">
			<input name="resultNumericOrString"		id="resultNumericOrString<%=index+1%>"	value="<%= dgDetail.getInvestigation().getNumericOrString()%>"	type="hidden"> 
			<input name="<%=RESULT_TYPE_SINGLE_VALUE %>"	type="hidden" size="10" value="<%=dgDetail.getResultType() %>"	readonly /> 
			<input name="<%=INVESTIGATION_ID_SINGLE_VALUE %>"	type="hidden" size="5" value="<%=dgDetail.getInvestigation().getId() %>" readonly /> 
			<label	style="font-weight: bold;"><%=dgDetail.getInvestigation().getInvestigationName()%></label>

			<%}else { %> 
			<label style="font-weight: bold;">-</label> 
			<%} %>
			</td>
			<%if(deptType.equalsIgnoreCase("DIAG")){ %>
			<td width="7%">
			<%if(dgDetail.getSample() !=null){ %> 
			<label><%=dgDetail.getSample().getSampleDescription() %></label>
			<input	name="<%=SAMPLE_ID_SINGLE_VALUE %>" id=<%=SAMPLE_ID_SINGLE_VALUE %>	type="hidden" size="5" value="<%=dgDetail.getSample().getId() %>"	readonly /> 
			<!--<input name="sample2"	value="<%=dgDetail.getSample().getSampleDescription() %>"	readonly="readonly" /> 
			--><%}else { %> 
			<label>-</label>
			<input type="hidden" name="sample2" readonly="readonly"/>- <%} %>
			</td>
			<%} %>
			<td>
			<% 
		    try{
		    	if(dgDetail.getInvestigation().getMinNormalValue() != null	&& dgDetail.getInvestigation().getMaxNormalValue() != null
		    		&& !dgDetail.getInvestigation().getMinNormalValue().equals("") && !dgDetail.getInvestigation().getMaxNormalValue().equals("")){
		    		
		    		Float minValue = Float.parseFloat(dgDetail.getInvestigation().getMinNormalValue());
		    		Float maxValue = Float.parseFloat(dgDetail.getInvestigation().getMaxNormalValue());
		    		if(dgDetail.getResult() != null && !dgDetail.getResult().equals("")){
		    			
		    			
		    			 properties = new Properties();
		    			 resourcePath = Thread.currentThread().getContextClassLoader()
		    					.getResource("adt.properties");
		    			String[] InvestigationId = null;
		    			try {
		    				properties.load(resourcePath.openStream());
		    				//String [] wardDepartmentTypeCode = (String []) properties.get("a");
		    				InvestigationId = properties.getProperty("InvetigationIdforWithoutDecimalResultPrinting").trim().split(",");
		    				//departmentTypeCode = properties.getProperty("departmentTypeCodeForOpd");
		    				
		    			} catch (Exception e) {
		    				e.printStackTrace();
		    			}		    			
		    			
		    			List<String> inv = new ArrayList<String>(Arrays.asList(InvestigationId));
		    			Float floatResult1   = Float.parseFloat(dgDetail.getResult());
		    			String finalResult="";
		    			if(inv.contains(dgDetail.getInvestigation().getId().toString()))
		    			{
		    				 finalResult = new DecimalFormat("0.##").format((double)floatResult1); // without decimal
		    			}
		    			else
		    			{
		    				 finalResult = floatResult1.toString(); // with decimal
		    			}
		    			
		    			
			    		if(floatResult1 <= maxValue && floatResult1 >= minValue ){ %> 
		
			<input	name="<%=RESULT_SINGLE_VALUE %>" tabindex="1" onkeyup="submitAllExceptEnter(this,event,'','<%=index+1 %>');" id="<%=RESULT_SINGLE_VALUE %><%=index+1 %>" value="<%=finalResult %>" />
			<% }else{ %> 
			<input name="<%=RESULT_SINGLE_VALUE %>" tabindex="1" onkeyup="submitAllExceptEnter(this,event,'','<%=index+1 %>');"	id="<%=RESULT_SINGLE_VALUE %><%=index+1 %>" class="highlight"	value="<%=finalResult %>" /> 
			<% }
		}else{%> 
		<input name="<%=RESULT_SINGLE_VALUE %>" tabindex="1" onkeyup="submitAllExceptEnter(this,event,'','<%=index+1 %>');"	id="<%=RESULT_SINGLE_VALUE %><%=index+1 %>" value="" />
		<%}
      }else{ 
          if(dgDetail.getResult() != null){%> 
         <input	name="<%=RESULT_SINGLE_VALUE %>" tabindex="1" onkeyup="submitAllExceptEnter(this,event,'','<%=index+1 %>');" id="<%=RESULT_SINGLE_VALUE %><%=index+1 %>"	value="<%=dgDetail.getResult()%>" /> 
         <% }else { %> 
         <input	name="<%=RESULT_SINGLE_VALUE %>" tabindex="1" onkeyup="submitAllExceptEnter(this,event,'','<%=index+1 %>');" id="<%=RESULT_SINGLE_VALUE %><%=index+1 %>" value="" />
			<% } %> 
			<% } 
	}catch(Exception exception){ %> 
	<input	name="<%=RESULT_SINGLE_VALUE %>" tabindex="1"	onkeyup="submitAllExceptEnter(this,event,'','<%=index+1 %>');"	id="<%=RESULT_SINGLE_VALUE %><%=index+1 %>"	value="<%=dgDetail.getResult()%>" /> 
	<% } %>
	</td>
	<%if(deptType.equalsIgnoreCase("DIAG")){ %>
	<td width="10%">
	<%if(dgDetail.getUom() !=null){ %> 
	<input	name="<%=UNIT_OF_MEASUREMENT_ID_SINGLE_VALUE %>" id="<%=UNIT_OF_MEASUREMENT_ID_SINGLE_VALUE %>" type="hidden" size="5" value="<%=dgDetail.getUom().getId()%>" readonly /> 
	<label ><%=dgDetail.getUom().getUomName() %></label>
	<!--<input	name="uom" value="<%=dgDetail.getUom().getUomName() %>"	readonly="readonly" /></input> 
	--><%}else { %> 
	<label >-</label>
	<input type="hidden" name="uom" value="-"	readonly="readonly" /></input> 
	<%} %>
	</td>
	<%} %>

		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<td width="10%">
		<%if(dgDetail.getInvestigation().getNormalValue() != null || dgDetail.getInvestigation().getMinNormalValue() != null || dgDetail.getInvestigation().getMaxNormalValue() != null){ %>
		<%if(dgDetail.getInvestigation().getNormalValue() != null ){ 
						if(!dgDetail.getInvestigation().getNormalValue().equals("")){
					%> 
					<label ><%=dgDetail.getInvestigation().getNormalValue()%></label>
	<input name="normalValue" type="hidden" size="8"	value="<%=dgDetail.getInvestigation().getNormalValue()%>" readonly />
		<%}else if (dgDetail.getInvestigation().getMinNormalValue()!= null && dgDetail.getInvestigation().getMaxNormalValue() != null){ %>
	<label><%=dgDetail.getInvestigation().getMinNormalValue()+" - "+dgDetail.getInvestigation().getMaxNormalValue()%></label>
	<input name="normalValue" type="hidden" style="" size="10"	value="<%=dgDetail.getInvestigation().getMinNormalValue()+" - "+dgDetail.getInvestigation().getMaxNormalValue()%>" readonly /> 
	<%}
		} 
	else if(dgDetail.getInvestigation().getMinNormalValue()!= null && dgDetail.getInvestigation().getMaxNormalValue() != null){ %>
	<label><%=dgDetail.getInvestigation().getMinNormalValue()+" - "+dgDetail.getInvestigation().getMaxNormalValue()%></label>
	<input name="normalValue" type="hidden" size="8"	value="<%=dgDetail.getInvestigation().getMinNormalValue()+" - "+dgDetail.getInvestigation().getMaxNormalValue()%>"	readonly /> 
	<%}}else{ %> 
	<label>-</label>
	<input name="normalValue" type="hidden"	size="8" value="" readonly /> 
	<%} %>
	</td>
	<%} %>
	<td>
	<%if(dgDetail.getRemarks() != null){ %> 
	<input type="text"	value="<%=dgDetail.getRemarks() %>" onkeyup="chkLength(this,100);"	id="<%=ADDITIONAL_REMARKS_SINGLE_VALUE %>"	name="<%=ADDITIONAL_REMARKS_SINGLE_VALUE %>" /> 
	<%}else{ %>
	<input type="text"	value="" onkeyup="chkLength(this,100);"	id="<%=ADDITIONAL_REMARKS_SINGLE_VALUE %>"	name="<%=ADDITIONAL_REMARKS_SINGLE_VALUE %>" /> 
	<%} %>
	</td>
	<td width="4%">
	<% if(dgDetail.getValidated() != null) {%> 
	<input	id="checkIdSingleValue<%=indexForSingle%>"	name="checkIdSingleValue<%=indexForSingle%>" type="checkbox" class="check" /> 
	<%}else{ %> 
	<input	id="checkIdSingleValue<%=indexForSingle%>"	name="checkIdSingleValue<%=indexForSingle%>" type="checkbox" class="check" /> 
	<%} %>
	</td>

</tr>

<% 
 indexForSingle++;
}else if(dgDetail.getInvestigation().getInvestigationType().equals("t")){ %>
<tr>

		<td><%=index+1 %></td>
		<td>
		<%if(dgDetail.getInvestigation() !=null){ 
		              %> 
	<label name="<%=INVESTIGATION_NAME %>"><%=dgDetail.getInvestigation().getInvestigationName() %>	</label> 
	<%}else { %> 
	<label style="font-weight: bold;">-</label> 
	<%} %>
		</td>
		<td>
	<%if(dgDetail.getRemarks() != null){ %> 
	<input type="text"	value="<%=dgDetail.getRemarks() %>" onkeyup="chkLength(this,100);"	id="<%=ADDITIONAL_REMARKS_SINGLE_VALUE %>"	name="<%=ADDITIONAL_REMARKS_SINGLE_VALUE %>" /> 
	<%}else{ %>
	<input type="text"	value="" onkeyup="chkLength(this,100);"	id="<%=ADDITIONAL_REMARKS_SINGLE_VALUE %>"	name="<%=ADDITIONAL_REMARKS_SINGLE_VALUE %>" /> 
	<%} %>
	</td>
		<!--<td></td>
		--><td><input name="resultIdTemplate"	id="resultIdTemplate<%=index%>" type="hidden"	value="<%=dgDetail.getResultEntry().getId()%>" />
		 <input	type="button" class="cmnButton" style="width: auto;"	value="Click Here To Validate Result"	onclick="openTemplateScreen('<%=index%>');" align="right" />
		 </td><!--
		<td></td>

	--></tr>
	<%	
	
	}else if(dgDetail.getInvestigation().getInvestigationType().equals("m")){ 
		System.out.println("multiple validation");
	%>
	<jsp:include page="resultValidationTableForMultipleTestType.jsp" flush="true">
		<jsp:param name="resultEntryIndex" value="<%=index%>" />
		<jsp:param name="resultEntryIndexForMultiple"	value="<%=indexForMultiple%>" />
	</jsp:include>

	<%  
		indexForMultiple = indexForMultiple + dgResultEntryHeader2.getDgResultEntryDetails().size()+1;
	}
	}
		index++;
   	} %>
	
</table>
</div>

<div class="Clear"></div>
<input type="hidden" name="validatedCheckBoxCountSingle"	id="validatedCheckBoxCountSingle" value="<%=indexForSingle%>" /> 
<input	type="hidden" name="validatedCheckBoxCountMultiple"	id="validatedCheckBoxCountMultiple" value="<%=indexForMultiple%>" /> 
<input	type="hidden" name="resultIdStringForTemplate"	id="resultIdStringForTemplate" value="<%=resultId%>" /> 
<!-- Table Ends -->
<!--Bottom labels starts-->

<div class="Clear"></div>
<div class="division"></div>

<input type="button" class="button" value="Submit" id="submitButton"	onclick="if(inputValidate()){submitForm('sampleCollection','investigation?method=submitResultUpdationForAllInvestigationTypeLab')};" /> 
<input name="Button" type="button" class="button"	value="Reset" onclick="resetResult();" /> 
<input name="Button" type="button" class="button" value="Back" onclick="goBack();" />
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
<div class="clear paddingTop40"></div>
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
			alert('\''+obj.value + '\' is not Accepted in Result Column at row ' + mainCount + '.' + subCount+ '.\nOnly numeric value is allowed in Result.');
			return false;
		}
	}
	return true;
}

function submitAllExceptEnterForMultiple(myfield,e,url,inc,mainCount,subCount)
{
	var keycode;
	if (window.event)
		 keycode = window.event.keyCode;
	else if (e) 
		keycode = e.which;
	else 
		return true;
	if (keycode != 13) {
		var resultNumericOrStringForMultiple = document.getElementById('resultNumericOrStringForMultiple'+inc).value;
		if(resultNumericOrStringForMultiple != 'S'){
			if(checkForNumericResultMultiple(myfield,inc,mainCount,subCount)){
				return true;
			}else{
				document.getElementById('<%=RESULT%>'+inc).value = '';
				return false;
			}
		}
	}
}

function inputValidate(){

	var validatedCheckBoxCountSingle = document.getElementById('validatedCheckBoxCountSingle').value;
	var validatedCheckBoxCountMultiple = document.getElementById('validatedCheckBoxCountMultiple').value;
	if(validatedCheckBoxCountSingle > 0 || validatedCheckBoxCountMultiple > 0){
		for(var i = 0 ;i< validatedCheckBoxCountSingle ;i++){
			if(document.getElementById('checkIdSingleValue'+i+'').checked == true){
				return true;
			}
		}	
		
		for(var j = 0 ;j< validatedCheckBoxCountMultiple ;j++){
			if(document.getElementById('checkId'+j+'').checked == true){
				return true;
			}
		}	
		alert("Please validate atleast one result.")
		return false;
	}else{
		return true;
	}
}
	
function inputValue(){
		for(var i = 0; i < document.getElementsByName('validated').length; i++){
			if(document.getElementsByName('validated')[i].checked == true)
              {
				return true;
			  }		
  		}
  		alert("Please Validate The Result.")
		return false;
	}
function openTemplateScreen(index){

		var resultId = document.getElementById('resultIdTemplate'+index).value;
		var resultIdStringForTemplate = document.getElementById('resultIdStringForTemplate').value;
		if(document.getElementById('<%=RESULT_VALIDATED_BY %>'))
		var resultEnteredByForTemplate = document.getElementById('<%=RESULT_VALIDATED_BY %>').value;
		submitForm('sampleCollection','investigation?method=searchPatientForResultValidation&resultId='+resultId+'&flagForLab=fromLab&resultIdStringForTemplate='+resultIdStringForTemplate+'&resultEnteredByForTemplate='+resultEnteredByForTemplate+'');
	
	
}				
function openSensitiveScreen(index){
		var resultId = document.getElementById('resultIdSensitive'+index).value;
		var resultIdStringForTemplate = document.getElementById('resultIdStringForTemplate').value;
		var resultEnteredByForTemplate = document.getElementById('<%=RESULT_VALIDATED_BY %>').value;
		submitForm('sampleCollection','investigation?method=searchPatientForResultValidation&resultId='+resultId+'&flagForLab=fromLab&resultIdStringForTemplate='+resultIdStringForTemplate+'&resultEnteredByForTemplate='+resultEnteredByForTemplate+'');
}				


function resetResult(){
	  document.getElementById('result').value="";
	   document.getElementById('additionalRemarks').value="";
	   
   }
document.getElementById('addbutton').checked = true;
CheckAll(document.getElementById('addbutton'));
document.getElementById("submitButton").focus(); 
</script>