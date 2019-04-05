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


<%@page import="jkt.hms.masters.business.OtPreAnesthesiaDetail"%>
<%@page import="jkt.hms.masters.business.OtBooking"%>
<%@page import="jkt.hms.masters.business.MasOt"%>
<%@page import="jkt.hms.masters.business.OpdSurgeryHeader"%>
<%@page import="jkt.hms.masters.business.OpdSurgeryDetail"%>
<%@page import="jkt.hms.masters.business.PreAnesthesiaConsultDoctorDt"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.OpdHoliday"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.AppSetup"%>
<%@page import="java.sql.Time"%>
<%@page import="java.text.SimpleDateFormat"%>
 <%@page import="jkt.hms.masters.business.AppEquipmentMaster"%>
 <%@page import="jkt.hms.masters.business.OtPreAnesthesiaHd"%>
 
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js?n=1"></script>
<!--By Vishnu  -->
<title>Waiting List For Surgery</title>

<% 

	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String currentTime = (String) utilMap.get("currentTime");
	String message ="";
			 	boolean showSubmitButton=false;
			 	
			 	Map<String, Object> map = new HashMap<String, Object>();
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
			 	
			 	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();

                 if(map.get("department") != null){
			       departmentList = (List<MasDepartment>)map.get("department");
		         }
                 
			 	List<OtPreAnesthesiaHd> waitList = new ArrayList<OtPreAnesthesiaHd>();
				if (map.get("waitList") != null) {
					waitList = (List<OtPreAnesthesiaHd>) map.get("waitList");
				}	
				if(map.get("message") != null){
					message = (String)map.get("message");
				}
				List<String> otPreAnesthesiaProcedureList = new ArrayList<String>();
				if(map.get("otPreAnesthesiaProcedureList") != null){
					otPreAnesthesiaProcedureList=(List)map.get("otPreAnesthesiaProcedureList");
				}
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

	
  function validateDates() 
  {
		var strValue = searchPrescription11.<%=FROM_DATE%>.value;
        
        if(strValue=='')
        {
        	alert("From Date can't be Blank ....");
			return false;
        }      
		var fromDate = new Date(strValue.substring(6),(strValue.substring(3,5) - 1) ,strValue.substring(0,2));
		strValue = searchPrescription11.<%=TO_DATE%>.value;
		 
		    if(strValue=='')
	        {
	        	alert("To Date can't be Blank ....");
				return false;
	        }      
				
	 	var toDate  = new Date(strValue.substring(6),(strValue.substring(3,5) - 1) ,strValue.substring(0,2));
			
		if (fromDate > toDate)
	 	{
			alert('From Date cannot be greater than To Date!....');
			return false;
	 	}
	 	
	 	return true; 
		
	}

		
	</script>


<div class="clear"></div>
<div class="titleBg">
<h2>Pending List For Surgery Scheduling</h2>
</div>
<div class="clear"></div>


<div class="clear"></div>
<div class="Clear"></div>

<h4><span><%=message%></span></h4>
<form name="search" action="" method="post">
<div class="Block">

<%-- <label>Date</label> <input type="text"
	id="appointmentdate" name="<%=APPOINTMENT_DATE %>" class="date"
	value="" MAXLENGTH="30" readonly="readonly" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currenDate %>',document.investigationAppointments.<%=APPOINTMENT_DATE%>,event);" />
 
<label> Department</label>
	<select name="department" id="de" >
	<option value="">Select Department</option>
	<% for(MasDepartment masDepartment:departmentList){ %>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
	<%} %>
	</select>
<label>Unit</label>
 <select id="departmentId" name="<%=DEPARTMENT_ID%>"
	validate="Department,number,no">
	<option value="0">Select</option>
   </select>
<div class="clear"></div> --%>
 
<%-- <label>Hin</label> <input type="text" name="<%=HIN_NO%>"></input> --%>
  
<label>Employee No.</label> <input type="text" name="<%=EMPLOYEE_ID%>"></input>

<label>Patient Name</label> <input type="text" name="<%=PATIENT_NAME%>"></input>
   <div class="clear"></div>

<input type="button" name="Search" value="Search" class="button"
	onClick="submitForm('search','/hms/hms/ot?method=surgeryWaitingList');" />
 	<input type="button" name="Reset" value="Reset" class="button"
		onClick="submitForm('search','/hms/hms/ot?method=surgeryWaitingList');" />
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults">
<div id="searchtable"></div>
<form name="pendingSurgeryWaitingList" method="post" action="">
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
data_header[5][1] = "data";
data_header[5][2] = "5%";
data_header[5][3] = "sex";

data_header[6] = new Array;
data_header[6][0] = "Procedure Name"
data_header[6][1] = "data";
data_header[6][2] = "7%";
data_header[6][3] = "pType";

