<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
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
	String date = "";
	String time = "";
	String userName = "";
	int hospitalId = 0;
	
	Box box = HMSUtil.getBox(request);
	System.out.println("box inside jsp" + box);
	List<HrMonthlyRationAccountingLeaveDetail> hrMonthlyRationAccountingLeaveDetailList = new ArrayList<HrMonthlyRationAccountingLeaveDetail>();
	List<HrMonthlyRationAccountingInpatientDetail> hrMonthlyRationAccountingInpatientDetailList = new ArrayList<HrMonthlyRationAccountingInpatientDetail>();
	List<HrMonthlyRationAccountingMovementDetail> hrMonthlyRationAccountingMovementTDDetailList = new ArrayList<HrMonthlyRationAccountingMovementDetail>();
	List<HrMonthlyRationAccountingMovementDetail> hrMonthlyRationAccountingMovementAWLDetailList = new ArrayList<HrMonthlyRationAccountingMovementDetail>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null)
 	{
		userName = (String)session.getAttribute("userName");
		}
 	
  	Map map = new HashMap();
  	
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
	}
	
	if (session.getAttribute("hospitalId") != null) 
	{
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}

	if (map.get("hrMonthlyRationAccountingLeaveDetailList")!=null)
	{
		hrMonthlyRationAccountingLeaveDetailList = (List<HrMonthlyRationAccountingLeaveDetail>)map.get("hrMonthlyRationAccountingLeaveDetailList");
	}
	if (map.get("hrMonthlyRationAccountingInpatientDetailList")!=null)
	{
		hrMonthlyRationAccountingInpatientDetailList = (List<HrMonthlyRationAccountingInpatientDetail>)map.get("hrMonthlyRationAccountingInpatientDetailList");
	}

	if (map.get("hrMonthlyRationAccountingMovementTDDetailList")!=null)
	{
		hrMonthlyRationAccountingMovementTDDetailList = (List<HrMonthlyRationAccountingMovementDetail>)map.get("hrMonthlyRationAccountingMovementTDDetailList");
	}
	if (map.get("hrMonthlyRationAccountingMovementAWLDetailList")!=null)
	{
		hrMonthlyRationAccountingMovementAWLDetailList = (List<HrMonthlyRationAccountingMovementDetail>)map.get("hrMonthlyRationAccountingMovementAWLDetailList");
	}
	

%>

<title>Employee Details</title>

<script>

</script>

<% 
String message="";
if (map.get("message") != null) {
		 message = (String) map.get("message");
		
	}
if(!message.equalsIgnoreCase("")){
%>
<h2><%=message %></h2>
<%} %>

<DIV class="Clear"></DIV>



<div id="contentHolder">
<h6>Employee Leave/Inpatient/Transfer/Absent without Leave  Detail</h6>
<DIV class="Clear"></DIV>
<form name="employeeDeatil"> 
<div class="Clear"></div>

<div class="blockTitle">Leave List In Requested Period </div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="tableHolderAuto">
<table align="center" width="100%" colspan="3" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th>Leave From Date </th>
			<th>Leave To Date </th>
			<th>Number of Days </th>
			<th>Eff. Number Of Days </th>

		</tr>
	</thead>
	<tbody>
	<%if(hrMonthlyRationAccountingLeaveDetailList !=null && hrMonthlyRationAccountingLeaveDetailList.size()>0){
		for(HrMonthlyRationAccountingLeaveDetail hrMonthlyRationAccountingLeaveDetail : hrMonthlyRationAccountingLeaveDetailList){
			if(hrMonthlyRationAccountingLeaveDetail.getLeaveFromDate()!=null){
	%>
	<tr>
	<td><%=hrMonthlyRationAccountingLeaveDetail.getLeaveFromDate() %></td>
	<td><%=hrMonthlyRationAccountingLeaveDetail.getLeaveToDate() %></td>
	<td><%=hrMonthlyRationAccountingLeaveDetail.getLeaveTotalDays() %></td>
	<td><%=hrMonthlyRationAccountingLeaveDetail.getEffTotalDays() %></td>
	</tr>
	<%}}} %>
	</tbody>
