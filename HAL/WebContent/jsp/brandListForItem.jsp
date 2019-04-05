<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : responseForAdmissionNo.jsp 
	 * Tables Used         : inpatient ,patient
	 * Description         : This JSP is called thru AJAX to populate Admission Number Combo in ipAdmissionReprt.jsp
	 * @author  Create Date: 22.04.2008    Name: Dipali
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Patient"%>

<%@page import="jkt.hms.masters.business.MasStoreBrand"%>

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
		List<Patient>brandList=new ArrayList<Patient>();
	
		boolean hinNoExist=false;
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		if(map.get("brandList")!=null){
			brandList=(List<Patient>)map.get("brandList");
		}
		
		if(map.get("hinNoExist")!=null )
			hinNoExist=(Boolean)map.get("hinNoExist");
		
		
		
%>


<label class="bodytextB"><font id="error">*</font>Brand Name:</label>

<select name="<%= BRAND_ID %>" size="4" multiple="4"
	validate="Brand Name,string,no" tabindex=1 id="item_master_brand">
	<%
			 			if (brandList!=null && brandList.size() > 0 ) 
	     				{ 
	     					for (Iterator iterator = brandList.iterator(); iterator.hasNext();) {
	    					MasStoreBrand masStoreBrand=(MasStoreBrand)iterator.next();
	    		%>

	<option value="<%=masStoreBrand.getId ()%>"><%=masStoreBrand.getBrandName()%></option>

	<%		}
			 		}
			 			

			 	
			 %>
</select>
