
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<%
Map<String, Object> map = new HashMap<String, Object>();
String formName = "";
String hinNo = "";
String entryNo = "";
int cardicContigentId=0;
int serviceTypeId=0;
int id=0;
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("formName") != null){
	formName = (String)map.get("formName");
}
if(map.get("hinNo") != null){
	hinNo = (String)map.get("hinNo");
}
if(map.get("entrySeqNo") != null){
	entryNo = (String)map.get("entrySeqNo");
}
if(map.get("cardicContigentId") != null){
	cardicContigentId = (Integer)map.get("cardicContigentId");
}
if(map.get("serviceTypeId") != null){
	serviceTypeId = (Integer)map.get("serviceTypeId");
}
if(map.get("Id") != null){
	id = (Integer)map.get("Id");
}
%>
<form name="msgContinget" method="post">
<div id="contentHolder">
<% 

		String message ="";
		if (map.get("message") != null) {
		             message = (String) map.get("message");
		      }
		if(!message.equalsIgnoreCase("")){
		 %>
<h2><%=message %></h2>
<%} %>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<h4><%=message %></span></h4>
<div class="Clear"></div>
<div class="blockFrame"><input type="hidden" name="hinNo"
	value="<%=hinNo %>" /> <input type="hidden" name="entryNo"
	value="<%=entryNo %>" /> <input type="hidden" name="message"
	value="<%=message %>" /> <input type="hidden" name="cardicContigentId"
	value="<%=cardicContigentId %>" /> <input type="hidden" name="Id"
	value="<%=id %>" /> <input type="hidden" name="serviceTypeId"
	value="<%=serviceTypeId %>" /> <label class="large"
	style="padding-left: 5px; width: 300px;">Cardiac Contingent
Bill For Reimbursement:</label> <input type="radio" id="opdPrint"
	name="selectReport" checked="checked" value="1" tabindex="1"
	class="radio" /> <label class="large"
	style="padding-left: 20px; width: 200px;">Annexure III
(Certificate of AMA):</label> <input type="radio" id="opdPrint"
	name="selectReport" value="2" tabindex="1" class="radio" />
<div class="Clear"></div>
<label class="large" style="padding-left: 175px; width: 130px;">Dependent
Certificate:</label> <input type="radio" id="opdPrint" name="selectReport"
	value="3" tabindex="1" class="radio" /> <label class="large"
	style="width: 220;">WillingnessCertificate(Annexure I):</label> <input
	type="radio" id="opdPrint" name="selectReport" value="5" tabindex="1"
	class="radio" />

<div class="Clear"></div>

<label class="large" style="padding-left: 55px; width: 250px;">PostFacto-Sanction
Covering Letter :</label> <input type="radio" id="opdPrint" name="selectReport"
	value="6" tabindex="1" class="radio" />
<div class="Clear"></div>
<div class="Clear"></div>
</div>


<input type="button" class="cmnButton" name="print" value="Print"
	onclick="submitForm('msgContinget','/hms/hms/mediClaim?method=printCardiacClaimReimbrusmentReports','checkTargetForYes');" />
<input type="button" class="cmnButton" name="no" value="No"
	onclick="submitForm('msgContinget','/hms/hms/mediClaim?method=showPatientCardicClaimContingentBill','checkTargetForNo');" />
<div class="Clear"></div>

</div>
</form>
