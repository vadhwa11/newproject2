
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

<%@page import="jkt.hms.masters.business.Discharge"%><script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>

<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
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
		int visitId=0;
		int token = 0;
		String medExamType="";
		String backFlag = "";
		if(map.get("backFlag") != null){
			backFlag = (String)map.get("backFlag");
		}
		if(map.get("token") != null){
			token = (Integer)map.get("token");
		}
		if(map.get("visitId") != null){
			visitId = (Integer)map.get("visitId");
		}	
		String FlagFOrMedExamMa = "";
		
		if(map.get("FlagFOrMedExamMa")!= null)
		{
			FlagFOrMedExamMa = (String)map.get("FlagFOrMedExamMa");
			
		}
		
		if(map.get("medExamType")!= null)
        {
      	medExamType = (String)map.get("medExamType");
        }
		
		String url = "";
		if(map.get("url") != null)
		  {
			url = ""+map.get("url");
		  }
		
		url=url+"&visitId="+visitId+"&medExamType="+medExamType;

		//int visitId = 0;
	List dischargeList = new ArrayList();
	
	if(map.get("dischargeList") != null){
		dischargeList=(List)map.get("dischargeList");
	}	
	
	if(dischargeList != null && dischargeList.size()>0)
	  {
		    	
	   // System.out.println("visitId========222222222>>>>"+visitId);
		   //medExamType = medExamList.get(0).getMedicalExamType();
		// System.out.println("medExamType=========3333333333>>>>"+medExamType);
		// url=url+"&visitId="+visitId+"&medExamType="+medExamType;
	  }
	

	if(dischargeList.size() > 0){
		Inpatient inpatient=(Inpatient)dischargeList.get(0);
%>

<div class="popupbg">

<div class="titleBg"><h2>Previous Hospitalizations- HAL</h2></div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock1.jsp" />


<form name="opd_previousVisitForHospitality1" method="post" action="">
<!-- <input type="button" class="button"  value="Clinical Setup" align="left" onClick="submitForm('patientList','ipd?method=showNursingCareJsp','validateRadio');" />-->

<div id="searchresults" tabindex=2>
<div id="searchtable1" tabindex=2></div>


<script type="text/javascript" language="javascript">

formFields = [
		[0, "<%= RequestConstants.HIN_ID%>", "id"],[1, "<%= RequestConstants.RADIO_FOR_TABLE%>"], [2,"<%=RequestConstants.AD_NO%>"],[3,"<%=RequestConstants.HOSPITAL_NAME%>"], [4,"<%= RequestConstants.AD_DATE %>"], [5,"<%= RequestConstants.DISCHARGE_DATE%>"],[6,"<%=RequestConstants.DIAGNOSIS_ID%>"],[7,"<%=RequestConstants.DISPOSAL_ID %>"]]; 
 statusTd =13;
</script></div>
<div id="edited"></div>
<div id="statusMessage" ></div>
<script	type="text/javascript" language="javascript">
		
		data_header1 = new Array();

		data_header1[0] = new Array;
		data_header1[0][0] = " "
		data_header1[0][1] = "radio";
		data_header1[0][2] = "5%";
		data_header1[0][3] = "<%= RequestConstants.RADIO_FOR_TABLE%>"
		
		
		data_header1[1] = new Array;
		data_header1[1][0] = "A&D No."
		data_header1[1][1] = "data";
		data_header1[1][2] = "8%";
		data_header1[1][3] = "<%=RequestConstants.AD_NO%>"

		data_header1[2] = new Array;
		data_header1[2][0] = "Hospital/SMC"
		data_header1[2][1] = "data";
		data_header1[2][2] = "5%";
		data_header1[2][3] = "<%=RequestConstants.HOSPITAL_NAME%>";
				
		data_header1[3] = new Array;
		data_header1[3][0] = "Date of Admission"
		data_header1[3][1] = "data";
		data_header1[3][2] = "8%";
		data_header1[3][3] = "<%=RequestConstants.AD_DATE%>"
		
		data_header1[4] = new Array;
		data_header1[4][0] = "Date of Discharge"
		data_header1[4][1] = "data";
		data_header1[4][2] = "10%";
		data_header1[4][3] = "<%=RequestConstants.DISCHARGE_DATE%>";
		
		
		  
		data_header1[5] = new Array;
		data_header1[5][0] = "Diagnosis"
		data_header1[5][1] = "data";
		data_header1[5][2] = "6%";
		data_header1[5][3] = "<%=RequestConstants.DIAGNOSIS_ID%>";
		
		data_header1[6] = new Array;
		data_header1[6][0] = "Disposal"
		data_header1[6][1] = "data";
		data_header1[6][2] = "5%";
		data_header1[6][3] = "<%=RequestConstants.DISPOSAL_ID%>";
		
		data_arr1 = new Array();
		
		<%
		int  i=0;
		int  sino=i+1;
		
		try{
			String st="";
		
			Iterator iterator=dischargeList.iterator();
		    
		          while(iterator.hasNext())
		           {   
		        	  Inpatient discharge= (Inpatient) iterator.next();
		        	  
		        	  
		        	    
		%>
		
		data_arr1[<%= i%>] = new Array();
		
		data_arr1[<%= i%>][0] ="<%=discharge.getId()%>"
		var hospitalId = <%=discharge.getHospital().getId()%>
		var adNo = "<%=discharge.getAdNo()%>";
		
			data_arr1[<%= i%>][1] = '<input type="radio" class="radiogrid" name="parent" value="<%=discharge.getAdNo()%>" id="parent" onclick="fillAdNo(this); fillHospitalId(<%=discharge.getHospital().getId()%>); "/>'
		
			
			data_arr1[<%= i%>][2] = "<%=discharge.getAdNo()%>"

				<%
					
				   if(discharge.getHospital().getHospitalName()!= null )
				   {
				%>
				data_arr1[<%= i%>][3] = "<%=discharge.getHospital().getHospitalName()%>"
				<%
				   }else{
				%> 
				data_arr1[<%= i%>][3] = ""
				<%
				   }%>
					
			<%
				if(discharge.getDateOfAddmission()!=null)
				{
			%>
			data_arr1[<%= i%>][4] = "<%=HMSUtil.changeDateToddMMyyyy(discharge.getDateOfAddmission())%>"
			<%
				}else{
			%>
			data_arr1[<%= i%>][4] = ""
			<%
				}
			   if(discharge.getDischargeDate()!=null)
			   {
			%>
			data_arr1[<%= i%>][5]="<%=HMSUtil.changeDateToddMMyyyy(discharge.getDischargeDate())%>"
			<%
			   }else{
			%>
			data_arr1[<%= i%>][5]=""
			<%
			   }
			   //if(discharge.getWorkingDiagnosis()!=null)
				    if(false)
			   {
			%>
			data_arr1[<%= i%>][6] = ""
			<%
			   }else{
			%>
			data_arr1[<%= i%>][6] = ""
			<%
			   }
			   //if(discharge.getDisposal().getDisposalName()!=null)
				   if(false)
			   {
			%>
			data_arr1[<%= i%>][7] = ""
			<%
			   }else{
			%>
			data_arr1[<%= i%>][7] = ""
			<%
			   }
			  %>		
		<% 	
			i++;
		  }
		          
		}catch(Exception e){
		e.printStackTrace();	
	
		}
		%>
		 
		formName = "opd_previousVisitForHospitality1"
		
		
		start1 = 0
		if(data_arr1.length < rowsPerPage)
			end1 = data_arr1.length;
		else
			end1 = rowsPerPage;
		makeTable1(start1,end1);
		
		intializeHover('searchresulttable1', 'TR', ' tableover');		
</script>
<div class="Clear"></div>
<%-- 
<div class="floatRight">
<label class="auto"><span>Total Hospitalized Patient</span></label>
<label class="valueAuto"><%= i%></label>
<input type="hidden"	name="counter" id="counter" value="<%=i %>" />
<input type="hidden" name="dischargeId" id="dischargeId" value="" />
</div>
<div class="clear"></div>
--%>

<input type="hidden" name="hospitalIdForReport" id="hospitalIdForReport" value="" />
<input type="hidden" name="adNo" id="adNo" value="" />
<div class="division"></div>
<!--<input name="Back" type="button" alt="Back" value="Back" class="button"	onClick="submitForm('opd_previousVisitForHospitality','<%=url%>');"/>
-->
<%if(backFlag.equals("OPD")  || backFlag.equals("dental") || backFlag.equals("fwc")){ %>
<!--<input name="Back" type="button" alt="Back" value="Back" class="button"	onclick="submitForm('opd_previousVisitForHospitality','opd?method=showOPDMainJsp&visitId=<%=visitId%>&token=<%=token%>');"/>-->
<input name="close" type="button" value="close" class="button" onclick="window.close();"/>
<%} %>
<%if(FlagFOrMedExamMa.equals("medExamMA")){ %>
<input name="Back" type="button" alt="Back" value="Back" class="button"	onClick="submitForm('opd_previousVisitForHospitality','<%=url%>');"/>
<%}%>
<input type="button" name="printReport" id="print"	onclick="submitFormForDischargeSummaryReport();" value="Discharge Summary"	class="buttonBig" accesskey="a" />
<div class="clear"></div>
<div class="division"></div>
</form>
<% }else{ %>
<form name="opd_previousVisitForHospitality" method="post" action="">
<div class="popupbg">
<h4>No Previous Hospitalization Records Found</h4>
<div class="Clear"></div>
<%if(FlagFOrMedExamMa.equals("medExamMA")){ %>
<input name="Back" type="button" alt="Back" value="Back" class="button"	onClick="submitForm('opd_previousVisitForHospitality','<%=url%>');"/>
<%}%>
<%if(backFlag.equals("OPD") || backFlag.equals("dental")){ %>
<!--<input name="Back" type="button" alt="Back" value="Back" class="button"	onclick="submitForm('opd_previousVisitForHospitality','opd?method=showOPDMainJsp&visitId=<%=visitId%>&token=<%=token%>');"/>-->
<input name="close" type="button" value="close" class="button" onclick="window.close();"/>
</div>
<% }} %>
</form>

<div class="Clear"></div>
</div>
<script type="text/javascript">	
	function submitFormForDischargeSummaryReport(){
		var flag = validateRadioForVisitNo();
		
		if(flag == false){
			return false;
		}else{
			
			submitForm('opd_previousVisitForHospitality1','/hms/hms/discharge?method=showDischargeSummaryReportFromPastHistory');
		
		}
		
	}
	
	function fillAdNo(printValueObj)
	{
		var allValues = printValueObj.value;		
		document.getElementById('adNo').value = allValues;
		
	}
	
	function fillHospitalId(hospitalId)
	{
		
		document.getElementById('hospitalIdForReport').value = hospitalId;
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
	
	
</script>


<%-- <%@ include file="opd_previousVisitForHospitalityHIS.jsp" %>  --%>
