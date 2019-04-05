<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreTenderM"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascrip"
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

<%
	String date = "";
	String time = "";
	String userName = "";
	int hospitalId = 0;
	int deptId = 0;
	String manufacturer_lab_practice = "";
	String standing_certificate="";
	String no_conviction_issued="";
	String status="";
	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	Box box = HMSUtil.getBox(request);
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	
  	Map map = new HashMap();
	List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();
	List<MasStoreGroup> masStoreGroupList = new ArrayList<MasStoreGroup>();
	List<MasStoreSupplier> masStoreSupplierList = new ArrayList<MasStoreSupplier>();

	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		
		if (map.get("storeTenderMList") != null)
		{
		storeTenderMList =   (ArrayList)map.get("storeTenderMList");
		System.out.println("inside jsp" + storeTenderMList.size());
		}
	
		if (map.get("masStoreGroupList") != null)
		masStoreGroupList = (ArrayList)map.get("masStoreGroupList");
		
		if (map.get("masStoreSupplierList") != null)
		masStoreSupplierList = (ArrayList)map.get("masStoreSupplierList");
		
		if (map.get("pagedArray") != null)
		pagedArray = (PagedArray)map.get("pagedArray");
		
  }
	
	if(session.getAttribute("userName") != null)
 	{
		userName = (String)session.getAttribute("userName");
	}
 		
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	
	if (session.getAttribute("deptId") != null) {
		Integer temp =  (Integer)session.getAttribute("deptId");
		deptId = temp.intValue();
	}
%>

<script>

//this function will be called by the Bean (not from JSP)
function goPage(pidx) 
{	
	TenderPNCForm.currPage.value = pidx;
	TenderPNCForm.method="post";
	submitForm('TenderPNCForm','tender?method=getTenderPNCGrid');
}

function onChangeTender()
{
//TenderPNCForm.<%=TENDER_SUPPLIER_GROUP_ID%>.options.length=1;
//TenderPNCForm.<%=TENDER_VENDOR_SUPPLIER_ID%>.options.length=1;
TenderPNCForm.method="post";
submitForm('TenderPNCForm','tender?method=getTenderGroupListForPNC');
}

function onChangeGroup()
{
//TenderPNCForm.<%=TENDER_VENDOR_SUPPLIER_ID%>.options.length=1;
TenderPNCForm.method="post";
submitForm('TenderPNCForm','tender?method=getTenderSupplierListForPNC');
}

function onChangeSupplier(flag) 
{
	TenderPNCForm.method="post";	
	submitForm('TenderPNCForm','tender?method=getTenderPNCGrid&flag='+flag);
}

function onUpdate()
{
TenderPNCForm.method="post";
submitForm('TenderPNCForm','tender?method=updatePNCGridItems');
}

function generateLPO()
{
	TenderPNCForm.method="post";	
	submitForm('TenderPNCForm','tender?method=generateLocalPurchaseOrder');
}

function printLPO()
{
	TenderPNCForm.method="post";	
	submitForm('TenderPNCForm','tender?method=printTenderLocalPurchaseOrder');

}


function pvmsSearch()
	 {
	 	TenderPNCForm.method="post";	
	   var tenderId=document.TenderPNCForm.<%=TENDER_NO%>.value;
	   var groupId=document.TenderPNCForm.<%=TENDER_SUPPLIER_GROUP_ID%>.value;
	   var supplierId=document.TenderPNCForm.<%=TENDER_VENDOR_SUPPLIER_ID%>.value;
	   var pvmsNo=document.TenderPNCForm.pvmsNo.value;
	  // alert("value of pvmsNo--"+pvmsNo)
	   if(pvmsNo != ""){
	   if(tenderId !="" && groupId!= "" && supplierId!= "" ){
		   submitForm('TenderPNCForm','tender?method=getTenderPNCGrid&flag=fresh&pvmsNo='+pvmsNo);
	   		}else{
	     	alert("Please select Tender No Group and Supplier.")
	     	}
	   }else{
	     alert("Please select PVMS No.")
	   }
 }
 
function calTotRate(i){
var length  = document.getElementById('datalength').value 
if(length > 1){
TenderPNCForm.<%=NEW_TOTRATE_MDQ%>[i].value = parseFloat(TenderPNCForm.<%=NEW_RATE_MDQ%>[i].value) + parseFloat(TenderPNCForm.<%=NEW_TAXAMT_MDQ%>[i].value)
}else if(length == 1){
TenderPNCForm.<%=NEW_TOTRATE_MDQ%>.value = parseFloat(TenderPNCForm.<%=NEW_RATE_MDQ%>.value) + parseFloat(TenderPNCForm.<%=NEW_TAXAMT_MDQ%>.value)
} 
}


