<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * registration_message.jsp  
 * Purpose of the JSP -  This is for Registration Message .
 * @author  Deepti
 * @author  Ritu
 * Create Date: 24th Sep,2007 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>

<div id="contentspace">

<form name="registrationByStaffMessage" method="post" action="">

<%@ page import="java.util.Map"%> <%  
	
		String message = "There were no message specified.";
	    	    
	    Map map=(Map)request.getAttribute("map");
	    if(!map.isEmpty()){
	     message = (String)map.get("message");
		}%>
<h2><font id="error"> <%=message%> </font></h2>

<input type="button" name="visitFirst" value="First Visit"
	class="button"
	onClick="submitForm('registrationByStaffMessage','contentspace','/hms/hms/visit?method=showFirstVisitJsp')"
	accesskey="r" />
</div>

</form>