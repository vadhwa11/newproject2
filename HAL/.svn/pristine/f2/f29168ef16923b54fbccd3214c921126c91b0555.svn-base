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
		List<Visit> visitNoList = new ArrayList<Visit>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("visitNoList") != null)
			visitNoList =(List)map.get("visitNoList");
		
%>
<div id="testDiv">
<%
	     if (visitNoList!=null && visitNoList.size() > 0 ) 
	     	{ 
	     %> <select name="<%=VISIT_NUMBER %>" id="visitNoReport"
	validate="Visit No,string,yes">
	<option value="">Select</option>
	<% 
	     	String visitdate="";
	        String department="";
	     		for (Visit visit : visitNoList) {
	     			if(visit.getVisitDate()!=null)
	     			{
	     				visitdate=HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
	     				
	     			}
	     			if(visit.getDepartment()!=null)
	     			{
	     				department=visit.getDepartment().getDepartmentName();
	     				
	     			}
	   		%>
	<option value="<%=visit.getVisitNo()%>"><%=visit.getVisitNo()+ " (" +visitdate +"  -  "+ department +")" %>
	</option>
	<% } 
	     	 %>
</select> <%} else{
		     	  %> <input type="text" name="<%=VISIT_NUMBER %>" value=""
	MAXLENGTH="6" readonly="readonly" validate="Visit No,String,yes" /> <%} %>
</div>