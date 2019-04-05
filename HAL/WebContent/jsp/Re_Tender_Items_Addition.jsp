<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.util.Box"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
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
html,body {
	overflow: auto;
}

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
 	
  	Map map = new HashMap();
  	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	List existingTenderNumbersList = null;
	List mmfyears = null;
	String tender_no;
	int deptId = 0;
	int proposal_id = 0;
	
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		pagedArray = (PagedArray) map.get("pagedArray");
		System.out.println("map inside jsp" + map);
		
		if (map.get("proposal_id") != null) {
			Integer temp =  (Integer)map.get("proposal_id");
			proposal_id = temp.intValue();
			box.put("proposal_id",proposal_id);
		}
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

<title>Re Tender Creation</title>

<script>

//this function will be called by the Bean (not from JSP)
function goPage(pidx) {	
	tenderForm.currPage.value = pidx;
	tenderForm.method="post";
	submitForm('tenderForm','tender?method=showAddReTenderItemsJsp');
}

function validateAddButton()
{
	if (tenderForm.<%=ITEMS_TO_BE_ADDED%>.length)
	{
			 for(var i = 0; i < tenderForm.<%=ITEMS_TO_BE_ADDED%>.length; i++)
			 {
			  if (tenderForm.<%=ITEMS_TO_BE_ADDED%>[i].checked == true)
             		return true;
			 }
	}
	else
	{
		if (tenderForm.<%=ITEMS_TO_BE_ADDED%>.checked == true)
			return true;
	}
	alert('No Item(s) Selected to Add!....');
	return false;
}

function validateTenderQty()
{
	if (tenderForm.<%=TENDER_ITEM_ID%> && tenderForm.<%=TENDER_ITEM_ID%>.length)
	{
			 for(var i = 0; i < tenderForm.<%=TENDER_ITEM_ID%>.length; i++)
			 {
			 	var total_qty = tenderForm.<%=TENDER_MMFQTY%>[i].value;
			 	var actual_qty = tenderForm.<%=TENDER_ANNREQ%>[i].value;
	   		    if (parseFloat(actual_qty) > parseFloat(total_qty)/2)
	   		    {
	   		    alert("Actual Tender Qty should not be more than Half of the Total Tender Qty!..."); 
	   		    return false;
	   		    }
			 }
		return true;
	}
	else
	{
	alert("Item(s) not found to Add!.....");
	return false;
	}
}


function jsAdd()
{
		if (validateAddButton())
		{
		tenderForm.method="post";
		submitForm('tenderForm','tender?method=doAddReTenderItems');
		}
}

function jsClose()
{
window.opener.location.href = "tender?method=showReTenderProposalJsp&<%=TENDER_NO%>="+tenderForm.<%=TENDER_NO%>.value;
  if (window.opener.progressWindow)
	 {
    	window.opener.progressWindow.close()
  	 } 
  window.close();
}

</script>
<div id="contentholder">
<form name="tenderForm" action="" method="post"><input
	type="hidden" name="numOfRows" size="5" value="15"> <input
	type="hidden" name="pageCount" size="5" value="10"> <input
	type="hidden" name="search" size="5" value="true"> <input
	type="hidden" name=<%=TENDER_NO%> size="5"
	value="<%=box.get(TENDER_NO)%>"> <input type="hidden"
	name=<%=PROPOSAL_ID%> size="5" value="<%=box.get(PROPOSAL_ID)%>">
<input type="hidden" name="deptId" size="5" value="<%=deptId%>">
<input type="hidden" name="hospitalId" size="5" value="<%=hospitalId%>">
<input type="hidden" name="<%=CHANGED_BY%>" size="5"
	value="<%=userName%>"> <input type="hidden"
	name="<%=CHANGED_DATE%>" size="5" value="<%=date%>"> <input
	type="hidden" name="<%=CHANGED_TIME%>" size="5" value="<%=time%>">

