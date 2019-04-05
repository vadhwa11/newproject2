

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
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

<%@page import="jkt.hms.util.Box"%><script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
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

		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");




	List patientList = new ArrayList();

	if(map.get("patientList") != null){
		patientList=(List)map.get("patientList");
	}
	Box box = HMSUtil.getBox(request);




	String userName = "";
	String serviceNo = "";
	String hinNo = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	int deptId=0;
	int visitNo=0;
	int visitId=0;
	String orderNo="";
String departmentCode="";
String message="";
	if (map.get("deptId") != null) {
		deptId = (Integer) map.get("deptId");
	}

	String deptName="";
	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
	}
	if (map.get("departmentCode") != null) {
		departmentCode = (String) map.get("departmentCode");
	}
	if (map.get("visitNoForReport") != null) {
		visitNo = (Integer) map.get("visitNoForReport");
	}
	if (map.get("orderNoForReport") != null) {
		orderNo = (String) map.get("orderNoForReport");
	}
	if (map.get("visitId") != null) {
		visitId = (Integer) map.get("visitId");
	}
	if (map.get("serviceNoForReport") != null) {
		serviceNo = (String) map.get("serviceNoForReport");
	}
	if (map.get("hinNoForReport") != null) {
		hinNo = (String) map.get("hinNoForReport");
	}
	String referedToMH = "";
	if (map.get("referedToMH") != null) {
		referedToMH = (String) map.get("referedToMH");
	}
	int unitId = 0;
	if (map.get("unitId") != null) {
		unitId = (Integer) map.get("unitId");
	}
	 boolean submitData = false;
	 if(map.get("submitData") != null){
		 submitData = (Boolean) map.get("submitData");
	 }
	
		if(map.get("message") != null){
		  message = (String)map.get("message");
	     }
	String flag = "";

	if(map.get("flag") != null){
		flag = (String)map.get("flag");
     }
	System.out.println("flag===="+flag);
%>

<div class="Clear"></div>


<div class="clear"></div>

<!-- thread search menu -->
<div class="searchBlock" id="threadsearch_menu" style="display: none">
<div class="clear"></div>
<form name="search" action="" method="post">
<label>HIN No.</label>
<input type="text" name="<%= RequestConstants.HIN_NO %>" id="hinNo"	MAXLENGTH="30" tabindex=1 />
<input	type="hidden" name="deptName" id="deptName" value="<%=deptName %>" />

<label>Patient F Name</label>
<input type="text" name="<%= RequestConstants.P_FIRST_NAME %>"	id="patientFName" MAXLENGTH="30" tabindex=1 />

<div class="clear"></div>
<label>Service No.</label>
<input	type="text" name="<%= RequestConstants.SERVICE_NO %>" id="serviceNo"	MAXLENGTH="30" tabindex=1 /></td>
<label>Patient M Name</label>
<input type="text" name="<%= RequestConstants.P_MIDDLE_NAME %>"	id="patientMName" MAXLENGTH="30" tabindex=1 />
<div class="clear"></div>
<label>Service Type</label>
<select	name="<%=RequestConstants.SERVICE_TYPE_NAME%>" id="serviceType"	>
			<option value="">Select</option>
			<%
								try{
								if(patientList.size()>0){
									Set serviceTypeSet=  new HashSet();
									Iterator itr=patientList.iterator();
								    while(itr.hasNext()){
								    	Visit visitObj= (Visit) itr.next();
								    	String serviceType=visitObj.getHin().getServiceType().getServiceTypeName();
								    	if(visitObj.getVisitStatus().equals("w")){
								    	serviceTypeSet.add(serviceType);
								    	}
								    }
								    	Iterator iterator=serviceTypeSet.iterator();
									    while(iterator.hasNext()){
									    	String serviceType=(String)iterator.next();
								%>

			<option value=<%=serviceType%>><%=serviceType%></option>

			<%

								  }
								    }
								}catch(Exception e){
								e.printStackTrace();

								}
								%>
		</select>

	<label>Patient L Name</label>
		<input type="text" name="<%= RequestConstants.P_LAST_NAME %>"	id="pateintLName" MAXLENGTH="30" tabindex=1 />
	<div class="clear"></div>
	<label>&nbsp;</label>
	
	<input	type="button" class="button" value=""	onClick="submitForm('search','opd?method=searchWaitingPatientListJsp');" />
