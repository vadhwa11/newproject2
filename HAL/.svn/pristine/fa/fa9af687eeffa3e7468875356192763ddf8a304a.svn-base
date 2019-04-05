<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.StoreIssueM"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>

<script language="Javascript">
function cancelForm(){
  	 close();
   	}
//this function will be called by the Bean (not from JSP)
function goPage(pidx) {	
	deleteIssueCiv.currPage.value = pidx;
	deleteIssueCiv.method="post";
	submitForm('deleteIssueCiv','stores?method=showDeleteIsuueCiv');
}

function jsSubmit()
{
deleteIssueCiv.method="post";
submitForm('deleteIssueCiv','stores?method=showDeleteIsuueCiv&currPage=1');
}

function del()
{
	if (validateDeleteButton())
	{
	deleteIssueCiv.method="post";
	submitForm('deleteIssueCiv','stores?method=deleteIssueCivItems');
	}
	else
	{
	alert('No Item(s) Selected for delete!....');
	}
}
function validateDeleteButton()
{
	if (deleteIssueCiv.items_to_be_deleted.length)
	{
			 for(var i = 0; i < deleteIssueCiv.items_to_be_deleted.length; i++)
			 {
			  if (deleteIssueCiv.items_to_be_deleted[i].checked == true)
             		return true;
			 }
	}
	else
	{
		if (deleteIssueCiv.items_to_be_deleted.checked == true)
			return true;
	}
	return false;
}


</script>


<%
	List<StoreIssueM> deleteStoreIssueList=new ArrayList<StoreIssueM>();
	Map<String,Object> map = new HashMap<String,Object>();
  	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
		pagedArray = (PagedArray) map.get("pagedArray");
	}
	if(map.get("deleteStoreIssueList")!=null){
		deleteStoreIssueList=(List<StoreIssueM>)map.get("deleteStoreIssueList");
	}
	Box box=HMSUtil.getBox(request);
	
%>
<%@page import="jkt.hms.util.RequestConstants"%>



<div id="contentspace">
<form name="deleteIssueCiv" method="post">
<body>
<input type="hidden" name="numOfRows" size="5" value="10">
<input type="hidden" name="pageCount" size="5" value="5">
<br />
<h2 align="left" class="style1">Delete Isuue Civ</h2>
<div style="padding-left: 15px;">


<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Dept Issue(s) Search</font></div>

<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 810px; height: 30px; background-color: #f4f9fe;">

<label class="bodytextB_blue"><font id="error"></font>Issue No :</label>
<select name="<%= RequestConstants.ISSUE_ID%>"
	validate='Issue No,num,Yes'>
	<option value="0">Select</option>
	<%
					for (StoreIssueM storeIssueM :deleteStoreIssueList ) {
				%>

	<option value=<%=storeIssueM.getId()%>
		<%=HMSUtil.isSelected(storeIssueM.getId().toString(),box.get("issueId")) %>><%=storeIssueM.getIssueNo()%></option>

	<%
					}
				%>
</select> <input type="button" name="" value="Ok" class="button"
	onclick="jsSubmit();" /> <br />
<br />

<%
// grid part start

	if (pagedArray == null) {
		%>
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid; BORDER-LEFT: #9A9A9A 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Item Details</font></div>

<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>
<br />

<div
	style="overflow: scroll; overflow-x: hidden; width: 95%; BORDER: #202020 1px solid;">
<table align="center" width="100%" colspan="7" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<td width="40%"><label valign="left" class="smalllabel">SrNo</label></td>
			<td width="40%"><label valign="left" class="smalllabel">Pvms/Niv
			No</label></td>
			<td width="40%"><label valign="left" class="smalllabel">Item
			Issued</label></td>
			<td width="40%"><label valign="left" class="smalllabel">Brand
			Name</label></td>
			<td width="40%"><label valign="left" class="smalllabel">Qty
			Req</label></td>
			<td width="40%"><label valign="left" class="smalllabel">Qty
			Issued</label></td>
			<td width="40%"><label valign="left" class="smalllabel">Batch
			No</label></td>
			<td width="40%"><label valign="left" class="smalllabel">Cost
			Price</label></td>
			<td width="40%"><label valign="left" class="smalllabel">DELETE</label>
			</td>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=7 align="center">No Items Found</td>
		</tr>
	</tbody>
</table>
</div>

<%  } else { %>
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid; BORDER-LEFT: #9A9A9A 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Item Details</font></div>

<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>
<br />
<div
	style="overflow: scroll; overflow-x: scroll; width: 103%; height: 300px; BORDER: #202020 1px solid;">
<table align="center" width="100%" colspan="7" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<td width="40%"><label valign="left" class="smalllabel">SrNo</label></td>
			<td width="40%"><label valign="left" class="smalllabel">Pvms/Niv
			No</label></td>
			<td width="40%"><label valign="left" class="smalllabel">Item
			Issued</label></td>
			<td width="40%"><label valign="left" class="smalllabel">Brand
			Name</label></td>
			<td width="40%"><label valign="left" class="smalllabel">Qty
			Req</label></td>
			<td width="40%"><label valign="left" class="smalllabel">Qty
			Issued</label></td>
			<td width="40%"><label valign="left" class="smalllabel">Batch
			No</label></td>
			<!-- 			      <td width="40%"><label valign="left" class="smalllabel">Cost Price</label></td>  -->
			<td width="40%"><label valign="left" class="smalllabel">DELETE</label>
			</td>

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
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("pvmsNo")%>" class="medcaption"
				name="pvmsNo" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("issuedItemName")%>" class="bigcaption"
				name="nomenclature" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("brandName")%>" class="medcaption"
				name="brandName" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("requestedQty")%>" class="medcaption"
				name="requestedQty" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("issuedQty")%>" class="medcaption"
				name="issuedQty" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("batchNo")%>" class="medcaption1"
				name="issuedQty" readonly="readonly" /></td>
			<input type="hidden" value="<%=gridData[i].get("costPrice")%>"
				class="medcaption" name="costPrice" readonly="readonly" />
			<td align="center" width="10%"><input type="checkbox"
				name="items_to_be_deleted" value="<%=gridData[i].get("issueTId")%>">
			<input type="hidden" name="itemId"
				value="<%=gridData[i].get("itemId")%>"> <input type="hidden"
				name="id" value="<%=gridData[i].get("issueTId")%>"> <input
				type="hidden" name="itemFromIndent"
				value="<%=gridData[i].get("itemFromIndent")%>"></td>

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
<input name="" type="button" class="button" value="Delete"
	onclick="del();"> <input name="" type="button" class="button"
	value="Close" onClick="cancelForm();""></div>
<%}%>
</div>
</div>
</body>
</form>

<script>
<% if (box.getString("firstTime").equals("1"))
{ %>
jsSubmit();
<%}%>

</script>