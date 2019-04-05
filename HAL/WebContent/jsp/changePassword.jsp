<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * changePassword.jsp  
 * Purpose of the JSP -  This is for Country Details.
 * @author  
 * @author  
 * Create Date: 17th september,2008 
 * Revision Date:      
 * Revision By: 
 * @version   
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>




<script>
function displayData(){
 if(document.getElementById("newPwd").value != document.getElementById("conPwd").value){
  alert("please check new password and confirm password are not same");
   return false;
 }
 return true;
}

	function resetpassword(){
	
	 if(document.getElementById("loginName").value == ""){
	   alert("Please select the Login name!!")
	   return false;
	 }
	  if(confirm("Are You sure, You want to Reset Password ?"))
					return true;
				else
					return false;
	}
</script>
<form name="changePassword" method="post" action="">
<% 
  Map map = new HashMap();
  //String message = "";
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	
	ArrayList usersList = (ArrayList)map.get("usersList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
  %> <%
if(map.get("message") != null){
	   String message = (String)map.get("message");
	    	   %> <h4><span><%=message %></span></h4> <% 
	  }

%>
<div class="titleBg">
<h2>Change Password</h2>
</div>
<div class="clear"></div>
<h4>Change Password</h4>
<div class="clear"></div>
<div class="Block">
<%if(userName.equals("admin")){
%> 
<label>Login Name</label> 
<input type="text" id="loginName" name="loginName" onblur="submitProtoAjaxWithDivName('changePassword','superAdmin?method=getEmpNameByLoginName','testdiv')" />
<div id="testdiv">
<label>Employee Name</label> <%}%>
<div class="clear"></div>

<label>Old Password </label> 
<input type="password" value="" id="oldPwd" name="oldPwd"> 
<label>New Password </label> 
<input type="password" value="" id="newPwd" name="newPwd" maxlength="25" />
<label>Confirm Password </label> 
<input type="password" value="" id="conPwd" name="conPwd" maxlength="25" />

<div class="clear"></div>
<input type="button" name="change" onClick="if(displayData()){submitForm('changePassword','superAdmin?method=showChangePassword&action=update');}" value="Submit" class="button"> 
<%if(userName.equals("admin")){%>
<input type="button" name="change" onClick="if(resetpassword()){submitForm('changePassword','superAdmin?method=showChangePassword&action=reset');}" value="Password Reset" class="buttonBig"> 
<%}%>
</div>
</div>
</form>
<div class="clear"></div>

