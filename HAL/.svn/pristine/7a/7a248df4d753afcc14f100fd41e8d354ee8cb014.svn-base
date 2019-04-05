<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="java.text.DecimalFormat"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<%
Map<String, Object> map = new HashMap<String, Object>();
DgResultEntryDetail dgResultEntryDetail =new DgResultEntryDetail();

String[] orderStatusMsg = null;
String appendedHtml = "";
Boolean resultEntered = false;

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("orderStatusMsg") != null){
	orderStatusMsg = (String[])map.get("orderStatusMsg");
}
if(map.get("dgResultEntryDetail") != null){
	dgResultEntryDetail = (DgResultEntryDetail)map.get("dgResultEntryDetail");
}
%>
<br />
<%if(orderStatusMsg != null){ 
	for(String msg : orderStatusMsg){%>
<h4><%=msg%> </h4>
<div class="Clear"></div>
<%	}
} %>



<div class="Clear"></div>
<!-- Table Starts -->

<table border="0" cellspacing="0" cellpadding="0">

	<tr>
		<th scope="col">Sl No.</th>
		<th scope="col">Investigation</th>
		<th scope="col">Result</th>
		<th scope="col">UOM</th>
		<th scope="col">Normal Range</th>
	</tr>
	<tr>
		<td>1</td>
		<td><%=dgResultEntryDetail.getInvestigation().getInvestigationName()%></td>
		<% 
    try{
    	if(dgResultEntryDetail.getInvestigation().getMinNormalValue() != null
    		&& dgResultEntryDetail.getInvestigation().getMaxNormalValue() != null){ 
    		Float minValue = Float.parseFloat(dgResultEntryDetail.getInvestigation().getMinNormalValue());
    		Float maxValue = Float.parseFloat(dgResultEntryDetail.getInvestigation().getMaxNormalValue());
    		if(dgResultEntryDetail.getResult() != null 
    				&& !dgResultEntryDetail.getResult().equals("")){

    			Float result1   = Float.parseFloat(dgResultEntryDetail.getResult());
	    		String result = new DecimalFormat("0.##").format((double)result1);
	    		if(result1 <= maxValue && result1 >= minValue ){ %>
		<td><%=result%></td>
		<% }else{ %>
		<td style="color: red; font-weight: bold;"><%=result %></td>
		<% }
    		}else{%>
		<td>No Result Entered</td>
		<%}
	       }else{ %>
		<td><%=dgResultEntryDetail.getResult()%></td>
		<% } 
    }catch(Exception exception){ %>
		<td><%=dgResultEntryDetail.getResult()%></td>
		<% } %>

		<% if(dgResultEntryDetail.getInvestigation().getUom() != null){ %>
		<td><%=dgResultEntryDetail.getInvestigation().getUom().getUomName()%></td>
		<% }else{ %>
		<td>-</td>
		<% } %>
		<% if(dgResultEntryDetail.getInvestigation().getMinNormalValue()  != null && !dgResultEntryDetail.getInvestigation().getMinNormalValue().isEmpty()
    		&& dgResultEntryDetail.getInvestigation().getMaxNormalValue() != null && !dgResultEntryDetail.getInvestigation().getMaxNormalValue().isEmpty()){ 
     		Float minValue1 = Float.parseFloat(dgResultEntryDetail.getInvestigation().getMinNormalValue());
    		Float maxValue1 = Float.parseFloat(dgResultEntryDetail.getInvestigation().getMaxNormalValue());
    		String minValue = new DecimalFormat("0.##").format((double)minValue1);
    		String maxValue = new DecimalFormat("0.##").format((double)maxValue1);
    		%>
		<td><%=minValue%> - <%=maxValue %></td>
		<% }else{ %>
		<td>-</td>
		<% } %>

	</tr>
</table>