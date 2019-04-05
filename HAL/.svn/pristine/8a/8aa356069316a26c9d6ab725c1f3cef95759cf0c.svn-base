
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
<%@page import="jkt.hms.masters.business.OpdPatientHistory"%>
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
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>


<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
 <script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script> 
<!-- <META HTTP-EQUIV="REFRESH" CONTENT="20"> -->
<script type="text/javascript">
	   var icdArray=new Array();

	</script>
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

		if(map.get("visitNoForJsp") != null){
			visitNoForJsp=(Integer)map.get("visitNoForJsp");
		}
		
		if(map.get("visitId") != null){
			visitId = (Integer)map.get("visitId");
		}
		
	/* List patientPreviousVisitList = new ArrayList(); */
		List<OpdPatientHistory> patientPreviousVisitList = new ArrayList<OpdPatientHistory>();
	List<Integer> maxVisitIdList = new ArrayList<Integer>();
	List<Integer> minVisitIdList = new ArrayList<Integer>();
	
	if(map.get("patientPreviousVisitList") != null){
		//patientPreviousVisitList=(List)map.get("patientPreviousVisitList");
		patientPreviousVisitList=(List<OpdPatientHistory>)map.get("patientPreviousVisitList");
	}	
	if(map.get("maxVisitIdList") != null){
		maxVisitIdList=(List)map.get("maxVisitIdList");
	}	
	if(map.get("minVisitIdList") != null){
		minVisitIdList=(List)map.get("minVisitIdList");
	}	
	System.out.println("patientPreviousVisitList.size()-->"+patientPreviousVisitList.size());
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
	int deptId=visitObj.getDepartment()!=null?visitObj.getDepartment().getId():0;
	MasAdministrativeSex masAdministrativeSexObj=patientObj.getSex();
%>


<div class="titleBg"><h2>Previous Prescriptions</h2></div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />


<form name="opdPatientPrevVisitForReport" method="post" action="">
<!-- <input type="button" class="button"  value="Clinical Setup" align="left" onClick="submitForm('patientList','ipd?method=showNursingCareJsp','validateRadio');" />-->




<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>


<script type="text/javascript" language="javascript">
	
	formFields = [
			[0, "<%= RequestConstants.HIN_ID%>", "id"],[1, "<%= RequestConstants.RADIO_FOR_TABLE%>"], [2,"<%= RequestConstants.TOKEN_NO%>"], [3,"<%= RequestConstants.VISIT_NUMBER %>"], [4,"<%= RequestConstants.VISIT_DATE %>"],[5,"<%= RequestConstants.VISIT_TIME %>"],[6,"<%= RequestConstants.SERVICE_NO %>"],[7,"<%=RequestConstants.APPOINTMENT_TYPE%>"],[8,"<%= RequestConstants.PATIENT_NAME %>"],[9,"<%=RequestConstants.AGE%>"],[10,"<%=RequestConstants.SEX%>"],[11,"<%=RequestConstants.DIAGNOSIS_ID%>"],[12,"visitNoForJsp"],[13,"<%=RequestConstants.EMPLOYEE_ID %>"],[14,"<%=RequestConstants.DISPOSAL_ID %>"] ,[15,"days"]];
	statusTd =15;
</script></div>
<div id="edited"></div>
<div id="statusMessage" ></div>
<input type="hidden" name="serviceNoForReport" id="serviceNoForReport"	value="<%=visitObj.getHin().getServiceNo()%>" />
<input type="hidden" name="visitNumberForReport"	id="visitNumberForReport" value="<%=visitObj.getOpdPatientDetails().getVisit().getVisitNo()%>" />
<input type="hidden" name="hinNoForReport" id="hinNoForReport" value="<%=visitObj.getHin().getHinNo()%>" />
<input type="hidden" name="hospitalIdForReport" id="hospitalIdForReport" value="<%=visitObj.getHospital().getId()%>" />

