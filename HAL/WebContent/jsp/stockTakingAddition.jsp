<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>

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
 	if(session.getAttribute("userName") != null)
 	{
		userName = (String)session.getAttribute("userName");
		}

  	Map map = new HashMap();
	if (request.getAttribute("map") != null)
	{
		map = (Map) request.getAttribute("map");
	}

	if (session.getAttribute("hospitalId") != null)
	{
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}

	int pageno=1;
	int totalPages=0;
	int totalRecords = 0;
	if (map.get("pageno")!=null)
	{
		 pageno = Integer.parseInt(map.get("pageno").toString());
	}

	if (map.get("totalPages")!=null)
	{
		 totalPages = Integer.parseInt(map.get("totalPages").toString());
	}

	if (map.get("totalRecords")!=null)
	{
		totalRecords = Integer.parseInt(map.get("totalRecords").toString());
	}

	List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
	List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();

	if (map.get("itemList")!=null)
	{
		itemList = (List)map.get("itemList");
	}

	if (map.get("brandList")!=null)
	{
		brandList = (List)map.get("brandList");
	}
%>

<title>Item Details</title>

<script>

//this function will be called by the Bean (not from JSP)
function GoPage() {
	var pgno = parseInt(stockTakingAddForm.gopage.value);
	var totalPages = parseInt(stockTakingAddForm.totalPages.value);
	if (pgno < 1 || pgno > totalPages)
	{
	alert('Invalid Page No!.....');
	return;
	}
	stockTakingAddForm.pageno.value = pgno;
	stockTakingAddForm.method="post";
	submitForm('stockTakingAddForm','stores?method=showStockTakingAddJsp');
}

function goNext()
{
 var pgno = parseInt(stockTakingAddForm.pageno.value)+1;

 if (pgno > stockTakingAddForm.totalPages.value)
 {
 alert('End of the File Reached!... ');
 return;
 }

 stockTakingAddForm.pageno.value = pgno;
 stockTakingAddForm.method="post";
 submitForm('stockTakingAddForm','stores?method=showStockTakingAddJsp');
}


function goPrevious()
{
 var pgno = parseInt(stockTakingAddForm.pageno.value)-1;

 if (pgno < 1)
 {
 alert('Beginning of the File Reached!... ');
 return;
 }

 stockTakingAddForm.pageno.value = pgno;
 stockTakingAddForm.method="post";
 submitForm('stockTakingAddForm','stores?method=showStockTakingAddJsp');
}

function jsSubmit()
{
		if (stockTakingAddForm.search_text.value!="" && stockTakingAddForm.pvms.value!="")
		{
		alert('Pl. provide any one the inputs........');
		return;
		}
		stockTakingAddForm.method="post";
		submitForm('stockTakingAddForm','stores?method=showStockTakingAddJsp&pageno=1');
}

function validateButton()
{
	if (stockTakingAddForm.<%=ITEMS_TO_BE_ADDED%>.length)
	{
			 for(var i = 0; i < stockTakingAddForm.<%=ITEMS_TO_BE_ADDED%>.length; i++)
			 {
			  if (stockTakingAddForm.<%=ITEMS_TO_BE_ADDED%>[i].checked == true)
             		return true;
			 }
	}
	else
	{
		if (stockTakingAddForm.<%=ITEMS_TO_BE_ADDED%>.checked == true)
			return true;
	}
	return false;
}
function jsAdd()
{
		if (validateButton())
		{
		stockTakingAddForm.method="post";
		submitForm('stockTakingAddForm','stores?method=doAddStockTakingItems');
		}
		else
		alert('Pl. select items to add!......');
}
	function jsClose()
	{
	  window.opener.location.href = "stores?method=showPhysicalStockJsp";
	  if (window.opener.progressWindow)
		 {
	    	window.opener.progressWindow.close()
	  	 }
	  window.close();
	}

</script>
<form name="stockTakingAddForm" method="post">
<div class="titleBg">
<h2>Stock Taking Items Addition</h2>
</div>
<input type="hidden" name="hospitalId" value="<%=hospitalId%>" /> <input
	type="hidden" name="<%=CHANGED_BY %>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input
	type="hidden" name="pageno" value=<%=pageno%> /> <input type="hidden"
	name="totalPages" value=<%=totalPages%> /> <input type="hidden"
	name="totalRecords" value=<%=totalRecords%> /> <input type="hidden"
	name="numOfRows" value=25 /> <input type="hidden"
	name="<%=DEPARTMENT_ID%>" value=<%=box.get(DEPARTMENT_ID)%> /> <input
	type="hidden" name="<%=PHYSICAL_STOCK_DATE%>"
	value=<%=box.get(PHYSICAL_STOCK_DATE)%> />
