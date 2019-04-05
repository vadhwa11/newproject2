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
			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String date1 = (String)utilMap.get("currentDate");	 
			String time = (String)utilMap.get("currentTime");
			   List<Birthdeathreg> deathList = new ArrayList<Birthdeathreg>();
			   List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			   if(map.get("employeeList") !=null){
				   employeeList=(List<MasEmployee>)map.get("employeeList");
			   }
			   try{
				   deathList=(List)map.get("deathList");
					
				}catch(Exception e){
					e.printStackTrace();
				}
				String serviceNo ="";
				String hinNo ="";
				String adNo="";
				String ptName ="";
				String gender="";
				String dod ="";
				String mName ="";
				String fName="";
				int noOfCopies =0;
				int amount =0;
				String regDate="";
				int empId =0;
				String address ="";
				String permanentAddress ="";
				Birthdeathreg birthdeathreg =null;
				String doi ="";
				String remarks="";
				String deathTime ="";
				int birthDeathId =0;
				int inpatientId =0;
		     	if (deathList!=null && deathList.size() > 0 ) {
		     		 birthdeathreg = (Birthdeathreg)deathList.get(0);
		     	if(birthdeathreg.getHin() !=null)
		     		{
		     		birthDeathId =birthdeathreg.getId();
		     		serviceNo =birthdeathreg.getHin().getServiceNo();
		     		hinNo =birthdeathreg.getHin().getHinNo();
		     		if(birthdeathreg.getName() !=null)
		     		ptName =birthdeathreg.getName();
		     		if(birthdeathreg.getMname() !=null)
		     		mName =birthdeathreg.getMname();
		     		if(birthdeathreg.getFname()  !=null)
		     		fName =birthdeathreg.getFname();
		     		if(birthdeathreg.getAddressDeath() !=null)
		     		address =birthdeathreg.getAddressDeath();
		     		if(birthdeathreg.getRemarks() !=null)
		     		remarks =birthdeathreg.getRemarks();
		     		if(birthdeathreg.getAddressPermanent() !=null)
		     		permanentAddress =birthdeathreg.getAddressPermanent();
		     		if( birthdeathreg.getHin().getSex() !=null)
		     		gender = birthdeathreg.getHin().getSex().getAdministrativeSexName();
		     		if(birthdeathreg.getDod() != null && !birthdeathreg.getDod().equals(""))
		     		dod =HMSUtil.changeDateToddMMyyyy(birthdeathreg.getDod());
		     		if(birthdeathreg.getNoOfCopies() !=null && !birthdeathreg.getNoOfCopies().equals(""))
		     		noOfCopies =Integer.parseInt(""+birthdeathreg.getNoOfCopies());
		     		if(birthdeathreg.getAmount() !=null && !birthdeathreg.getAmount().equals(""))
		     		amount =Integer.parseInt(""+birthdeathreg.getAmount());
		     		
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
		     		deathTime =birthdeathreg.getTime();
			String userName = "";
			if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
			}
			%>
<div class="blockFrame"><label><span>*</span> Service
No.:</label> <input type="text" id="serviceNo." name="<%=SERVICE_NO%>"
	value="<%=serviceNo %>" readonly="readonly" MAXLENGTH="30" />
<div id="hinDiv"><label><span>*</span> Hin:</label> <input
	type="text" name="<%=HIN_NO%>" value="<%=hinNo %>" readonly="readonly"
	MAXLENGTH="30" validate="Hin,,yes" /></div>

<label><span>*</span> Ad No:</label> <input type="text" id="frwSlno"
	name="<%=INPATIENT_ID%>" readonly="readonly" value="<%=adNo %>"
	MAXLENGTH="30" validate="Admission No,,yes" />
<div class="Clear"></div>

<div id="deathDiv"><label>Patient Name:</label> <input
	id="patientId" type="text" name="<%=PATIENT_NAME %>"
	value="<%=ptName %>" title="Patient Name"
	validate="Patient Name,String ,yes" MAXLENGTH="50" /> <label>Gender:</label>
<input id="gender" type="text" name="<%=SEX %>" value="<%=gender %>"
	title="Gender" readonly="readonly" validate="Gender,string,yes"
	MAXLENGTH="15" /> <label>Date of Death:</label> <input type="text"
	id="deathDateId" name="<%=DATE_OF_DEATH %>" value="<%=dod%>"
	class="calDate" readonly="readonly" validate="Date Of Death ,date,no" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.fatalDocumentPanchnamaReport.<%=DATE_OF_DEATH%>,event)" />