<input type="hidden" name="visitId" id="visitId"	value="" />
<script	type="text/javascript" language="javascript">
		
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = " "
		data_header[0][1] = "radio";
		data_header[0][2] = "5%";
		data_header[0][3] = "<%= RequestConstants.RADIO_FOR_TABLE%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "Token No"
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
		data_header[5][0] = "Employee No."
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
		data_header[9][0] = "Sex"
		data_header[9][1] = "hide";
		data_header[9][2] = "1%";
		data_header[9][3] = "<%=RequestConstants.SEX%>";
		
		data_header[10] = new Array;
		data_header[10][0] = "Diagnosis"
		data_header[10][1] = "hide";
		data_header[10][2] = "10%";
		data_header[10][3] = "<%=RequestConstants.DIAGNOSIS_ID %>";
		
		data_header[11] = new Array;
		data_header[11][0] = "visit No For Jsp"
		data_header[11][1] = "hide";
		data_header[11][2] = "10%";
		data_header[11][3] = "visitNoForJsp";

		data_header[12] = new Array;
		data_header[12][0] = "Doctor"
		data_header[12][1] = "data";
		data_header[12][2] = "10%";
		data_header[12][3] = "<%=RequestConstants.EMPLOYEE_ID %>";

		data_header[13] = new Array;
		data_header[13][0] = "Diagnosis"
		data_header[13][1] = "hide";
		data_header[13][2] = "10%";
		data_header[13][3] = "<%=RequestConstants.DIAGNOSIS_ID %>";
		
		data_header[14] = new Array;
		data_header[14][0] = "Disposal"
		data_header[14][1] = "hide";
		data_header[14][2] = "10%";
		data_header[14][3] = "<%=RequestConstants.DISPOSAL_ID %>";

		data_header[15] = new Array;
		data_header[15][0] = "Days"
		data_header[15][1] = "hide";
		data_header[15][2] = "10%";
		data_header[15][3] = "days";
		
		//added by Babita
		data_header[16] = new Array;
		data_header[16][0] = "Speciality"
		data_header[16][1] = "data";
		data_header[16][2] = "10%";
		data_header[16][3] = "deptName";
		
		data_header[17] = new Array;
		data_header[17][0] = "ICD Diagnosis"
		data_header[17][1] = "data";
		data_header[17][2] = "10%";
		data_header[17][3] = "icdDiagnosis";
		
		data_arr = new Array();
		
		<%
		int  i=0;
		try{
			String st="";
			String icdDaignosisString= "";
			String seperator = " | ";
			// Iterator iterator=patientPreviousVisitList.iterator();
		
	          for(i=0;  i<=patientPreviousVisitList.size();i++)
	           {   
	        	  //Visit visit= (Visit) iterator.next();
	        	  //  MasDepartment deptObj=(MasDepartment)visit.getDepartment();
	        	      Visit visit= (Visit) patientPreviousVisitList.get(i).getOpdPatientDetails().getVisit();
		        	  
		    			Set<DischargeIcdCode> dischageIcdSet = new HashSet<DischargeIcdCode>();
		    			dischageIcdSet = visit.getDischargeIcdCodes();
		    			 int count =0;
						for(DischargeIcdCode orderdt : dischageIcdSet){
		       				if(count++>=1)
		       					icdDaignosisString = icdDaignosisString.concat(seperator);
		       				    icdDaignosisString = icdDaignosisString.concat(orderdt.getIcd().getIcdName());
		       			}
	        	      
	        	      Patient patientHin=(Patient)visit.getHin();
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
					String doctorName="";
					  if(visit.getDoctor()!= null){
						  if(visit.getDoctor().getFirstName() !=null)
						  doctorName=visit.getDoctor().getFirstName();
		   	        	  }
						if(visit.getDoctor()!= null){
							
							 if(visit.getDoctor().getMiddleName() !=null)
							doctorName=doctorName+" "+visit.getDoctor().getMiddleName();
						}
						if(visit.getDoctor()!= null)
						{
							 if(visit.getDoctor().getLastName() !=null)
							doctorName=doctorName+" "+visit.getDoctor().getLastName();
						}
						String disposal="";
						if(visit.getDisposal()!=null){
							disposal=visit.getDisposal().getDisposalName();
						}
						String dignosis="";
						if(visit.getDiagnosisName()!=null){
							dignosis=visit.getDiagnosisName();
						}
		        	  MasAdministrativeSex masAdministrativeSex=patientHin.getSex();
		        	  String visitDate =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
		        	  
		        	  
		        	  
		        	  
		%>
		
			data_arr[<%= i%>] = new Array();
			
			data_arr[<%= i%>][0] ="<%=visit.getId()%>"
			
			data_arr[<%= i%>][1] = '<input type="radio" class="radiogrid" name="parent" value="<%=visit.getHin().getServiceNo()%>@<%=visit.getHin().getHinNo()%>@<%=visit.getVisitNo()%>@<%=visit.getId()%>@<%=visit.getHospital().getId()%>" id="parent" onclick="fillVisitNo(this)"/>'
			
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
		
			if(visit.getWorkingDiagnosis()!= null){
			
		%>
			data_arr[<%= i%>][11] = "<%=visit.getWorkingDiagnosis()%>"
		<%
		  	}else{
		%>
			data_arr[<%= i%>][11] = ""
		<%}%>
		<%if(visitNoForJsp != 0){%>
		 data_arr[<%= i%>][12] = "<%=visitNoForJsp%>"
			 <%}else{%>
			 data_arr[<%= i%>][12] = ""
			 <%}%>
		 <%if(doctorName != null){%>
		 data_arr[<%= i%>][13] = "<%=doctorName%>"
			 <%}else{%>
			 data_arr[<%= i%>][13] = ""
			 <%}%>
			 <%if(dignosis != null && !dignosis.equals("")){%>
			 data_arr[<%= i%>][14] = "<%=dignosis%>"
				 <%}else{%>
				 data_arr[<%= i%>][14] = "&nbsp;"
				 <%}%>	 
		
				 <%if(disposal != null && !disposal.equals("")){%>
				 data_arr[<%= i%>][15] = "<%=disposal%>"	
					 <%}else{%>
					 data_arr[<%= i%>][15] = "&nbsp;"
					 <%}%>	 
					 <%if(visit.getDisposalDays() != null){%>
					 data_arr[<%= i%>][16] = "<%=visit.getDisposalDays()%>"	
						 <%}else{%>
						 data_arr[<%= i%>][16] = "&nbsp;"
						 <%}%>	 
					        <%
							if(visit.getDepartment().getDepartmentName()!= null){
								
								%>
									data_arr[<%= i%>][17] = "<%=visit.getDepartment().getDepartmentName()%>"
								<%
								  	}else{
								%>
								data_arr[<%= i%>][17] = ""
								<%
								  	}%>	
								  	
									<%
									if(icdDaignosisString!= null){
									%>

									data_arr[<%= i%>][18] = "<%=icdDaignosisString%>"
									<%
										}else{
									%>
									data_arr[<%= i%>][18] = ""
									<%}%>
		 
		<% 	
			//i++;
		  }
		}catch(Exception e){
		e.printStackTrace();	
	
		}
		%>
		 
		formName = "opdPatientPrevVisitForReport"
		
		
		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeTable(start,end);
		
		intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
