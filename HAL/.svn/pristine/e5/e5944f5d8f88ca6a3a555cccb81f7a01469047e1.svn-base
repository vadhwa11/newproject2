<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>


<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<div class="titleBg">
<h2>Discharge Slip Report</h2>
</div>
<div class="clear"></div>

<form name="dischargeSlipReport" target="_blank" method="post" action="">

<div class="Block">
<label>Service No.</label> 
<input type="text" id="serviceNo." name="<%=SERVICE_NO%>" value="" MAXLENGTH="30"
	onblur="submitProtoAjax('dischargeSlipReport','ipd?method=getAdmissionNoList&flag=admission')" />
<!--<div id="hinDiv">-->
<!--<label>Hin </label> -->
<!--<input type="text" name="<%=HIN_NO%>" value="" MAXLENGTH="30" /></div>-->
<div id="testDiv">
<label>Admission No. </label> 
<input type="text" name="<%=INPATIENT_ID%>" value="" MAXLENGTH="30" />
</div>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('dischargeSlipReport','ipd?method=showDischargeSlipReport');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" />
	<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
	</form>








