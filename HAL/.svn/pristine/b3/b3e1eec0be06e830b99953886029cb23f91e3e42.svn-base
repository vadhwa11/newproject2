<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForUserGroupAccessRights.jsp  
 * Purpose of the JSP -  This is for Response for User Group Access Rights.
 * @author  Deepali
 * @author  Mansi
 * Create Date: 23rd Oct,2007 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>


<%@page import="jkt.hms.masters.business.AccessRights"%>
<%@page import="jkt.hms.masters.business.UsergroupAccessrightsHospital"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.RequestConstants"%>

<%

	Map accessRightsMap = new HashMap();
	if(request.getAttribute("map") != null)
		accessRightsMap = (Map) request.getAttribute("map");
	
	List accessRightsToUserGroupList = new ArrayList();
	if(accessRightsMap.get("accessRightsToUserGroupList") != null)
		accessRightsToUserGroupList = (List) accessRightsMap.get("accessRightsToUserGroupList");
		
	List accessRightsList = new ArrayList();
	Iterator itrAccessRights = null;
	
	if(accessRightsMap.get("accessRightsList") != null){
		accessRightsList = (List) accessRightsMap.get("accessRightsList");
		itrAccessRights = accessRightsList.iterator();
	}
	UsergroupAccessrightsHospital usergroupAccessrightsHospital = new UsergroupAccessrightsHospital();
	AccessRights accessRights = new AccessRights();
%>

<table>
	<%
	if(accessRightsToUserGroupList != null && accessRightsToUserGroupList.size() > 0){
		while(itrAccessRights.hasNext()){
			accessRights = (AccessRights) itrAccessRights.next();
			boolean checked = false;
			for (Iterator iter = accessRightsToUserGroupList.iterator(); iter.hasNext();) {
				usergroupAccessrightsHospital = (UsergroupAccessrightsHospital) iter.next();
%>
	<tr>
		<td align="right">
		<%				
				if(accessRights.getId().equals(usergroupAccessrightsHospital.getAccessId())){
					checked = true;
				}else{
					checked = false;
				}

				if(checked == true)
					break;
			}
			if(checked == true){
%> <input type="checkbox" name=<%=RequestConstants.ACCESS_RIGHTS%>
			value="<%=accessRights.getId()%>" checked="checked"> <%
			}else{
%> <input type="checkbox" name=<%=RequestConstants.ACCESS_RIGHTS%>
			value="<%=accessRights.getId()%>"> <%
			}
%>
		</td>
		<td align="left" class="bodytextB_blue"><%=accessRights.getDescription() %>
		</td>
	</tr>

	<%
		}
	}else{
		while(itrAccessRights.hasNext()){
			accessRights = (AccessRights) itrAccessRights.next();
%>
	<tr>
		<td align="right"><input type="checkbox"
			name=<%=RequestConstants.ACCESS_RIGHTS%>
			value="<%=accessRights.getId()%>"></td>
		<td align="left" class="bodytextB_blue"><%=accessRights.getDescription() %>
		</td>
	</tr>
	<%
		}
	}
%>
</table>