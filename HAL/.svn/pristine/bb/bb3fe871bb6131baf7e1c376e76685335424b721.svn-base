
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">

<%
	Map<String, Object> map = new HashMap<String, Object>();
	String message = "";
	String years = "";
	String months = "";
	String id="";
	int contigentMedicalBill_Id=0;
	int specialInvId=0;
	int entryNo = 0;
	if(request.getAttribute("map") != null){
		map = (Map<String,Object>)request.getAttribute("map");
	}
	if(map.get("message") != null){
		message = (String)map.get("message");
	}
	if(map.get("years") != null){
		years = (String)map.get("years");
	}
	if (map.get("months") != null) {
	    months = (String) map.get("months");
	      }
	if(!message.equalsIgnoreCase("")){
	%>

<label class="noWidth"><span><%=message %></span></label>
<%} %>
<form name="message" method="post">
<div class="Clear"></div>
<div id="contentHolder">
<%
%>

<div class="Clear"></div>
<div class="blockFrame">
<input type="hidden" name="years" value="<%=years %>" />
<input type="hidden" name="months" value="<%=months %>" />
<label class="large" style="width:330px;padding-left:10px;">Print Monthly Ration For Living In Airmen :</label>
<input type="radio" id="monthlyRation" name="monthlyRation" checked="checked" value="1" tabindex="1" class="radio" />
<label class="large" style="width:350px;padding-left:30px;">Print Monthly Ration For Living In TD Airmen :</label>
<input type="radio" id="monthlyRation" name="monthlyRation"  value="3" tabindex="1" class="radio" />

<div class="Clear"></div>
<label class="large" style="width:330px;padding-left:10px;">Print Monthly Ration For Living In SNCO's:</label>
<input type="radio" id="monthlyRation" name="monthlyRation" value="2" tabindex="1" class="radio" />
<label class="large" style="width:350px;padding-left:30px;">Print Monthly Ration For Living In TD SNCO's:</label>
<input type="radio" id="monthlyRation" name="monthlyRation" value="4" tabindex="1" class="radio" />


<div class="Clear"></div>
<label class="large" style="width:330px;padding-left:10px;">Print Consolidate Ration Summary Mess wise :</label>
<input type="radio" id="monthlyRation" name="monthlyRation" value="5" tabindex="1" class="radio" />
<label class="large" style="width:350px;padding-left:30px;">Print Ration Summary Date Wise :</label>
<input type="radio" id="monthlyRation" name="monthlyRation" value="6" tabindex="1" class="radio" />

<div class="Clear"></div>
<div class="Clear"></div>
</div>
<input type="button" name="yes" value="Print" class="cmnButton"
	onclick="submitForm('message','/hms/hms/hrOrderly?method=printMonthlyRationAccountingReports','checkTargetForYes');" />
<div class="Clear"></div>

</div>
</form>
