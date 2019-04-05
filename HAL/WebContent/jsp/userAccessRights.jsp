<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * userAccessRights.jsp  
 * Purpose of the JSP -  This is for User Access Rights.
 * @author  Deepali
 * @author  Mansi
 * Create Date: 23rd Oct,2007 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>


<%@ page import="jkt.hms.masters.business.Users"%>
<%@ page import="java.util.*"%>

<%
Map map = new HashMap();
if(request.getAttribute("map") != null)
map = (Map) request.getAttribute("map");
List userNameList = new ArrayList();
Users users = new Users();
//List userNameList=(List)session.getAttribute("userNameList");
userNameList = (List) map.get("userNameList");
	 Iterator userNameListitr=userNameList.iterator();

String flag = null;
session.setAttribute("flag",flag);
String  userName= null;
String lastName= null;
String loginName= null;
String email= null;

%>


<form name="userAccessRights" action="" method="post"><input
	type="hidden" name="hid" /> <br>
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

		<% while (userNameListitr.hasNext()){
	        	   Users userObject=(Users) userNameListitr.next();
	        	   int userId= userObject.getId();
	        	   
	        	   loginName=userObject.getLoginName();
	        	 
	        	 %>
		<tbody>
			<tr>
				<td><input type="radio" name="userName_details" class=checkbox
					onclick="checked"></td>

				<td>&nbsp;&nbsp;&nbsp;<%=loginName%></td>

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
	<div align="center"><input type="submit" style=""
		name="assignRights" value="Assign Rights" class="button"
		onclick="/security/login?method=addAccessRights" /> <input
		type="submit" style="" name="cancel" value="Cancel" class="button" />
	<input type="reset" style="" name="reset" value="Reset" class="button" />
	<input type="submit" style="" name="view" value="View" class="button" />
	</td>
</tr>



</form>
</div>

</body>