<%		
		if (pagedArray == null) {
		%>
<div class="blockTitle">Tender Item Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="tableHolderAuto">
<table align="center" width="100%" colspan="7" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th width="5%">SR No</th>
			<th width="10%">PVMS No</th>
			<th width="30%">Nomenclature</th>
			<th width="10%">A/U</th>
			<th width="10%">Disp Type</th>
			<th width="15%">Stock in Hand</th>
			<th width="10%">Total Tender Qty</th>
			<th width="15%">Actual Tender Qty</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=8 align="center">No Items Found</td>
		</tr>
	</tbody>
</table>
</div>
<div class="Clear"></div>
<input type="button" name="Close" onClick="jsClose()" value="Close"
	class="button" />
<div class="Clear"></div>
<%  } else { %>

<div class="blockTitle">Tender Item Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="tableHolderAuto">

<table align="center" width="100%" colspan="7" class="grid_header"
	cellpadding="0" cellspacing="0">

	<thead>
		<tr>
			<th width="5%">SR No</th>
			<th width="10%">PVMS No</th>
			<th width="30%">Nomenclature</th>
			<th width="10%">A/U</th>
			<th width="10%">Disp Type</th>
			<th width="15%">Stock in Hand</th>
			<th width="10%">Total Tender Qty</th>
			<th width="15%">Actual Tender Qty</th>
			<th>ADD</th>
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
				name="<%=TENDER_SRNO%>" size="3" readonly="readonly" /></td>
			<td><input type="text"
				value="<%=gridData[i].get(TENDER_PVMS )%>" name="<%=TENDER_PVMS %>"
				size="12" readonly="readonly" /></td>
			<td><input type="text"
				value="<%=gridData[i].get(TENDER_NOMENCLATURE)%>" size="50"
				name="<%=TENDER_NOMENCLATURE %>" readonly="readonly" /></td>
			<td><input type="text" value="<%=gridData[i].get(TENDER_AU)%>"
				name="<%=TENDER_AU%>" size="12" readonly="readonly" /></td>
			<td><input type="text"
				value="<%=gridData[i].get("disp_type")%>" name="disp_type" size="12"
				readonly="readonly" /></td>
			<td><input type="text"
				value="<%=(gridData[i].get(TENDER_STOCK_IN_HAND)==null)?"0.000":gridData[i].get(TENDER_STOCK_IN_HAND)%>"
				size="12" name="<%=TENDER_STOCK_IN_HAND%>" readonly="readonly" /></td>
			<td><input type="text"
				value="<%=(gridData[i].get(TENDER_MMFQTY)==null)?"0.000":gridData[i].get(TENDER_MMFQTY)%>"
				name="<%=TENDER_MMFQTY %>" size="12" readonly="readonly" /></td>
			<td><input type="text"
				value="<%=(gridData[i].get(TENDER_ANNREQ)==null)?"0.000":gridData[i].get(TENDER_ANNREQ)%>"
				name="<%=TENDER_ANNREQ %>" size="12"
				validate="Actual Tender Qty,num,no" /></td>
			<td><input type="checkbox" name=<%=ITEMS_TO_BE_ADDED%>
				value="<%=gridData[i].get(TENDER_ITEM_ID)%>"></td>
			<td><input type="hidden"
				value="<%=gridData[i].get(TENDER_ITEM_ID)%>"
				name="<%=TENDER_ITEM_ID%>" /></td>

		</tr>
		<% } %>
	</tbody>
</table>
</div>
<div class="Clear"></div>
<div id="pagination"><%= pagedArray.showIndex()%> <%= pagedArray.getPageIndexHiddenTag()%>
</div>
<div class="Clear"></div>

<input type="button" name="Add" onClick="jsAdd()" value="Add"
	class="button" /> <input type="button" name="Close"
	onClick="jsClose()" value="Close" class="button" /> <%}%>
</form>
</div>
