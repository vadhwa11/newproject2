<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">
<div class="clear"></div>
<div class="clear"></div>
<div class="titleBg">
<h2>Patient Prescription and Investigation Format</h2>
</div>
<div class="clear"></div>

<form name="search" target="_blank" method="post" action="">
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>Employee No. </label>
<input type="text" id="serviceNo." name="<%=SERVICE_NO%>" value=""	 MAXLENGTH="30"	onblur="getHinNo('search','opd?method=getHinNoForpatientpres&flag=visit')" />

<div id="hinDiv">
<label> Patient Name </label>
<input	type="text" name="<%=HIN_NO%>" value="" MAXLENGTH="30"	onchange="submitProtoAjax('search','opd?method=getPresVisitNo')"	validate="Service No. ,String,yes" />
</div>
<label>Visit No</label>
<div id="testDiv"> 
<input type="text" id="visitNo" name="<%=VISIT_NUMBER%>" value="" class="textbox_date" MAXLENGTH="6" />

</div>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="OK" value="Ok" class="button"
	onClick="submitForm('search','opd?method=printPatientPrescriptionInvestigation','checkTargetForYes');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>





