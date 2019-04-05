<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.StoreFyDocumentNo"%>

<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script>
 var flag;
 </script>

<%
	Map map = new HashMap();
List<MasHospital> hospitalList = new ArrayList<MasHospital>();
List<StoreFyDocumentNo> departmentList = new ArrayList<StoreFyDocumentNo>();
	String choice = "";

	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

		}

		if(map.get("hospitalList")!=null)
		{
			hospitalList=(List)map.get("hospitalList");
		}
		
		if(map.get("departmentList")!=null)
		{
			departmentList=(List)map.get("departmentList");
		}
		
		
		%>
<div id="DeptDiv">
<select name="assignDept" id="assignDept"  multiple="multiple" size="3" class="listBig3">
    <%
       for(StoreFyDocumentNo md:departmentList){
    	   %>
       <option value="<%=md.getDepartment().getId() %>"><%=md.getDepartment().getDepartmentName()%></option>
       
       <%} %>
</select>

</div>