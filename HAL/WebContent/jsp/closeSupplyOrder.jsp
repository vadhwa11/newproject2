
<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * acknowledgment.jsp  
	 * Purpose of the JSP -  This is for Department Indent.
	 * @author  Mansi
	 * Create Date: 21th Apr, 2008
	 * Revision Date:      
	 * Revision By: 
	 * @version 1.5  
	--%>


<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.StoreIndentT"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.masters.business.StoreSupplyOrderEntry"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<link rel="stylesheet" href="/hms/jsp/css/acnik.css" type="text/css" />

<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript">
	<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
	</script>


<style type="text/css">
<!--
.locatorArrow {
	COLOR: #666666;
	FONT-FAMILY: Verdana;
	FONT-SIZE: 12px
}
</style>


<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
</script>

<script language="Javascript">



function getIndent()
{
	supplyOder.method="post";
	var indentNo = document.getElementById('indentNo').value
	alert(indentNo)
	submitForm('supplyOder','stores?method=createGridSupplyOrderEntryData&<%=INDENT_NO%>='+indentNo);
	
}


//this function will be called by the Bean (not from JSP)
function goPage(pidx) {	
	supplyOder.currPage.value = pidx;
	supplyOder.method="post";
	submitForm('supplyOder','stores?method=createGridSupplyOrderEntryData');
}
function showSupplyOrder(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=closeSupplyOrderJsp";
  obj.submit();
}

	</script>

<%
		StringBuffer orderDateOnly = new StringBuffer();
		GregorianCalendar gregorianCalendar1 = new GregorianCalendar();
	
		int dateOfMonth = gregorianCalendar1.get(Calendar.DAY_OF_MONTH);
		if (dateOfMonth < 10) {
			orderDateOnly.append("0");
			orderDateOnly.append(dateOfMonth);
		} else {
			orderDateOnly.append(dateOfMonth);
		}
	
		orderDateOnly.append("/");
	
		int month1 = gregorianCalendar1.get(Calendar.MONTH) + 1;
		if (month1 < 10) {
			orderDateOnly.append("0");
			orderDateOnly.append(month1);
		} else {
			orderDateOnly.append(month1);
		}
	
		orderDateOnly.append("/");
		int year1 = gregorianCalendar1.get(Calendar.YEAR);
		orderDateOnly.append(year1);
		String currentDate = new String(orderDateOnly);
	%>
<%
		Map<String,Object> map = new HashMap<String,Object>();
	
		Box box = HMSUtil.getBox(request);
		HashMap[] gridData =null;
		PagedArray pagedArray = null;
		String flag = "";
		int indentMId = 0;
		List<StoreIndentM> searchStoreIndentMList = new ArrayList<StoreIndentM>();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
			pagedArray = (PagedArray) map.get("pagedArray");
		}
		if (map.get("indentMId")!=null){
			indentMId=Integer.parseInt(""+map.get("indentMId"));
		}
		
		
		if(map.get("searchStoreIndentMList")!=null)
			searchStoreIndentMList = (List) map.get("searchStoreIndentMList");
		
		System.out.println("searchStoreIndentMList in JSP"+searchStoreIndentMList.size());
		
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
		
		String date = (String)utilMap.get("currentDate");
		String time = (String)utilMap.get("currentTime");
		String userName = "";
		
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		
		int deptId=0;
		if(session.getAttribute("deptId") != null){
			deptId = (Integer)session.getAttribute("deptId");
		}
	
		
		
		if(map.get("message") != null){
			   String message = (String)map.get("message");
			   %>
<br>
<br>
<%
			   out.println(message);
		}
		

	%>


<br />

<h2 align="left" class="style1">Supply Order Form</h2>

<div id="contentspace"><br />


<form name="supplyOder" method="post"><input type="hidden"
	name="numOfRows" size="5" value="5"> <input type="hidden"
	name="pageCount" size="5" value="10"> <input type="hidden"
	name="deptId" size="5" value="<%=deptId %>">

<table width="20%" align="right" border="0" cellpadding="0"
	cellspacing="0">
	<tr>
		<td width="5%"><IMG SRC="/hms/jsp/images/toolBar_01.gif" WIDTH=24
			HEIGHT=28 ALT=""></td>
		<td width="7%" background="/hms/jsp/images/toolbuttBack.gif"><input
			type="button" name="Add" type="submit" value="Add" class="toolbutton"
			onClick="submitForm('supplyOder','stores?method=addSupplyOrder');"></td>
		<td width="1%" background="/hms/jsp/images/toolbuttBack.gif"></td>
		<td width="10%" background="/hms/jsp/images/toolbuttBack.gif"><input
			type="button" name="Modify" type="submit" value="Modify"
			class="toolbutton"
			onClick="submitForm('supplyOder','stores?method=updateSupplyOrder');"></td>
		<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
		<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
			type="button" name="Reset" type="submit" value="Reset"
			class="toolbutton" onClick="showSupplyOrder('supplyOder');"></td>
		<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
		<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
			type="button" name="Delete" type="submit" value="Delete"
			class="toolbutton"></td>
		<td width="4%" background="/hms/jsp/images/toolbuttBack.gif"><input
			type="button" name="print" type="submit" class="toolbutton" value=" "
			onClick=""></td>
		<td width="39%"><IMG SRC="/hms/jsp/images/closeButton.gif"
			WIDTH=24 HEIGHT=28 ALT=""></td>
	</tr>
</table>
</td>
</tr>
</table>

<br />


