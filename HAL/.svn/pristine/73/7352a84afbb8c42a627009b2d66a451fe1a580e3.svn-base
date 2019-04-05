<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : responseForHinNo.jsp 
	 * Tables Used         : inpatient ,patient
	 * Description         : This JSP is called thru AJAX to populate Hin Number Combo in ipAdmissionReprt.jsp
	 *   Name: Shailesh
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
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
		int visitId =0 ;
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
		String flag = "";
		String url = "";
		List<Visit> visitNoList = new ArrayList<Visit>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("visitNoList") != null)
			visitNoList =(List)map.get("visitNoList");
		
 	 	
	 	int previousVisitNo = 0;
		String maxSequenceNo= "";
%>
<div id="testDiv">
<%
	     if (visitNoList!=null && visitNoList.size() > 0 ) 
	     	{ 
	    	
			%> <select id="vId" name="<%=VISIT_NUMBER %>"
	validate="Visit No,string,no"
	onchange="submitForm('search','opd?method=getPatientOpdDetails');">
	<option value="0">select</option>

	<%for(Visit visit:visitNoList){%>
	<option value="<%=visit.getId() %>"><%=visit.getVisitNo()+ " (" + HMSUtil.changeDateToddMMyyyy(visit.getVisitDate())+"  -  "+ visit.getDepartment().getDepartmentName() +")" %>
	</option>


	<% }%>
</select> <% }else{%> <input type="text" id="visitId" name="<%=VISIT_NUMBER %>"
	value=""
	ochange="submitForm('search','opd?method=getPatientOpdDetails');"
	validate="Visit No ,String,yes" readonly="readonly" /> <script>
  		    	alert("Visit no. not exist for this Patient")
  		    	</script> <% }%>
</div>