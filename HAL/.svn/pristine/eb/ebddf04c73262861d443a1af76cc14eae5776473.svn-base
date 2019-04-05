<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * patientMovementOrder.jsp  
 * Purpose of the JSP -  This is for Patient Movement Order.
 * @author  Deepti
 * @author  ritu
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasRankCategory"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<br />
<div id="contentspace"><script type="text/javascript"
	language="javascript">
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script> <br />
<h2 align="left" class="style1">Patient Movement Order</h2>
<br />


<%
			 	String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 				 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	String currenDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");

			 	Map<String, Object> map = new HashMap<String, Object>();
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
					
			 	List<Patient> serviceNoList = new ArrayList<Patient>();
			 	List<MasDisposal> disposalList = new ArrayList<MasDisposal>();
			 	List<Patient> patientList = new ArrayList<Patient>();
			 	List<Visit> visitList = new ArrayList<Visit>();
			 	List<Object> list = null;
			 	Date toDate  = null;
				Date fromDate=null;
				String category=null;
			 	
				
			 	if (map.get("serviceNoList") != null) {
			 		serviceNoList = (List<Patient>) map.get("serviceNoList");
			 	}
			 	if (map.get("disposalList") != null) {
			 		disposalList = (List<MasDisposal>) map.get("disposalList");
			 	}
			 	if (map.get("patientList") != null) {
			 		patientList = (List<Patient>) map.get("patientList");
			 	}
			 	if (map.get("showList") != null) {
			 		visitList = (List<Visit>) map.get("showList");
			 		session.setAttribute("visitList", visitList);
			 	}
			 	if (map.get("showList") != null) {
			 		list = (List<Object>) map.get("showList");
			 		session.setAttribute("list", list);
			 	}
			 	if (map.get("toDate") != null) {
			 		toDate = (Date) map.get("toDate");
			 		session.setAttribute("toDate", toDate);
			 	}
			 	if (map.get("fromDate") != null) {
			 		fromDate = (Date) map.get("fromDate");
			 		session.setAttribute("fromDate", fromDate);
			 	}
			 	if (map.get("category") != null) {
			 		category = (String) map.get("category");
			 		session.setAttribute("category", category);
			 	}
			 	
			 	
			 %>

<form name="edreport" target="_blank" method="post" action=""><label
	class="bodytextB"><font id="error">*</font>Service No.:</label> <input
	type="text" id="serviceNo." name="<%=SERVICE_NO%>" value=""
	validate="Service No.,number,yes" class="textbox_date" MAXLENGTH="30" />
<br />
<br />
<!-- 			
			<label class="bodytextB"> FRW SLNO:</label>
			<input type="text" id="frwSlno" name="<//%=FRW_SLNO%>" value="" class="textbox_date" MAXLENGTH="30" />
			
			<label class="bodytextB"> From/ To:</label>
			<input type="text" id="fromTo" name="<//%=FROM_TO%>" value="" class="textbox_date" MAXLENGTH="30" />
			 --> <label class="bodytextB">Disposal :</label> <select
	id="disposalId" name="<%=DISPOSAL_ID %>">
	<option value="0">select</option>
	<%
							for (MasDisposal masDisposal : disposalList) {
						%>
	<option value="<%=masDisposal.getDisposalName() %>"><%=masDisposal.getDisposalName()%></option>
	<%
						}
					%>
</select> <br />

<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('edreport','mis?method=searchPatientMovementOrder');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" /></form>


</div>