<div class="Clear"></div>

<label>Time of Death:</label> <input id="gender" type="text"
	name="<%=TIME %>" value="<%=deathTime %>" validate="Time,string,yes"
	MAXLENGTH="15"
	onblur="checkTime('fatalDocumentPanchnamaReport','<%=TIME%>')" /> <label>Mother's
Name:</label> <input id="motherId" type="text" name="<%=MOTHER_NAME %>"
	value="<%=mName %>" title="Mother Name"
	validate="Mother Name,String,yes" MAXLENGTH="50" /> <label>Father's
Name:</label> <input id="fatherId" type="text" name="<%=FATHER_NAME %>"
	value="<%=fName %>" title="Father Name"
	validate="Father Name,String,yes" MAXLENGTH="50" />

<div class="Clear"></div>
<div class="Height10"></div>

<label>Address of the deceased at the time of death:</label> <textarea
	name="<%=ADDRESS1%>" cols="20" rows="2" tabindex="2"
	validate="Address,string,no" class="large"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"><%=address %></textarea>

<div class="Clear"></div>
<div class="Height10"></div>

<label>Permanent address of deceased:</label> <textarea
	name="<%=ADDRESS2%>" cols="20" rows="2" tabindex="2"
	validate="Address,string,no" class="large"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"><%=permanentAddress %></textarea>
<div class="Clear"></div>
<div class="Height10"></div>



<label>Date Of Registration:</label> <input type="text" id="regDateId"
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
	name="<%=NO_OF_COPIES %>" value="<%=noOfCopies%>"
	validate="No of Copies,num,no" MAXLENGTH="15" />

<div class="Clear"></div>

<label>Amount:</label> <input id="fatherId" type="text"
	name="<%=AMOUNT %>" value="<%=amount%>" validate="No of Copies,num,no"
	MAXLENGTH="15" /> <label>Remarks:</label> <input id="fatherId"
	type="text" name="<%=REMARKS %>" value="<%=remarks %>" title="Remarks"
	MAXLENGTH="15" /> <input type="hidden" name="<%=BIRTHDEATHID %>"
	value="<%=birthDeathId %>" /> <label>Authenticated Employee:</label>
<select id="employeeId" name="<%=EMPLOYEE_ID %>">
	<option value="0">Select</option>

	<%
							for (MasEmployee employee : employeeList) {
								if(employee.getId() ==empId){
						%>
	<option value="<%=employee.getId()%>" selected="selected"><%=employee.getFirstName()%>
	<%=employee.getMiddleName()%> <%=employee.getLastName()%></option>
	<%}else{ %>
	<option value="<%=employee.getId()%>"><%=employee.getFirstName()%>
	<%=employee.getMiddleName()%> <%=employee.getLastName()%></option>
	<%} %>
	<%
						}
					%>
</select>

<div class="Clear"></div>

</div>
</div>
<div class="Clear"></div>
<input type="button" name="Submit" value="Submit" class="button"
	onClick="submitForm('fatalDocumentPanchnamaReport','mis?method=submitUpdateDeathCertificate');" />
<input type="hidden" name="ipId" value="<%=inpatientId%>" />
<%}else{ %>
<label class="noWidth"><span>No Records Found</span></label>
<div class="Clear"></div>
<%} %>
<div class="Clear"></div>