<div class="clear"></div>
<h4>Store Item(s) Search</h4>
<div class="clear"></div>
<div class="Block"><label class="bodytextB_blue">Item
Name:</label> <input type="text" name="search_text"
	value="<%=box.get("search_text")%>" class="bigcaption1" MAXLENGTH="30" "/>

<label class="bodytextB_blue">Item Code:</label> <input type="text"
	name="pvms" value="<%=box.get("pvms")%>" 
	MAXLENGTH="10" "/> <input type="button" name="Submit" id="addbutton"
	onClick="jsSubmit()" value="Search" class="button" />
<div class="clear"></div>
</div>

<div class="clear"></div>
<%
		if (itemList == null || itemList.size() == 0) {
		%>

<div class="clear"></div>

<h4>Item Details</h4>


<div class="clear"></div>
<div class="smallWithHeight">
<table colspan="7" id="indentDetails" border="0" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>

			<th>Sl. No.</th>
			<th>PVMS/NIV No.</th>
			<th>Item Name</th>
			<th>Uom</th>
			<th>Stock In Hand</th>
			<th>Qty. in MMF</th>
			<th>Loan Recd</th>
			<th>Requested Qty.</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=8 align="center">No Items Found</td>
		</tr>
	</tbody>
</table>
</div>

<%  } else { %>
<div class="paddingTop15"></div>
<h4>Item Details</h4>
<div class="clear"></div>

<div class="smallWithHeight">
<table colspan="7" id="indentDetails" border="0" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>

			<th>Sl. No.</th>
			<th>PVMS/NIV No.</th>
			<th>Item Name</th>
 			<th>Brand</th>
			<th>Batch</th>
			<th colspan="2">Expiry Date</th>
			<th>Cost Price</th>
			<th>ADD</th>
		</tr>
	</thead>
	<tbody>
		<%
			    int slno = 1;
			    MasStoreItem masStoreItem = new MasStoreItem();
			    for(int i=0;i<itemList.size();i++)
			    {
			    	masStoreItem = itemList.get(i);
			    %>
		<tr>
			<td><input type="text" value="<%=slno++%>" size="2" name="srno"
				readonly="readonly" /></td>
			<td><input type="text" value="<%=masStoreItem.getPvmsNo()%>"
				class="medcaption" name="pvms_no" readonly="readonly" /></td>
			<td><input type="text"
				value="<%=masStoreItem.getNomenclature()%>" class="bigcaption"
				name="nomenclature" readonly="readonly" /></td>
			<td>
					<select name="brand">
						<%
						for(int j=0;j<brandList.size();j++)
						{
							if (masStoreItem.equals(brandList.get(j).getItem()))
							{
							%>
							<option value="<%=brandList.get(j).getId()%>"><%=brandList.get(j).getBrandName()%></option>
						<%
							}
						}
						%>
					</select>
					</td> 
			<td><input type="text" value="" name="batch"
				validate="Batch,String,no" /></td>
			<td><input type="text" size="8" name="expiry" id="expiry<%=i%>"
				MAXLENGTH="30" tabindex="1" /></td>
			<td><img src="/hms/jsp/images/cal.gif" width="16" height="16"
				border="0" validate="Pick a date" class="calender" tabindex="1"
				onClick="setdate('<%=date%>',document.getElementById('expiry<%=i%>'),event)" />
			</td>
			<td><input type="text" value="" name="cost_price"
				validate="Cost Price,numeric,no" /></td>
			<td><input type="checkbox" name=<%=ITEMS_TO_BE_ADDED%>
				class="smcaption" value="<%=masStoreItem.getId()%>"/></td>
			<td><input type="hidden" value="<%=masStoreItem.getId()%>"
				name="itemId" /></td>
		</tr>
		<% }
				   } %>
	</tbody>
</table>
</div>
<div class="clear"></div>
<% if (totalPages > 0 ) { %>
<div id="pagination">Page <span class="selected"><%=pageno %></span>
of <span class="selected"><%=totalPages %></span> <a
	href="javascript:goPrevious()">Prev</a>&nbsp;&nbsp; <a
	href="javascript:goNext()">Next</a> <input type="text" name="gopage"
	size="3" /> <input type="button" name="Go Page" type="submit"
	class="button" onclick="javascript:GoPage();"/></div>
<% } %>

<div>
<div class="clear"></div>
<input type="button" name="Add" onClick="jsAdd()" value="Add"
	class="button" /> <input type="button" name="Close"
	onClick="jsClose()" value="Close" class="button" /></div>
</form>



