<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * HospitalMasterMain.jsp  
 * Purpose of the JSP -  This is for Hospital Master Main.
 * @author  Mansi
 * @author  Deepali
 * Create Date: 12th Nov,2007 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.*"%>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<title>Main</title>
<div id=contentspace>
<h2 align="left" class="style1">Masters</h2>
<fieldset align="center" style="width: 80%" class="tableBorder">

<legend class="bodytextB">Hospital - Main </legend> <script
	type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script> <%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
	String message = "";

	if (map.get("message") != null && map.get("message") != "")
		message = (String) map.get("message");
	
	String currentDate="";
	String currentTime="";
	currentDate=(String)HMSUtil.getCurrentDateAndTime().get("currentDate");
	currentTime=(String)HMSUtil.getCurrentDateAndTime().get("currentTime");
	
	String viewPage = "enquiryHospital";
	String pojoName = "MasHospital";
	String pojoPropertyName = "HospitalName";
	
	session.setAttribute("viewPage",viewPage);
	session.setAttribute("pojoName",pojoName);
	session.setAttribute("pojoPropertyName",pojoPropertyName);
		 
%>
<form name="hospitalMasterMain" method="post" action="">
<%
            	if(message != null || !(message.equals(""))){
            %> <%}
            %> <br>

<label class="bodytextB_blue">Hospital Code:</label> <input
	id="hospitalCode" name=<%=RequestConstants.HOSPITAL_CODE%> type="text"
	validate='Hospital Code,alphanumeric,no' class="textbox_size20"
	maxlength="8" /></br>
<br>
<label class="bodytextB_blue">Hospital Name:</label> <input
	id="hospitalName" name=<%=RequestConstants.SEARCH_NAME%> type="text"
	validate='Hospital Name,alphaspace,yes' class="textbox_size20"
	maxlength="30" /></br>
<br>
<label class="bodytextB_blue">Address:</label> <input id="hospitalAdd"
	name=<%=RequestConstants.ADDRESS%> type="text" class="textbox_size20"
	validate='Address,address,no' maxlength="50" /></br>
<br>
<label class="bodytextB_blue">Contact N0:</label> <input
	id="hospitalContact" name=<%=RequestConstants.CONTACT_NUMBER%>
	type="text" class="textbox_size20" validate='Contact Number,phone,no'
	maxlength="12" /></br>
<label class="bodytextB_blue">Status :</label> <input
	name="<%=RequestConstants.STATUS  %>" type="radio" class="checkbox"
	value="y" checked="checked" /> <font class="bodytextB_blue">Active</font>
<input type="radio" name="<%=RequestConstants.STATUS %>" value="n"
	class="checkbox" /> <font class="bodytextB_blue">Inactive</font> <br />
<br />
<label class="bodytextB_blue">Changed By:</label> <input type="text"
	name="<%= CHANGED_BY%>" value="<%=userName%>" class="textbox_size20"
	readonly="readonly" MAXLENGTH="8" / tabindex=3 /> <label id=biglabel
	class="bodytextB_blue"> Changed Date:</label> <input type="text"
	name="<%= CHANGED_DATE %>" value="<%=currentDate%>"
	class="textbox_size20" readonly="readonly" tabindex=3 /> <label
	class="bodytextB_blue">Changed Time:</label> <input type="text"
	name="<%=CHANGED_TIME %>" value="<%=currentTime%>"
	class="textbox_size20" readonly="readonly" tabindex=3 /> <br />
<br>

<label>&nbsp;</label><input type="button" name="add" value="Add"
	class="button"
	onclick="submitForm('hospitalMasterMain','/security/security/superAdmin?method=addHospitalMaster','checkBlankForAddHospital');" />

<input type="button" name="update" value="Update" class="button"
	onclick="submitForm('hospitalMasterMain','/security/security/superAdmin?method=showUpdateHospital');" />
<input type="button" name="delete" value="Delete" class="button"
	onclick="submitForm('hospitalMasterMain','/security/security/superAdmin?method=showDeleteHospital');" />
<input type="button" name="enquiry" value="Enquiry" class="button"
	onclick="submitForm('hospitalMasterMain','/security/security/superAdmin?method=showEnquiryJsp');" />
<input type="hidden" name="<%=RequestConstants.CHANGED_BY %>"
	value="<%=userName%>"> <input type="hidden"
	name="<%=RequestConstants.CHANGED_DATE%>" value="<%=currentDate%>">
<input type="hidden" name="<%=RequestConstants.CHANGED_TIME %>"
	value="<%=currentTime%>"> <br />
<br />

</form>
</fieldset>
</div>
