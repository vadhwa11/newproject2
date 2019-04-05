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
		List<Object> hinNoList = new ArrayList<Object>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("hinNoList") != null)
			hinNoList =(List)map.get("hinNoList");
		System.out.println("hinNoList  Size in  DS "+hinNoList.size());
		String url = "";
		if (map.get("fatalCase") != null){
			url = "mis?method=getAdmissionNoList&fatalCase=yes";
		}else if(map.get("birthJsp") != null){
			url = "mis?method=getMotherAdmissionNumberList&flag=admission";
		}else if(map.get("deathJsp") != null){
			url = "mis?method=getExpiredAdmissionNumberList&flag=admission";
		}
		else if(map.get("onlyReport") != null){
			url = "mis?method=getAdmissionNoList&onlyReport=yes&flag=admission";
		}
		else{
			url = "mis?method=getAdmissionNoList&flag=admission";
		}
		
%>
<div id="hinDiv"><label><span>*</span> HIN </label> <select
	name="<%=HIN_NO%>" validate="Hin,,yes"
	onchange="submitProtoAjax('fatalDocumentPanchnamaReport','<%=url%>')">
	<option value="">Select</option>
	<% 
	     	
	     	if (hinNoList!=null && hinNoList.size() > 0 ) 
	     	{ 
	     		for (Iterator iterator = hinNoList.iterator(); iterator.hasNext();) {
	    				Patient patient = (Patient)iterator.next();
	    				System.out.println("fatalCase   "+map.get("fatalCase"));
	    				if (map.get("fatalCase") != null){
							if(patient.getRelation().getRelationName().equals("Self") && (patient.getPatientStatus().equals("Expired"))){
				%>
	<option value="<%=patient.getHinNo()%>"><%=patient.getHinNo()%>
	</option>
	<% 			} 
						}
	    				else{
	    					
	    						%>
	<option value="<%=patient.getId()%>"><%=patient.getHinNo()%></option>
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