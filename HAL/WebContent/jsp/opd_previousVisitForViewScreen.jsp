
<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * showPatientList.jsp  
 * Purpose of the JSP -  This is Show Patient List.
 * @author  Deepti
 * @author  Ritu
 * Create Date: 21st Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.15
--%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.OpdPatientHistory"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.SilDilStatus"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js?n=1"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/jquery.min.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js?n=1"></script>
<link href="/hms/jsp/css/style.css?n=1" rel="stylesheet" type="text/css" />
<!-- <script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script> -->
<!-- <META HTTP-EQUIV="REFRESH" CONTENT="20"> -->
<script type="text/javascript">
	<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
	</script>
<%
		Map map = new HashMap();
		//String includedJsp = null;
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
	
		}
		int visitNoForJsp=0;
		int visitId=0;
		int token=0;
		String backFlag = "";
		String medExamType ="";
		if(map.get("visitNoForJsp") != null){
			visitNoForJsp=(Integer)map.get("visitNoForJsp");
		}
		if(map.get("backFlag") != null){
			backFlag=(String)map.get("backFlag");
		}
		String url = "";
		
		if(map.get("token") != null){
			token = (Integer)map.get("token");
		}
		if(map.get("visitId") != null){
			visitId = (Integer)map.get("visitId");
		}
		//System.out.println("medExamType  in opdPreviousVisit***********"+map.get("medExamType"));
       /* if(map.get("medExamType")!= null)
          {
        	medExamType = (String)map.get("medExamType");
          }*/
		
          
	List<OpdPatientHistory> patientPreviousVisitList = new ArrayList<OpdPatientHistory>();
	List<Integer> maxVisitIdList = new ArrayList<Integer>();
	List<Integer> minVisitIdList = new ArrayList<Integer>();
	
	if(map.get("patientPreviousVisitList") != null){
		patientPreviousVisitList=(List<OpdPatientHistory>)map.get("patientPreviousVisitList");
	}
	if(map.get("url") != null)
	  {
		url = ""+map.get("url");
		
	  }
	//url=url+"&visitId="+visitId+"&medExamType="+medExamType;
	
	
	if(map.get("maxVisitIdList") != null){
		maxVisitIdList=(List)map.get("maxVisitIdList");
	}	
	if(map.get("minVisitIdList") != null){
		minVisitIdList=(List)map.get("minVisitIdList");
	}	
	String link="";
	if(map.get("link") != null){
		link=(String)map.get("link");
	}
	String flag="";
	if(map.get("flag")!=null){
		flag = (String)map.get("flag");
	}
	String FlagFOrMedExamMa = "";
	if(map.get("FlagFOrMedExamMa")!= null)
	{
		FlagFOrMedExamMa = (String)map.get("FlagFOrMedExamMa");
	}
	if(patientPreviousVisitList.size() > 0){

		OpdPatientHistory visitObj = patientPreviousVisitList.get(0);
	//Visit visitObj=(Visit)patientPreviousVisitList.get(0);
	Patient patientObj=visitObj.getHin();
	String pName="";
	if(visitObj.getHin().getPFirstName()!= null){
		pName=visitObj.getHin().getPFirstName();
	}
	if(visitObj.getHin().getPMiddleName()!= null){
		pName=pName+" "+visitObj.getHin().getPMiddleName();
	}
	if(visitObj.getHin().getPLastName()!= null){
		pName=pName+" "+visitObj.getHin().getPLastName();
	}
	// String visitDateInString =HMSUtil.changeDateToddMMyyyy(visitObj.getVisitDate());
	int deptId=0;
	if(visitObj.getDepartment()!=null)
		deptId = visitObj.getDepartment().getId();
	MasAdministrativeSex masAdministrativeSexObj=patientObj.getSex();
%>

<div class="popupbg">
<div class="titleBg"><h2>Previous Visits</h2></div>

<div id="resultnavigation1">
<form name="3231" method="post" action=""></form>

<form name="paging1" method="post" action="">

  
  <span id="currStart1"  style="display: none;">1</span>
  <span id="currEnd1" style="display: none;">5</span>
  <span	id="totalRecs1" style="display: none;"></span>
  <!--
  <input type="hidden" id="totalRecs" name=""/>
    <input type="hidden" id="currEnd" name=""/>
    
    
        <input type="hidden" id="currStart" name=""/>
--><input type="button" class="previous" name="firstpage1" value="f"	onClick="navigate11(this)" accesskey="f" />
<input type="button" name="prevpage1" value="p" onClick="navigate11(this)" accesskey="p" class="singlePrev" /> Page <span id="current1">1</span> of <span
	id="total1">2</span> 
	<input type="button" name="nextpage1" value="n" onClick="navigate11(this)" accesskey="n" class="singleNext" /> 
	<input type="button" name="lastpage1" value="l" onClick="navigate11(this)" accesskey="l" class="next" /> 
	<input name="pageno1" type="text" id="pageno1" MAXLENGTH="4" tabindex=1 onkeypress="return onEnter(event,paging);" /> 
	<input type="button" value="Go" class="button" name="ok" tabindex="1"
	onClick="goToPage(pageno1.value)" />
	</form>
	
</div>
<div class="Clear"></div>



<form name="323" method="post" action=""></form>


<form name="opdPatientPrevVisitForViewScreen1" method="post" action="">

<!-- <input type="button" class="button"  value="Clinical Setup" align="left" onClick="submitForm('patientList','ipd?method=showNursingCareJsp','validateRadio');" />-->




<div id="searchresults" tabindex=2>
<div id="searchtable1" tabindex=2></div>


<script type="text/javascript" language="javascript">
	
	formFields = [
			[0, "<%= RequestConstants.HIN_ID%>", "id"],[1, "<%= RequestConstants.RADIO_FOR_TABLE%>"], [2,"<%= RequestConstants.TOKEN_NO%>"], [3,"<%= RequestConstants.VISIT_ID %>","visitId"], [4,"<%= RequestConstants.SERVICE_NO %>"],[5,"<%= RequestConstants.VISIT_TIME %>"],[6,"<%= RequestConstants.SERVICE_NO %>"],[7,"<%=RequestConstants.HIN_NO%>"],[8,"<%= RequestConstants.PATIENT_NAME %>"],[9,"<%=RequestConstants.AGE%>"],[10,"<%=RequestConstants.SEX%>"],[11,"<%=RequestConstants.DIAGNOSIS_ID%>"],[12,"visitNoForJsp"],[13,"disposal"],[14,"days"]  ];
	 //statusTd =13;

</script></div>
<div id="edited"></div>
<div id="statusMessage" ></div>
<input type="hidden" name="serviceNoForReport" id="serviceNoForReport"	value="<%=visitObj.getHin().getServiceNo()%>" />
<input type="hidden" name="hospitalIdForReport"	id="hospitalIdForReport" value="" />
<input type="hidden"	name="hinNoForReport" id="hinNoForReport" value="<%=visitObj.getHin().getHinNo()%>" />
 	<input name="visitId" id="visitId" type="hidden" value="<%=visitObj.getId()%>" />
<script	type="text/javascript" language="javascript">
		
		data_header1 = new Array();
		
		data_header1[0] = new Array;
		data_header1[0][0] = " "
		data_header1[0][1] = "hide";
		data_header1[0][2] = "5%";
		data_header1[0][3] = "<%= RequestConstants.RADIO_FOR_TABLE%>"
		
		data_header1[1] = new Array;
		data_header1[1][0] = "Token No."
		data_header1[1][1] = "hide";
		data_header1[1][2] = "8%";
		data_header1[1][3] = "<%= RequestConstants.TOKEN_NO%>"
		
		data_header1[2] = new Array;
		data_header1[2][0] = "Visit No."
		data_header1[2][1] = "hide";
		data_header1[2][2] = "10%";
		data_header1[2][3] = "<%= RequestConstants.VISIT_NUMBER %>";
		
		data_header1[3] = new Array;
		data_header1[3][0] = "Visit Date"
		data_header1[3][1] = "data";
		data_header1[3][2] = "5%";
		data_header1[3][3] = "<%=RequestConstants.VISIT_DATE %>";
		
		data_header1[4] = new Array;
		data_header1[4][0] = "Visit Time"
		data_header1[4][1] = "hide";
		data_header1[4][2] = "6%";
		data_header1[4][3] = "<%=RequestConstants.VISIT_TIME %>";
		
		data_header1[5] = new Array;
		data_header1[5][0] = "Employee No."
		data_header1[5][1] = "hide";
		data_header1[5][2] = "5%";
		data_header1[5][3] = "<%=RequestConstants.SERVICE_NO %>";
		
		
		
		data_header1[6] = new Array;
		data_header1[6][0] = "Appointment Type"
		data_header1[6][1] = "hide";
		data_header1[6][2] = "5%";
		data_header1[6][3] = "<%=RequestConstants.APPOINTMENT_TYPE %>";
		
		data_header1[7] = new Array;
		data_header1[7][0] = "Patient Name"
		data_header1[7][1] = "hide";
		data_header1[7][2] = "10%";
		data_header1[7][3] = "<%=RequestConstants.PATIENT_NAME %>";
		
		data_header1[8] = new Array;
		data_header1[8][0] = "Age"
		data_header1[8][1] = "hide";
		data_header1[8][2] = "6%";
		data_header1[8][3] = "<%=RequestConstants.AGE %>";
		
		
		
		data_header1[9] = new Array;
		data_header1[9][0] = "Gender"
		data_header1[9][1] = "hide";
		data_header1[9][2] = "1%";
		data_header1[9][3] = "<%=RequestConstants.SEX%>";
		
		data_header1[10] = new Array;
		data_header1[10][0] = "Diagnosis"
		data_header1[10][1] = "data";
		data_header1[10][2] = "10%";
		data_header1[10][3] = "<%=RequestConstants.DIAGNOSIS_ID %>";
		
		data_header1[11] = new Array;
		data_header1[11][0] = "visit No. For Jsp"
		data_header1[11][1] = "hide";
		data_header1[11][2] = "10%";
		data_header1[11][3] = "visitNoForJsp";

		data_header1[12] = new Array;
		data_header1[12][0] = "hinId"
		data_header1[12][1] = "hide";
		data_header1[12][2] = "10%";
		data_header1[12][3] = "HinId";
		data_header1[13] = new Array;
		data_header1[13][0] = "Dept Id"
		data_header1[13][1] = "hide";
		data_header1[13][2] = "10%";
		data_header1[13][3] = "deptId";

		data_header1[14] = new Array;
		data_header1[14][0] = "Department"
		data_header1[14][1] = "hide";
		data_header1[14][2] = "10%";
		data_header1[14][3] = "department";

		data_header1[15] = new Array;
		data_header1[15][0] = "Doctor"
		data_header1[15][1] = "data";
		data_header1[15][2] = "10%";
		data_header1[15][3] = "doctor";

		data_header1[16] = new Array;
		data_header1[16][0] = "token"
		data_header1[16][1] = "hide";
		data_header1[16][2] = "10%";
		data_header1[16][3] = "token";
		
		data_header1[17] = new Array;
		data_header1[17][0] = "link"
		data_header1[17][1] = "hide";
		data_header1[17][2] = "10%";
		data_header1[17][3] = "link";

		data_header1[18] = new Array;
		data_header1[18][0] = "Diagnosis"
		data_header1[18][1] = "hide";
		data_header1[18][2] = "10%";
		data_header1[18][3] = "<%=RequestConstants.DIAGNOSIS_ID %>";
		
		data_header1[19] = new Array;
		data_header1[19][0] = "Disposal"
		data_header1[19][1] = "hide";
		data_header1[19][2] = "10%";
		data_header1[19][3] = "Disposal";
		
		data_header1[20] = new Array;
		data_header1[20][0] = "Days"
		data_header1[20][1] = "hide";
		data_header1[20][2] = "10%";
		data_header1[20][3] = "days";
//added by Babita
		data_header1[21] = new Array;
		data_header1[21][0] = "Speciality"
		data_header1[21][1] = "data";
		data_header1[21][2] = "10%";
		data_header1[21][3] = "deptName";
		
		data_header1[22] = new Array;
		data_header1[22][0] = "Present Complain"
		data_header1[22][1] = "data";
		data_header1[22][2] = "10%";
		data_header1[22][3] = "presentComplain";
		
		data_header1[23] = new Array;
		data_header1[23][0] = "Family History"
		data_header1[23][1] = "data";
		data_header1[23][2] = "10%";
		data_header1[23][3] = "familyHistory";
		
		data_header1[24] = new Array;
		data_header1[24][0] = "System Diagnosis"
		data_header1[24][1] = "hide";
		data_header1[24][2] = "10%";
		data_header1[24][3] = "systemdiagnosis";
		
		data_header1[25] = new Array;
		data_header1[25][0] = "ICD Diagnosis"
		data_header1[25][1] = "data";
		data_header1[25][2] = "10%";
		data_header1[25][3] = "icdDiagnosis";
	
		data_header1[26] = new Array;
		data_header1[26][0] = "Report"
		data_header1[26][1] = "data";
		data_header1[26][2] = "10%";
		data_header1[26][3] = "report";
		
		
		data_arr1 = new Array();
		
		<%
		//int  i=0;
	
		String presentcomplain = null;
		String presentfamilyhistroy = null;
		String icdDaignosisString= "";
		String workingDaignosisString= "";
		String serviceNo= null;
		String hinNo= null;
		int hospitalId =0;
		
		serviceNo= patientPreviousVisitList.get(0).getHin().getServiceNo();
		hinNo= patientPreviousVisitList.get(0).getHin().getHinNo();
		 hospitalId =patientPreviousVisitList.get(0).getHospital().getId();
		//end
		try{
			String st="";
			String seperator = " | ";
	
		          for(int i=0;  i<patientPreviousVisitList.size();i++)
		           {   
		        	  icdDaignosisString= "";
		        	  //Visit visit= (Visit) iterator.next();
		        	  //code added by Babita
		        	   presentcomplain = patientPreviousVisitList.get(i).getPresentComplain();
		     		   presentfamilyhistroy = patientPreviousVisitList.get(i).getFamilyPresentHistory();
		        	   Visit visit= (Visit) patientPreviousVisitList.get(i).getOpdPatientDetails().getVisit();
		        	   int count =0;
		    			Set<DischargeIcdCode> dischageIcdSet = new HashSet<DischargeIcdCode>();
		    			dischageIcdSet = visit.getDischargeIcdCodes();
		       			for(DischargeIcdCode orderdt : dischageIcdSet){
		       				
		       				if(count++>=1)
		       					icdDaignosisString = icdDaignosisString.concat(seperator);
		       				
		       				icdDaignosisString = icdDaignosisString.concat(orderdt.getIcd().getIcdName());
		       				
		       			}
	        	   //end
		        	   
		       			
		        	  Patient patientHin=(Patient)visit.getHin();
		        	  MasDepartment deptObj=(MasDepartment)visit.getDepartment();
		        	  String patientName="";
		        	  if(visit.getHin().getPFirstName()!= null){
		        	   patientName=visit.getHin().getPFirstName();
	   	        	  }
					if(visit.getHin().getPMiddleName()!= null){
						patientName=patientName+" "+visit.getHin().getPMiddleName();
					}
					if(visit.getHin().getPLastName()!= null)
					{
						patientName=patientName+" "+visit.getHin().getPLastName();
					}				
					 
		        	  MasAdministrativeSex masAdministrativeSex=patientHin.getSex();
		        	  String visitDate =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
		        	  
		%>
		
			data_arr1[<%= i%>] = new Array();
			
			data_arr1[<%= i%>][0] ="<%=visit.getId()%>"
			
			data_arr1[<%= i%>][1] = '<input type="radio" class="radiogrid" name="parent" value="<%=visit.getHin().getServiceNo()%>@<%=visit.getHospital().getId()%>@<%=visit.getHin().getHinNo()%>@<%=visit.getId()%>" id="parent" onclick="fillVisitNo(this);submitFormForPrescriptionReport();"/>'
			
			<%
				if(visit.getTokenNo()!=null)
				{
			%>
			data_arr1[<%= i%>][2] = "<%=visit.getTokenNo()%>"
			<%
				}else{
			%>
			data_arr1[<%= i%>][2] = ""
			<%
				}
			   if(visit.getId()!=null)
			   {
			%>
			data_arr1[<%= i%>][3]="<%=visit.getId()%>"
			<%
			   }else{
			%>
			data_arr1[<%= i%>][3]=""
			<%
				}
			   if(visit.getVisitDate()!= null )
			   {
			%>
			data_arr1[<%= i%>][4] = "<%=visitDate%>"
			<%
			   }else{
			%> 
			data_arr1[<%= i%>][4] = ""
			<%
			   }if(visit.getVisitTime()!= null || visit.getVisitTime()!= "")
			   {
			%>
			data_arr1[<%= i%>][5] = "<%=visit.getVisitTime()%>"
			<%
			   }else{
			%>
			data_arr1[<%= i%>][5] = ""
			<%
			   }
			   if(visit.getHin().getServiceNo()!= null ||visit.getHin().getServiceNo() != "")
			   {
			%>
			data_arr1[<%= i%>][6] = "<%=visit.getHin().getServiceNo()%>"
			<%
			   }else{
			%>
			data_arr1[<%= i%>][6] = ""
			<%
			   }
			   if(visit.getHin() != null || visit.getHin()!=null)
			   {
			%>
			data_arr1[<%= i%>][7] = "<%=visit.getHin().getHinNo()%>"
			<%
			   }else{
			%>
			data_arr1[<%= i%>][7] = ""
			
			<%
			  }
			   if(patientName!= null )
			   {
			%>
			data_arr1[<%= i%>][8] = "<%=patientName%>"
			<%
			   }else{
			 %>
			 data_arr1[<%= i%>][8] = ""
		    <%}
			   if(visit.getHin().getAge() != null)
			   {
			%>
			
			data_arr1[<%= i%>][9] = "<%=visit.getHin().getAge()%>"
            <%
			   }else{
            %> 			
			data_arr1[<%= i%>][9] = ""
		<%   }if(masAdministrativeSex.getAdministrativeSexName() != null || masAdministrativeSex.getAdministrativeSexName() != ""){
		%>
			data_arr1[<%= i%>][10] = "<%=masAdministrativeSex.getAdministrativeSexName()%>"
		<%
		  	}else{
		%>
			data_arr1[<%= i%>][10] = ""
		<%}
		  //out.print(visit.getWorkingDiagnosis());
			if(visit.getWorkingDiagnosis()!= null){
				
				 workingDaignosisString = visit.getWorkingDiagnosis().toString();
				
				workingDaignosisString = workingDaignosisString.replace("\r", "$");
				workingDaignosisString = workingDaignosisString.replace("\n", "^");  
			
		%>
		
			 var workingDaignosisString = "<%out.print(workingDaignosisString);%>";
			workingDaignosisString = workingDaignosisString.split('$').join("\r");
			workingDaignosisString = workingDaignosisString.split('^').join("\n"); 
		
			
			data_arr1[<%= i%>][11] = workingDaignosisString;
			
			
		<%
		  	}else{
		%>
			data_arr1[<%= i%>][11] = ""
		<%}%>
		 data_arr1[<%= i%>][12] = "<%=visitNoForJsp%>"
		 data_arr1[<%= i%>][13] = "<%=visit.getHin().getId()%>"
			 <%
			 if(visit.getDepartment()!=null){
			 %>
		 data_arr1[<%= i%>][14] = "<%=visit.getDepartment().getId()%>"
			 <%}else{%>
			 data_arr1[<%= i%>][14] = "0";
			 <%}%>	 
			<% if(visit.getDepartment()!= null){
					
					%>
						data_arr1[<%= i%>][15] = "<%=visit.getDepartment().getDepartmentName()%>"
					<%
					  	}else{
					%>
						data_arr1[<%= i%>][15] = ""
					<%}%>
                    <% if(visit.getDoctor()!= null){
                    	String name="";
                    	//name=name+visit.getDoctor().getRank().getRankName();
						if(visit.getDoctor().getFirstName()!=null)
						{
							name=name+" "+visit.getDoctor().getFirstName();
						}
						if(visit.getDoctor().getMiddleName()!=null)
						{
							name=name+" "+visit.getDoctor().getMiddleName();
						}
						if(visit.getDoctor().getLastName()!=null)
						{
							name=name+" "+visit.getDoctor().getLastName();
						}
						%>
							data_arr1[<%= i%>][16] = "<%=name%>"
						<%
						  	}else{
						%>
							data_arr1[<%= i%>][16] = ""
						<%}%>	
		data_arr1[<%= i%>][17] = "<%=token%>"	 
		data_arr1[<%= i%>][18] = "<%=link%>"
			
			<%
			
			if(visit.getDisposal()!= null){
				
				%>
					data_arr1[<%= i%>][19] = "<%=visit.getDisposal().getDisposalName()%>"
				<%
				  	}else{
				%>
				data_arr1[<%= i%>][19] = ""
				<%
				  	}%>	
	<%	if(visit.getWorkingDiagnosis()!= null){
			
			%>
				data_arr1[<%= i%>][20] = "A"
			<%
			  	}else{
			%>
			data_arr1[<%= i%>][20] = ""
			<%
			  	}
					%>
					

					<%
					if(visit.getDisposalDays() != null){
					%>

					data_arr1[<%= i%>][21] = "<%=visit.getDisposalDays()%>"
					<%
						}else{
					%>
					data_arr1[<%= i%>][21] = ""
					<%}%>	
					
		         <%
					if(visit.getDepartment()!= null){
						
						%>
							data_arr1[<%= i%>][22] = "<%=visit.getDepartment().getDepartmentName()%>"
						<%
						  	}else{
						%>
						data_arr1[<%= i%>][22] = ""
						<%
						  	}%>	
						  	
						  	
					
					<%
					if(presentcomplain!= null){
						
											
						presentcomplain = presentcomplain.replace("\r", "$");
						presentcomplain = presentcomplain.replace("\n", "^"); 
					%>
					
					var presentcomplain = "<% out.print(presentcomplain); %>";
					presentcomplain = presentcomplain.split('$').join("\r");
					presentcomplain = presentcomplain.split('^').join("\n");	
					
					data_arr1[<%= i%>][23] = presentcomplain;

				
					<%
						}else{
					%>
					data_arr1[<%= i%>][23] = ""
					<%}%>
					
					<%
					if(presentfamilyhistroy!= null){
						
						presentfamilyhistroy = presentfamilyhistroy.replace("\r", "$");
						presentfamilyhistroy = presentfamilyhistroy.replace("\n", "^"); 
						
					%>
					var presentfamilyhistroy = "<% out.print(presentfamilyhistroy); %>";
					presentfamilyhistroy = presentfamilyhistroy.split('$').join("\r");
					presentfamilyhistroy = presentfamilyhistroy.split('^').join("\n");
					data_arr1[<%= i%>][24] = presentfamilyhistroy;
					<%
						}else{
					%>
					data_arr1[<%= i%>][24] = ""
					<%}%>	
					
		
					
					<%
					if(patientPreviousVisitList.get(i).getOpdPatientDetails().getSystemDiagnosis()!= null){
					%>

					data_arr1[<%= i%>][25] = "<%=patientPreviousVisitList.get(i).getOpdPatientDetails().getSystemDiagnosis().getSystemDiagnosisName()%>"
					<%
						}else{
					%>
					data_arr1[<%= i%>][25] = ""
					<%}%>
					
					<%
					if(icdDaignosisString!= null){
					%>

					data_arr1[<%= i%>][26] = "<%=icdDaignosisString%>"
					<%
						}else{
					%>
					data_arr1[<%= i%>][26] = ""
					<%}%>
			
					
					data_arr1[<%= i%>][27] ="<input type='button'  onclick=\"RequestForViewScreen('<%=visit.getId()%>','<%=serviceNo%>','<%=hinNo%>','0');\" value='Report'	class='button' accesskey='a' />"
		<% 	
			//i++;
		  }
		}catch(Exception e){
		e.printStackTrace();	
	
		}
		%>
		 
		formName = "opdPatientPrevVisitForViewScreen1"
		
		
		start1 = 0
		if(data_arr1.length < rowsPerPage)
			end1 = data_arr1.length;
		else
			end1 = rowsPerPage;
		makeTable1(start1,end1);
		
		intializeHover('searchresulttable1', 'TR', ' tableover');		
</script>
<div class="Clear"></div>
<%-- <div class="floatRight">
<label class="auto"><span>Total Patient Visit </span></label>
<label class="valueAuto"><%= i%></label>
<input type="hidden"	name="counter" id="counter" value="<%=i %>" />
<input type="hidden" name="visitNoForJsp" id="visitNoForJsp" value="<%=visitNoForJsp%>" />
</div>
<div class="clear"></div>--%>
<!-- <div class="division"></div> -->

<!-- <input type="button" name="printReport" id="print" 	onclick="submitFormForPrescriptionReport();" value="Case Sheet"	class="buttonBig" accesskey="a" /> --> 
<%if(backFlag.equals("OPD") || backFlag.equals("dental")){ %>
<!--<input name="Back" type="button" alt="Back" value="Back" class="button"	onclick="submitForm('opdPatientPrevVisitForViewScreen','opd?method=showOPDMainJsp&visitId=<%=visitId%>&token=<%=token%>');"/>-->
<input name="close" type="button" value="close" class="button" onclick="window.close();"/>
<%} %>


<div class="clear"></div>
<!-- <div class="division"></div> -->
</form>
<% }else{ %>

<form name="opdPatientPrevVisitForViewScreen1" method="post" action="">
<div class="popupbg">
<h4>No Previous Visit Records Found </h4>
<div class="Clear"></div>
<%if(backFlag.equals("OPD") || backFlag.equals("dental")){ %>
<!--<input name="Back" type="button" alt="Back" value="Back" class="button"	onclick="submitForm('opdPatientPrevVisitForViewScreen','opd?method=showOPDMainJsp&visitId=<%=visitId%>&token=<%=token%>');"/>-->
<input name="close" type="button" value="close" class="button" onclick="window.close();"/>
<%} }%>

