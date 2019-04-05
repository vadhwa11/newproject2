<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * visitByHin.jsp
 * Purpose of the JSP -  This is for Visit By HIN.
 * @author  Ritu
 * Create Date: 08th Feb,2008
 * Revision Date:
 * Revision By:
 * @version 1.22
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasComplaint"%>

<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.MasCaseType"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>

<%@page import="java.util.Properties"%>
<%@page import="java.net.URL"%>



<%--For AutoComplete Through Ajax--%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MasTherapyType"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.PhysiotherapyDetails"%>

<%@page import="jkt.hms.masters.business.PhysioRequisitionDetail"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>

<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%><script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
	<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
	
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>


<script>
	<%

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}

	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>


<%

	Map<String, Object> map = new HashMap<String, Object>();

	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}

//	List<Visit> visitList = new ArrayList<Visit>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentTimeWithoutSecond();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	List<Object[]> patientPresriptionDetailList = new ArrayList<Object[]>();
	
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("patientPresriptionDetailList") != null){
		patientPresriptionDetailList = (List)map.get("patientPresriptionDetailList");	
	}
String message = "";
if(map.get("message")!=null){
	message = (String)map.get("message");
}
%>



<form name="ct" method="post">
<div class="clear"></div>
<h4><%=message %></h4>
<div class="clear"></div>
<div class="titleBg">
<h2>Continuous Treatment</h2>
</div>
<div class="clear"></div>

<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block"><label>Service No. <span>*</span></label> <input
	type="text" name="<%=SERVICE_NO %>" id="serviceNo" value=""
	validate="Service No.,metachar,yes"
	onblur="if(this.value!=''){submitProtoAjaxWithDivName('ct','/hms/hms/opd?method=getPatientDetailsForCT','hinDiv');}" />
<label>HIN <span>*</span></label>
<div id="hinDiv"><input type="text" name="<%=HIN_ID %>" id="hinId"
	value="" /></div>
<div id="testDiv"></div>

</div>



<div class="clear"></div>

<div class="division"></div>
<div class="clear"></div>



<div id="edited"></div>
<input type="button" name="submitForDisable" id="submitForDisable"
	value="Save" class="button"
	onClick="submitForm('ct','/hms/hms/opd?method=saveCtDetails');" />
<input type="reset" name="Reset" value="Reset" class="button"
	accesskey="r" /> 

<div class="clear"></div>
<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=currentDate%></label>

<label>Changed Time</label> <label class="value"><%=time%></label> <input
	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=LAST_CHANGED_DATE %>" value="<%=currentDate%>" />
<input type="hidden" name="<%=LAST_CHANGED_TIME %>" value="<%=time%>" />

</div>

<div id="statusMessage" class="messagelabel">
<div class="clear"></div>
</div>
</form>
