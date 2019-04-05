<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

<link href="css/style.css" rel="stylesheet" type="text/css" />

<form name="demandIssueReport" method="post">
<div class="titleBg">
<h2>Demand Issue Report</h2>
</div>
<div class="clear"></div>
<%
Map<String, Object> map = new HashMap<String, Object>();
List<StoreInternalIndentM> searchStoreInternalIndentMList = new ArrayList<StoreInternalIndentM>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
if(map.get("searchStoreInternalIndentMList")!= null){
	searchStoreInternalIndentMList = (List<StoreInternalIndentM>)map.get("searchStoreInternalIndentMList");
}
String message="";
if(map.get("message")!=null){
	message=(String)map.get("message");
}

%>
<div class="Block">

<label> Demand No  </label>
<select id="demandNo" name="<%=DEMAND_NO%>">

	<%
		for (StoreInternalIndentM mObj :searchStoreInternalIndentMList ) {
	%>
	<option value=<%=mObj.getDemandNo()%>><%=mObj.getDemandNo()%></option>
	<%
		}
	%>
</select>
<div class="clear"></div>
<h4><%=message %></h4>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input name="Button2" type="button" class="button" value="Print" onclick="submitForm('demandIssueReport','/hms/hms/stores?method=printDemandIssueReport')"/>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>