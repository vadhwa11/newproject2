
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
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDiet"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="jkt.hms.masters.business.MasAdmissionType"%>
<%@page import="jkt.hms.masters.business.MasBed"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.MasDocument"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.UserEmpGroup"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>


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
	List<MasIcd> diagnosisList = new ArrayList<MasIcd>();
	List<MasAdmissionType> admissionTypeList = new ArrayList<MasAdmissionType>();
	List<MasBed> bedList = new ArrayList<MasBed>();
	List<MasRelation> relationList = new ArrayList<MasRelation>();
	List<MasDocument> documentList = new ArrayList<MasDocument>();
	List<MasMaritalStatus> maritalStatusList = new ArrayList<MasMaritalStatus>();
	List<UserEmpGroup> userEmpGroupList = new ArrayList<UserEmpGroup>();
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
	//This is the part test bed availability
	if(map.get("detailsMap") != null){
			detailsMap = (Map<String,Object>)map.get("detailsMap");
		}
	if(detailsMap.get("bedList") != null){
		bedList = (List<MasBed>)detailsMap.get("bedList");
	}
	if(detailsMap.get("userEmpGroupList") != null){
		userEmpGroupList = (List<UserEmpGroup>)detailsMap.get("userEmpGroupList");
	}
	boolean uEGcheck = false;
	for(UserEmpGroup uEG : userEmpGroupList){
		if(userName.equals(uEG.getUser().getLoginName())){
			uEGcheck = true;
		}
	}
	

	for (Iterator iterator = bedList.iterator(); iterator.hasNext();) {
		MasBed masBed = (MasBed) iterator.next();
		if(masBed.getBedStatus().getId() == bedStatusUnOccupiedId){
			
			bedId = masBed.getId();
	  }
	}
	List<MasRank> rankList = new ArrayList<MasRank>();
	if(detailsMap.get("rankList") != null){
	rankList= (List<MasRank>)detailsMap.get("rankList");
	}
	if(detailsMap.get("maritalStatusList") != null){
		maritalStatusList = (List<MasMaritalStatus>)detailsMap.get("maritalStatusList");
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
	
	if(detailsMap.get("diagnosisList") != null){
		diagnosisList = (List<MasIcd>)detailsMap.get("diagnosisList");
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

	%>
	
<%if(bedId >0 ){ %>


	<%int ageForDiet = 0;
	Patient patient = new Patient();
	if(patientList.size() > 0){
		patient = patientList.get(0);
		String age = "";
		String currentAge = "";
		if(patient.getAge()!= null){
			age = patient.getAge();
			currentAge = HMSUtil.calculateAgeForADT(age, patient.getRegDate());
			ageForDiet = Integer.parseInt(""+HMSUtil.calculateAgeForADT2(age, patient.getRegDate())) ;
		}
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
<div class="Block">
<label>Service No. <span>*</span></label>
<input type="text" name="<%=SERVICE_NO %>" id="serviceNo" value="<%= patient.getServiceNo()!=null? patient.getServiceNo():""%>" validate="Service No.,string,yes" onblur="submitProtoAjaxWithDivName('admissionByHin','/hms/hms/adt?method=getHinNoForAdm','hinDiv');"  /> 
<label>HIN <span>*</span></label>
<div id="hinDiv">
<input type="text" name="<%=HIN_ID %>" id="hinId" value="<%=patient.getHinNo() %>"/> 
</div>

<label>Patient Name</label> 
<label class="value"><%= patient.getPFirstName()+" "+middleName+" "+lastName%></label>
<div class="clear"></div>
<label>Relation</label> <%
	if(patient.getRelation() != null){
	%> <label class="value"><%= patient.getRelation().getRelationName()%></label>
<input type="hidden" name="relationId" id="relationId" value="<%=patient.getRelation()%>"> 
<%} else{ %> 
<label class="value">-</label> <% }%> 


<%
		/* if(patient.getServiceType().getId()!=7){ */
			if(patient.getRank()!=null){
	%>
	<label>Rank</label>
	<label class="value"><%=patient.getRank()!=null?patient.getRank().getRankName():"" %></label>

<label>Name</label> <%
		String sMiddleName = "";
		String sLastName = "";
		if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){
		
			if(patient.getSMiddleName() != null){
				sMiddleName = patient.getSMiddleName();
			}
			if(patient.getSLastName() != null){
				sLastName = patient.getSLastName();
			}
	 %> <label class="value"><%= patient.getSFirstName()+" "+sMiddleName+" "+sLastName%></label>
<%}else{ %> 
<label class="value">-</label> <% }%>


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
<%-- <input	type="hidden" name="<%=SERVICE_TYPE_CODE %>" value="<%=patient.getServiceType().getServiceNameShortDesc() %>">
<input type="hidden" name="<%=SERVICE_TYPE_ID %>" value="<%=patient.getServiceType().getId() %>" id="serviceTypeId"> --%>
<% 

	}else{ %>

<label>Patient Name</label> 
<label	class="value">&nbsp;</label> 
<div class="clear"></div>
<label>Relation</label>
<label class="value">&nbsp;</label>

<label>Rank</label>
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
<select name="<%=ADMISSION_TYPE_ID %>" tabindex="1" 
	validate="Admission Type,String,yes" id="admType" onchange="displayFieldsForAdmType(this.value);">
	<option value="0">Select</option>
	<% 
		for (MasAdmissionType obj : admissionTypeList){
	%>
	<option value="<%=obj.getId ()%>"><%=obj.getAdmissionTypeName()%></option>
	<% }%>
</select> 
<script>
document.getElementById('admType').focus();
</script>
<div id="admTypeDt" style="display: none;">
<label>  Hospital Name <span>*</span></label> 
<input type="text" name="prevHospitalName" value="" maxlength="50" tabindex="1" />

<div class="clear"></div>
<label>  A&D No. <span>*</span></label> 
<input type="text" name="prevAdNo" value="" maxlength="30"tabindex="1" />
<label>  Disposal <span>*</span></label> 
<input type="text" name="prevDisposal" value="" maxlength="100"tabindex="1" />
<label>  Diagnosis <span>*</span></label> 
<input type="text" name="prevDiagnosis" value="" maxlength="100"tabindex="1" />
<div class="clear"></div>
</div>

<label>  Date  <span>*</span></label> 
<input type="text"	name="<%=DATE_OF_ADMISSION%>" value="<%=currentDate %>" tabindex="1"  class="calDate"	readonly="readonly" validate="Adm. Date,dateOfAdmission,yes"
	MAXLENGTH="30" id="admDate" onchange="populateListDateTime();"	onclick="populateListDateTime();" /> 
<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender"
	onClick="setdate('',document.admissionByHin.<%=DATE_OF_ADMISSION%>,event)" />

<label>  Time  <span>*</span></label> 
<input type="text"	name="<%=TIME_OF_ADMISSION %>" value="<%=currentTime %>"	 validate="Adm. Time,String,yes" id="admTime"
	readonly="readonly"	onblur="checkTime('admissionByHin','<%=TIME_OF_ADMISSION%>');populateListDateTime();" />

<div class="clear"></div>

<label>  Admitting MO <span>*</span></label> 
<select	name="<%=CONSULTING_DOCTOR %>" validate="Admitting MO,String,yes" tabindex="1" >
	<option value="0">Select</option>
	<% 
		for (MasEmployee  obj : employeeList){
			if(obj.getEmpCategory() != null){
			if(obj.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
			
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
	<option value="<%=obj.getId ()%>"><%=rankName+" "+obj.getFirstName()+" "+doctorMiddleName+" "+doctorLastName%></option>
	<%  }}
	} %>
</select>
<label>  Ward <span>*</span></label> 
<select name="<%=DEPARTMENT_ID %>"	validate="Ward,String,yes" onchange="checkBed()" id="wardId" tabindex="1" >
	<option value="0">Select</option>
	<% 
		
				for(MasDepartment obj : departmentList){
		%>
	<option value="<%=obj.getId()%>"><%=obj.getDepartmentName()%></option>
	<%}%>
</select>
<input type="hidden"  id="bedNoTemp" value="" class="readOnly" readonly="readonly" validate="Bed No.,String,yes" />
  <input type="hidden" id="roomTypeId" name="<%=ROOM_TYPE_ID %>" value=""/>
<input type="hidden" name="bedNo" id="bedNo" value=""/>
<label>Prov. Diagnosis</label> 
<input type="text" name="<%=PROVISIONAL_DIAG %>" id="icdCode" value="" tabindex="1" maxlength="100"/> 

<div class="clear"></div>
<label>  Condition <span>*</span></label> 
<select id="conditionId" name="<%=CONDITION %>" class="year" tabindex="1" validate="Condition,String,yes" onchange="displayStatus(),displayListDateTime();">
	<option value="0">Select</option>
	<option value="Normal">Normal</option>
	<option value="Critical">Critical</option>
	<option value="Dead">Dead</option>
</select> 
<label>  Status <span>*</span></label>
<!--<label id="blnkSts">&nbsp;</label>
--><div id="status1" >
<select name="<%=CONDITION_STATUS %>" id="conditionStatus" class="" tabindex="1" validate="Status,String,no">
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
<select name="<%=CONDITION_STATUS %>" class="" tabindex="1" >
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
		}else if(condition == "Dead"){
			document.getElementById('status2').style.display = "inline";
			document.getElementById('status1').style.display = "none";
			document.getElementById('status3').style.display = "none";
		}else if(condition == "Critical"){
			document.getElementById('status3').style.display = "inline";
			document.getElementById('status1').style.display = "none";
			document.getElementById('status2').style.display = "none";
		}else if(condition == "0"){
			document.getElementById('status1').style.display = "none";
			document.getElementById('status2').style.display = "none";
			document.getElementById('status3').style.display = "none";
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

 <label> Veg/Non-Veg</label> 
 <select	name="<%=DIET_TYPE%>" validate="Veg/Non-Veg,String,no" tabindex="1" >
	<option value="">Select</option>
	<option value="Veg">Veg</option>
	<option value="Non-Veg">Non-Veg</option>
</select>

 <div class="clear"></div>


<label>Patient Diet</label> 
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

</select>
<label>CDA Account No.</label>
 <input type="text" name="<%=CDA_ACCOUNT_NO %>" value="" maxlength="50" tabindex="1" >
<label>AB 64 Available</label>
 <input type="checkbox" class="radio" 	name="<%=AB_64_AVAILABLE %>" value="y" tabindex="1" >
	
<div class="clear"></div>
</div>	
<div class="clear"></div>
<h4>NOK Details</h4>
<div class="clear"></div>
<div class="Block">
<%
if(patientList.size() > 0){
%>
<label> NOK1</label>
<div class="clear"></div>
<label>  Name</label>
<input type="text" name="<%=NEXT_OF_KIN_NAME%>" value="<%=patient.getNextOfKinName()!=null?patient.getNextOfKinName():""%>" tabindex="1" 	validate="NOK1 Name,fullName,no" id="nokNameId" maxlength="30"/>
	
<label>  Relation</label> 
<select	name="<%=NEXT_OF_KIN_RELATION_ID %>" validate="NOK1 Relation,String,no"	id="relId" tabindex="1" >
	<option value="0">Select</option>

	<% 
	for (MasRelation  obj : relationList){
	%>
	<option value="<%=obj.getId()%>"><%=obj.getRelationName()%></option>
	<% 				
	}%>
</select>
<script>
document.getElementById('relId').value = '<%=patient.getNextOfKinRelation()!=null?patient.getNextOfKinRelation().getId():"0"%>';
</script>
<label> Contact No.</label> 
<input	type="text" name="<%=NEXT_OF_KIN_PHONE_NO%>" value="<%=patient.getNextOfKinPhoneNumber()!=null?patient.getNextOfKinPhoneNumber():""%>" id="nokContactNoId" tabindex="1" 	validate="NOK1 Phone No,phone,no" maxlength="16" />
<div class="clear"></div>
<label> Address</label> 
<textarea name="<%=NEXT_OF_KIN_ADDRESS %>" id="nextOfKinAdd"	cols="20" rows="2" tabindex="1" validate="Nok1 Address,string,no" maxlength="200"
	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"><%=patient.getNextOfKinAddress()!=null?patient.getNextOfKinAddress():""%></textarea>

<div class="clear"></div>
	
<label> NOK2</label>
<div class="clear"></div>
<label>  Name</label>
<input type="text" name="nok2Name" value="<%=patient.getNok2Name()!=null?patient.getNok2Name():""%>"	validate="NOK2 Name,fullName,no" tabindex="1"  id="nok2NameId" maxlength="30"/>
	
<label>  Relation</label> 
<select	name="nok2RelationId" validate="NOK2 Relation,String,no" tabindex="1" 	id="nok2RelId">
	<option value="0">Select</option>

	<% 
	for (MasRelation  obj : relationList){
	%>
	<option value="<%=obj.getId()%>"><%=obj.getRelationName()%></option>
	<% 				
	}%>
</select>
<script>
document.getElementById('nok2RelId').value = '<%=patient.getNok2Relation()!=null?patient.getNok2Relation().getId():"0"%>';

</script>
<label> Contact No.</label> 
<input	type="text" name="nok2ContactNo" value="<%=patient.getNok2ContactNo()!=null?patient.getNok2ContactNo():""%>" id="nok2ContactNo" tabindex="1" 	validate="NOK2 Contact No,phone,no" maxlength="16" />
<div class="clear"></div>
<label> Address</label> 
<textarea name="nok2Address" id="nok2Add"	cols="20" rows="2" tabindex="1" validate="Nok2 Address,string,no" maxlength="200"
	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"><%=patient.getNok2Address()!=null?patient.getNok2Address():""%></textarea>
<%}else{ %>	
<label> NOK1</label>
<div class="clear"></div>
<label>  Name</label>
<input type="text" name="<%=NEXT_OF_KIN_NAME%>" value="" tabindex="1" 	validate="NOK1 Name,fullName,no" id="nokNameId" maxlength="30"/>
	
<label>  Relation</label> 
<select	name="<%=NEXT_OF_KIN_RELATION_ID %>" validate="NOK1 Relation,String,no"	id="relId" tabindex="1" >
	<option value="0">Select</option>

	<% 
	for (MasRelation  obj : relationList){
	%>
	<option value="<%=obj.getId()%>"><%=obj.getRelationName()%></option>
	<% 				
	}%>
</select>
<label> Contact No.</label> 
<input	type="text" name="<%=NEXT_OF_KIN_PHONE_NO%>" value="" id="nokContactNoId" tabindex="1" 	validate="NOK1 Phone No,phone,no" maxlength="16" />
<div class="clear"></div>
<label> Address</label> 
<textarea name="<%=NEXT_OF_KIN_ADDRESS %>" id="nextOfKinAdd"	cols="20" rows="2" tabindex="1" validate="Nok1 Address,string,no"
	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>

<div class="clear"></div>
	
<label> NOK2</label>
<div class="clear"></div>
<label>  Name</label>
<input type="text" name="nok2Name" value=""	validate="NOK2 Name,fullName,no" tabindex="1"  id="nok2NameId" maxlength="30"/>
	
<label>  Relation</label> 
<select	name="nok2RelationId" validate="NOK2 Relation,String,no" tabindex="1" 	id="nok2RelId">
	<option value="0">Select</option>

	<% 
	for (MasRelation  obj : relationList){
	%>
	<option value="<%=obj.getId()%>"><%=obj.getRelationName()%></option>
	<% 				
	}%>
</select>
<label> Contact No.</label> 
<input	type="text" name="nok2ContactNo" value="" id="nok2ContactNo" tabindex="1" 	validate="NOK2 Contact No,phone,no" maxlength="16" />
<div class="clear"></div>
<label> Address</label> 
<textarea name="nok2Address" id="nok2Add"	cols="20" rows="2" tabindex="1" validate="Nok2 Address,string,no"
	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
	<%} %>
<%--<script>
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
	--%>
<div class="clear"></div>
</div><!-- End Block 3--> 
<div class="Block">
<label>Docs. Received</label> 
 <select name="<%=DOCUMENT_ID%>" size="3" title="Press ctrl key to select multiple" tabindex="1" 	multiple="3" validate="Document Initiated,String,no" class="list">
	<option value="0">Select</option>
	<% 
		for (MasDocument  obj : documentList){
	%>
	<option value="<%=obj.getId ()%>"><%=obj.getDocumentName()%></option>
	<% }%>

</select> 

<div class="clear"></div>

<input type="hidden" name="<%=BED_ID %>" value="" id="bedId" validate="Bed No.,string,yes">
<div class="clear"></div>

<%} %>
</div>