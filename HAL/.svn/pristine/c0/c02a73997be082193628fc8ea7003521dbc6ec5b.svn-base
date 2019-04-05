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

<%@page import="jkt.hms.masters.business.Inpatient"%>

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
<script type="text/javascript">
function fillRgDate(){
	document.getElementById("regDateId").value =document.getElementById("birthDateId").value
} 
</script>


<%	
		Map map = new HashMap();
		List<Object> admissionNoList = new ArrayList<Object>();
		String url ;
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("admissionNoList") != null)
		
			admissionNoList =(List)map.get("admissionNoList");
		
		
		
		
%>
<div id="testDiv"><label><span>*</span> Admission No. </label> <select
	name="<%=INPATIENT_ID%>" validate="Admission Number,,yes"
	onchange="submitProtoAjaxWithDivName('fatalDocumentPanchnamaReport','mis?method=showBirth','birthDiv');">
	<option value="">Select</option>
	<% 
	     
	     	if (admissionNoList!=null && admissionNoList.size() > 0 ) 
	     	{ 
	     		for (Iterator iterator = admissionNoList.iterator(); iterator.hasNext();) {
	    			Object[] object = (Object[]) iterator.next();
					Inpatient inpatient = (Inpatient)object[0];
									%>
	<option value="<%=inpatient.getId()%>"><%=inpatient.getAdNo()%>
	</option>
	<% 
  		     		
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