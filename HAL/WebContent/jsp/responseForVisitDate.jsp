<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : responseForHinNo.jsp 
	 * Tables Used         : inpatient ,patient
	 * Description         : This JSP is called thru AJAX to populate Hin Number Combo in ipAdmissionReprt.jsp
	 * @author  Create Date: 18.02.2008    Name: Ritu  
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />


<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
	</script>


<%	
		Map map = new HashMap();
		List<Visit> visitDateList = new ArrayList<Visit>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("visitDateList") != null)
			visitDateList =(List)map.get("visitDateList");
  	    
		
%>
<div id="testDiv"><label class="bodytextB">From Date: </label> <select
	name="<%=FROM_DATE%>" validate="From Date,string,yes"
	class="select_adt">
	<option value="">Select</option>
	<% 
	     	
	     	if (visitDateList!=null && visitDateList.size() > 0 ) 
	     	{ 
	     		for (Visit visit : visitDateList){
				%>
	<option
		value="<%=HMSUtil.convertDateToStringWithoutTime(visit.getVisitDate())%>"><%=HMSUtil.convertDateToStringWithoutTime(visit.getVisitDate())%>
	</option>
	<% } 
			} 
	     	 %>
</select> <label class="bodytextB">To Date: </label> <select name="<%=TO_DATE%>"
	validate="To Date,string,yes" class="select_adt"
	onchange="getDiagnosisForReport('medicalCertificateReport','adt?method=getDiagnosis')">
	<option value="">Select</option>
	<% 
	     	
	     	if (visitDateList!=null && visitDateList.size() > 0 ) 
	     	{ 
	     		for (Visit visit : visitDateList){
				%>
	<option
		value="<%=HMSUtil.convertDateToStringWithoutTime(visit.getVisitDate())%>"><%=HMSUtil.convertDateToStringWithoutTime(visit.getVisitDate())%>
	</option>
	<% } 
			} 
	     	 %>
</select></div>