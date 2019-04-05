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
		
		if (map.get("hinNo") != null) {
			hinNo =  ""+map.get("hinNo");
		}
		if (map.get("andNo") != null) {
			andNo =  ""+map.get("andNo");
		}
		
		 
%>

<div class="titleBg"><h2 >Prescription Slip</h2></div>
<div class="clear"></div>
<form name="ipPrescriptionReport" target=_blank action=""	method="post">
<div class="Block">

<label>Service No. <span>*</span></label>
<input type="text" id="serviceNo" name="serviceNo" value="" MAXLENGTH="30" validate="Service No.,String,yes"
 onblur="getPatientName(this.value)"/>
<div id="hinDiv"><label> HIN <span>*</span></label> <input type="text" validate="Hin,String,yes"
	name="<%=HIN_NO%>" value="" MAXLENGTH="50"
	onchange="getAdNo(this.value);" /></div>
 
<!--<div id=patient>
<label>Patient Name.</label> 
<input type="text" id="patientName" name="patientName" value="" MAXLENGTH="30" /> 

</div>

--><div id=adDiv>
<label>A&D No. <span>*</span></label> 
<input type="text" id="adNo" name="adNo" validate="A&D No.,String,yes"
value="" MAXLENGTH="30" /> 
</div>

<div class="clear"></div>
</div>
<div class="division"></div>
<input type="button" name="Submit" 	id="addbutton"	onClick="submitForm('ipPrescriptionReport','ipd?method=printIPPrescriptionInvestReport&flag=prescription');"	value="Submit" class="button" accesskey="a" />
<input type="reset"	name="Reset" value="Cancel" class="button"	onclick="location.reload();" accesskey="r" />
<label id="errorMsg" style="display: none;"></label>
<div class="clear"></div>
<div class="division"></div>
<script type="text/javascript">

function getPatientName(val)
{
	//alert(val)
	//submitProtoAjaxWithDivName('ipPrescriptionReport','/hms/hms/ipd?method=showPatientName&paramName='+val+'&flag=s','patient');
	submitProtoAjaxWithDivName('ipPrescriptionReport','/hms/hms/ipd?method=showPatientHinNo&paramName='+val,'hinDiv');

}
		

function getAdNo(val)
{
	submitProtoAjaxWithDivName('ipPrescriptionReport','/hms/hms/ipd?method=showPatientName&paramName='+val+'&flag=p','adDiv');
}


		
</script>
</form>

