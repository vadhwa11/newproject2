<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * editUser.jsp  
 * Purpose of the JSP -  This is for edit the User.
 * @author  Deepti
 * @author  Ritu  
 * Create Date: 22 Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.3
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page
	import="java.util.*,jkt.hms.masters.business.UserGroups,jkt.hms.masters.business.StatusMaster"%>
<%@page
	import="jkt.hms.masters.business.RoleMaster,jkt.hms.masters.business.HospitalMaster,jkt.hms.masters.business.UsergroupHospital"%>
<%@page
	import="jkt.hms.masters.business.UserHospitalRole,jkt.hms.masters.business.Users,jkt.hms.masters.business.UsergroupHospital"%>




</script>

<html>
<head>
<title>Edit User</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>
<%
    UsergroupHospital usergroupHospitalObj=null;
	Map map = new HashMap();
	map = (Map)request.getAttribute("map");
	session.setAttribute("map",map);
	List roleList=new ArrayList();
    List statusList = new ArrayList();
    List userGroupList= new ArrayList(); 
    Map values=(Map)map.get("values");
	if(map.get("values") != null)
	  {
	   
	    if(values.get("roles") != null)
	        roleList = (List)values.get("roles");
	 
	   
	    if(values.get("status") != null)
	       statusList = (List)values.get("status");
	   
	   if(values.get("usergroups") != null)
	       userGroupList = (List)values.get("usergroups"); 
	       
	  }
	 /* List userGroupList= new ArrayList();
	  if(map.get("usergroupList") != null)
        	userGroupList=(List)map.get("usergroupList");
	*/
	List userHospitalRoleList=new ArrayList();
	if(map.get("userHospitalRoleList") != null)
	  userHospitalRoleList= (List)map.get("userHospitalRoleList");
	  UserHospitalRole userHospitalRoleObj=(UserHospitalRole)userHospitalRoleList.get(0);
	  
	  
	 
	List userList=new ArrayList();	
	if(map.get("userList") != null)
	   userList = (List)map.get("userList");
	   Users usersObj=(Users)userList.get(0);
	 
	
	
     
	List userGroupHospitalList=new ArrayList();	
	if(map.get("userGroupHospitalList") != null)	
	{
      	userGroupHospitalList=(List)map.get("userGroupHospitalList");
      	 usergroupHospitalObj=(UsergroupHospital)userGroupHospitalList.get(0);
     } 	
      	
    	
	
	
%>



<body>
<form name="editUser" method="post"
	action="/hms/hms/login?method=updateUserList">
<h3>EDIT USER DETAILS FORM</h3>
<table width="70%" border="1" align="center">

	<tr>
		<td>First Name</td>
		<td><input type="text" name="firstname"
			value="<%=usersObj.getFirstName()%>"></td>
		<td>Last Name</td>
		<td><input type="text" name="lastname"
			value="<%=usersObj.getLastName ()%>"></td>
		<input type="hidden" name="userId" value="<%=usersObj.getId()%>">
	</tr>

	<tr>
		<td>Login Name</td>
		<td><input type="text" name="loginname"
			value="<%=usersObj.getLoginName ()%>"></td>
		<td>Password</td>
		<td><input type="password" name="password"
			value="<%=usersObj.getPassword ()%>"></td>
	</tr>

	<tr>
		<td>Activation Date</td>
		<td><input type="text" name="adate"
			value="<%=usersObj.getActivationDate ()%>"></td>
		<td>Email ID</td>
		<td><input type="text" name="email"
			value="<%=usersObj.getEmail ()%>"></td>
	</tr>

	<tr>
		<td>Last Login Date</td>
		<td><input type="text" name="logindate"
			value="<%=usersObj.getDateOfLastLogin ()%>"></td>
	</tr>
	<tr>
		<td>User Group</td>
		<td><select name="usergroup">
			<option value=<%=usergroupHospitalObj.getGroupId()%>><%=usergroupHospitalObj.getUserGroup().getGroupName()%></option>
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
			<option value=<%=userHospitalRoleObj.getRoleId()%>><%=userHospitalRoleObj.getRole().getRoleName()%></option>
			<%
                Iterator roleListIterator = roleList.iterator();
				while( roleListIterator.hasNext())
				{
					RoleMaster roleMasterObj = (RoleMaster) roleListIterator.next();
					String name = "";
					name = roleMasterObj.getRoleName ();
     
        %>
			<option value=<%=roleMasterObj.getId()%>><%=name%></option>
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
	type="submit" name="update" value="UPDATE" class="button" /></form>

</body>
</html>
