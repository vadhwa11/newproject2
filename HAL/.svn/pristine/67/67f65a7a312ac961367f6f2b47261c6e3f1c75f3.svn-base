
<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * index.jsp  
 * Purpose of the JSP -  This is for index.
 * @author  Mansi
 * @author  Deepali
 * Create Date: 11th Jan,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>
<%@ page errorPage="error.jsp"%>
<%@ page import="java.util.Map"%>
<%@ page import="jkt.hms.masters.business.MasApplication"%>

<%@ include file="header.jsp"%>
<div class="clear"></div>
<%
        Map mainMap=(Map)request.getAttribute("map");
		String contentJsp="";
		if(mainMap.get("contentJsp") != null){
			contentJsp = (String)mainMap.get("contentJsp").toString();
%>


<%@ include file="navigation1.jsp"%>
<div class="clear"></div>
<jsp:include page="<%=contentJsp%>" flush="true" />
<%
		}
		else{ %>
<jsp:include page="newDefault.jsp" flush="true" />
<%
}
%>
<script type="text/javascript">
var formlist = document.getElementsByTagName("form");
	if(formlist.length > 0)
	{
		for(var i=0; i<formlist.length; i++)
		{
			var ele = document.createElement("input");
   		ele.setAttribute("id","csrfToken");
   		ele.setAttribute("name","csrfToken");
   		ele.setAttribute("type","hidden");
   		ele.setAttribute("value","<%=session.getAttribute("csrfToken")%>");
   		
			formlist[i].appendChild(ele);
   	}
}
//var prev_handler = window.onload;
window.onload = function(){
	//if (prev_handler) {
       // prev_handler();
    //}
   	var formlist = document.getElementsByTagName("form");
   	if(formlist.length > 0)
   	{
   		for(var i=0; i<formlist.length; i++)
   		{
   			var ele = document.createElement("input");
       		ele.setAttribute("id","csrfToken");
       		ele.setAttribute("name","csrfToken");
       		ele.setAttribute("type","hidden");
       		ele.setAttribute("value","<%=session.getAttribute("csrfToken")%>");
       		
   			formlist[i].appendChild(ele);
       	}
    }
}
</script>
<%@ include file="footer.jsp"%>
