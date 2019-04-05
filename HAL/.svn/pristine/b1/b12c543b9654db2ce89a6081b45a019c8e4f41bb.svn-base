<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * modifySoc.jsp  
 * Purpose of the JSP -  This is for modify Soc.
 * @author  Mansi
 * @author  Deepali
 * Create Date: 21st Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.3
--%>

<%@page import="jkt.hms.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="jkt.hms.masters.business.StoreSoc"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
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
	int socId = 0;
	Map<String,Object> map = new HashMap<String,Object>();
	List<StoreSoc> searchSocList = new ArrayList<StoreSoc>();
	List<StoreSoc> gridSocList = new ArrayList<StoreSoc>();
	List<MasStoreItem> itemList= new ArrayList<MasStoreItem>();
	List<MasDepartment> departmentList= new ArrayList<MasDepartment>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	if (map.get("searchSocList") != null)
		searchSocList = (List) map.get("searchSocList");
	if (map.get("gridSocList") != null)
		gridSocList = (List) map.get("gridSocList");
	if (map.get("socId") != null)
		socId = (Integer) map.get("socId");
	if(map.get("departmentList")!=null)
		departmentList=(List) map.get("departmentList");
	if(map.get("itemList")!=null)
		itemList=(List) map.get("itemList");
	
	
	System.out.println("socId                 " + socId);
	System.out.println("gridSocList gridSocList "
			+ gridSocList.size());
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
					type="button" name="Add" type="submit" value="Add"
					class="toolbutton"
					onClick="submitForm('searchSoc','stores?method=showSocJsp');" /></td>
				<td width="1%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="10%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Modify" type="submit" value="Modify"
					class="toolbutton"
					onClick="submitForm('poMain','purchaseOrder?method=poModifyJsp');" /></td>
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
					value=" " onClick=""></td>
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
		Date :</label> <input type="text" name="<%= FROM_DATE %>" class="textbox_date"
			MAXLENGTH="30" / tabindex=1 /> <img id="calendar"
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.soc.<%= FROM_DATE%>,true);"
			class="calender" /> <label class="bodytextB_blue">To Date :</label>

		<input type="text" name="<%= TO_DATE %>" class="textbox_date"
			MAXLENGTH="30" / tabindex=1 /> <img id="calendar"
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.soc.<%= TO_DATE%>,true);"
			class="calender" /> <br />
		<label class="bodytextB_blue">Indent No:</label> <select
			name="<%= INDENT_NO_FOR_SEARCH%>">
			<option value="0">Select</option>
			<%
				for (StoreSoc storeSoc : searchSocList) {
			%>

			<option value=<%=storeSoc.getIndentNo()%>><%=storeSoc.getIndentNo()%></option>

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
<jsp:include page="searchResultPO.jsp" /> <br />
<div id="testDiv">
<%
			for (StoreSoc grStoreSoc : gridSocList) {
		%> <label class="bodytextB_blue"><font id="error"></font>
Indent No: </label> <input type="text" name="<%=INDENT_NO%>"
	value="<%=grStoreSoc.getIndentNo()%>" validate="Indent No,string,yes"
	class="textbox_size20" MAXLENGTH="8"/  > <label
	class="bodytextB_blue"><font id="error"></font>Indent Date:</label> <input
	type="text" name="<%=INDENT_DATE%>"
	value="<%=HMSUtil.changeDateToddMMyyyy(grStoreSoc.getIndentDate())%>"
	readonly="readonly" class="textbox_size20" MAXLENGTH="30" /> <label
	class="bodytextB_blue"><font id="error"></font>Item Code :</label> <select
	name="<%= ITEM_ID%>" validate="Item,string,yes">
	<option value="0">Select</option>
	<%
						for (MasStoreItem masItem :itemList ) {
							if(grStoreSoc.getItem().getId() == masItem.getId()){
					%>
	<option value="<%=masItem.getId()%>" selected="selected"><%=masItem.getNomenclature()%></option>
	<%}else{ %>
	<option value="<%=masItem.getId()%>"><%=masItem.getNomenclature()%></option>
	<%}
						}
					%>
</select> <label class="bodytextB_blue"><font id="error"></font>Quantity
Demanded:</label> <input type="text" name="<%=QUANTITY_DEMANDED%>"
	validate="Item,string,yes"
	value="<%=grStoreSoc.getQuantityDemanded()%>" class="textbox_size20"
	MAXLENGTH="30" /> <br />

<label class="bodytextB_blue"><font id="error"></font>Cost :</label> <input
	type="text" name="<%=COST%>" validate="Cost,num,yes"
	value="<%=grStoreSoc.getCost()%>" class="textbox_size20" MAXLENGTH="30" />

<label class="bodytextB_blue"><font id="error"></font>Department
:</label> <select name="<%= DEPARTMENT_ID%>" validate="Department,string,yes">
	<option value="0">Select</option>
	<%
						for (MasDepartment masDepartment :departmentList ) {
							if(grStoreSoc.getDepartment().getId() == masDepartment.getId()){
					%>
	<option value="<%=masDepartment.getId()%>" selected="selected"><%=masDepartment.getDepartmentName()%></option>
	<%}else{ %>
	<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
	<%}
						}
					%>
</select> <label class="bodytextB_blue"><font id="error"></font>Present
Holding Form All Sources :</label> <input type="text"
	name="<%=HOLDING_FORM_SOURCES%>"
	value="<%=grStoreSoc.getHoldingSources()%>"
	validate="Present Holding Form All Sources,string,yes"
	class="textbox_size20" MAXLENGTH="30" /> <label class="bodytextB_blue"><font
	id="error"></font>Brief Justification :</label> <input type="text"
	name="<%=BRIEF_JUSTIFICATION%>" value="<%=grStoreSoc.getBriefJust()%>"
	validate="Brief Justification,string,yes" class="textbox_size20"
	MAXLENGTH="30" /> <br />

<label class="bodytextB_blue"><font id="error"></font>If PAC,
General Detail Justification :</label> <input type="text"
	name="<%=IF_PAC_GENERAL_DETAILS%>"
	value="<%=grStoreSoc.getIfPacDetail()%>" class="textbox_size20"
	validate=" General Detail Justification ,string,yes" MAXLENGTH="30" />

<label class="bodytextB_blue"><font id="error"></font>If PAC,
Name Of The Foreign Principal & Name & Address of Indian Agency :</label> <input
	type="text" name="<%=IF_PAC_NAME%>"
	value="<%=grStoreSoc.getIfPacName()%>" class="textbox_size20"
	validate="Name Of The Foreign Principal & Name & Address of Indian Agency,string,yes"
	MAXLENGTH="30" /> <label class="bodytextB_blue"><font
	id="error"></font>Foward To TC :</label> <input type="text"
	name="<%= RequestConstants.FWD_TO_TC %>"
	value="<%=grStoreSoc.getFwdToTc()%>" validate="Foward To TC,string,yes"
	class="textbox_size20" maxlength="100" /> <label
	class="bodytextB_blue"><font id="error"></font>Foward To HQ :</label> <input
	type="text" name="<%= RequestConstants.FWD_TO_HQ %>"
	value="<%=grStoreSoc.getFwdToHq()%>" validate="Foward To HQ,string,yes"
	class="textbox_size20" maxlength="100" /> <br />

<label class="bodytextB_blue"><font id="error"></font>Foward To
DHAFMS :</label> <input type="text" name="<%= RequestConstants.FWD_TO_DHAFMS %>"
	value="<%=grStoreSoc.getFwdToDhafms()%>"
	validate="Foward To DHAFMS,string,yes" class="textbox_size20"
	maxlength="100" /> <label class="bodytextB_blue"><font
	id="error"></font>Present Status :</label> <input type="text"
	name="<%= RequestConstants.PRESENT_STATUS %>"
	value="<%=grStoreSoc.getPresentStatus()%>"
	validate="Present Status,string,yes" class="textbox_size20"
	maxlength="200" /> <br />
<input type="hidden" name="<%=NO_OF_ROWS%>" id="rr" value="" /> <input
	type="hidden" name="<%=SOC_ID %>" value="<%=grStoreSoc.getId() %>">
<%
				}
			%>
</div>
<br />
</div>

<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>
<input type="hidden" name="rows" id="rr" value="1" />
<input type="button" name="submit" align="right" class="button"
	value="Update" onclick="submitForm('soc','stores?method=updateSoc');" />

</form>

