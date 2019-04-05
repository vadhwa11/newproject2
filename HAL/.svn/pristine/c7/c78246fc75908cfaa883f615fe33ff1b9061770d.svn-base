<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : completionOfMinorWorkDetails.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 06.05.2009    Name: Vineet Kumar
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%><%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasMinorWorkDetail"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<script language=javascript src="/hms/jsp/js/common.js"
	type=text/javascript></script>
<script language=javascript src="/hms/jsp/js/hms.js"
	type=text/javascript></script>
<script language=javascript src="/hms/jsp/js/calendar.js"
	type=text/javascript></script>

<%
	Calendar calendar = Calendar.getInstance();
	String month = String.valueOf((calendar.get(Calendar.MONTH)) + 1);
	String dateCal = String.valueOf(calendar.get(Calendar.DATE));
	int year = calendar.get(calendar.YEAR);
	if (month.length() < 2) {
		month = "0" + month;
	}
	if (dateCal.length() < 2) {
		dateCal = "0" + dateCal;
	}
%>
<script>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';
	function chkLength(field,maxLimit)
   {
   if(field.value.length > maxLimit)
   {
    alert('Maximum Limit is '+maxLimit+' characters.');
    var val=field.value.substring(0,maxLimit);
    field.value=val;
   }
}
	</script>


<%
	String userName = "";
	Map<String, Object> map = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");

		List<MasEmployee> masEmployee = new ArrayList<MasEmployee>();
	if (map.get("masEmployee") != null) {
		masEmployee = (List) map.get("masEmployee");
	}
	String completionNumber="";
	if (map.get("completionNumber") != null) {
		completionNumber = (String) map.get("completionNumber");
	   }
	List<MasMinorWorkDetail> minorWorkDetailUpdateList = new ArrayList<MasMinorWorkDetail>();
	if (map.get("minorWorkDetailUpdateList") != null) {
		minorWorkDetailUpdateList = (List) map
				.get("minorWorkDetailUpdateList");
	}
	String message ="";
%>
<% 
if (map.get("message") != null) {
		 message = (String) map.get("message");
		
	}
if(!message.equalsIgnoreCase("")){
%>
<h2><%=message %></h2>
<%} %>

<div class="Clear"></div>
<div id=contentHolder>

<h6>Minor Work Completion Details</h6>
<div class="Clear"></div>



<form name="completionOfMinorWorkDetails" action="" method=post>

<input type="hidden" name="<%=POJO_NAME%>" value="MasMinorWorkDetail">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>"
	value="MinorWorkDetail"> <input type="hidden" name="title"
	value="Completion of Minor Work Details"> <input type="hidden"
	name="<%=JSP_NAME %>" value="completionOfMinorWorkDetails"> <input
	type="hidden" name="<%=MINOR_WORK_NO %>"
	value="<%=minorWorkDetailUpdateList.get(0).getMinorWorkDetailNo()%>">
<input type="hidden" name="<%=MINOR_WORK_ID %>"
	value="<%=minorWorkDetailUpdateList.get(0).getId()%>">

<div class="blockFrame"><label>Financial Year</label> <label
	class="value"><%= minorWorkDetailUpdateList.get(0).getFinancialYear()%></label>

<label>Minor Work No.</label> <label class="value"><%=minorWorkDetailUpdateList.get(0).getMinorWorkDetailNo()%></label>

<label>Minor Work Date</label> <label class="value"><%=HMSUtil.convertDateToStringWithoutTime(minorWorkDetailUpdateList.get(0).getMinorWorkDetailDate())%>
</label>

<div class="Clear"></div>

<label> <span>*</span> Work Category</label> <label class="value"><%=minorWorkDetailUpdateList.get(0).getWorkCategoryId()%></label>

<label><span>*</span> Work Type</label> <label class="value"><%=minorWorkDetailUpdateList.get(0).getWorkType().getWorkTypeName()%>
</label>
<div class="Clear"></div>
</div>
<div class="division"></div>

