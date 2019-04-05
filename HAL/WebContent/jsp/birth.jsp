<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * registration.jsp  
 * Purpose of the JSP -  This is for Birth .
 * @author  Dipali
 * Create Date: 23rd April,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.36
--%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<%
    Map<String, Object> map = new HashMap<String, Object>();
	String motherName="";
	String regNo="";
	int serNo=0;
	if(request.getAttribute("map") != null){
		map=(Map<String, Object>)request.getAttribute("map");
	}
	String fatherName="";
	List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
   try{
		inPatientDetailList=(List)map.get("showList");
		if(map.get("fatherName")!=null)
		{
			fatherName=""+map.get("fatherName");
		}
		if(map.get("motherName")!=null)
		{
			motherName=""+map.get("motherName");
		}
		if(map.get("employeeList")!=null)
		{
			employeeList=(List)map.get("employeeList");
		}
		
		if(map.get("regNo")!=null)
		{
			regNo=(String)map.get("regNo");
		}
		if(map.get("serNo")!=null)
		{
			serNo=Integer.parseInt(""+map.get("serNo")) ;
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	   if(inPatientDetailList != null && inPatientDetailList.size()>0)
	   {
		   Inpatient inPatientDetail=(Inpatient)inPatientDetailList.get(0);
		   String middleName = "";
		   String lastName = "";
		   if(inPatientDetail.getHin().getPMiddleName() != null){
				middleName = inPatientDetail.getHin().getPMiddleName();
			}
			if(inPatientDetail.getHin().getPLastName() != null){
				lastName = inPatientDetail.getHin().getPLastName();
			}
		   String patientName=inPatientDetail.getHin().getPFirstName()+""+middleName+""+lastName;
		   
 %>

<div id="birthDiv"><label>Patient Name</label> <input
	id="patientId" type="text" name="<%=PATIENT_NAME %>"
	value="<%=patientName %>" title="Patient Name"
	validate="Patient Name,string,yes" MAXLENGTH="50" /> <input
	type="hidden" id="frwSlno" name="<%=HIN_ID%>"
	value="<%=inPatientDetail.getHin().getId()%>" MAXLENGTH="50" /> <input
	type="hidden" id="frwSlno" name="<%=SEX_ID%>"
	value="<%=inPatientDetail.getHin().getSex().getId()%>" MAXLENGTH="30" />
<input type="hidden" name="serNo" value="<%=serNo%>" MAXLENGTH="30" />
<label>Gender</label> <%if(inPatientDetail.getHin().getSex() != null){ %>
<input id="genderId" type="text" name="<%=SEX%>"
	value="<%=inPatientDetail.getHin().getSex().getAdministrativeSexName() %>"
	title="Patient Name" validate="Gender,string,yes" MAXLENGTH="15" /> <%}else{ %>
<input type="text" name="<%=SEX%>" size="2" value="" /> <%} %> <label>Date
of Birth</label> <%if(inPatientDetail.getHin().getDateOfBirth() != null){ %> <input
	type="text" id="birthDateId" name="<%=DATE_OF_BIRTH %>" class="calDate"
	value="<%=HMSUtil.changeDateToddMMyyyy(inPatientDetail.getHin().getDateOfBirth()) %>"
	validate="Date Of Birth,date,no" readonly="readonly" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.fatalDocumentPanchnamaReport.<%=DATE_OF_BIRTH%>,event)" />

<%}else{ %> <input type="text" name="<%=DATE_OF_BIRTH %>" class="calDate"
	size="2" value="" id="birthDateId" readonly="readonly"> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.fatalDocumentPanchnamaReport.<%=DATE_OF_BIRTH%>,event)" />

<%} %>

<div class="Clear"></div>


<label>Time of Birth</label> <input id="gender" type="text"
	name="<%=TIME %>" value="" title="Gender" validate="Time of Birth,string,yes"
	MAXLENGTH="8" onKeyUp="mask(this.value,this,'2,5',':');" onBlur="IsValidTime(this.value,this.id);"    /> 
	<label>Mother's
Name</label> <input id="motherId" type="text" name="<%=MOTHER_NAME %>"
	value="<%=motherName%>" title="Mother Name"
	validate="Mother Name,string,no" MAXLENGTH="50" /> <label>Father's
Name</label> <input id="fatherId" type="text" name="<%=FATHER_NAME %>"
	value="<%=fatherName%>" title="Father Name"
	validate="Father Name,String,no" MAXLENGTH="50" />
<div class="Clear"></div>
<div class="Height10"></div>

<label>Address of Parents at the time of birth of the child</label> <textarea
	name="<%=ADDRESS1%>" cols="20" rows="2" tabindex="2"
	validate="Address,string,no" class="large"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
<div class="Clear"></div>
<div class="Height10"></div>
<label>Permanent address of parents</label> <%if(inPatientDetail.getHin().getAddress() != null){ %>
<textarea name="<%=ADDRESS2%>" cols="20" rows="2" tabindex="2"
	validate="Address,string,no" class="large"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
<%}else{ %> <textarea name="<%=ADDRESS2%>" cols="20" rows="2" tabindex="2"
	validate="Address,string,no" class="large"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
<%} %>

<div class="Clear"></div>
<div class="Height10"></div>
<label>Date of Registration</label> <%if(inPatientDetail.getHin().getRegDate() != null){ %>
<input type="text" id="regDateId" name="<%=REG_DATE %>"
	value="<%=HMSUtil.changeDateToddMMyyyy(inPatientDetail.getHin().getRegDate()) %>"
	validate="Date Of Registration,date,no" /> <%}else{ %> <input
	type="text" name="<%=REG_DATE %>" size="2" value="" /> <%} %> <label>Date
of Issuing</label> <input type="text" id="regDateId" name="<%=ISSUE_DATE %>"
	value="" class="calDate" readonly="readonly"
	validate="Date Of Registration,date,no" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('',document.fatalDocumentPanchnamaReport.<%=ISSUE_DATE%>,event)" />

<label><span>*</span> Registration No.</label> <input id="regId"
	type="text" name="<%=REG_NO %>" value="<%=regNo %>"
	validate="Registration No,String,yes"
	onblur="checkRegNo(this.value,'birth');" title="Registration No."
	MAXLENGTH="10" /> <%} %>

<div class="Clear"></div>
<label>No of Copies</label> <input id="fatherId" type="text"
	name="<%=NO_OF_COPIES %>" value="" validate="No of Copies,num,no"
	MAXLENGTH="3" /> <label>Amount</label> <input id="fatherId"
	type="text" name="<%=AMOUNT %>" value="" validate="amount,num,no"
	MAXLENGTH="15" /> <label>Remarks</label> <input id="fatherId"
	type="text" name="<%=REMARKS %>" value="" title="Remarks"
	MAXLENGTH="45" />

<div class="Clear"></div>
<label>Authenticated Employee</label> <select id="employeeId"
	name="<%=EMPLOYEE_ID %>">
	<option value="0">Select</option>
	<%
							for (MasEmployee masEmployee : employeeList) {
						%>
	<option value="<%=masEmployee.getId()%>"><%=masEmployee.getFirstName()%>
	<%=masEmployee.getMiddleName()%> <%=masEmployee.getLastName()%></option>
	<%
						}
					%>
</select> <input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
