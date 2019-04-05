<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * registration11.jsp  
 * Purpose of the JSP -  This is for Registration.
 * @author  Deepti
 * @author  Ritu
 * Create Date: 16th Jan,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>

<%@ page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasCountry"%>
<%@page import="jkt.hms.masters.business.MasState"%>
<%@page import="jkt.hms.masters.business.MasTitle"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.MasReligion"%>
<%@page import="jkt.hms.masters.business.MasCaste"%>
<%@page import="jkt.hms.masters.business.MasOccupation"%>
<%@page import="jkt.hms.masters.business.MasComplaint"%>
<%@page import="jkt.hms.masters.business.MasReference"%>
<%@page import="jkt.hms.masters.business.MasPatientType"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasBlock"%>
<%@page import="jkt.hms.masters.business.MasPostCode"%>
<%@page import="jkt.hms.masters.business.MasCompany"%>

<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasReferralDoctor"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDependent"%>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>

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


<div id="contentspace"><br />
<div id="heading"><label class="headtext">Patient
Registration</label></div>
<br />

<form name="registration" method="post" action="">
<%  	Map<String, Object> map = new HashMap<String, Object>();
			if(request.getAttribute("map") != null){
				map=(Map<String, Object>)request.getAttribute("map");
			}
	
			List<MasTitle> titleList = new ArrayList<MasTitle>();
			List<MasCountry> countryList = new ArrayList<MasCountry>();
			List<MasState> stateList = new ArrayList<MasState>();
			List<MasDistrict> districtList = new ArrayList<MasDistrict>();
			List<MasBlock> blockList = new ArrayList<MasBlock>();	
			List<MasPostCode> postCodeList =	new ArrayList<MasPostCode>();
			List<MasRelation> relationList = new ArrayList<MasRelation>();
			List<MasCaste> casteList = new ArrayList<MasCaste>();
			List<MasReligion> religionList = new ArrayList<MasReligion>();
			List<MasOccupation> occupationList = new ArrayList<MasOccupation>();
			List<MasComplaint> complaintList = new ArrayList<MasComplaint>();
			List<MasPatientType> patientTypeList = new ArrayList<MasPatientType>();
			List<MasReference> referenceList = new ArrayList<MasReference>();
			List<MasCompany> companyMasterList = new ArrayList<MasCompany>();
			List<MasReferralDoctor> referralDoctorList = new ArrayList<MasReferralDoctor>();
			List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			List<MasEmployeeDependent> employeeDependentList = new ArrayList<MasEmployeeDependent>();
			
			String hin = "";
			hin = (String)map.get("hin");
			
			if(map.get("titleList") != null){
				titleList = (List<MasTitle>)map.get("titleList");
			}
			if(map.get("countryList") != null){
				countryList =(List<MasCountry>)map.get("countryList");
			}
			if(map.get("stateList") != null)	{
				stateList = (List<MasState>)map.get("stateList");
			}
			if(map.get("districtList") != null){
				districtList =(List<MasDistrict>)map.get("districtList");
			}
			if(map.get("blockList") != null){
				blockList = (List<MasBlock>)map.get("blockList");
			}
			if(map.get("postCodeList") != null){
				postCodeList = (List<MasPostCode>)map.get("postCodeList");
			}
			if(map.get("relationList") != null){
				relationList = (List<MasRelation>)map.get("relationList");
			}
			if(map.get("casteList") != null){
				casteList = (List<MasCaste>)map.get("casteList");
			}
			if(map.get("religionList") != null){
				religionList = (List<MasReligion>)map.get("religionList");
			}
			if(map.get("occupationList") != null){
				occupationList = (List<MasOccupation>)map.get("occupationList");
			}
			if(map.get("complaintList") != null){
				complaintList = (List<MasComplaint>)map.get("complaintList");
			}
			if(map.get("patientTypeList") != null){
				patientTypeList = (List<MasPatientType>)map.get("patientTypeList");
			}
			if(map.get("referenceList") != null){
				referenceList = (List<MasReference>)map.get("referenceList");
			}
			if(map.get("companyMasterList") != null){
				companyMasterList = (List<MasCompany>)map.get("companyMasterList");
			}
			if(map.get("referalDoctorList") != null){
				referralDoctorList = (List<MasReferralDoctor>)map.get("referalDoctorList");
			}
			if(map.get("departmentList") != null){
				departmentList = (List<MasDepartment>)map.get("departmentList");
			}
			if(map.get("employeeList") != null){
				employeeList = (List<MasEmployee>)map.get("employeeList");
			}
			if(map.get("employeeDependentList") != null){
				employeeDependentList = (List<MasEmployeeDependent>)map.get("employeeDependentList");
			}
			%> <script type="text/javascript">
		<%
			int counter1 = 0;
			for (MasState masState : stateList)
			{
				for (MasDistrict masDistrict : districtList) 
				{
					if(masState.getId().equals(masDistrict.getState().getId() )){
								%>
									districtArray[<%=counter1%>] = new Array();
									districtArray[<%=counter1%>][0]=<%=masState.getId()%>;
									districtArray[<%=counter1%>][1] = <%=masDistrict.getId()%>;									
									districtArray[<%=counter1%>][2] = "<%=masDistrict.getDistrictName()%>";

								<%
								counter1++;
						}
					}
				}
			
		%>
			<%
			int count = 0;
			for (MasDistrict masDistrict : districtList) 
			{
				for (MasBlock masBlock  : blockList) 
				{
					if(masDistrict.getId().equals(masBlock.getDistrict().getId())){
								%>
									blockArray[<%=count%>] = new Array();
									blockArray[<%=count%>][0] = <%=masDistrict.getId()%>;
									blockArray[<%=count%>][1] = <%=masBlock.getId()%>;									
									blockArray[<%=count%>][2] = "<%=masBlock.getBlockName()%>";

								<%
								count++;
						}
					}
				}
			%>
			<%
			int count1 = 0;
			for (MasBlock masBlock : blockList) 
			{
				for (MasPostCode masPostCode : postCodeList) 
				{
					if(masBlock.getId().equals(masPostCode.getBlock().getId())){
								%>
									pincodeArray[<%=count1%>] = new Array();
									pincodeArray[<%=count1%>][0] = <%=masBlock.getId()%>;
									pincodeArray[<%=count1%>][1] = <%=masPostCode.getId()%>;									
									pincodeArray[<%=count1%>][2] = "<%=masPostCode.getPostCode()%>";

								<%
								count1++;
						}
					}
				}
			%>
		</script>


