<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * attach_admission.jsp  
 * Purpose of the JSP -  This is for admission.
 * @author  Deepti Tevatia
 * Create Date: 21st Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.13  
--%>

<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="jkt.hms.masters.business.AttachInpatient"%>
<%@page import="jkt.hms.masters.business.MasBed"%>
<%@page import="java.util.Properties"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.HashSet"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="java.util.StringTokenizer"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/prototype.js"></script>
	<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
	
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
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
<div id="contentspace">
<form name="attach" method="post">
<body onload="checkBed();">
<%

int bedId = 0;
String adNo ="";
Map<String, Object> map = new HashMap<String, Object>();
Map<String,Object> patientMap = new HashMap<String,Object>();
Map<String, Object> detailsMap = new HashMap<String, Object>();
Map<String,Object> attachMap = new HashMap<String,Object>();
Map<String,Object> utilMap = new HashMap<String,Object>();

List<MasRelation> relationList = new ArrayList<MasRelation>();
List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
List<Patient> patientList = new ArrayList<Patient>();
List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
List<Patient> hinList = new ArrayList<Patient>();
List<MasBed> bedList = new ArrayList<MasBed>();
List<Inpatient> existenceAttachedList = new ArrayList<Inpatient>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");  
String currentTime = (String)utilMap.get("currentTime");
String message="";
String fathereExists ="n";
String motherExists ="n";
String serviceNo ="";
Properties properties = new Properties();
URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
try {
	properties.load(resourcePath.openStream());
} catch (Exception e) {
	e.printStackTrace();
}
int bedStatusUnOccupiedId = Integer.parseInt(properties.getProperty("bedStatusUnOccupiedId"));
int relationIdForFather = Integer.parseInt(properties.getProperty("relationIdForFather"));
int relationIdForMother = Integer.parseInt(properties.getProperty("relationIdForMother"));
List<Inpatient> inpatientList =new ArrayList<Inpatient>();
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("patientMap") != null){
	patientMap = (Map<String,Object>)map.get("patientMap");
}
if(map.get("adNo") != null){
	adNo = ""+map.get("adNo");
}
if(map.get("serviceNo") != null){
	serviceNo = ""+map.get("serviceNo");
}
if(map.get("inpatientList") != null){
	inpatientList = (List<Inpatient>)map.get("inpatientList");
}
Inpatient inpatient =null;
try{
	if(inpatientList.size()>0)
inpatient = inpatientList.get(0);
if(map.get("message") != null){
	message = (String)map.get("message");
}
if(map.get("attachMap") != null){
	attachMap = (Map<String,Object>)map.get("attachMap");
}
if(attachMap.get("hinList") != null){
	hinList = (List<Patient>)attachMap.get("hinList");
}
if(attachMap.get("existenceAttachedList") != null){
	existenceAttachedList = (List<Inpatient>)attachMap.get("existenceAttachedList");
}
if(patientMap.get("patientList") != null){
	patientList = (List<Patient>)patientMap.get("patientList");
}
}catch(Exception e){
	e.printStackTrace();
}
Patient patient =null;
if(patientList.size() > 0){
	
 try{
	 System.out.println("patientList In JSP "+patientList.size());
	 patient = patientList.get(0);
	
	if(map.get("detailsMap") != null){
		detailsMap = (Map<String, Object>)map.get("detailsMap");
	}
	if(detailsMap.get("relationList") != null){
		relationList = (List<MasRelation>)detailsMap.get("relationList");
	}
	if(detailsMap.get("sexList") != null){
		sexList = (List<MasAdministrativeSex>)detailsMap.get("sexList");
	}
	if(detailsMap.get("departmentList") != null){
		departmentList = (List<MasDepartment>)detailsMap.get("departmentList");
	}
	if(detailsMap.get("bedList") != null){
		bedList = (List<MasBed>)detailsMap.get("bedList");
	}
 }catch(Exception ee ){
	 ee.printStackTrace();
 }
 
%>
<h2><font id="error"><%=message %></font></h2>
<input type="button" name="yes" value="Print" class="button"
	onclick="submitForm('attach','/hms/hms/adt?method=showIPAdmissionReport&adNo=<%=adNo %>','checkTargetForYes');" />

<%

 
if(existenceAttachedList.size() > 0){
%>


<div
	style="width: 15px; height: 20px; BORDER-bottom: #3c8ad7 1px solid; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 250px; height: 20px; float: left;">
<font class="boxtitle">Already Attached Admission</font></div>

<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: auto; background-color: #f4f9fe;">



<div style="height: auto; width: auto;"><br />

<%try{
		for (Iterator<Inpatient> iterator2 = existenceAttachedList.iterator(); iterator2.hasNext();) {
			Inpatient inpatient2 = (Inpatient) iterator2.next();
%> <label class="bodytextB">Name:</label> <span class="wardspan"><%= inpatient2.getHin().getPFirstName()+" "+inpatient2.getHin().getPMiddleName()+" "+inpatient2.getHin().getPLastName()%></span>

<label class="bodytextB">Age:</label> <%
		if(inpatient2.getAge() != null){
		%> <span class="wardspan"><%= inpatient2.getAge()%></span> <%} %> <label
	class="bodytextB">Sex:</label> <%
		if(inpatient2.getHin().getSex() != null){
		%> <span class="wardspan"><%=inpatient2.getHin().getSex().getAdministrativeSexName()%></span>
<%} %> <label class="bodytextB">Relation:</label> <%
		if(inpatient2.getHin().getRelation() != null){
			
			if(inpatient2.getHin().getRelation().getId()==relationIdForMother ){
				motherExists="y";
			}
			if(inpatient2.getHin().getRelation().getId()==relationIdForFather ){
				fathereExists="y";
			}
		%> <span class="wardspan"><%= inpatient2.getHin().getRelation().getRelationName() %></span>
<%} %> <br />
<%		}}catch(Exception e){
	e.printStackTrace();
}%>
</div>
</div>
<%
	
}
%>




<br />


<div
	style="width: 15px; height: 20px; BORDER-bottom: #3c8ad7 1px solid; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 250px; height: 20px; float: left;">
<font class="boxtitle">New Attached Admission</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 95%; height: 140px; background-color: #f4f9fe;">



<div style="height: 100%; width: auto;"><br />

<label class="bodytextB"><font id="error">*</font>Name:</label> <input
	type="text" name="<%=NAME_OF_ATTACH %>" class="textbox_size20"
	validate="Name,String,no" MAXLENGTH="30" id="forName" /> <%Integer hours =0;
		StringTokenizer s = new StringTokenizer(currentTime,":");  
		if(s.hasMoreTokens())
			hours=Integer.parseInt(""+s.nextToken()) ;
	%> <label class="bodytextB"><font id="error">*</font>Age:</label> <input
	type="text" name="<%=AGE %>" class="textbox_size20"
	style="width: 60px;" validate="Age,int,no" maxlength="2" id="forAge"
	onblur="calculateDiet('<%=hours%>');" /> <select id="ageUnitId"
	name="<%=AGE_UNIT %>" validate="AgeUnit,string,no" tabindex="1"
	style="width: 60px;" id="ageUnitId"
	onblur="calculateDiet('<%=hours%>');">
	<option selected="selected" value="Years">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select> <label class="bodytextB"><font id="error">*</font>Sex:</label> <select
	name="<%=SEX_ID %>" validate="Sex,String,no" style="width: 120px;"
	id="forSex">
	<option value="0">Select</option>
	<% 
		for (MasAdministrativeSex  obj : sexList){
	%>
	<option value="<%=obj.getId ()%>"><%=obj.getAdministrativeSexName()%></option>
	<% }%>
</select> <br />
<label class="bodytextB"><font id="error">*</font>Veg/Non-Veg:</label> <select
	name="<%=DIET_TYPE%>" validate="Veg/Non-Veg,String,Yes" id="veg"
	style="width: 90px;">
	<option value="0">Select</option>
	<option value="Veg">Veg</option>
	<option value="Non-Veg">Non-Veg</option>
</select> <label class="bodytextB"><font id="error">*</font>Diet: </label> <select
	name="<%=DIET_ID%>" validate="Diet,String,Yes" id="diet"
	style="width: 90px;">
	<option value="0">Select</option>
</select> <label class="bodytextB"><font id="error">*</font> Relation:</label> <select
	name="<%=RELATION_ID %>" validate="Relation,String,Ye"
	style="width: 120px;" id="rel"
	onchange="checkForDuplicateOfAdnoInAttach();">
	<option value="0">Select</option>
	<% 
	for (MasRelation  obj : relationList){
	%>
	<option value="<%=obj.getId ()%>"><%=obj.getRelationName()%></option>
	<% }%>
</select> <br />

<label class="bodytextB"><font id="error">*</font>Ward:</label> <select
	name="<%=DEPARTMENT_ID %>" style="width: 90px;" onchange="checkBed();"
	id="wardId">
	<option value="0">Select</option>
	<% 
			for (MasDepartment  masDepartment : departmentList){
				if(inpatient.getDepartment().getId() ==masDepartment.getId()){
		%>
	<option value="<%=masDepartment.getId ()%>" selected="selected"><%=masDepartment.getDepartmentName()%></option>
	<%}else{ %>
	<option value="<%=masDepartment.getId ()%>"><%=masDepartment.getDepartmentName()%></option>
	<%}}%>
</select> <label class="bodytextB"><font id="error">*</font>Admin Date: </label>
<input type="text" name="<%=CHANGED_DATE%>" value="<%=currentDate %>"
	class="textbox_date" readonly="readonly" validate="Visit Date,date,yes"
	MAXLENGTH="30" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onClick="setdate('',document.attach.<%=CHANGED_DATE%>,event)" /> <label
	class="bodytextB"><font id="error">*</font>Admin Time: </label> <input
	type="text" id="attachTimeId" name="<%=CHANGED_TIME %>"
	value="<%=currentTime %>" class="textbox_size20" style="width: 120px;"
	validate="Visit Time,String,yes"
	onchange="IsValidTime(this.value,this.id);" /> <label class="bodytextB"><font
	id="error">*</font>Attached As: </label> <select name="<%=AT_OR_DT%>"
	style="width: 90px;" id="attachedAs">
	<option value="0">Select</option>
	<option value="Sick Attendent">Sick Attendent</option>
	<option value="Sick Dependent">Sick Dependent</option>
	<option value="Sick Dependent">dependent to attendent</option>

</select> <input type="hidden" name="<%=SERVICE_TYPE_CODE%>"
	value="<%=patient.getServiceType().getServiceTypeCode() %>"> <br />
<label class="bodytextB"><font id="error"> </font>HSR Receipt
No:</label> <input type="text" name="<%=HSR_RECEIPT_NO %>"
	validate="HSR Receipt No,string,no" maxlength="12"
	style="width: 135px;" class="textbox_size20" value=""> <label
	class="bodytextB"><font id="error"> </font>HSR Amount :</label> <input
	type="text" name="<%=HSR_AMOUNT %>"
	validate="HSR Amount,floatWithoutSpaces,no" maxlength="7"
	style="width: 135px;" class="textbox_size20" value=""></div>
</div>
<input type="hidden" name="<%=SERVICE_TYPE_ID %>"
	value="<%=patient.getServiceType().getId() %>" id="serviceTypeId">
<input type="hidden" name="<%=SERVICE_NO%>" value="<%=serviceNo%>"
	id="serviceNo">


<input type="hidden" value="<%=inpatient.getAdNo()%>" name="parentAdNo" />
<input type="hidden" value="<%=inpatient.getHin().getId()%>"
	name="<%=HIN_ID %>" />
<input type="hidden" name="<%=BED_ID %>" value="" id="bedId">
<br />

<div id="edited"></div>
<label>&nbsp;</label>
<input type="button" name="attach" value="Save" class="button"
	onClick="if(testPage()){submitForm('attach','/hms/hms/adt?method=saveAttachedAdmission&formName=attach');}" />
<input type="submit" class="button" value="Back"
	onclick="submitFormForBack('attach','/hms/hms/adt?method=showAdmissionJsp');" />
<input type="hidden" name="Reset" value="Reset" class="button"
	onclick="location.reload();" accesskey="r" />


<% }
		%>
