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
	String regNo="";
	int serNo =0;
	String motherName="";
	String fatherName="";
	if(request.getAttribute("map") != null){
		map=(Map<String, Object>)request.getAttribute("map");
	}
	
	List<Inpatient> inpatientList = new ArrayList<Inpatient>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	
	try{
		if(map.get("inpatientList")!=null)
		{
			inpatientList=(List<Inpatient>)map.get("inpatientList");
		}
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
	Inpatient inpatient = new Inpatient();
	System.out.print("inPatientDetailList   "+inpatientList.size());
	 if(inpatientList != null && inpatientList.size()>0)
	   {
			 inpatient = inpatientList.get(0);
		 }
		   
		   String patientName="";
		   if(inpatient.getHin() !=null){
			   patientName =inpatient.getHin().getPFirstName()+" "+inpatient.getHin().getPMiddleName()+" "+inpatient.getHin().getPLastName();
		   }
 %>
<div id="deathDiv"><label>Patient Name:</label> <input
	id="patientId" type="text" name="<%=PATIENT_NAME %>"
	value="<%=patientName %>" title="Patient Name"
	validate="Patient Name,String,no" MAXLENGTH="50" /> <input
	type="hidden" id="frwSlno" name="<%=HIN_ID%>"
	value="<%=inpatient.getHin().getId()%>" MAXLENGTH="30" /> <input
	type="hidden" id="frwSlno" name="<%=SEX_ID%>"
	value="<%=inpatient.getHin().getSex().getId()%>" MAXLENGTH="30" /> <input
	type="hidden" name="serNo" value="<%=serNo%>" MAXLENGTH="30" /> <label>Gender:</label>
<%if(inpatient.getHin().getSex() != null){ %> <input id="genderId"
	type="text" name="<%=SEX%>"
	value="<%=inpatient.getHin().getSex().getAdministrativeSexName() %>"
	title="Patient Name" validate="Gender,string,yes" MAXLENGTH="15" /> <%}else{ %>
<input type="text" name="<%=SEX%>" size="2" value="" /> <%} %> <label>Date
of Death:</label> <input type="text" id="deathDateId" name="<%=DATE_OF_DEATH %>"
	value="" class="calDate" readonly="readonly"
	validate="DDate Of Death,date,no" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('',document.fatalDocumentPanchnamaReport.<%=DATE_OF_DEATH%>,event)" />

<div class="Clear"></div>

<label>Time of Death:</label> <input id="gender" type="text"
	name="<%=TIME %>" value="" title="Gender" validate="Time,string,yes"
	MAXLENGTH="15"
	onblur="checkTime('fatalDocumentPanchnamaReport','<%=TIME%>')" /> <label>Mother's
Name:</label> <input id="motherId" type="text" name="<%=MOTHER_NAME %>"
	value="<%=motherName%>" title="Mother Name"
	validate="Mother Name,String,no" MAXLENGTH="50" /> <label>Father's
Name:</label> <input id="fatherId" type="text" name="<%=FATHER_NAME %>"
	value="<%=fatherName %>" title="Father Name"
	validate="Father Name,String,no" MAXLENGTH="50" />

<div class="Clear"></div>
<div class="Height10"></div>

<label>Address of the deceased at the time of death:</label> <textarea
	name="<%=ADDRESS1%>" cols="20" rows="2" tabindex="2"
	validate="Address,string,no" class="large"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>

<div class="Clear"></div>
<div class="Height10"></div>

<label>Permanent address of deceased:</label> <%if(inpatient.getHin().getAddress() != null){ %>
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

<label>Date of Registration:</label> <%if(inpatient.getHin().getRegDate() != null){ %>
<input type="text" id="regDateId" name="<%=REG_DATE %>"
	value="<%=HMSUtil.changeDateToddMMyyyy(inpatient.getHin().getRegDate()) %>"
	validate="Date Of Registration,date,no" /> <%}else{ %> <input
	type="text" name="<%=REG_DATE %>" size="2" value="" id="regDateId" /> <%} %>

<label>Date of Issuing:</label> <input type="text" id="regDateId"
	name="<%=ISSUE_DATE %>" value="" class="calDate" readonly="readonly"
	validate="Date Of Registration,date,no" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('',document.fatalDocumentPanchnamaReport.<%=ISSUE_DATE%>,event)" />

<label><span>*</span> Registration No.:</label> <input id="regId"
	type="text" name="<%=REG_NO %>" value="<%=regNo %>"
	validate="Registration No,String,yes" title="Registration No."
	onblur="checkRegNo(this.value,'death');" MAXLENGTH="15" />

<div class="Clear"></div>

<label>No of Copies:</label> <input id="fatherId" type="text"
	name="<%=NO_OF_COPIES %>" value="" validate="No of Copies,num,no"
	MAXLENGTH="15" /> <label>Amount:</label> <input id="fatherId"
	type="text" name="<%=AMOUNT %>" value="" validate="No of Copies,num,no"
	MAXLENGTH="15" /> <label>Remarks:</label> <input id="fatherId"
	type="text" name="<%=REMARKS %>" value="" title="Remarks"
	MAXLENGTH="15" />
<div class="Clear"></div>
<label>Authenticated Employee:</label> <select id="employeeId"
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
<div class="Clear"></div>