<div id="searchbar">
<div class="panelbar">
<div id=biglabel class="paneltext"">Personal Details</div>
</div>
<br />
<label> HIN No:</label><span>&nbsp;&nbsp;&nbsp; <%=hin %></span> <input
	type="hidden" name="<%=HIN %>" value="<%=hin %>"> <br />
<label> Title:</label> <select id="titleId" name="<%=TITLE%>"
	validate="Title,string,no">
	<option value="0">Select</option>
	<%
			 	for (MasTitle masTitle : titleList) 
				{
			%>
	<option value="<%=masTitle.getId()%>"><%=masTitle.getTitleName()%></option>
	<%}%>
</select> <br />

<label><font id="error">*</font> First Name:</label> <input type="text"
	name="<%=FIRST_NAME %>" value="" class="textbox_size20"
	validate="First Name,name,yes" MAXLENGTH="20" /> <label>Middle
Name:</label> <input type="text" name="<%=MIDDLE_NAME%>" value=""
	class="textbox_size20" validate="Middle Name,name,no" MAXLENGTH="30" />

<label><font id="error">*</font> Last Name:</label> <input type="text"
	name="<%=LAST_NAME %>" value="" class="textbox_size20"
	validate="Last Name,name,yes" MAXLENGTH="30" /> <br />

<div id="dateOfBirth"><label> <font id="error">*</font>Date
of Birth:</label> <input type="text" id="dobId" name="<%=DATE_OF_BIRTH %>"
	value="" class="textbox_date" readonly="readonly"
	validate="DOB,date,yes" MAXLENGTH="30" /> <a
	href="javascript:setdate('',document.registration.<%=DATE_OF_BIRTH%>)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a>

<div id="ageLabelId" style="display: none;"><label> Age:</label> <input
	type="text" name="ageLabel" value="" class="textbox_size20" /></div>