<div class="blockTitle">Work Details</div>
<div class="blockTitleCurve"></div>

<div class="blockFrame"><label><span>*</span> Details of
Work</label> <label class="value"><%=minorWorkDetailUpdateList.get(0).getMinorWorkDetail()%></label>

<label><span>*</span> EstimatedCost</label> <label class="value"><%=minorWorkDetailUpdateList.get(0).getMinorWorkDetailEstimatedCost()%></label>
<div class="Clear"></div>
</div>
<div class="division"></div>
<div class="blockTitle">Approval Work Detail</div>
<div class="blockTitleCurve"></div>

<div class="blockFrame"><label class="large"><span>*</span>
Admin Approval No</label> <label class="value"><%=minorWorkDetailUpdateList.get(0).getAdminApprovalNo()%></label>

<label>Admin Approval Date</label> <label class="value"><%=HMSUtil.convertDateToStringWithoutTime(minorWorkDetailUpdateList.get(0).getAdminApprovalDate())%></label>


<div class="Clear"></div>

<label class="large"><span>*</span>PDC</label> <label class="value"><%=minorWorkDetailUpdateList.get(0).getPdc()%></label>

<label>Estimated Date</label> <label class="value"><%=HMSUtil.convertDateToStringWithoutTime(minorWorkDetailUpdateList.get(0).getEstimatedDate())%></label>

<div class="Clear"></div>
<label class="large"><span>*</span>Admin Remarks</label> <label
	class="value"><%=minorWorkDetailUpdateList.get(0).getMinorWorkDetailRemarks()%></label>
<div class="Clear"></div>
</div>
<div class="division"></div>
<div class="blockTitle">Completion Work Detail</div>
<div class="blockTitleCurve"></div>

<div class="blockFrame"><label class="large"><span>*</span>Completion
Number</label> <input name="<%=COMPLETION_NUMBER %>"
	validate="Completion Number,String, yes" value=""> <label><span>*</span>
Completion Date</label> <input id="completionDateWorkService" class="calDate"
	validate="Completion Date,date,yes" type="text"
	name="<%= COMPLETION_DATE_WORK_SERVICE %>" value="" tabindex="1" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.completionOfMinorWorkDetails.<%=COMPLETION_DATE_WORK_SERVICE%>,event)" ; />

<div class="Clear"></div>

<label class="large"><span>*</span>Completion Remarks</label> <textarea
	tabindex="1" class="large" value="" name="<%=MINOR_WORK_REMARK%>"
	onkeyup="chkLength(this,100);" validate="Remark,string,yes"><%=minorWorkDetailUpdateList.get(0).getMinorWorkDetailRemarks()%></textarea>

<input tabindex="1" type="button" class="cmnButton" id="userComments"
	value="User Comments" name=""
	onClick="setComments('completionOfMinorWorkDetails');"> <input
	tabindex="1" type="button" class="cmnButton" id="viewComments"
	value="View Comments" name=""
	onClick="getComments('completionOfMinorWorkDetails');"> <script
	type="text/javascript">
function getComments(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/minorWorkDetail?method=showViewUserCommentsJsp";
  obj.submit();
}

function setComments(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/minorWorkDetail?method=showUserCommentsJsp";
  obj.submit();
}
</script></div>
<div class="division"></div>
<div class="bottom"><input tabindex="1" type="button"
	class="button" id=Save accessKey=a value=Save name=Save
	onClick="submitForm('completionOfMinorWorkDetails','completionOfMinorWorkDetails?method=editCompletionOfMinorWorkDetails');">
<input tabindex="1" type="reset" name="Reset" class="button" id=reset
	accessKey=r onclick=resetCheck(); value=Reset> <input
	tabindex="1" onClick="javascript:history.back()" type="button"
	name="back" class="button" id=back accessKey=b value=Back>

<div class="division"></div>
<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden"
	name="<%=STATUS %>" value="" /> <input type="hidden"
	name="<%= COMMON_ID%>" value="" /> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
</form>
</div>


