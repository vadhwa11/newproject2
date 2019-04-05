
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.*"%>
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
  obj.action = "/hms/hms/ot?method=showOtPatientDetails&otProcedure=yes";
  obj.submit();
}
</script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<br />
<div id="contentspace">
<%
	Map map = new HashMap();
	String userName="";
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	
	}
		
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	
	int hospitalId=0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	int prescribedDepartmentId=0;
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	
		String servicePersonName="";
	
%> <br />
<h2 align="left" class="style1">Search Post OP Notes (Surgery)
Entry</h2>
<br />

<form name="search" method="post" action=""><label
	class="bodytextB">Service No.:</label> <input type="text"
	id="serviceNo." name="<%=SERVICE_NO%>" value="" class="textbox_date"
	MAXLENGTH="20"
	onblur="getHinNo('search','ot?method=getOtProcedureDetails&flag=hin')" />
<div id="hinDiv"><label class="bodytextB"> Hin No:</label> <input
	type="text" name="<%=HIN_NO%>" value="" class="textbox_date"
	MAXLENGTH="50"
	onblur="submitProtoAjaxWithDivName('search','ot?method=getOtProcedureDetails&flag=yearlySerialNo','testDiv')" />
</div>
<div id="testDiv"><label class="bodytextB">Yearly No.:</label> <input
	type="text" id="yearlySerialNo" name="yearlySerialNo" value=""
	class="textbox_date" MAXLENGTH="6" /></div>
<br>
<br>
<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('search','ot?method=showOtProcedureNotesEntryJsp');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" /> <input type="button"
	name="Back" class="button" value="Back" onclick="showBack('search')" />






</form>
</div>





