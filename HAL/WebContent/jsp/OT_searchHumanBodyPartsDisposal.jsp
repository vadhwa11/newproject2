<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript">

function showBack(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/ot?method=showOTPatientSearchForDisposalJsp";
  obj.submit();
}
</script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<br />
<div id="contentspace"><br />
<h2 align="left" class="style1">Search Human Body Parts Disposal</h2>
<br />

<form name="search" method="post" action=""><label
	class="bodytextB">Service No.:</label> <input type="text"
	id="serviceNo." name="<%=SERVICE_NO%>"
	validate="Service No.,string,yes" value="" class="textbox_date"
	MAXLENGTH="20"
	onblur="submitProtoAjaxWithDivName('search','ot?method=getHinNoList&flag=hin','hinDiv')" />
<div id="hinDiv"><label class="bodytextB"> Hin No:</label> <input
	type="text" name="<%=HIN_NO%>" value="" class="textbox_date"
	MAXLENGTH="50"
	onchange="submitProtoAjaxWithDivName('search','ot?method=getHinNoList&flag=entry','entryDiv')" />
</div>
<div id="entryDiv"><label class="bodytextB"> Entry No:</label> <input
	type="text" name="entryNo" value="" class="textbox_date" MAXLENGTH="50" />
</div>
<br />
<br />

<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('search','ot?method=showHumanBodyPartsDisposalJsp&flag=existingRecord');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" /> <input type="button"
	name="Back" class="button" value="Back" onclick="showBack('search')" />


</form>
</div>





