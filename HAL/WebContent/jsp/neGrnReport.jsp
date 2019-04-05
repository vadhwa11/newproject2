
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreGrnM"%>
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
	List<StoreGrnM> crvNumberList = new ArrayList<StoreGrnM>();
	
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if(map.get("crvNumberList")!=null){
		crvNumberList =(List) map.get("crvNumberList");
		
	}
%>
<div id="contentspace">
<form name="grnReport" id=grnReport method="post" action=""
	target="_blank">

<div class="panelbar">
<div class="paneltext"">CRV REPORT</div>
</div>
<br />
<label class="bodytextB">CRV No: </label> <select name="<%=GRN_NO%>">
	<option value="0">Select</option>
	<%
	for (StoreGrnM storeGrnM : crvNumberList) {
	%>
	<option value="<%=storeGrnM.getGrnNo()%>"><%=storeGrnM.getGrnNo() %></option>
	<%
	}
	%>
</select> <input type="button" name="add" id="addbutton" value="CRV Report"
	class="button"
	onClick="submitForm('grnReport','neStores?method=generateCrvReport');"
	accesskey="g" tabindex=1 />
</div>






