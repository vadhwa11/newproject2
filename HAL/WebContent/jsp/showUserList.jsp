<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * showUserList.jsp  
 * Purpose of the JSP -  This is show User list.
 * @author  Deepali
 * @author  Mansi
 * Create Date: 12th Nov,2007 
 * Revision Date:      
 * Revision By:  
 * @version 1.3
--%>

<%@  page import="jkt.hms.masters.business.Users"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.HospitalMaster"%>
<%@ page import="jkt.hms.util.RequestConstants"%>

</script>
<script>
function deleteUserGroupConfirmation(formName,action){
		if(confirm("Are you sure to delete this User Group? ")){
			deleteUserGroup(formName,action);
		}else {
			return false;
		}
	}
	
	function deleteUserGroup(formName,action){
		obj = eval('document.'+formName)
    	if(obj){
        	obj.action = action;
        	alert(obj.action)
       	    obj.submit();
    	}
    	else
	       	return false;	

       	return true;
	}
</script>

<%
    Map map = new HashMap();
    map = (Map) request.getAttribute("map");
    List userNameList = new ArrayList();
    if(map.get("userList") != null)
        userNameList = (List) map.get("userList");
    
     Users users = new Users();    
     Iterator userNameListitr=userNameList.iterator();

     String flag = null;
     session.setAttribute("flag",flag);
     String  userName= null;
     String lastName= null;
     String loginName= null;
     String email= null;

%>


<form name="userList" action="/hms/hms/login?method=editUserList"
	method="post"><input type="hidden" name="hid" /> <br>
<br>
<br>
<table width="38%" height="195" border="1" align="center">
	<thead>
		<tr>

			<td width="15"></td>

			<td>First Name</td>
			<td>Last Name</td>
			<td>Login Name</td>
			<td>Email Id</td>

		</tr>

	</thead>



	<tbody>

		<% 
            int userId= 0;
            while (userNameListitr.hasNext()){
             Users userObject=(Users) userNameListitr.next();
            	userId= userObject.getId();
             userName= userObject.getFirstName();
             lastName =userObject.getLastName();
             loginName=userObject.getLoginName();
             email=userObject.getEmail();
           
           %>
		<tbody>
			<tr>
				<td><input type="radio" name="userNameList" class=checkbox
					onclick="checked" value="<%=userId%>"></td>
				<td>&nbsp;&nbsp;&nbsp;<%=userName%></td>
				<td>&nbsp;&nbsp;&nbsp;<%=lastName%></td>
				<td>&nbsp;&nbsp;&nbsp;<%=loginName%></td>
				<td>&nbsp;&nbsp;&nbsp;<%=email%></td>

				<% 
            }
            %>
			
		</tbody>
</table>

<label>&nbsp;&nbsp;&nbsp;&nbsp;</label> <a name="bottom"></a><br />
<table>
	<tr>

		<tr>
		</tr>
		<tr>
		</tr>
		<tr>
		</tr>
		<tr>
		</tr>
</table>
<br>


<br>
<br>
<br>
<br>
<br>
<tr>
	<td colspan="4">
	<div align="center"><input type="submit" style="" name="editUser"
		value="Edit User" class="button" /> <input type="submit" style=""
		name="cancel" value="Cancel" class="button" /> <input type="reset"
		style="" name="reset" value="Reset" class="button" /> <input
		type="submit" style="" name="view" value="View" class="button" /> <input
		type="button" name="delete" value="Delete" class="button"
		onclick="return deleteUserGroupConfirmation('userList','/hms/hms/login?method=deleteUserFromList&userId='+<%=userId%>)" />
	</td>
</tr>



</form>
</div>

</body>