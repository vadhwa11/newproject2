
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.HIN_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.EMPLOYEE_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.PATIENT_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.OT_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.SURGERY_DATE"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.InputStream"%><script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<title>Surgery Scheduling</title>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
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
</script>
<%

/* URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in); */

		Map map = new HashMap();
		//String includedJsp = null;
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
	
		}
	
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");	 
		
	
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
  <label>OT</label>  <%System.out.println("fssd");%>
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
 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date%>',document.getElementById('tentativeDateId'),event)" /></td>
 
<input type="button" name="Search" value="Search" class="button"
	onClick="submitForm('search','/hms/hms/ot?method=showPacClearedListForOTBookingJsp');" />
 
 	<input type="button" name="Reset" value="Reset" class="button"
		onClick="submitForm('search','/hms/hms/ot?method=showPacClearedListForOTBookingJsp');" />
 
 
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<% String message = "";
		if(map.get("message") != null){
			message = (String)map.get("message");
		  }
    %>
<div class="clear"></div>

<div class="titleBg">
<h2>OT Booking Patient List</h2>

<%
	if(!message.equals("")){
%>
<H4><span><%=message %></span></H4>

<%} %>
</div>

<div class="Clear"></div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
  
<%if(otList.size()>0){%>
<form name="otPacClearedList" method="post" action="">
<!-- <input type="button" class="button"  value="Clinical Setup" align="left" onClick="submitForm('patientList','ipd?method=showNursingCareJsp','validateRadio');" />-->

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div id="test" class="wid">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<script type="text/javascript" language="javascript">
	
	formFields = [
			[0, "<%= RequestConstants.HIN_ID%>", "id"],[1, "<%= RequestConstants.RADIO_FOR_TABLE%>"], [2,"<%= RequestConstants.SERVICE_NO%>"], [3,"<%= RequestConstants.HIN_NO %>"], [4,"<%= RequestConstants.PATIENT_NAME %>"],[5,"<%= RequestConstants.SERVICE_TYPE_NAME %>"],[6,"<%= RequestConstants.SERVICE_PERSON_NAME %>"],[7,"<%=RequestConstants.AGE%>"],[8,"<%= RequestConstants.SEX %>"],[9,"<%=RequestConstants.PATIENT_TYPE%>"],[10,"<%=RequestConstants.PAC%>"] ];
	 statusTd =12;

</script></div>
<div id="edited"></div>
<div id="statusMessage" class="messagelabel"><br />
</div>
</div>
<input type="hidden" name="bookingId" id="bookingId" value="" />

<script type="text/javascript" language="javascript">
		
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = " "
		data_header[0][1] = "radio";
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
		data_header[6][0] = "Age"
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
		
		
		data_header[9] = new Array;
		data_header[9][0] = "Surgery Type"
		data_header[9][1] = "data";
		data_header[9][2] = "1%";
		data_header[9][3] = "surgeryType";
		
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
		
		data_header[12] = new Array;
		data_header[12][0] = "OT"
		data_header[12][1] = "data";
		data_header[12][2] = "1%";
		data_header[12][3] = "ot";
		data_arr = new Array();
		
		<%
		int  i=0;
		int deptId=0;
		String patientStatus="";
		try{
			String st="";
			 String majSur =null;
			 String minSur =null;
			 String surgeryType= null;
			 OtBookingDt bookingdt =null;
				majSur = HMSUtil.getProperties("adt.properties", "subChargeCodeForMajorSurgery");
			 	minSur = HMSUtil.getProperties("adt.properties", "subChargeCodeForMinorSurgery");
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
		        		  surgeryType =null;
		        		  if(otbooking.getOtBookingDt().size()>0)
		        		  bookingdt= ((OtBookingDt)(otbooking.getOtBookingDt().toArray()[0]));
		        		   if(bookingdt!=null&& majSur.equalsIgnoreCase(bookingdt.getOtPreAnesthesiaDetail().getOpdSurgeryDetail().getChargeCode().getSubChargecode().getSubChargecodeCode())) 
							   surgeryType ="Major";
						   else if(bookingdt!=null&& minSur.equalsIgnoreCase(bookingdt.getOtPreAnesthesiaDetail().getOpdSurgeryDetail().getChargeCode().getSubChargecode().getSubChargecodeCode()))
								   surgeryType ="Minor";  
		        		 
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
					
					//deptId = otbooking.getInpatient().getAdWardId().getId();
					
						//patientStatus = "In Patient";
						if(otbooking.getInpatient() != null)
						{
							patientStatus = "IPD Patient";
						}
						else if(otbooking.getVisit() != null)
						{
							patientStatus = "OPD Patient";
						}
						
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
				data_arr[<%= i%>][5] = "<%=otbooking.getHin().getRelation().getRelationName()%>"
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
		
            %> 			
			data_arr[<%= i%>][9] = "<%=patientStatus%>"
		<%   if(otbooking.getOtBookingDt() != null){
			
		/* 	Set<OpdSurgeryDetail> opdSuregryDetailsSet = new HashSet<OpdSurgeryDetail>();
			opdSuregryDetailsSet = otbooking.getOpdSurseryHeader().getOpdSurgeryDetails();
			String procedureName = "";
			 int count =0;
			for(OpdSurgeryDetail osd:opdSuregryDetailsSet){
				if(count++>=1)
					procedureName = procedureName.concat(" | ");
				    procedureName =procedureName+ osd.getChargeCode().getChargeCodeName(); 
			} */
			
		/* 	Set<OtBookingDt> OtBookingDtSet = new HashSet<OtBookingDt>();
			OtBookingDtSet = otbooking.getOtBookingDt();
			for(OtBookingDt otDt :OtBookingDtSet){
				System.out.println(otDt.getOtPreAnesthesiaDetail().getOpdSurgeryDetail().getChargeCode().getChargeCodeName());
			} */
			
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
			data_arr[<%= i%>][10] = " <%= procedureName%>"
		<%
		  	}else{
		%>
			data_arr[<%= i%>][10] = ""
		<%}
		
		if(surgeryType!=null){
			%>
				data_arr[<%= i%>][11] = "<%=surgeryType%>"
			<%
			  	}else{
			%>
				data_arr[<%= i%>][11] = ""
			<%}
		if(otbooking!= null && otbooking.getSurgeryDate()!=null){
			%>
				data_arr[<%= i%>][12] = "<%=otbooking.getSurgeryDate()%>"
			<%
			  	}else{
			%>
				data_arr[<%= i%>][12] = ""
			<%}
		
		if(otbooking.getOt() != null && otbooking.getOt().getOtName()!=null){
			%>
				data_arr[<%= i%>][13] = "<%=otbooking.getOt().getOtName()%>"
			<%
			  	}else{
			%>
				data_arr[<%= i%>][13] = ""
			<%}
			i++;
		  }//end of while loop
         }   //end of if loop     
		}catch(Exception e){
		e.printStackTrace();	
		}
		%>
		 
		formName = "otPacClearedList"
		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeTable(start,end);
		
		intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
