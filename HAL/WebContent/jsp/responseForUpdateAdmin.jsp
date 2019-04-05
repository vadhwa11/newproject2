<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : responseForAdmissionNo.jsp 
	 * Tables Used         : inpatient ,patient
	 * Description         : This JSP is called thru AJAX to populate Admission Number Combo in ipAdmissionReprt.jsp
	 * @author  Create Date: 18.02.2008    Name: Ritu  
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Inpatient"%>


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
		List<Object> inpatientList = new ArrayList<Object>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("inpatientList") != null)
			inpatientList =(List)map.get("inpatientList");
  	    
		
%>
<div id="testDiv"><label class="bodytextB">Admission No.:
</label> <select name="<%=AD_NO%>" validate="Admission No,string,yes">
	<option value="">Select</option>
	<% 
	     	try{
	     		System.out.println("admissionNoList  "+inpatientList.size());
	     	if (inpatientList!=null && inpatientList.size() > 0 ) 
	     	{ 
	     		for (Iterator iterator = inpatientList.iterator(); iterator.hasNext();) {
	    			Object[] object = (Object[]) iterator.next();
					Inpatient inpatient = (Inpatient)object[0];
					if(inpatient.getAdStatus().equals("A") || inpatient.getAdStatus().equals("W")){
			%>
	<option value="<%=inpatient.getAdNo()%>"><%=inpatient.getAdNo()%>
	</option>

	<%}}}
	     	}catch(Exception e){
	     		e.printStackTrace();
	     	}
	     	%>
</select></div>