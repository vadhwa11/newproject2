<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForAge.jsp  
 * Purpose of the JSP -  This is for Response Age.
 * @author  Ritu
 * Create Date: 30th Jan,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>

<%@ page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	
	String tokenMsg = "";
	if(map.get("tokenMsg") != null){
		tokenMsg = (String)map.get("tokenMsg");
		String tokenNoDisplayflag =null;
		if(map.get("tokenNoDisplayflag") != null)
			tokenNoDisplayflag = (String)map.get("tokenNoDisplayflag");
		
%>


    <label class="value" >
      <%
    if(tokenNoDisplayflag!=null && tokenNoDisplayflag.equalsIgnoreCase("n")){
    String digitOnly = "[0-9]+";
	/* if(tokenMsg.matches(digitOnly))
	{
		out.println("Doctor is available");
	}
	else */
		out.println(tokenMsg);
    }
	else
	{
	  out.println(tokenMsg);	
	}
    
	%>
    
    </label> <input
	id="tokenNoId" type="hidden" name="<%=TOKEN_NO %>"
	value="<%=tokenMsg %>" validate="Token no.,int,no" maxlength="3"
	class="readOnly">
<%}%>