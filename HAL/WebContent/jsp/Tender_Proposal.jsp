<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.util.Box"%>

<%@page import="jkt.hms.masters.business.StoreTenderM"%>
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
	int groupId = 0; 
	Box box = HMSUtil.getBox(request);
	Map<String,Object> utilMap = new HashMap<String,Object>();
	Map<String,Object> masterDataMap = new HashMap<String,Object>();
	List<MasStoreGroup> masStoreGroupList = new ArrayList<MasStoreGroup>();
	List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();
	List<Object> existingList = new ArrayList<Object>();
	

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
		masStoreGroupList = (ArrayList)map.get("masStoreGroupList");
		if(map.get("storeTenderMList") != null){
		storeTenderMList = (ArrayList)map.get("storeTenderMList");
		}
		if(map.get("existingList")!=null){
		existingList =  (ArrayList)map.get("existingList"); 	
		}
		groupId =(Integer)map.get("groupId");
	}
	
%>

<script>

function openPopupWindow()
{
 if(document.getElementById('groupId').value != ""){
 var url="/hms/hms/tender?method=showAddTenderItemsJsp&numOfRows=15&pageCount=10&groupId="+document.getElementById('groupId').value;
 newwindow=window.open(url,'name','top=50, left=50, height=600,width=950,status=1');
 }else{
  alert("Please select the group!!!");
 }
 
}

//this function will be called by the Bean (not from JSP)
function goPage(pidx) {	
var groupId = document.getElementById('groupId').value
	tenderProposalForm.currPage.value = pidx;
	tenderProposalForm.method="post";
	submitForm('tenderProposalForm','tender?method=showTenderProposalJsp&groupId='+groupId);
}

function jsDisplay() {	
	if (document.searchForm.<%=TENDER_NO%>.value=="")
	{
	alert('Pl. select Tender No....');
	return;
	}
	
	tenderProposalForm.method="post";
	submitForm('searchForm','tender?method=showTenderProposalJsp');
}

function upd()
{
var groupId = document.getElementById('groupId').value
tenderProposalForm.method="post";
submitForm('tenderProposalForm','tender?method=updateTenderProposalGridItems&groupId='+groupId);
}

function validateDeleteButton()
{
	if (tenderProposalForm.<%=ITEMS_TO_BE_DELETED%> && tenderProposalForm.<%=ITEMS_TO_BE_DELETED%>.length)
	{
			 for(var i = 0; i < tenderProposalForm.<%=ITEMS_TO_BE_DELETED%>.length; i++)
			 {
			  if (tenderProposalForm.<%=ITEMS_TO_BE_DELETED%>[i].checked == true)
             		return true;
			 }
	}
	else
	{
		if (tenderProposalForm.<%=ITEMS_TO_BE_DELETED%> && tenderProposalForm.<%=ITEMS_TO_BE_DELETED%>.checked == true)
			return true;
	}
	return false;
}

function del()
{
	if (validateDeleteButton())
	{
	tenderProposalForm.method="post";
	var groupId = document.getElementById('groupId').value
	submitForm('tenderProposalForm','tender?method=deleteTenderProposalGridItems&groupId='+groupId);
	}
	else
	{
	alert('No Item(s) Selected for delete!....');
	}
}

function printProposal()
{
var groupId = document.getElementById('groupId').value
if(groupId != ""){
<% if (pagedArray!=null) { %>
	tenderProposalForm.method="post";

	submitForm('tenderProposalForm','tender?method=printTenderProposalItems&groupId='+groupId);
<% } else { %>
	alert('No Items to print!.........');
<% } %>
}else{
   alert("please Select the group!!!");
}
}

	function pvmsSearch()
	 {
	 tenderProposalForm.method="post";
      var groupId = document.getElementById('groupId').value
	   var pvmsNo=document.tenderProposalForm.pvmsNo.value;
	   if(pvmsNo != ""){
	     submitForm('tenderProposalForm','tender?method=showTenderProposalJsp&flag=fresh&pvmsNo='+pvmsNo+'&groupId='+groupId);
	   }else{
	     alert("Please select PVMS No.")
	   }
	 }
	 
	 
 function getProposalItem() {	
   var groupId = document.getElementById('groupId').value
	
	if(groupId != ""){
	tenderProposalForm.method="post";
	submitForm('tenderProposalForm','tender?method=showTenderProposalJsp&groupId='+groupId);
	}else{
	  alert("please Select the group!!!");
	}
	
}

