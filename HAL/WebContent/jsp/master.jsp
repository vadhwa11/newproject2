<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * master.jsp  
 * Purpose of the JSP -  This is for Master.
 * @author  Mansi
 * @author  Deepali
 * Create Date: 12th Nov,2007
 * Revision Date:      
 * Revision By: 
 * @version 1.3
--%>

<%@page
	import="java.util.Map,java.util.HashMap,java.text.DateFormat,java.text.SimpleDateFormat"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.AccessRights"%>

<HTML>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>

<% 
Map map = new HashMap();
String errorMsg = "";
String currentDate = "";
String currentTime = "";
String errorMessageForExistence = "";
String message = "";

if(request.getAttribute("map") != null){
	map = (Map)request.getAttribute("map"); 
}

if(map.get("errorMessageForExistence") != null){
	errorMessageForExistence = (String)map.get("errorMessageForExistence");
}

    Map<String,Object> utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	currentDate = (String)utilMap.get("currentDate");
	currentTime = (String)utilMap.get("currentTime");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}

%>
<HEAD>
<TITLE>Hospital Management System</TITLE>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=iso-8859-1">
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
.style1 {
	color: #339900
}

.style2 {
	font-size: 18px
}
-->
</style>
</HEAD>
<BODY BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0
	MARGINHEIGHT=0>
