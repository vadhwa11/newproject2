<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * soc.jsp  
 * Purpose of the JSP -  This is for SOC.
 * @author  Deepali
 * @author  Mansi
 * Create Date: 30th Jan,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.5
--%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="jkt.hms.masters.business.StoreSoc"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
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

	int month = gregorianCalendar1.get(Calendar.MONTH) + 1;
	if (month < 10) {
		orderDateOnly.append("0");
		orderDateOnly.append(month);
	} else {
		orderDateOnly.append(month);
	}

	orderDateOnly.append("/");
	int year = gregorianCalendar1.get(Calendar.YEAR);
	orderDateOnly.append(year);
	String currentDate = new String(orderDateOnly);
%>


<%
	Map<String,Object> map = new HashMap<String,Object>();
	List<StoreSoc> searchSocList = new ArrayList<StoreSoc>();
		List<MasStoreItem> itemList= new ArrayList<MasStoreItem>();
		List<MasDepartment> departmentList= new ArrayList<MasDepartment>();
		
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	if(map.get("searchSocList")!=null)
		searchSocList = (List) map.get("searchSocList");
	if(map.get("departmentList")!=null)
		departmentList=(List) map.get("departmentList");
	if(map.get("itemList")!=null)
		itemList=(List) map.get("itemList");
	
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %>
<br>
<br>
<%
		   out.println(message);
		  }
	
%>

<div id="contentspace">
<form name="soc" method="post"><br />

<table class="tborder" width="100%" align="center">
	<tr>
		<td width="20%" nowrap="nowrap" class="vbmenu_control"
			id="threadsearch"><a href="">Search</a> <script
			type="text/javascript"> vbmenu_register("threadsearch"); </script></td>
		<td width="80%"><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>


		<table width="20%" align="right" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="5%"><IMG SRC="/hms/jsp/images/toolBar_01.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
				<td width="7%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Add" value="Add" class="toolbutton"></td>
				<td width="1%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="reset" name="Reset" value="Reset" class="toolbutton"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="39%"><IMG SRC="/hms/jsp/images/closeButton.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
			</tr>
		</table>
		</td>
	</tr>
</table>



<div align="center">
<div style="padding: 0px 25px 0px 25px"><!-- thread search menu -->
<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">

<form action="searchPanel" method="post">
<table cellpadding="4" cellspacing="1" border="0">
	<tr>
		<td class="thead">Search Panel<a name="goto_threadsearch"></a></td>
	</tr>
	<tr>
		<td class="vbmenu_option" title="nohilite"><input type="hidden"
			name="s" value="cccfbaab0a70ed43fad9de8e3733112d" /> <input
			type="hidden" name="do" value="process" /> <input type="hidden"
			name="searchthread" value="1" /> <input type="hidden"
			name="showposts" value="1" /> <input type="hidden"
			name="searchthreadid" value="85875" /> <label class="bodytextB_blue">From
		Date :</label> <input type="text" name="<%= RequestConstants.FROM_DATE %>"
			class="textbox_date" MAXLENGTH="30" / tabindex=1 /> <img
			id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
			border="0" validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.soc.<%= RequestConstants.FROM_DATE%>,true);"
			class="calender" /> <label class="bodytextB_blue">To Date :</label>

		<input type="text" name="<%= RequestConstants.TO_DATE %>"
			class="textbox_date" MAXLENGTH="30" / tabindex=1 /> <img
			id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
			border="0" validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.soc.<%= RequestConstants.TO_DATE%>,true);"
			class="calender" /> <br />

		<label class="bodytextB_blue">Indent No:</label> <select
			name="<%= RequestConstants.INDENT_NO_FOR_SEARCH%>">
			<option value="0">Select</option>
			<%
					for (StoreSoc storeSoc :searchSocList ) {
				%>

			<option value="<%=storeSoc.getIndentNo()%>"><%=storeSoc.getIndentNo()%></option>

			<%
					}
				%>
		</select> <input type="button" class="smbutton" value="Go!"
			onClick="submitForm('soc','stores?method=searchSoc');" /></td>
	</tr>

</table>
</form>
</div>
</div>
</div>

