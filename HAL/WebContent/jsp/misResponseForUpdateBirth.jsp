<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * registration.jsp  
 * Purpose of the JSP -  This is for Birth Certificate.
 * @author  Dipali
 * Create Date: 23rd April,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.36
--%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Birthdeathreg"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>

<%  	
			
			Map<String, Object> map = new HashMap<String, Object>();
			if(request.getAttribute("map") != null){
				map=(Map<String, Object>)request.getAttribute("map");
			}
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			if(map.get("employeeList") != null){
				employeeList=(List<MasEmployee>)map.get("employeeList");
			}
			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String date1 = (String)utilMap.get("currentDate");	 
			String time = (String)utilMap.get("currentTime");
			   List<Birthdeathreg> birthList = new ArrayList<Birthdeathreg>();

			   try{
				   birthList=(List)map.get("birthList");
					
				}catch(Exception e){
					e.printStackTrace();
				}
			String userName = "";
			if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
			}
			%>
<div id="test">
<% 
			String birthTime ="";
			String serviceNo ="";
			String hinNo ="";
			String adNo="";
			String ptName ="";
			String gender="";
			String dob ="";
			String mName ="";
			String fName="";
			int noOfCopies =0;
			int amount =0;
			String regDate="";
			int empId =0;
			int bdId =0;
			int inpatientId =0;
			String remarks="";
			String address ="";
			String permanentAddress ="";
			String doi ="";
			Birthdeathreg birthdeathreg =null;
	     	if (birthList!=null && birthList.size() > 0 ) {
	     		 birthdeathreg = (Birthdeathreg)birthList.get(0);
	     	if(birthdeathreg.getHin() !=null)
	     		
	     	{	serviceNo =birthdeathreg.getHin().getServiceNo();
	     		bdId =birthdeathreg.getId();
	     		hinNo =birthdeathreg.getHin().getHinNo();
	     		ptName =birthdeathreg.getName();
	     		mName =birthdeathreg.getMname();
	     		fName =birthdeathreg.getFname();
	     		gender = birthdeathreg.getHin().getRelation().getRelationName();
	     		if(birthdeathreg.getDob() != null && !birthdeathreg.getDob().equals(""))
	     		dob =HMSUtil.changeDateToddMMyyyy(birthdeathreg.getDob());
	     		if(birthdeathreg.getNoOfCopies() !=null && !birthdeathreg.getNoOfCopies().equals(""))
	     		noOfCopies =Integer.parseInt(""+birthdeathreg.getNoOfCopies());
	     		if(birthdeathreg.getAmount() !=null && !birthdeathreg.getAmount().equals(""))
	     		amount =Integer.parseInt(""+birthdeathreg.getAmount());
	     		if(birthdeathreg.getAddressDeath() !=null)
		     	address =birthdeathreg.getAddressDeath();
		     	if(birthdeathreg.getRemarks() !=null)
		     	remarks =birthdeathreg.getRemarks();
		     	if(birthdeathreg.getAddressPermanent() !=null)
		     	permanentAddress =birthdeathreg.getAddressPermanent();
		     	if(birthdeathreg.getDateOfIssue() != null && !birthdeathreg.getDateOfIssue().equals(""))
	     		doi =HMSUtil.changeDateToddMMyyyy(birthdeathreg.getDateOfIssue());
	     	}
	     	if(birthdeathreg.getDor() != null && !birthdeathreg.getDor().equals(""))
	     		regDate =HMSUtil.changeDateToddMMyyyy(birthdeathreg.getDor());
	     	if(birthdeathreg.getEmp() !=null)
	     		empId =birthdeathreg.getEmp().getId();
	     	if(birthdeathreg.getInpatient() !=null)
	     		adNo =birthdeathreg.getInpatient().getAdNo();
	     	if(birthdeathreg.getInpatient() !=null)
	     		inpatientId =birthdeathreg.getInpatient().getId();
	     	if(birthdeathreg.getTime() !=null)
	     		birthTime =birthdeathreg.getTime();
			%>

<div class="blockFrame"><label><span>*</span> Service No.:</label>
<input type="text" id="serviceNo." name="<%=SERVICE_NO%>"
	value="<%=serviceNo %>" readonly="readonly" MAXLENGTH="30" />
<div id="hinDiv"><label><span>*</span> Hin:</label> <input
	type="text" name="<%=HIN_NO%>" value="<%=hinNo%>" MAXLENGTH="30"
	readonly="readonly" /></div>
<div id="testDiv1"><label><span>*</span> Admission No:</label> <input
	type="text" id="frwSlno" name="<%=INPATIENT_ID%>" value="<%=adNo %>"
	MAXLENGTH="30" validate="Admission No,,yes" readonly="readonly" /></div>

<div class="Clear"></div>

<div id="birthDiv"><label>Patient Name:</label> <input
	id="patientId" type="text" name="<%=PATIENT_NAME %>"
	value="<%=ptName%>" title="Patient Name"
	validate="Patient Name,string,yes" MAXLENGTH="50" /> <label>Gender:</label>
<input id="gender" type="text" name="<%=SEX %>" value="<%=gender %>"
	title="Gender" validate="Gender,string,yes" MAXLENGTH="15"
	readonly="readonly" /> <label>Date of Birth:</label> <input
	type="text" id="birthDateId" name="<%=DATE_OF_BIRTH %>"
	value="<%=dob %>" class="calDate" readonly="readonly"
	validate="Date Of Birth,date,no" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('',document.fatalDocumentPanchnamaReport.<%=DATE_OF_BIRTH%>,event)" />

<div class="Clear"></div>

<label>Time of Birth:</label> <input id="gender" type="text"
	name="<%=TIME %>" value="<%=birthTime %>" validate="Time,string,yes"
	MAXLENGTH="15"
	onblur="checkTime('fatalDocumentPanchnamaReport','<%=TIME%>')" /> <label>Mother's
Name:</label> <input id="motherId" type="text" name="<%=MOTHER_NAME %>"
	value="<%=mName %>" title="Mother Name"
	validate="Mother Name,String,yes" MAXLENGTH="39" /> <label>Father's
Name:</label> <input id="fatherId" type="text" name="<%=FATHER_NAME %>"
	value="<%=fName %>" title="Father Name"
	validate="Father Name,String,yes" MAXLENGTH="39" />

<div class="Clear"></div>
<div class="Height10"></div>
<label>Address of Parents at the time of birth of the child:</label> <textarea
	name="<%=ADDRESS1%>" cols="20" rows="2" tabindex="2"
	validate="Address,string,no" class="large"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"><%=address %></textarea>
<div class="Clear"></div>
<div class="Height10"></div>
<label>Permanent address of parents:</label> <textarea
	name="<%=ADDRESS2%>" cols="20" rows="2" tabindex="2"
	validate="Address,string,no" class="large"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"><%=permanentAddress %></textarea>
<div class="Clear"></div>
<div class="Height10"></div>
<label>Date of Registration:</label> <input type="text" id="regDateId"
	name="<%=REG_DATE %>" value="<%=regDate %>" class="calDate"
	readonly="readonly" validate="Date Of Registration,date,no" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.fatalDocumentPanchnamaReport.<%=REG_DATE%>,event)" />

