<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">
<div class="titleBg">
<h2>AFMSF-7A</h2>
</div>

<form name="search" target="_blank" method="post" action="">
<div class="Block">
<label>Service No. </label>
<input type="text" id="serviceNo." name="<%=SERVICE_NO%>" value=""	 MAXLENGTH="30"	 validate="Service No.,metachar,no"
onblur="getHinNo('search','opd?method=getHinNoForpatientpres&flag=visit')" />

<div id="hinDiv">
<label> Patient Name</label>
<input	type="text" name="<%=HIN_NO%>" value="" MAXLENGTH="30"	onchange="submitProtoAjax('search','opd?method=getPresVisitNo')"	validate="Patient Name,metachar,yes" />
</div>
<label>Visit No</label>
<div id="testDiv"> <input
	type="text" id="visitNo" name="<%=VISIT_NUMBER%>" value=""
	class="textbox_date" MAXLENGTH="6" />

	</div>
	<div class="clear"></div>
	</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="OK" value="Ok" class="button"	onClick="submitForm('search','medicalExam?method=AFMSF7AReport');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>
	






