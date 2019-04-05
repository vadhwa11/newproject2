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

<%@page import="jkt.hms.masters.business.Patient"%>

<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%><script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>



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
		List<Object> hinNoList = new ArrayList<Object>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("hinNoList") != null)
			hinNoList =(List)map.get("hinNoList");
		
  	    String flag = "";
  	  	
  	 	 if (map.get("flag") != null)
			flag =(String)map.get("flag");
  	 	 
  	 	 String url = "";
  	 	 if(flag.equals("registration")){
  	 		 url = "stores?method=getBarcodeNumber";
  	 	 }else if(flag.equals("visit")){
  	 		url = "registration?method=getVisitNo";
  	 	 }else if(flag.equals("admission")){
  	 		url = "registration?method=getAdmissionNoList&flag=admission";
  	 	 }else if(flag.equals("billing")){
  	 		url = "billing?method=getPatientDetails";
  	 	 }else if(flag.equals("ipd")){
  	 		url = "ipd?method=getPatientName";
  	 	 }
%>
<div id="hinDiv"><label>Batch No. <span>*</span></label> <% 
			if(flag.equals("billing")){
			%> <select name="<%=HIN_NO%>" validate="Batch No.,string,yes" tabindex=""
	onchange="submitBarcodeAjax('barcodeGerator','<%=url %>')">
	<%}else{ %>
	<select name="<%=HIN_NO%>" validate="Batch No.,string,yes" tabindex="1"
		onchange="submitBarcodeAjax('barcodeGerator','<%=url %>')">
		<%} %>
		<option value="">Select</option>
		<% 
	     	
	     	if (hinNoList!=null && hinNoList.size() > 0 ) 
	     	{ 
	     		for (Iterator iterator = hinNoList.iterator(); iterator.hasNext();) {
	    				//Patient patient = (Patient)iterator.next();
	    				String strb = (String)iterator.next();
				%>
		<option value="<%=strb%>"><%=strb%>
		</option>
		<% } 
			} 
	     	
	     	 %>
	</select></div>