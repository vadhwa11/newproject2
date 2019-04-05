<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * indent.jsp
 * Purpose of the JSP -  This is for indent.
 * @author  Mansi
 * @author  Deepali
 * Create Date: 21th Feb,2008
 * Revision Date:
 * Revision By:
 * @version 1.28
--%>

<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.StoreAdjustmentM"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreAdjustmentT"%>

<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StoreStockTakingT"%>
<%@page import="jkt.hms.masters.business.StoreStockTakingM"%>
<%@page import="java.math.BigDecimal;"%>



<script type="text/javascript" src="/hms/jsp/js/actb.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<script>
function checkAdjustment(){

	if(document.getElementById('searchField').value == ''){
		alert("Please enter in textfield");
		return false;
	}else
		return true;
}

function GoPage() {
	var pgno = parseInt(document.adjustmentGrid.gopage.value);
	var totalPages = parseInt(document.adjustmentGrid.totalPages.value);
	if (pgno < 1 || pgno > totalPages)
	{
	alert('Invalid Page No!.....');
	return;
	}
	document.adjustmentGrid.pageno.value = pgno;
	document.adjustmentGrid.method="post";
	submitForm('adjustmentGrid','stores?method=showAdjustmentJsp');
}

function goNext()
{
 var pgno = parseInt(document.adjustmentGrid.pageno.value)+1;

 if (pgno > document.adjustmentGrid.totalPages.value)
 {
 alert('End of the File Reached!... ');
 return;
 }

 document.adjustmentGrid.pageno.value = pgno;
 document.adjustmentGrid.method="post";
 submitForm('adjustmentGrid','stores?method=showAdjustmentJsp');
}


function goPrevious()
{
 var pgno = parseInt(document.adjustmentGrid.pageno.value)-1;

 if (pgno < 1)
 {
 alert('Beginning of the File Reached!... ');
 return;
 }

 document.adjustmentGrid.pageno.value = pgno;
 document.adjustmentGrid.method="post";
 submitForm('adjustmentGrid','stores?method=showAdjustmentJsp');
}

function adjust()
{
if (confirm("Computed Stock will get Adjusted. Are You Sure?"))
{
submitForm('adjustmentGrid','stores?method=addAdjustment');
}
}
</script>

<script>
	<%

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}

	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
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

	int monthSearch = gregorianCalendar1.get(Calendar.MONTH) + 1;
	if (monthSearch < 10) {
		orderDateOnly.append("0");
		orderDateOnly.append(monthSearch);
	} else {
		orderDateOnly.append(monthSearch);
	}

	orderDateOnly.append("/");
	int year1 = gregorianCalendar1.get(Calendar.YEAR);
	orderDateOnly.append(year1);
	String currentDate = new String(orderDateOnly);
%>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date1 = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	int pageNo=1;
		List<StoreAdjustmentM> searchStoreAdjustmentMList = new ArrayList<StoreAdjustmentM>();


	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}

	String max="";
	if(map.get("max")!=null)
		max = (String) map.get("max");

	if(map.get("searchStoreAdjustmentMList")!=null){
	searchStoreAdjustmentMList = (List) map.get("searchStoreAdjustmentMList");
	}

	List<StoreStockTakingM> searchStoreStockTakingMList= new ArrayList<StoreStockTakingM>();

	if(map.get("searchStoreStockTakingMList")!=null){
		searchStoreStockTakingMList = (List) map.get("searchStoreStockTakingMList");
	}

	List<StoreStockTakingT> searchStoreStockTakingTList= new ArrayList<StoreStockTakingT>();

	if(map.get("searchStoreStockTakingTList")!=null){
		searchStoreStockTakingTList = (List) map.get("searchStoreStockTakingTList");
	}
	int departmentId=0;
	if(map.get("departmentId")!=null){
		departmentId = (Integer) map.get("departmentId");
	}
	int physicalStockMId=0;
	if(map.get("physicalStockMId")!=null){
		physicalStockMId = (Integer) map.get("physicalStockMId");
	}
	int pageno = 0;
	int totalPages = 0;
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

	String flag="";
	if(map.get("flag")!=null)
		 flag = (String)map.get("flag");

	String physicalStockMDate="";
	if(map.get("physicalStockMDate")!=null)
		physicalStockMDate = (String)map.get("physicalStockMDate");

%>

<div class="clear"></div>
<form name="adjustmentGrid" method="post">

<div class="titleBg">
<h2>Adjustment</h2>
</div>
<div class="clear"></div>