</script>

<form name="TenderPNCForm" method="post" action=""><input
	type="hidden" name="numOfRows" size="5" value="20"> <input
	type="hidden" name="pageCount" size="5" value="10"> <input
	type="hidden" name="hospitalId" size="5" value="<%=hospitalId%>">
<input type="hidden" name="deptId" size="5" value="<%=deptId%>">
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />

<div id="contentHolder">
<h6>Tender - PNC</h6>
<div class="Clear"></div>
<div class="blockTitle">Tender - PNC</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label>Group</label> <select
	name="<%=TENDER_SUPPLIER_GROUP_ID%>" onChange="onChangeGroup();">
	<option value="">--Select Group--</option>
	<%
			for (Iterator iterator = masStoreGroupList.iterator(); iterator.hasNext();) 
			{
				MasStoreGroup masStoreGroup = (MasStoreGroup)iterator.next();
			%>
	<option value="<%=masStoreGroup.getId()%>"
		<%=HMSUtil.isSelected(masStoreGroup.getId(),Integer.valueOf(box.getInt(TENDER_SUPPLIER_GROUP_ID)))%>><%=masStoreGroup.getGroupName()%></option>
	<%
			}
			%>
</select> <label>Tender No</label> <select name="<%=TENDER_NO%>"
	onChange="onChangeTender();">
	<option value="">--Select Tender No--</option>
	<%
		for (Iterator iterator = storeTenderMList.iterator(); iterator.hasNext();) 
		{
			StoreTenderM storeTenderM = (StoreTenderM)iterator.next();
		%>
	<option value="<%=storeTenderM.getId()%>"
		<%=HMSUtil.isSelected(storeTenderM.getId(),Integer.valueOf(box.getInt(TENDER_NO)))%>><%=storeTenderM.getTenderNo()%></option>
	<%
		}
		%>
</select> <label>Supplier/Vendor</label> <select
	name="<%=TENDER_VENDOR_SUPPLIER_ID%>"
	onChange="onChangeSupplier('fresh');">
	<option value="">--Select Supplier--</option>
	<%
			for (Iterator iterator = masStoreSupplierList.iterator(); iterator.hasNext();) 
			{
				MasStoreSupplier masStoreSupplier = (MasStoreSupplier)iterator.next();
			%>
	<option value="<%=masStoreSupplier.getId()%>"
		<%=HMSUtil.isSelected(masStoreSupplier.getId(),Integer.valueOf(box.getInt(TENDER_VENDOR_SUPPLIER_ID)))%>><%=masStoreSupplier.getSupplierName()%></option>
	<%
			}
			%>
</select>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div class="bottom"><label class="bodytextB">Changed By:</label> <label
	class="value"> <%=userName%> </label> <label class="bodytextB">Changed
Date:</label> <label class="value"> <%=date%> </label> <label class="bodytextB">Changed
Time:</label> <label class="value"> <%=time%> </label></div>
<div class="Clear"></div>
<%
		
		if (pagedArray !=null && map.get("status").toString().equalsIgnoreCase("o")) 
		{
			%>
<div class="Clear"></div>
<input type="button" name="Submit" onClick="onUpdate()" value="Update"
	class="button" accesskey="u" /> <!--  <input type="button" name="Generate LPO" onClick="generateLPO()" value="Generate LPO" class="button" accesskey="o" />  -->
<div class="Clear"></div>
<% } else {
   		%> <!-- <input type="button" name="Print LPO" onClick="printLPO()" value="Print LPO" class="button" accesskey="o" />  -->
<% } %>
<div class="Clear"></div>
<label>PVMS/NIV</label> <input type="text" name="pvmsNo" value=""
	class=""
	onkeypress="submitenter(this,event,'tender?method=getTenderPNCGrid&flag=fresh')" />
<IMG SRC="/hms/jsp/images/s_search.gif" WIDTH="26" HEIGHT="26"
	style="cursor: pointer; float: left;"
	onClick="javascript:pvmsSearch();"
	title="Click here to Search Pvms/Niv">
