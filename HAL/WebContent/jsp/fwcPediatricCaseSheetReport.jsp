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
<div id="contentspace"><br />
<h2 align="left" class="style1">FWC Pediatric Case Sheet</h2>
<br />

<form name="search" target="_blank" method="post" action="">
<label class="bodytextB">Service No.:</label> 
<input type="text" id="serviceNo." validate="Service No.,string,yes" name="<%=SERVICE_NO%>" value="" class="textbox_date" MAXLENGTH="20" onblur="getHinNo('search','fwc?method=getFwcReportList&flag=hin')" />
<div id="hinDiv">
<label class="bodytextB"> Hin No:</label> 
<input type="text" name="<%=HIN_NO%>" value="" class="textbox_date" MAXLENGTH="50" onchange="submitProtoAjax('search','fwc?method=getFwcReportList&flag=visit')" />
</div>
<div id="testDiv">
<label class="bodytextB">Visit No</label> 
<input type="text" id="visitNo" name="<%=VISIT_NUMBER%>" value="" class="textbox_date" MAXLENGTH="6" />
</div>
<br />
<br />

<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('search','fwc?method=printFwcPediatricCaseSheet');" /><!--showFwcPediatricCaseSheetReport  -->
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" /></form>
</div>




