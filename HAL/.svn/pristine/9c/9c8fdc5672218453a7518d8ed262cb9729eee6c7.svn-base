<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForDischarge.jsp  
 * Purpose of the JSP -  This is for Response Discharge.
 * @author  Abha
* Create Date: 27th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>


<%@ page import="java.util.*"%>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<script>

 </script>


<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	
	
	
	boolean flag=false;
	if(map.get("flag") != null)
	{
	flag=(Boolean)map.get("flag");	
	System.out.println("flag in res "+flag);
	}
	System.out.println("flag in respo "+flag);
	
%>
<div id=flagDiv>

<input type="hidden" name="existGrnNo" id="existIndentNo" value="<%=flag%>">	
</div>

