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


<%@page import="jkt.hms.masters.business.OtBooking"%>
<%@page import="jkt.hms.masters.business.OtBookingDt"%>
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
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<!--By Vishnu  -->
<title>Pending List of Operative Notes</title>

	<%
 	Map<String, Object> utilMap = new HashMap<String, Object>();
 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String currentTime = (String) utilMap.get("currentTime");
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}

	
	
	List pacList = new ArrayList();
	List otList = new ArrayList();
	List<MasOt> masOtList = new ArrayList<MasOt>();
			
	if (map.get("pacList") != null) {
		pacList = (List) map.get("pacList");
	}
	if (map.get("otList") != null) {
		otList = (List) map.get("otList");
	}
	
	if (map.get("masOtList") != null) {
		masOtList = (List) map.get("masOtList");
	}		
	
String userName = "";
if (session.getAttribute("userName") != null) {
	userName = (String) session.getAttribute("userName");
}
int hospitalId=0;
if (session.getAttribute("hospitalId") != null) {
	hospitalId = (Integer) session.getAttribute("hospitalId");
}	
	
	%>


<script type="text/javascript" language="javascript">
 
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
<h2>Pending List of Surgery Operative Notes</h2>
</div>
<div class="clear"></div>


<div class="clear"></div>
<div class="Clear"></div>

<%-- <h4><span><%=message%></span></h4> --%>
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
  <label>OT</label>
  <select name="<%=OT_ID%>">
    <option value="0">Select</option>
    	<%if(masOtList!=null && masOtList.size()>0){
			for(MasOt masOt :masOtList){
		%>
	<option value="<%=masOt.getId()%>"><%=masOt.getOtName()%></option>
	<%}}%>
  </select> 
 <label>Surgery Date</label>
<input type="text" name=<%=SURGERY_DATE%> readonly="readonly" id="tentativeDateId"  value="" />
 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=currentDate%>',document.getElementById('tentativeDateId'),event)" /></td>
   
   


<input type="button" name="Search" value="Search" class="button"
	onClick="submitForm('search','/hms/hms/ot?method=showPreOperativeCheckList');" />
 
 	<input type="button" name="Reset" value="Reset" class="button"
		onClick="submitForm('search','/hms/hms/ot?method=showPreOperativeCheckList');" />
 
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults">
<div id="searchtable"></div>
<form name="preAnaesthesiaWaitingList" method="post" action="">
<script type="text/javascript">
	formFields = [
		[0, "surgeryId", "id"],[1,"<%=PRESCRIPTION_NO%>"],[2,"<%=PRESCRIPTION_DATE%>"],[3,"<%=PRESCRIPTION_TIME%>"],[4,"hin"],[5,"serviceType"],[6,"serNo"],[7,"sPerName"],[8,"relation"],[9,"patName"], [10,"age"], [11,"sex"],[12,"pType"],[13,"doct"]];
		statusTd = 13;
	</script></form>
<%-- 
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> --%>
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
data_header[1][0] = "Employee No."
data_header[1][1] = "data";
data_header[1][2] = "8%";
data_header[1][3] = "<%=RequestConstants.SERVICE_NO%>"

data_header[2] = new Array;
data_header[2][0] = "HIN No"
data_header[2][1] = "hide";
data_header[2][2] = "10%";
data_header[2][3] = "<%= RequestConstants.HIN_NO %>";

data_header[3] = new Array;
data_header[3][0] = "Patient Name"
data_header[3][1] = "data";
data_header[3][2] = "5%";
data_header[3][3] = "<%=RequestConstants.PATIENT_NAME %>";

data_header[4] = new Array;
data_header[4][0] = "Relation"
data_header[4][1] = "data";
data_header[4][2] = "6%";
data_header[4][3] = "<%=RequestConstants.RELATION_ID %>";

data_header[5] = new Array;
data_header[5][0] = "Service Person Name"
data_header[5][1] = "hide";
data_header[5][2] = "5%";
data_header[5][3] = "<%=RequestConstants.SERVICE_PERSON_NAME %>";

data_header[6] = new Array;
data_header[6][0] = "AGE"
data_header[6][1] = "data";
data_header[6][2] = "5%";
data_header[6][3] = "<%=RequestConstants.AGE %>";

data_header[7] = new Array;
data_header[7][0] = "Gender"
data_header[7][1] = "data";
data_header[7][2] = "10%";
data_header[7][3] = "<%=RequestConstants.SEX %>";

data_header[8] = new Array;
data_header[8][0] = "Patient Type"
data_header[8][1] = "data";
data_header[8][2] = "6%";
data_header[8][3] = "<%=RequestConstants.PATIENT_TYPE %>";

data_header[9] = new Array;
data_header[9][0] = "Procedure Name"
data_header[9][1] = "data";
data_header[9][2] = "1%";
data_header[9][3] = "<%=RequestConstants.PAC%>";

data_header[10] = new Array;
data_header[10][0] = "Surgery Date"
data_header[10][1] = "data";
data_header[10][2] = "1%";
data_header[10][3] = "<%=RequestConstants.SURGERY_DATE%>";

data_header[11] = new Array;
data_header[11][0] = "OT"
data_header[11][1] = "data";
data_header[11][2] = "1%";
data_header[11][3] = "ot";
data_arr = new Array();

