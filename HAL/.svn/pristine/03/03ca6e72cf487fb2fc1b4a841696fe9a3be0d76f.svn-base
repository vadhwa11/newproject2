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

<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.OtBooking"%>
<%@page import="jkt.hms.masters.business.OpdSurgeryHeader"%>
<%@page import="jkt.hms.masters.business.OpdSurgeryDetail"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript" src="/hms/jsp/js/proto.js"></script>
<title>Labor Room Waiting List</title>

	<%
 	Map<String, Object> utilMap = new HashMap<String, Object>();
 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String currentTime = (String) utilMap.get("currentTime");
 	boolean showSubmitButton=false;
 	String message = "";
 	String errorMessage = "";
 	
 	Map<String, Object> map = new HashMap<String, Object>();
 	if (request.getAttribute("map") != null) {
 		map = (Map<String, Object>) request.getAttribute("map");
 	}
 
     
 	List<Inpatient> recordList = new ArrayList<Inpatient>();
	if (map.get("patientList") != null) {
		recordList = (List) map.get("patientList");
	}	
	if(map.get("message") != null){
		message = (String)map.get("message");
	}

	if(map.get("error") != null){
		errorMessage = (String)map.get("error");
	}

	
	%>

<div class="clear"></div>
<div class="titleBg">
<h2>Labor Room Waiting List</h2>
</div>
<div class="clear"></div>


<div class="clear"></div>
<div class="Clear"></div>
<%-- <h4><span><%=errorMessage%></span></h4> --%>
<form name="search" action="" method="post">
<div class="Block">
  
<label>Employee No.</label> <input type="text" name="<%=SERVICE_NO%>"></input>

<label>Patient Name</label> <input type="text" name="<%=PATIENT_NAME%>"></input>
   <div class="clear"></div>

<input type="button" name="Search" value="Search" class="button"
	onClick="submitForm('search','/hms/hms/lr?method=transferPatientWaitingList');" />
 
 	<input type="reset" name="Reset" value="Reset" class="button"
		onClick="submitForm('search','/hms/hms/lr?method=transferPatientWaitingList');" />
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<jsp:include page="searchResultBlock.jsp" />
<h4><span><%=message%></span></h4>
<div id="searchresults">
<div id="searchtable"></div>
<form name="laborPatientTransfer" method="post" action="">
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
data_header[0][0] = "S. No"
data_header[0][1] = "hide";
data_header[0][2] = "5%";
data_header[0][3] = "s_no";


data_header[1] = new Array;
data_header[1][0] = "Employee No"
data_header[1][1] = "data";
data_header[1][2] = "8%";
data_header[1][3] = "serNo";

 data_header[2] = new Array;
data_header[2][0] = "Patient Name"
data_header[2][1] = "data";
data_header[2][2] = "10%";
data_header[2][3] = "patName";

data_header[3] = new Array;
data_header[3][0] = "Relation"
data_header[3][1] = "data";
data_header[3][2] = "7%";
data_header[3][3] = "relation";

data_header[4] = new Array;
data_header[4][0] = "Age"
data_header[4][1] = "data";
data_header[4][2] = "10%";
data_header[4][3] = "age";

data_header[5] = new Array;
data_header[5][0] = "Gender"
data_header[5][1] = "hide";
data_header[5][2] = "5%";
data_header[5][3] = "sex";

data_header[6] = new Array;
data_header[6][0] = "Ward Department"
data_header[6][1] = "data";
data_header[6][2] = "7%";
data_header[6][3] = "department";

data_header[7] = new Array;
data_header[7][0] = "Surgery Date"
data_header[7][1] = "hide";
data_header[7][2] = "7%";
data_header[7][3] = "surgerydate";

data_header[8] = new Array;
data_header[8][0] = "Priority"
data_header[8][1] = "hide";
data_header[8][2] = "7%";
data_header[8][3] = "pType";


data_arr = new Array();
<%
	int  counter=0;
	 if (recordList != null && recordList.size() > 0) {
 		for(Inpatient inpatient:recordList)
 		{
 		 
 			
 %>
	data_arr[<%= counter%>] = new Array();
	data_arr[<%= counter%>][0] = "<%=inpatient.getId()%>"
		data_arr[<%= counter%>][1] = "<%=counter%>"	
	data_arr[<%= counter%>][2] = "<%=inpatient.getHin().getServiceNo()%>"
	<%
	if(inpatient.getHin() != null){
		String FirName="";String midName=""; String lastName="";
		if(inpatient.getHin().getPFirstName() !=null){
			FirName = inpatient.getHin().getPFirstName();
			}
			if(inpatient.getHin().getPMiddleName()!=null){
				midName = inpatient.getHin().getPMiddleName();
			}
			if(inpatient.getHin().getPLastName()!=null){
				lastName = inpatient.getHin().getPLastName();
			}
			String name = FirName+" "+midName+" "+lastName;
	
	%>
	
	data_arr[<%= counter%>][3] = "<%=name%>"
	<%}else{%>
	data_arr[<%= counter%>][3] = "-"
<%}%>
data_arr[<%= counter%>][4] = "<%=inpatient.getHin().getRelation().getNewRelationName()%>"
	data_arr[<%= counter%>][5] = "<%=inpatient.getHin().getAge()%>"
	data_arr[<%= counter%>][6] = "<%=inpatient.getHin().getSex().getAdministrativeSexName()%>"
		 <%if(inpatient.getDepartment()!=null){ %>
	     data_arr[<%= counter%>][7] = "<%=inpatient.getDepartment().getDepartmentName()%>"
         <%}else{ %>
         data_arr[<%= counter%>][7] = "-"
         <%} %> 
<%-- 
	    
	
	 <%--     <%if(inpatient.getInpatient()!=null){ %>
	     data_arr[<%= counter%>][8] = "<%= HMSUtil.convertDateToStringWithoutTime(inpatient.getSurgeryDate())%>"
         <%}else{ %>
         data_arr[<%= counter%>][8] = "-"
         <%} %> --%>
         
   <%--       <%if(inpatient.getOpdSurseryHeader()!=null && inpatient.getOpdSurseryHeader().getVisit()!=null){ %>
         data_arr[<%= counter%>][9] = "<%= inpatient.getOpdSurseryHeader().getVisit().getPriority()%>"
         <%}else{ %>
         data_arr[<%= counter%>][9] = "-"
         <%} %> --%>
	

	<%
	counter++;
	}
}
%>

formName = "laborPatientTransfer"
start = 0
if(data_arr.length < rowsPerPage){
end = data_arr.length;
}
else{
end = rowsPerPage;

}
makeTable(start,end);
</script>
