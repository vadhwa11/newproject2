<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * investigationAppointments.jsp  
 * Purpose of the JSP -  This is for Appointment Setup Screen.
 * @author  Priyanka
 * Create Date: 10th july,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.2  
--%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@ page import="static jkt.hms.util.RequestConstants.EMPLOYEE_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.PRESCRIPTION_DATE"%>
<%@ page import="static jkt.hms.util.RequestConstants.PRESCRIPTION_TIME"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_DATE"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_TIME"%>
<%@ page import="static jkt.hms.util.RequestConstants.PRESCRIPTION_NO"%>

<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>
 
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js?n=1"></script>
<!--By Vishnu  -->
<title>Waiting List For Surgery</title>

<% 
Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String currentDate = (String) utilMap.get("currentDate");
String currentTime = (String) utilMap.get("currentTime");
Map map = new HashMap();
int waitingCount = 0;
//String includedJsp = null;
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
List<OpdSurgeryHeader> pacList = new ArrayList<OpdSurgeryHeader>();
List sexList = new ArrayList();

if (map.get("pacList") != null) {
	pacList = (List) map.get("pacList");
}

if (map.get("sexList") != null) {
	sexList = (List) map.get("sexList");
}
 String userName = "";
if (session.getAttribute("userName") != null) {
	userName = (String) session.getAttribute("userName");
} 
			 

List patientList = new ArrayList();
int totalPatient=0;
if(map.get("patientList") != null)
{
	patientList=(List)map.get("patientList");
}
System.out.println("000daf 0"+patientList.size());
%>

<script	type="text/javascript" language="javascript">
	<%

	
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String getDate=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(getDate.length()<2){
		getDate="0"+getDate;
	}

%>
serverdate = '<%=getDate+"/"+month+"/"+year%>'

	


		
	</script>


<div class="clear"></div>
<div class="titleBg">
<h2>Pending List For Surgery Scheduling</h2>
</div>
<div class="clear"></div>


<div class="clear"></div>
<div class="Clear"></div>

<%-- <h4><span><%=message%></span></h4> --%>
<form name="search" action="" method="post">
<div class="Block">
<div class="clear"></div> 
<title>PAC Clearance List</title>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<!-- <label>HIN</label> <input type="text" id="uhid" name="uhid"  maxlength="15"> --></input>
 <label>Patient Name</label> <input type="text" id="pname" name="pname" maxlength="20"></input>
<!-- <label>IP No.</label> <input type="text" id="ipno" name="ipno" maxlength="20"></input> -->
<label>Employee No</label> <input type="text"  name="<%=EMPLOYEE_ID%>" maxlength="20"></input>
<label>Gender</label> 

 <div class="clear"></div>
	<input type="button" name="Search" value="Search" class="button"
		onClick="submitForm('search','/hms/hms/ot?method=showPACClearanceList');" />
		
		<input type="button" name="Reset" value="Reset" class="button"
		onClick="submitForm('search','/hms/hms/ot?method=showPACClearanceList');" />
 </div>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
 </form>

<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults">
<div id="searchtable"></div>
<form name="emergencyOPDWaitingList" method="post" action="">
<script type="text/javascript">
	formFields = [
		[0, "surgeryId", "id"],[1,"<%=PRESCRIPTION_NO%>"],[2,"<%=PRESCRIPTION_DATE%>"],[3,"<%=PRESCRIPTION_TIME%>"],[4,"hin"],[5,"serviceType"],[6,"serNo"],[7,"sPerName"],[8,"relation"],[9,"patName"], [10,"age"], [11,"sex"],[12,"pType"],[13,"doct"]];
		statusTd = 13;
	</script></form>


<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=currentTime%>" />
</div>

<script type="text/javascript" language="javascript">

data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = " "
data_header[0][1] = "hide";
data_header[0][2] = "5%";
data_header[0][3] = "<%= RequestConstants.RADIO_FOR_TABLE%>"

data_header[1] = new Array;
data_header[1][0] = "Priority"
data_header[1][1] = "hide";
data_header[1][2] = "10%";
data_header[1][3] = "Priority";

data_header[2] = new Array;
data_header[2][0] = "Token No."
data_header[2][1] = "hide";
data_header[2][2] = "8%";
data_header[2][3] = "<%= RequestConstants.TOKEN_NO%>"

data_header[3] = new Array;
data_header[3][0] = "Visit Date"
data_header[3][1] = "hide";
data_header[3][2] = "5%";
data_header[3][3] = "<%=RequestConstants.VISIT_DATE %>";

data_header[4] = new Array;
data_header[4][0] = "Visit Time"
data_header[4][1] = "hide";
data_header[4][2] = "6%";
data_header[4][3] = "<%=RequestConstants.VISIT_TIME %>";

data_header[5] = new Array;
data_header[5][0] = "HIN No."
data_header[5][1] = "hide";
data_header[5][2] = "5%";
data_header[5][3] = "<%=RequestConstants.HIN_NO %>";