data_header[7] = new Array;
data_header[7][0] = "Admission Date"
data_header[7][1] = "data";
data_header[7][2] = "7%";
data_header[7][3] = "admissiondate";

data_header[8] = new Array;
data_header[8][0] = "Priority"
data_header[8][1] = "data";
data_header[8][2] = "7%";
data_header[8][3] = "pType";

/* data_header[12] = new Array;
data_header[12][0] = "Doctor"
data_header[12][1] = "data";
data_header[12][2] = "8%";
data_header[12][3] = "doct";  */

data_arr = new Array();
<%
	int  counter=0;
	 if (waitList != null && waitList.size() > 0) {
		 //	System.out.println("hervve "+waitList.get(0).getId());	
		 	int patientAge =0;
	String sPatientAge="-";
	String age =null;
 		for(OtPreAnesthesiaHd object1:waitList)
 		{
 	
 			  if(object1.getHin().getDateOfBirth() != null)
 			    {
 			        Date date_of_birth= object1.getHin().getDateOfBirth();        
 			        patientAge = HMSUtil.calculateAgeInYears(date_of_birth);
 			        if(patientAge == 1 )
 			            sPatientAge = patientAge +" Year";
 			        else if(patientAge == 0 )
 			        {
 			        	sPatientAge= HMSUtil.getAgeFromDOB( object1.getHin().getDateOfBirth());
 			        }
 			        else
 			            sPatientAge = patientAge +" Years";
 			    }
	    int surgeryHeaderId = 0;
	    
	    //OpdSurgeryHeader object = object1.getOpdSurgeryHeader();
	    if(object1.getOtPreAnesthesiaDetails() !=null)
	    {
	   	 
	   	 Set<OtPreAnesthesiaDetail> opdSuregryDetailsSet = new HashSet<OtPreAnesthesiaDetail>();
	   	 opdSuregryDetailsSet = object1.getOtPreAnesthesiaDetails();
	   	 
	   	 for(OtPreAnesthesiaDetail pacDetail:opdSuregryDetailsSet)
	   	 {
	   	//	surgeryHeaderId = pacDetail.getOpdSurgeryDetail().getOpdSurgery().getId();
	   	//object = pacDetail.getOpdSurgeryDetail().getOpdSurgery();
	  // 	System.out.println("hervve "+object.getId());	 
	   	break;
	   		 
	   	 }
	   	
	    }
 			
 %>
	data_arr[<%= counter%>] = new Array();
	data_arr[<%= counter%>][0] = "<%=object1.getId()%>"
		data_arr[<%= counter%>][1] = "<%=counter%>"	
	  data_arr[<%= counter%>][2] = "<%=object1.getHin().getServiceNo()%>"
	<%
	if(object1.getHin() != null){
		String FirName="";String midName=""; String lastName="";
		if(object1.getHin().getPFirstName() !=null){
			FirName = object1.getHin().getPFirstName();
			}
			if(object1.getHin().getPMiddleName()!=null){
				midName = object1.getHin().getPMiddleName();
			}
			if(object1.getHin().getPMiddleName()!=null){
				lastName = object1.getHin().getPLastName();
			}
			
			String name = FirName+" "+midName+" "+lastName;
	
	%>
	
	data_arr[<%= counter%>][3] = "<%=name%>"
	<%}else{%>
	data_arr[<%= counter%>][3] = "-"
<%}%>
data_arr[<%= counter%>][4] = "<%=object1.getHin().getRelation().getNewRelationName()%>"
	data_arr[<%= counter%>][5] = "<%=sPatientAge%>"
	data_arr[<%= counter%>][6] = "<%=object1.getHin().getSex().getAdministrativeSexName()%>"

	     <%if(otPreAnesthesiaProcedureList.get(counter)!=null){
	    		String procedureName = otPreAnesthesiaProcedureList.get(counter);
	    		
	    	 %>
	     data_arr[<%= counter%>][7] = "<%=procedureName%>"
         <%}else{ %>
         data_arr[<%= counter%>][7] = "-"
         <%} %>
	
	     <%if(object1.getInpatient()!=null){ %>
	     data_arr[<%= counter%>][8] = "<%= HMSUtil.convertDateToStringWithoutTime(object1.getInpatient().getDateOfAddmission())%>"
         <%}else{ %>
         data_arr[<%= counter%>][8] = "-"
         <%}

%>
         
         <%
         
         if(object1.getVisit()!=null && object1.getVisit().getPriority()!=null){ %>
         data_arr[<%= counter%>][9] = "<%= object1.getVisit().getPriority()%>"
         <%}else{ %>
         data_arr[<%= counter%>][9] = "-"
         <%} %>
	

	<%
	counter++;
	}
}
%>

formName = "pendingSurgeryWaitingList"
start = 0
if(data_arr.length < rowsPerPage){
end = data_arr.length;
}
else{
end = rowsPerPage;

}
makeTable(start,end);
</script>