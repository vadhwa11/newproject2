<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<br />
<div id="contentspace">
<h6>Result Entry Format</h6>
<div class="Clear"></div>

<form name="search" target="_blank" method="post" action=""><label>Service
No.</label> <input type="text" id="serviceNo." validate="Service No.,string,yes"
	name="<%=SERVICE_NO%>" value="" class="textbox_date" MAXLENGTH="20"
	onblur="getHinNo('search','lab?method=getLabReportList&flag=hin')" />
<div id="hinDiv"><label>Patient Name</label> <input type="text"
	name="<%=HIN_NO%>" value="" class="textbox_date" MAXLENGTH="50"
	onchange="submitProtoAjax('search','lab?method=getLabReportList&flag=order')" />
</div>
<div id="testDiv"><label>Order No.</label> <input type="text"
	id="diagnosisNo" name="<%=ORDER_NO%>" value="" class="textbox_date"
	MAXLENGTH="30"
	onchange="submitProtoAjax('search','lab?method=getLabOrderReportList&flag=result')" />
</div>

<div id="resultDiv"><label>Investigation</label> <input
	type="text" id="resultList" name="<%=RESULT_TYPE%>" value=""
	class="textbox_date" MAXLENGTH="30" /></div>


<div class="Clear"></div>

<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('search','lab?method=showResultEntryReport');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" /></form>
</div>





