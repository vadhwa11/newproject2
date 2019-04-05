<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : responseForHinNoWard.jsp 
	 * Tables Used         : inpatient ,patient
	 * Description         : This JSP is called thru AJAX to populate Hin Number Combo in ip
	 * @author  Create Date: 23.03.2012    
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Inpatient"%>
<script type="text/javascript" language="javascript"
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
		//List<Object> patientList = new ArrayList<Object>();
		List<Object[]> patientList = new ArrayList<Object[]>();
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("patientList") != null){
			patientList =(List)map.get("patientList");
		}
		String flag="";
		String url = "";
		String formName = "";
		if (map.get("flag") != null){
			flag =(String)map.get("flag");
		}
		
%>
<div id="hinDiv">
<%if(flag.equals("s")){ %>
<label>Patient <span>*</span></label> 
<select name="<%=HIN_ID%>" id="hinId" onblur="setHinNo();" onchange="getAdNo(this.value);">
	<option value="">Select</option>
	<% 
	     	
	     	if (patientList!=null && patientList.size() > 0 ) 
	     	{ 
	     		for (Object[] obj : patientList) {
				%>
	<option value="<%=obj[0]%>"><%=(String)obj[1]+"-"+ (String)obj[2] +" "
	
		        + ((String)obj[3]!=null ? (String)obj[3]:"") +" "+ ((String)obj[4]!=null ? (String)obj[4]:"") +"("+(String)obj[5]+")" %>
		       </option>
	<% } 
	     		
			} 
	     	
			 %>
	
</select>
<%}else{ %>
<label>Patient <span>*</span></label> 
<select name="<%=HIN_ID%>" id="hinId"	validate="Hin,String,yes"	MAXLENGTH="50" onblur="setHinNo();" onchange="getAdNo(this.value);">
	<option value="">Select</option>
	<% 
	     	
	     	if (patientList!=null && patientList.size() > 0 ) 
	     	{ 
	     		for (Object[] obj : patientList) {
				%>
	<option value="<%=obj[0]%>"><%=(String)obj[1]+"-"+ (String)obj[2] +" "
	
    + ((String)obj[3]!=null ? (String)obj[3]:"") +" "+ ((String)obj[4]!=null ? (String)obj[4]:"")+"("+(String)obj[5]+")" %>
	                                           
	</option>
	<% } 
			} 
	     	 
			 %>
</select>
<%} %>
</div>