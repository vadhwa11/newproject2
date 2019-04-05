<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.util.Box"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

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



<style type="text/css">
<!--
.locatorArrow {
	COLOR: #666666;
	FONT-FAMILY: Verdana;
	FONT-SIZE: 12px
}
</style>

<%
	String date = "";
	String time = "";
	String userName = "";
	int hospitalId = 0;
	
	Box box = HMSUtil.getBox(request);
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
		}
 	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
  	Map map = new HashMap();
  	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	List existingTenderNumbersList = null;
	List mmfyears = null;
	String tender_no;
	int deptId = 0;
	
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		pagedArray = (PagedArray) map.get("pagedArray");
		System.out.println("map " + map);
	}
	
	if (map.get("indent_id")!=null)
		box.put("indent_id",Integer.parseInt(map.get("indent_id").toString()));
	
	if (map.get("indent_type")!=null)
		box.put("indent_type",map.get("indent_type").toString());

	if (map.get("supplierList")!=null)
		supplierList = (List)map.get("supplierList");
	
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	
	if (session.getAttribute("deptId") != null) {
		Integer temp =  (Integer)session.getAttribute("deptId");
		deptId = temp.intValue();
	}
%>

<title>Tender Creation</title>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link href="../style/pdb_style.css" rel="stylesheet" type="text/css" />
<script>

//this function will be called by the Bean (not from JSP)
function goPage(pidx) {	
	supplyOrderEntryForm.currPage.value = pidx;
	supplyOrderEntryForm.method="post";
	submitForm('supplyOrderEntryForm','stores?method=showAddSupplyOrderEntryJsp');
}

function jsSubmit()
{
		supplyOrderEntryForm.method="post";
		submitForm('supplyOrderEntryForm','stores?method=showAddSupplyOrderEntryJsp&currPage=1');
}

function jsAdd()
{
		supplyOrderEntryForm.method="post";
		submitForm('supplyOrderEntryForm','stores?method=doAddSupplyOrderEntryItems');
}


function jsClose()
{
  window.opener.location.href = "stores?method=createGridSupplyOrderEntryData&indent_type="+supplyOrderEntryForm.indent_type.value + "&<%=INDENT_NO%>=" + supplyOrderEntryForm.indent_id.value + "&deptId=" + supplyOrderEntryForm.deptId.value;
  if (window.opener.progressWindow)
	 {
    	window.opener.progressWindow.close()
  	 } 
  window.close();
}



</script>
</head>
<div id="contentspace">

<form name="supplyOrderEntryForm" action="" method="post"><input
	type="hidden" name="numOfRows" size="5" value="15"> <input
	type="hidden" name="pageCount" size="5" value="10"> <input
	type="hidden" name="search" size="5" value="true"> <input
	type="hidden" name="deptId" size="5" value="<%=deptId%>"> <input
	type="hidden" name="indent_id" size="5"
	value="<%=box.getInt("indent_id")%>"> <input type="hidden"
	name="indent_type" size="5" value="<%=box.getString("indent_type")%>">

<div style="padding-left: 15px;"><br />
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Indent Item(s) Search </font></div>

<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 955px; height: 83px; background-color: #f4f9fe;">
<br />


<label class="bodytextB">Nomenclature</label> <input type="text"
	name="search_text" value="<%=box.get("search_text") %>"
	class="textbox_size20" MAXLENGTH="30" validate="Nomenclature,string,no" />

<input type="button" name="Submit" id="addbutton" onClick="jsSubmit()"
	value="Submit" class="button" /></div>
<br />

