
<%@ page import="java.util.*" %>
<%@page import="jkt.hms.masters.business.FaMasAccountSubGroup"%>
<script type="text/javascript" language="javascript" src="/erp/jsp/js/proto.js"></script>
<link href="/erp/jsp/css/style.css" rel="stylesheet" type="text/css"/>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<FaMasAccountSubGroup> subGroupList= new ArrayList<FaMasAccountSubGroup>();
if(map.get("subGroupList") != null){
	subGroupList = (List)map.get("subGroupList");
	
}

%>
<label> Account Sub Group Name <span>*</span> </label>
<select name="subGroupName" id="subGroupName" validate="SubGroup,string,yes"  tabindex=1>
<%	if(subGroupList.size() !=0){%>
	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = subGroupList.iterator(); iterator.hasNext();) {
					 FaMasAccountSubGroup subgroup = (FaMasAccountSubGroup) iterator.next();
				  %>
				  <option value="<%=subgroup.getId()%>"><%=subgroup.getAccountSubGroupName()%></option>
				  <%
				  	 	}
				   %>
		
	<%}else{%>
	<option value="0">Select</option>
	
	<%} %>
	</select>