<%
 	if (searchStoreStockTakingTList.size() > 0 )
    {
   	%>
<div class="Block">
<input type="hidden" name="<%=DEPARTMENT_ID%>"	value="<%=departmentId %>"/>
<input type="hidden"	name="<%=PHYSICAL_STOCK_ID_ID%>" value="<%=physicalStockMId %>"/>
<label><span>*</span> Adjustment No </label>
<input type="text" name="<%=ADJUSTMENT_NO %>" value="<%=max %>"	validate="Adjustment No.,string,yes" class="textbox_size20"	MAXLENGTH="12"/>
<label><span>*</span> Adjustment Date</label>
<input type="text" name="<%=ADJUSTMENT_DATE%>" class="readOnly"	readonly="readonly" value="<%=currentDate %>" class="textbox_size20" MAXLENGTH="100" />
<label><span>*</span> Reason</label>
<input	type="text" name="<%=REASON %>" value="" class="textbox_size20"	tabindex=3 maxlength="100"  validate="Reason,string,yes" />
<div class="clear"></div>
<label> Remarks</label>
<input type="text"	name="<%=REMARKS %>" value="" class="textbox_size20" tabindex=3	maxlength="100" />
<label> Approved By</label>
<input	type="text" name="<%=APPROVED_BY_EMPLOYEE_ID_ADJUSTMENT %>" value="" class="textbox_size20" tabindex=3 maxlength="12"    />
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input	type="button" name="add" value="Adjust" class="button"	onclick="javascript:adjust()" tabindex=1 />
<input type="hidden"	name="<%=CHANGED_BY %>" value="<%=userName%>" />
<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=date1%>" />
<input type="hidden"	name="<%=CHANGED_TIME %>" value="<%=time%>" />
<input type="hidden"     name="<%=NO_OF_ROWS%>" id="rr" value="22" />
<input type="hidden"	 name="pageno" value="<%=pageno%>" />
<input type="hidden"	name="totalPages" value="<%=totalPages%>" />
<input type="hidden"	name="totalRecords" value="<%=totalRecords%>" />
<input type="hidden"	name="numOfRows" value="5" />
<input type="hidden"	name="<%=PHYSICAL_STOCK_DATE %>" value=<%=physicalStockMDate%> />
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div class="clear"></div>

<h4>Adjustment details</h4>
<div class="cmntable">
<table colspan="7" id="indentDetails" border="0" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th>Sl. No.</th>
			<th>PVMS/NIV No.</th>
			<th>Nomenclature</th>
			<th>A/U</th>
			<!-- <td width="10%"><label valign="left" class="smalllabel">Brand Name</label></td> -->
			<th>Batch No.</th>
			<th>Expiry Date</th>
			<th>Computed Stock</th>
			<th>Surplus</th>
			<th>Deficient</th>
			<th>Final Stock</th>
		</tr>
	</thead>
	<tbody>

		<%int firstRow=1;
   			int i=0; int slno = 1;
   			firstRow=firstRow +((pageno-1)*5);
			Iterator itr= searchStoreStockTakingTList.iterator();
			while(itr.hasNext())
			{
				StoreStockTakingT storeStockTakingT =(StoreStockTakingT)itr.next();
		%>
		<tr>

			<td width="10%"><input type="text" size="2" value="<%=firstRow%>"
				name="<%=SR_NO%>" class="readOnly" readonly="readonly" id="" /></td>

			<td><input type="text" 
				name="<%=ITEM_PVMS_NO%>"
				value="<%=storeStockTakingT.getItem().getPvmsNo()%>"
				class="readOnly" readonly="readonly" id="" /></td>

			<td><input type="text"
				value="<%=storeStockTakingT.getItem().getNomenclature()%>"
				name="<%=ITEM_NOMENCLATURE%>" class="readOnly" readonly="readonly"
				id="" /></td>

			<%	String itemUnitName = "";
				int itemUnitId=0;
				if(storeStockTakingT.getItem().getItemConversion() != null){
					itemUnitName = storeStockTakingT.getItem().getItemConversion().getPurchaseUnit().getUnitName();
					itemUnitId = storeStockTakingT.getItem().getItemConversion().getId();
				}
			%>

			<td><input type="text"
				value="<%=itemUnitName%>" name="<%=ITEM_AV%>" class="readOnly"
				readonly="readonly" id="" /></td>

			<%--

			<td width="13%">
			<input type="text"  size="2" value="<%=brandName%>" name="<%=BRAND_NAME%>"  readonly="readonly" id="" />
			</td>
			--%>
			<td><input type="text" 
				value="<%=storeStockTakingT.getBatchNo() %>" name="<%=BATCH%>" id=""
				class="readOnly" readonly="readonly" /></td>

			<%
			String expiry_date = "";
			try
			{
				expiry_date = HMSUtil.convertDateToStringWithoutTime(storeStockTakingT.getExpiryDate());
			}
			catch(Exception e)
			{
				expiry_date="";
			}
			%>
			<td><input type="text" 
				name="<%=EXPIRY_DATE %>" value="<%=expiry_date%>" class="readOnly"
				readonly="readonly" />

			<input type="hidden" value="<%=storeStockTakingT.getComputedStock() %>"
				name="<%=COMPUTED_STOCK_TEMP%>" class="readOnly" readonly="readonly" />
			<input type="hidden" size="2" value="<%=storeStockTakingT.getComputedStock() %>"
				name="<%=COMPUTED_STOCK%>" />
			<input type="hidden" name="<%=PHYSICAL_STOCK_ID %>"
				value="<%=storeStockTakingT.getStockTakingM().getId() %>"/>
			<input type="hidden" name="<%=PHYSICAL_STOCK_T_ID %>"
				value="<%=storeStockTakingT.getId() %>" />
				<input type="hidden"
				value="<%=storeStockTakingT.getStoreStockService()%>"
				class="smalllabel" name="<%=STOCK_IN_STORES %>" tabindex="2"
				validate="Stock in Stores Service,num,no" MAXLENGTH="8"
				readonly="readonly" />
				<input type="hidden"
				value="<%=storeStockTakingT.getStoreStockDefective()%>"
				class="smalllabel" name="<%=STOCK_IN_DEFECTIVE %>" tabindex="2"
				validate="Stock in Stores Defective,num,no" MAXLENGTH="8"
				readonly="readonly" /></td>

			<td><input type="text" class="readOnly"
				readonly="readonly"
				value="<%=storeStockTakingT.getComputedStock()%>" name=""
				MAXLENGTH="8" readonly="readonly" /></td>

			<td><input type="text" class="readOnly"
				readonly="readonly" value="<%=storeStockTakingT.getStockSurplus()%>"
				name="<%=SURPLUS_STOCK %>" MAXLENGTH="8" readonly="readonly" /></td>

			<td><input type="text" class="readOnly"
				readonly="readonly"
				value="<%=storeStockTakingT.getStockDeficient()%>"
				name="<%=DEFICIENT %>" MAXLENGTH="8" readonly="readonly" /></td>

			<%
           BigDecimal finalStock = new BigDecimal(0);
           try
           {
           		BigDecimal compStock = storeStockTakingT.getComputedStock();
           		BigDecimal defi = storeStockTakingT.getStockDeficient();
           		BigDecimal surplus = storeStockTakingT.getStockSurplus();
           		finalStock = compStock.add(surplus).subtract(defi);
           }
           catch(Exception e)
           {
				finalStock = new BigDecimal(0);
           }

           %>
			<td><input type="text" class="readOnly"
				readonly="readonly" value="<%=finalStock%>" name="" MAXLENGTH="8"
				readonly="readonly" />


			<input type="hidden" value="" name="<%=REMARKS_TEMP %>"
				class="readOnly" readonly="readonly" MAXLENGTH="30" />
			<input type="hidden" class="readOnly" readonly="readonly" size="2"
				value="emptyString" name="<%=REMARKS %>" validate="Remarks,string,no" readonly="readonly" />
			</td>
		</tr>
		<%	i++; firstRow++;
				 } %>
	</tbody>
</table>
</div>
<% if (totalPages > 0 ) { %>
<div id="pagination">Page <span class="selected"><%=pageno %></span>
of <span class="selected"><%=totalPages %></span> <a
	href="javascript:goPrevious()" class="previous">Prev</a>&nbsp;&nbsp; <a
	href="javascript:goNext()" class="next">Next</a> <input type="button"
	name="Go Page" type="submit" class="button" value=" "
	onclick="javascript:GoPage();"><input type="text" name="gopage"
	size="3" /> <% } %>
</div>
<%
   }
   else
   {%> <br>
<h4><span> No Record Found !! </span></h4>
<% } %>

</form>

<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script>
<input type="hidden" name="rows" id="rr" value="1" />

