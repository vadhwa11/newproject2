
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.MasManufacturer"%>

<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.StoreGrnM"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="jkt.hms.masters.business.StoreDefectiveDrugM"%>
<%@page import="jkt.hms.masters.business.StoreBoo"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<StoreBoo> booList = new ArrayList<StoreBoo>();
	
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if(map.get("booList")!=null){
		booList =(List) map.get("booList");
		
	}
%>
<div id="contentspace">
<form name="grnReport" id=grnReport method="post" action="">

<div class="panelbar">
<div class="paneltext"">BOO REPORT</div>
</div>
<br />
<label>BOO No : </label> <select name="<%=BOO_NO%>">
	<option value="0">Select</option>
	<%
	for (StoreBoo storeBoo : booList) {
	%>
	<option value="<%=storeBoo.getBooNo()%>"><%=storeBoo.getBooNo() %></option>
	<%
	}
	%>
</select> <input type="button" name="add" id="addbutton" value="Print Report"
	class="button"
	onClick="submitForm('grnReport','stores?method=printBooReport');"
	accesskey="g" tabindex=1 />
</div>






