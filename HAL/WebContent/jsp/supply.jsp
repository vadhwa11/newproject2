<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>

<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreIndentT"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<%
	Map map = new HashMap();
	String includedJsp = null;
		List<StoreIndentM> searchIndentMList = new ArrayList<StoreIndentM>();
		List<StoreIndentT> searchIndentTList= new ArrayList<StoreIndentT>();
		List<MasStoreItem> itemList= new ArrayList<MasStoreItem>();
		List<MasStoreSection> sectionList= new ArrayList<MasStoreSection>();
		int maxIndentNo=0;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	if(map.get("maxIndentNo")!=null)
		maxIndentNo=Integer.parseInt(""+map.get("maxIndentNo"));
	if(map.get("searchIndentMList")!=null)
		searchIndentMList=(List) map.get("searchIndentMList");
	if(map.get("searchIndentTList")!=null)
	searchIndentTList = (List) map.get("searchIndentTList");
	if(map.get("itemList")!=null)
		itemList=(List) map.get("itemList");
	if(map.get("sectionList")!=null)
		sectionList=(List) map.get("sectionList");
%>

<div id="contentspace">
<div align="center">
<div style="padding: 0px 25px 0px 25px"><!-- thread search menu -->
<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">

<form name="searchPanel" method="post">
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
			name="searchthreadid" value="85875" /> <label class="bodytextB_blue">Indent
		No:</label> <select name="<%= RequestConstants.INDENT_NO%>">
			<option value="0">Select</option>
			<%
					for (StoreIndentM storeIndentM :searchIndentMList ) {
				%>

			<option value=<%=storeIndentM.getIndentNo()%>><%=storeIndentM.getIndentNo()%></option>

			<%
					}
				%>
		</select> <input type="button" class="smbutton" value="Go!"
			onClick="submitForm('indent','stores?method=searchIndent');" /></td>
	</tr>

</table>
</form>
</div>
</div>
</div>
<jsp:include page="searchResultPO.jsp" /> <br />

<form name="zzzz" method="post"><input type="hidden" name="hdb"
	value="1" id="hdb" />

<fieldset style="width: 99%; padding-left: 9px;"><legend>Supply
Order Entry </legend>


<div
	style="overflow: auto; width: 100%; height: 150px; padding-left: 9px;">
<table width="98%" colspan="7" id="tblSample" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">

	<thead>
		<tr>

			<td width="10%"><label valign="left" class="smalllabel">SR
			No</label></td>
			<td width="13%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Nomenclature</label>
			</td>

			<td width="13%"><label valign="left" class="smalllabel">A/V</label>
			</td>
			<td width="13%"><label valign="left" class="smalllabel">MMF</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Vendor
			Name</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Supply
			Order No.</label></td>
			<td width="13%"><label valign="left" class="smalllabel">First
			Received No.</label></td>
			<td width="13%"><label valign="left" class="smalllabel">First
			Received Date</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Second
			Received No. </label></td>
			<td width="13%"><label valign="left" class="smalllabel">Second
			Received Date</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Rate</label></td>


		</tr>
	</thead>
	<tbody>

		<tr>
			<td width="10%"><input type="text" size="2" value="1"
				name="<%=RequestConstants.SR_NO%>" id="" /></td>
			<td width="10%"><select name="<%= RequestConstants.ITEM_ID%>">
				<option value="0">Select</option>
				<%
					for (MasStoreItem masItem :itemList ) {
				%>

				<option value=<%=masItem.getId()%>><%=masItem.getNomenclature()%></option>

				<%
					
					}
				%>
			</select> <% 
			MasStoreItem  masItem = new MasStoreItem();
 				if (itemList.size() != 0 && itemList != null)
 					for (int i = 0; i < itemList.size(); i++) {
 						masItem = (MasStoreItem) itemList.get(i);
 			%> <script>
								tempItemArray[<%=i%>]= new Array();
								tempItemArray[<%=i%>][0] = "<%=masItem.getId()%>";
								tempItemArray[<%=i%>][1] = "<%=masItem.getNomenclature()%>";
								
								</script> <%} %>
			</td>
			<td width="10%"><input type="text" class="textbox_size20"
				value="1" name="<%=RequestConstants.NOMENCLATURE%>" id="" /></td>
			<td width="10%"><input type="text" class="textbox_size20"
				value="2" name="<%=RequestConstants.AV%>" id="" /></td>
			<td width="10%"><select name="<%= RequestConstants.SECTION_ID%>">
				<option value="0">Select</option>
				<%
					for (MasStoreSection masStoreSection2 :sectionList ) {
				%>

				<option value=<%=masStoreSection2.getId()%>><%=masStoreSection2.getSectionName()%></option>

				<%
					
					}
				%>
			</select></td>
			<td width="10%"><input type="text" class="textbox_size20"
				value="3" name="<%=RequestConstants.STOCKING%>" id="" /></td>
			<td width="10%"><input type="text" class="textbox_size20"
				value="4" name="<%=RequestConstants.MMF%>" id="" /></td>
			<td width="10%"><input type="text" class="textbox_size20"
				value="5" name="<%=RequestConstants.QTY_DEMAND%>"
				onblur="addRowToTable();" /></td>
			<td width="10%"><input type="text" class="textbox_size20"
				value="5" name="<%=RequestConstants.QTY_DEMAND%>"
				onblur="addRowToTable();" /></td>
	</tbody>
</table>
</br>
</fieldset>
</div>
</div>
<br />
<br />
<br />
<input type="button" name="sss" align="right" class="button"
	value="Submit" onclick="submitForm('zzzz','stores?method=addIndent');" />
</form>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script>
<input type="hidden" name="rows" id="rr" value="1" />

</form>

