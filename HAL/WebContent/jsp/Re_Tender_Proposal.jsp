<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.StoreTenderM"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.util.Box"%>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/acnik.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>

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



<script type="text/javascript">
/***********************************************
* Textarea Maxlength script- 
***********************************************/
function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)
}
</script>



<%
	Map map = new HashMap();
	HashMap[] gridData =null;
	PagedArray pagedArray = null;

	String date = "";
	String time = "";
	String userName = "";
	String deptName = "";
	int deptId = 0;
	int hospitalId = 0;
	int tender_no = 0;
	int proposal_id = 0;
	Box box = HMSUtil.getBox(request);
	Map<String,Object> utilMap = new HashMap<String,Object>();
	Map<String,Object> masterDataMap = new HashMap<String,Object>();
	List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();

	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");

 	if (session.getAttribute("userName") != null)
 	{
		userName = (String)session.getAttribute("userName");
	}
 	
 	if (session.getAttribute("deptName") != null)
 	{
		deptName = (String)session.getAttribute("deptName");
	}

 	if (session.getAttribute("deptId") != null)
 	{
		Integer temp = (Integer)session.getAttribute("deptId");
		deptId = temp.intValue();
	}
 	
	if (session.getAttribute("hospitalId") != null) 
	{
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}

	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		pagedArray = (PagedArray) map.get("pagedArray");
		storeTenderMList = (List) map.get("storeTenderMList");
		if (map.get(TENDER_NO)!=null)
		{
			tender_no = Integer.parseInt(map.get(TENDER_NO).toString());
			box.put(TENDER_NO,tender_no);
		}
		
		if (map.get(PROPOSAL_ID)!=null)
		{
			proposal_id = Integer.parseInt(map.get(PROPOSAL_ID).toString());
			box.put(PROPOSAL_ID,proposal_id);
		}
	}
	
%>

<title>Re Tender Proposal</title>
<script>

function openPopupWindow()
{
 if (RetenderProposalForm.<%=TENDER_NO%>.value=="")
 {
 	alert("Please Select Tender No.....");
 	return;
 }
 
 var url="/hms/hms/tender?method=showAddReTenderItemsJsp&numOfRows=15&pageCount=10&tender_no="+RetenderProposalForm.<%=TENDER_NO%>.value + "&proposal_id=" + RetenderProposalForm.<%=PROPOSAL_ID%>.value ;
 newwindow=window.open(url,'name','top=50, left=50, height=600,width=990,status=1');
}

//this function will be called by the Bean (not from JSP)
function goPage(pidx) {	
	RetenderProposalForm.currPage.value = pidx;
	RetenderProposalForm.method="post";
	submitForm('RetenderProposalForm','tender?method=showReTenderProposalJsp');
}

