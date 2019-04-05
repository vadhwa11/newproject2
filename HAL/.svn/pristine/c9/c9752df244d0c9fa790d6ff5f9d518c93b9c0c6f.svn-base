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

<%@ page import="static jkt.hms.util.RequestConstants.HIN_ID"%>

<%@page import="jkt.hms.masters.business.Patient"%>

<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%><script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>


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
		List<Object[]> hinNoList = new ArrayList<Object[]>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("hinNoList") != null)
			hinNoList =(List)map.get("hinNoList");
		
		Box box= HMSUtil.getBox(request);
		String url = "";
		if(!box.getString("flag").equals("unwillingness") && !box.getString("flag").equals("registration") && !box.getString("flag").equals("invRequisition")){
			url = "if(validateMetaCharacters(this.value)){getPatientDetailsForDMO('/hms/hms/registration?method=getPatientDetailsForDMO&hinId='+this.value+'&flag="+box.getString("flag")+"')}";
		}else if(box.getString("flag").equals("invRequisition")){
			url = "if(validateMetaCharacters(this.value)){submitForm('investigationWaitList','/hms/hms/lab?method=showInvestigationRequisitionJsp&hinId='+this.value)}";
		}
		
  	   
%>
	<select id="hinNo" name="<%=HIN_ID%>" validate="HIN,metachar,yes"  onchange="<%=url %>">
		<option value="">Select</option>
		<% 
	     	
	     	if (hinNoList!=null && hinNoList.size() > 0 ) 
	     	{ 
	     		for (Object[] obj : hinNoList) {
				%>
		<option value="<%=obj[0]%>"><%=(String)obj[2]+" "+(obj[3]!=null?(String)obj[3]:"")+" "+(obj[4]!=null?(String)obj[4]:"")+" ("+(obj[5]!=null?(String)obj[5]:"")+")"%></option>
		<% } 
			} 
	     	
	     	 %>
	</select>