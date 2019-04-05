<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : procedureAdviceList.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 22.09.2011    Name: Mukesh Narayan Singh
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>



<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script>
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
	</script>

<%
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String time = (String)utilMap.get("currentTime");
 
 		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		List<DgResultEntryDetail> resultEntryDetailList = new ArrayList<DgResultEntryDetail>();
		if(map.get("resultEntryDetailList") != null){
			resultEntryDetailList = (List<DgResultEntryDetail>)map.get("resultEntryDetailList");
		}
		System.out.println("resultEntryDetailList==in jsp===="+resultEntryDetailList.size());
		
		int visitId =0;
		int hinId=0;
		
	
	%>

<form name="resultInvestigation" action="" method="post">
<h4>Investigation Result</h4>
<div class="Clear"></div>
<div id="pageNavPosition"></div>
<div class="Clear"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="proceduregrid">

	<tr>
				<th scope="col">Test</th>
		
	</tr>
	<%
	if(resultEntryDetailList.size()>0){
		for(DgResultEntryDetail dgResultEntryDetail : resultEntryDetailList){
	%>
	<tr>
	
	<td><%=dgResultEntryDetail.getResult() %></td>
	</tr>
<%}} %>
</table>
	
	
	
<div class="Clear"></div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=LAST_CHANGED_DATE %>" value="<%=currentDate%>"  />
<input type="hidden" name="<%=LAST_CHANGED_TIME %>"  value="<%=time%>" />
<div class="Clear"></div>

</form>
