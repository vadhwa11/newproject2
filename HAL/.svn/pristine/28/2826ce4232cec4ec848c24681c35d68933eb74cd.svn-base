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
		}
	
		if (map.get("masStoreGroupList") != null)
		masStoreGroupList = (ArrayList)map.get("masStoreGroupList");
		
		if (map.get("masStoreSupplierList") != null)
		masStoreSupplierList = (ArrayList)map.get("masStoreSupplierList");
		
		if (map.get("status") != null)
			status = map.get("status").toString();
		
		if (map.get(TENDER_TB_GOOD_MANUF_LABORATORY_PRACTICES)!=null)
		{
			manufacturer_lab_practice = map.get(TENDER_TB_GOOD_MANUF_LABORATORY_PRACTICES).toString();
		}
		
		if (map.get(TENDER_TB_MARKET_STANDING_CERTIFICATE)!=null)
		{
			standing_certificate=map.get(TENDER_TB_MARKET_STANDING_CERTIFICATE).toString();
		}
		
		if (map.get(TENDER_TB_NO_CONVICTION_CERTIFICATE)!=null)
		{
			no_conviction_issued=map.get(TENDER_TB_NO_CONVICTION_CERTIFICATE).toString();
		}
		
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

<title>Tender - Technical Bid</title>

<script>

//this function will be called by the Bean (not from JSP)
function goPage(pidx) 
{	
	TechnicalBidForm.currPage.value = pidx;
	TechnicalBidForm.method="post";
	submitForm('TechnicalBidForm','tender?method=getTenderTechnicalBidGrid');
}

function onChangeTender()
{
TechnicalBidForm.<%=TENDER_VENDOR_SUPPLIER_ID%>.options.length=1;
TechnicalBidForm.method="post";
submitForm('TechnicalBidForm','tender?method=getTenderSupplierList');
}

function onChangeGroup()
{
//TechnicalBidForm.<%=TENDER_SUPPLIER_GROUP_ID%>.options.length=1;
//TechnicalBidForm.<%=TENDER_VENDOR_SUPPLIER_ID%>.options.length=1;
TechnicalBidForm.method="post";
submitForm('TechnicalBidForm','tender?method=getTenderGroupList');
}

function onChangeSupplier(flag) 
{
	TechnicalBidForm.method="post";	
	submitForm('TechnicalBidForm','tender?method=getTenderTechnicalBidGrid&flag='+flag);
}

function onUpdate()
{
TechnicalBidForm.method="post";
submitForm('TechnicalBidForm','tender?method=updateTechnicalBidGridItems');
}

function gotoPrevious()
{
	var ind = TechnicalBidForm.<%=TENDER_VENDOR_SUPPLIER_ID%>.selectedIndex;
	
	if (ind == '1' || ind =='0')
	{
	alert('Press Next to See Next Record');
	return;
	}

	ind = ind - 1;
	TechnicalBidForm.<%=TENDER_VENDOR_SUPPLIER_ID%>.selectedIndex = ind;
	TechnicalBidForm.method="post";	
	submitForm('TechnicalBidForm','tender?method=getTenderTechnicalBidGrid&flag=fresh');
}


function gotoNext()
{
	var len = TechnicalBidForm.<%=TENDER_VENDOR_SUPPLIER_ID%>.options.length;
	var ind = TechnicalBidForm.<%=TENDER_VENDOR_SUPPLIER_ID%>.selectedIndex;
	if (ind == len-1)
	{
	alert('Press Previous to See Previous Record');
	return;
	}

	ind = ind + 1;
	TechnicalBidForm.<%=TENDER_VENDOR_SUPPLIER_ID%>.selectedIndex = ind;
	TechnicalBidForm.method="post";	
	submitForm('TechnicalBidForm','tender?method=getTenderTechnicalBidGrid&flag=fresh');
}

	function pvmsSearch()
	 {
	 	TechnicalBidForm.method="post";	
	   var tenderId=document.TechnicalBidForm.<%=TENDER_NO%>.value;
	   var groupId=document.TechnicalBidForm.<%=TENDER_SUPPLIER_GROUP_ID%>.value;
	   var supplierId=document.TechnicalBidForm.<%=TENDER_VENDOR_SUPPLIER_ID%>.value;
	   var pvmsNo=document.TechnicalBidForm.pvmsNo.value;
	  // alert("value of pvmsNo--"+pvmsNo)
	   if(pvmsNo != ""){
	   if(tenderId !="" && groupId!= "" && supplierId!= "" ){
		   submitForm('TechnicalBidForm','tender?method=getTenderTechnicalBidGrid&flag=fresh&pvmsNo='+pvmsNo);
	   		}else{
	     	alert("Please select Tender No Group and Supplier.")
	     	}
	   }else{
	     alert("Please select PVMS No.")
	   }
	 }

