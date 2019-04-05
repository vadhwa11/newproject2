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

<%@page import="jkt.hms.masters.business.Discharge"%><script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>
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
		int visitId=0;
		int token = 0;
		if(map.get("token") != null){
			token = (Integer)map.get("token");
		}
		
		if(map.get("visitId") != null){
			visitId = (Integer)map.get("visitId");
		}	
		
	List dischargeList = new ArrayList();
	
	if(map.get("dischargeList") != null){
		dischargeList=(List)map.get("dischargeList");
	}	
	

	if(dischargeList.size() > 0){
		Discharge inpatient=(Discharge)dischargeList.get(0);
%>


<div class="titleBg"><h2>Previous Hospitalizations</h2></div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />


<form name="opd_previousVisitForHospitality" method="post" action="">
<!-- <input type="button" class="button"  value="Clinical Setup" align="left" onClick="submitForm('patientList','ipd?method=showNursingCareJsp','validateRadio');" />-->

<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>


<script type="text/javascript" language="javascript">

formFields = [
		[0, "<%= RequestConstants.HIN_ID%>", "id"],[1, "<%= RequestConstants.RADIO_FOR_TABLE%>"], [2,"<%=RequestConstants.AD_NO%>"],[3,"<%=RequestConstants.HOSPITAL_NAME%>"], [4,"<%= RequestConstants.AD_DATE %>"], [5,"<%= RequestConstants.DISCHARGE_DATE%>"],[6,"<%=RequestConstants.DIAGNOSIS_ID%>"],[7,"<%=RequestConstants.DISPOSAL_ID %>"]]; 
 statusTd =13;
</script></div>
<div id="edited"></div>
<div id="statusMessage" ></div>
<script	type="text/javascript" language="javascript">
		
		data_header = new Array();

		data_header[0] = new Array;
		data_header[0][0] = " "
		data_header[0][1] = "radio";
		data_header[0][2] = "5%";
		data_header[0][3] = "<%= RequestConstants.RADIO_FOR_TABLE%>"
		
		
		data_header[1] = new Array;
		data_header[1][0] = "A&D No."
		data_header[1][1] = "data";
		data_header[1][2] = "8%";
		data_header[1][3] = "<%=RequestConstants.AD_NO%>"

		data_header[2] = new Array;
		data_header[2][0] = "Hospital/SMC"
		data_header[2][1] = "data";
		data_header[2][2] = "5%";
		data_header[2][3] = "<%=RequestConstants.HOSPITAL_NAME%>";
				
		data_header[3] = new Array;
		data_header[3][0] = "Date of Admission"
		data_header[3][1] = "data";
		data_header[3][2] = "8%";
		data_header[3][3] = "<%=RequestConstants.AD_DATE%>"
		
		data_header[4] = new Array;
		data_header[4][0] = "Date of Discharge"
		data_header[4][1] = "data";
		data_header[4][2] = "10%";
		data_header[4][3] = "<%=RequestConstants.DISCHARGE_DATE%>";
		
		
		  
		data_header[5] = new Array;
		data_header[5][0] = "Diagnosis"
		data_header[5][1] = "data";
		data_header[5][2] = "6%";
		data_header[5][3] = "<%=RequestConstants.DIAGNOSIS_ID%>";
		
		data_header[6] = new Array;
		data_header[6][0] = "Disposal"
		data_header[6][1] = "data";
		data_header[6][2] = "5%";
		data_header[6][3] = "<%=RequestConstants.DISPOSAL_ID%>";
		
		data_arr = new Array();
		
		<%
		int  i=0;
		int  sino=i+1;
		try{
			String st="";
		
			Iterator iterator=dischargeList.iterator();
		    
		          while(iterator.hasNext())
		           {   
		        	  Discharge discharge= (Discharge) iterator.next();
		%>
		
		data_arr[<%= i%>] = new Array();
		
		data_arr[<%= i%>][0] ="<%=discharge.getId()%>"
		
			data_arr[<%= i%>][1] = '<input type="radio" class="radiogrid" name="parent" value="<%=discharge.getId()%>" id="parent" onclick="fillDischargeNo(this)"/>'
		
			
			data_arr[<%= i%>][2] = "<%=discharge.getInpatient().getAdNo()%>"

				<%
					
				   if(discharge.getHospital().getHospitalName()!= null )
				   {
				%>
				data_arr[<%= i%>][3] = "<%=discharge.getHospital().getHospitalName()%>"
				<%
				   }else{
				%> 
				data_arr[<%= i%>][3] = ""
				<%
				   }%>
					
			<%
				if(discharge.getInpatient().getDateOfAddmission()!=null)
				{
			%>
			data_arr[<%= i%>][4] = "<%=HMSUtil.changeDateToddMMyyyy(discharge.getInpatient().getDateOfAddmission())%>"
			<%
				}else{
			%>
			data_arr[<%= i%>][4] = ""
			<%
				}
			   if(discharge.getDateOfDischarge()!=null)
			   {
			%>
			data_arr[<%= i%>][5]="<%=HMSUtil.changeDateToddMMyyyy(discharge.getDateOfDischarge())%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][5]=""
			<%
			   }
			   if(discharge.getWorkingDiagnosis()!=null)
			   {
			%>
			data_arr[<%= i%>][6] = "<%=discharge.getWorkingDiagnosis()%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][6] = ""
			<%
			   }
			   if(discharge.getDisposal().getDisposalName()!=null)
			   {
			%>
			data_arr[<%= i%>][7] = "<%=discharge.getDisposal().getDisposalName()%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][7] = ""
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
		 
		formName = "opd_previousVisitForHospitality"
		
		
		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeTable(start,end);
		
		intializeHover('searchresulttable', 'TR', ' tableover');		
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
<div class="division"></div>
<%---
<input name="Back" type="button" alt="Back" value="Back" class="button"	onclick="submitForm('opd_previousVisitForHospitality','opd?method=showOPDMainJsp&visitId=<%=visitId%>&token=<%=token%>');"/>
 --%>
 <input type="button" name="Close" value="Close" class="button" onclick="window.close()" tabindex="1" />
<input type="button" name="printReport" id="print"	onclick="submitFormForDischargeSummaryReport();" value="Discharge Summary"	class="buttonBig" accesskey="a" />
<div class="clear"></div>
<div class="division"></div>
</form>
<% }else{ %>
<form name="opd_previousVisitForHospitality" method="post" action="">
<h4>Records not available! </h4>
<div class="Clear"></div>
<%--
<input name="Back" type="button" alt="Back" value="Back" class="button"	onclick="submitForm('opd_previousVisitForHospitality','opd?method=showOPDMainJsp&visitId=<%=visitId%>&token=<%=token%>');"/>
 --%>
<input type="button" name="Close" value="Close" class="button" onclick="window.close()" tabindex="1" />
<% } %>

<script type="text/javascript">	
	function submitFormForDischargeSummaryReport(){
		var flag = validateRadioForVisitNo();
		var orderNo = '';
		if(flag == false){
			return false;
		}else{
			var printId = document.getElementById('print');
			checkTargetForYes();
			//printId.setAttribute("type","submit");
			submitForm('opd_previousVisitForHospitality','/hms/hms/opd?method=showHospitalizedDischargeSummaryReport');
			checkTargetForNo();
		}
		
	}
	
	function fillDischargeNo(printValueObj){
		var allValues = printValueObj.value;
		document.getElementById('dischargeId').value = allValues;
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