<div class="Clear"></div>
<%--  <div class="floatRight">
<label class="auto"><span>Total Patient Visit </span></label>
<label class="valueAuto"><%= i%></label>
<input type="hidden"	name="counter" id="counter" value="<%=i %>" />
<input type="hidden" name="visitNoForJsp" id="visitNoForJsp" value="<%=visitNoForJsp%>" />
</div>
--%>
<div class="clear"></div>
<div class="division"></div>
<!-- 
<input name="Back" type="button"	alt="Back" value="Back" class="button"	onclick="submitForm('opdPatientPrevVisitForReport','opd?method=showOPDMainJsp&visitId=<%=visitId%>&deptId=<%=deptId%>');"/>
 -->
<input type="button" name="close" id="close"	onclick="window.close();" value="Close"	class="button" accesskey="a" />

<input type="button" name="printReport" id="print" 	onclick="submitFormForPrescriptionReport();" value="print Prescription"	class="buttonBig" accesskey="a" />

<input type="button" name="printReport" id="print" 	onclick="openPrescriptionDetails();" value="Prescription Details"	class="buttonBig" accesskey="a" />
<!--  
<div class="arrowlistmenu">
<ul  class="categoryitems">
	<li> <a href="javascript:openPopupPrescriptionDetails(473,11,3)">
	Previous Prescriptions</a></li>
