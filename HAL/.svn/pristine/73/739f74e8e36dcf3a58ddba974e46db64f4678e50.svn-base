

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
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>

<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
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
		
	
	
	

	String userName = "";
	String serviceNo = "";
	String hinNo = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	int deptId=0;
	int visitNo=0;
	String orderNo="";	
	
	if (map.get("deptId") != null) {
		deptId = (Integer) map.get("deptId");
	}
	
	String deptName="";
	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
	}
	if (map.get("visitNoForReport") != null) {
		visitNo = (Integer) map.get("visitNoForReport");
	}
	if (map.get("orderNoForReport") != null) {
		orderNo = (String) map.get("orderNoForReport");
	}

	if (map.get("serviceNoForReport") != null) {
		serviceNo = (String) map.get("serviceNoForReport");
	}
	if (map.get("hinNoForReport") != null) {
		hinNo = (String) map.get("hinNoForReport");
	}

	 boolean submitData = false;
	 if(map.get("submitData") != null){
		 submitData = (Boolean) map.get("submitData");
	 }
	 
	 String statusMsg = "";
	 if(map.get("statusMsg") != null){
		 statusMsg = (String) map.get("statusMsg");
	 }
	 
	 
%>
<div id="contentHolder">
<form name="opdPatientList" method="post" action="">
<h4><%=deptName %></h4>
<h6>OPD Patient List</h6>
<div class="Clear"></div>


<table class="tborder" width="100%" align="center">
	<tr>
		<td width="20%" nowrap="nowrap" class="vbmenu_control"
			id="threadsearch"><a href="">Search</a> <script
			type="text/javascript"> vbmenu_register("threadsearch"); </script></td>
		<td width="80%"></td>
	</tr>
</table>

<div align="center"">
<div class="page" style="width: 100%; text-align: left">
<div style="padding: 0px 25px 0px 25px"><!-- thread search menu -->
<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">

<form name="search" action="" method="post">
<table cellpadding="4" cellspacing="1" border="0">
	<tr>
		<td colspan="2" class="thead">Search Panel<a
			name="goto_threadsearch"></a></td>
	</tr>
	<tr>
		<td width="132" valign="top" class="vbmenu_option" title="nohilite"><label
			class="bodytextB1">HIN Number :</label></td>
		<td width="177" align="left" class="vbmenu_option" title="nohilite">

		<input type="text" name="<%= RequestConstants.HIN_NO %>" id="hinNo"
			MAXLENGTH="30" class="textbox_size20" / tabindex=1 /> <input
			type="hidden" name="deptName" id="deptName" value="<%=deptName %>" /></td>
		<input type="hidden" name="date" id="date" value="<%=date %>" />

		<td width="132" valign="top" class="vbmenu_option" title="nohilite"><label
			class="bodytextB1">Patient F Name :</label></td>
		<td width="177" align="left" class="vbmenu_option" title="nohilite">
		<input type="text" name="<%= RequestConstants.P_FIRST_NAME %>"
			id="patientFName" MAXLENGTH="30" class="textbox_size20" / tabindex=1 />
		</td>

	</tr>
	<tr>
		<td class="vbmenu_option" title="nohilite"><label
			class="bodytextB1">Service Number :</label></td>
		<td align="left" class="vbmenu_option" title="nohilite"><input
			type="text" name="<%= RequestConstants.SERVICE_NO %>" id="serviceNo"
			MAXLENGTH="30" / tabindex=1 class="textbox_size20" /></td>

		<td width="132" valign="top" class="vbmenu_option" title="nohilite"><label
			class="bodytextB1">Patient M Name :</label></td>
		<td width="177" align="left" class="vbmenu_option" title="nohilite">
		<input type="text" name="<%= RequestConstants.P_MIDDLE_NAME %>"
			id="patientMName" MAXLENGTH="30" class="textbox_size20" / tabindex=1 />
		</td>
	</tr>
	<tr>
		<td class="vbmenu_option" title="nohilite"><label
			class="bodytextB1">Service Type:</label></td>
		<td align="left" class="vbmenu_option" title="nohilite"><select
			name="<%=RequestConstants.SERVICE_TYPE_NAME%>" id="serviceType"
			class="NewSelectBox">
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
		</select></td>

		<td width="132" valign="top" class="vbmenu_option" title="nohilite"><label
			class="bodytextB1">Patient L Name :</label></td>
		<td width="177" align="left" class="vbmenu_option" title="nohilite">
		<input type="text" name="<%= RequestConstants.P_LAST_NAME %>"
			id="pateintLName" MAXLENGTH="30" class="textbox_size20" / tabindex=1 />
		</td>

	</tr>
	<tr>
		<td colspan="2" align="right" class="vbmenu_option"
			style="padding-right: 30px;" title="nohilite"><input
			type="button" class="morebutton" value=" "
			onClick="submitForm('search','opd?method=searchWaitingPatientListJsp');"
			style="float: right;" /></td>

	</tr>
	<tr>
		<td height="2" colspan="2" class="vbmenu_option" title="nohilite"></td>
	</tr>
