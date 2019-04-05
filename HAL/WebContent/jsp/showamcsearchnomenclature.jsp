<%@page import="jkt.hms.util.RequestConstants"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">



<%
	Map<String,Object> map = new HashMap<String,Object>();	
    if (request.getAttribute("map") != null) 
	map = (Map) request.getAttribute("map");
	List<MasStoreItem> nomenclatureList= new ArrayList<MasStoreItem>();
	if(map.get("nomenclatureList")!=null)
	nomenclatureList = (List) map.get("nomenclatureList");
	
%>
<div id="testDiv"><label class="bodytextB2">Nomenclature :</label>
<select name="<%= RequestConstants.NOMENCLATURE%>" class="bigselect"
	onchange="submitProtoAjaxDynamic('amcmaintenancesearch','neStores?method=getSerialNoforSearch',serialDiv);">
	<option value="">Select</option>
	<%
			  	for (MasStoreItem masStoreItem:nomenclatureList ){
			  	
		  	 %>
	<option value="<%=masStoreItem.getId()%>"><%=masStoreItem.getNomenclature()%></option>
	<% } %>
</select></div>
