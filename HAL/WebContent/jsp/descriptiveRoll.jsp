


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.*"%>

<%@page import="jkt.hms.masters.business.MasPersonnelDetails"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>


<title>Descriptive Roll</title>
<div id="contentspace"><br />

<form name="descriptiveRoll" action="" method="post">
<h6>Descriptive Roll</h6>
<%
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		
		
		if(map.get("message") != null){
			   String message = (String)map.get("message");
			   out.println(message);
			  }
	%>


<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Descriptive Roll </font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 100px; background-color: #f4f9fe;">

<br />


<label class="bodytextB">Pass No: </label> <input type="text"
	name="passNo" value="" class="textbox_size20" MAXLENGTH="30" /> <label
	class="bodytextB"> Name:</label> <input type="text" name="Name"
	value="" class="textbox_size20" MAXLENGTH="30" />


<div class="Clear"></div>
<br />
</div>

<br />
</form>

<input type="button" name="Print"
	onclick="submitForm('descriptiveRoll','/hms/hms/pension?method=printDescriptiveRollJsp');"
	value="Print" class="button" accesskey="a" /> </script>