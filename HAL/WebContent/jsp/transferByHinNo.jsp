<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * transferByHinNo.jsp  
 * Purpose of the JSP -  This is for Transfer By HIN No.
 * @author  Ritu
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.9
--%>


<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.MasBed"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Transfer"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.Properties"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.UserEmpGroup"%>


<%@page import="jkt.hms.masters.business.AllergyDetail"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>

<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%><script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>

<script>
<%

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
<%
	
	String right = "n";
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	Map<String, Object> patientMap = new HashMap<String, Object>();
	
	List<Inpatient> inpatientList = new ArrayList<Inpatient>();
	List<Object[]> departmentList = new ArrayList<Object[]>();
	List<MasBed> bedList = new ArrayList<MasBed>();
	List<Transfer> transferNoList = new ArrayList<Transfer>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<UserEmpGroup> userRights = new ArrayList<UserEmpGroup>();
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTimeWithoutSc");
	
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	int bedStatusUnOccupiedId = Integer.parseInt(properties.getProperty("bedStatusUnOccupiedId"));
	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
	String departmentTypeCodeForWard = properties.getProperty("departmentTypeCodeForWard");


	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("patientMap") != null){
		patientMap = (Map<String,Object>)map.get("patientMap");
	}
	
	if(patientMap.get("inpatientList") != null){
		inpatientList = (List<Inpatient>)patientMap.get("inpatientList");
	}
	if(patientMap.get("userRights") != null){
		userRights = (List<UserEmpGroup>) patientMap.get("userRights"); 
	}
	if(userRights.size() > 0){
		right = "y";
	}
%>

<h6>Patient Transfer</h6>

