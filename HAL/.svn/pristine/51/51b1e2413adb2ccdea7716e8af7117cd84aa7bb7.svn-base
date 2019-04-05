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
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
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
		int pageNo=1;
		int hinId=0;
		Map map = new HashMap();
		List<Object> hinNoList = new ArrayList<Object>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("hinList") != null)
			hinNoList =(List)map.get("hinList");
  	    
		if(map.get("pageNo") != null)
		{
			pageNo=(Integer)map.get("pageNo");
			
			
		}	
		if(map.get("hinId") != null)
		{
			
			hinId=(Integer)map.get("hinId");
			
		}
		
%>
<input type="hidden" name="pageNo" value="<%=pageNo %>" />
<div id="hinDiv">
<input type="hidden" name="buttonFlag"	value="empty" />
<label >Service Type</label>
<% 
	Patient patient1=null;
	String serviceType="";
	if (hinNoList!=null && hinNoList.size() > 0 ) 
	{ 
		for (Iterator iterator = hinNoList.iterator(); iterator.hasNext();)
		{
			 patient1 = (Patient)iterator.next();
			 serviceType=patient1.getServiceType().getServiceTypeName();
		}
	}	
	
%>
 <input	type="text" id="serviceType" name="serviceType" value="<%=serviceType %>"  tabindex="1" />
<label class="medium">HIN</label>
<select	name="<%=HIN_ID%>" validate="Hin,string,no"	onchange="submitProtoAjax('opdPatientIssue','stores?method=showOPDPatientIssueGrid')">
 <option value="">Select</option>
	<% 
	     	Patient patient=null;
	     	String patientName="";
	     	if (hinNoList!=null && hinNoList.size() > 0 ) 
	     	{ 
	     		for (Iterator iterator = hinNoList.iterator(); iterator.hasNext();) {
	    				 patient = (Patient)iterator.next();
	    				int hinIdFromDB=patient.getId();
	    				if(patient.getPFirstName() != null)
	    				{
	    					patientName=patient.getPFirstName();
	    				}
	    				if(patient.getPMiddleName() != null)
	    				{
	    					patientName+=patient.getPMiddleName();
	    				}
	    				if(patient.getPLastName() != null)
	    				{
	    					patientName+=patient.getPLastName();
	    				}
	    				if (hinId==hinIdFromDB) {
				%>
<option value="<%=patient.getId()%>" selected><%=patient.getHinNo()%>----<%=patientName %></option>
	<%}else{%>
<option value="<%=patient.getId()%>"><%=patient.getHinNo()%>----<%=patientName %></option>
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
</select>
</div>




