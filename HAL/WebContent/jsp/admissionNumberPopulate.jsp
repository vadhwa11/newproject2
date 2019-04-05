<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : admissionNumberPopulate.jsp 
	 * Jasper Reports Used : Discharge_Summary_General.jasper, Discharge_Summary_Gyna.jasper, Discharge_Summary_Pedia.jasper
	 * Tables Used         : discharge_items, discharge_items_category, discharge_summary, patient
	 * Description         : This JSP is called thru AJAX to populate Admission Number Combo in dischargeSummaryReport.jsp
	 * @author  Create Date: 18.02.2008    Name: Othivadivel K R   
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 * @see DischargeController.java, DischargeHandlerService.java, DischargeHandlerServiceImpl.java, 
	 *      DischargeDataService.java, DischargeDataServiceImpl.java, dischargeSummaryReport.jsp
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
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

<%	
		String userName = "";
		String date ="";
		String time = "";
		String reply = "";
		Boolean hinNoFound = null;
		Map map = new HashMap();
		
		Map<String,Object> utilMap = new HashMap<String,Object>();
		List inpatientSet = null;
		List<Inpatient>inpatientList=null;
		Inpatient inpatient = new Inpatient();

		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		date = (String)utilMap.get("currentDate");	
		time = (String)utilMap.get("currentTime");
		
  	    if (map.get("inpatientSet") != null)
  	    	inpatientList =(List<Inpatient>)map.get("inpatientSet");
  	    
		if (map.get("hinNoFound") != null)
			hinNoFound = (Boolean)map.get("hinNoFound");


  	    if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
%>
<div id="testDiv"><label>Admission No.</label> <select
	name="<%=ADMISSION_NUMBER%>" validate="Admission Number,,yes">
	<% if (inpatientList!=null && inpatientList.size() > 0 ) 
	     	{ 
				Iterator itr = inpatientList.iterator();
				while (itr.hasNext())				
				{ 
					inpatient = (Inpatient)itr.next();
					if (!inpatient.getAdStatus().equalsIgnoreCase("D")) 
					{
					%>
	<option value="<%=inpatient.getAdNo()%>"><%=inpatient.getAdNo()%>
	</option>
	<% } 
  		        } %>
	<script>
			 	document.getElementById('errorMsg').innerHTML='';
			 </script>
	<% } 
	     	 else if (hinNoFound) 
	     	 {
			 %>
	<script>
			 	document.getElementById('errorMsg').innerHTML='<div class="errormsg" style="width: 850px;">* No Admitted Patients!... Pl. Check Your Hin Number</div>';
			 </script>
	<%
			  } 
	     	 else
		      {
				 %>
	<script>
				 	document.getElementById('errorMsg').innerHTML='<div class="errormsg" style="width: 850px;">* Wrong Service Number!... Pl. Check Your Hin Number</div>';
				 </script>
	<%
				  }
	     	 %>
</select></div>