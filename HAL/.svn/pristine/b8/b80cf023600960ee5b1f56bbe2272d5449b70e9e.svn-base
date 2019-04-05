<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * addUser.jsp  
 * Purpose of the JSP - This is the Add User JSP. This is used to add a new User. 
 * @author  Deepali
 * @author  Mansi
 * Create Date: 12th Nov,2007 
 * Revision Date:      
 * Revision By: 
 * @version 1.2  
--%>




<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page
	import="java.util.*,jkt.hms.masters.business.UserGroups,jkt.hms.masters.business.StatusMaster"%>
<%@page
	import="jkt.hms.masters.business.RoleMaster,jkt.hms.masters.business.HospitalMaster,jkt.hms.masters.business.UsergroupHospital"%>

<html>
<head>
<title>Add User</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>
<%
	Map map = new HashMap();
	map = (Map)request.getAttribute("map");
	
	List roleList=new ArrayList();
	if(map.get("roles") != null)
	 roleList = (List)map.get("roles");
	 
	List statusList = new ArrayList();
	if(map.get("status") != null)
	statusList = (List)map.get("status");
	
	
     
	List userGroupList= new ArrayList();
	if(map.get("usergroupList") != null)
    	userGroupList=(List)map.get("usergroupList");
    	
	
%>
<body>
<form name="adduser" method="post"
	action="/hms/hms/login?method=insertData">
<h3>USER DETAILS FORM</h3>
<table width="70%" border="1" align="center">

	<tr>
		<td>First Name</td>
		<td><input type="text" name="firstname"></td>
		<td>Last Name</td>
		<td><input type="text" name="lastname"></td>
	</tr>

	<tr>
		<td>Login Name</td>
		<td><input type="text" name="loginname"></td>
		<td>Password</td>
		<td><input type="password" name="password"></td>
	</tr>

	<tr>
		<td>Activation Date</td>
		<td><input type="text" name="adate"></td>
		<td>Email ID</td>
		<td><input type="text" name="email"></td>
	</tr>
	<tr>
		<td>Current Status</td>
		<td><select name="status">
			<option value="1">--Select--</option>
			<%
                Iterator statusListIterator = statusList.iterator();
				while(statusListIterator.hasNext())
				{
					StatusMaster statusMasterObj = (StatusMaster)statusListIterator.next();
					String name = "";
					name = statusMasterObj.getDescription();
     
       %>
			<option value=<%=statusMasterObj.getId()%>><%=name%></option>
			<%		
   				}
      %>
		</select></td>
		<td>Last Login Date</td>
		<td><input type="text" name="logindate"></td>

		<tr>
			<td>User Group</td>
			<td><select name="usergroup">
				<option value="1">--Select--</option>
				<%
                Iterator userGroupIterator = userGroupList.iterator();
				while(userGroupIterator.hasNext())
				{
					UserGroups userGroupObj = (UserGroups) userGroupIterator.next();
     
 %>
				<option value=<%=userGroupObj.getId()%>><%=userGroupObj.getGroupName()%></option>
				<%		
   				}
    %>
			</select></td>
			<td>User Type</td>
			<td><select name="usertype">
				<option value="1">--Select--</option>
				<%
                Iterator roleListIterator = roleList.iterator();
				while( roleListIterator.hasNext())
				{
					RoleMaster roleMasterObj = (RoleMaster) roleListIterator.next();
     
        %>
				<option value=<%=roleMasterObj.getId()%>><%=roleMasterObj.getRoleName ()%></option>
				<%		
   				}
        %>
			</select></td>

		</tr>
		<tr>
</table>
<br>
<table align="center">
	</tr>
	<div id="contentspace">
	<tr>
</table>
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
	type="submit" name="add" value="Add" class="button" /> <input
	type="reset" name="reset" value="Reset" class="button" /> <input
	type="button" name="back" value="Cancel" class="button"
	onclick="javascript:history.back()" /> <input type="hidden" value="0"
	name="count" /></form>


</body>
</html>
