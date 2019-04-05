<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : dischargeSummaryReport.jsp 
	 * Jasper Reports Used : Discharge_Summary_General.jasper, Discharge_Summary_Gyna.jasper, Discharge_Summary_Pedia.jasper
	 * Tables Used         : discharge_items, discharge_items_category, discharge_summary, patient
	 * Description         : User Screen to feed Input data for Reports viz. Discharge Summary General, Gynaecology & Pediatrics
	 * @author  Create Date: 18.02.2008    Name: Othivadivel K R   
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 * @see DischargeController.java, DischargeHandlerService.java, DischargeHandlerServiceImpl.java, 
	 *      DischargeDataService.java, DischargeDataServiceImpl.java, admissionNumberPopulate.jsp
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

function jsSetPatientData(serviceNo)
{
document.dischargeSummaryReportForm.<%=SERVICE_NO%>.value=serviceNo;
document.dischargeSummaryReportForm.<%=SERVICE_NO%>.focus();
}

</script>

<%
Map map = new HashMap();
Map<String, Object> utilMap = new HashMap<String, Object>();
Set patientSet = null;
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String status = "";
String admissionNumber = "";
String hinNo = "";
if(request.getAttribute("map") != null)
{
	map = (Map) request.getAttribute("map");
	status = (String)map.get("status");
	if (status.equalsIgnoreCase("nodata"))
	{
		admissionNumber = (String)map.get("admissionNumber");
		hinNo = (String)map.get("hinNo");
	}
}


String date = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");
String adno = "";
String hinno="";

%>
<div class="titleBg">
<h2>Ward Report</h2>
</div>
<div class="clear"></div>
<form name="dischargeSummaryReportForm" action="" method="post">


<h4>Enter Details</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>Employee No. <span>*</span></label>
<input type="text" id="serviceNo" name="serviceNo" value="" MAXLENGTH="30"
validate="Service No.,String,yes" onblur="getPatientName(this.value)"/> 
<div id="hinDiv"><label> Patient <span>*</span></label> <input type="text"
	name="<%=HIN_NO%>" value="" MAXLENGTH="50"
	onchange="getAdNo(this.value);" /></div>

<!--<div id=patient>
<label>Patient Name.</label> 
<input type="text" id="patientName" name="patientName" value="" MAXLENGTH="30" /> 

</div>

--><div id=adDiv>
<label>A&D No. <span>*</span></label> 
<input type="text" id="adNo" name="adNo" value="" MAXLENGTH="30" /> 
</div>
		<div class="clear"></div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<!-- <input type="button" name="Submit" id="addbutton" onClick="submitForm('dischargeSummaryReportForm','discharge?method=showDischargeSummaryReport&flag=o');" value="Ok" class="button" accesskey="a" /> --> 
<input type="button" name="Submit" id="addbutton" onClick="submitForm('dischargeSummaryReportForm','discharge?method=showDischargeSummaryReport&flag=d');" value="Declaration Form" class="button" accesskey="a" />
<input type="button" name="Submit" id="addbutton" onClick="submitForm('dischargeSummaryReportForm','discharge?method=showDischargeSummaryReport&flag=p');" value="Patient Prescription" class="button" accesskey="a" />
<input type="button" name="Submit" id="addbutton" onClick="submitForm('dischargeSummaryReportForm','discharge?method=showDischargeSummaryReport&flag=i');" value="Patient Investigation" class="button" accesskey="a" />
<input type="button" name="Submit" id="addbutton" onClick="submitForm('dischargeSummaryReportForm','discharge?method=showDischargeSummaryReport&flag=l');" value="Linen Form" class="button" accesskey="a" />
<input type="button" name="Submit" id="addbutton" onClick="submitForm('dischargeSummaryReportForm','discharge?method=showClinicalSheetReportIPD');" value="Clinical Sheet" class="button" accesskey="a" />
<input type="button" name="Submit" 	id="addbutton"	onClick="submitForm('dischargeSummaryReportForm','ipd?method=showIntakeOutputChartReportIPD&reportType=summary');"	value="Intake Output Chart" class="button" accesskey="a" />
<input type="button" name="Submit" 	id="addbutton"	onClick="submitForm('dischargeSummaryReportForm','discharge?method=showDischargeSummaryReport&flag=s');"	value="Surgery Requision" class="button" accesskey="a" />
<input type="button" name="Submit" 	id="addbutton"	onClick="submitForm('dischargeSummaryReportForm','discharge?method=showDischargeSummaryReport&flag=proce');"	value="Procedure Advice" class="button" accesskey="a" />
<input type="button" name="Submit" 	id="addbutton"	onClick="submitForm('dischargeSummaryReportForm','discharge?method=showDischargeSummaryReport&flag=c');"	value="Case Sheet" class="button" accesskey="a" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" />
<input type="hidden" name="SearchFlag" value="false" /> 
<label id="errorMsg" style="color: red;" class="biglabel"></label> 
<script>
	<% if (status.equalsIgnoreCase("nodata")) { %>
			 document.dischargeSummaryReportForm.<%=HIN_NO%>.value='<%=hinNo%>';
			 alert('No Report Data Found');
			 submitProtoAjax('dischargeSummaryReportForm','discharge?method=getAdmissionNumberList');  	
   	<% } %>
</script>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<script type="text/javascript">

		function getPatientName(val)
		{
			//submitProtoAjaxWithDivName('dischargeSummaryReportForm','/hms/hms/ipd?method=showPatientName&paramName='+val+'&flag=s','patient');
			submitProtoAjaxWithDivName('dischargeSummaryReportForm','/hms/hms/ipd?method=showPatientHinNo&paramName='+val,'hinDiv');
		}
				

		function getAdNo(val,discharge)
		{
			


			submitProtoAjaxWithDivName('dischargeSummaryReportForm','/hms/hms/ipd?method=showPatientName&paramName='+val+'&flag=w&discharge=yes','adDiv');

		}

	
				
		</script>
</form>