<%
int  i=0;
int deptId=0;
String patientStatus="";
try{
	String st="";
	int patientAge =0;
		String sPatientAge="-";
	Iterator iterator=otList.iterator();
    
          while(iterator.hasNext())
           {   
        	  OtBooking otbooking=(OtBooking) iterator.next();
        	  if(otbooking.getOtBookingStatus()==null || otbooking.getOtBookingStatus().equalsIgnoreCase("y")){
        		  
        		   if(otbooking.getHin().getDateOfBirth() != null)
    			    {
    			        Date date_of_birth= otbooking.getHin().getDateOfBirth();        
    			        patientAge = HMSUtil.calculateAgeInYears(date_of_birth);
    			        if(patientAge == 1 )
    			            sPatientAge = patientAge +" Year";
    			        else if(patientAge == 0 )
    			        {
    			        	sPatientAge= HMSUtil.getAgeFromDOB(otbooking.getHin().getDateOfBirth());
    			        }
    			        else
    			            sPatientAge = patientAge +" Years";
    			    } 
        		  
        	  String patientName="";
        	  if(otbooking.getHin().getPFirstName()!= null){
        	   patientName=otbooking.getHin().getPFirstName();
	        	  }
			if(otbooking.getHin().getPMiddleName()!= null){
				patientName=patientName+" "+otbooking.getHin().getPMiddleName();
			}
			if(otbooking.getHin().getPLastName()!= null)
			{
				patientName=patientName+" "+otbooking.getHin().getPLastName();
			}
				deptId = otbooking.getInpatient().getDepartment().getId();
						patientStatus = "In Patient";
				
%>

	data_arr[<%= i%>] = new Array();
	
	data_arr[<%= i%>][0] =<%=otbooking.getId()%>
	
	data_arr[<%= i%>][1] = '<input type="radio" class="radiogrid" name="parent" value="<%= otbooking.getId()%>" id="parent"   onclick="fillVisitNo(this)"/>'
	
	data_arr[<%= i%>][2] = "<%=otbooking.getHin().getServiceNo()%>"
	<%
	   if(otbooking.getHin()!=null)
	   {
	%>
	data_arr[<%= i%>][3]="<%=otbooking.getHin().getHinNo()%>"
	<%
	   }else{
	%>
	data_arr[<%= i%>][3]=""
	<%
		}
	   if(otbooking.getHin()!= null )
	   {
	%>
	data_arr[<%= i%>][4] = "<%=patientName%>"
	<%
	   }else{
	%> 
	data_arr[<%= i%>][4] = ""
	<%
	   }
	%>
		<%
		   if(otbooking.getHin() != null )
		   {
		%>
		data_arr[<%= i%>][5] = "<%=otbooking.getHin().getRelation().getNewRelationName()%>"
		<%
		   }else{
		%>
		data_arr[<%= i%>][5] = ""
		
		<%
		  }
		%>
	data_arr[<%= i%>][6] = ""
	<%
	   if(otbooking.getHin() != null )
	   {
	%>
	data_arr[<%= i%>][7] = "<%=sPatientAge%>"
	<%
	   }else{
	%>
	data_arr[<%= i%>][7] = ""
	
	<%
	  }
	   if(otbooking.getHin().getSex() != null )
	   {
	%>
	data_arr[<%= i%>][8] = "<%=otbooking.getHin().getSex().getAdministrativeSexName()%>"
	<%
	   }else{
	 %>
	 data_arr[<%= i%>][8] = ""
    <%}
	   if(patientStatus != null)
	   {
	%>
	
	data_arr[<%= i%>][9] = "<%=patientStatus%>"
    <%
	   }else{
    %> 			
	data_arr[<%= i%>][9] = "" 
<%   }if(otbooking.getOtBookingDt() != null){
	
	Set<OtBookingDt> OtBookingDtSet = new HashSet<OtBookingDt>();
	OtBookingDtSet = otbooking.getOtBookingDt();
	//OtBookingDt  OtBookingDt = otbooking.getot
	String procedureName = "";
	 int count =0;
	 for(OtBookingDt otDt :OtBookingDtSet){
		if(count++>=1)
			procedureName = procedureName.concat(" | ");
		   procedureName =procedureName+ otDt.getOtPreAnesthesiaDetail().getOpdSurgeryDetail().getChargeCode().getChargeCodeName(); 
	} 
%>
	data_arr[<%= i%>][10] = "<%=procedureName%>"
<%
  	}else{
%>
	data_arr[<%= i%>][10] = ""
<%}

if(otbooking.getSurgeryDate() != null){
	%>
		data_arr[<%= i%>][11] = "<%=otbooking.getSurgeryDate()%>"
	<%
	  	}else{
	%>
		data_arr[<%= i%>][11] = ""
	<%}

if(otbooking.getOt() != null && otbooking.getOt().getOtName()!=null){
	%>
		data_arr[<%= i%>][12] = "<%=otbooking.getOt().getOtName()%>"
	<%
	  	}else{
	%>
		data_arr[<%= i%>][12] = ""
	<%}
	i++;
  }//end of while loop
 }   //end of if loop     
}catch(Exception e){
e.printStackTrace();	
}
%>
 
formName = "preAnaesthesiaWaitingList"
start = 0
if(data_arr.length < rowsPerPage){
end = data_arr.length;
}
else{
end = rowsPerPage;

}
makeTable(start,end);
</script>