function validateTenderQty()
{
	if (RetenderProposalForm.<%=TENDER_ITEM_ID%> && RetenderProposalForm.<%=TENDER_ITEM_ID%>.length)
	{
			 for(var i = 0; i < RetenderProposalForm.<%=TENDER_ITEM_ID%>.length; i++)
			 {
			 	var total_qty = RetenderProposalForm.<%=TENDER_MMFQTY%>[i].value;
			 	var actual_qty = RetenderProposalForm.<%=TENDER_ANNREQ%>[i].value;
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
	alert("Item(s) not found for Update!.....");
	return false;
	}
}

function upd()
{
RetenderProposalForm.method="post";
submitForm('RetenderProposalForm','tender?method=updateReTenderProposalGridItems');
}

function validateDeleteButton()
{
	if (RetenderProposalForm.<%=ITEMS_TO_BE_DELETED%> && RetenderProposalForm.<%=ITEMS_TO_BE_DELETED%>.length)
	{
			 for(var i = 0; i < RetenderProposalForm.<%=ITEMS_TO_BE_DELETED%>.length; i++)
			 {
			  if (RetenderProposalForm.<%=ITEMS_TO_BE_DELETED%>[i].checked == true)
             		return true;
			 }
	}
	else
	{
		if (RetenderProposalForm.<%=ITEMS_TO_BE_DELETED%> && RetenderProposalForm.<%=ITEMS_TO_BE_DELETED%>.checked == true)
			return true;
	}
	return false;
}

function del()
{
	if (validateDeleteButton())
	{
	RetenderProposalForm.method="post";
	submitForm('RetenderProposalForm','tender?method=deleteReTenderProposalGridItems');
	}
	else
	{
	alert('No Item(s) Selected for delete!....');
	}
}

function printProposal()
{
<% if (pagedArray!=null) { %>
	RetenderProposalForm.method="post";
	submitForm('RetenderProposalForm','tender?method=printReTenderProposalItems');
<% } else { %>
	alert('No Items to print!.........');
<% } %>
}

	function pvmsSearch()
	 {
	 	RetenderProposalForm.method="post";	
	   var pvmsNo=document.RetenderProposalForm.pvmsNo.value;
	  // alert("value of pvmsNo--"+pvmsNo)
	   if(pvmsNo != ""){
	     submitForm('RetenderProposalForm','tender?method=showReTenderProposalJsp&flag=fresh&pvmsNo='+pvmsNo);
	   }else{
	     alert("Please select PVMS No.")
	   }
	 }


</script>

<div id="contentHolder">
<h6>Re Tender Proposal</h6>
<div class="Clear"></div>
<form name="RetenderProposalForm" method="post" action=""><input
	type="hidden" name="numOfRows" size="5" value="15"> <input
	type="hidden" name="pageCount" size="5" value="10"> <input
	type="hidden" name="hospitalId" size="5" value="<%=hospitalId%>">
<input type="hidden" name="deptId" size="5" value="<%=deptId%>">
<input type="hidden" name="<%=PROPOSAL_ID %>" size="5"
	value="<%=box.get(PROPOSAL_ID)%>">
<div class="blockTitle">Re Tender Proposal</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label>Proposal No:</label> <label
	class="value"><%=box.getInt(PROPOSAL_ID)%></label> <label>Tender
No</label> <select name="<%=TENDER_NO%>">
	<option value="">Select Tender No</option>

	<%
			if (storeTenderMList!=null && storeTenderMList.size()>0)
			{
				for(int i=0;i<storeTenderMList.size();i++) 
				{
			%>
	<option value="<%=storeTenderMList.get(i).getId()%>"
		<%=HMSUtil.isSelected(storeTenderMList.get(i).getId(),box.getInt(TENDER_NO)) %>><%=storeTenderMList.get(i).getTenderNo()%></option>
	<% }
				}
			 %>
</select> <label>Department:</label> <label class="value"><%=deptName%></label>

<div class="Clear"></div>

<label>Changed By:</label> <label class="value"><%=userName%></label> <label>Changed
Date:</label> <label class="value"><%=date%></label> <label>Changed
Time:</label> <label class="value"><%=time%></label></div>
<div class="Clear"></div>

<div class="floatRight"><input type="button" name="Add"
	type="submit" value="Add" class="button" onClick="openPopupWindow();">
<input type="button" name="Update" type="submit" value="Update"
	class="button" onClick="upd();"> <input type="button"
	name="Delete" type="submit" value="Delete" class="button"
	onClick="del();"> <input type="button" name="Print"
	type="submit" value="Print" class="button" onClick="printProposal();">
<div class="Clear"></div>
</div>
<div class="Clear"></div>

<label>PVMS/NIV</label> <input type="text" name="pvmsNo" value=""
	tabindex=1
	onkeypress="submitenter(this,event,'tender?method=showReTenderProposalJsp&flag=fresh')" />
<IMG SRC="/hms/jsp/images/s_search.gif" WIDTH="26" tabindex=1
	HEIGHT="26" style="cursor: pointer; float: left;"
	onClick="javascript:pvmsSearch();"
	title="Click here to Search Pvms/Niv"> <%		
		if (pagedArray == null) {
		%>
<div class="Clear"></div>

<div class="blockTitle">Re Tender Proposal Item Details</div>
<div class="blockTitleCurve"></div>
<div class="tableHolderAuto">
<table width="100%" colspan="7" id="indentDetails" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th width="5%">SR No</th>
			<th width="10%">PVMS No</th>
			<th width="30%">Nomenclature</th>
			<th width="15%">A/U</th>
			<th width="15%">Disp Type</th>
			<th width="12%">Stock in Hand</th>
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
<%  } else { %>
<div class="Clear"></div>

<div class="blockTitle">Re Tender Proposal Item Details</div>
<div class="blockTitleCurve"></div>
<div class="tableHolderAuto">
<table width="100%" colspan="7" id="indentDetails" class="grid_header"
	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="5%">SR No</th>
			<th width="10%">PVMS No</th>
			<th width="30%">Nomenclature</th>
			<th width="15%">A/U</th>
			<th width="15%">Disp Type</th>
			<th width="12%">Stock in Hand</th>
			<th width="10%">Total Tender Qty</th>
			<th width="15%">Actual Tender Qty</th>
			<th width="6%">DELETE</th>
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
				name="<%=TENDER_SRNO%>" size="3" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get(TENDER_PVMS )%>" name="<%=TENDER_PVMS %>"
				size="12" readonly="readonly" /></td>
			<td width="30%"><input type="text"
				value="<%=gridData[i].get(TENDER_NOMENCLATURE)%>"
				name="<%=TENDER_NOMENCLATURE %>" size="50" readonly="readonly" /></td>
			<td width="15%"><input type="text"
				value="<%=gridData[i].get(TENDER_AU)%>" name="<%=TENDER_AU%>"
				readonly="readonly" size="12" /></td>
			<td width="15%"><input type="text"
				value="<%=gridData[i].get("disp_type")%>" name="disp_type"
				readonly="readonly" size="12" /></td>
			<td width="15%"><input type="text"
				value="<%=(gridData[i].get(TENDER_STOCK_IN_HAND)==null)?"0.000":gridData[i].get(TENDER_STOCK_IN_HAND)%>"
				name="<%=TENDER_STOCK_IN_HAND%>" size="12" readonly="readonly" /></td>
			<td width="12%"><input type="text"
				value="<%=(gridData[i].get(TENDER_MMFQTY)==null)?"0.000":gridData[i].get(TENDER_MMFQTY)%>"
				name="<%=TENDER_MMFQTY %>" size="12" readonly="readonly" /></td>
			<td width="13%"><input type="text"
				value="<%=(gridData[i].get(TENDER_ANNREQ)==null)?"0.000":gridData[i].get(TENDER_ANNREQ)%>"
				name="<%=TENDER_ANNREQ %>" size="12" validate="Tender Qty,num,no"
				maxlength="16" /></td>
			<td width="6%"><input type="checkbox"
				name=<%=ITEMS_TO_BE_DELETED%>
				value="<%=gridData[i].get(TENDER_ITEM_ID)%>"></td>
			<td width="10%"><input type="hidden"
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
<% } %>
</form>
<div class="Clear"></div>
</div>

<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>
