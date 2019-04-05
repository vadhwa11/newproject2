<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * message.jsp  
 * Purpose of the JSP -  This is for Message.
 * @author  Mansi
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>
<%@page import="java.util.HashMap"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<% 

	Map<String,Object> map = new HashMap<String,Object>();
	String message="";
	String url="";
	String combinedIds = "";
	String nextCombinedIds = "";
	String OrderNo="";
	String formSubmitFrom ="HAL";
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");

	}
	if(map.get("messageTOBeVisibleToTheUser") !=null){
		message=""+map.get("messageTOBeVisibleToTheUser");
	}
	if(map.get("url") !=null){
		url=""+map.get("url");
	}
	
	if(map.get("CombinedIds") != null){
		combinedIds = (String)map.get("CombinedIds");
	}
	if(map.get("nextCombinedIds") != null){
		nextCombinedIds = (String)map.get("nextCombinedIds");
	}
	if(map.get("order_no") != null){
		OrderNo = (String)map.get("order_no");
	}
	
	if(map.get("formSubmitFrom") != null){
		formSubmitFrom = (String)map.get("formSubmitFrom");
	}
	
%>
<script type="text/javascript">
function checkTargetForYesTemp(){
	var aTags = document.getElementsByTagName('input');
	for (i=0; i < aTags.length; i++) {
			aTags[i].setAttribute("target", "_blank");
		}
	return true;
}
</script>
<form name="message" method="post" target="_blank"><br />
<h4><%=message %></h4>
<div class="Clear"></div>

<input type="hidden" name="combinedIds" id="combinedIds"	value="<%=combinedIds%>" /> 
<input type="hidden"	name="nextCombinedIds" id="nextCombinedIds"	value="<%=nextCombinedIds%>" />
<input type="hidden"	name="formSubmitFrom" id="formSubmitFrom"	value="<%=formSubmitFrom%>" />  
<input type="button" name="yes"	value="HTML" id="buttonTemplate" class="button"	onclick="submitForm('message','/hms/hms/investigation?method=showPrintResultEntryForLab');" />
<!--<input type="button" name="yes"	value="PDF" id="buttonTemplate" class="button"	onclick="submitForm('message','/hms/hms/lab?method=generatePrintResultForLab&OrderNo=<%=OrderNo %>')" />-->
<input type="button" name="no" value="No" class="button"	onClick="submitForm('message','<%=url%>','checkTargetForNo');" />
<!--<input	type="button" name="next" value="Next" class="button"	onclick="submitForm('message','/hms/hms/investigation?method=nextForResultEntryLab','checkTargetForNo');" />-->
<!-- <input type="button" value="ResultValidation" class="cmnButton" onClick="submitFormForButton('message','/hms/hms/investigation?method=showPendingForResultValidationJsp','checkTargetForNo');" />  -->

</form>
