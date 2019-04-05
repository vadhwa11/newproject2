<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<div id="contentspace">
<form name="fatalCase" method="post" action=""><br />
<br />
<label class="bodytextB">Service No.:</label> <input type="text"
	id="serviceNo." name="<%=SERVICE_NO%>" value="" class="textbox_date"
	MAXLENGTH="30"
	onblur="submitProtoAjaxWithDivName('fatalCase','mis?method=getHinAdNoDetailsFatalCase&flag=hin','hinDiv')" />
<div id="hinDiv"><label class="bodytextB"> Hin:</label> <input
	type="text" name="<%=HIN_NO%>" value="" class="textbox_date"
	MAXLENGTH="30"
	onchange="submitProtoAjaxWithDivName('fatalCase','mis?method=getAdmissionNoList&flag=admission&fatalCase=yes','testDiv')" />
</div>
<div id="testDiv"><label class="bodytextB"><font
	id="error">*</font>Ad No:</label> <input type="text" id="frwSlno"
	name="<%=AD_NO%>" value="" validate="AD No.,,yes" class="textbox_date"
	MAXLENGTH="30"
	onblur="submitProtoAjaxWithDivName('fatalCase','mis?method=showFatalCase','show');" />
</div>
<br />
<br />
<input type="button" name="edit" value="Print" class="button"
	onClick="submitForm('fatalCase','mis?method=printFDTReport');" /></form>
</div>