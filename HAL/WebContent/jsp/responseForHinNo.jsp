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
  	    
		String url = "";
		String formName = "";
		if (map.get("mlc") != null){
			url = "adt?method=getMlcNo";
			formName = "search";
		}else if (map.get("wound") != null){
			formName = "search";
			url = "adt?method=getAdmissionNoList&flag=admission&wound=yes";
		}else{
			formName = "search";
			url = "adt?method=getAdmissionNoList&flag=admission";
		}
		if(map.get("silDil") !=null){
			formName = "search";
			url = "adt?method=getAdmissionNoList&flag=admission&silDil=silDil";
		}if (map.get("mlcForm") != null){
			formName = "mlcCase";
			url = "adt?method=getPatientDetailsForMlc";
		}
%>
<div id="hinDiv">
<label>HIN <span>*</span></label> 
<select name="<%=HIN_NO%>"	validate="Hin,String,yes" id="hinNo" tabindex="1"	onchange="submitProtoAjaxWithDivName('<%=formName %>','<%=url %>','testDiv')">
	<option value="">Select</option>
	<% 
	     	
	     	if (hinNoList!=null && hinNoList.size() > 0 ) 
	     	{ 
	     		for (Iterator iterator = hinNoList.iterator(); iterator.hasNext();) {
	    				Patient patient = (Patient)iterator.next();
				%>
	<option value="<%=patient.getHinNo()%>"><%=patient.getPFirstName()+" "+(patient.getPMiddleName()!=null?patient.getPMiddleName():"")+" "+(patient.getPLastName()!=null?patient.getPLastName():"")+" ("+patient.getRelation().getRelationName()+")"%>
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
<script>document.getElementById('hinNo').focus();</script>