<div id="age" style="display: block;"><label><font
	id="error">*</font> Age:</label> <select id="ageId" name="<%=AGE%>"
	validate="Age,string,no" onchange="disableDOB(this)"
	style="width: 75px;">
	<option value="">Select</option>
	<%
					for(int age1=1;age1<=100;age1++){
					%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> <select id="ageUnitId" name="<%=AGE_UNIT %>"
	validate="AgeUnit,string,no" onchange="disableDOB()"
	style="width: 60px;">
	<option selected value="year">Years</option>
	<option value="month">Months</option>
	<option value="day">Days</option>
</select></div>

<label><font id="error">*</font> Gender:</label> <select
	name="<%=GENDER %>" validate="Gender,string,yes" style="width: 75px;">
	<option value="">Select</option>
	<option value="Male">Male</option>
	<option value="Female">Female</option>
</select> <br />

<label> Religion:</label> <select name="<%=RELIGION %>"
	validate="Religion,string,no">
	<option value="0">Select</option>
	<%
			 for(MasReligion masReligion : religionList){
			
			%>
	<option value="<%=masReligion.getId()%>"><%=masReligion.getReligionName()%></option>
	<%}%>
</select> <label> Caste:</label> <select name="<%=CASTE %>"
	validate="Caste,string,no">
	<option value="0">Select</option>
	<%
				for(MasCaste masCaste : casteList){
			
			%>
	<option value="<%=masCaste.getId()%>"><%=masCaste.getCasteName()%></option>
	<%}%>
</select> <label> Occupation:</label> <select name="<%=OCCUPATION %>"
	validate="Occupation,string,no">
	<option value="0">Select</option>
	<%
			 for(MasOccupation masOccupation : occupationList){
			 %>
	<option value="<%=masOccupation.getId()%>"><%=masOccupation.getOccupationName()%></option>
	<%}%>
</select> <br />

<div class="labelbig"><font id="error">*</font>Patient Department:</div>
<select name="<%=PATIENT_DEPARTMENT %>"
	onchange="populateDoctor(this.value,'registration')"
	validate="Patient Department,string,yes">
	<option value="0">Select</option>
	<%
			 for(MasDepartment masDepartment : departmentList){
			%>
	<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
	<%}%>
</select>

<div class="labelbig"><font id="error">*</font> Consulting Doctor:</div>
<select name="<%=CONSULTING_DOCTOR %>"
	validate="Consulting Doctor,string,yes">
	<option value="0">Select</option>
</select> <script type="text/javascript">
			<%int i = 0;
			for (MasDepartment masDepartment : departmentList) 
			{
				for (MasEmployee masEmployee : employeeList) 
				{
					if(masDepartment.getId().equals(masEmployee.getDepartment().getId())){
								%>
									doctorArr[<%=i%>] = new Array();
									doctorArr[<%=i%>][0] = <%=masDepartment.getId()%>;
									doctorArr[<%=i%>][1] = <%=masEmployee.getId()%>;									
									doctorArr[<%=i%>][2] = "<%=masEmployee.getFirstName().concat(" ").concat(masEmployee.getLastName())%>";

								<%
								i++;
						}
					}
				}
				%>
			</script> <label> Patient Status:</label> <span>&nbsp;&nbsp;&nbsp; Out
Patient</span> <br />

<label>Reference:</label> <select name="<%=REFERENCE%>"
	validate="Reference,string,no">
	<option value="0">Select</option>
	<%
			 for(MasReference masReference : referenceList){
			
			%>
	<option value="<%=masReference.getId()%>"><%=masReference.getReferenceName()%></option>
	<%}%>
</select> <label>Complaint:</label> <select name="<%=COMPLAINT_ID%>"
	validate="Complaint,string,no">
	<option value="0">Select</option>
	<%
			 for(MasComplaint masComplaint : complaintList){
			
			%>
	<option value="<%=masComplaint.getId()%>"><%=masComplaint.getComplaintName()%></option>
	<%}%>
</select> <label>If Others:</label> <textarea name="<%=OTHER_COMPLAINT %>"
	cols="25" rows="3"></textarea> <br>
</div>
</div>
<br />

<div id="searchbar">
<div class="panelbar">
<div id=biglabel class="paneltext"">Contact Details</div>
</div>
<br />

<label><font id="error">*</font>Address:</label> <textarea
	name="<%=ADDRESS%>" cols="50" rows="3" validate="Address,string,yes"
	MAXLENGTH="30"></textarea> <br />
<label><font id="error">*</font> Country:</label> <select
	name="<%= NATIONALITY %>" validate="Nationality,string,yes"
	onchange="populateState(this.value,'registration')">
	<option value="0">Select</option>
	<%
			 for(MasCountry cntMaster : countryList)
			 {
			%>
	<option value="<%=cntMaster.getId()%>"><%=cntMaster.getCountryName()%></option>
	<%}%>
</select> <label><font id="error">*</font> State:</label> <select
	name="<%=STATE%>" validate="State,string,yes"
	onchange="populateDistrict(this.value,'registration')">
	<option value="0">Select</option>
</select> <script type="text/javascript">
			
			<%
			int counter=0;
			for (MasCountry masCountry : countryList) 
			{
				for (MasState masState : stateList) 
				{
					if(masCountry.getId().equals(masState.getCountry().getId())){
								%>
									stateArr[<%=counter%>] = new Array();
									stateArr[<%=counter%>][0] = <%=masCountry.getId()%>;
									stateArr[<%=counter%>][1] = <%=masState.getId()%>;									
									stateArr[<%=counter%>][2] = "<%=masState.getStateName()%>";
								<%
								counter++;
						}
					}
				}
		%>
			</script> <label> City:</label> <input type="text" name="<%=CITY %>" value=""
	class="textbox_size20" validate="City,city,no" MAXLENGTH="30" /> <br />

<label>District:</label> <select name="<%=DISTRICT%>"
	validate="District,string,no"
	onchange="populateBlock(this.value,'registration')">
	<option value="0">Select</option>
</select> <label>Block:</label> <select name="<%=BLOCK%>"
	validate="Block,string,no"
	onchange="populatePincode(this.value,'registration')" />
	<option value="0">Select</option>
</select> <label>Pincode:</label> <select name="<%=PINCODE%>"
	validate="Pincode,string,no"">
	<option value="0">Select</option>
</select> <br />

<label> Village:</label> <input type="text" name="<%=VILLAGE %>"
	value="" class="textbox_size20" validate="Village,city,no"
	MAXLENGTH="30" /> <label> Post Office:</label> <input type="text"
	name="<%=POST_OFFICE %>" value="" class="textbox_size20"
	validate="Post Office,string,no" MAXLENGTH="30" /> <label>
Police Station:</label> <input type="text" name="<%=POLICE_STATION %>" value=""
	class="textbox_size20" validate="Police Station,string,no"
	MAXLENGTH="30" /> <br />
<label><font id="error">*</font> Phone:</label> <input type="text"
	name="<%=PHONE %>" value="" class="textbox_size20"
	validate="Phone,int,yes" MAXLENGTH="20" /> <label>Mobile:</label> <input
	type="text" name="<%=MOBILE %>" value="" class="textbox_size20"
	validate="Mobile Number,int,no" MAXLENGTH="20" /> <label>Email
Id:</label> <input type="text" name="<%=EMAIL_ID %>" value=""
	class="textbox_size20" validate="Email Id,email,no" MAXLENGTH="30" />
<br />
<label><font id="error">*</font> Patient Type:</label> <select
	name="<%=PATIENT_TYPE%>" validate="Patient Type,string,yes"
	onchange="showComboAccordingToPatientType('registration')">
	<option value="0">Select</option>
	<%
			 for(MasPatientType masPatientType : patientTypeList){
			%>
	<option value="<%=masPatientType.getId()%>"><%=masPatientType.getPatientTypeName()%></option>
	<%}%>

</select>

<div id="Company" style="display: none;"><label><font
	id="error">*</font> Company :</label> <select name="<%=COMPANY%>"
	validate="Company,string,no">
	<option value="0">Select</option>
	<%
			 for(MasCompany masCompany : companyMasterList){
				if(masCompany.getCompanyCode().equals("COM")){
			%>
	<option value="<%=masCompany.getId() %>"><%=masCompany.getCompanyName() %></option>
	<%}
			} %>
</select></div>

<div id="Project" style="display: none;"><label><font
	id="error">*</font> Project :</label> <select name="<%=PROJECT%>"
	validate="Project,string,no">
	<option value="0">Select</option>
	<%
			 for(MasCompany masCompany : companyMasterList){
				if(masCompany.getCompanyCode().equals("PRJ")){
			%>
	<option value="<%=masCompany.getId() %>"><%=masCompany.getCompanyName() %></option>
	<%}
			} %>
</select></div>

<div id="Insurance" style="display: none;"><label><font
	id="error">*</font> Insurance :</label> <select name="<%=INSURANCE%>"
	validate="Insurance,string,no">
	<option value="0">Select</option>
	<%
			  for(MasCompany masCompany : companyMasterList){
				if(masCompany.getCompanyCode().equals("INS")){
			%>
	<option value="<%=masCompany.getId() %>"><%=masCompany.getCompanyName() %></option>
	<%}
			} %>
</select></div>

<div id="Retired" style="display: none;"><label><font
	id="error">*</font> Retired Staff :</label> <select name="<%=RETIRED_STAFF%>"
	validate="Retired Staff,string,no">
	<option value="0">Select</option>
	<%
				 for(MasEmployee masEmployee : employeeList){
					if(masEmployee.getStatus().equals("n")){
			%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
	<%}
				 }
			 %>
</select></div>

<div id="Staff" style="display: none;"><label><font
	id="error">*</font> Staff :</label> <select name="<%=STAFF%>"
	validate="Staff,string,no"
	onchange="populateStaffDependent(this.value,'registration')">
	<option value="0">Select</option>
	<%
		 	for(MasEmployee masEmployee : employeeList){
					if(masEmployee.getStatus().equals("y")){
			%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
	<%}
				 }
			 %>
</select></div>

<div id="Dependent" style="display: none;"><label><font
	id="error">*</font> Staff Dependent:</label> <select
	name="<%=STAFF_DEPENDENT%>" validate="Staff Dependent,string,no">
	<option value="0">Select</option>
</select> <script type="text/javascript">
			
			<%
			int j=0;
			for(MasEmployee masEmployee : employeeList){
				for (MasEmployeeDependent masEmployeeDependent : employeeDependentList) 
				{
					if(masEmployee.getId().equals(masEmployeeDependent.getEmployee().getId())){
								%>
									dependentArray[<%=j%>] = new Array();
									dependentArray[<%=j%>][0] = <%=masEmployee.getId()%>;
									dependentArray[<%=j%>][1] = <%=masEmployeeDependent.getId()%>;									
									dependentArray[<%=j%>][2] = "<%=masEmployeeDependent.getEmployeeDependentName()%>";

								<%
								j++;
						}
					}
				}
			
		%>
			</script></div>
<div id="Referral" style="display: none;"><label><font
	id="error">*</font> Referral :</label> <select name="<%=REFERRAL%>"
	validate="Referral,string,no"
	onchange="populateStaffDependent(this.value,'registration')">
	<option value="0">Select</option>
	<%
				 for(MasEmployee masEmployee : employeeList){
					if(masEmployee.getStatus().equals("y")){
			%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
	<%}
				 }
			 %>
</select></div>
</div>
<br />

<div id="searchbar">
<div class="panelbar">
<div id=biglabel class="paneltext"">Emergency Contact</div>
</div>
<br />

<label>Relative Name:</label> <input type="text"
	name="<%=RELATIVE_NAME %>" value="" class="textbox_size20"
	validate="Relative Name,name,no" MAXLENGTH="30" /> <label>&nbsp;Relation:</label>
<select name="<%=RELATION_ID%>">
	<option value="0">Select</option>
	<%
			 for(MasRelation masRelation : relationList){
			 %>
	<option value="<%=masRelation.getId()%>"><%=masRelation.getRelationName()%></option>
	<%}%>
</select> <br />
<label> Address:</label> <textarea name="<%=EMERGENCY_ADDRESS %>"
	validate="Emergency Address,string,no" cols="25" rows="3" />
			</textarea> <label>Pincode:</label> <select name="<%=EMERGENCY_PINCODE%>"
	validate="Emergency Pincode,string,no"">
	<option value="0">Select</option>
	<%
				 for(MasPostCode masPostCode : postCodeList){
			 %>
	<option value="<%=masPostCode.getId()%>"><%=masPostCode.getPostCodeName()%></option>
	<%}%>
</select> <label>Phone:</label> <input type="text" name="<%=EMERGENCY_PHONE %>"
	value="" class="textbox_size20" validate="Phone,int,no" MAXLENGTH="30" />
<br />
<label>Mobile:</label> <input type="text" name="<%=EMERGENCY_MOBILE %>"
	value="" class="textbox_size20" validate="Mobile Number,int,no"
	MAXLENGTH="30" /></div>

<br />
<div id="searchbar">
<div class="panelbar">
<div id=biglabel class="paneltext"">Referal Doctor</div>
</div>
<br />
<label> Referal Doctor Name:</label> <select
	name="<%=REFERRAL_DOCTOR_ID%>" validate="Referal Doctor,string,no">
	<option value="0">Select</option>
	<%
			 for(MasReferralDoctor masReferralDoctor : referralDoctorList){
				
			%>
	<option value="<%=masReferralDoctor.getId() %>"><%=masReferralDoctor.getDoctorName() %></option>
	<%
			} %>
</select>

<div id="edited"></div>
<label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>
<input type="button" name="Submit" value="Submit" class="button"
	onClick="submitForm('registration','/hms/hms/registration?method=submitPatientInformation');" />
<input type="reset" name="Reset" value="Reset" class="button"
	onclick="location.reload();" accesskey="r" /></div>
<div id="statusMessage" class="messagelabel"><br />
</div>
</form>

</div>