<!-- <input type="button" name="printReport" id="print" 	onclick="openInvestigationDetails();" value="Investigation Details"	class="buttonBig" accesskey="a" /> -->

<%
if(otList!=null && otList.size()>0){ %>
<input name="Submit" type="button" class="buttonBig"
	value="Re-schedule"
	onclick="submitForm('otPacClearedList','ot?method=showOTScheduleForUpdation','validateRadioForPAC');" />

<input type="button" name="printReport" id="print" 	onclick="if(validateRadioForPAC()){cancelSurgery();}" value="Cancel Surgery" class="buttonBig" accesskey="a" />

<label>Remarks</label>
<textarea class="large" name="cancelOtRemarks" id="cancelOtRemarks" maxlength="30" style="height:45px;"></textarea>

<%} %>

 <input type="hidden" name="counter" id="counter" value="<%=i %>" /> 
<input type="hidden" name="deptId" id="deptId" value="<%=deptId %>" /> <script
	type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>
</form>

<script type="text/javascript">	

function fillVisitNo(printValueObj){
	document.getElementById('bookingId').value = printValueObj.value;
}
/* function validateRadioForVisitNo(){
	for(var i = 0; i < document.getElementsByName('parent').length; i++){
		if(document.getElementsByName('parent')[i].checked == true){
			return true;
		}		
		}
		alert("Please select one row");
	return false;
}
 */
function validateRadioForPAC(){
	
	 for(var i = 0; i < document.getElementsByName('parent').length; i++){
	//alert("i-- "+i)
	//alert("document.getElementsByName('parent').length"+ document.getElementsByName('parent').length)
	  if(document.getElementsByName('parent')[i].checked == true)
     {
		return true;
	  }
	
	}
		 alert("Please select the patient");
return false;
} 
	function cancelSurgery()
	{
		
		var remarks = document.getElementById("cancelOtRemarks").value;
		
		if(remarks =="")
			{
			 alert("Please fill remarks for OT cancelation");
			return ;
			}
		//var data = "bookingId="+document.getElementById("bookingId").value;
		 	
		var data = "bookingId="+document.getElementById("bookingId").value +"&cancelOtRemarks="+remarks;
		    //var url = "ot?method=cancelOTSchedule";
		     var url = "ot?method=cancelOTSchedule";
		 	    
		  jQuery(function ($) {
		  
		    	$.ajax({
					type:"POST",
					url: url,
					 data: data,	 
					 dataType: "text",
					cache: false,
					success: function(msg)
					{									 
						if(msg.indexOf("success~~~true") != -1)
							{
									alert("Cancel successfully");
									window.location ="ot?method=showPacClearedListForOTBookingJsp&selectedAppId=A543";
							}
						else
							{
								alert("An error has occurred while contacting the server");
							}
						
					},
					error: function(msg)
					{					
						alert("An error has occurred while contacting the server");
						
					}
					
					
				});
		    });   

	}
	<%} %>
/* function openInvestigationDetails(){
	var flag = validateRadioForVisitNo();
	var orderNo = '';
	if(flag == false){
		return false;
	}else{
		var printId = document.getElementById('print');
		var hinId = document.getElementById('hinId').value ;
		//submitForm('opdPatientPrevVisitForReport','/hms/hms/opd?method=showPatientPreviousPrescriptionRepeat');
	//	submitProtoAjaxWithDivName('opdPatientPrevVisitForReport','/hms/hms/opd?method=showPatientPreviousInvestigation','testP');
			submitProtoAjaxWithDivName('opdPatientPrevVisitForReport','/hms/hms/lab?method=viewAllTestForOrderNo&hinId='+hinId,'testP');
		checkTargetForNo();
	}
	
}	 */

</script>