</script>

<form name="TechnicalBidForm" method="post" action=""><input
	type="hidden" name="numOfRows" size="5" value="20"> <input
	type="hidden" name="pageCount" size="5" value="10"> <input
	type="hidden" name="hospitalId" size="5" value="<%=hospitalId%>">
<input type="hidden" name="deptId" size="5" value="<%=deptId%>">
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />

<div id="contentHolder">
<h6>Tender - Technical Bid</h6>
<div class="Clear"></div>
<div class="blockTitle">Technical Bid</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label>Group</label> <select
	name="<%=TENDER_SUPPLIER_GROUP_ID%>" onChange="onChangeGroup();"
	class="large">
	<option value="">Select Group</option>
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
	<option value="">Select Tender No.</option>
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
	<option value="">Select Supplier</option>
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
<div class="Height10"></div>
<label class="noWidth">Manf. Lab Practices</label> <select
	name="<%=TENDER_TB_GOOD_MANUF_LABORATORY_PRACTICES%>" class="small">
	<option value="Y"
		<%=HMSUtil.isSelected("Y",manufacturer_lab_practice.toUpperCase())%>>Yes</option>
	<option value="N"
		<%=HMSUtil.isSelected("N",manufacturer_lab_practice.toUpperCase())%>>No</option>
</select> <label class="noWidth">&nbsp;No Convic. Certificate </label> <select
	name="<%=TENDER_TB_NO_CONVICTION_CERTIFICATE%>" class="small">
	<option value="Y"
		<%=HMSUtil.isSelected("Y",no_conviction_issued.toUpperCase())%>>Yes</option>
	<option value="N"
		<%=HMSUtil.isSelected("N",no_conviction_issued.toUpperCase())%>>No</option>
</select> <label class="noWidth">Mkt. Standing Certificate </label> <select
	name="<%=TENDER_TB_MARKET_STANDING_CERTIFICATE%>" class="small">
	<option value="Y"
		<%=HMSUtil.isSelected("Y",standing_certificate.toUpperCase())%>>Yes</option>
	<option value="N"
		<%=HMSUtil.isSelected("N",standing_certificate.toUpperCase())%>>No</option>
</select> <label class="noWidth">Acceptance Lr Attached</label> <select
	name="acceptance_letter" class="small">
	<option value="Y" <%=HMSUtil.isSelected("Y","Y")%>>Yes</option>
	<option value="N" <%=HMSUtil.isSelected("N","N")%>>No</option>
</select>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div class="bottom"><label>Changed By:</label> <label
	class="value"> <%=userName%> </label> <label>Changed Date:</label> <label
	class="value"> <%=date%> </label> <label>Changed Time:</label> <label
	class="value"> <%=time%> </label></div>
