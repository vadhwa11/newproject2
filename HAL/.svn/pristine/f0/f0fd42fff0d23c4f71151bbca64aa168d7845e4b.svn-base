<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<div id="contentHolder">
<h6>Search Patient Previous Visit</h6>
<div class="Clear"></div>

<form name="search" method="post" action="">
<label	class="bodytextB">Service No.:</label> <input type="text"
	id="serviceNo." validate="Service No.,string,yes"
	name="<%=SERVICE_NO_FOR_REPORT%>" value="" class="textbox_date" MAXLENGTH="20"
	onblur="getHinNo('search','opd?method=getOpdReportList&flag=hin')" />
<div id="hinDiv"><label class="bodytextB"> Hin No:</label> <input
	type="text" name="hinNo" value="" class="textbox_date" MAXLENGTH="50"
	onchange="submitProtoAjax('search','opd?method=getOpdReportList&flag=visit')" />
</div>


<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('search','opd?method=showPatientPreviousHinNumber');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" /></form>
</div>





