<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : responseForOpdHinNo.jsp 
	 * Tables Used         : inpatient ,patient
	 * Description         : This JSP is called thru AJAX to populate Hin Number Combo in patientPrescriptionReport.jsp
	 * @author  Create Date: 25.08.2008    Name: Mansi  
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.OtPostAnaesthesiaProcedure"%>
<%@page import="jkt.hms.masters.business.OtHumanBodyDisposal"%>
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
		List<OtHumanBodyDisposal> otHumanBodyDisposalList = new ArrayList<OtHumanBodyDisposal>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("otHumanBodyDisposalList") != null)
			otHumanBodyDisposalList =(List)map.get("otHumanBodyDisposalList");
  	    
		
		
%>
<div id="entryDiv"><label class="bodytextB">Entry No: </label> <select
	name="entryNo" validate="Entry,String,yes">
	<option value="">Select</option>
	<% 
	     	
	     	if (otHumanBodyDisposalList!=null && otHumanBodyDisposalList.size() > 0 ) 
	     	{ 
	     		for (Iterator iterator = otHumanBodyDisposalList.iterator(); iterator.hasNext();) {
	    				OtHumanBodyDisposal otHumanBodyDisposal = (OtHumanBodyDisposal)iterator.next();
				%>
	<option value="<%=otHumanBodyDisposal.getEntryNo()%>"><%=otHumanBodyDisposal.getEntryNo()%>
	</option>
	<% } 
			} 
	     	 else
	     	 {
			 %>
	<script>
			 	document.getElementById('errorMsg').innerHTML=' No Record Found!!';
			 </script>
	<%
			  } 
	     	 %>
</select></div>