<%
	try{
		String patientName ="";
		String consultantName = "";
	if(inpatientList != null && inpatientList.size() > 0){
		Inpatient inpatient = inpatientList.get(0);
		Patient patient = inpatient.getHin();
		
		String age = "";
		String currentAge = "";
	    if(patient.getAge()!=null)
			age = patient.getAge();
		try{
			if(!age.equals(""))
			currentAge = HMSUtil.calculateAgeForADT(age,patient.getRegDate());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		if(map.get("detailsMap") != null){
			detailsMap = (Map<String,Object>)map.get("detailsMap");
		}
		if(detailsMap.get("departmentList") != null){
			departmentList = (List<Object[]>)detailsMap.get("departmentList");
		}
		if(detailsMap.get("bedList") != null){
			bedList = (List<MasBed>)detailsMap.get("bedList");
		}
		if(detailsMap.get("transferNoList") != null){
			transferNoList = (List<Transfer>)detailsMap.get("transferNoList");
		}
		if(detailsMap.get("employeeList") != null){
			employeeList = (List<MasEmployee>)detailsMap.get("employeeList");
		}
		int transferNo = 0;
		if(transferNoList.size() > 0){
			for(Transfer transfer : transferNoList){
				transferNo = transfer.getTransferNo()+1;
			}
		}else{
			transferNo = 1;	
		}
		
		String adNo = "";
		int inpatientId = 0;
		String admissionDate = "";
		String admissionTime = "";
		
		inpatientId = inpatient.getId();
		adNo = inpatient.getAdNo();
		admissionDate = HMSUtil.changeDateToddMMyyyy(inpatient.getDateOfAddmission());
		admissionTime = inpatient.getTimeOfAddmission();
			
		patient = inpatientList.get(0).getHin();
		inpatient = inpatientList.get(0);
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
	%>

<form name="transferByHin" method="post">


<div class="Clear"></div>
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

<%-- <label>Branch/Trade</label>
<%
if(patient.getTrade() != null){
%> 
<label class="value"><%=  patient.getTrade().getTradeName()%></label>
<%} else{ %> 
<label class="value">-</label> 
<% }%> --%>


<%-- <label>Unit</label> <%
if(patient.getUnit() != null){
%> <label class="value"><%= patient.getUnit().getUnitName()%></label>
<%} else{ %> 
<label class="value">-</label> 
<% }%> --%>
<!-- <div class="Clear"></div> -->
<label>Age</label> <%if(!currentAge.equals("")){ %>
<label class="value"> <%=currentAge %></label> <%}else{ %>
<label	class="value">-</label> <%} %>
<label>Gender</label> <%if(patient.getSex() != null){ %>
<label class="value"> <%=patient.getSex().getAdministrativeSexName() %></label>
<%}else{ %>
<label class="value">-</label> <%} %>

<%-- <label>Med Cat</label>
<label class="value"><%=patient.getCategory()!=null?patient.getCategory().getCategories():"-" %></label>
 --%>

<div class="Clear"></div>

<label>Admitting Doctor</label>
<label class="value"><%=consultantName %></label>

<%-- <label>Allergies</label>
<%
String allergies = "";
	if(patient.getDrugAllergies()!=null){
/*	for(AllergyDetail allergyDetail : patient.getAllergyDetails()){
		if(!allergies.equals("")){
			allergies += ",";
		}
		allergies += allergyDetail.getDescription();
	}*/
		allergies = patient.getDrugAllergies();
}%>
<%
	if(!allergies.equals("")){
%>
<label class="valueAuto"><%=allergies %></label>
<%}else{ %>
<label class="value"></label>
<%} %> --%>
<!-- <div class="Clear"></div> -->

<label> Diagnosis</label> 
<%
List<DischargeIcdCode> diagnosisList = new ArrayList<DischargeIcdCode>();
if(patientMap.get("diagnosisList")!=null){
	diagnosisList = (List<DischargeIcdCode>)patientMap.get("diagnosisList");
	
}
if(diagnosisList != null && diagnosisList.size() > 0 && diagnosisList.get(0).getIcd()!=null)
{
%> <label class="valueFixedWidth"><%=diagnosisList.get(0).getIcd().getIcdName()%></label>
<%
		}else{
		%> <label class="value">-</label> <%	
		}
		%> 
<%-- <label>Disability</label>
<%
	List<MasMedicalExaminationDetail> disabilityList = new ArrayList<MasMedicalExaminationDetail>();
	if(patientMap.get("disabilityList")!=null){
		disabilityList = (List<MasMedicalExaminationDetail>)patientMap.get("disabilityList");
	}
	if(disabilityList != null && disabilityList.size() > 0)
	{
	%> <label class="valueFixedWidth"><%=disabilityList.get(0).getMasIcd()!=null?disabilityList.get(0).getMasIcd().getIcdName():"" %></label>
<%
	}else{
	%> <label class="value"></label> <%	
	}
%>  --%>

<div class="Clear"></div>

</div>


<div class="Clear"></div>
<h4>Transfer Schedule</h4>
<div class="Clear"></div>
<div class="Block">
<label>Adm Date</label> <label class="value"><%=admissionDate%></label>

<label>Adm Time</label> <label class="value"><%=admissionTime %></label>
<div class="Clear"></div>
<label>Transfer No.</label> 
<label class="value"><%=transferNo %></label> 
<label>Transfer Date</label> 
<input type="text" id="tdate" name="<%=TRANSFER_DATE %>" tabindex="1" value="<%=currentDate %>" class="date" readonly="readonly"
	validate="Transfer Date,date,no" MAXLENGTH="30" onblur="dateCheck();" /> 
<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender"
	onClick="setdate('',document.transferByHin.<%=TRANSFER_DATE%>,event)" />

<label>Transfer Time</label> 
<input type="text"	name="<%=TRANSFER_TIME%>" value="<%=currentTime%>">
<div class="Clear"></div>
</div>

<div class="Clear"></div>

<h4>Transfer Details</h4>
<div class="Clear"></div>
<div class="Block">
<label> From Ward</label> 
<input	type="text" name="fromWardName"	value="<%=inpatient.getDepartment().getDepartmentName() %>"	validate="List Time,String,no" readonly="readonly"/> 
<label> To Ward <span>*</span></label> 
<%-- <select name="<%=TO_WARD %>"	onchange="checkBedForTransfer();submitProtoAjaxWithDivName('transferByHin','/hms/hms/appointment?method=getDoctorList','doctorList');" id="wardId"	validate="To Ward,String,yes"> --%>
<select name="<%=TO_WARD %>"	onchange="if(document.getElementById('wardId').value!=0){checkBed();submitProtoAjaxWithDivName('transferByHin','/hms/hms/appointment?method=getDoctorList','doctorList');}" id="wardId"	validate="To Ward,String,yes">
	<option value="0">Select</option>
	<% 
	for(Object[] obj : departmentList){
					if(obj[2] != null){
						if(obj[2].equals(departmentTypeCodeForWard)){
			%>
	<option value="<%=obj[0]%>"><%=obj[1]%></option>
	<%			}
					}
			}%>
</select> 
<%-- <label> Authorized By <span>*</span></label> 
<select	name="<%=AUTHORIZER_ID %>" validate="Authorized By,String,yes">
	<option value="0">Select</option>
	<% 
		for (MasEmployee  obj : employeeList){
			if(obj.getEmpCategory() != null){
			if(obj.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
				String doctorMiddleName = "";
				String doctorLastName = "";
				String rankName ="";
				
				if(obj.getMiddleName() != null){
					doctorMiddleName = obj.getMiddleName();
				}
				if(obj.getLastName() != null){
					doctorLastName = obj.getLastName();
				}
				if(obj.getRank() != null){
					rankName = obj.getRank().getRankName();
				}
	%>
	<option value="<%=obj.getId ()%>"><%=rankName+" "+obj.getFirstName()+" "+doctorMiddleName+" "+doctorLastName%></option>
	<% } 
	 }
	}%>
</select> --%>

<div class="Clear"></div>
<label> From Bed No.</label> 
<label class="value"><%=inpatient.getBed().getBedNo() %></label>
<label> To Bed No.</label> 
<input type="text" id="bedNo" class="readOnly"	readonly="readonly" value="" />
<div class="Clear"></div>
<label> From Doctor</label> 
<input	type="text" name="fromDoctorName"	value='<%=inpatient.getDoctor().getFirstName()+" "+ (inpatient.getDoctor().getMiddleName()!=null?inpatient.getDoctor().getMiddleName() +" ":"") + (inpatient.getDoctor().getLastName()!=null?inpatient.getDoctor().getLastName():"") %>'	validate="List Time,String,no" readonly="readonly"/> 
<label> To Doctor <span>*</span></label> 
<div id ="doctorList">

<select name="<%=TO_DOCTOR %>"	id="doctorId"	validate="To Doctor,String,yes">
	<option value="0">Select</option>

</select> 
</div>
<div class="Clear"></div>
<label> Transfer Summary</label> 
<textarea id="transfer_reason" name="transfer_reason" class="large" onkeyup="auto_grow(this)" maxlength="5000"></textarea>


<div class="Clear"></div>
<div class="paddingTop15"></div>
<input type="button" name="Submit10" value="Save" class="button"
	onClick="checkValidation()" />
<input type="reset" name="Reset" value="Reset" class="button"
	accesskey="r" /> <input type="button" class="button" value="Back"
	align="right" onClick="submitFormForButton('transferByHin','ipd?method=showPatientListJsp');" />

</div>

<script type="text/javascript">
			<%
				int i = 0;
				for (Object[] object : departmentList) 
				{
					for (MasBed masBed : bedList) 
					{
						if(masBed.getBedStatus() != null){
							if(masBed.getBedStatus().getId().equals(bedStatusUnOccupiedId)){
								if(object[0].equals(masBed.getDepartment().getId())){
			%>
										bedArr[<%=i%>] = new Array();
										bedArr[<%=i%>][0] = <%=object[0]%>;
										bedArr[<%=i%>][1] = <%=masBed.getId()%>;									
										bedArr[<%=i%>][2] = "<%=masBed.getBedNo()%>";
	
			<%
									i++;
								}
							}
						}
					}
				}
			%>
		</script> <input type="hidden" name="<%=BED_ID %>" value="" id="bedId">

<input type="hidden" name="<%=TRANSFER_NO %>" value="<%=transferNo%>">
<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>">
<input type="hidden" name="inpatientId" value="<%=inpatientId %>" id=inpatientId>
<input type="hidden" name="<%=AD_NO %>" value="<%=adNo %>" id="adNo"> <input
	type="hidden" name="<%=AD_STATUS %>"
	value="<%=inpatient.getAdStatus() %>">
	 <input type="hidden"	id="fromWardId" name="<%=FROM_WARD %>" value="<%=inpatient.getDepartment().getId() %>">
	<input type="hidden"	id="fromDoctorId" name="<%=FROM_DOCTOR %>" value="<%=inpatient.getDoctor().getId() %>">
	
	 <input
	type="hidden" id="fromBedId" name="<%=FROM_BED %>"
	value="<%=inpatient.getBed().getId() %>"></div>



<div class="Clear"></div>
<div class="bottom"><!--<label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=currentDate%></label> <label>Changed Time:</label> <label
	class="value"><%=currentTime%></label> --><input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=currentTime%>" /></div>
	<input type="hidden" name="rights" id="rights" value="<%=right%>">
	<input type="hidden" name="<%=CHANGED_DATE %>" id="currentDate" value="<%=currentDate%>" />
<div class="Clear"></div>

<div id="edited"></div>
<%
		 }else{
		%>
<div class="Clear"></div>
<label class="noWidth"><span>Patient is Ready to
Discharge</span></label>
<div class="Clear"></div>

<%}
	}catch(Exception ee){
		ee.printStackTrace();
	}
		 %>
<div id="statusMessage" class="messagelabel"></div>

<script type="text/javascript">

function displayListDateTime(){
	var list = document.getElementById('listId').value;
	date = '<%=currentDate%>';
	time = '<%=currentTime%>';
	if(list != 0){
		document.getElementById('listdateId').value = date;
		document.getElementById('listtimeId').value = time;
	}else{
		document.getElementById('listdateId').value = "";
		document.getElementById('listtimeId').value = "";
	}
}


function dateCheck(){
    var disDate = document.getElementById('tdate')
    var curDate = document.getElementById('currentDate')
    var right   = document.getElementById('rights').value
    var disDate1   = new Date(disDate.value.substring(6),(disDate.value.substring(3,5) - 1) ,disDate.value.substring(0,2));
	var currdate = new Date(curDate.value.substring(6),(curDate.value.substring(3,5) - 1) ,curDate.value.substring(0,2));
	
	currdate.setDate(currdate.getDate() - 2);
	
	if(right == "n"){
	if(disDate1.value != "" && currdate.value != ""){
	 if(disDate1 < currdate){
	  alert("Transfer date should not be less than 2 day before today's date !");
	   document.getElementById('tdate').value ="";
	   return false;
	  }
	}else{
	 return false;
	}
	}else{
	return true;
	}
}


function jsSetBedId(bedId)
{
document.getElementById("bedId").value=bedId;
}

function checkValidation()
{
	var fromWard = parseInt(document.getElementById("fromWardId").value);
	var toWard = parseInt(document.getElementById("wardId").value);
	var fromBed = parseInt(document.getElementById("fromBedId").value);
	var toBed;
	var flag = true;
	
	if(fromWard == toWard)
		{
	
		if(document.getElementById("bedId").value.trim()=="")
		{
		toBed = parseInt(document.getElementById("fromBedId").value);
		}
	else
		{
		toBed = parseInt(document.getElementById("bedId").value);
	}
		
		}
	else
		{
		if(document.getElementById("bedId").value.trim()==="")
		{
			flag = false;
		alert("Please select the bed.");
		}
		}

	 
	var fromDoctor = parseInt(document.getElementById("fromDoctorId").value);
	var toDoctor = parseInt(document.getElementById("doctorId").value);
 	if(fromWard = toWard && fromBed == toBed && fromDoctor == toDoctor)
		{
		 alert("Patient is already under select ward, bed and doctor.");
		}
	else
		{
		if(flag)
			{
			submitForm('transferByHin','/hms/hms/adt?method=submitTransferInformation');
			}
	 	

		} 
	
	}
</script>

</form>
<div class="Clear"></div>

<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>
