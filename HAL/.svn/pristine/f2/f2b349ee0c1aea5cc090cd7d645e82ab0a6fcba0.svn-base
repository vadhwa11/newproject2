<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * messageForMaster.jsp  
 * Purpose of the JSP -  This is for Master Message.
 * @author  vikas	 
 * Create Date: 30th Jan,2008 
 * Revision Date:      
 * Revision By: 			
 * @version 1.6
--%>

<%@ page import="java.util.*"%>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>

<% 	
		Map map = new HashMap();
		String message = "";
		String url = "";
		String title = "";
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		if( map.get("message") != null){	
			message = (String) map.get("message");
		}
		if( map.get("url") != null){	
			url = (String) map.get("url");
		}
		if( map.get("title") != null){	
			title = (String) map.get("title");
		}
	%>

<div id="contentspace">
<form name="messsage" method="post" action="">
<table width="537" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td width="402" valign="top">
		<h3 class="style1"><%=title %></h3>
		<fieldset style="width: 85%" class="tableBorder"><legend
			class="bodytextB"><%=title%></legend>
		<table width="182%" height="33" border="0" align="center"
			cellpadding="0" cellspacing="0">
			<tr>
				<td><%=message%></td>
			</tr>
		</table>
		<br />
		<input type="button" class="button" value="Back" align="center"
			onClick="submitForm('messsage','superAdmin?method=showHospitalMasterJsp');" />
		</fieldset>
		</td>
	</tr>
</table>
</form>
</div>

