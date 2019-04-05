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
  obj.action = "/hms/hms/ot?method=showPostAnaesthesiaPatientDetails";
  obj.submit();
}
</script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<br />
<div id="contentspace"><br />
<h2 align="left" class="style1">Search OT Specimen Dispatch Entry</h2>
<br />

<form name="search" method="post" action=""><label
	class="bodytextB">Service No.:</label> <input type="text"
	id="serviceNo." name="<%=SERVICE_NO%>"
	validate="Service No.,string,yes" value="" class="textbox_date"
	MAXLENGTH="20"
	onblur="getHinNo('search','ot?method=getOTSpecimenDispatchList&flag=hin')" />
<div id="hinDiv"><label class="bodytextB"> Hin No:</label> <input
	type="text" name="<%=HIN_NO%>" value="" class="textbox_date"
	MAXLENGTH="50"
	onchange="submitProtoAjax('search','ot?method=getOTSpecimenDispatchList&flag=visit')" />
</div>
<div id="testDiv"><label class="bodytextB">Entry No.:</label> <input
	type="text" id="visitNo" name="<%=VISIT_NUMBER%>" value=""
	class="textbox_date" MAXLENGTH="6" /></div>
<br />
<br />

<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('search','ot?method=showOtSpecimenDispatchEntry');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" /> <input type="button"
	name="Back" class="button" value="Back" onclick="showBack('search')" />


</form>
</div>





