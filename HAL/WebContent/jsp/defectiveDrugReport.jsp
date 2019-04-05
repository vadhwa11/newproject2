
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.MasManufacturer"%>

<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.StoreGrnM"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="jkt.hms.masters.business.StoreDefectiveDrugM"%>
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
	List<StoreDefectiveDrugM> defectiveDrugsList = new ArrayList<StoreDefectiveDrugM>();
	
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if(map.get("defectiveDrugsList")!=null){
		defectiveDrugsList =(List) map.get("defectiveDrugsList");
		
	}
%>
<div id="contentspace">
<form name="grnReport" id=grnReport method="post" action="">

<div class="panelbar">
<div class="paneltext"">DEFECTIVE DRUG REPORT</div>
</div>
<br />
<label>Entry No : </label> <select name="<%=ENTRY_NO%>">
	<option value="0">Select</option>
	<%
	for (StoreDefectiveDrugM storeDefectiveDrugM : defectiveDrugsList) {
	%>
	<option value="<%=storeDefectiveDrugM.getEntryNo()%>"><%=storeDefectiveDrugM.getEntryNo() %></option>
	<%
	}
	%>
</select> <input type="button" name="add" id="addbutton" value="Report"
	class="button"
	onClick="submitForm('grnReport','stores?method=printDefectiveDrugJsp');"
	accesskey="g" tabindex=1 />
</div>






