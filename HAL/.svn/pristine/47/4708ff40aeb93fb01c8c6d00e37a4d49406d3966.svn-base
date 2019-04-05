<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<%

List<StoreIndentM> storeIndentMList= new ArrayList<StoreIndentM>();
Map<String,Object> map=new HashMap<String,Object>();

if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
}
	List list=new ArrayList();
if(map.get("storeIndentMList")!=null)
	storeIndentMList = (List) map.get("storeIndentMList");
%>

<%@page import="jkt.hms.util.RequestConstants"%>
<div id="contentspace">

<form name="importForm" method="post"><br />
<h2 align="left" class="style1">Lock MMF Indent</h2>
<label class="bodytextB_blue"><font id="error"></font>Lock MMF
Indent:</label> <select name="<%= RequestConstants.MMF_FOR_THE_YEAR%>"
	validate="MMF Year,num,Yes">
	<option value="0">Select</option>
	<%
			for(StoreIndentM storeIndentM:storeIndentMList){
				 %>
	<option value="<%=storeIndentM.getId() %>"><%=storeIndentM.getMmfForTheYear() %></option>
	<%} %>
</select> <input name="" type="button" value="Lock" class="button"
	onclick="submitForm('importForm','stores?method=lockMMFIndent');">
</form>
</div>