<%		
		if (pagedArray == null) {
		%>
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid; BORDER-LEFT: #9A9A9A 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Indent Item Details</font></div>

<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>
<br />

<div
	style="overflow: scroll; overflow-x: hidden; width: 100%; height: 300px; BORDER: #202020 1px solid;">
<table align="center" width="100%" colspan="7" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<td width="10%"><label valign="left" class="smalllabel">SR
			No</label></td>
			<td width="13%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Nomenclature</label></td>
			<td width="13%"><label valign="left" class="smalllabel">A/U</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Date
			of Recpt</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Qty
			Recd</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Batch
			No</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Manuf.
			Date</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Expiry
			Date</label></td>
			<td width="13%"><label valign="left" class="smalllabel">DGFMS
			RC No.</label></td>
			<td width="13%"><label valign="left" class="smalllabel">RC
			Date</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Supplier</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Enclosure
			No</label></td>
	</thead>
	<tbody>
		<tr>
			<td colspan=13 align="center">No Items Found</td>
		</tr>
	</tbody>
</table>
</div>
<input type="button" name="Close" onClick="jsClose()" value="Close"
	class="button" /> <%  } else { %>

<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid; BORDER-LEFT: #9A9A9A 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Indent Item Details</font></div>

<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>
<br />

<div
	style="overflow: scroll; overflow-x: scroll; width: 100%; height: 300px; BORDER: #202020 1px solid;">
<table align="center" width="100%" colspan="7" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">

	<thead>
		<tr>
			<td width="10%"><label valign="left" class="smalllabel">SR
			No</label></td>
			<td width="13%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Nomenclature</label></td>
			<td width="13%"><label valign="left" class="smalllabel">A/U</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Date
			of Recpt</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Qty
			Recd</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Batch
			No</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Manuf.
			Date</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Expiry
			Date</label></td>
			<td width="13%"><label valign="left" class="smalllabel">DGFMS
			RC No.</label></td>
			<td width="13%"><label valign="left" class="smalllabel">
			RC. Date </label></td>
			<td width="13%"><label valign="left" class="smalllabel">Supplier</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Enclosure
			No</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Add</label></td>
		</tr>
	</thead>
	<tbody>


		<%
			    gridData = (HashMap[])pagedArray.getPagedArray();
				int iFirstRow = pagedArray.getFirstRowIdx();
			    for(int i=0;i<gridData.length;i++)
			    { %>
		<tr>
			<td><input type="text" value="<%=iFirstRow++%>"
				class="smcaption" name="srno" readonly="readonly" /></td>
			<td><input type="text" value="<%=gridData[i].get("pvms" )%>"
				class="medcaption" name="pvms" readonly="readonly" /></td>
			<td><input type="text"
				value="<%=gridData[i].get("nomenclature")%>" class="bigcaption"
				name="nomenclature" readonly="readonly" /></td>
			<td><input type="text" value="<%=gridData[i].get("au")%>"
				name="au" class="smcaption" readonly="readonly" /></td>

			<td width="40%"><input type="text" name="date_of_receipt"
				id="date_of_receipt<%=i%>" class="smcaption" MAXLENGTH="30"
				tabindex="1" /> <img src="/hms/jsp/images/cal.gif" width="16"
				height="16" border="0" validate="Pick a date" class="calender"
				tabindex="1"
				onClick="setdate('<%=date%>'document.getElementById('date_of_receipt<%=i%>'),event)" />

			</td>
			<td><input type="text" value="" name="qty_recd"
				class="smcaption" tabindex="1" /></td>
			<td><input type="text" value="" name="batch_no"
				class="smcaption" tabindex="1" /></td>
			<td width="40%"><input type="text" name="manuf_date"
				id="manuf_date<%=i%>" class="smcaption" MAXLENGTH="30" tabindex="1" />


			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date" class="calender" tabindex="1"
				onClick="setdate('<%=date%>'document.getElementById('manuf_date<%=i%>'),event)" />
			</td>

			<td width="40%"><input type="text" name="expiry_date"
				id="expiry_date<%=i%>" class="smcaption" MAXLENGTH="30" tabindex="1" />

			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date" class="calender" tabindex="1"
				onClick="setdate('<%=date%>'document.getElementById('expiry_date<%=i%>'),event)" />

			</td>
			<td><input type="text" value="" name="rc_no" class="smcaption"
				tabindex="1" /></td>
			<td width="40%"><input type="text" name="rc_date"
				id="rc_date<%=i%>" class="smcaption" MAXLENGTH="30" tabindex="1" />

			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date" class="calender" tabindex="1"
				onClick="setdate('<%=date%>'document.getElementById('rc_date<%=i%>'),event)" />
			</td>
			<td><select name="supplier" tabindex=1>
				<option value="">Select</option>
				<% for(MasStoreSupplier masStoreSupplier : supplierList)
					{
				%>
				<option value="<%=masStoreSupplier.getId()%>"><%=masStoreSupplier.getSupplierName() %>
				</option>
				<%
					}
				%>
			</select></td>

			<td><input type="text" value="" name="enclosure_no"
				class="smcaption" tabindex="1" /></td>

			<td><input type="checkbox" name=<%=ITEMS_TO_BE_ADDED%>
				value="<%=gridData[i].get("item_id")%>" class="smcaption"
				tabindex="1"></td>
			<td><input type="hidden"
				value="<%=gridData[i].get("indent_t_id")%>" name="indent_t_id" />
			</td>
			<td><input type="hidden"
				value="<%=gridData[i].get("item_id")%>" name="item_id" /></td>

		</tr>
		<% } %>
	</tbody>
</table>
</div>

<div style="padding-left: 250px;">

<div class="wardspan" style="float: left;"><%= pagedArray.showIndex()%></div>
<div class="wardspan" style="float: left;"><%= pagedArray.getPageIndexHiddenTag()%>
</div>
</div>
<div><br />

<input type="button" name="Add" onClick="jsAdd()" value="Add"
	class="button" tabindex="1" /> <input type="button" name="Close"
	onClick="jsClose()" value="Close" class="button" tabindex="1" /></div>
</div>
<%}%>
</form>