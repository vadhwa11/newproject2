<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript">
function openPopupWindow()
{
	 var url="/hms/hms/ipd?method=showPatientSearchJsp";
	 newwindow=window.open(url,'name',"height=600,width=1010,status=1,scrollbars=1,resizable=1");
}

function jsSetPatientData(serviceNo)
{
	document.intakeOutputChartReportForm.<%=SERVICE_NO%>.value=serviceNo;
	document.intakeOutputChartReportForm.<%=SERVICE_NO%>.focus();
}
function checkHinNo(hinNo){
if(hinNo ==""){
	return false;
}else{
	return true
}
}
</script>


<%
	Map map = new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	Set patientSet = null;
	String hinNo ="";
	String andNo ="";
	
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
	}
	
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currenDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
	if (map.get("patientSet") != null)
		patientSet = (Set) map.get("patientSet");
	List<Object> list = null;
	Date toDate  = null;
	Date fromDate=null;
	if (map.get("toDate") != null) {
			toDate = (Date) map.get("toDate");
			session.setAttribute("toDate", toDate);
		}
		if (map.get("fromDate") != null) {
			fromDate = (Date) map.get("fromDate");
			session.setAttribute("fromDate", fromDate);
		}
		
		if (map.get("hinNo") != null) {
			hinNo =  ""+map.get("hinNo");
		}
		if (map.get("andNo") != null) {
			andNo =  ""+map.get("andNo");
		}
		//Set<Inpatient> inpatientSet=new HashSet<Inpatient>();
		List<Inpatient>inpatientList=null;
		if (map.get("inpatientSet") != null) {
			inpatientList = (List<Inpatient>)map.get("inpatientSet");
		}
		 
%>

<div class="titleBg"><h2 >Intake/Output Chart</h2></div>
<div class="clear"></div>
<form name="intakeOutputChartReportForm" target=_blank action=""	method="post">
<div class="Block">
	<%--	<label>From Date</label>
		<input type="text"	id="fromDateId" name="<%=FROM_DATE %>" value="<%=currenDate %>"	class="date" readonly="readonly" MAXLENGTH="30" />
		<img  src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Pick a date" class="calender"	onClick="setdate('<%=currenDate %>',document.intakeOutputChartReportForm.<%=FROM_DATE%>,event)" />
		<label>To Date</label>
		<input type="text" id="toDateId"	name="<%=TO_DATE %>" value="<%=currenDate %>" class="date"	readonly="readonly" MAXLENGTH="30" /></td>
		<img src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('<%=currenDate %>',document.intakeOutputChartReportForm.<%=TO_DATE%>,event)" />
				
				
					<div class="clear"></div>
					
					
		<label>From Time</label>
		<input type="text" name="<%=FROM_TIME%>" value="8:00" MAXLENGTH="30" class="auto" size="17" />
		<label class="smallauto">AM</label>
	
		<label>To Time</label>
		<input type="text"	name="<%=TO_TIME%>" value="8:00" MAXLENGTH="30" class="auto" size="17" />
		<label class="smallauto">AM</label>
	
					
					<div class="clear"></div>
					
	 --%>
	<label>Service No. <span>*</span></label>
<input type="text" id="serviceNo" name="serviceNo" value="" MAXLENGTH="30" validate="Service No.,String,yes" onblur="getPatientName(this.value);"/> 
<div id="hinDiv"><label> HIN <span>*</span></label> <input type="text"
	name="<%=HIN_NO%>" value="" MAXLENGTH="50" validate="Hin.,String,yes"
	onchange="getAdNo(this.value);" /></div>
<!--<div id=patient>
<label>Patient Name.</label> 
<input type="text" id="patientName" name="patientName" value="" MAXLENGTH="30" /> 

</div>

--><div id=adDiv>
<label>A&D No. <span>*</span></label> 
<input type="text" id="adNo" name="adNo" value="" MAXLENGTH="30" validate="A&D No.,String,yes"/> 
</div>
<label>Summary</label>
<input type="radio" name="reportType" value="summary" class="radio" checked="checked"/>
<label>Detail</label>
<input type="radio" name="reportType" value="detail"class="radio"/>
		<div class="clear"></div>
		</div>
		<div class="division"></div>
		<input type="button" name="Submit" 	id="addbutton"	onClick="submitForm('intakeOutputChartReportForm','ipd?method=showIntakeOutputChartReport');"	value="Submit" class="button" accesskey="a" />
		<input type="reset"	name="Reset" value="Cancel" class="button"	onclick="location.reload();" accesskey="r" />
		<label id="errorMsg" style="display: none;"></label>
		<div class="clear"></div>
		<div class="division"></div>
		<script type="text/javascript">

		function getPatientName(val)
		{
			
			//submitProtoAjaxWithDivName('intakeOutputChartReportForm','/hms/hms/ipd?method=showPatientName&paramName='+val+'&flag=s','patient');
			submitProtoAjaxWithDivName('intakeOutputChartReportForm','/hms/hms/ipd?method=showPatientHinNo&paramName='+val,'hinDiv');
		}
				

		function getAdNo(val)
		{
			


			submitProtoAjaxWithDivName('intakeOutputChartReportForm','/hms/hms/ipd?method=showPatientName&paramName='+val+'&flag=p','adDiv');

		}

	
				
		</script>
</form>