<br />
<br />
<form name="zzzz" method="post">
<div id="searchbar">
<div class="panelbar">
<div class="paneltext">
<div id="servicePerson" style="display: block;">PAC/NON-PAC
Details</div>
</div>
</div>
<label class="bodytextB_blue"><font id="error"></font> Indent
No: </label> <input type="text" name="<%=RequestConstants.INDENT_NO %>"
	validate="Indent No,string,yes" class="textbox_size20" MAXLENGTH="8"/  >

<label class="bodytextB_blue"><font id="error"></font>Indent
Date:</label> <input type="text" name="<%=RequestConstants.INDENT_DATE%>"
	readonly="readonly" value="<%=currentDate %>" class="textbox_size20"
	MAXLENGTH="30" /> <label class="bodytextB_blue"><font
	id="error"></font>Item Code/Name, Nomenclature:</label> <select
	name="<%= RequestConstants.ITEM_ID%>" validate="Item,string,yes">
	<option value="0">Select</option>
	<%
						for (MasStoreItem masItem :itemList ) {
					%>

	<option value=<%=masItem.getId()%>><%=masItem.getNomenclature()%></option>

	<%
						}
					%>
</select> <label class="bodytextB_blue"><font id="error"></font>Quantity
Dem.:</label> <input type="text"
	name="<%= RequestConstants.QUANTITY_DEMANDED %>"
	validate="Quantity Demanded,string,yes" value="" class="textbox_size20"
	MAXLENGTH="8" /> <br />

<label class="bodytextB_blue"><font id="error"></font>Cost :</label> <input
	type="text" name="<%= RequestConstants.COST %>" validate="Cost,num,yes"
	value="" class="textbox_size20" MAXLENGTH="8" /> <label
	class="bodytextB_blue"><font id="error"></font>Department: </label> <select
	name="<%= RequestConstants.DEPARTMENT_ID%>"
	validate="Deparment,string,yes">
	<option value="0">Select</option>
	<%
						for (MasDepartment masDepartment :departmentList ) {
					%>

	<option value=<%=masDepartment.getId()%>><%=masDepartment.getDepartmentName()%></option>

	<%
						}
					%>
</select> <label class="bodytextB_blue"><font id="error"></font>Present
Hold. :</label> <input type="text"
	name="<%= RequestConstants.HOLDING_FORM_SOURCES %>" value=""
	class="textbox_size20" validate="Holding Form All Sources,string,yes" />

<label class="bodytextB_blue">Brief Just. :</label> <textarea
	name="<%= RequestConstants.BRIEF_JUSTIFICATION %>" cols="25" rows="3"
	validate="Brief Justification,string,yes" MAXLENGTH="30"></textarea> <br />

<div id="searchbar">
<div class="panelbar">
<div class="paneltext">
<div id="servicePerson" style="display: block;">Send Details</div>
</div>
</div>

<label class="bodytextB_blue"><font id="error"></font> PAC
Detail :</label> <input type="text"
	name="<%= RequestConstants.IF_PAC_GENERAL_DETAILS %>" value=""
	class="textbox_size20" maxlength="100" /> <label
	class="bodytextB_blue"><font id="error"></font>PAC,Name Of
Foreign Principal,Address of Indian Agency :</label> <input type="text"
	name="<%= RequestConstants.IF_PAC_NAME %>" value=""
	class="textbox_size20" maxlength="100" /> <label
	class="bodytextB_blue"><font id="error"></font>Forward To TC :</label>
<input type="text" name="<%= RequestConstants.FWD_TO_TC %>" value=""
	class="textbox_size20" maxlength="100" /> <label
	class="bodytextB_blue"><font id="error"></font>Forward To HQ :</label>
<input type="text" name="<%= RequestConstants.FWD_TO_HQ %>" value=""
	class="textbox_size20" maxlength="100" /> <br />

<label class="bodytextB_blue"><font id="error"></font>Forward To
DHAFMS :</label> <input type="text" name="<%= RequestConstants.FWD_TO_DHAFMS %>"
	value="" class="textbox_size20" maxlength="100" /> <label
	class="bodytextB_blue"><font id="error"></font>Present Status :</label>
<input type="text" name="<%= RequestConstants.PRESENT_STATUS %>"
	value="" class="textbox_size20" maxlength="100" /> <br />

<input type="button" name="sss" align="right" class="button"
	value="Submit" onclick="submitForm('zzzz','stores?method=addSoc');" />

</div>
</form>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script> <input type="hidden" name="rows" id="rr" value="1" /></form>
</div>
