
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
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
	src="/hms/jsp/js/calendar.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<%
Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
List<MasStoreBrand> searchMasStoreBrandList = new ArrayList<MasStoreBrand>();
if(map.get("searchMasStoreBrandList")!=null)
	searchMasStoreBrandList = (List) map.get("searchMasStoreBrandList");


	
	
	
%>
<div id="contentspace">
<form name="brand" method="post" action=""><br />
<br />
<div class="panelbar">
<div class="paneltext"">Brand Report</div>
</div>
<br />

<label class="bodytextB1">Brand Name:</label> <select
	name="<%=BRAND_NAME%>" validate="Brand,String,no">
	<option value=0>Select</option>
	<%
				for (MasStoreBrand masStoreBrand :searchMasStoreBrandList ) {
				
				%>
	<option value=<%=masStoreBrand.getId()%>><%=masStoreBrand.getBrandName()%>
	</option>
	<%	
					}
				
					
				%>
</select> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="button" name="add"
	id="addbutton" value="Ok" class="button"
	onClick="submitForm('brand','stores?method=generateBrandReport');"
	accesskey="a" tabindex=1 /> <input type="button" name="clear"
	id="clearbutton" value="Clear" class="button"
	onClick="submitForm('brand','stores?method=showBrandReportJsp');"
	accesskey="a" tabindex=1 /></form>
</div>






