<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * indentSocTracker.jsp  
 * Purpose of the JSP -  This is for maintain the status of Soc Indent
 * Table  store_indent_soc_tracker
 * @author  Vivek
 * Create Date: 25th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.Map"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="jkt.hms.masters.business.StoreIndentT"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" src="/hms/jsp/js/proto.js"></script>
<script>
<%

	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>

<%
	Map<String,Object> map = new HashMap<String,Object>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	
	if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
	}
	if(map.get("departmentList")!=null)
		departmentList=(List<MasDepartment>)map.get("departmentList");
	
	
	String userName = "";
	String time="";
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 date = (String)utilMap.get("currentDate");	 
	 time = (String)utilMap.get("currentTime");
	 if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
%>

<script> var nameArray=new Array(); </script>

<div id="contentspace"><%-- Start of contentspace div--%>
<form name="indentSocTracker" method="post"><br />
<div class="Block">
<h2 align="left" class="style1">DGAFMS Indent(Soc) Tracker</h2>

<table class="tborder" width="100%" align="center">
	<tr>
		<td width="20%" nowrap="nowrap" class="vbmenu_control"
			id="threadsearch"><a href="">Search</a></td>
		<td width="80%"><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>
		<table width="20%" align="right" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="5%"><IMG SRC="/hms/jsp/images/toolBar_01.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
				<td width="7%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Add" value="Add" class="toolbutton"
					onclick="submitForm('indentSocTracker','/hms/hms/stores?method=addOrUpdateIndentSocTracker&buttonType=add')"></td>
				<td width="1%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="10%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Modify" type="submit" value="Modify"
					class="toolbutton"
					onClick="submitForm('indentSocTracker','/hms/hms/stores?method=addOrUpdateIndentSocTracker&buttonType=update');"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Reset" type="submit" value="Reset"
					class="toolbutton"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Delete" type="submit" value="Delete"
					class="toolbutton"></td>
				<td width="4%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="print" type="submit" class="toolbutton"
					value="Print" onClick=""></td>
				<td width="39%"><IMG SRC="/hms/jsp/images/closeButton.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<br />
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">SOC Tracker Details :</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 30px; background-color: #f4f9fe; padding-top: 10px; padding-bottom: 5px;">


<label class="bodytextB"><font id="error"></font>Department :</label> <select
	name="<%= RequestConstants.DEPARTMENT_ID%>" tabindex="1"
	onchange="submitProtoAjaxDynamic('indentSocTracker','stores?method=getIndentListForSocTracker&departmentIdTemp='+this.value,'indentDiv');"
	id="departmentId">
	<option value="0">Select</option>
	<%for (MasDepartment dept :departmentList ) {%>
	<option value=<%=dept.getId()%>><%=dept.getDepartmentName()%></option>
	<%}%>

</select> <label class="bodytextB"><font id="error"></font>Indent no :</label>
<div id="indentDiv"><select
	name="<%= RequestConstants.INDENT_ID%>" tabindex="1" id="indentId">
	<option value="0">Select</option>
</select></div>
<label class="bodytextB"><font id="error"></font>Nomenclature :</label>
<div id="itemDiv"><select
	name="<%= RequestConstants.NOMENCLATURE%>" tabindex="1"
	class="bigselect" id="nomenclature">
	<option value="0">Select</option>
</select></div>

</div>

<div id="testDiv"><%-- Start of testDiv div--%>



<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 180px; background-color: #f4f9fe; padding-top: 10px; padding-bottom: 5px;">




<input type="hidden" name="INDENT_SOC_TRACKER_ID" value="0"> <label
	class="bodytextB"><font id="error"></font>Pres. Status :</label> <textarea
	name="<%=RequestConstants.PRESENT_STATUS%>" rows="2" cols="30"
	class="txtarea"></textarea> <label class="bodytextB"><font
	id="error"></font>Remarks :</label> <textarea
	name="<%=RequestConstants.REMARKS%>" rows="2" cols="30" class="txtarea"></textarea>

<label class="bodytextB"><font id="error"></font>Forward to TC :</label>
<textarea name="<%=RequestConstants.FORWARD_TO_TC%>" rows="2" cols="30"
	class="txtarea"></textarea> <br />

<label class="bodytextB"><font id="error"></font>SOC Sr. NO. at
AIRHQ :</label> <textarea name="<%=RequestConstants.SOC_SR_NO_AT_AIRHQ%>"
	rows="2" cols="30" class="txtarea"></textarea> <label class="bodytextB"><font
	id="error"></font>Forward TC to AIRHQ :</label> <textarea
	name="<%=RequestConstants.FORWARD_TC_TO_AIRHQ%>" rows="2" cols="30"
	class="txtarea"></textarea> <label class="bodytextB"><font
	id="error"></font>Forward AIRHQ to DGAFMS :</label> <textarea
	name="<%=RequestConstants.FORWARD_AIRHQ_TO_DGAFMS%>" rows="2" cols="30"
	class="txtarea"></textarea> <br />
<label class="bodytextB"><font id="error"></font>Date of SOC
forward :</label> <input type="text"
	name="<%= RequestConstants.DATE_OF_SOC_FORWARD %>" class="textbox_date"
	MAXLENGTH="30" / tabindex=1 validate="Date of SOC forward,String,Yes" />

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('<%=date%>',document.indentSocTracker.<%=RequestConstants.DATE_OF_SOC_FORWARD%>,event)" />



</div>

<br />

<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid; BORDER-LEFT: #9A9A9A 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Item Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>
<br />
<table width="200px" colspan="7" id="indentDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<td width="3%"><label valign="left" class="gridsmlabel">SR
			No</label></td>
			<td width="15%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="15%"><label valign="left" class="smalllabel">Nomenclature</label>
			</td>
			<td width="3%"><label valign="left" class="gridsmlabel">A/U</label>
			</td>
			<td width="4%"><label valign="left" class="smalllabel">Stock
			in</label></td>
			<td width="15%"><label valign="left" class="smalllabel">Qty
			Demand</label></td>
			<td width="45%"><label valign="left" class="smalllabel">Unit
			Rate</label></td>

		</tr>
	</thead>
	<tbody>
		<tr>
			<td width="3%"><input type="text" class="smcaption" value=""
				size="4" readonly="readonly" /></td>
			<td width="15%"><input type="text" value="" class="medcaption"
				readonly="readonly" /></td>
			<td width="15%"><input type="text" value="" class="bigcaption"
				readonly="readonly" /></td>
			<td width="3%"><input type="text" class="smcaption" value=""
				size="4" readonly="readonly" /></td>
			<td width="4%"><input type="text" class="medcaption" value=""
				size="4" readonly="readonly" /></td>
			<td width="15%"><input type="text" value="" class="medcaption"
				readonly="readonly" /></td>
			<td width="45%"><input type="text" value="" class="medcaption"
				readonly="readonly" /></td>
		</tr>
	</tbody>
</table>
<br />
<label class="bodytextB">Changed By:</label>
<div class="changebydt"><%=userName%></div>

<label class="bodytextB">Changed Date:</label>
<div class="changebydt"><%=date%></div>

<label class="bodytextB">Changed Time:</label>
<div class="changebydt"><%=time%></div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
	</div>
<%-- End of testDiv div--%></form>
</div>
<%-- End of contentspace div--%>