<label>Date of Issuing:</label> <input type="text" id="regDateId"
	name="<%=ISSUE_DATE %>" value="<%=doi%>" class="calDate"
	readonly="readonly" validate="Date Of Registration,date,no" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.fatalDocumentPanchnamaReport.<%=ISSUE_DATE%>,event)" />

<label>No of Copies:</label> <input id="fatherId" type="text"
	name="<%=NO_OF_COPIES %>" value="<%=noOfCopies %>"
	validate="No of Copies,num,no" MAXLENGTH="50" />

<div class="Clear"></div>

<label>Amount:</label> <input id="fatherId" type="text"
	name="<%=AMOUNT %>" value="<%=amount %>" validate="No of Copies,num,no"
	MAXLENGTH="15" /> <label>Remarks:</label> <input id="fatherId"
	type="text" name="<%=REMARKS %>" value="<%=remarks %>" title="Remarks"
	MAXLENGTH="15" /> <label>Authenticated Employee:</label> <select
	id="employeeId" name="<%=EMPLOYEE_ID %>">
	<option value="0">Select</option>
	<%
							for (MasEmployee masEmployee : employeeList) {
								if(empId==masEmployee.getId()){
						%>
	<option value="<%=masEmployee.getId()%>" selected="selected"><%=masEmployee.getFirstName()%>
	<%=masEmployee.getMiddleName()%> <%=masEmployee.getLastName()%></option>
	<%}else{ %>
	<option value="<%=masEmployee.getId()%>"><%=masEmployee.getFirstName()%>
	<%=masEmployee.getMiddleName()%> <%=masEmployee.getLastName()%></option>
	<%} %>
	<%
						}
					%>
</select></div>
<input type="hidden" name="<%=BIRTHDEATHID%>" value="<%=bdId%>" /> <input
	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date1%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input
	type="hidden" name="ipId" value="<%=inpatientId%>" /></div>
<div class="Clear"></div>
<input type="button" name="Submit" value="Submit" class="button"
	onClick="if(checkValidation()){submitForm('fatalDocumentPanchnamaReport','mis?method=submitUpdateBirthCertificate');}" />
<%}else{%> <label class="noWidth"><span>No Records Found</span></label> <%}%>