<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : responseForHinNo.jsp 
	 * Tables Used         : inpatient ,patient
	 * Description         : This JSP is called thru AJAX to populate Hin Number Combo in ipAdmissionReprt.jsp
	 *   Name: Dipali
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
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
		List<DgOrderhd> orderNoList = new ArrayList<DgOrderhd>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("orderNoList") != null)
			orderNoList =(List)map.get("orderNoList");
		
 	 	if (map.get("flag") != null)
		 flag =(String)map.get("flag");
	
	 	 if(flag.equals("lab")){
	 		 url = "lab?method=getPatientDetails";
	 	 }
	 	int previousVisitNo = 0;
		String maxSequenceNo= "";
%>
<div id="testDiv">
<%
	     if (orderNoList!=null && orderNoList.size() > 0 ) 
	     	{ 
	    	
				if(flag.equals("lab")){
				%> <select id="vId" name="<%=ORDER_NO %>"
	validate="Visit No,string,no"
	onblur="submitForm('search','lab?method=getPatientDetailsForUpdate');">
	<%}else{%>
	<select id="oId" name="<%=ORDER_NO %>" validate="Visit No,string,no"
		onblur="submitForm('search','lab?method=getPatientDetailsForUpdate');">
		<%} %>
		<%for(DgOrderhd dgOrderhd : orderNoList){ %>
		<option value="<%=dgOrderhd.getId() %>"><%=dgOrderhd.getOrderNo() %>
		</option>
		<%} %>
	</select>
	<input type="hidden" name="visitId" value="<%=visitId%>" />
	<script>
	   	document.getElementById("vId").focus();
	   </script>
	<% }else{ %>
	<input type="text" id="visitId" name="<%=VISIT_NUMBER %>" value=""
		onchange="submitForm('search','lab?method=getPatientDetails');"
		validate="Visit No ,String,yes" readonly="readonly" />
	<script>
  		    	alert("Order no. not exist for this Patient")
  		    	</script>
	<% }%>
</div>