data_header[6] = new Array;
data_header[6][0] = "Appointment Type"
data_header[6][1] = "hide";
data_header[6][2] = "5%";
data_header[6][3] = "<%=RequestConstants.APPOINTMENT_TYPE %>";

data_header[7] = new Array;
data_header[7][0] = "Employee No."
data_header[7][1] = "data";
data_header[7][2] = "10%";
data_header[7][3] = "<%=RequestConstants.SERVICE_NO %>";

data_header[8] = new Array;
data_header[8][0] = "Patient Name"
data_header[8][1] = "data";
data_header[8][2] = "10%";
data_header[8][3] = "<%=RequestConstants.PATIENT_NAME %>";

data_header[9] = new Array;
data_header[9][0] = "Relation"
data_header[9][1] = "data";
data_header[9][2] = "10%";
data_header[9][3] = "<%=RequestConstants.RELATION %>";

data_header[10] = new Array;
data_header[10][0] = "Service No."
data_header[10][1] = "hide";
data_header[10][2] = "10%";
data_header[10][3] = "<%=RequestConstants.SERVICE_NO %>";

data_header[11] = new Array;
data_header[11][0] = "Designation"
data_header[11][1] = "data";
data_header[11][2] = "10%";
data_header[11][3] = "<%=RequestConstants.RANK %>";

data_header[12] = new Array;
data_header[12][0] = "Name"
data_header[12][1] = "data";
data_header[12][2] = "10%";
data_header[12][3] = "<%=RequestConstants.SERVICE_PERSON_NAME %>";

data_header[13] = new Array;
data_header[13][0] = "Age"
data_header[13][1] = "data";
data_header[13][2] = "6%";
data_header[13][3] = "<%=RequestConstants.AGE %>";

data_header[14] = new Array;
data_header[14][0] = "Gender"
data_header[14][1] = "data";
data_header[14][2] = "1%";
data_header[14][3] = "<%=RequestConstants.SEX%>";

data_header[15] = new Array;
data_header[15][0] = "Diagnosis"
data_header[15][1] = "hide";
data_header[15][2] = "10%";
data_header[15][3] = "<%=RequestConstants.DIAGNOSIS_ID %>";

data_header[16] = new Array;
data_header[16][0] = "I-Card Status"
data_header[16][1] = "hide";
data_header[16][2] = "1%";
data_header[16][3] = "<%=RequestConstants.I_CARD_VERIFIED %>";

data_header[17] = new Array;
data_header[17][0] = "Detained"
data_header[17][1] = "hide";
data_header[17][2] = "10%";
data_header[17][3] = "<%=RequestConstants.I_CARD_VERIFIED %>";
data_header[17][4] = "10%";

data_header[18] = new Array;
data_header[18][0] = "Visit Number"
data_header[18][1] = "hide";
data_header[18][2] = "10%";
data_header[18][3] = "<%= RequestConstants.VISIT_NUMBER %>";
data_header[18][4] = "10%";

data_header[19] = new Array;
data_header[19][0] = "Action"
data_header[19][1] = "data";
data_header[19][2] = "6%";

data_header[20] = new Array;
data_header[20][0] = "Action"
data_header[20][1] = "hide";
data_header[20][2] = "6%";