<div class="Clear"></div>
<% if (pagedArray !=null && status.equalsIgnoreCase("O")) 
		{ %>

<div class="Clear"></div>
<input type="button" name="Submit" onClick="onUpdate()" value="Update"
	class="button" accesskey="u" />
<div class="Clear"></div>
<% } %> <% if (pagedArray !=null) 
		{ %>
<div class="Clear"></div>
<input type="button" name="Previous" onClick="gotoPrevious()"
	value="Previous" class="button" accesskey="p" /> <input type="button"
	name="Next" onClick="gotoNext()" value="Next" class="button"
	accesskey="n" />
<div class="Clear"></div>
<% } %>
<div class="Clear"></div>
<label>PVMS/NIV</label> <input type="text" name="pvmsNo" value=""
	onkeypress="submitenter(this,event,'tender?method=getTenderTechnicalBidGrid&flag=fresh')" />
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
			<th>A/U</th>
			<th>Dispens. Type</th>
			<th>MDQ</th>
			<th>Rate Per MDQ</th>
			<th>Items Submitted</th>
			<th>Manuf. Licence</th>
			<th>Cert. to Market</th>
			<th>Remarks</th>
			<th>Disqual.</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=13 align="center">No Items Found</td>
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
			<th>A/U</th>
			<th>Composition</th>
			<th>Dispens. Type</th>
			<th>MDQ</th>
			<th>Rate Per MDQ</th>
			<th>Items Submitted</th>
			<th>Manuf. Licence</th>
			<th>Cert. to Market</th>
			<th>Remarks</th>
			<th>Disqual.</th>
		</tr>
	</thead>
	<tbody>


		<%
			    gridData = (HashMap[])pagedArray.getPagedArray();
				int iFirstRow = pagedArray.getFirstRowIdx();
			    for(int i=0;i<gridData.length;i++)
			    {
			    	String checked = "";
			    	if (gridData[i].get(TENDER_TB_DISQUALIFIED)!=null && gridData[i].get(TENDER_TB_DISQUALIFIED).toString().equalsIgnoreCase("N")) checked = "checked";
			    %>
		<tr>
			<td><input type="text" value="<%=iFirstRow++%>"
				name="<%=TENDER_TB_SLNO%>" readonly="readonly" size="3" /></td>
			<td><input type="text"
				value="<%=gridData[i].get(TENDER_TB_PVMS)%>"
				name="<%=TENDER_TB_PVMS%>" readonly="readonly" size="7" /></td>
			<td><input type="text"
				value="<%=gridData[i].get(TENDER_TB_NOMENCLATURE)%>"
				name="<%=TENDER_TB_NOMENCLATURE%>" readonly="readonly" size="50" /></td>
			<td><input type="text"
				value="<%=gridData[i].get(TENDER_TB_BRAND)==null?"":gridData[i].get(TENDER_TB_BRAND)%>"
				name="<%=TENDER_TB_BRAND%>" readonly="readonly" size="15" /></td>
			<td><input type="text"
				value="<%=gridData[i].get(TENDER_TB_MANUFACTURER_NAME)==null?"":gridData[i].get(TENDER_TB_MANUFACTURER_NAME)%>"
				name="<%=TENDER_TB_MANUFACTURER_NAME%>" readonly="readonly"
				size="20" /></td>
			<td><input type="text"
				value="<%=gridData[i].get(TENDER_TB_AU)==null?"":gridData[i].get(TENDER_TB_AU)%>"
				name="<%=TENDER_TB_AU%>" readonly="readonly" size="10" /></td>

			<!-- 
				<td>
				<select name="<%=TENDER_TB_DISP_TYPE%>" />
				<option value="">--Select--</option>				
				<option value="Bottle of (gm)" <%=HMSUtil.isSelected("Bottle of (gm)",gridData[i].get(TENDER_TB_DISP_TYPE).toString())%>>Bottle of (gm)</option>
				<option value="Bottle of (ml)" <%=HMSUtil.isSelected("Bottle of (ml)",gridData[i].get(TENDER_TB_DISP_TYPE).toString())%>>Bottle of (ml)</option>
				<option value="Each" <%=HMSUtil.isSelected("Each",gridData[i].get(TENDER_TB_DISP_TYPE).toString())%>>Each</option>				
				<option value="Jar of (gm)" <%=HMSUtil.isSelected("Jar of (gm)",gridData[i].get(TENDER_TB_DISP_TYPE).toString())%>>Jar of (gm)</option>
				<option value="Kit of (Tests)" <%=HMSUtil.isSelected("Kit of (Tests)",gridData[i].get(TENDER_TB_DISP_TYPE).toString())%>>Kit of (Tests)</option>
				<option value="No" <%=HMSUtil.isSelected("No",gridData[i].get(TENDER_TB_DISP_TYPE).toString())%>>No</option>
				<option value="Pack of (No)" <%=HMSUtil.isSelected("Pack of (No)",gridData[i].get(TENDER_TB_DISP_TYPE).toString())%>>Pack of (No)</option>
				<option value="Reel of (Mtr)" <%=HMSUtil.isSelected("Reel of (Mtr)",gridData[i].get(TENDER_TB_DISP_TYPE).toString())%>>Reel of (Mtr)</option>
				<option value="Strip of (No)" <%=HMSUtil.isSelected("Strip of (No)",gridData[i].get(TENDER_TB_DISP_TYPE).toString())%>>Strip of (No)</option>
				<option value="Tests" <%=HMSUtil.isSelected("Tests",gridData[i].get(TENDER_TB_DISP_TYPE).toString())%>>Tests</option>
				</select>
				</td>
				 -->
			<td><input type="text"
				value="<%=gridData[i].get("composition")==null?"":gridData[i].get("composition")%>"
				name="<%="composition"%>" readonly="readonly" /></td>
			<td><input type="text"
				value="<%=gridData[i].get(TENDER_TB_DISP_TYPE)==null?"":gridData[i].get(TENDER_TB_DISP_TYPE)%>"
				name="<%=TENDER_TB_DISP_TYPE%>" size="10" /></td>

			<td><input type="text"
				value="<%=gridData[i].get(TENDER_TB_MDQ)%>"
				name="<%=TENDER_TB_MDQ%>" size="5" /></td>
			<td><input type="text"
				value="<%=gridData[i].get(TENDER_CB_RATE_PER_MDQ)%>"
				name="<%=TENDER_CB_RATE_PER_MDQ%>" size="5" readonly="readonly" /></td>
			<td><input type="text"
				value="<%=gridData[i].get(TENDER_TB_NO_OF_ITEMS)%>"
				name="<%=TENDER_TB_NO_OF_ITEMS%>" size="5" readonly="readonly" /></td>
			<td><select name="<%=TENDER_TB_MANUFACTURE_LICENCE%>" />
				<option value="Y"
					<%=HMSUtil.isSelected("Y",gridData[i].get(TENDER_TB_MANUFACTURE_LICENCE).toString().toUpperCase())%>>Yes</option>
				<option value="N"
					<%=HMSUtil.isSelected("N",gridData[i].get(TENDER_TB_MANUFACTURE_LICENCE).toString().toUpperCase())%>>No</option>
			</select></td>

			<td><select name="<%=TENDER_TB_CERTIFICATE_TO_MARKET_PRODUCT%>" />
				<option value="Y"
					<%=HMSUtil.isSelected("Y",gridData[i].get(TENDER_TB_CERTIFICATE_TO_MARKET_PRODUCT).toString().toUpperCase())%>>Yes</option>
				<option value="N"
					<%=HMSUtil.isSelected("N",gridData[i].get(TENDER_TB_CERTIFICATE_TO_MARKET_PRODUCT).toString().toUpperCase())%>>No</option>
			</select></td>
			<td><input type="text" name="<%=TENDER_TB_REMARKS%>"
				value="<%=gridData[i].get(TENDER_TB_REMARKS)%>" maxlength="250"
				size="30" /></td>
			<td><input type="checkbox" name="<%=TENDER_TB_DISQUALIFIED%>"
				value="<%=gridData[i].get(TENDER_TB_ITEM_ID)%>" <%=checked%> /></td>
			<td><input type="hidden" name="<%=TENDER_TB_ITEM_ID%>"
				value="<%=gridData[i].get(TENDER_TB_ITEM_ID)%>" /></td>

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