<div class="Clear"></div>
<%
		if (pagedArray == null) {
		%>
<div class="Clear"></div>
<div class="blockTitle">Item Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="tableHolderAuto">
<table width="100%" colspan="7" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th>Sr No</th>
			<th>PVMS/NIV</th>
			<th>Nomenclature</th>
			<th>Brand Name</th>
			<th>Manufacturer Name</th>
			<th>Dispens. Type</th>
			<th title="Minimum Dispensable Quantity">MDQ</th>
			<th>Tax Amt Per MDQ</th>
			<th>Rate Per MDQ</th>
			<th>Total Rate Per MDQ</th>
			<th title="Maximum Retail Price">MRP</th>
			<th>Comp Rate</th>
			<th>L Cat</th>
			<th>New Rate Per MDQ</th>
			<th>New Tax Amt Per MDQ</th>
			<th>New Total Rate Per MDQ</th>
			<th>Remarks</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=14 align="center">No Items Found</td>
		</tr>
	</tbody>
</table>
</div>
<%  } else { %>
<div class="blockTitle">Item Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="tableHolderAuto">
<table width="100%" colspan="7" cellpadding="0" class="grid_header"
	cellspacing="0">
	<thead>
		<tr>
			<th>Sr No</th>
			<th>PVMS/NIV</th>
			<th>Nomenclature</th>
			<th>Brand Name</th>
			<th>Manufacturer Name</th>
			<th>Dispens. Type</th>
			<th title="Minimum Dispensable Quantity">MDQ</th>
			<th>Tax Amt Per MDQ</th>
			<th>Rate Per MDQ</th>
			<th>Total Rate Per MDQ</th>
			<th title="Maximum Retail Price">MRP</th>
			<th>Comp Rate</th>
			<th>L Cat</th>
			<th>New Rate Per MDQ</th>
			<th>New Tax Amt Per MDQ</th>
			<th>New Total Rate Per MDQ</th>
			<th>Remarks</th>
		</tr>
	</thead>
	<tbody>
		<%   gridData = (HashMap[])pagedArray.getPagedArray();
			int iFirstRow = pagedArray.getFirstRowIdx();
			  for(int i=0;i<gridData.length;i++)
			    {
			    %>
		<tr>
			<td><input type="text" value="<%=iFirstRow++%>"
				name="<%=TENDER_CB_SLNO%>" readonly="readonly" size="3" /></td>
			<td><input type="text" value="<%=gridData[i].get(TENDER_PVMS)%>"
				name="<%=TENDER_PVMS%>" readonly="readonly" size="12" /></td>
			<td><input type="text"
				value="<%=gridData[i].get(TENDER_NOMENCLATURE)%>"
				name="<%=TENDER_NOMENCLATURE%>" readonly="readonly" size="50" /></td>
			<td><input type="text"
				value="<%=gridData[i].get(TENDER_CB_BRAND_NAME)%>"
				name="<%=TENDER_CB_BRAND_NAME%>" readonly="readonly" size="15" /></td>
			<td><input type="text"
				value="<%=gridData[i].get(TENDER_CB_MANF_NAME)==null?"":gridData[i].get(TENDER_CB_MANF_NAME)%>"
				name="<%=TENDER_CB_MANF_NAME%>" readonly="readonly" size="16" /></td>
			<!-- 
				<td>
				<select name="<%=TENDER_CB_DISP_TYPE%>" class="medcaption"/>
				<option value="">--Select--</option>				
				<option value="Bottle of (gm)" <%=HMSUtil.isSelected("Bottle of (gm)",gridData[i].get(TENDER_CB_DISP_TYPE).toString())%>>Bottle of (gm)</option>
				<option value="Bottle of (ml)" <%=HMSUtil.isSelected("Bottle of (ml)",gridData[i].get(TENDER_CB_DISP_TYPE).toString())%>>Bottle of (ml)</option>
				<option value="Each" <%=HMSUtil.isSelected("Each",gridData[i].get(TENDER_CB_DISP_TYPE).toString())%>>Each</option>				
				<option value="Jar of (gm)" <%=HMSUtil.isSelected("Jar of (gm)",gridData[i].get(TENDER_CB_DISP_TYPE).toString())%>>Jar of (gm)</option>
				<option value="Kit of (Tests)" <%=HMSUtil.isSelected("Kit of (Tests)",gridData[i].get(TENDER_CB_DISP_TYPE).toString())%>>Kit of (Tests)</option>
				<option value="No" <%=HMSUtil.isSelected("No",gridData[i].get(TENDER_CB_DISP_TYPE).toString())%>>No</option>
				<option value="Pack of (No)" <%=HMSUtil.isSelected("Pack of (No)",gridData[i].get(TENDER_CB_DISP_TYPE).toString())%>>Pack of (No)</option>
				<option value="Reel of (Mtr)" <%=HMSUtil.isSelected("Reel of (Mtr)",gridData[i].get(TENDER_CB_DISP_TYPE).toString())%>>Reel of (Mtr)</option>
				<option value="Strip of (No)" <%=HMSUtil.isSelected("Strip of (No)",gridData[i].get(TENDER_CB_DISP_TYPE).toString())%>>Strip of (No)</option>
				<option value="Tests" <%=HMSUtil.isSelected("Tests",gridData[i].get(TENDER_CB_DISP_TYPE).toString())%>>Tests</option>
				</select>
				</td>
				 -->

			<td>
			<input type="text" value="<%=gridData[i].get(TENDER_CB_DISP_TYPE)==null?"":gridData[i].get(TENDER_CB_DISP_TYPE)%>"
				name="<%=TENDER_CB_DISP_TYPE%>" size="10" readonly="readonly" /></td>
			<td>
			<input type="text" value="<%=gridData[i].get(TENDER_CB_MDQ)==null?"":gridData[i].get(TENDER_CB_MDQ)%>" name="<%=TENDER_CB_MDQ%>" readonly="readonly" size="5" /></td>
			<td>
			<input type="text" value="<%=gridData[i].get(TAX_AMT_MDQ)==null?"":gridData[i].get(TAX_AMT_MDQ)%>" name="<%=TAX_AMT_MDQ%>" readonly="readonly" size="10" /></td>
			<td>
			 <input type="text" value="<%=gridData[i].get(TENDER_CB_RATE_PER_MDQ)==null?"":gridData[i].get(TENDER_CB_RATE_PER_MDQ)%>"
				name="<%=TENDER_CB_RATE_PER_MDQ%>" readonly="readonly" size="10" /></td>
			<td>
			<input type="text" value="<%=gridData[i].get(TOT_RATE_MDQ)==null?"":gridData[i].get(TOT_RATE_MDQ)%>"
				name="<%=TOT_RATE_MDQ%>" readonly="readonly" size="12" /></td>
			<td>
			 <input type="text" value="<%=gridData[i].get(TENDER_CB_MRP)%>"	name="<%=TENDER_CB_MRP%>" size="12" readonly /></td>
			<td>
			 <input type="text"	value="<%=gridData[i].get(TENDER_CB_COMP_RATE)%>" name="<%=TENDER_CB_COMP_RATE%>" readonly="readonly" size="10" /></td>
			<td>
			  <input type="text" value="<%=gridData[i].get(TENDER_CB_LCAT)%>" name="<%=TENDER_CB_LCAT%>" readonly="readonly" size="5" /></td>
			<%if(gridData[i].get(ITEM_STATUS).toString().equalsIgnoreCase("o")){%>
			<td>
			  <input type="text" value="<%=gridData[i].get(NEW_RATE_MDQ)%>" name="<%=NEW_RATE_MDQ%>" size="12" onblur="calTotRate(<%=i %>);" /></td>
			<td>
			 <input type="text" value="<%=gridData[i].get(NEW_TAXAMT_MDQ)%>" name="<%=NEW_TAXAMT_MDQ%>" size="12" onblur="calTotRate(<%=i %>);" /></td>
			<td>
			 <input type="text"	value="<%=gridData[i].get(NEW_TOTRATE_MDQ)%>" name="<%=NEW_TOTRATE_MDQ%>" size="12" readonly="readonly" /></td>
			<% }else{%>
			<td style="background-color: green;">
			<input type="text" value="<%=gridData[i].get(NEW_RATE_MDQ)%>" name="<%=NEW_RATE_MDQ%>" size="12" readonly="readonly" /></td>
			<td style="background-color: green;">
			 <input type="text"	value="<%=gridData[i].get(NEW_TAXAMT_MDQ)%>" name="<%=NEW_TAXAMT_MDQ%>" size="12" readonly="readonly" /></td>
			<td style="background-color: green;">
			<input type="text"	value="<%=gridData[i].get(NEW_TOTRATE_MDQ)%>" name="<%=NEW_TOTRATE_MDQ%>" size="12" readonly="readonly" /></td>
			<% }%>
			<td>
			 <input type="text"	value="<%=gridData[i].get(TENDER_CB_REMARKS)%>"	name="<%=TENDER_CB_REMARKS%>" size="30" /></td>
			<td>
			<input type="hidden" name="<%=TENDER_ITEM_ID%>"	value="<%=gridData[i].get(TENDER_ITEM_ID)%>" /></td>
			<input type="hidden" name="datalength" id="datalength" value="<%=gridData.length%>">
		</tr>
		<% } %>
	</tbody>
</table>
</div>
<div class="Clear"></div>
<div id="pagination"><%= pagedArray.showIndex()%> <%= pagedArray.getPageIndexHiddenTag()%>
</div>
<div class="Clear"></div>
<% } %>
</div>
</form>
