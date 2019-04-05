<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForGroup.jsp  
 * Purpose of the JSP   This is for Response for Hospital.
 * @author  Mansi
 * Create Date: 17th jun,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.3
--%>


<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.masters.business.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	List<Object> userGroupForHospitalList = new ArrayList<Object>();
	if(map.get("error") != null){
		String error = (String)map.get("error");
%>
<label class="nowidth"><span><%=error%></span></label>
<%		
	}else if(map.get("userGroupForHospitalList") != null){
		userGroupForHospitalList=(List)map.get("userGroupForHospitalList");
%>


<label><span>*</span> Group Name:</label>

<select id="group" name="<%=GROUP_ID %>"
	validate="Group Name,string,yes" class="large2">
	<option value="0">Select</option>
	<%    
	userGroupForHospitalList = (List<Object>)map.get("userGroupForHospitalList");
			UserGroups grpObj = new UserGroups();
			for (Iterator iterator = userGroupForHospitalList.iterator(); iterator.hasNext();) {
			Object[] object = (Object[]) iterator.next();
			grpObj = (UserGroups)object[2];
	   			
   %>
	<option value="<%=grpObj.getId()%>"><%=grpObj.getGroupName()%></option>
	<%	
}
%>
</select>

<%
		}%>




