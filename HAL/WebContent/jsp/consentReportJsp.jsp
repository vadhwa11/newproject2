<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<div class="titleBg">
<h2>Consent Report</h2>
</div>
<div class="Clear"></div>
<form name="consentReportJsp" target="_blank" method="post" action="">
<div class="Block"><label>Service No.</label> <input
	type="text" id="serviceNo." name="<%=SERVICE_NO%>" value=""
	MAXLENGTH="30"
	onblur="getHinNo('consentReportJsp','ipd?method=getAdmissionNoList&flag=hin')" />
<div id="hinDiv">
  <label>HIN</label> 
   <input type="text" name="<%=HIN_NO %>" value="" MAXLENGTH="30" />
 </div>
<div id="testDiv"></div>
	</div>
	<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('consentReportJsp','registration?method=printConsentReportJsp');" />
<input type="reset" name="Reset" value="Reset" class="button"
	onclick="location.reload();" accesskey="r" />
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
</form>


