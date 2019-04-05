<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForDischarge.jsp  
 * Purpose of the JSP -  This is for Response Discharge.
 * @author  Abha
* Create Date: 27th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>


<%@ page import="java.util.*"%>
<%@page import="jkt.security.util.RequestConstants"%>
<%@page import="jkt.security.masters.business.UsergroupHospital"%>
<%@page import="jkt.security.util.RequestConstants"%>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/addRow.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<script>
 var flag;
 </script>

<%
	Map map = new HashMap();
	List<UsergroupHospital> groupList= new ArrayList<UsergroupHospital>();

	if(request.getAttribute("map") != null)
	{
		map = (Map)request.getAttribute("map");
		groupList=(List)map.get("second_combo");
		
	}
%>



<label class="bodytextB">Group Name</label>
<select id="groupId" name="<%=RequestConstants.GROUP_ID%>"
	class="bigselect" tabindex=1 validate="Group Name,string,yes">
	<option value=""><--select Group Name--></option>
	<!-- to display hospital list -->
	<%
		for (UsergroupHospital usergroupHospital :groupList ) {
		%>
	<option value=<%=usergroupHospital.getGroup().getId()%>><%=usergroupHospital.getGroup().getGroupName()%></option>
	<%}
	%>
	<!--  end of for loop -->
</select>