<div id="statusMessage" class="messagelabel"><br />
</div>
</div>
<script>
function closeWin(){
close();
}

function testPage(){
var errorMessage="";
	formName="attach"
	obj = eval('document.'+formName)


	if(document.getElementById('forName').value == "")
		errorMessage=errorMessage+"Please Fill name \n"; 
		if(document.getElementById('forAge').value == "")
		errorMessage=errorMessage+"Please fill age \n"; 
		if(document.getElementById('forSex').value == 0)
		errorMessage=errorMessage+"Please Slect sex \n"; 
		if(document.getElementById('attachedAs').value == 0)
		errorMessage=errorMessage+"Please Slect attachedAs \n"; 
	if(document.getElementById('rel').value == 0)
		errorMessage=errorMessage+"Please Select Relation \n"; 
	if(document.getElementById('veg').value == 0)
		errorMessage=errorMessage+"Please Select Veg/Non-Veg  \n";
	if(document.getElementById('diet').value == 0)
		errorMessage=errorMessage+"Please Select diet  \n";
		if(document.getElementById('wardId').value == 0)
		errorMessage=errorMessage+"Please Select Ward  \n";
		
		if(errorMessage !=""){
		alert(errorMessage)
		return false;
		}else{
		return true
		}
}

function checkForDuplicateOfAdno2(motherStatus,fatherStatus,motherId,fatherId,id){
if((motherStatus=="y") &&(motherId==id)){
	alert("Mother Already attached...!");
	obj=eval(document.getElementById('rel'))
	obj.selectedIndex=0
	return false;
}
if((fatherStatus=="y") &&(fatherId==id)){
	alert("Father already attached...!")
	obj=eval(document.getElementById('rel'))
	obj.selectedIndex=0
	return false
}
return true
}


