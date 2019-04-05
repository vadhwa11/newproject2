<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * nursingCareEntryDetail.jsp  
 * Purpose of the JSP -  This is for Nursing Care Entry Setup.
 * @author  Vikas
 * @author  Deepali
 * Create Date: 20th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>
<%@page import="jkt.hms.masters.business.NursingcareSetup"%>
<%@page import="jkt.hms.masters.business.Ipdcaredetail"%>


<%@page import="jkt.hms.masters.business.AllergyDetail"%>

<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%><script type="text/javascript" language="javascript"	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar2.js"></script>

<script type="text/javascript">
	vBulletin_init();
</script>

<%	List<NursingcareSetup> nursingCareSetupList = new ArrayList<NursingcareSetup>();
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	String deptName="";
	
	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
	}
	String caretime=(String)map.get("caretime");
	
	List<Inpatient> inpatientList = new ArrayList<Inpatient>();

	if(map.get("nursingCareSetupList") != null)
	{
		nursingCareSetupList=(List<NursingcareSetup>)map.get("nursingCareSetupList");
	}
	if(map.get("inpatientList") != null)
	{
		inpatientList=(List<Inpatient>)map.get("inpatientList");
	}
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	 
	Patient patient = new Patient();
	Inpatient inpatient = new Inpatient();
	String patientName ="";
	String consultantName = "";
	String age = "";
	String currentAge = "";
	if(inpatientList.size() >0){
		patient = inpatientList.get(0).getHin();
		inpatient = inpatientList.get(0);
		if(patient.getPFirstName() != null)
		   {
	       patientName=patient.getPFirstName();
		   }
		if(patient.getPMiddleName() != null)
			   {
			   patientName +=patient.getPMiddleName();
			   }
		if(patient.getPLastName() != null)
			   {
			   patientName +=patient.getPLastName();
			   }
		if(inpatient.getDoctor() !=null){
			/* consultantName=inpatient.getDoctor().getRank().getRankName(); */
			if(inpatient.getDoctor().getFirstName() != null)
			{
				consultantName+=" "+inpatient.getDoctor().getFirstName();	
			}
			if(inpatient.getDoctor().getMiddleName() != null)
			{
				consultantName+= " "+inpatient.getDoctor().getMiddleName();
			}
			if(inpatient.getDoctor().getLastName() != null)
			{
				consultantName+=" "+inpatient.getDoctor().getLastName();
			}
		}
		
	    if(patient.getAge()!=null)
			age = patient.getAge();
		try{
			if(!age.equals(""))
			currentAge = HMSUtil.calculateAgeForADT(age,patient.getRegDate());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
%>
<h4>Patient Details</h4>
<div class="Clear"></div>
<div class="Block">

<label>A&D No.</label> <%if(inpatient.getAdNo() != null){ %>
<label class="value"><%=inpatient.getAdNo() %></label> <%}else{ %>
<label class="value">-</label>
<%} %>
<label>Employee No.</label> 
<label class="value"> <%=patient.getServiceNo()!=null?patient.getServiceNo():"" %></label>

<label>Ward </label> <%if(inpatient.getDepartment() != null){ %>
<label class="value"> <%=inpatient.getDepartment().getDepartmentName() %></label>
<%}else{ %>
<label class="value">-</label>
<%} %>

<div class="Clear"></div>
<label>Patient Name</label>
<label	class="value"> <%= patientName %></label>

<label>Relation</label> <%
	if(patient.getRelation() != null){
	%> 
<label class="value"><%= patient.getRelation().getRelationName()%></label>
<%} else{ %> <label
	class="value">-</label> 
	<% }%> 

<label>Designation</label>
<label class="value"><%=patient.getRank()!=null?patient.getRank().getRankName():"" %></label>
<div class="Clear"></div>
<label>Employee Name</label> <%
		String sMiddleName = "";
		String sLastName = "";
		if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){
		
			if(patient.getSMiddleName() != null){
				sMiddleName = patient.getSMiddleName();
			}
			if(patient.getSLastName() != null){
				sLastName = patient.getSLastName();
			}
	 %> 
<label class="value"><%= patient.getSFirstName()+" "+sMiddleName+" "+sLastName%></label>
<%}else{ %> 
<label class="value">-</label> 
<% }%>
<%-- 
<label>Branch/Trade</label>
<%
if(patient.getTrade() != null){
%> 
<label class="value"><%=  patient.getTrade().getTradeName()%></label>
<%} else{ %> 
<label class="value">-</label> 
<% }%>
 --%>
<%-- 
<label>Unit</label> <%
if(patient.getUnit() != null){
%> <label class="value"><%= patient.getUnit().getUnitName()%></label>
<%} else{ %> 
<label class="value">-</label> 
<% }%> --%>
<!-- <div class="Clear"></div> -->
<label>Age</label> <%if(!currentAge.equals("")){ %>
<label class="value"> <%=currentAge %></label> <%}else{ %>
<label	class="value">-</label> <%} %>
<label>Gender</label> <%if(patient.getSex() != null){ %>
<label class="value"> <%=patient.getSex().getAdministrativeSexName() %></label>
<%}else{ %>
<label class="value">-</label> <%} %>

<%-- <label>Med Cat</label>
<label class="value"><%=patient.getCategory()!=null?patient.getCategory().getCategories():"-" %></label>
 --%>
<div class="Clear"></div>

<label>Admitting Doctor</label>
<label class="value"><%=consultantName %></label>
<%-- 
<label>Allergies</label>
<%
String allergies = "";
	if(patient.getDrugAllergies()!=null){
/*	for(AllergyDetail allergyDetail : patient.getAllergyDetails()){
		if(!allergies.equals("")){
			allergies += ",";
		}
		allergies += allergyDetail.getDescription();
	}*/
		allergies = patient.getDrugAllergies();
}%>
<%
	if(!allergies.equals("")){
%>
<label class="valueAuto"><%=allergies %></label>
<%}else{ %>
<label class="value"></label>
<%} %> --%>
<!-- <div class="Clear"></div> -->

<label> Diagnosis</label> 
	<%
	List<DischargeIcdCode> diagnosisList = new ArrayList<DischargeIcdCode>();
	if(map.get("diagnosisList")!=null){
		diagnosisList = (List<DischargeIcdCode>)map.get("diagnosisList");
		
	}
	if(diagnosisList != null && diagnosisList.size() > 0 && diagnosisList.get(0).getIcd()!=null)
	{
	%> <label class="valueFixedWidth"><%=diagnosisList.get(0).getIcd().getIcdName()%></label>
	<%
		}else{
		%> <label class="value"></label> <%	
		}
		%> 
		<%-- 
<label>Disability</label>
<%
	List<MasMedicalExaminationDetail> disabilityList = new ArrayList<MasMedicalExaminationDetail>();
	if(map.get("disabilityList")!=null){
		disabilityList = (List<MasMedicalExaminationDetail>)map.get("disabilityList");
	}
	
	if(disabilityList != null && disabilityList.size() > 0)
	{
	%> <label class="valueFixedWidth"><%=disabilityList.get(0).getMasIcd()!=null?disabilityList.get(0).getMasIcd().getIcdName():"" %></label>
<%
	}else{
	%> <label class="value"></label> <%	
	}
%>  --%>
<div class="Clear"></div>

</div>
<%
if(nursingCareSetupList.size() > 0){
%>
<div class="Clear"></div>
<h4>Nursing Care Entry</h4>
<div class="Clear"></div>
<%} %>
<%--
<div class="Block">
<label>Date</label>
<input type="text" name="careDate" value="<%=currentDate %>" readonly="readonly" />

<label>Time</label>
<input type="text" name="time" value="<%=time.substring(0,time.lastIndexOf(":")) %>" readonly="readonly" />
</div>
 --%>
<input type="hidden" name="careDate" value="<%=currentDate %>" readonly="readonly" />
<input type="hidden" name="time" value="<%=time.substring(0,time.lastIndexOf(":")) %>" readonly="readonly" /> 


<div class="Clear"></div>

<div class="Clear"></div>
<jsp:include page="searchResultBlockForIPD.jsp" />
<div class="Clear"></div>
<form name="nursingCareEntryDetail" method="post">
<input type="hidden" name="careTime1" value="<%=time.substring(0,time.lastIndexOf(":"))  %>" readonly="readonly" />
<input type="hidden" name="careTime" value="<%=time%>" readonly="readonly" />

<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>



<script type="text/javascript" language="javascript">
	
	formFields = [
			[0, "<%= RequestConstants.HIN_ID%>", "id"],[1, "<%= RequestConstants.RADIO_FOR_TABLE%>"], [2,"<%= RequestConstants.ADMISSION_NUMBER%>"], [3,"<%= RequestConstants.PATIENT_NAME %>"],[4,"<%= RequestConstants.CARE_TIME %>"], [5,"1"],[6,"2"],[7,"3"],[8,"4"],[9,"5"],[10,"6"],[11,"7"],[12,"8"],[13,"9"],[14,"10"],[15,"11"],[16,"12"],[17, "<%= RequestConstants.CARE_REMARKS%>"],[18, "<%= RequestConstants.NURSING_SETUP_ID%>"],[19, "<%= RequestConstants.ADMISSION_NUMBER%>"],[20, "<%= RequestConstants.HIN_ID%>"],[21, "<%= RequestConstants.IPDCAREDETAIL_ID%>"],[22,"stop"] ];
	 statusTd =21;

</script></div>
<div id="edited"></div>
<div id="statusMessage" class="messagelabel"><br />
</div>

<script type="text/javascript" language="javascript">
		
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = " "
		data_header[0][1] = "hide";
		data_header[0][2] = "5%";
		data_header[0][3] = "<%= RequestConstants.RADIO_FOR_TABLE%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "Care Type/Procedure "
		data_header[1][1] = "data";
		data_header[1][2] = "8%";
		data_header[1][3] = "<%= RequestConstants.ADMISSION_NUMBER%>"
		
		data_header[2] = new Array;
		data_header[2][0] = "Patient Name"
		data_header[2][1] = "hide";
		data_header[2][2] = "6%";
		data_header[2][3] = "<%= RequestConstants.PATIENT_NAME %>";
		
		data_header[3] = new Array;
		data_header[3][0] = "Care Time"
		data_header[3][1] = "hide";
		data_header[3][2] = "6%";
		data_header[3][3] = "<%= RequestConstants.CARE_TIME %>";
		
		data_header[4] = new Array;
		data_header[4][0] = "1"
		data_header[4][1] = "data";
		data_header[4][2] = "24%";
		data_header[4][3] = "1";
		
		data_header[5] = new Array;
		data_header[5][0] = "2"
		data_header[5][1] = "data";
		data_header[5][2] = "24%";
		data_header[5][3] = "2";
		
		data_header[6] = new Array;
		data_header[6][0] = "3"
		data_header[6][1] = "data";
		data_header[6][2] = "8%";
		data_header[6][3] = "3";
		
		
		
		data_header[7] = new Array;
		data_header[7][0] = "4"
		data_header[7][1] = "data";
		data_header[7][2] = "4%";
		data_header[7][3] = "4";
		
		data_header[8] = new Array;
		data_header[8][0] = "5"
		data_header[8][1] = "data";
		data_header[8][2] = "4%";
		data_header[8][3] = "5";
		
		data_header[9] = new Array;
		data_header[9][0] = "6"
		data_header[9][1] = "data";
		data_header[9][2] = "4%";
		data_header[9][3] = "6";
		
		data_header[10] = new Array;
		data_header[10][0] = "7"
		data_header[10][1] = "data";
		data_header[10][2] = "4%";
		data_header[10][3] = "7";
		
		data_header[11] = new Array;
		data_header[11][0] = "8"
		data_header[11][1] = "data";
		data_header[11][2] = "4%";
		data_header[11][3] = "8";
		
		data_header[12] = new Array;
		data_header[12][0] = "9"
		data_header[12][1] = "data";
		data_header[12][2] = "4%";
		data_header[12][3] = "9";
		
		data_header[13] = new Array;
		data_header[13][0] = "10"
		data_header[13][1] = "data";
		data_header[13][2] = "4%";
		data_header[13][3] = "10";
		
		data_header[14] = new Array;
		data_header[14][0] = "11"
		data_header[14][1] = "data";
		data_header[14][2] = "4%";
		data_header[14][3] = "11";
		
		data_header[15] = new Array;
		data_header[15][0] = "12"
		data_header[15][1] = "data";
		data_header[15][2] = "4%";
		data_header[15][3] = "12";
		
		data_header[16] = new Array;
		data_header[16][0] = "Remarks"
		data_header[16][1] = "data";
		data_header[16][2] = "5%";
		data_header[16][3] = "<%= RequestConstants.CARE_REMARKS %>";
		
		data_header[17] = new Array;
		data_header[17][0] = "Nursing Care Id"
		data_header[17][1] = "hide";
		data_header[17][2] = "1%";
		data_header[17][3] = "<%= RequestConstants.NURSING_SETUP_ID %>";
		
		data_header[18] = new Array;
		data_header[18][0] = "Admission Number"
		data_header[18][1] = "hide";
		data_header[18][2] = "1%";
		data_header[18][3] = "<%= RequestConstants.ADMISSION_NUMBER %>";
		
		data_header[19] = new Array;
		data_header[19][0] = "HinId"
		data_header[19][1] = "hide";
		data_header[19][2] = "1%";
		data_header[19][3] = "<%= RequestConstants.HIN_ID %>";
		
		data_header[20] = new Array;
		data_header[20][0] = "IPD Care Detail Id"
		data_header[20][1] = "hide";
		data_header[20][2] = "1%";
		data_header[20][3] = "<%= RequestConstants.IPDCAREDETAIL_ID %>";
		
		data_header[21] = new Array;
		data_header[21][0] = "Stop"
		data_header[21][1] = "data";
		data_header[21][2] = "1%";
		data_header[21][3] = "stop";
		
		
		data_arr = new Array();
		
		<%
			
			String st="";
		
		    int  i=0;
		    int noOfDays = 0;
		    String stop = "n";
		         for(NursingcareSetup nursingcareSetup : nursingCareSetupList){
		        	  Set<Ipdcaredetail> ipdcaredetail=nursingcareSetup.getIpdcaredetails();
		        	  int frequency=nursingcareSetup.getFrequency().getId();
		        	//  noOfDays = nursingcareSetup.getNoOfDays()!=null?nursingcareSetup.getNoOfDays():0;
		        	stop = nursingcareSetup.getStop()!=null?nursingcareSetup.getStop():"n";
		%>
		
			data_arr[<%= i%>] = new Array();
			
			data_arr[<%= i%>][0] =<%=nursingcareSetup.getId()%>
			
			data_arr[<%= i%>][1] = '<input type="radio" class="radiogrid" name="parent" value="<%=nursingcareSetup.getId()%>" id="parent" />'
			
			<%
				if(nursingcareSetup.getNursing()!=null)
				{
			%>
			data_arr[<%= i%>][2] = "<%=nursingcareSetup.getNursing().getNursingName()%>"
			<%
				}else{
			%>
			data_arr[<%= i%>][2] = ""
			<%
				}
			%>
			data_arr[<%= i%>][3]=""
			
			data_arr[<%= i%>][4]='<input type="text"  name="caretime<%=i%>" id="caretime<%=i%>"  onblur="checkTimeValue(\'nursingCareEntryDetail\',this);" value="<%=caretime%>" MAXLENGTH="5"  />'
			
			<%
			     Iterator itr1=ipdcaredetail.iterator();
			     if(ipdcaredetail.size() > 0){
	        	  while(itr1.hasNext())
	        	  {
	        		  String bool="false";
	        		  int check=0;
	        		  String flag="off";
	        		  Ipdcaredetail ipdObj=(Ipdcaredetail)itr1.next();
	        		  int ipdcaredetailId=ipdObj.getId();
	        		  
	        		  Date date =ipdObj.getDateOfCare();
	        		  String dateInString=HMSUtil.convertDateToStringWithoutTime(date);
	        		
	        		  if(dateInString.equals(currentDate))
	        		  {
	        			  bool="true";
	        			  
	        			  String care1=ipdObj.getCare1();
	        			  String care2=ipdObj.getCare2();
	        			  String remarks=ipdObj.getRemarks();
	        			
	        			  
	        			  if(ipdObj.getCare1()!= null)
	        			  {
	        				  check=1;  
	        	   %>
	    			  data_arr[<%= i%>][5] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="one" checked="true" DISABLED  id="once<%=i%>" /><%=ipdObj.getCare1Time()%>'
	    			    		
	        		<%	 
	        		   }else{
	        			   if(check<frequency && flag.equals("off") && !stop.equals("y"))
	        			   {
	        				   check=1;
	        				   flag="on";
	        		%>
	        			   data_arr[<%= i%>][5] = '<input type="checkbox" class="radiogrid" name="care<%=i%>"   value="one" id="once<%=i%>" />'
	        		<%	   
	        			   }else
	        			   {
	        		%>
	        			data_arr[<%= i%>][5] = '<input type="checkbox" class="radiogrid" name="care<%=i%>"   value="one" DISABLED id="once<%=i%>" />'
	        		<%		   
	        			   }
	        		    }
	        		    if( ipdObj.getCare2() != null )
	        		    {
	        		    	check=2;
	        	  %>
						data_arr[<%= i%>][6] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="two" checked="true" DISABLED  value="" id="twice<%=i%>" /><%=ipdObj.getCare2Time()%>'
						        	  
	        	  <%	
	        		    }else
	        		    {
	        		    	if(check<frequency && flag.equals("off") && !stop.equals("y"))
	        		    	{
	        		    		check=2;
	        		    		flag="on";
	        		%>
	        		data_arr[<%= i%>][6] = '<input type="checkbox" class="radiogrid" name="care<%=i%>"  value="two" id="twice<%=i%>" />'		
	        		<%    
	        		    	}else
	        		    	{
	        		 %>
	        		 data_arr[<%= i%>][6] = '<input type="checkbox" class="radiogrid" name="care<%=i%>"  value="two" DISABLED id="twice<%=i%>" />'
	        		 <%   		
	        		    	}
	        		    }
	        		    if(ipdObj.getCare3()!= null)
	        		    {
	        		    	check=3;
	        		 %>
	        		 data_arr[<%= i%>][7] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="three" checked="true" DISABLED   value="" id="thrice<%=i%>" /><%=ipdObj.getCare3Time()%>'
	        		 
	        		 <%   	
	        		    }
	        		    else{
	        		    	if(check<frequency && flag.equals("off") && !stop.equals("y"))
	        		    	{
	        		    		check=3;
	        		    		flag="on";
	        		 %>
	        		   data_arr[<%= i%>][7] = '<input type="checkbox" class="radiogrid" name="care<%=i%>"   value="three" id="thrice<%=i%>" />'
	        		 <% 
	        		    	}else{
	        		  %>
	        		  data_arr[<%= i%>][7] = '<input type="checkbox" class="radiogrid" name="care<%=i%>"  value="three" DISABLED id="thrice<%=i%>" />'
	        		  <%  		
	        		    	}
	        		    }
	        		    if(ipdObj.getCare4() != null)
	        		    {
	        		    	check=4;
	        		  %>
	        		  data_arr[<%= i%>][8] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="four" checked="true" DISABLED value="" id="4 times<%=i%>" /><%=ipdObj.getCare4Time()%>'
	        		  <%
	        		    }else{
	        		    	if(check<frequency  && flag.equals("off")  && !stop.equals("y"))
	        		    	{
	        		    		check=4;
	        		    		flag="on";
	        		 %>
	        		  data_arr[<%= i%>][8] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="four" id="4 times<%=i%>" />'
	        		 <%
	        		    	}else{
	        		 %>
	        		  data_arr[<%= i%>][8] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="four" DISABLED id="4 times<%=i%>" />'
	        		 <% 		
	        		    	}
	        		    }
	        		    if(ipdObj.getCare5() != null)
	        		    {
	        		    	check=5;
	        		 %>
	        		 data_arr[<%= i%>][9] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="five" checked="true" DISABLED value="" id="5 times<%=i%>" /><%=ipdObj.getCare5Time()%>'
	        		 <%   	
	        		    }else{
	        		    	if(check<frequency && flag.equals("off") && !stop.equals("y"))
	        		    	{
	        		    		check=5;
	        		    		flag="on";
	        		  %>
	        		  data_arr[<%= i%>][9] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="five" id="5 times<%=i%>" />'
	        		  <%  		
	        		    	}else{
	        		   %>
	        		   data_arr[<%= i%>][9] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="five" DISABLED id="5 times<%=i%>" />'
	        		   <% 		
	        		    	}
	        		    }
	        		    if(ipdObj.getCare6() != null)
	        		    {
	        		    	check=6;
	        		   %>
	        		   data_arr[<%= i%>][10] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="six" checked="true" DISABLED value="" id="6 times<%=i%>" /><%=ipdObj.getCare6Time()%>'
	        		   <% 
	        		    }else{
	        		    	if(check<frequency && flag.equals("off") && !stop.equals("y"))
	        		    	{
	        		    		check=6;
	        		    		flag="on";
	        		   %>
	        		   data_arr[<%= i%>][10] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="six" id="6 times<%=i%>" />'
	        		   <%
	        		    	}else{
	        		   %>
	        		   data_arr[<%= i%>][10] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="six" DISABLED  id="6 times<%=i%>" />'
	        		   <% 		
	        		    	}
	        		    }
	        		    if(ipdObj.getCare7() != null)
	        		    {
	        		    	check=7;
	        		   %>
	        		   data_arr[<%= i%>][11] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="seven" checked="true" DISABLED value="" id="7 times<%=i%>" /><%=ipdObj.getCare7Time()%>'
	        		   <% 	
	        		    }else{
	        		    	if(check<frequency && flag.equals("off") && !stop.equals("y"))
	        		    	{
	        		    		check=7;
	        		    		flag="on";
	        		   %>
	        		   data_arr[<%= i%>][11] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="seven" id="7 times<%=i%>" />'
	        		   <% 		
	        		    	}else{
	        		    %>
	        		    data_arr[<%= i%>][11] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="seven" DISABLED id="7 times<%=i%>" />'
	        		    <%		
	        		    	}
	        		    }
	        		    if(ipdObj.getCare8() != null)
	        		    {
	        		    	check=8;
	        		   %>
	        		   data_arr[<%= i%>][12] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="eight" checked="true" DISABLED value="" id="8 times<%=i%>" /><%=ipdObj.getCare8Time()%>'
	        		   <% 	
	        		    }else{
	        		    	if(check<frequency && flag.equals("off")  && !stop.equals("y"))
	        		    	{
	        		    		check=8;
	        		    		flag="on";
	        		   %>
	        		   data_arr[<%= i%>][12] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="eight" id="8 times<%=i%>" />'
	        		   <% 		
	        		    	}else{
	        		    %>
	        		    data_arr[<%= i%>][12] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="eight" DISABLED id="8 times<%=i%>" />'
	        		    <%		
	        		    	}
	        		    }
	        		    if(ipdObj.getCare9() != null)
	        		    {
	        		    	check=9;
	        		   %>
	        		   data_arr[<%= i%>][13] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="nine" checked="true" DISABLED value="" id="9 times<%=i%>" /><%=ipdObj.getCare9Time()%>'
	        		   <% 	
	        		    }else{
	        		    	if(check<frequency && flag.equals("off") && !stop.equals("y"))
	        		    	{
	        		    		check=9;
	        		    		flag="on";
	        		   %>
	        		   data_arr[<%= i%>][13] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="nine" id="9 times<%=i%>" />'
	        		   <% 		
	        		    	}else{
	        		    %>
	        		    data_arr[<%= i%>][13] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="nine" DISABLED id="9 times<%=i%>" />'
	        		    <%		
	        		    	}
	        		    }
	        		    if(ipdObj.getCare10() != null)
	        		    {
	        		    	check=10;
	        		   %>
	        		   data_arr[<%= i%>][14] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="ten" checked="true" DISABLED value="" id="10 times<%=i%>" /><%=ipdObj.getCare10Time()%>'
	        		   <% 	
	        		    }else{
	        		    	if(check<frequency && flag.equals("off") && !stop.equals("y"))
	        		    	{
	        		    		check=10;
	        		    		flag="on";
	        		    %>
	        		    data_arr[<%= i%>][14] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="ten" id="10 times<%=i%>" />'
	        		    <%		
	        		    	}else{
	        		    %>
	        		    data_arr[<%= i%>][14] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="ten" DISABLED id="10 times<%=i%>" />'
	        		    <%		
	        		    	}
	        		    }
	        		    if(ipdObj.getCare11() != null)
	        		    {
	        		    	check=11;
	        		   %>
	        		   data_arr[<%= i%>][15] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="eleven" checked="true" DISABLED value="" id="11 times<%=i%>" /><%=ipdObj.getCare11Time()%>'
	        		   <% 	
	        		    }else{
	        		    	if(check<frequency && flag.equals("off") && !stop.equals("y"))
	        		    	{
	        		    		check=11;
	        		    		flag="on";
	        		    %>
	        		    data_arr[<%= i%>][15] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="eleven" id="11 times<%=i%>" />'
	        		    <%		
	        		    	}else{
	        		    %>
	        		    data_arr[<%= i%>][15] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="eleven" DISABLED id="11 times<%=i%>" />'
	        		    <%		
	        		    	}
	        		    }
	        		    if(ipdObj.getCare12() != null)
	        		    {
	        		    	check=12;
	        		   %>
	        		   data_arr[<%= i%>][16] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="twelve" checked="true" DISABLED value="" id="12 times<%=i%>" /><%=ipdObj.getCare12Time()%>'
	        		   <% 	
	        		    }else{
	        		    	if(check<frequency && flag.equals("off") && !stop.equals("y"))
	        		    	{
	        		    		check=12;
	        		    		flag="on";
	        		    %>
	        		    data_arr[<%= i%>][16] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="twelve" id="12 times<%=i%>" />'
	        		    <%		
	        		    	}else{
	        		    %>
	        		    data_arr[<%= i%>][16] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="twelve" DISABLED id="12 times<%=i%>" />'
	        		    <%		
	        		    	}
	        		    }if(remarks != null)
	        		    {
	        		   %>
	        		    data_arr[<%= i%>][17] = '<input type="text"  name="careremarks<%=i%>" id="careremarks<%=i%>" value="<%=remarks%>"  style="width: 190px; border: 1px solid #7f9db7;" MAXLENGTH="50" />'
	        		   <%
	        		    }else{
	        		   %>
	        		   data_arr[<%= i%>][17] = '<input type="text"  name="careremarks<%=i%>" id="careremarks<%=i%>" value=""  style="width: 190px; border: 1px solid #7f9db7;" MAXLENGTH="50" />'
	        		   <% 	
	        		    }
	        		    %>
	        		   
	        		    data_arr[<%= i%>][18] = '<input type="hidden"  name="nursingId<%=i%>" value="<%=nursingcareSetup.getId()%>"  />'
	        		    data_arr[<%= i%>][19] = '<input type="hidden"  name="adNo<%=i%>" value="<%=nursingcareSetup.getAdNo()%>"  />'
	        		    data_arr[<%= i%>][20] = '<input type="hidden"  name="hinId<%=i%>" value="<%=patient.getId()%>"  />'
	        		    data_arr[<%= i%>][21] = '<input type="hidden"  name="ipdcaredetailId<%=i%>" value="<%=ipdObj.getId()%>"  />'
						<%
						if(stop.equals("y")){
						%>
       		    	   data_arr[<%= i%>][22] = '<input type="checkbox" class="radiogrid" name="stop<%=i%>" value="y" checked  id="stop<%=i%>" />'
	        		    <%}else{
	        		    	%>
	        		    	data_arr[<%= i%>][22] = '<input type="checkbox" class="radiogrid" name="stop<%=i%>" value="y"  id="stop<%=i%>" />'
	        		    <%}
	        		    break;
	        			  
	        		  }
	        		  if(bool.equals("false"))
	        		  {
	        	%>
	        		 data_arr[<%= i%>][5] = '<input type="checkbox" class="radiogrid" name="care<%=i%>"   value="one" id="once<%=i%>" />'
	        		 data_arr[<%= i%>][6] = '<input type="checkbox" class="radiogrid" name="care<%=i%>"  value="two" DISABLED id="twice<%=i%>" />'
	        		 data_arr[<%= i%>][7] = '<input type="checkbox" class="radiogrid" name="care<%=i%>"   value="three" DISABLED id="thrice<%=i%>" />'
	        		 data_arr[<%= i%>][8] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="four" DISABLED id="4 times<%=i%>" />'
	        		   data_arr[<%= i%>][9] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="five" DISABLED id="5 times<%=i%>" />'
	        		  data_arr[<%= i%>][10] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="six" DISABLED  id="6 times<%=i%>" />'
	        		 data_arr[<%= i%>][11] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="seven" DISABLED id="7 times<%=i%>" />'
	        		 data_arr[<%= i%>][12] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="eight" DISABLED id="8 times<%=i%>" />'
	        		 data_arr[<%= i%>][13] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="nine" DISABLED id="9 times<%=i%>" />'
	        		 data_arr[<%= i%>][14] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="ten" DISABLED id="10 times<%=i%>" />'
	        		  data_arr[<%= i%>][15] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="eleven" DISABLED id="11 times<%=i%>" />'
	        		  data_arr[<%= i%>][16] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="twelve" DISABLED id="12 times<%=i%>" />'
	        		  data_arr[<%= i%>][17] = '<input type="text"  name="careremarks<%=i%>" id="careremarks<%=i%>" style="width: 190px; border: 1px solid #7f9db7;" value="" MAXLENGTH="50" />'
	        		  data_arr[<%= i%>][18] = '<input type="hidden"  name="nursingId<%=i%>" value="<%=nursingcareSetup.getId()%>"  />'
	        		  data_arr[<%= i%>][19] = '<input type="hidden"  name="adNo<%=i%>" value="<%=nursingcareSetup.getAdNo()%>"  />'
	        		  data_arr[<%= i%>][20] = '<input type="hidden"  name="hinId<%=i%>" value="<%=patient.getId()%>"  />'
	        		  data_arr[<%= i%>][21] = '<input type="hidden"  name="ipdcaredetailId<%=i%>" value="notvalid"  />'
	        		  data_arr[<%= i%>][22] = '<input type="checkbox" class="radiogrid" name="stop<%=i%>" value="y"  id="stop<%=i%>" />'
	        		        	
	        	<%		  
	        		  }
	        	    }
			     }else{
			    %>
					data_arr[<%= i%>][5] = '<input type="checkbox" class="radiogrid" name="care<%=i%>"   value="one" id="once<%=i%>" />'
	        		data_arr[<%= i%>][6] = '<input type="checkbox" class="radiogrid" name="care<%=i%>"  value="two" DISABLED id="twice<%=i%>" />'
	        		data_arr[<%= i%>][7] = '<input type="checkbox" class="radiogrid" name="care<%=i%>"   value="three" DISABLED id="thrice<%=i%>" />'
	        		data_arr[<%= i%>][8] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="four" DISABLED id="4 times<%=i%>" />'
	        		  data_arr[<%= i%>][9] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="five" DISABLED id="5 times<%=i%>" />'
	        		 data_arr[<%= i%>][10] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="six" DISABLED  id="6 times<%=i%>" />'
	        		data_arr[<%= i%>][11] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="seven" DISABLED id="7 times<%=i%>" />'
	        		 data_arr[<%= i%>][12] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="eight" DISABLED id="8 times<%=i%>" />'
	        		 data_arr[<%= i%>][13] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="nine" DISABLED id="9 times<%=i%>" />'
	        		 data_arr[<%= i%>][14] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="ten" DISABLED id="10 times<%=i%>" />'
	        		 data_arr[<%= i%>][15] = '<input type="checkbox" class="radiogrid" name="care<%=i%>" value="eleven" DISABLED id="11 times<%=i%>" />'
	        		 data_arr[<%= i%>][16] = '<input type="checkbox" class="radiogrid" name="care<%=i%>"  value="twelve" DISABLED id="12 times<%=i%>" />'
	        		 data_arr[<%= i%>][17] = '<input type="text"  name="careremarks<%=i%>" id="careremarks<%=i%>" style="width: 190px; border: 1px solid #7f9db7;" value="<%=nursingcareSetup.getRemarks()!=null?nursingcareSetup.getRemarks():""%>" MAXLENGTH="50" />'
	        		 data_arr[<%= i%>][18] = '<input type="hidden"  name="nursingId<%=i%>" value="<%=nursingcareSetup.getId()%>"  />'
	        		 data_arr[<%= i%>][19] = '<input type="hidden"  name="adNo<%=i%>" value="<%=nursingcareSetup.getAdNo()%>"  />'
	        		 data_arr[<%= i%>][20] = '<input type="hidden"  name="hinId<%=i%>" value="<%=patient.getId()%>"  />'
	        		 data_arr[<%= i%>][21] = '<input type="hidden"  name="ipdcaredetailId<%=i%>" value="notvalid"  />'
	        		data_arr[<%= i%>][22] = '<input type="checkbox" class="radiogrid" name="stop<%=i%>" value="y"  id="stop<%=i%>" />'
	        		        	
				<%
			     }				
				%>
			
			
		<% 
		    
			i++;
		      
		  }
		%>
		 
		formName = "nursingCareEntryDetail"
		
		
		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeGrid(start,end);
		
		intializeHover('searchresulttable', 'TR', ' tableover');		
	</script> <!--  <input type="button" class="button"  value="Clinical Setup" align="left" onClick="submitForm('patientList','ipd?method=showNursingCareJsp','validateRadio');" />-->


<input type="hidden" name="counter" id="counter" value="<%=i %>" />


<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>

<input type="button" class="button" value="Submit " align="left"
	onClick="submitForm('nursingCareEntryDetail','ipd?method=submitNursingCareEntryDetails','validateCheckbox');" />
<!--<input type="button" class="button" value="Print " align="left"
	onClick="submitForm('nursingCareEntryDetail','ipd?method=showNursingCareReportJsp');" />
--><input type="button" class="button" value="Back" align="left"
	onClick="submitForm('nursingCareEntryDetail','ipd?method=showPatientListJsp');" />
<input type="reset" name="reset" value="Reset"/>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
</form>

<script>


function checkTimeFormat(){
	
	var chtime=document.getElementById("caretime").value
 	if(chtime==""){
		alert('Changed Time  can not be blank')
		return false
	}
	 if(chtime!= ""){
	 			var index=chtime.indexOf(':');
	 			//alert(index)
				if(!validateInteger(trimAll(chtime)))
				{
					alert(" Time should be a number(without spaces) without special Characters in HH:MM Format.");
					return false						
				}
				if(index == -1)
				  alert("Please Enter The Time in Correct Format.")
					
	
		 //var indx = chtime.indexOf(':');
		 
		 if (index != -1) {
		 var pairs2 = chtime.substring(0,chtime.length).split(':');
		 }
				 
		 if (pairs2.length!=2) { 
			 alert("Invalid Time Format.It should be HH:MM")
			return false;
			}
		 
		 if (pairs2[0].length != 2 || pairs2[1].length != 2 ) {
				  alert("Invalid Time Format.It should be HH:MM")
				  return false;
				}
		 
		 		 val2=eval(pairs2[0]);
		 			
						  if (val2<0 || val2>23) {
							  alert("Hours should 00-23")
					 		 return false;}
					 		 
					 		 val3=eval(pairs2[1]);
		 		
							  if (val3<0 || val3>59) {
							  alert("Min should 00-59")
					 		 return false;}
			 			
		return true;	  
	}
	}

</script>