function getItems(event,th){
var groupId = document.getElementById('groupId').value
submitenter(th,event,'tender?method=showTenderProposalJsp&enter=true&flag=fresh&groupId='+groupId);
}
function onChangeGroup()
	{
	//tenderProposalForm.<%=TENDER_SUPPLIER_GROUP_ID%>.options.length=1;
	var groupId = document.getElementById('groupId').value
	tenderProposalForm.method="post";
	submitForm('tenderProposalForm','tender?method=getTenders&groupId='+groupId);
	}
	
 function importProposal()
  {
   //tenderProposalForm.<%=TENDER_SUPPLIER_GROUP_ID%>.options.length=1;
	 var groupId = document.getElementById('groupId').value
	 var tenderId = document.getElementById('tenderId').value
	if(groupId !="" && tenderId != ""){
	tenderProposalForm.method="post";
	  if(confirm("\nAre You Sure,You want to import proposal? ")){
        submitForm('tenderProposalForm','tender?method=ImportLastTenderProposal&groupId='+groupId+'&tenderId='+tenderId);
		return true;
	  }else{
		return false;
	  }
	}else{
	  var err = "";
	     if(groupId ==""){
	      err = err + "Select the group";
	     }
	     if(tenderId ==""){
	      err = err + "\n Select the Tender no";
	     } 
	     if(err != ""){
	      alert(err);
	  }
    	return false;     
  }
}
</script>
<div id="contentHolder">
<h6>Tender Proposal</h6>
<form name="tenderProposalForm" method="post" action=""><input
	type="hidden" name="numOfRows" size="5" value="15"> <input
	type="hidden" name="pageCount" size="5" value="10"> <input
	type="hidden" name="hospitalId" size="5" value="<%=hospitalId%>">
<input type="hidden" name="deptId" size="5" value="<%=deptId%>">
<div class="blockTitle">Tender Proposal</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label>Department:</label> <label
	class="value"><%=deptName%></label> <label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label>

<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div class="blockFrame">
<%if(existingList.size() == 0){ %> <input type="button" name="Submit"
	id="confirm" value="Import Last Proposals" class="cmnButton"
	onclick="importProposal();"> <% }%> <select
	name="<%=TENDER_SUPPLIER_GROUP_ID %>" id="groupId"
	onChange="onChangeGroup();">
	<option value="">Select Group</option>
	<%
									for (Iterator iterator = masStoreGroupList.iterator(); iterator.hasNext();) 
									{
										MasStoreGroup masStoreGroup = (MasStoreGroup)iterator.next();
									%>
	<option value="<%=masStoreGroup.getId()%>"
		<%=HMSUtil.isSelected(masStoreGroup.getId(),groupId)%>><%=masStoreGroup.getGroupName()%></option>
	<%
									}
									%>
</select> <select name="<%=TENDER_NO%>" id="tenderId">
	<option value="">Select Tender No</option>
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
</select> <input type="button" name="Submit" id="confirm" value="OK"
	class="button" onclick="getProposalItem();"> <input
	type="button" name="Add" type="submit" value="Add" class="button"
	onClick="openPopupWindow();"> <input type="button"
	name="Update" type="submit" value="Update" class="button"
	onClick="upd();"> <input type="button" name="Delete"
	type="submit" value="Delete" class="button" onClick="del();">

<input type="button" name="Print" type="submit" value="Print"
	class="button" onClick="printProposal();"></div>

<div class="Clear"></div>
<label>PVMS/NIV</label> <input type="text" name="pvmsNo" value=""
	onkeypress="getItems(event,this);" /> <input type="hidden"
	name="puser" value="<%=userName%>"> <input type="hidden"
	name="pDate" value="<%=date%>"> <input type="hidden"
	name="pTime" value="<%=time%>"> <IMG
	SRC="/hms/jsp/images/s_search.gif" WIDTH="26" HEIGHT="26"
	style="cursor: pointer; float: left;"
	onClick="javascript:pvmsSearch();"
	title="Click here to Search Pvms/Niv">
<div class="Clear"></div>
<%		
		if (pagedArray == null) {
		%>
<div class="Clear"></div>
<div class="blockTitle">Tender Proposal Item Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
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
			<th width="12%">Qty in MMF</th>
			<th width="13%">Tender Qty</th>
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
<div class="blockTitle">Tender Proposal Item Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
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
			<th width="12%">Qty in MMF</th>
			<th width="13%">Tender Qty</th>
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
				size="3" name="<%=TENDER_SRNO%>" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get(TENDER_PVMS )%>" size="10"
				name="<%=TENDER_PVMS %>" readonly="readonly" /></td>
			<td width="30%"><input type="text"
				value="<%=gridData[i].get(TENDER_NOMENCLATURE)%>" size="50"
				name="<%=TENDER_NOMENCLATURE %>" readonly="readonly" /></td>
			<td width="15%"><input type="text"
				value="<%=gridData[i].get(TENDER_AU)%>" name="<%=TENDER_AU%>"
				size="12" readonly="readonly" /></td>
			<td width="15%"><input type="text"
				value="<%=gridData[i].get("disp_type")%>" name="disp_type" size="10"
				readonly="readonly" /></td>
			<td width="15%"><input type="text"
				value="<%=(gridData[i].get(TENDER_STOCK_IN_HAND)==null)?"0.00":gridData[i].get(TENDER_STOCK_IN_HAND)%>"
				name="<%=TENDER_STOCK_IN_HAND%>" size="10" readonly="readonly" /></td>
			<td width="12%"><input type="text"
				value="<%=(gridData[i].get(TENDER_MMFQTY)==null)?"0.00":gridData[i].get(TENDER_MMFQTY)%>"
				size="10" name="<%=TENDER_MMFQTY %>" readonly="readonly" /></td>
			<td width="13%"><input type="text"
				value="<%=(gridData[i].get(TENDER_ANNREQ)==null)?"0.00":gridData[i].get(TENDER_ANNREQ)%>"
				name="<%=TENDER_ANNREQ %>" size="10" validate="Tender Qty,num,no"
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

</div>

<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>
