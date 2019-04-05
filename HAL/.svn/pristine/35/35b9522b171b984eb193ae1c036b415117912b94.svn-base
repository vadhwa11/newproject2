<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * registration.jsp  
 * Purpose of the JSP -  This is for Death Certificate.
 * @author  Dipali
 * Create Date: 23rd April,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.36
--%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
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
<script type="text/javascript">


 function checkValidation(){

	if(document.getElementById("regDateId").value == document.getElementById("deathDateId").value){
			return true;
	}else{
			alert("Date Of Death and Date Of Registration should be same")
			return false;
		}
 }
function autoFill(){
	document.getElementById("regDateId").value =document.getElementById("deathDateId").value
}
</script>
<div class="titleBg"><h2>Death Certificate</h2></div>
<%  	
			
			Map<String, Object> map = new HashMap<String, Object>();
			if(request.getAttribute("map") != null){
				map=(Map<String, Object>)request.getAttribute("map");
			}
			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String date1 = (String)utilMap.get("currentDate");	 
			String time = (String)utilMap.get("currentTime");
			 List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
			 List<MasEmployee> employeeList = new ArrayList<MasEmployee>();

			   try{
					inPatientDetailList=(List)map.get("showList");
					
				}catch(Exception e){
					e.printStackTrace();
				}
			String userName = "";
			if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
			}
			List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
			if(map.get("sexList") != null){
				sexList = (List<MasAdministrativeSex>)map.get("sexList");
			}
			if(map.get("employeeList")!=null)
			{
				employeeList=(List)map.get("employeeList");
			}
    %> <script>
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
<div class="Clear"></div>
<form name="fatalDocumentPanchnamaReport" method="post" action="">
<div class="Block"><label><span>*</span> Service
No.</label> <input type="text" id="serviceNo." name="<%=SERVICE_NO%>" value=""
	MAXLENGTH="30"
	onblur="getHinNo('fatalDocumentPanchnamaReport','mis?method=getExpiredAdmissionNumberList&flag=hin')" />
<div id="hinDiv"><label><span>*</span> HIN</label>
<input	type="text" name="<%=HIN_NO%>" value="" MAXLENGTH="30"	validate="Hin,,yes"	onchange="submitProtoAjaxWithDivName('fatalDocumentPanchnamaReport','mis?method=getExpiredAdmissionNumberList&flag=admission','testDiv')" />
</div>
<div id="testDiv"><label><span>*</span> Ad No.</label>
<input	type="text" id="frwSlno" name="<%=INPATIENT_ID%>" value=""	MAXLENGTH="30" validate="Admission No,,yes" /></div>
<div class="Clear"></div>
<div id="deathDiv"><label>Patient Name</label> <input
	id="patientId" type="text" name="<%=PATIENT_NAME %>" value=""
	title="Patient Name" validate="Patient Name,name,yes" MAXLENGTH="39" />
<label>Gender</label> <input id="gender" type="text" name="<%=SEX %>"
	value="" title="Gender" validate="Gender,string,yes" MAXLENGTH="15" />
<label>Date of Death</label> <input type="text" id="deathDateId"
	name="<%=DATE_OF_DEATH %>" value="" class="calDate" readonly="readonly"
	validate="Date Of Death ,date,no" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('',document.fatalDocumentPanchnamaReport.<%=DATE_OF_DEATH%>,event)" />
<div class="Clear"></div>
<label>Time of Death</label> <input id="gender" type="text"
	name="<%=TIME %>" value="" title="Gender" validate="Gender,string,yes"
	MAXLENGTH="15" /> <label>Mother's Name</label> <input id="motherId"
	type="text" name="<%=MOTHER_NAME %>" value="" title="Mother Name"
	validate="Mother Name,name,yes" MAXLENGTH="39" /> <label>Father's
Name</label> <input id="fatherId" type="text" name="<%=FATHER_NAME %>" value=""
	title="Father Name" validate="Father Name,name,yes" MAXLENGTH="39" />
<div class="Clear"></div>
<div class="Height10"></div>

<label>Address of the deceased at the time of death</label> <textarea
	name="<%=ADDRESS1%>" cols="20" rows="2" tabindex="2"
	validate="Address,string,no" class="large"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
<div class="Clear"></div>
<div class="Height10"></div>
<label>Permanent address of deceased</label> <textarea
	name="<%=ADDRESS2%>" cols="20" rows="2" tabindex="2"
	validate="Address,string,no" class="large"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
<div class="Clear"></div>
<div class="Height10"></div>

<label>Date of Registration</label> <input type="text" id="regDateId"
	name="<%=REG_DATE %>" value="" class="calDate" readonly="readonly"
	validate="Date Of Registration,date,no" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('',document.fatalDocumentPanchnamaReport.<%=REG_DATE%>,event)" />

<label>Date of Issuing</label> <input type="text" id="regDateId"
	name="<%=ISSUE_DATE %>" value="" class="calDate" readonly="readonly"
	validate="Date Of Registration,date,no" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('',document.fatalDocumentPanchnamaReport.<%=ISSUE_DATE%>,event)" />


<label><span>*</span> Registration No.</label> <input id="fatherId"
	type="text" name="<%=REG_NO %>" value="" title="Registration No."
	onblur="checkRegNo(this.value);" MAXLENGTH="15" />

<div class="Clear"></div>

<label>No of Copies</label> <input id="fatherId" type="text"
	name="<%=NO_OF_COPIES %>" value="" validate="No of Copies,num,no"
	MAXLENGTH="15" /> <label>Amount</label> <input id="fatherId"
	type="text" name="<%=AMOUNT %>" value="" validate="No of Copies,num,no"
	MAXLENGTH="15" /> <label>Remarks</label> <input id="fatherId"
	type="text" name="<%=REMARKS %>" value="" title="Remarks"
	MAXLENGTH="15" />
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
</select></div>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date1%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="Clear"></div>
<input type="button" name="Submit" value="Submit" class="button"
	onClick="if(checkValidation()){submitForm('fatalDocumentPanchnamaReport','mis?method=submitDeathCertificate');}" />

</form>
<div class="Clear"></div>

