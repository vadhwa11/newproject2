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
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="jkt.hms.masters.business.StoreIndentT"%>
<%@page import="jkt.hms.masters.business.StoreIndentSocTracker"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Iterator"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/actb.js"></script>
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
	List<StoreIndentSocTracker> storeIndentSocTrackerList = new ArrayList<StoreIndentSocTracker>();
	List<MasStoreItem> masStoreItemList= new ArrayList<MasStoreItem>();
	List<StoreIndentT> storeIndentTList= new ArrayList<StoreIndentT>();
	List objectList=new ArrayList();
	if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
	}
	if(map.get("storeIndentSocTrackerList")!=null)
		storeIndentSocTrackerList=(List<StoreIndentSocTracker>)map.get("storeIndentSocTrackerList");
	if(map.get("storeIndentTList")!=null)
		storeIndentTList=(List<StoreIndentT>) map.get("storeIndentTList");
	if(map.get("objectList")!=null)
		objectList=(List) map.get("objectList");
	String time="";
	String userName = "";
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 date = (String)utilMap.get("currentDate");	 
	 time = (String)utilMap.get("currentTime");
	 if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
	 String currentDate = (String)utilMap.get("currentDate");
%>

<script>
var nameArray=new Array();

</script>




<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 180px; background-color: #f4f9fe; padding-top: 10px; padding-bottom: 5px;">



<%
				if(storeIndentSocTrackerList.size()!=0)
				for(StoreIndentSocTracker storeIndentSocTracker:storeIndentSocTrackerList){
				%> <input type="hidden" name="INDENT_SOC_TRACKER_ID"
	value="<%=storeIndentSocTracker.getId()%>"> <label
	class="bodytextB"><font id="error"></font>Present Status :</label> <textarea
	name="<%=RequestConstants.PRESENT_STATUS%>" tabindex="1" rows="2"
	cols="30" MAXLENGTH="150" class="txtarea"><%=storeIndentSocTracker.getPresentStatus() %></textarea>

<label class="bodytextB"><font id="error"></font>Remarks :</label> <textarea
	name="<%=RequestConstants.REMARKS%>" tabindex="1" rows="2" cols="30"
	MAXLENGTH="250" class="txtarea"><%=storeIndentSocTracker.getRemarks() %></textarea>

<label class="bodytextB"><font id="error"></font>Forward to TC :</label>
<textarea name="<%=RequestConstants.FORWARD_TO_TC%>" tabindex="1"
	rows="2" MAXLENGTH="150" cols="30" class="txtarea"><%=storeIndentSocTracker.getForwardToTc() %></textarea>
<br />

<label class="bodytextB"><font id="error"></font>SOC Sr. NO. at
AIRHQ :</label> <textarea name="<%=RequestConstants.SOC_SR_NO_AT_AIRHQ%>"
	tabindex="1" MAXLENGTH="250" rows="2" cols="30" class="txtarea"><%=storeIndentSocTracker.getSrNoAtAirhq() %></textarea>

<label class="bodytextB"><font id="error"></font>Forward TC to
AIRHQ :</label> <textarea name="<%=RequestConstants.FORWARD_TC_TO_AIRHQ%>"
	tabindex="1" rows="2" MAXLENGTH="150" cols="30" class="txtarea"><%=storeIndentSocTracker.getForwardTcToAirhq() %></textarea>

<label class="bodytextB"><font id="error"></font>Forward AIRHQ
to DGAFMS :</label> <textarea
	name="<%=RequestConstants.FORWARD_AIRHQ_TO_DGAFMS%>" tabindex="1"
	rows="2" MAXLENGTH="150" cols="30" class="txtarea"><%=storeIndentSocTracker.getForwardAirhqToDgafms() %></textarea>
<br />
<label class="bodytextB"><font id="error"></font>Date of SOC
forward :</label> <%
				String date4MySQL ="";
				if(storeIndentSocTracker.getDateOfSoc() !=null){
					SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
				 SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
				  date4MySQL=formatterOut.format(formatterIn.parse(""+storeIndentSocTracker.getDateOfSoc())); } %>

<input type="text" name="<%= RequestConstants.DATE_OF_SOC_FORWARD %>"
	value="<%=date4MySQL%>" class="textbox_date" MAXLENGTH="30"
	/ tabindex=1 validate="Date of SOC forward,String,Yes" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.indentSocTracker.<%=RequestConstants.DATE_OF_SOC_FORWARD%>,event)" />