</ul>
</div>
-->
<div class="clear"></div>
<div class="division"></div>
</form>
<% }else{ %>

<form name="opdPatientPrevVisitForReport" method="post" action="">
<h4>No Previous Prescription Records Found</h4>
<div class="Clear"></div>
<input type="button" name="close" id="close"	onclick="window.close();" value="Close"	class="button" accesskey="a" />
<!-- <input name="Back" type="button"	alt="Back" value="Back" class="button"	onclick="history.go(-1);return false;" />--></form> 

<% } %>
<div id="testP"></div>
<script type="text/javascript">	
function openPrescriptionDetails(){
	var flag = validateRadioForVisitNo();
	var orderNo = '';
	if(flag == false){
		return false;
	}else{
		var printId = document.getElementById('print');
		
		//submitForm('opdPatientPrevVisitForReport','/hms/hms/opd?method=showPatientPreviousPrescriptionRepeat');
		submitProtoAjaxWithDivName('opdPatientPrevVisitForReport','/hms/hms/opd?method=showPatientPreviousPrescriptionRepeat','testP');
			
		checkTargetForNo();
	}
	
}
/*
function openPopupPrescriptionDetails(visitId,hinId,visitNo)
{
 var url="/hms/hms/opd?method=showPatientPreviousPrescription&visitId="+visitId+"&hinId="+hinId+"&visitNo="+visitNo;
 newwindow=window.open(url,'name',"left=2,top=100,height=300,width=1010,status=1,scrollbars=1,resizable=0");
	 //alert("Detention Advice ....");
}
*/
	function submitFormForPrescriptionReport(){
		var flag = validateRadioForVisitNo();
		var orderNo = '';
		if(flag == false){
			return false;
		}else{
			var printId = document.getElementById('print');
			checkTargetForYes();
			
			//printId.setAttribute("type","submit");
			submitForm('opdPatientPrevVisitForReport','/hms/hms/opd?method=showPatientPrescriptionReport');
			//submitForm('opdPatientPrevVisitForReport','/hms/hms/opd?method=opdPatientInvestigationFormatPrint');
			checkTargetForNo();
		}
		
	}
	function openPriscriptionDetails(){
		var flag = validateRadioForVisitNo();
		var orderNo = '';
		if(flag == false){
			return false;
		}else{
			var printId = document.getElementById('print');
			checkTargetForYes();
			//printId.setAttribute("type","submit");
			//submitForm('opdPatientPrevVisitForReport','/hms/hms/opd?method=showPatientPrescriptionReport');
			submitForm('opdPatientPrevVisitForReport','/hms/hms/opd?method=opdPatientInvestigationFormatPrint');
			checkTargetForNo();
		}
		
	}
	function fillVisitNo(printValueObj){
		var allValues = printValueObj.value;
		var allValuesArray = allValues.split("@");
		document.getElementById('serviceNoForReport').value = allValuesArray[0];
		document.getElementById('visitNumberForReport').value = allValuesArray[2]; 
		document.getElementById('hinNoForReport').value = allValuesArray[1];
		document.getElementById('visitId').value = allValuesArray[3];
		document.getElementById('hospitalIdForReport').value = allValuesArray[4];
		
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

<script type="text/javascript">
var icdArray=new Array();
var unitArray=new Array();
var instructionACPCArray=new Array();
var typeLeftRightArray=new Array();
	function setValuesInParentForPrescription(formname){
  		//formName=formname.name;
		var grid = window.opener.document.getElementById("grid").rows.length;

 		var nomenclatureVal = window.opener.document.getElementById('nomenclature1').value;
 		var hdbVal = window.opener.document.getElementById('hdb').value;
		if(hdbVal == 1 && nomenclatureVal == ''){
			var len = window.opener.document.getElementById("grid").rows.length;
			var r1 = window.opener.document.getElementById("grid").deleteRow(len-1);
		}
			
		for(var index = 1; index < parseInt(document.patientPrescription.counter.value); index++ ){
			
			var toEval = "document.patientPrescription.repeatPrescription" + index;
			var repeatIn = eval(toEval);
			if(repeatIn.checked == true){
			
				  var len = window.opener.document.getElementById("grid").rows.length;
				  //var r1 = window.opener.document.getElementById("grid").deleteRow(len-1);
				  var r = window.opener.document.getElementById("grid").insertRow(len);
				  
				  var c1 = r.insertCell(0);
				  var c2= r.insertCell(1);
				  var c3 = r.insertCell(2);
				  var c4 = r.insertCell(3);
				  var c5 = r.insertCell(4);
				  var c6 = r.insertCell(5);
				  var c7 = r.insertCell(6);
				  var c8 = r.insertCell(7);
				  var c9 = r.insertCell(8);	
				  var c10 = r.insertCell(9);
				  var c11 = r.insertCell(10);	
				  var c12 = r.insertCell(11);			
				/*   var c13 = r.insertCell(12);	 */
				  
				  var nomenclature=eval('document.'+formname+'.nomenclature' + index + '.value')
				  var pvmsNo=eval('document.'+formname+'.pvmsNo' + index + '.value')
				
				  var x1 = window.opener.document.createElement('input');
				  x1.type = 'text';
				  x1.name='nomenclature'+len;
				  x1.id='nomenclature'+len;
				  x1.size = '30';
	  			  x1.tabindex='1';	 				  
				  x1.value = nomenclature+"["+pvmsNo+"]";;
				  
				  c1.appendChild(x1);
	  			  //new Ajax.Autocompleter('nomenclature'+len,'ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature'+len});
                  
                    
				  var divElement = window.opener.document.createElement('div');
				  divElement.id = 'ac2update1';
				  divElement.style.display = 'none';
				  c1.appendChild(divElement);
                  
				  var x2 = window.opener.document.createElement('input');
				  x2.type = 'text';
				  x2.name='otherMedicine'+len;
				  x2.id='otherMedicine'+len
				  x2.size='20';
				  x2.setAttribute('tabindex','1');
				  c2.appendChild(x2);

				  var x3 = window.opener.document.createElement('Select');
				  x3.name='itemConversionId'+len;
				  x3.id='itemConversionId'+len;
				  x3.className='medium';
				  //e2.class = 'medium';
				  x3.setAttribute('tabindex','1');
				//  x3.options[0] = new Option('Select', '0');
				 var opt = window.opener.document.createElement("option");  
				 opt.value = '0';
		      	 opt.innerHTML = 'Select';
		      	 x3.appendChild(opt);
				   for(var i = 0;i<unitArray.length;i++ ){
					   var option1 = window.opener.document.createElement("option");  
		   		      	if(selectedFrequency == unitArray[i][0]){
		   		      	    option1.value = unitArray[i][0];
		   		      	    option1.innerHTML = unitArray[i][1];
		   		      		option1.selected='Selected';
		   		      	}else{
		   		      	 	option1.value = unitArray[i][0];
		   		      	    option1.innerHTML =unitArray[i][1];
		   		      	}
		   		     x3.appendChild(option1);
				     // e12.options[i+1] = new Option(unitArray[i][1],unitArray[i][0]);
				      }
				  c3.appendChild(x3);

				  var x41 = window.opener.document.createElement('input');
				  x41.type = 'hidden';
				  x41.name='actualDispensingQty'+len;
				  x41.id='actualDispensingQty'+len
				  x41.size='6';
				  x41.setAttribute('tabindex','1');
				  var x4 = window.opener.document.createElement('input');
				  x4.type = 'text';
				  x4.name='au'+len;
				  x4.id='au'+len
				  x4.size='6';
				  x4.setAttribute('tabindex','1');
				  //e12.onblur=function(){displayAU(this.value,iteration)};
				  c4.appendChild(x41);
				  c4.appendChild(x4);
				  
				  var x51 = window.opener.document.createElement('input');
				  x51.type = 'hidden';
				  x51.name='pvmsNo'+len;
				  x51.id='pvmsNo'+len;
				  x51.size = '10';
				  x51.setAttribute('tabindex','1');				  
				  x51.value = eval('document.'+formname+'.pvmsNo' + index + '.value');
				  x51.setAttribute("readonly","readonly");
				  c5.appendChild(x51);

				  var x5 = window.opener.document.createElement('input');
				  x5.type = 'text';
				  x5.name='dosage'+len;
				  x5.id='dosage'+len;
				  x5.size = '5';
	  			  x5.setAttribute('tabindex','1');				  
				  x5.value = eval('document.'+formname+'.dosage' + index + '.value');
				  //x3.setAttribute("readonly","readonly");
				  c5.appendChild(x5);

				  var x6 = window.opener.document.createElement('Select');
				  //x4.type = 'hidden';
				  x6.name='frequency'+len;
				  x6.id='frequency'+len;
				  x6.className='medium';
	  			  x6.tabindex = '1';	
				  selectedFrequency = eval('document.'+formname+'.frequencyId' + index + '.value');
				  var opt1 = window.opener.document.createElement("option");  
				  opt1.value = '0';
		      	  opt1.innerHTML = 'Select';
		      	  x6.appendChild(opt1);
				  for(var i = 0;i<icdArray.length;i++ ){
					  var option = window.opener.document.createElement("option");  
		   		      	if(selectedFrequency == icdArray[i][0]){
		   		      	    option.value = icdArray[i][0];
		   		      	    option.innerHTML = icdArray[i][1];
		   		      		option.selected='Selected';
		   		      	}else{
		   		      	 	option.value = icdArray[i][0];
		   		      	    option.innerHTML = icdArray[i][1];
		   		      	}
		   		     x6.appendChild(option);
				  }

				/*  x4.options[0] = new Option('Select', '0');
	   		      for(var i = 0;i<icdArray.length;i++ ){
	   		      	if(selectedFrequency == icdArray[i][0]){
	   		      		x4.options[i+1] = new Option(icdArray[i][1],icdArray[i][0]);
	   		      		x4.options[i+1].selected='Selected';
	   		      	}else{
	      		  		x4.options[i+1] = new Option(icdArray[i][1],icdArray[i][0]);
	   		      	}
	      		  }*/
	      		  
	      		  
				  c6.appendChild(x6);

	      		  var e61 = window.opener.document.createElement('input');
	      		  e61.type = 'text';
	      		  e61.name='sosQty'+len;
	      		  e61.id='sosQty'+len;
	      		  e61.tabIndex='1';
	      		  e61.size='3';
	      		  e61.style.display='none';
	      		  e61.setAttribute('maxlength', 3); 
	      	      e61.onblur=function(){fillValue(this.value,iteration)};
	      		  c6.appendChild(e61);

	      		  var e62 = window.opener.document.createElement('input');
	      		  e62.type = 'hidden';
	      		  e62.name='frequencyValue'+len;
	      		  e62.id='frequencyValue'+len;
	      		  e62.size='5';
	      		  e62.setAttribute('tabindex','1');
	      		  c6.appendChild(e62);

				  var x7 = window.opener.document.createElement('input');
				  x7.type = 'text';
				  x7.name='noOfDays'+len;
				  x7.id='noOfDays'+len;
				  x7.size = '3';
	  			  x7.setAttribute('tabindex','1');				  
				  x7.value = eval('document.'+formname+'.noOfDays' + index + '.value');
				  //x5.setAttribute("readonly","readonly");
				  c7.appendChild(x7);

				  var e71 = window.opener.document.createElement('input');
				  e71.type = 'hidden';
				  e71.name='total'+len;
				  e71.id='total'+len;
				  e71.size='5';
				  e71.setAttribute('tabindex','1');
				  c7.appendChild(e71);

				  var x8 = window.opener.document.createElement('input');
				  x8.type = 'text';
				  x8.name='route'+len;
				  x8.id='route'+len
				  x8.size='5';
					//e6.value='route';
				  x8.setAttribute('maxlength', 20); 
				  x8.setAttribute('tabindex','1');
				  c8.appendChild(x8);
				  /* 

				  var x7 = document.createElement('Select');
				  x7.name='instructionACPC'+len;
				  x7.id='instructionACPC'+len;
				  x7.options[0] = new Option('Select', '');
				  selectedInstructionACPC = eval('document.'+formName+'.instructionACPC' + index + '.value'); 
	   		      for(var i = 0;i<instructionACPCArray.length;i++ ){
	   		      	if(selectedInstructionACPC == instructionACPCArray[i][0]){
	   		      		x7.options[i+1] = new Option(instructionACPCArray[i][1],instructionACPCArray[i][0]);
	   		      		x7.options[i+1].setAttribute('Selected','Selected');
	   		      	}else{
	      		  		x7.options[i+1] = new Option(instructionACPCArray[i][1],instructionACPCArray[i][0]);
	   		      	}
	      		  }
				  
	  			  x7.setAttribute('tabindex','1');				  
				  c7.appendChild(x7);

				  var x8 = document.createElement('Select');
				  x8.name='typeLeftRight'+len;
				  x8.id='typeLeftRight'+len;
				  
				  x8.options[0] = new Option('Select', '');
				  selectedtypeLeftRight = eval('document.'+formName+'.typeLeftRight' + index + '.value'); 
	   		      for(var i = 0;i<typeLeftRightArray.length;i++ ){
	   		      	if(selectedtypeLeftRight == typeLeftRightArray[i][0]){
	   		      		x8.options[i+1] = new Option(typeLeftRightArray[i][1],typeLeftRightArray[i][0]);
	   		      		x8.options[i+1].setAttribute('Selected','Selected');
	   		      	}else{
	      		  		x8.options[i+1] = new Option(typeLeftRightArray[i][1],typeLeftRightArray[i][0]);
	   		      	}
	      		  }
				  
	  			  x8.setAttribute('tabindex','1');				  
				  c8.appendChild(x8);
				  */
				  //var cellRight6 = row.insertCell(6);
					
					
				  var x9 = window.opener.document.createElement('input');
				  x9.type = 'text';
				  x9.name='remarks'+len;
				  x9.id='remarks'+len;
				  x9.size = '10';
	  			  x9.setAttribute('tabindex','1');				  
				  x9.value = eval('document.'+formname+'.remarks' + index + '.value');
				  //x5.setAttribute("readonly","readonly");
				  c9.appendChild(x9);
				  
				/*   var x10 = window.opener.document.createElement('input');
				  x10.type = 'checkbox';
				  x10.name='ct'+len;
				  x10.id='ct'+len
				  x10.size='10';
				  x10.className='radio';
				  x10.value='y';
				  x10.setAttribute('tabindex','1');
				  c10.appendChild(x10); */

				  var x11 = window.opener.document.createElement('input');
				  x11.type = 'text';
				  x11.name='closingStock'+len;
				  x11.id='closingStock'+len
				  x11.size='3';
				  x11.setAttribute('tabindex','1');
				  c10.appendChild(x11);



				  var x12 = window.opener.document.getElementById('hdb');
				  x12.value=len;

				  
				  var x13 = window.opener.document.createElement('input');
				  x13.type = 'button';
				  x13.className = 'buttonAdd';
	  			 // x13.tabindex='1';	
	  			  x13.onClick=function(){addRow()}; 			  
				  c11.appendChild(x13);

				  var x14 = window.opener.document.createElement('input');
				  x14.type = 'button';
				  x14.className = 'buttonDel';
	  			  x14.tabindex='1';	
	  			  x14.onclick=function(){removeRow();}; 			  
				  c12.appendChild(x14);
				  
				 
			}
		}
		
	window.close();		
  	}
		
	
		
</script>