</div>
</form>
</div>
<script type="text/javascript">	
	function submitFormForPrescriptionReport(){
		//var flag = validateRadioForVisitNo();
		var orderNo = '';
	/* 	if(flag == false){
			return false;
		}else{ */
			var printId = document.getElementById('print');
	//	checkTargetForYes();
			//printId.setAttribute("type","submit");
		//	submitForm('opdPatientPrevVisitForViewScreen','/hms/hms/opd?method=opdMedicalCaseSheetPrint');
		submitForm('opdPatientPrevVisitForViewScreen1','/hms/hms/opd?method=showPatientMedicalCaseSheetReport');
		
		//	checkTargetForNo();
		//}
		
	}
	
	function fillVisitNo(printValueObj){
		var allValues = printValueObj.value;
		
		var allValuesArray = allValues.split("@");
		
		document.getElementById('serviceNoForReport').value = allValuesArray[0];
		document.getElementById('hospitalIdForReport').value = allValuesArray[1]; 
		document.getElementById('hinNoForReport').value = allValuesArray[2];  
		document.getElementById('visitId').value = allValuesArray[3];  
	}
	
	function validateRadioForVisitNo(){
		for(var i = 0; i < document.getElementsByName('parent').length; i++){
			if(document.getElementsByName('parent')[i].checked == true){
				return true;
			}		
  		}
  		alert("Please select one row");
		return false;
	}
	function showPreviousVisit(hinId,deptId,visitNo,token){
		
		if(visitNo >=1){
		
	 
       document.opdPatientPrevVisitForViewScreen.action="/hms/hms/opd?method=getPatientOpdDetails&flag=current&hinId="+hinId+"&deptId="+deptId+"&visitNumber="+visitNo+"&token="+token+"&link=<%=link%>";
      
       document.opdPatientPrevVisitForViewScreen.submit();
       
        }else{
         alert("This Is Patient's first Visit.")
       }
    }
	function backtoHome()
	{
		<%
		if(flag.equals("registration")){
		%>
		 document.opdPatientPrevVisitForViewScreen.action="registration?method=showRegistrationJsp";
			
		<%}else{%>
		 document.opdPatientPrevVisitForViewScreen.action="opd?method=showOPDMainJsp&visitId=<%=visitId%>&token=<%=token%>";
		 <%}%>
		
		
	}
	
</script>


<%--  <%@ include file="opd_previousVisitForViewScreenHIS.jsp" %>
 --%>