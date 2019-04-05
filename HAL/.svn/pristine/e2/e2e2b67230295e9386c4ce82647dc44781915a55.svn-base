<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<div class="clear"></div>
<div class="clear"></div>
<div class="titleBg">
<h2>Patient Prescription Slip</h2>
</div>
<div class="clear"></div>

<form name="search"  method="post" action="">
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>Employee No. </label>
<input type="text" id="serviceNo." name="<%=SERVICE_NO%>" value=""	 MAXLENGTH="30"	onblur="if(validateMetaCharacters(this.value)){getHinNo('search','opd?method=getHinNoForpatientpres&flag=pres')}" />

<div id="hinDiv">
<label> Patient Name </label>
<input	type="text" name="<%=HIN_NO%>" value="" MAXLENGTH="30"	onchange="if(validateMetaCharacters(this.value)){submitProtoAjax('search','opd?method=getvisitDetails')}"	 />
</div>
<label>Visit No For Prescription</label>
<div id="testDiv"> 
<input type="text" id="visitNo" name="<%=VISIT_ID%>" value="" class="date" MAXLENGTH="6" validate="Visit No.,String,yes" />

</div>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="OK" value="Ok" class="button"
	onClick="submitForm('search','opd?method=printPatientPrescriptionReport');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>