data_arr = new Array();
<%
int  i=0;
try{
String st="";


Iterator iterator=patientList.iterator();
while(iterator.hasNext())
{
Visit visit= (Visit) iterator.next();
/* if(visit.getVisitStatus().equalsIgnoreCase("w"))
{ */
Patient patientHin=(Patient)visit.getHin();
MasDepartment deptObj=(MasDepartment)visit.getDepartment();
String servicepatientName="";
if(visit.getHin().getPFirstName()!= null){
	servicepatientName=visit.getHin().getSFirstName();
}
if(visit.getHin().getSMiddleName()!= null){
	servicepatientName=servicepatientName+" "+visit.getHin().getSMiddleName();
}
if(visit.getHin().getSLastName()!= null)
{
	servicepatientName=servicepatientName+" "+visit.getHin().getSLastName();
}

MasAdministrativeSex masAdministrativeSex=patientHin.getSex();
String visitDate =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
%>

data_arr[<%= i%>] = new Array();

data_arr[<%= i%>][0] =<%=visit.getId()%>

data_arr[<%= i%>][1] = '<input type="radio" class="radiogrid" name="parent" value="<%= visit.getId()%>" id="parent" />'

<%
if(visit.getPriority()!=null){
	
	%>
		data_arr[<%= i%>][2] ="<%=visit.getPriority()%>"
			<%
	}else{
			%>
			data_arr[<%= i%>][2] ="0"
	<%
}
if(visit.getTokenNo()!=null)
{
%>
data_arr[<%= i%>][3] = "<%=visit.getTokenNo()%>"
<%
}else{
%>
data_arr[<%= i%>][3] = ""
<%
}

if(visit.getVisitDate()!= null )
{
%>
data_arr[<%= i%>][4] = "<%=visitDate%>"
<%
}else{
%>
data_arr[<%= i%>][4] = ""
<%
}if(visit.getVisitTime()!= null || visit.getVisitTime()!= "")
{
%>
data_arr[<%= i%>][5] = "<%=visit.getVisitTime()%>"
<%
}else{
%>
data_arr[<%= i%>][5] = ""
<%
}
if(visit.getHin().getHinNo()!= null ||visit.getHin().getHinNo() != "")
{
%>
data_arr[<%= i%>][6] = "<%=visit.getHin().getHinNo()%>"
<%
}else{
%>
data_arr[<%= i%>][6] = ""
<%
}
if(visit.getAppointmentType() != null || visit.getAppointmentType() !="")
{
%>
data_arr[<%= i%>][7] = "<%=visit.getAppointmentType()%>"
<%
}else{
%>
data_arr[<%= i%>][7] = ""
	<%}%>
	<%
if(visit.getHin().getServiceNo()!= null )
{
%>
data_arr[<%= i%>][8] = '<%= visit.getHin().getServiceNo()%>'
<%
}else{
%>
data_arr[<%= i%>][8] = ''
 <%}%>
 <%
	if(visit.getHin().getServiceNo()!= null )
	{
	%>
	data_arr[<%= i%>][8] = "<%=visit.getHin().getServiceNo()%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][8] = ""
  <%}%>
  <%
	if(visit.getHin().getPFirstName()!= null )
	{
		String fname=visit.getHin().getPFirstName();
		if(visit.getHin().getPMiddleName()!=null)
		{
			fname+=" "+visit.getHin().getPMiddleName();
		}
		if(visit.getHin().getPLastName()!=null)
		{
			fname+=" "+visit.getHin().getPLastName();
		}
	%>
	data_arr[<%= i%>][9] = "<%=fname%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][9] = ""
    <%}%>

	<%

if(visit.getHin().getRelation().getNewRelationName()!= null )
{
%>
data_arr[<%= i%>][10] = "<%=visit.getHin().getRelation().getNewRelationName()%>"
<%
}else{
%>
data_arr[<%= i%>][10] = ""

	<%}%>

	<%
	if(visit.getHin().getServiceNo()!= null )
	{
	%>
	data_arr[<%= i%>][11] ='<%= visit.getHin().getServiceNo()%>'
	<%
	}else{
	%>
	data_arr[<%= i%>][11] = ''
     <%}%>
     <%
 	if(visit.getHin().getServiceNo()!= null )
 	{
 	%>
 	data_arr[<%= i%>][11] = "<%=visit.getHin().getServiceNo()%>"
 	<%
 	}else{
 	%>
 	data_arr[<%= i%>][11] = ""
      <%}%>
      
		
	 <%
	 	if(visit.getHin().getRank()!= null )
	 	{
	 	%>
	 	data_arr[<%= i%>][12] = "<%=visit.getHin().getRank().getRankName()%>"
	 	<%
	 	}else{
	 	%>
	 	data_arr[<%= i%>][12] = ""
	      <%}%>
	  		  				
<%

if(servicepatientName!= null )
{
%>
data_arr[<%= i%>][13] = "<%=servicepatientName%>"
<%
}else{
%>
data_arr[<%= i%>][13] = ""
<%}
if(visit.getHin().getAge() != null)
{
%>

data_arr[<%= i%>][14] = "<%=visit.getHin().getAge()%>"
<%
}else{
%>
data_arr[<%= i%>][14] = ""
<%   }
if(masAdministrativeSex.getAdministrativeSexName() != null || masAdministrativeSex.getAdministrativeSexName() != ""){
%>
data_arr[<%= i%>][15] = "<%=masAdministrativeSex.getAdministrativeSexName()%>"
<%
}else{
%>
data_arr[<%= i%>][15] = ""
<%}

if(visit.getWorkingDiagnosis()!= null){

%>
data_arr[<%= i%>][16] = "<%=visit.getWorkingDiagnosis()%>"
<%
}else{
%>
data_arr[<%= i%>][16] = ""
<%}%>
data_arr[<%= i%>][17] = ""
data_arr[<%= i%>][18] = '<input type="hidden" id="iCardStatus<%=i%>"  name="iCardStatus<%=i%>" value="<%=patientHin.getServiceCardStatus()%>"  />'
<%
if(visit.getVisitNo()!=null)
{
%>
data_arr[<%= i%>][19]="<%=visit.getVisitNo()%>"
<%
}else{
%>
data_arr[<%= i%>][19]=""
<%
}

%>

var visitid =  <%=visit.getId()%> 
var tokenNo =  '<%=visit.getTokenNo()%>';
data_arr[<%= i%>][20] ="<input type='button' name='btn' id='btn' value='Release' onclick='doPatientRelease("+visitid+");'/>";



<%	
i++;
//}
}

}catch(Exception e){
e.printStackTrace();

}
%>
		 
		formName = "emergencyOPDWaitingList"
			start = 0
			if(data_arr.length < rowsPerPage){
			end = data_arr.length;
			}
			else{
			end = rowsPerPage;

			}
			makeTable(start,end);
			</script>
