
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

function openPopupWindow()
{
 	var indent_type;
	obj1 = document.getElementById("indent1");
	obj2 = document.getElementById("indent2");
	if (obj1.checked) indent_type = obj1.value;
	if (obj2.checked) indent_type = obj2.value;

 	var url="/hms/hms/stores?method=showAddSupplyOrderEntryJsp&indent_id="+document.getElementById("indentNo").value + "&indent_type=" + indent_type;
	newwindow=window.open(url,'name','top=50, left=10, height=550,width=1000,status=1');
}


function getIndent()
{
    var indent_type;
	obj1 = document.getElementById("indent1");
	obj2 = document.getElementById("indent2");
	if (obj1.checked) indent_type = obj1.value;
	if (obj2.checked) indent_type = obj2.value;
	supplyOrder.method="post";
	var indentNo = document.getElementById('indentNo').value
	submitForm('supplyOrder','stores?method=createGridSupplyOrderEntryData&<%=INDENT_NO%>='+indentNo + "&indent_type=" + indent_type);
}

function populateIndentNo(indent_type, formName)
{
	supplyOrder.method = "post";
	submitForm('supplyOrder','stores?method=getIndentNosForSupplyOrderEntry&indent_type=' + indent_type);
}


//this function will be called by the Bean (not from JSP)
function goPage(pidx) {	
	supplyOrder.currPage.value = pidx;
	supplyOrder.method="post";
	submitForm('supplyOrder','stores?method=createGridSupplyOrderEntryData');
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
		List<StoreIndentM> searchStoreIndentMList = new ArrayList<StoreIndentM>();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
			pagedArray = (PagedArray) map.get("pagedArray");
		}
		
		
		if(map.get("searchStoreIndentMList")!=null)
			searchStoreIndentMList = (List) map.get("searchStoreIndentMList");
		
		
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
		
		String date = (String)utilMap.get("currentDate");
		String time = (String)utilMap.get("currentTime");
		String userName = "";
		
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		
		box.put("indent",box.getString("indent_type"));
		
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

<h2 align="left" class="style1">Rate Contract / ATSO</h2>

<div id="contentspace"><br />


<form name="supplyOrder" method="post"><input type="hidden"
	name="numOfRows" size="5" value="5"> <input type="hidden"
	name="pageCount" size="5" value="10"> <input type="hidden"
	name="deptId" size="5" value="<%=deptId %>"> <br />

<input type="radio" id="indent1" name="indent" size="" value="p"
	<%=box.getString("indent").equalsIgnoreCase("p")==true?"checked":"" %>
	onClick="populateIndentNo(this.value,'supplyOrder');"> Indent
to DGFMC <input type="radio" id="indent2" name="indent" size=""
	value="s"
	<%=box.getString("indent").equalsIgnoreCase("s")==true?"checked":"" %>
	onClick="populateIndentNo(this.value,'supplyOrder');"> Indent
to SOC <br />
<br />


<label class="bodytextB">Indent No:</label> <select id="indentNo"
	name="<%=INDENT_NO%>" validate="Indent No,String,no"
	onChange="getIndent();">
	<option value="0" selected>Select</option>
	<% for (StoreIndentM storeIndentM : searchStoreIndentMList)
		{%>
	<option value=<%=storeIndentM.getId() %>
		<%=HMSUtil.isSelected(storeIndentM.getId().toString(),box.getString(INDENT_NO))%>>
	<%=storeIndentM.getIndentNo() %></option>
	<%}
		%>
</select> <input type="button" name="add" id="addbutton" value="Add Item"
	class="button" onClick="openPopupWindow();" accesskey="a" tabindex=1 />

<input type="hidden" name="<%=CHANGED_BY %>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <br />

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
			<td width="10%"><label valign="left" class="smalllabel">Date
			of Recpt</label></td>
			<td width="13%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Nomenclature</label></td>
			<td width="13%"><label valign="left" class="smalllabel">A/U</label></td>
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
			<td width="13%"><label valign="left" class="smalllabel">CRV
			No & Date </label></td>
			<td width="13%"><label valign="left" class="smalllabel">Enclosure
			No</label></td>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=14>No Data Found</td>
		</tr>
	</tbody>
</table>
</div>
</fieldset>
<% } else { %>
<fieldset style="width: 99%; padding-left: 9px;"><legend>Receipt
Details</legend>
<div
	style="overflow: auto; width: 100%; height: 175px; padding-left: 9px;">
<table width="100%" colspan="7" id="indentDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<td width="10%"><label valign="left" class="smalllabel">SR
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Date
			of Recpt</label></td>
			<td width="13%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Nomenclature</label></td>
			<td width="13%"><label valign="left" class="smalllabel">A/U</label></td>
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
			<td width="13%"><label valign="left" class="smalllabel">Supplier
			Address</label></td>
			<td width="13%"><label valign="left" class="smalllabel">CRV
			No & Date </label></td>
			<td width="13%"><label valign="left" class="smalllabel">Enclosure
			No</label></td>
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
			<td width="5%"><input type="text"
				value="<%=gridData[i].get("date_of_receipt")%>" class="smcaption"
				name="date_of_receipt" readonly="readonly" /></td>
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
				value="<%=gridData[i].get("qty_recd")%>" name="qty_recd"
				validate="Qty Received,float,no" readonly="readonly" /></td>
			<td width="12%"><input type="text"
				value="<%=gridData[i].get("batch_no")%>" name="batch_no"
				validate="Batch No,string,no" readonly="readonly" /></td>
			<td width="12%"><input type="text"
				value="<%=gridData[i].get("manuf_date")%>" name="manuf_date"
				readonly="readonly" /></td>
			<td width="12%"><input type="text"
				value="<%=gridData[i].get("expiry_date")%>" name="expiry_date"
				readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("supplyOrderNo")%>" name="supplyOrderNo"
				validate="supplyOrderNo Qty,string,no" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("supplyOrderDate")%>"
				name="supplyOrderDate" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("supplier_address")%>"
				name="supplier_address" class="bigcaption" readonly="readonly" /> </textarea>
			</td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("crv_no_date")%>" name="crv_no_date"
				readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("enclosure_no")%>" name="enclosure_no"
				readonly="readonly" /></td>
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
	onClick="submitForm('supplyOrder','stores?method=updateSupplyOrder');"
	accesskey="a" tabindex=1 /> <input type="button" name="close"
	id="closebutton" value="Close" class="button"
	onClick="showSupplyOrder('supplyOrder')" accesskey="u" tabindex=1 /> <% } %>


</form>
</div>

