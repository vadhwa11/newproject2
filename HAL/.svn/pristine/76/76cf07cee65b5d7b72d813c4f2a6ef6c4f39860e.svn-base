
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<%
	Map map = new HashMap();
	List<StoreIndentM> indentMList= new ArrayList<StoreIndentM>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if(map.get("indentMList")!=null)
		indentMList=(List) map.get("indentMList");
	%>


<div id="contentspace">
<form name="printIndentDepot" method="post"><br />
<label class="bodytextB_blue">Indent No:</label> <select
	name="<%= RequestConstants.INDENT_NO%>">
	<option value="0">Select</option>
	<%
					for (StoreIndentM storeIndentM :indentMList ) {
				%>

	<option value=<%=storeIndentM.getId()%>><%=storeIndentM.getIndentNo()%></option>

	<%
					}
				%>
</select> <input type="button" name="print" value="Print" class="button"
	onClick="submitForm('printIndentDepot','stores?method=printIndentSoc');" />
</form>
</div>