<label class="bodytextB">Indent No:</label> <select id="indentNo"
	name="<%=INDENT_NO%>" validate="Indent No,String,no"
	onchange="getIndent();">
	<option value="0">Select</option>
	<%
				for (StoreIndentM storeIndentM :searchStoreIndentMList ) {
				
				%>
	<option value=<%=storeIndentM.getId()%>><%=storeIndentM.getIndentNo()%></option>
	<%	
					}
				
					
				%>
</select> <input type="hidden" name="<%=CHANGED_BY %>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input
	type="hidden" name="indentMId"
	value="<%=map.get("indentMId") == null?0:map.get("indentMId")%>" /> <br />

<% if (pagedArray == null) { %>
<fieldset style="width: 99%; padding-left: 9px;"><legend>Details</legend>
<div
	style="overflow: auto; width: 100%; height: 175px; padding-left: 9px;">
<table width="100%" colspan="7" id="indentDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>


			<td width="10%"><label valign="left" class="smalllabel">SR
			No</label></td>
			<td width="13%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Nomenclature</label>
			</td>

			<td width="13%"><label valign="left" class="smalllabel">A/U</label>
			</td>
			<td width="13%"><label valign="left" class="smalllabel">MMF</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Supply
			Order No.</label></td>
			<td width="13%"><label valign="left" class="smalllabel">First
			Rec. No.</label></td>
			<td width="13%"><label valign="left" class="smalllabel">First
			Rec. Date</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Second
			Rec. No. </label></td>
			<td width="13%"><label valign="left" class="smalllabel">Second
			Rec. Date</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Rate</label></td>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=6>No Data Found</td>
		</tr>
	</tbody>
</table>
</div>
</fieldset>
<% } else { %>
<fieldset style="width: 99%; padding-left: 9px;"><legend>Acknowledgment
Details</legend>
<div
	style="overflow: auto; width: 100%; height: 175px; padding-left: 9px;">
<table width="100%" colspan="7" id="indentDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<td width="10%"><label valign="left" class="smalllabel">SR
			No</label></td>
			<td width="13%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Nomenclature</label>
			</td>

			<td width="13%"><label valign="left" class="smalllabel">A/U</label>
			</td>
			<td width="13%"><label valign="left" class="smalllabel">MMF</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Supply
			Order No.</label></td>
			<td width="13%"><label valign="left" class="smalllabel">First
			Rec. No.</label></td>
			<td width="13%"><label valign="left" class="smalllabel">First
			Rec. Date</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Second
			Rec. No. </label></td>
			<td width="13%"><label valign="left" class="smalllabel">Second
			Rec. Date</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Rate</label></td>
		</tr>
	</thead>
	<tbody>
		<%
				    gridData = (HashMap[])pagedArray.getPagedArray();
					int iFirstRow = pagedArray.getFirstRowIdx();
				    for(int i=0;i<gridData.length;i++)
				    { %>
		<tr>
			<td width="5%"><input type="text" value="<%=iFirstRow++%>"
				class="smcaption" name="srno" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("pvms")%>" class="medcaption" name="pvms"
				readonly="readonly" /></td>
			<td width="40%"><input type="text"
				value="<%=gridData[i].get("nomenclature")%>" class="bigcaption"
				name="nomenclature" readonly="readonly" /></td>
			<td width="12%"><input type="text"
				value="<%=gridData[i].get("au")==null?"":gridData[i].get("au")%>"
				class="medcaption" name="au" readonly="readonly" /></td>
			<td width="12%"><input type="text"
				value="<%=gridData[i].get("mmf")%>" name="mmf"
				validate="mmf,float,no" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("supplyOrderNo")%>" name="supplyOrderNo"
				validate="supplyOrderNo Qty,string,no" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("firstRecNo")%>" name="firstRecNo" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("firstRecDate")==null?"":gridData[i].get("firstRecDate")%>"
				name="firstRecDate" class="textbox_date" readonly /> <img
				src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date" class="calender" tabindex="1"
				onClick="setdate('<%=currentDate%>',document.supplyOder.firstRecDate,event)" />
			</td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("secondRecNo")%>" name="secondRecNo" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("secondRecDate")==null?"":gridData[i].get("secondRecDate")%>"
				name="secondRecDate" class="textbox_date" readonly /> <img
				src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date" class="calender" tabindex="1"
				onClick="setdate('<%=currentDate%>',document.supplyOder.secondRecDate,event)" />
			</td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("rate")%>" name="rate"
				validate="rate,float,no" /></td>
			<td><input type="hidden"
				value="<%=gridData[i].get("indentTId")%>" name="indentTId" /></td>
			<td><input type="hidden"
				value="<%=gridData[i].get("indentId")%>" name="indentId" /></td>
			<td><input type="hidden" value="<%=gridData[i].get("itemId")%>"
				name="itemId" /></td>
			<td><input type="hidden"
				value="<%=gridData[i].get("supplyOrderId")%>" name="supplyOrderId" />
			</td>
		</tr>
		<% } %>
		<tr class="locatorArrow">
			<td colspan=7 align="center"><%= pagedArray.showIndex()%> <%=pagedArray.getPageIndexHiddenTag()%></td>
		</tr>
	</tbody>
</table>
</div>
</fieldset>

<input type="button" name="update" id="updatebutton" value="Update"
	class="button"
	onClick="submitForm('supplyOder','stores?method=updateSupplyOrder');"
	accesskey="a" tabindex=1 /> <input type="button" name="close"
	id="closebutton" value="Close" class="button"
	onClick="showSupplyOrder('supplyOder')" accesskey="u" tabindex=1 /> <% } %>


</form>
</div>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script>