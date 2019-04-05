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

<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.Visit"%><script type="text/javascript" language="javascript"
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
		List<Visit> visitList = new ArrayList<Visit>();

		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}

		if (map.get("visitList") != null)
			visitList =(List)map.get("visitList");
		//System.out.println("visitList in resposdffnse new jsp :"+visitList.size());
		 int visitId = 0;
%>
<div id="tessstDiv">


<%
	     if (visitList!=null && visitList.size() > 0 )
	     	{
	    	 %> <select name="<%=VISIT_ID %>" id="visitNoReport" 	validate="Visit No.,string,yes" onchange="populateSpecialityWiseButton(this.value);">
	<option value="">Select</option>
	<%
        String department="";
	    String visitdate="";
	   int opdPatientDetailsId =0;
	     		for (Visit list : visitList) {
	     			if(list.getDepartment()!=null)
	     			{
	     				department=list.getDepartment().getDepartmentName();
	     			}
	     			if(list.getVisitDate()!=null)
	     			{
	     				visitdate=HMSUtil.changeDateToddMMyyyy(list.getVisitDate());
	     			}
	     			if(list.getId() != 0){
	     				visitId = list.getId();
	     			}
	     			//System.out.println("visitId===="+visitId);
	     			if(list.getOpdPatientDetails().size()>0)
	     			opdPatientDetailsId = ((OpdPatientDetails)(list.getOpdPatientDetails().toArray()[0])).getId();
	   		%>
	<option value="<%=list.getId()%>@<%=opdPatientDetailsId%>@<%=list.getDepartment().getDepartmentCode()%>"><%=list.getVisitNo()+ " (" + visitdate+"  -  "+ department+")" %>
	</option>
	<% }
	     	 %>
</select> <%} else{
		     	  %> <input type="text" name="<%=VISIT_ID %>" value=""
	MAXLENGTH="6" readonly="readonly" validate="Visit No.,string,yes" /> <%} %>
	
	
</div>

<script>
function getVisitId(visitId){

	//alert("sdfds");
 <%
	 for (Visit listA : visitList) {
 %>	
if(<%=listA.getId()%> == visitId){
	alert(visitId);
	document.getElementById('visitId').value = visitId;
}
 <%}%>
}
</script>



