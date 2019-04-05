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
<%@page import="jkt.hms.masters.business.DgSampleCollectionHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
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
		List<Object> orderNoList = new ArrayList<Object>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("orderNoList") != null)
			orderNoList =(List)map.get("orderNoList");
  	    System.out.println("orderNoList--->"+orderNoList.size());
  	    
		String url = "";
		
		url = "lab?method=getLabOrderReportList&flag=result";

		
%>
<div id="testDiv"><label>Order No.</label> <select
	name="<%=ORDER_NO%>" validate="Order No,string,yes"
	onchange="submitProtoAjaxWithDivName('search','<%=url %>','resultDiv')">
	<option value="">Select</option>
	<% 
	     	if (orderNoList!=null && orderNoList.size() > 0 ) 
	     	{ 
	     		for (Iterator iterator = orderNoList.iterator(); iterator.hasNext();) {
					DgOrderhd dgOrderhd = (DgOrderhd)iterator.next();
					if(dgOrderhd.getOrderStatus().equals("A")){
				%>
	<option value="<%=dgOrderhd.getOrderNo()%>"><%=dgOrderhd.getOrderNo()%></option>

	<% 
  		     			}
	     		}
			} 
	     	 else
	     	 {
			 %>
	<script>
			 	document.getElementById('errorMsg').innerHTML='* No Record Found!!';
			 </script>
	<%
			  } 
	     	 %>
</select></div>