</table>
</form>
</div>
</div>
</div>
</div>
<div class="Height10"></div>

<%
		if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
    %> <%
	String urlDept = ""; 
	if(map.get("urlDept") != null){
		urlDept = (String)map.get("urlDept"); 
	}
		%> <% if(submitData == true){
	%> <input name="<%=SERVICE_NO_FOR_REPORT%>" type="hidden"
	value="<%=serviceNo%>" /> <input name="<%=VISIT_NUMBER_FOR_REPORT%>"
	type="hidden" value="<%=visitNo%>" /> <input
	name="<%=HIN_NO_FOR_REPORT%>" type="hidden" value="<%=hinNo%>" /> <input
	name="<%=ORDER_NO_FOR_REPORT%>" type="hidden" value="<%=orderNo%>" /> <%if (!urlDept.equals("")){ %>
<label class="nowidth"><span>Do you want to open <%=deptName %>
specific template ?</span> </label>
<div class="Clear"></div>
<div class="bottom"><input name="Yes" type="button" align="right"
	class="cmnButton" value="Yes"
	onclick="submitForm('opdPatientList','<%=urlDept%>','checkTargetForNo');" />
<input name="No" type="button" align="right" class="cmnButton"
	value="No"
	onclick="submitForm('opdPatientList','opd?method=showWaitingPatientListJsp','checkTargetForNo');" />
<!-- <input name="button1" type="button" align="right" class="cmnButton" value="AFSFM-7A Case Sheet Print"  onclick="submitFormForAFSFMReport();" /> -->
<input name="button2" type="button" align="right" class="cmnButton"
	value="Prescription Print" onclick="submitFormForPrescriptionReport();" />
<input name="button3" type="button" align="right" class="cmnButton"
	value="Investigation Print"
	onclick="submitFormForInvestigationReport();" /></div>
<%}else{ 
	    if(statusMsg.length() > 0){%> <label class="nowidth"><span><%=statusMsg +" .\n"%></span>
</label> <%} %> <label class="nowidth"><span>Do you want to print ?</span>
</label>
<div class="Clear"></div>
<div class="bottom"><!-- <input name="button1" type="button" align="right" class="cmnButton" value="AFSFM-7A Case Sheet Print"  onclick="submitFormForAFSFMReport();" /> -->
<input name="button2" type="button" align="right" class="cmnButton"
	value="Prescription Print" onclick="submitFormForPrescriptionReport();" />
<input name="button3" type="button" align="right" class="cmnButton"
	value="Investigation Print"
	onclick="submitFormForInvestigationReport();" /> <input name="No"
	type="button" align="right" class="cmnButton" value="Back"
	onclick="submitForm('opdPatientList','opd?method=showUpdatePatientPrescribtionJsp','checkTargetForNo');" />
</div>
<%   } %> <%}
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
				//alert("I -Card Status for patient----:"+status)
				return true;
			  }		
  		}
  		alert("Please select the patient")
		return false;
		
	}
	function submitFormForAFSFMReport(){
		submitForm('opdPatientList','opd?method=showPatientMedicalCaseSheetReport','checkTargetForYes');
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
	
</script></form>
</div>
