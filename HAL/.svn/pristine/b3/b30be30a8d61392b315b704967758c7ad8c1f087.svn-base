<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<div id="contentHolder">
<h6>Patient Movement Order</h6>

<div class="Clear"></div>
<form name="PMOReport" target="_blank" method="post" action="">
<div class="blockFrame"><label class=""><span>*</span>
Service No:</label> 
	<input type="text" size="2" title="Enter Service No. of patient." id="serviceNo" name="<%=SERVICE_NO%>" onblur="populateHinNo(this.value);" /> 
	<label><span>*</span>Hin No:</label> 
	<select	id="hinNoId" name="<%=HIN_ID %>" validate="Hin No,string,yes" onchange="submitProtoAjax('PMOReport','mis?method=getAdNo1');" />
	<option value="0">select</option>
	</select> 
	<div id="testDiv"><label class="bodytextB"><span>*</span>Admission No:</label>
<input type="text" name="<%=AD_NO %>" id="<%=AD_NO %>" value="" class="textbox_date"
	MAXLENGTH="30" validate="Admission No,String,yes" />

</div>
<div class="Clear"></div>
<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('PMOReport','mis?method=printPMO');" /></form>

</div>





