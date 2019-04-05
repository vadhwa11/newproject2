<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : pendingSampleCollection.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author    Name: Dipali
	 * Revision Date:      Revision By: 
	 * @version 1.0  
--%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.DgCollectionCenter"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgMasCollection"%>
<%@page import="jkt.hms.masters.business.Users"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%@page import="java.net.URL"%>

<form name="sampleCollection" method="post" action="">
<%
    int pageNo=1;
	Map map = new HashMap();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	List<MasDepartment> collectionCenterListForSampleCollection = new ArrayList<MasDepartment>();
	List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
	List<DgMasCollection> conatinerList = new ArrayList<DgMasCollection>();
	List<DgCollectionCenter> collectionCenterList = new ArrayList<DgCollectionCenter>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
	List<Patient> patientList = new ArrayList<Patient>();
	DgOrderhd dgOrderhd= new DgOrderhd();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTimeWithoutSc");
	Box box = HMSUtil.getBox(request);
	String userName = "";
	int hinId= 0;
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	String empCategoryCodeForNursing = properties.getProperty("empCategoryCodeForNursing");
	String empCategoryCodeForParaMedical = properties.getProperty("empCategoryCodeForParaMedical");
	
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("dgOrderhdList") != null){
		dgOrderhdList=(List)map.get("dgOrderhdList");
	}
	if(map.get("collectionCenterList") != null){
		collectionCenterList=(List)map.get("collectionCenterList");
	}
	if(dgOrderhdList != null) {
		dgOrderhd = (DgOrderhd) dgOrderhdList.get(0);
			hinId =dgOrderhd.getHin().getId();
	}
	if(map.get("pageNo") != null){
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
	if(map.get("patientList") != null){
		patientList = (ArrayList)map.get("patientList");
	}
	if(map.get("collectionCenterListForSampleCollection") != null){
		collectionCenterListForSampleCollection = (ArrayList)map.get("collectionCenterListForSampleCollection");
	}
	if(map.get("conatinerList") != null){
		conatinerList = (ArrayList)map.get("conatinerList");
	}
	if(map.get("investigationList") != null){
		investigationList = (ArrayList)map.get("investigationList");
	}
	Set<DgOrderdt> dgOrderdtSet = new HashSet<DgOrderdt>();
	dgOrderdtSet = dgOrderhd.getDgOrderdts();
	Patient patient = new Patient();
    MasDepartment masDepartment=new MasDepartment();
    masDepartment = (MasDepartment) dgOrderhd.getDepartment();
	 String deptName="";
		if (map.get("deptName") != null) {
			deptName = (String) map.get("deptName");
		}
		int deptId =0;
		if(session.getAttribute("deptId") != null){
			deptId = (Integer)session.getAttribute("deptId");
		}
		List<String> prevRemarks = new ArrayList<String>();
		if (map.get("prevRemarks") != null) {
			prevRemarks = (List<String>) map.get("prevRemarks");
		}
		String remarks = "";
		if(prevRemarks.size() > 0){
			for(int i=0;i<prevRemarks.size();i++){
				if(prevRemarks.get(i)!=null && !prevRemarks.get(i).equals("")){
					remarks = prevRemarks.get(i);
				}
			}
		}
		
		String flag = "";
		if(map.get("flag")!=null){
			flag = (String)map.get("flag");
		}
		
		String deptType1 = "";
		if(map.get("deptType1")!=null){
			deptType1 = (String)map.get("deptType1");
		
		
		String dptType="";
							for(DgOrderdt dgOrderdt :dgOrderdtSet)
							{
							
								dptType=dgOrderdt.getMainChargecode().getDepartment().getDepartmentType().getDepartmentTypeCode();		
						
								
					
							}
		
		
		}

%> <!--main content placeholder starts here-->
<div class="titleBg">
<%if(deptType1.equalsIgnoreCase("EC") || deptType1.equalsIgnoreCase("Radio")){ %>
<h2>Acceptance For Investigation</h2>
<%}else{ %>
<h2>Sample Collection</h2>
<%} %>
</div>
<div class="Clear"></div>
<div class="Block">
<input type="hidden" name="deptType" value="<%=deptType1 %>">
<label>Req Date</label>
<label	class="valueMedium"><%=HMSUtil.changeDateToddMMyyyy(dgOrderhd.getOrderDate())%></label>
<label class="medium">Req Time</label> <label class="valueMedium"><%=dgOrderhd.getOrderTime()%></label>
<label class="medium">Req No.</label> <label class="valueMedium"><%=dgOrderhd.getOrderNo()%></label>
<label class="">Department</label> <label class="value"><%=dgOrderhd.getDepartment().getDepartmentName()%></label>
</div>
<div class="Clear"></div>
<!--Block Two Starts-->
<h4>Patient Details</h4>
<div class="Block">

<label>Employee No.</label>
<%
		if(dgOrderhd.getHin().getServiceNo() != null && !(dgOrderhd.getHin().getServiceNo().equals(""))){
%> 
<label class="value"><%= dgOrderhd.getHin().getServiceNo()%></label>
<%}else{ %> 
<label class="value">-</label>
 <%}%>

<%
	String middleName = "";
	String lastName = "";
	if(dgOrderhd.getHin().getPMiddleName() != null){
		middleName = dgOrderhd.getHin().getPMiddleName();
	}
	if(dgOrderhd.getHin().getPLastName() != null){
		lastName = dgOrderhd.getHin().getPLastName();
	}
%> 

<label>Patient Name</label> 
<label class="value"><%= dgOrderhd.getHin().getPFirstName()+" "+middleName+" "+lastName%></label>


<label>Relation</label> 
<%
	if(dgOrderhd.getHin().getRelation() != null){
%> 
<label class="value"><%= dgOrderhd.getHin().getRelation().getRelationName()%></label>
<%}else{ %> 
<label class="value">-</label> 
<% }%>
	<div class="Clear"></div>
<label>Designation</label> <%
			if(dgOrderhd.getHin().getRank() != null){
			%> <label class="value"><%= dgOrderhd.getHin().getRank().getRankName()%></label>
<%} else{ %> <label class="value">-</label> <% }%>

<label>Name</label> <%
				if(dgOrderhd.getHin().getSFirstName() != null  && !(dgOrderhd.getHin().getSFirstName().equals(""))){
				
					String sMiddleName = "";
					String sLastName = "";
					if(dgOrderhd.getHin().getSMiddleName() != null){
						sMiddleName = dgOrderhd.getHin().getSMiddleName();
					}
					if(dgOrderhd.getHin().getSLastName() != null){
						sLastName = dgOrderhd.getHin().getSLastName();
					}
			 %> <label class="value"><%= dgOrderhd.getHin().getSFirstName()+" "+sMiddleName+" "+sLastName%></label>
<%}else{ %> <label class="value">-</label> <% }%>

 
<%
		
	    
	    
	       int PatientAge=0;
					
			if(dgOrderhd.getHin().getDateOfBirth() != null)
			{
				Date date_of_birth= dgOrderhd.getHin().getDateOfBirth();		
				
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

<label>Gender</label> <label class="value"><%=dgOrderhd.getHin().getSex().getAdministrativeSexName() %></label>

		<div class="Clear"></div>
		


<div class="Clear"></div>

<div>
<%if( dgOrderhd.getInpatient() != null){%> <input type="hidden"
	name="<%=INPATIENT_ID %>"
	value="<%= dgOrderhd.getInpatient().getId()%>" /> <%} %> <%if(dgOrderhd.getVisit()!=null){ %>
<input type="hidden" name="<%=VISIT_ID%>"
	value="<%= dgOrderhd.getVisit().getId()%>" /> <%} %>  <input type="hidden"
	name="sessDeptId" value="<%=deptId %>" />  <input type="hidden"
	name="<%=HIN_ID %>" value="<%=dgOrderhd.getHin().getId() %>" />
	 <input
	type="hidden" name="<%=ORDER_BOOKING_ID %>"
	value="<%=dgOrderhd.getId()%>" /></div>
</div>
<!--Block Two Ends-->
<div class="clear"></div>
<!-- Block Three Starts -->
<%if(deptType1.equalsIgnoreCase("EC") || deptType1.equalsIgnoreCase("Radio")){ %>
<h4>Investigation Details</h4>
<%}else{ %>
<h4>Sample Details</h4>
<%} %>
<div class="Block">
<%
	 String diagSeqNo="";
		if(map.get("diagSeqNo") != null){
			diagSeqNo = (String)map.get("diagSeqNo");
		}
	%> 
	<label>Date</label> 
	<label class="value"><%=date%></label> 
<label>Time</label> 
<label class="value"><%=time%></label>

<label> Accepted By <span>*</span></label> 
<% 
		Users user = (Users)session.getAttribute("users");
		Integer empId =user.getEmployee().getId();
%>	

<label class="value"><%=user.getEmployee().getFirstName()%></label>
<input type="hidden" name="<%=EMPLOYEE_ID %>" id="collectedBy" value="<%=empId %>"/>

<input type="hidden" name="departmentId" id="departmentId" value="<%=dgOrderhd.getDepartment().getId() %>"/>

<%--<select id="collectedBy" name="<%=EMPLOYEE_ID %>"	validate="Collected By,string,yes">
	<option value="0">Select</option>
	<% 
		Users user = (Users)session.getAttribute("users");
		Integer empId =user.getEmployee().getId();
		for (MasEmployee  obj : employeeList){
			
		String nurseMiddleName = "";
		String nurseLastName = "";
		if(obj.getMiddleName()!=null){
			nurseMiddleName = obj.getMiddleName();			
		}
		if(obj.getLastName()!=null){
			nurseLastName = obj.getLastName();			
		}
	   if(empId.equals(obj.getId())){
%>
	<option value="<%=obj.getId()%>" selected="selected"><%=obj.getFirstName()+" "+nurseMiddleName+" "+nurseLastName%></option>
	<%  } else {%>
	<option value="<%=obj.getId()%>"><%=obj.getFirstName()+" "+nurseMiddleName+" "+nurseLastName%></option>
	<%	} 
		}%>
</select>  --%>
<%--<label> Room <span>*</span></label> 
<select	name="<%= COLLECTION_CENTER_ID %>"	validate="Collection Center,string,yes" tabindex="1">
	<option value="0">Select</option>
	<% 
	   if(collectionCenterList.size() > 0){ 	
		for (DgCollectionCenter  dgCollectionCenter : collectionCenterList){
					%>
	<option value="<%=dgCollectionCenter.getId ()%>" selected="selected"><%=dgCollectionCenter.getCollectionCenterName()%></option>
	<%}
				  } %>
--%>
	<div class="Clear"></div><label>Diagnostic No.</label>
<label class="value"><%=diagSeqNo%></label>
<input type="hidden" name="diagnosticNo" value="<%=diagSeqNo%>">
	<div class="Clear"></div>
<label> Clinical Notes</label> 
<% if(dgOrderhd.getClinicalNote() != null){ %>
<label class="valueLarge"><%=dgOrderhd.getClinicalNote()%></label> 
<%}else{ %>
<label class="valueLarge">-</label> 
<%} %>
<div class="Clear"></div>
<input type="hidden" value="0" name="pagecounter2" /> <input
	type="hidden" name="pageNo" id="pageNo" value="<%=pageNo%>" />
	</div>
<!-- Block Three Ends -->
<div class="Clear"></div>
<!-- Table Starts -->
<table border="0" cellspacing="0" cellpadding="0">

	<tr>
		<th scope="col">Sl No.</th>
		<th scope="col">Investigation </th>
		<%if(deptType1.equalsIgnoreCase("EC") || deptType1.equalsIgnoreCase("Radio")){ %>
		<%}else{ %>
		<th scope="col">Sample</th>
		<th scope="col">Container</th>
		<%} %>
		<th scope="col">
		<input type="checkbox" name="checkall" class="radioCheck"	value="Collected All" id="addbutton" onclick="CheckAll(this);"	/> 
		<%if(deptType1.equalsIgnoreCase("EC") || deptType1.equalsIgnoreCase("Radio")){ %>
		Accepted
		<%}else{ %>
		
		Collected
		<%} %> 
		
		</th>
		
		<th scope="col">
		<input type="checkbox" name="checkallEmpanelled" class="radioCheck"	value="Empanelled All" id="addbutton" onclick="CheckAllEmpanelled(this);"	/> 
		<%if(deptType1.equalsIgnoreCase("EC") || deptType1.equalsIgnoreCase("Radio")){ %>
		Accepted
		<%}else{ %>
		
		Empanelled
		<%} %> 
		
		</th>
		<th scope="col">Remarks</th>
		<th scope="col">Appointment</th>
	</tr>

	<%
int detailCounter=8; 
int temp=1;
int inc = 0;    	
if(pageNo!=1)
{
temp=detailCounter*(pageNo-1);
} 
%>
	<%	
	
					for(DgOrderdt dgOrderdt :dgOrderdtSet){
				//		if((dgOrderdt.getCreatedon()!=null && dgOrderdt.getCreatedon().compareTo(HMSUtil.convertStringTypeDateToDateType(date)) ==0) || (dgOrderdt.getAppointmentDate()!=null && dgOrderdt.getAppointmentDate().compareTo(HMSUtil.convertStringTypeDateToDateType(date)) == 0)){
							if((dgOrderdt.getCreatedon()!=null ) || (dgOrderdt.getAppointmentDate()!=null && dgOrderdt.getAppointmentDate().compareTo(HMSUtil.convertStringTypeDateToDateType(date)) == 0)){
						
						/*if(dgOrderdt.getMainChargecode().getDepartment().getDepartmentType().getDepartmentTypeCode().equalsIgnoreCase("DIAG") 
								&& dgOrderdt.getOrderStatus().equalsIgnoreCase("p") && !dgOrderdt.getInvestigationToMH().equalsIgnoreCase("y"))
						*/
						
						
						if(dgOrderdt.getMainChargecode().getDepartment().getDepartmentType().getDepartmentTypeCode().equalsIgnoreCase(deptType1) 
								&& dgOrderdt.getOrderStatus().equalsIgnoreCase("p") && dgOrderdt.getBillingStatus().equalsIgnoreCase("y"))
											{
							
							int investigationId = 0;
							DgMasInvestigation dgMasInvestigationActive = null;
							 if(investigationList != null){
							 	for (DgMasInvestigation  dgMasInvestigation : investigationList){
							 									 		if((dgMasInvestigation.getChargeCode().getId()!=null)&& (dgOrderdt.getChargeCode().getId()!=null)){
				            			if(dgOrderdt.getChargeCode().getId() == dgMasInvestigation.getChargeCode().getId()){
											investigationId = dgMasInvestigation.getId();
											dgMasInvestigationActive = dgMasInvestigation;
							 				break;
						    			}else{
						    				investigationId =0;
										} 
									}
				            	}
							}

					
				%>
	<tr>
	
		<td width="5%"><input type="text" size="2" value="<%=temp+inc%>" name="<%=SR_NO%>" readonly="readonly" />
		
		<input type="hidden" name="<%=CHARGE_CODE_ID%>"	id="chargeCodeId<%=inc %>"	value="<%=dgOrderdt.getChargeCode().getId() %>" />
		<input type="hidden" name="mainCharge" id="mainChargeId<%=inc %>"	value="<%=dgOrderdt.getMainChargecode().getId() %>" />
		<input type="hidden" name="mainChargeName" id="mainChargeNameId<%=inc %>"	value="<%=dgOrderdt.getMainChargecode().getMainChargecodeName() %>" />
		<input type="hidden" name="subCharge" id="subChargeId<%=inc %>" 	value="<%=dgOrderdt.getSubChargeid().getId() %>" /></td>
		<td>
		<%if(dgOrderdt.getChargeCode() !=null){ 
		%> 
		<label><%=dgOrderdt.getChargeCode().getChargeCodeName() %></label>
		<input name="chargename"	type="hidden" size="15" value="<%=dgOrderdt.getChargeCode().getChargeCodeName() %>" readonly />
		<%}else { 
		%> 
		<label>-</label>
		<input name="chargename" type="hidden" size="2" value=""
			readonly /> <%} %>
		</td>
<%if(deptType1.equalsIgnoreCase("EC") || deptType1.equalsIgnoreCase("Radio")){ %>



<% if(dgMasInvestigationActive != null && dgMasInvestigationActive.getSample()!=null ){
		%>
		
		<input name="<%= SAMPLE_NAME+inc %>" type="hidden" size="5"
			value="<%=dgMasInvestigationActive.getSample().getSampleDescription() %>"
			readonly /> <%}else {%> 
			<label>-</label>
			<input name="<%= SAMPLE_NAME+inc %>" type="hidden"
			size="5" value="" readonly="readonly" /> <%}%>
		
		<% 
		if(dgMasInvestigationActive != null && dgMasInvestigationActive.getSample()!=null){
		%>
		<input type="hidden" name="<%=SAMPLE_ID+inc%>" id="sampleId<%=inc %>"
			value="<%=dgMasInvestigationActive.getSample().getId() %>" readonly />
		<%}else {%>
		<input type="hidden" name="<%=SAMPLE_ID+inc%>" id="sampleId<%=inc %>"
			value="" readonly="readonly" />
		<%}%>
		<%
		if(conatinerList.size()>0)
		{
		%>
		<input type="hidden" name=<%=CONTAINER %> id='containerId<%=inc%>' value="<%=conatinerList.get(0).getId()%>">
			
			
			
			<%} %>
		 <script type="text/javascript">
	 <%if(dgMasInvestigationActive != null && dgMasInvestigationActive.getContainer()!=null){%>
     	document.getElementById('containerId<%=inc%>').value='<%=dgMasInvestigationActive.getContainer().getId()%>';
     <%} %>
   	</script>
<%}else{ %>
		<td>
		<% if(dgMasInvestigationActive != null && dgMasInvestigationActive.getSample()!=null ){
		%>
		<label><%=dgMasInvestigationActive.getSample().getSampleDescription() %></label>
		<input name="<%= SAMPLE_NAME+inc %>" type="hidden" size="5"
			value="<%=dgMasInvestigationActive.getSample().getSampleDescription() %>"
			readonly /> <%}else {%> 
			<label>-</label>
			<input name="<%= SAMPLE_NAME+inc %>" type="hidden"
			size="5" value="" readonly="readonly" /> <%}%>
		
		<% 
		if(dgMasInvestigationActive != null && dgMasInvestigationActive.getSample()!=null){
		%>
		<input type="hidden" name="<%=SAMPLE_ID+inc%>" id="sampleId<%=inc %>"
			value="<%=dgMasInvestigationActive.getSample().getId() %>" readonly />
		<%}else {%>
		<input type="hidden" name="<%=SAMPLE_ID+inc%>" id="sampleId<%=inc %>"
			value="" readonly="readonly" />
		<%}%>
</td>
		<td><select name=<%=CONTAINER %> id='containerId<%=inc%>'>
			<option value="">Select</option>
			<%
			for(DgMasCollection dgMasCollection : conatinerList){ %>
			<option value="<%=dgMasCollection.getId() %>"><%=dgMasCollection.getCollectionName() %></option>
			<%} %>
		</select> <script type="text/javascript">
	 <%if(dgMasInvestigationActive != null && dgMasInvestigationActive.getContainer()!=null){%>
     	document.getElementById('containerId<%=inc%>').value='<%=dgMasInvestigationActive.getContainer().getId()%>';
     <%} %>
   	</script></td>
   	
   	<%} %>
   		<td><input id="checkId<%=inc%>" name="<%=COLLECTED%><%=inc%>" type="checkbox" value="y" class="check" onclick="disableAppCheck(this,<%=inc %>)"/>
		 <input type="hidden" name="orderDtId" id="orderDtId<%=inc %>"	value=<%= dgOrderdt.getId()%> /></td>
		 <td><input id="checkIdEmpanelled<%=inc%>" name="<%=Empanelled %><%=inc%>" type="checkbox" value="y" class="check" onclick="disableAppCheck(this,<%=inc %>)"/>
<%-- 		 <input type="hidden" name="orderDtId" id="orderDtId<%=inc %>"	value=<%= dgOrderdt.getId()%> /></td> --%>
		 <!--
   	
		<td> 	<select name=<%=QUANTITY %>>    	<option value="">Select</option> 
		<% if(dgMasInvestigationActive != null && dgMasInvestigationActive.getQuantity()!=null){%>
		<input type="text" name="<%=QUANTITY+inc %>" id="<%=QUANTITY%><%=inc%>"
			value="<%=dgMasInvestigationActive.getQuantity()%>" size="9"
			MAXLENGTH="10" tabindex=1 /> <%}else{ %> <input type="text"
			name="<%=QUANTITY+inc %>" value="" size="9" MAXLENGTH="10" tabindex=1 />
		<%} %>  </select> </td>

		-->
		
		<td><input type="hidden"
			name="<%=QUANTITY+inc %>" value="1" size="9" MAXLENGTH="10" tabindex=1 />
			<input type="text" name="<%=REMARKS+inc%>"
			id="remarksId<%=inc %>" value="<%=remarks %>" />
		<input type="hidden" name="<%=INVESTIGATION_ID%>"
			id="investigationId<%=inc %>" value="<%=investigationId%>" /></td>

		<td><input type="checkbox" name="appointment<%=inc %>" id="appointment<%=inc %>" onclick="displayDate(this,<%=inc %>);" class="radio"/>
		<input type="text" name="appointmentDate<%=inc %>" id="appointmentDate<%=inc %>" style="display: none;" size="12"/>
		<img id="calendar<%=inc %>" src="/hms/jsp/images/cal.gif" width="16" height="16" style="display: none;"	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.getElementById('appointmentDate<%=inc %>'),event)" />
		
		</td>
	</tr>

	<% inc++;
						}
	}
 } %>
</table>

<!-- Table Ends -->
<div class="clear"></div>
<div class="division"></div>
<input type="hidden" name="counter" id="counter" value=<%=inc %>>
<input type="button" id = "submitButton" class="button" value="Submit" name="Submit11"
	onclick="if(validateCollected())submitForm('sampleCollection','lab?method=submitSampleCollection');"
	align="right" /> <input type="reset" class="button" name="Reset"
	id="reset" value="Reset"
	onclick="resetClicked('sampleCollection',<%=inc %>);" accesskey="r" />

<div class="clear"></div>
<div class="division"></div>

<!--Bottom labels starts-->
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label>


</div>
<div class="clear paddingTop40"></div>
<!--Bottom labels starts--> <!--main content placeholder ends here-->
</form>
<!---------------Java Scripts Related to Sample Collection------------------------------>
<script type="text/javascript">

function validateCollected(){
var msg="";
	flag = true;
		counter = document.getElementById('counter').value;
		
		for(var i = 0; i < counter; i++){
			
			if((document.getElementById('checkId'+i).checked) ||(document.getElementById('checkIdEmpanelled'+i).checked))
            { 
            	flag = false;
            	break;
     		}
		
			
  		}
		for(var i = 0; i < counter; i++){
			
			if(document.getElementById('appointment'+i).checked) 
            { 
            	flag = false;
            	break;
     		}
		}
  		if(flag == false)
  		{	
			return true;
		}
		else{
			alert("Please either Collect atleast one Test OR Click on Empanelled....");
			return false;
		}
				
  		 if(msg != ""){
			 	alert(msg);
			 	return false;
		}
		return true;
		
	}
	</script>
<script type="text/javascript">
   history.forward();
</script>
<script type="text/javascript">
function CheckAll(chk)
{
	var cnt = document.getElementById('counter').value;
	for (var i=0;i < cnt;i++){
		document.getElementById('checkId'+i).checked = chk.checked;
		if(document.getElementById('checkId'+i).checked ){
			document.getElementById('appointment'+i).checked=false;
			document.getElementById('appointmentDate'+i).style.display='none';
			document.getElementById('calendar'+i).style.display='none';
			document.getElementById('appointmentDate'+i).value="";
		}
	}
	
}

function CheckAllEmpanelled(chk)
{
	var cnt = document.getElementById('counter').value;
	for (var i=0;i < cnt;i++){
		document.getElementById('checkIdEmpanelled'+i).checked = chk.checked;
		if(document.getElementById('checkIdEmpanelled'+i).checked ){
			document.getElementById('appointment'+i).checked=false;
			document.getElementById('appointmentDate'+i).style.display='none';
			document.getElementById('calendar'+i).style.display='none';
			document.getElementById('appointmentDate'+i).value="";
		}
	}
	
}



  
function checkFilledRow(){
   var msg ="";
	 if(document.getElementById('noOfRecords').value==0 || document.getElementById('noOfRecords').value ==""){
	  	alert("Please fill atleast one row to submit.");
	  	return false;
	  }else{
	  	var msg ="";
	  	var count = document.getElementById('noOfRecords').value;
	  	for(var i=1;i<=count;i++){
	  	 	if(document.getElementById('chargeCode'+i).value != ""){
	  			if(document.getElementById('qty'+i).value == ""){
	  				msg += "Quantity can not be blank.\n";
	  			}
	  			
	  			if(msg != ""){
	  				break;
	  			}
	  		
	  			}
	  		}
	  	if(msg != ""){
	  			alert(msg)
	  			return false;
	  		}else
	  			return true;
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
<script>
function displayDate(obj,cnt){
	if(obj.checked){
		document.getElementById('appointmentDate'+cnt).style.display='block';
		document.getElementById('calendar'+cnt).style.display='block';
		document.getElementById('checkId'+cnt).checked=false;
	}else{
		document.getElementById('appointmentDate'+cnt).style.display='none';
		document.getElementById('calendar'+cnt).style.display='none';
		document.getElementById('appointmentDate'+i).value="";
	}
	
}
function disableAppCheck(obj,cnt){
	if(obj.checked){
		document.getElementById('appointmentDate'+cnt).style.display='none';
		document.getElementById('calendar'+cnt).style.display='none';
		document.getElementById('appointmentDate'+i).value="";
		document.getElementById('appointment'+cnt).checked=false;
	}else{
		document.getElementById('appointmentDate'+cnt).style.display='none';
		document.getElementById('calendar'+cnt).style.display='none';
		document.getElementById('appointmentDate'+i).value="";
	}
}
document.getElementById('addbutton').checked = true;
CheckAll(document.getElementById('addbutton'));
document.getElementById("submitButton").focus();  	

</script>


