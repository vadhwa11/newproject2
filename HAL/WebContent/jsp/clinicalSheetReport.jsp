<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : clinicalSheetReport.jsp 
	 * Jasper Reports Used : Clinical_Sheet_Report.jasper, Clinical_Sheet_SubReport_Temperature.jasper, 
	 *                       Clinical_Sheet_SubReport_Intake.jasper, Clinical_Sheet_SubReport_Output.jasper
	 * Tables Used         : ipd_intake_output_chart, ipd_temperature, ipd_intake, ipd_output
	 * Description         : User Screen to feed Input data for Clinical Sheet Report
	 * @author  Create Date: 29.02.2008    Name: Othivadivel K R   
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 * @see DischargeController.java, DischargeHandlerService.java, DischargeHandlerServiceImpl.java, 
	 *      DischargeDataService.java, DischargeDataServiceImpl.java
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>

<script type="text/javascript" language="javascript">
function openPopupWindow()
{
 var url="/hms/hms/discharge?method=showPatientSearchJsp";
 newwindow=window.open(url,'name',"height=600,width=1010,status=1,scrollbars=1,resizable=1");
}

function jsSetPatientData(hinNo)
{
document.clinicalSheetReportForm.<%=SERVICE_NO%>.value=hinNo;
document.clinicalSheetReportForm.<%=SERVICE_NO%>.focus();
}
</script>

<%
Map map = new HashMap();
Map<String, Object> utilMap = new HashMap<String, Object>();
Set patientSet = null;
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String date = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");
String status = "";
String admissionNumber = "";
String serviceNo = "";
String hinNoForPrint ="";
String adNoForprint ="" ;
if(request.getAttribute("map") != null)
{
	map = (Map) request.getAttribute("map");
	status = (String)map.get("status");
	if (status.equalsIgnoreCase("nodata"))
	{
		admissionNumber = (String)map.get("admissionNumber");
		serviceNo = (String)map.get("serviceNo");
	}
}
if(map.get("adNo") != null) {
	adNoForprint = (String) map.get("adNo");
}
if(map.get("serviceNo") != null) {
	serviceNo = (String) map.get("serviceNo");
}
%>

<div class="titleBg">
<h2>Clinical Sheet Report</h2>
</div>
<div class="clear"></div>
<form name="clinicalSheetReportForm" action="" method="post">
<h4>Enter Details</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>


<label>Service No. <span>*</span></label> 
<input type="text" name="<%=SERVICE_NO%>" id="<%=SERVICE_NO%>" value="<%=serviceNo%>" MAXLENGTH="30" validate="Service No.,String,yes"
onblur="getPatientName(this.value)"	 />
<%-- onblur="submitProtoAjax('clinicalSheetReportForm','discharge?method=getAdmissionNumberList');"
method removed for getting hinNo--%> 
<!--<img src="/hms/jsp/images/search.gif" WIDTH="26" HEIGHT="26"
	style="cursor: pointer;" onClick="javascript:openPopupWindow();">
-->
<div id="hinDiv">
<label> HIN  <span>*</span></label> <input type="text"
	name="hinNo" value="" MAXLENGTH="50" validate="Hin,String,yes"
	onchange="getAdNo(this.value);" /></div>
<!--<div id="testDiv"><label>Admission No.</label> 
<select
	name="<%=ADMISSION_NUMBER%>"	validate="Admission Number,,yes">
	<%if(adNoForprint.equals("")){ %>
<option value="0" selected="selected">Select</option>
	<%}else{ %>
<option value="<%=adNoForprint%>" selected="selected"><%=adNoForprint%></option>

	<%} %>
</select></div>
-->
<div id=adDiv>
<label>A&D No.  <span>*</span></label> 
<input type="text" id="adNo" name="adNo" validate="A&D No.,String,yes" value="" MAXLENGTH="30" /> 
</div>
</div>
<div class="clear"></div>
<h4 id="errorMsg"></h4>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="Submit" id="addbutton"	onClick="submitForm('clinicalSheetReportForm','discharge?method=showClinicalSheetReport');"	value="Ok" class="button" accesskey="a" align="center" />
<input type="reset" name="Reset" value="Cancel" class="button"	onclick="location.reload();" accesskey="r" />
<input	type="hidden" name="SearchFlag" value="false" />
 <script>
	<% if (status.equalsIgnoreCase("nodata")) { %>
			 document.clinicalSheetReportForm.<%=SERVICE_NO%>.value='<%=serviceNo%>';
			 alert('No Report Data Found');
			 submitProtoAjax('clinicalSheetReportForm','discharge?method=getAdmissionNumberList');  	
   	<% } %>
   	</script>
 <div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>  	
 </form>
<script>
function getPatientName(val)
{
	//submitProtoAjaxWithDivName('ipInvestigationReport','/hms/hms/ipd?method=showPatientName&paramName='+val+'&flag=s','patient');
	submitProtoAjaxWithDivName('clinicalSheetReportForm','/hms/hms/ipd?method=showPatientHinNo&paramName='+val,'hinDiv');
}
function getAdNo(val)
{
	submitProtoAjaxWithDivName('clinicalSheetReportForm','/hms/hms/ipd?method=showPatientName&paramName='+val+'&flag=w'+'&flag1=k','adDiv');
}
</script>