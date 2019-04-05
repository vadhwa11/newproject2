
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<%
	Map map = new HashMap();

	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<String> prescriptionList = new ArrayList<String>();
	if(map.get("prescriptionList")!=null){
		prescriptionList = (List<String>)map.get("prescriptionList");
	}
	%>
	<div class="clear"></div>
	<table width="100%" border="0" cellpadding="2" cellspacing="2"	class="grid_header">


	<thead>
		<tr>
			<th>Treatment</th>
			<th>Discharge Summary</th>
		</tr>
	</thead>
	<%
	int i=1;
	if(prescriptionList.size() > 0){
	
	for(int j=0;j<prescriptionList.size();j++){
%>
<tr>
	<td><%=prescriptionList.get(j) %>
	<input type="hidden" name="treatment<%=i %>" id="treatment<%=i %>" value="<%=prescriptionList.get(j)  %>" />
	</td>
<td><input type="checkbox" name="ds<%=i %>" id="ds<%=i %>" value="y" /></td>
</tr>
<% i++;} %>


<%}else{ %>
<tr><td>No Data</td>
<td>&nbsp;</td>
</tr>

<%} %>
</table>
	<input type="hidden" value="<%=i-1 %>" name="hiddenValue" id="hiddenValue" />
<div class="clear"></div>
<input type="button" name="ok" value="Ok" onclick="setValuesInParent();" class="button"/>	
	
<script>
function setValuesInParent(){
	var count = document.getElementById('hiddenValue').value;
	var treatment = ''; 
	for(var i = 1;i<=count;i++){
		if(document.getElementById('ds'+i) && document.getElementById('ds'+i).checked){
			if(treatment!=''){
				treatment += ",\n";
			}
			treatment +=(document.getElementById('treatment'+i).value);
			

		}
	}
	window.opener.document.getElementById('treatment').value = treatment;
	window.close();
}

</script>
	