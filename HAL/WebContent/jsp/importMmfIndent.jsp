<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" src="/hms/jsp/js/proto.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<%
Map<String,Object> map=new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
}
	List list=new ArrayList();
	if(map.get("list")!=null)
	 list = (List) map.get("list");
%>

<%@page import="jkt.hms.util.RequestConstants"%>
<div id="contentspace">

<form name="importForm" method="post"><br />
<h2 align="left" class="style1">Import MMF Indent</h2>

<h2 align="left" class="style1">
<div id="importMessage"></div>
</h2>
<label class="bodytextB_blue"><font id="error"></font>MMF Year:</label>
<select name="<%= RequestConstants.MMF_FOR_THE_YEAR%>"
	validate="MMF Year,num,Yes">
	<option value="0">Select</option>
	<%
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				Object object = (Object) iterator.next();
				Integer i0 = (Integer.parseInt(object.toString()));
				
				 %>
	<option value=<%=i0%>><%=i0%></option>
	<%} %>
</select> <input name="" type="button" value="Import" class="button"
	onclick="importingMmfIndent('importForm','stores?method=importMMFIndent');">
<input type="button" value="Back" class="button"
	onClick="submitForm('importForm','/hms/hms/stores?method=showIndentJsp');" />
</form>
</div>