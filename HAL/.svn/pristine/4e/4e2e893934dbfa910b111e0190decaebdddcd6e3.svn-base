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

<%@page import="jkt.hms.masters.business.*"%>
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
		List<String> hinNoList = new ArrayList<String>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("hinNoList") != null)
			hinNoList =(List)map.get("hinNoList");
  	    
		String url = "";
		
		url = "ot?method=getPreAnaesthesiaProcedureDetails&flag=yearlySerialNo";
		
%>
<div id="hinDiv"><label class="bodytextB">Hin No: </label> <select
	name="<%=HIN_NO%>" validate="Hin,String,yes"
	onchange="submitProtoAjaxWithDivName('search','<%=url %>','testDiv')">
	<option value="">Select</option>
	<% 
	     	
	     	if (hinNoList!=null && hinNoList.size() > 0 ) 
	     	{ int count=0;
	     		for (int i=0; i<hinNoList.size();i++) {
	     			//OtPreAnaesthesiaProcNotesMain otPreAnaesthesiaProcNotesMain = (OtPreAnaesthesiaProcNotesMain)iterator.next();
				%>
	<option value="<%=hinNoList.get(i)%>"><%=hinNoList.get(i)%></option>
	<% count++;} 
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