function submitFormForBack(formName,action){
		obj = eval('document.'+formName)
	        	obj.action = action;
				obj.submit();
			
	}
function calculateDiet(hours){
ageVal=document.getElementById("forAge").value
	if(document.getElementById("ageUnitId").value !="Years"){
		ageVal=0
	}
	obj = eval('document.attach.diet');
	obj.length = 1;
	
	if(ageVal < 1){
		obj.options[obj.length-1].value=24;
		obj.options[obj.length-1].text='B/F';
		obj.selectedIndex =obj.length-1			
	}else if(ageVal < 5){
		obj.options[obj.length-1].value=25;
		obj.options[obj.length-1].text='N/2';
		obj.selectedIndex =obj.length-1
	}else if(ageVal >5 && ageVal <10){
		obj.options[obj.length-1].value=26;
		obj.options[obj.length-1].text='O/2';
		obj.selectedIndex =obj.length-1
	}else if(ageVal > 10){
	
		if(hours >= 18  && hours <24){
			obj.options[obj.length-1].value=3;
			obj.options[obj.length-1].text='N';
			obj.selectedIndex =obj.length-1
		}else if(hours >= 0  && hours <12)
		{
			obj.options[obj.length-1].value=1;
			obj.options[obj.length-1].text='O';
			obj.selectedIndex =obj.length-1
		}else if(hours >= 12  && hours <18 ){
			obj.options[obj.length-1].value=2;
			obj.options[obj.length-1].text='S';
			obj.selectedIndex =obj.length-1
		}
	}
	}
</script>
</body>
</form>

</div>