<%}else{%> <input type="hidden" name="INDENT_SOC_TRACKER_ID" value="0">
<label class="bodytextB"><font id="error"></font>Present Status
:</label> <textarea name="<%=RequestConstants.PRESENT_STATUS%>" tabindex="1"
	rows="2" cols="30" class="txtarea"></textarea> <label class="bodytextB"><font
	id="error"></font>Remarks :</label> <textarea
	name="<%=RequestConstants.REMARKS%>" tabindex="1" rows="2" cols="30"
	class="txtarea"></textarea> <label class="bodytextB"><font
	id="error"></font>Forward to TC :</label> <textarea
	name="<%=RequestConstants.FORWARD_TO_TC%>" tabindex="1" rows="2"
	cols="30" class="txtarea"></textarea> <br />

<label class="bodytextB"><font id="error"></font>SOC Sr. NO. at
AIRHQ :</label> <textarea name="<%=RequestConstants.SOC_SR_NO_AT_AIRHQ%>"
	tabindex="1" rows="2" cols="30" class="txtarea"></textarea> <label
	class="bodytextB"><font id="error"></font>Forward TC to AIRHQ :</label>
<textarea name="<%=RequestConstants.FORWARD_TC_TO_AIRHQ%>" tabindex="1"
	rows="2" cols="30" class="txtarea"></textarea> <label
	class="bodytextB"><font id="error"></font>Forward AIRHQ to
DGAFMS :</label> <textarea name="<%=RequestConstants.FORWARD_AIRHQ_TO_DGAFMS%>"
	tabindex="1" rows="2" cols="30" class="txtarea"></textarea> <br />
<label class="bodytextB"><font id="error"></font>Date of SOC
forward :</label> <input type="text"
	name="<%= RequestConstants.DATE_OF_SOC_FORWARD %>" class="textbox_date"
	MAXLENGTH="30" / tabindex=1 /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.indentSocTracker.<%=RequestConstants.DATE_OF_SOC_FORWARD%>,event)" />

<%}%> <br />
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
			<td width="5%"><label valign="left" class="smalllabel">SR
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Nomenclature</label>
			</td>
			<td width="13%"><label valign="left" class="smalllabel">A/U</label>
			</td>
			<td width="13%"><label valign="left" class="smalllabel">Stock
			in</label></td>
			<td width="6%"><label valign="left" class="smalllabel">Qty
			Demand</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Unit
			rate</label></td>
		</tr>
	</thead>
	<tbody>
		<tr>
			<%for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
				Object[] object = (Object[]) iterator.next();
  		  %>
			<td width="10%"><input type="text" value="1" class="smcaption"
				readonly="readonly" /></td>
			<td width="10%"><input type="text" value="<%=object[1] %>"
				class="medcaption" readonly="readonly" /></td>
			<td width="10%"><input type="text" value="<%=object[2] %>"
				class="bigcaption" readonly="readonly" /></td>
			<td width="10%"><input type="text" value="<%=object[3] %>"
				class="medcaption" readonly="readonly" /></td>
			<%if(object[6] !=null){ %>
			<td width="10%"><input type="text" value="<%=object[6] %>"
				class="medcaption" readonly="readonly" /></td>
			<%}else{ %>
			<td width="10%"><input type="text" value="0" class="medcaption"
				readonly="readonly" /></td>
			<%} %>

			<%if(object[5] !=null){ %>
			<td width="10%"><input type="text" value="<%=object[5] %>"
				class="medcaption" readonly="readonly" /></td>
			<%}else{ %>
			<td width="10%"><input type="text" value="0" class="medcaption"
				readonly="readonly" /></td>
			<%} %>
			<%if(object[4] !=null){ %>
			<td width="10%"><input type="text" value="<%=object[4] %>"
				class="medcaption" readonly="readonly" /></td>
			<%}else{ %>
			<td width="10%"><input type="text" value="0" class="medcaption"
				readonly="readonly" /></td>
			<%} %>
			<%}%>


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

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