</table>
</div>
<div class="division"></div>
<div class="blockTitle">TD List in Requested Period </div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="tableHolderAuto">
<table align="center" width="100%" colspan="3" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th>TD From Date </th>
			<th>TD To Date </th>
            <th>TD Number of Days </th>
            <th>Eff. Number of Days </th>
		</tr>
	</thead>
	<tbody>
	<%if(hrMonthlyRationAccountingMovementTDDetailList !=null && hrMonthlyRationAccountingMovementTDDetailList.size()>0){
		for(HrMonthlyRationAccountingMovementDetail hrMonthlyRationAccountingMovementTDDetail : hrMonthlyRationAccountingMovementTDDetailList){
			if(hrMonthlyRationAccountingMovementTDDetail.getMovementFromDate()!=null){
	%>
	<tr>
	<td><%=hrMonthlyRationAccountingMovementTDDetail.getMovementFromDate() %></td>
	<td><%=hrMonthlyRationAccountingMovementTDDetail.getMovementToDate() %></td>
	<td><%=hrMonthlyRationAccountingMovementTDDetail.getMovementTotalDays() %></td>
	<td><%=hrMonthlyRationAccountingMovementTDDetail.getEffTotalDays() %></td>
	</tr>
	<%}}} %>
	
	</tbody>
</table>
</div>
<div class="division"></div>
<div class="blockTitle">Hospital Inpatient Details in Requested Period </div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="tableHolderAuto">
<table align="center" width="100%" colspan="3" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th>Inpatient Date of Addmission</th>
			<th>Inpatient Date of Discharge</th>
			<th>Inpatient Number of Days </th>
			<th>Eff. Number of Days </th>

		</tr>
	</thead>
	<tbody>
    
    <%if(hrMonthlyRationAccountingInpatientDetailList !=null && hrMonthlyRationAccountingInpatientDetailList.size()>0){
		for(HrMonthlyRationAccountingInpatientDetail hrMonthlyRationAccountingInpatientDetail : hrMonthlyRationAccountingInpatientDetailList){
			if(hrMonthlyRationAccountingInpatientDetail.getHospFromDate()!=null){
	%>
	<tr>
	<td><%=hrMonthlyRationAccountingInpatientDetail.getHospFromDate() %></td>
	<td><%=hrMonthlyRationAccountingInpatientDetail.getHospToDate() %></td>
	<td><%=hrMonthlyRationAccountingInpatientDetail.getHospTotalDays() %></td>
	<td><%=hrMonthlyRationAccountingInpatientDetail.getEffTotalDays() %></td>
	</tr>
	<%}}} %>
    
	</tbody>
</table>
</div>
<div class="division"></div>
<div class="blockTitle">Awl List in Requested Period </div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="tableHolderAuto">
<table align="center" width="100%" colspan="3" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th>AWL From Date </th>
			<th>AWL To Date </th>
			<th>AWL Number of Days </th>
			<th>Eff. Number of Days </th>

		</tr>
	</thead>
	<tbody>
	<%if(hrMonthlyRationAccountingMovementAWLDetailList !=null && hrMonthlyRationAccountingMovementAWLDetailList.size()>0){
		for(HrMonthlyRationAccountingMovementDetail hrMonthlyRationAccountingMovementAWLDetail : hrMonthlyRationAccountingMovementAWLDetailList){
			if(hrMonthlyRationAccountingMovementAWLDetail.getMovementFromDate()!=null){
	%>
	<tr>
	<td><%=hrMonthlyRationAccountingMovementAWLDetail.getMovementFromDate() %></td>
	<td><%=hrMonthlyRationAccountingMovementAWLDetail.getMovementToDate() %></td>
	<td><%=hrMonthlyRationAccountingMovementAWLDetail.getMovementTotalDays() %></td>
	<td><%=hrMonthlyRationAccountingMovementAWLDetail.getEffTotalDays() %></td>
	</tr>
	<%}}} %>
	
	</tbody>
</table>
</div>

<div class="division"></div>
<div class="division"></div>
<div class="bottom">
<div class="Clear"></div>
<input type="button" class="button"  onclick="window.close();" value="close" style="margin-left:420px;" />
</div>
<div class="division"></div>



</form>
</div>



