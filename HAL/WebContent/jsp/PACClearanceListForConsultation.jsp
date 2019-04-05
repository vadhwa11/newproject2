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


<%@page import="jkt.hms.masters.business.PreAnesthesiaConsultDoctorHd"%>
<%@page import="jkt.hms.masters.business.OtPreAnesthesiaHd"%>
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
<title>PAC Clearance Consultation</title>

	<%
 	Map<String, Object> utilMap = new HashMap<String, Object>();
     
 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
 	String currenDate = (String) utilMap.get("currentDate");
 	String currentTime = (String) utilMap.get("currentTime");
 	boolean showSubmitButton=false;
 	String message = "";
 	
 	Map<String, Object> map = new HashMap<String, Object>();
 	if (request.getAttribute("map") != null) {
 		map = (Map<String, Object>) request.getAttribute("map");
 	}
 	
 	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();

     if(map.get("department") != null){
       departmentList = (List<MasDepartment>)map.get("department");
     }
     
 	List<PreAnesthesiaConsultDoctorHd> requestList = new ArrayList<PreAnesthesiaConsultDoctorHd>();
 	List<OtPreAnesthesiaHd> pacDt = new ArrayList<OtPreAnesthesiaHd>();
	if (map.get("requestList") != null) {
		requestList = (List<PreAnesthesiaConsultDoctorHd>) map.get("requestList");
	}	
	if(map.get("message") != null){
		message = (String)map.get("message");
	}
	
	if(map.get("pacDt") != null){
		pacDt = (List<OtPreAnesthesiaHd>) map.get("pacDt");
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
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(date.length()<2){
	date="0"+date;
	}
	String time = (String) utilMap.get("currentTime");
date = (String) utilMap.get("currentDate");
String userName = "";
	%>
	serverdate = '<%=date+"/"+month+"/"+year%>'
	
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
<h2>Pending List for PAC Clearance Consultation</h2>
</div>
<div class="clear"></div>


<div class="clear"></div>
<div class="Clear"></div>

<h4><span><%=message%></span></h4>

<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults">
<div id="searchtable"></div>
<form name="pendingForPACConsulation" method="post" action="">
<script type="text/javascript">
	formFields = [
		[0, "surgeryId", "id"],[1,"<%=PRESCRIPTION_NO%>"],[2,"<%=PRESCRIPTION_DATE%>"],[3,"<%=PRESCRIPTION_TIME%>"],[4,"hin"],[5,"serviceType"],[6,"serNo"],[7,"sPerName"],[8,"relation"],[9,"patName"], [10,"age"], [11,"sex"],[12,"pType"],[13,"doct"]];
		statusTd = 13;
	</script></form>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
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
data_header[8][1] = "hide";
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
	 if (requestList != null && requestList.size() > 0) {
 		for(PreAnesthesiaConsultDoctorHd doctorHd:requestList)
 		{
 			
 			OtPreAnesthesiaHd object =pacDt.get(counter);
 		   	
 			System.out.println("jkk"+counter + " "+object.getId()+" f"+object.getHin().getServiceNo());
 			
 		   //	 Set<OtPreAnesthesiaDetail> opdSuregryDetailsSet1 = new HashSet<OtPreAnesthesiaDetail>();
 		   	// opdSuregryDetailsSet1 = requestList.get(counter).getOtPreAnesthesiaHd().getOtPreAnesthesiaDetails();
 			//System.out.println("size of= "+requestList.size());
 			/* System.out.println("size of= "+opdSuregryDetailsSet1.size());
 			System.out.println("pac hd id= "+doctorHd.getOtPreAnesthesiaHd().getId());
 		   	System.out.println("pac dt sets"+doctorHd.getOtPreAnesthesiaHd().getOtPreAnesthesiaDetails()); */
 		 // System.out.println("dd"+object.getId());
 		/*    	 for(OtPreAnesthesiaDetail pacDetail:opdSuregryDetailsSet1)
 		   	 {
 		   		 
 		   		object = pacDetail.getOpdSurgeryDetail().getOpdSurgery();
 		   		 break;
 		   	 } */
 		   	
 		     			
 			/*  = doctorDt.getConsultDoctorIdHd().getOtPreAnesthesiaHd().getOpdSurgeryHeader();
 			System.out.println("here "+doctorDt.getConsultDoctorIdHd().getId());
 			System.out.println("here "+doctorDt.getConsultDoctorIdHd().geto); */
 %>
	data_arr[<%= counter%>] = new Array();
	data_arr[<%= counter%>][0] = "<%=doctorHd.getOtPreAnesthesiaHd().getId() %>"
		data_arr[<%= counter%>][1] = "<%=counter%>"	
	data_arr[<%= counter%>][2] = "<%=object.getHin().getServiceNo()%>"
	<%
	if(object.getHin() != null){
		String FirName="";String midName=""; String lastName="";
		if(object.getHin().getPFirstName() !=null){
			FirName = object.getHin().getPFirstName();
			}
			if(object.getHin().getPMiddleName()!=null){
				midName = object.getHin().getPMiddleName();
			}
			if(object.getHin().getPLastName()!=null){
				lastName = object.getHin().getPLastName();
			}
			String name = FirName+" "+midName+" "+lastName;
	
	%>
	
	data_arr[<%= counter%>][3] = "<%=name%>"
	<%}else{%>
	data_arr[<%= counter%>][3] = "-"
<%}%>
data_arr[<%= counter%>][4] = "<%=object.getHin().getRelation().getNewRelationName()%>"
	data_arr[<%= counter%>][5] = "<%=object.getHin().getAge()%>"
	data_arr[<%= counter%>][6] = "<%=object.getHin().getSex().getAdministrativeSexName()%>"

	     <%if(otPreAnesthesiaProcedureList.get(counter)!=null){
	    	 String procedureName = otPreAnesthesiaProcedureList.get(counter);
    		// int count =0;
    /* 		for(OtPreAnesthesiaDetail pacd:pacDt){
    			if(count++>=1)
    				procedureName = procedureName.concat(" | ");
    			    procedureName =procedureName+ pacd.getOpdSurgeryDetail().getChargeCode().getChargeCodeName(); 
    		} */
	    	 %>
	     data_arr[<%= counter%>][7] = "<%=procedureName%>"
         <%}else{ %>
         data_arr[<%= counter%>][7] = "-"
         <%} %>
	
	     <%if(object.getInpatient()!=null){ %>
	     data_arr[<%= counter%>][8] = "<%= HMSUtil.convertDateToStringWithoutTime(object.getInpatient().getDateOfAddmission())%>"
         <%}else{ %>
         data_arr[<%= counter%>][8] = "-"
         <%} %>
         
         <%if(object.getVisit()!=null && object.getVisit().getPriority()!=null){ %>
         data_arr[<%= counter%>][9] = "<%= object.getVisit().getPriority()%>"
         <%}else{ %>
         data_arr[<%= counter%>][9] = "-"
         <%} %>
	

	<%
	counter++;
	}
}
%>

formName = "pendingForPACConsulation"
start = 0
if(data_arr.length < rowsPerPage){
end = data_arr.length;
}
else{
end = rowsPerPage;

}
makeTable(start,end);
</script>
