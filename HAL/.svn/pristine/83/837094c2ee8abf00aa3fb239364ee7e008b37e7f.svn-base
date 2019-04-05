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
<%@page import="jkt.hms.masters.business.PatientDietIndoorDetail"%>
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

<%	List<PatientDietIndoorDetail> patientDietIndoorDetailList = new ArrayList<PatientDietIndoorDetail>();
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

	if(map.get("patientDietIndoorDetailList") != null)
	{
		patientDietIndoorDetailList=(List<PatientDietIndoorDetail>)map.get("patientDietIndoorDetailList");
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
if(patientDietIndoorDetailList.size() > 0){
%>
<div class="Clear"></div>
<h4>Diet Entry</h4>
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
<input type="hidden" id="inpatientId" name="inpatientId" value="<%=inpatient.getId()%>"/>

<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>



<script type="text/javascript" language="javascript">
	
	formFields = [
			[0, "id"],[1, "<%= RequestConstants.RADIO_FOR_TABLE%>"], [2,"date"], [3,"<%= RequestConstants.PATIENT_NAME %>"],[4,"<%= RequestConstants.CARE_TIME %>"], [5,"BreakFast"],[6,"Lunch"],[7,"Dinner"],[8, "<%= RequestConstants.CARE_REMARKS%>"],[9, "<%= RequestConstants.NURSING_SETUP_ID%>"],[10, "<%= RequestConstants.ADMISSION_NUMBER%>"],[11, "<%= RequestConstants.HIN_ID%>"],[12, "<%= RequestConstants.IPDCAREDETAIL_ID%>"] ];
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
		data_header[1][0] = "Date"
		data_header[1][1] = "data";
		data_header[1][2] = "8%";
		data_header[1][3] = "date"
		
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
		data_header[4][0] = "BreakFast"
		data_header[4][1] = "data";
		data_header[4][2] = "24%";
		data_header[4][3] = "1";
		
		data_header[5] = new Array;
		data_header[5][0] = "Lunch"
		data_header[5][1] = "data";
		data_header[5][2] = "24%";
		data_header[5][3] = "2";
		
		data_header[6] = new Array;
		data_header[6][0] = "Dinner"
		data_header[6][1] = "data";
		data_header[6][2] = "8%";
		data_header[6][3] = "3";
		
		
		data_header[7] = new Array;
		data_header[7][0] = "Remarks"
		data_header[7][1] = "data";
		data_header[7][2] = "5%";
		data_header[7][3] = "<%= RequestConstants.CARE_REMARKS %>";
		
		data_header[8] = new Array;
		data_header[8][0] = "Nursing Care Id"
		data_header[8][1] = "hide";
		data_header[8][2] = "1%";
		data_header[8][3] = "<%= RequestConstants.NURSING_SETUP_ID %>";
		
		data_header[9] = new Array;
		data_header[9][0] = "Admission Number"
		data_header[9][1] = "hide";
		data_header[9][2] = "1%";
		data_header[9][3] = "<%= RequestConstants.ADMISSION_NUMBER %>";
		
		data_header[10] = new Array;
		data_header[10][0] = "HinId"
		data_header[10][1] = "hide";
		data_header[10][2] = "1%";
		data_header[10][3] = "<%= RequestConstants.HIN_ID %>";
		
		data_header[11] = new Array;
		data_header[11][0] = "IPD Care Detail Id"
		data_header[11][1] = "hide";
		data_header[11][2] = "1%";
		data_header[11][3] = "<%= RequestConstants.IPDCAREDETAIL_ID %>";
		
		
		
		
		data_arr = new Array();
		
		<%
			
			String st="";
		
		    int  i=0;
		    int noOfDays = 0;
		    String stop = "n";
		    String bool="false";
		    if(patientDietIndoorDetailList.size() > 0){
	        	 
		         for(PatientDietIndoorDetail patientDietIndoorDetail : patientDietIndoorDetailList){
		        	  int check=0;
	        		  String flag="off";
	        		  
	        		  int ipddietdetailId=patientDietIndoorDetail.getId();
	        		  
	        		  Date date =patientDietIndoorDetail.getEntryDate();
	        		  String dateInString=HMSUtil.convertDateToStringWithoutTime(date);
	        		
		        	
		%>
		
			data_arr[<%= i%>] = new Array();
			
			data_arr[<%= i%>][0] =<%=patientDietIndoorDetail.getId()%>
			
			data_arr[<%= i%>][1] = '<input type="radio" class="radiogrid" name="parent" value="<%=patientDietIndoorDetail.getId()%>" id="parent" />'
			
			<%
				if(patientDietIndoorDetail.getEntryDate()!=null)
				{
			%>
			data_arr[<%= i%>][2] = "<%=dateInString%>"
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
			   
			   
	        		  
	        		System.out.println("dateInString"+dateInString);
			System.out.println("currentDate"+currentDate);
	        		  if(dateInString.equalsIgnoreCase(currentDate))
	        		  {
	        			  bool="true";
	        			  
	        			  String care1=patientDietIndoorDetail.getMorningTeaBread();
	        			  String care2=patientDietIndoorDetail.getLunch();
	        			  String remarks=patientDietIndoorDetail.getSpecialInst();
	        			
	        			  
	        			  if(patientDietIndoorDetail.getMorningTeaBread()!= null)
	        			  {
	        				  check=1;  
	        	   %>
	    			  data_arr[<%= i%>][5] = '<input type="checkbox" class="radiogrid" name="breakfast<%=i%>" value="breakfast" checked="true" DISABLED  id="breakfast<%=i%>" /><%=patientDietIndoorDetail.getBreakfastTime()!=null?patientDietIndoorDetail.getBreakfastTime():""%>'
	    			    		
	        		<%	 
	        		   }
	        			  else
	        			   {
	        		%>
	        			data_arr[<%= i%>][5] = '<input type="checkbox" class="radiogrid" name="care<%=i%>"   value="breakfast"  id="breakfast<%=i%>" />'
	        		<%		   
	        			   }
	        		    
	        		    if( patientDietIndoorDetail.getLunch() != null )
	        		    {
	        		    	check=2;
	        	  %>
						data_arr[<%= i%>][6] = '<input type="checkbox" class="radiogrid" name="lunch<%=i%>" value="lunch" checked="true" DISABLED  value="" id="lunch<%=i%>" /><%=patientDietIndoorDetail.getLunchTime()!=null?patientDietIndoorDetail.getLunchTime():""%>'
						        	  
	        	  <%	
	        		    }  else
	        		    	{
	        		 %>
	        		 data_arr[<%= i%>][6] = '<input type="checkbox" class="radiogrid" name="lunch<%=i%>"  value="lunch"  id="lunch<%=i%>" />'
	        		 <%   		
	        		    	}
	        		    
	        		    if(patientDietIndoorDetail.getDinner()!= null)
	        		    {
	        		    	check=3;
	        		 %>
	        		 data_arr[<%= i%>][7] = '<input type="checkbox" class="radiogrid" name="dinner<%=i%>" value="dinner" checked="true" DISABLED   value="" id="dinner<%=i%>" /><%=patientDietIndoorDetail.getDinnerTime()!=null?patientDietIndoorDetail.getDinnerTime():""%>'
	        		 
	        		 <%   	
	        		    }
	        		    
	        		    	else{
	        		  %>
	        		  data_arr[<%= i%>][7] = '<input type="checkbox" class="radiogrid" name="dinner<%=i%>"  value="dinner"  id="dinner<%=i%>" />'
	        		  <%  		
	        		    	}
	        		    
	        		  if(remarks != null)
	        		    {
	        		   %>
	        		    data_arr[<%= i%>][8] = '<input type="text"  name="remarks<%=i%>" id="remarks<%=i%>" value="<%=remarks%>"  style="width: 190px; border: 1px solid #7f9db7;" MAXLENGTH="50" />'
	        		   <%
	        		    }else{
	        		   %>
	        		   data_arr[<%= i%>][8] = '<input type="text"  name="remarks<%=i%>" id="remarks<%=i%>" value=""  style="width: 190px; border: 1px solid #7f9db7;" MAXLENGTH="50" />'
	        		   <% 	
	        		    }
	        		    %>
	        		   
	        		    data_arr[<%= i%>][9] = '<input type="hidden"  name="id<%=i%>" value=""  />'
	        		    data_arr[<%= i%>][10] = '<input type="hidden"  name="adNo<%=i%>" value=""  />'
	        		    data_arr[<%= i%>][11] = '<input type="hidden"  name="hinId<%=i%>" value="<%=patient.getId()%>"  />'
	        		    data_arr[<%= i%>][12] = '<input type="hidden"  name="ipdcaredetailId<%=i%>" value=""  />'
						<%
					
	        			  
	        		  
	        
	        	    
	        		    i++;
	        		  }
	        		  else 
	        			  {
	        			  String care1=patientDietIndoorDetail.getMorningTeaBread();
	        			  String care2=patientDietIndoorDetail.getLunch();
	        			  String remarks=patientDietIndoorDetail.getSpecialInst();
	        			
	        			  
	        			  if(patientDietIndoorDetail.getMorningTeaBread()!= null)
	        			  {
	        				  check=1;  
	        	   %>
	    			  data_arr[<%= i%>][5] = '<input type="checkbox" class="radiogrid" name="breakfast<%=i%>" value="breakfast" checked="true" DISABLED  id="breakfast<%=i%>" /><%=patientDietIndoorDetail.getBreakfastTime()!=null?patientDietIndoorDetail.getBreakfastTime():""%>'
	    			    		
	        		<%	 
	        		   }
	        			  else
	        			   {
	        		%>
	        			data_arr[<%= i%>][5] = '<input type="checkbox" class="radiogrid" name="care<%=i%>"   value="breakfast" DISABLED id="breakfast<%=i%>" />'
	        		<%		   
	        			   }
	        		    
	        		    if( patientDietIndoorDetail.getLunch() != null )
	        		    {
	        		    	check=2;
	        	  %>
						data_arr[<%= i%>][6] = '<input type="checkbox" class="radiogrid" name="lunch<%=i%>" value="lunch" checked="true" DISABLED  value="" id="lunch<%=i%>" /><%=patientDietIndoorDetail.getLunchTime()!=null?patientDietIndoorDetail.getLunchTime():""%>'
						        	  
	        	  <%	
	        		    }  else
	        		    	{
	        		 %>
	        		 data_arr[<%= i%>][6] = '<input type="checkbox" class="radiogrid" name="lunch<%=i%>"  value="lunch" DISABLED id="lunch<%=i%>" />'
	        		 <%   		
	        		    	}
	        		    
	        		    if(patientDietIndoorDetail.getDinner()!= null)
	        		    {
	        		    	check=3;
	        		 %>
	        		 data_arr[<%= i%>][7] = '<input type="checkbox" class="radiogrid" name="dinner<%=i%>" value="dinner" checked="true" DISABLED   value="" id="dinner<%=i%>" /><%=patientDietIndoorDetail.getDinnerTime()!=null?patientDietIndoorDetail.getDinnerTime():""%>'
	        		 
	        		 <%   	
	        		    }
	        		    
	        		    	else{
	        		  %>
	        		  data_arr[<%= i%>][7] = '<input type="checkbox" class="radiogrid" name="dinner<%=i%>"  value="dinner" DISABLED id="dinner<%=i%>" />'
	        		  <%  		
	        		    	}
	        		    
	        		  if(remarks != null)
	        		    {
	        		   %>
	        		    data_arr[<%= i%>][8] = '<input type="text"  name="remarks<%=i%>" id="remarks<%=i%>" value="<%=remarks%>"  style="width: 190px; border: 1px solid #7f9db7;" MAXLENGTH="50" />'
	        		   <%
	        		    }else{
	        		   %>
	        		   data_arr[<%= i%>][8] = '<input type="text"  name="remarks<%=i%>" id="remarks<%=i%>" value=""  style="width: 190px; border: 1px solid #7f9db7;" MAXLENGTH="50" />'
	        		   <% 	
	        		    }
	        		    %>
	        		   
	        		    data_arr[<%= i%>][9] = '<input type="hidden"  name="id<%=i%>" value=""  />'
	        		    data_arr[<%= i%>][10] = '<input type="hidden"  name="adNo<%=i%>" value=""  />'
	        		    data_arr[<%= i%>][11] = '<input type="hidden"  name="hinId<%=i%>" value="<%=patient.getId()%>"  />'
	        		    data_arr[<%= i%>][12] = '<input type="hidden"  name="ipdcaredetailId<%=i%>" value=""  />'
						<%
					
	        			  
	        		  
	        
	        	    
	        		    i++;
		         }
	        		    }
			     
			      
				  }
		    if(bool.equals("false")){
					  %>
						data_arr[<%= i%>] = new Array();
						
						data_arr[<%= i%>][0] =""
						
						data_arr[<%= i%>][1] = '<input type="radio" class="radiogrid" name="parent" value="" id="parent" />'
						
						
						data_arr[<%= i%>][2] = "<%=currentDate%>"
						
						data_arr[<%= i%>][3]=""
						
						data_arr[<%= i%>][4]='<input type="text"  name="caretime<%=i%>" id="caretime<%=i%>"  onblur="checkTimeValue(\'nursingCareEntryDetail\',this);" value="<%=caretime%>" MAXLENGTH="5"  />'
						
			    
					data_arr[<%= i%>][5] = '<input type="checkbox" class="radiogrid" name="breakfast<%=i%>"   value="breakfast" id="breakfast<%=i%>" />'
	        		data_arr[<%= i%>][6] = '<input type="checkbox" class="radiogrid" name="lunch<%=i%>"  value="lunch"  id="lunch<%=i%>" />'
	        		data_arr[<%= i%>][7] = '<input type="checkbox" class="radiogrid" name="dinner<%=i%>"   value="dinner"  id="dinner<%=i%>" />'
	        		
	        		 data_arr[<%= i%>][8] = '<input type="text"  name="remarks<%=i%>" id="remarks<%=i%>" style="width: 190px; border: 1px solid #7f9db7;" value="" MAXLENGTH="50" />'
	        		 data_arr[<%= i%>][9] = '<input type="hidden"  name="id<%=i%>" value=""  />'
	        		 data_arr[<%= i%>][10] = '<input type="hidden"  name="adNo<%=i%>" value=""  />'
	        		 data_arr[<%= i%>][11] = '<input type="hidden"  name="hinId<%=i%>" value="<%=patient.getId()%>"  />'
	        		 data_arr[<%= i%>][12] = '<input type="hidden"  name="ipdcaredetailId<%=i%>" value="notvalid"  />'
	        		
	        		        	
				<%
				 i++;
			     }				
				%>
			
			
		<% 
		    
			
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


<input type="hidden" name="counter" id="counter" value="<%=i%>" />


<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>

<input type="button" class="button" value="Submit " align="left"
	onClick="submitForm('nursingCareEntryDetail','ipd?method=submitDietEntryDetails','validateCheckbox');" />
<!--<input type="button" class="button" value="Print " align="left"
	onClick="submitForm('nursingCareEntryDetail','ipd?method=showNursingCareReportJsp');" />
--><input type="button" class="button" value="Back" align="left"
	onClick="submitForm('nursingCareEntryDetail','ipd?method=showPatientListJsp');" />
<input type="reset" name="reset" value="Reset" class="button" onclick="location.reload();"/>
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




