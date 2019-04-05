<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
<%@page import="jkt.hms.masters.business.Patient"%>
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
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<!--[if lt IE 9]>
        <link href="/hms/jsp/css/ie.css" rel="stylesheet" type="text/css" />
<![endif]-->
<!-- script for fixed header table starts -->

<!--[if IE 9]>
<link href="/hms/jsp/css/ie.css" rel="stylesheet" type="text/css" />
<![endif]-->
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
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

		if(map.get("visitNoForJsp") != null){
			visitNoForJsp=(Integer)map.get("visitNoForJsp");
		}
		
		

		if(map.get("visitNoForJsp") != null){
			visitNoForJsp=(Integer)map.get("visitNoForJsp");
		}
		if(map.get("token") != null){
			token = (Integer)map.get("token");
		}
		if(map.get("visitId") != null){
			visitId = (Integer)map.get("visitId");
		}

		
	List patientPreviousVisitList = new ArrayList();
	List<Integer> maxVisitIdList = new ArrayList<Integer>();
	List<Integer> minVisitIdList = new ArrayList<Integer>();
	
	if(map.get("patientPreviousVisitList") != null){
		patientPreviousVisitList=(List)map.get("patientPreviousVisitList");
	}	
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
	if(patientPreviousVisitList.size() > 0){
		

	Visit visitObj=(Visit)patientPreviousVisitList.get(0);
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
	 String visitDateInString =HMSUtil.changeDateToddMMyyyy(visitObj.getVisitDate());
	int deptId=0;
	if(visitObj.getDepartment()!=null)
		deptId = visitObj.getDepartment().getId();
	MasAdministrativeSex masAdministrativeSexObj=patientObj.getSex();
%>


<div class="titleBg"><h2>Previous Visits</h2></div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />


<form name="opdPatientPrevVisitForViewScreen" method="post" action="">
<!-- <input type="button" class="button"  value="Clinical Setup" align="left" onClick="submitForm('patientList','ipd?method=showNursingCareJsp','validateRadio');" />-->




<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>


<script type="text/javascript" language="javascript">
	
	formFields = [
			[0, "<%= RequestConstants.HIN_ID%>", "id"],[1, "<%= RequestConstants.RADIO_FOR_TABLE%>"], [2,"<%= RequestConstants.TOKEN_NO%>"], [3,"<%= RequestConstants.VISIT_NUMBER %>","visitNumber"], [4,"<%= RequestConstants.VISIT_DATE %>"],[5,"<%= RequestConstants.VISIT_TIME %>"],[6,"<%= RequestConstants.SERVICE_NO %>"],[7,"<%=RequestConstants.APPOINTMENT_TYPE%>"],[8,"<%= RequestConstants.PATIENT_NAME %>"],[9,"<%=RequestConstants.AGE%>"],[10,"<%=RequestConstants.SEX%>"],[11,"<%=RequestConstants.DIAGNOSIS_ID%>"],[12,"visitNoForJsp"],[13,"disposal"],[14,"days"]  ];
	 statusTd =13;

</script></div>
<div id="edited"></div>
<div id="statusMessage" ></div>
<input type="hidden" name="serviceNoForReport" id="serviceNoForReport"	value="<%=visitObj.getHin().getServiceNo()%>" />
<input type="hidden" name="visitNumberForReport"	id="visitNumberForReport" value="<%=visitObj.getVisitNo()%>" />
<input type="hidden" name="hinNoForReport" id="hinNoForReport" value="<%=visitObj.getHin().getHinNo()%>" />
<input type="hidden" name="visitId" id="visitId" value="<%=visitObj.getId()%>" />

 
<script	type="text/javascript" language="javascript">
		
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = " "
		data_header[0][1] = "data";
		data_header[0][2] = "5%";
		data_header[0][3] = "<%= RequestConstants.RADIO_FOR_TABLE%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "Token No."
		data_header[1][1] = "hide";
		data_header[1][2] = "8%";
		data_header[1][3] = "<%= RequestConstants.TOKEN_NO%>"
		
		data_header[2] = new Array;
		data_header[2][0] = "Visit No."
		data_header[2][1] = "data";
		data_header[2][2] = "10%";
		data_header[2][3] = "<%= RequestConstants.VISIT_NUMBER %>";
		
		data_header[3] = new Array;
		data_header[3][0] = "Visit Date"
		data_header[3][1] = "data";
		data_header[3][2] = "5%";
		data_header[3][3] = "<%=RequestConstants.VISIT_DATE %>";
		
		data_header[4] = new Array;
		data_header[4][0] = "Visit Time"
		data_header[4][1] = "hide";
		data_header[4][2] = "6%";
		data_header[4][3] = "<%=RequestConstants.VISIT_TIME %>";
		
		data_header[5] = new Array;
		data_header[5][0] = "Service No."
		data_header[5][1] = "hide";
		data_header[5][2] = "5%";
		data_header[5][3] = "<%=RequestConstants.SERVICE_NO %>";
		
		
		
		data_header[6] = new Array;
		data_header[6][0] = "Appointment Type"
		data_header[6][1] = "hide";
		data_header[6][2] = "5%";
		data_header[6][3] = "<%=RequestConstants.APPOINTMENT_TYPE %>";
		
		data_header[7] = new Array;
		data_header[7][0] = "Patient Name"
		data_header[7][1] = "hide";
		data_header[7][2] = "10%";
		data_header[7][3] = "<%=RequestConstants.PATIENT_NAME %>";
		
		data_header[8] = new Array;
		data_header[8][0] = "Age"
		data_header[8][1] = "hide";
		data_header[8][2] = "6%";
		data_header[8][3] = "<%=RequestConstants.AGE %>";
		
		
		
		data_header[9] = new Array;
		data_header[9][0] = "Gender"
		data_header[9][1] = "hide";
		data_header[9][2] = "1%";
		data_header[9][3] = "<%=RequestConstants.SEX%>";
		
		data_header[10] = new Array;
		data_header[10][0] = "Diagnosis"
		data_header[10][1] = "hide";
		data_header[10][2] = "10%";
		data_header[10][3] = "<%=RequestConstants.DIAGNOSIS_ID %>";
		
		data_header[11] = new Array;
		data_header[11][0] = "visit No. For Jsp"
		data_header[11][1] = "hide";
		data_header[11][2] = "10%";
		data_header[11][3] = "visitNoForJsp";

		data_header[12] = new Array;
		data_header[12][0] = "hinId"
		data_header[12][1] = "hide";
		data_header[12][2] = "10%";
		data_header[12][3] = "HinId";
		data_header[13] = new Array;
		data_header[13][0] = "Dept Id"
		data_header[13][1] = "hide";
		data_header[13][2] = "10%";
		data_header[13][3] = "deptId";

		data_header[14] = new Array;
		data_header[14][0] = "Department"
		data_header[14][1] = "hide";
		data_header[14][2] = "10%";
		data_header[14][3] = "department";

		data_header[15] = new Array;
		data_header[15][0] = "Medical Officer"
		data_header[15][1] = "data";
		data_header[15][2] = "10%";
		data_header[15][3] = "doctor";

		data_header[16] = new Array;
		data_header[16][0] = "token"
		data_header[16][1] = "hide";
		data_header[16][2] = "10%";
		data_header[16][3] = "token";
		
		data_header[17] = new Array;
		data_header[17][0] = "link"
		data_header[17][1] = "hide";
		data_header[17][2] = "10%";
		data_header[17][3] = "link";

		data_header[18] = new Array;
		data_header[18][0] = "Diagnosis"
		data_header[18][1] = "data";
		data_header[18][2] = "10%";
		data_header[18][3] = "<%=RequestConstants.DIAGNOSIS_ID %>";
		
		data_header[19] = new Array;
		data_header[19][0] = "Disposal"
		data_header[19][1] = "data";
		data_header[19][2] = "10%";
		data_header[19][3] = "Disposal";
		
		data_header[20] = new Array;
		data_header[20][0] = "Days"
		data_header[20][1] = "data";
		data_header[20][2] = "10%";
		data_header[20][3] = "days";


		
		
		data_arr = new Array();
		
		<%
		int  i=0;
		try{
			String st="";
		
			Iterator iterator=patientPreviousVisitList.iterator();
		    
		          while(iterator.hasNext())
		           {   
		        	  Visit visit= (Visit) iterator.next();
		        	 
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
		
			data_arr[<%= i%>] = new Array();
			
			data_arr[<%= i%>][0] ="<%=visit.getId()%>"
			
			data_arr[<%= i%>][1] = '<input type="radio" class="radiogrid" name="parent" value="<%=visit.getHin().getServiceNo()%>@<%=visit.getVisitNo()%>@<%=visit.getHin().getHinNo()%>" id="parent" onclick="fillVisitNo(this)"/>'
			
			<%
				if(visit.getTokenNo()!=null)
				{
			%>
			data_arr[<%= i%>][2] = "<%=visit.getTokenNo()%>"
			<%
				}else{
			%>
			data_arr[<%= i%>][2] = ""
			<%
				}
			   if(visit.getVisitNo()!=null)
			   {
			%>
			data_arr[<%= i%>][3]="<%=visit.getVisitNo()%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][3]=""
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
			   if(visit.getHin().getServiceNo()!= null ||visit.getHin().getServiceNo() != "")
			   {
			%>
			data_arr[<%= i%>][6] = "<%=visit.getHin().getServiceNo()%>"
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
			
			<%
			  }
			   if(patientName!= null )
			   {
			%>
			data_arr[<%= i%>][8] = "<%=patientName%>"
			<%
			   }else{
			 %>
			 data_arr[<%= i%>][8] = ""
		    <%}
			   if(visit.getHin().getAge() != null)
			   {
			%>
			
			data_arr[<%= i%>][9] = "<%=visit.getHin().getAge()%>"
            <%
			   }else{
            %> 			
			data_arr[<%= i%>][9] = ""
		<%   }if(masAdministrativeSex.getAdministrativeSexName() != null || masAdministrativeSex.getAdministrativeSexName() != ""){
		%>
			data_arr[<%= i%>][10] = "<%=masAdministrativeSex.getAdministrativeSexName()%>"
		<%
		  	}else{
		%>
			data_arr[<%= i%>][10] = ""
		<%}
		
			if(visit.getDiagnosisString()!= null){
			
		%>
			data_arr[<%= i%>][11] = "<%=visit.getDiagnosisString()%>"
		<%
		  	}else{
		%>
			data_arr[<%= i%>][11] = ""
		<%}%>
		 data_arr[<%= i%>][12] = "<%=visitNoForJsp%>"
		 data_arr[<%= i%>][13] = "<%=visit.getHin().getId()%>"
			 <%
			 if(visit.getDepartment()!=null){
			 %>
		 data_arr[<%= i%>][14] = "<%=visit.getDepartment().getId()%>"
			 <%}else{%>
			 data_arr[<%= i%>][14] = "0";
			 <%}%>	 
			<% if(visit.getDepartment()!= null){
					
					%>
						data_arr[<%= i%>][15] = "<%=visit.getDepartment().getDepartmentName()%>"
					<%
					  	}else{
					%>
						data_arr[<%= i%>][15] = ""
					<%}%>
                    <% if(visit.getDoctor()!= null){
                    	String name="";
						if(visit.getDoctor().getFirstName()!=null)
						{
							name=name+visit.getDoctor().getFirstName();
						}
						if(visit.getDoctor().getMiddleName()!=null)
						{
							name=name+visit.getDoctor().getMiddleName();
						}
						if(visit.getDoctor().getLastName()!=null)
						{
							name=name+visit.getDoctor().getLastName();
						}
						%>
							data_arr[<%= i%>][16] = "<%=name%>"
						<%
						  	}else{
						%>
							data_arr[<%= i%>][16] = ""
						<%}%>	
		data_arr[<%= i%>][17] = "<%=token%>"	 
		data_arr[<%= i%>][18] = "<%=link%>"
			
			
	<%	if(visit.getDiagnosisString()!= null){
			
			%>
				data_arr[<%= i%>][20] = "<%=visit.getDiagnosisString()%>"
			<%
			  	}else{
			%>
			data_arr[<%= i%>][20] = ""
			<%
			  	}
					%>
					<%
					
					if(visit.getDisposal()!= null){
						
						%>
							data_arr[<%= i%>][19] = "<%=visit.getDisposal().getDisposalName()%>"
						<%
						  	}else{
						%>
						data_arr[<%= i%>][19] = ""
						<%
						  	}%>

					<%
					if(visit.getDisposalDays() != null){
					%>

					data_arr[<%= i%>][21] = "<%=visit.getDisposalDays()%>"
					<%
						}else{
					%>
					data_arr[<%= i%>][21] = ""
					<%}%>	
		<% 	
			i++;
		  }
		          
		}catch(Exception e){
		e.printStackTrace();	
	
		}
		%>
		 
		formName = "opdPatientPrevVisitForViewScreen"
		
		
		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeTable(start,end);
		
		intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
<div class="Clear"></div>
<%-- <div class="floatRight">
<label class="auto"><span>Total Patient Visit </span></label>
<label class="valueAuto"><%= i%></label>
<input type="hidden"	name="counter" id="counter" value="<%=i %>" />
<input type="hidden" name="visitNoForJsp" id="visitNoForJsp" value="<%=visitNoForJsp%>" />
</div>
<div class="clear"></div>--%>
<div class="division"></div>
<!--<input name="Back" type="button" alt="Back" value="Back" class="button"	onclick="backtoHome()"/>
-->
<input name="Back" type="button" alt="Back" value="Close" class="button"	onclick="window.close()"/>
<input type="button" name="printReport" id="print" 	onclick="submitFormForPrescriptionReport();" value="Case Sheet"	class="buttonBig" accesskey="a" /> 
<!-- 
<input name="Back" type="button" alt="Back" value="Back" class="button"	onclick="submitForm('opdPatientPrevVisitForReport','opd?method=showOPDMainJsp&visitId=<%=visitId%>&deptId=<%=deptId%>');"/>
 -->
<div class="clear"></div>
<div class="division"></div>
</form>
<% }else{ %>

<form name="opdPatientPrevVisitForViewScreen" method="post" action="">
<h4>No Previous Visit For Patient </h4>
<div class="Clear"></div>
<input name="Back" type="button" alt="Back" value="Close" class="button"	onclick="window.close()" /></form>

 <!-- <input name="Back" type="button" value="Back" class="button"	onclick="history.go(-1);return false;"/>
 -->
<% } %>

<script type="text/javascript">	
	function submitFormForPrescriptionReport(){
		var flag = validateRadioForVisitNo();
		var orderNo = '';
		if(flag == false){
			return false;
		}else{
			var printId = document.getElementById('print');
			checkTargetForYes();
			//printId.setAttribute("type","submit");
			submitForm('opdPatientPrevVisitForViewScreen','/hms/hms/opd?method=opdMedicalCaseSheetPrint');
			checkTargetForNo();
		}
		
	}
	
	function fillVisitNo(printValueObj){
		var allValues = printValueObj.value;
		
		var allValuesArray = allValues.split("@");
		
		document.getElementById('serviceNoForReport').value = allValuesArray[0];
		document.getElementById('visitNumberForReport').value = allValuesArray[1]; 
		document.getElementById('hinNoForReport').value = allValuesArray[2];  
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
		document.opdPatientPrevVisitForViewScreen.submit();
		
	}
	
</script>