</form>
</div>
<form name="fwcAntental" method="post" action="">
 <%
	System.out.println("submitData===="+submitData);
 String urlDept = "";
	if(map.get("urlDept") != null){
		urlDept = (String)map.get("urlDept");
	}
		%> <% if(submitData == true){
	%>
	<input name="flag" type="hidden" value="<%=flag%>" id="flagId" />
	<input name="<%=SERVICE_NO_FOR_REPORT%>" type="hidden" 	value="<%=serviceNo%>" />
 	<input name="<%=VISIT_NUMBER_FOR_REPORT%>" type="hidden" value="<%=visitNo%>" />
	<input name="<%=HIN_NO_FOR_REPORT%>" type="hidden" value="<%=hinNo%>" />
	<input name="<%=ORDER_NO_FOR_REPORT%>" type="hidden" value="<%=orderNo%>" />
	<input name="<%=VISIT_ID%>" type="hidden" value="<%=visitId%>" />
	<input name="<%=UNIT_ID%>" type="hidden" value="<%=unitId%>" />
	<input type="hidden" name="date" id="date" value="<%=date %>" />

<h4><%=message %></h4>
<label class="auto">Do you want to print ?</label>
<div class="Clear"></div>
<div class="division"></div>
<%-- 
<input name="button1" type="button"	align="right" class="button" value="Form 44"
	onclick="submitForm44();" />
<%
if(referedToMH.equals("y")){ %>
<input name="button2" type="button"	align="right" class="buttonBig2" value="AFMSF-7A"
	onclick="submitFormForAFSFMReport();" />
	<%} %>--%>
<input name="button2" type="button"	align="right" class="buttonBig2" value="Case Sheet"
	onclick="submitFormForCaseSheetReport();" />
<%-- <input name="button3" type="button" align="right" class="buttonBig" value="Prescription"
			 onclick="submitFormForPrescriptionReport();" />
<input name="button4" type="button" align="right" class="buttonBig" value="Investigation"
		onclick="submitFormForInvestigationReport();" />
<input name="No" type="button" align="right" class="button" value="No"
	onclick="submitForm('opdPatientList','opd?method=showWaitingPatientListJsp','checkTargetForNo');" />--%>
<div class="Clear"></div>
<div class="division"></div>
<%   } %> <%
%> <script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script> <script type="text/javascript">

		function validateICard(){
			var counter=document.getElementById("counter")
			 for(var i = 0; i < document.getElementsByName('parent').length; i++){

			  if(document.getElementsByName('parent')[i].checked == true)
              {
              	var index=start+i;
				var status=document.getElementById('iCardStatus'+index).value
				if(status=="n")
				{
					alert("I-Card is not available with the patient.")
					return true;
				}
				return true;
			  }
  		}
  		alert("Please select the patient")
		return false;

	}
		function submitFormForCaseSheetReport(){
			if(document.getElementById('flagId').value =="fwc"){
			submitForm('fwcAntental','fwc?method=showAntentalCardReportJsp','checkTargetForYes');
			}else if(document.getElementById('flagId').value =="pnc"){
			submitForm('fwcAntental','fwc?method=showPncReportJsp','checkTargetForYes');
			}else if(document.getElementById('flagId').value =="fp"){
				submitForm('fwcAntental','fwc?method=showFpReportJsp','checkTargetForYes');
			}
			checkTargetForNo();
		}
	function submitFormForAFSFMReport(){
		submitForm('opdPatientList','opd?method=printPatientReviewMedicalCaseSheetReport&selectedRadio=2','checkTargetForYes');
		checkTargetForNo();
	}
	function submitFormForPrescriptionReport(){
		submitForm('opdPatientList','opd?method=showPatientPrescriptionReport','checkTargetForYes');
		checkTargetForNo();
	}
	
	function submitFormForInvestigationReport(){
		submitForm('opdPatientList','opd?method=showPatientInvestigationReport','checkTargetForYes');
		checkTargetForNo();
	}
	function submitForm44(){
		submitForm('opdPatientList','opd?method=showPatientForm44Report','checkTargetForYes');
		checkTargetForNo();
	}
</script></form>
