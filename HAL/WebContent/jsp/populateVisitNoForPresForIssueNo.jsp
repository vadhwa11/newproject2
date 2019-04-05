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

<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%><script type="text/javascript" language="javascript"
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
		List<PatientPrescriptionHeader> visitList = new ArrayList<PatientPrescriptionHeader>();

		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}

		if (map.get("visitList") != null)
			visitList =(List)map.get("visitList");
		//System.out.println("visitList in resposdffnse new jsp :"+visitList.size());
		 int visitId = 0;
%>
<div id="testDiv">
<%
	     if (visitList!=null && visitList.size() > 0 )
	     	{
	     %> 
	<select name="number" id="visitNoReport" 	>
	<option value="">Select</option>
	<%
        String department="";
	    String visitdate="";
	   
	     		for (PatientPrescriptionHeader patientPrescriptionHeader : visitList) {
	     			if(patientPrescriptionHeader.getVisit().getDepartment()!=null)
	     			{
	     				department =patientPrescriptionHeader.getVisit().getDepartment().getDepartmentName();
	     			}
	     			if(patientPrescriptionHeader.getVisit().getVisitDate()!=null)
	     			{
	     				visitdate=HMSUtil.changeDateToddMMyyyy(patientPrescriptionHeader.getVisit().getVisitDate());
	     			}
	     			if(patientPrescriptionHeader.getVisit().getId() != 0){
	     				visitId = patientPrescriptionHeader.getVisit().getId();
	     			}
	     			//System.out.println("visitId===="+visitId);
	     			
	   		%>
	<option value="<%=patientPrescriptionHeader.getDispensaryIssueNo()%>"><%=patientPrescriptionHeader.getDispensaryIssueNo()+"  -  "+ department+"("+visitdate+")" %>
	</option>
	<% }
	     	 %>
</select> <%} else{
		     	  %> <input type="text" name="<%=VISIT_ID %>" value="" MAXLENGTH="6" readonly="readonly" validate="Visit No,String,yes" /> <%} %>
	
	
</div>