<table width="660" height="427" border="0" align="left" cellpadding="0"
	cellspacing="0">
	<tr>
		<td width="402" height="427" valign="top">
		<h3 class="style1">&nbsp;</h3>

		<h3 class="style1">MASTERS</h3>
		<table width="127%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>
				<div align="right"><span class="bodytextB_blue"><a
					href="/hms/jsp/mainPage.jsp">Home Page</a></span></div>
				</td>
			</tr>
		</table>
		<fieldset style="width: 85%" class="tableBorder"><legend
			class="bodytextB"> - Main</legend>
		<div id="userDetailsForm"><br>
		<form name="frequencyForm" method="post" action=""><input
			type="hidden" name="<%= RequestConstants.VIEW_PAGE %>"
			value="enquiryFrequency"> <input type="hidden"
			name="<%= RequestConstants.POJO_NAME %>" value="FrequencyMaster">
		<input type="hidden" name="<%=RequestConstants.POJO_PROPERTY_NAME %>"
			value="FrequencyName"> <input type="hidden" name="title"
			value="Frequency"> <input type="hidden"
			name="<%=RequestConstants.JSP_NAME %>" value="frequency"> <input
			type="hidden" name="pojoPropertyCode" value="FrequencyCode">

		<table width="182%" height="135" border="0" align="center"
			cellpadding="0" cellspacing="0">
			<tr>
				<td class="bodytextB_blue" width="14%">&nbsp;</td>
				<td class="bodytextB_blue" width="3%">&nbsp;</td>
				<td width="29%">&nbsp;</td>
				<td class="bodytextB_blue" width="30%">&nbsp;</td>
				<td width="24%">&nbsp;</td>
			</tr>
			<%
            	if(errorMessageForExistence != null || !(errorMessageForExistence.equals(""))){
            %>
			<tr>
				<td class="errormsg" align="center" colspan="4" id="existMessage"><%=errorMessageForExistence%></td>
			</tr>
			<%}
            %>
			<tr>
				<tr>
					<td class="bodytextB_blue" width="14%" height="28">&nbsp;</td>
					<td class="bodytextB_blue" width="9%" height="28">&nbsp;</td>
					<td class="bodytextB_blue" width="15%" height="28">Code</td>
					<td class="bodytextB_blue" width="31%" height="28"><input
						id="id" name=<%=RequestConstants.CODE%> type="text"
						validate='Code,alphanumeric,no' class="textbox_size20"
						maxlength="8"></td>
					<td width="31%" height="28">&nbsp;</td>
				</tr>
				<tr>
					<td class="bodytextB_blue" width="14%" height="28">&nbsp;</td>
					<td class="bodytextB_blue" width="9%" height="28">&nbsp;</td>
					<td class="bodytextB_blue" width="15%" height="28">Name</td>
					<td class="bodytextB_blue" width="31%" height="28"><input
						id=<%=RequestConstants.FREQUENCY_NAME%>
						name=<%=RequestConstants.SEARCH_NAME%> type="text"
						validate='Name,alphaspace,yes' class="textbox_size20"
						maxlength="30"></td>
					<td width="31%" height="28">&nbsp;</td>
				</tr>
				<tr>
					<td class="bodytextB_blue" width="14%" height="28">&nbsp;</td>
					<td class="bodytextB_blue" width="3%" height="28">&nbsp;</td>
					<td class="bodytextB_blue" width="29%" height="28">Status</td>
					<td class="bodytextB_blue" width="30%" height="28"><input
						type="radio" name="<%=RequestConstants.STATUS%>" value="y" checked>
					Active <input type="radio" name="<%=RequestConstants.STATUS%>"
						value="n"> Inactive</td>
					<td width="24%" height="28">&nbsp;</td>
				</tr>
				<tr>
					<td class="bodytextB_blue" width="14%">&nbsp;</td>
					<td class="bodytextB_blue" width="3%">&nbsp;</td>
					<td width="29%">&nbsp;</td>
					<td class="bodytextB_blue" width="30%">&nbsp;</td>
					<td width="24%">&nbsp;</td>
				</tr>
				<tr>
					<td class="bodytextB_blue" colspan="5">
					<table width="90%" border="0" cellpadding="0" cellspacing="0"
						align="center">
						<tr>
							<td width="33%" height="21"><span class="bodytextB_blue">
							Changed by : </span></td>
							<td width="35%" height="21"><span class="bodytextB_blue">
							Changed Date :</span></td>
							<td width="32%" height="21"><span class="bodytextB_blue">
							Changed Time :</span></td>
						</tr>
						<tr>
							<td width="33%"><input
								name="<%=RequestConstants.CHANGED_BY%>" type="text"
								class="textbox_size20_disb" value="<%=userName%>"
								readonly="readonly"></td>
							<td width="35%"><input
								name="<%=RequestConstants.CHANGED_DATE%>" type="text"
								class="textbox_size20_disb" value="<%= currentDate%>"
								readonly="readonly"></td>
							<td width="32%"><input
								name="<%=RequestConstants.CHANGED_TIME%>" type="text"
								class="textbox_size20_disb" value="<%= currentTime%>"
								readonly="readonly"></td>
						</tr>
					</table>
					</td>
				</tr>
				<tr>
					<td class="bodytextB_blue" colspan="5">&nbsp;</td>
				</tr>
		</table>
		<br>
		<table width="182%" height="33" border="0" align="center"
			cellpadding="0" cellspacing="0">
			<tr>
				<td class="bodytextB_blue">&nbsp;</td>
				<td colspan="4" class="bodytextB_blue">
				<div align="center"><input type="button" name="add"
					value="Add" class="button"
					onClick="submitForm('frequencyForm','/hms/hms/systemRelatedMaster?method=addFrequency','checkBlankForAdd');" />
				<input type="button" name="update" value="Update" class="button"
					onClick="submitForm('frequencyForm','/hms/hms/common?method=showUpdateMasters&<%=RequestConstants.UPDATE_JSP_NAME %>=updateFrequency');" />
				<input type="button" name="delete" value="Delete" class="button"
					onClick="submitForm('frequencyForm','/hms/hms/common?method=showDeleteMasters&<%=RequestConstants.DELETE_JSP_NAME %>=deleteFrequency');" />
				<input type="button" name="enquiry" value="Enquiry" class="button"
					onClick="submitForm('frequencyForm','/hms/hms/common?method=showEnquiryJsp');" />
				</div>
				</td>
			</tr>
		</table>

		<br>
		</form>
		</div>
		</fieldset>
		</td>
	</tr>
</table>

<script>

</script>
</BODY>
</HTML>