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
<style>
html,body {
	overflow: auto;
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



<style type="text/css">
<!--
.locatorArrow {
	COLOR: #666666;
	FONT-FAMILY: Verdana;
	FONT-SIZE: 12px
}
</style>

<%
    String boxmessage = "";
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
	int groupId = 0;
	List existingTenderNumbersList = null;
	List mmfyears = null;
	String tender_no;
	int deptId = 0;
	String hiddenFieldForRecords="";
	String itemIdForNextRecord=null;
	String message = "";
	boolean show = false;
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		pagedArray = (PagedArray) map.get("pagedArray");
		groupId = (Integer) map.get("groupId");
		
		if(map.get("message") != null){
			message = (String) map.get("message");
		}
		System.out.println("map " + map);
	}
	
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	
	if (session.getAttribute("deptId") != null) {
		Integer temp =  (Integer)session.getAttribute("deptId");
		deptId = temp.intValue();
	}
	if(map.get("hiddenFieldForRecords")!= null)
	{
		hiddenFieldForRecords=(String)map.get("hiddenFieldForRecords");
	}
	if(map.get("itemIdForNextRecord")!= null)
	{
		itemIdForNextRecord=(String)map.get("itemIdForNextRecord");
		System.out.println("itemIdForNextRecord------------------in jsp tender item addition------------"+itemIdForNextRecord);
	}
	
	if(map.get("show") != null){
		 show = (Boolean)map.get("show");
	}
%>

<title>Tender Creation</title>
<script>

//this function will be called by the Bean (not from JSP)
function goPage(pidx) {	
   var groupId = document.getElementById('groupId').value;
	tenderForm.currPage.value = pidx;
	tenderForm.method="post";
	var valueOfHiddenField=document.tenderForm.hiddenFieldForRecords.value;
	if(valueOfHiddenField =="true"){
		submitForm('tenderForm','tender?method=showAddTenderItemsJspForNextRecords&groupId='+groupId+'&showAll='+document.getElementById('showAll').checked);
	}else{
	submitForm('tenderForm','tender?method=showAddTenderItemsJsp&groupId='+groupId+'&showAll='+document.getElementById('showAll').checked);
	}
}

function jsSubmit()
{
		if (tenderForm.pvms.value == "" &&  tenderForm.search_text.value=="")
		{
		alert("Either Nomenclature or PVMS No should be entered!...");
		return;
		}
		tenderForm.method="post";
		submitForm('tenderForm','tender?method=showAddTenderItemsJsp&currPage=1&groupId='+document.getElementById('groupId').value+'&showAll='+document.getElementById('showAll').checked);
}

function validateAddButton()
{
	if (tenderForm.<%=ITEMS_TO_BE_ADDED%> && tenderForm.<%=ITEMS_TO_BE_ADDED%>.length)
	{
			 for(var i = 0; i < tenderForm.<%=ITEMS_TO_BE_ADDED%>.length; i++)
			 {
			  if (tenderForm.<%=ITEMS_TO_BE_ADDED%>[i].checked == true)
             		return true;
			 }
	}
	else
	{
		if (tenderForm.<%=ITEMS_TO_BE_ADDED%> && tenderForm.<%=ITEMS_TO_BE_ADDED%>.checked == true)
			return true;
	}
	return false;
}


function jsAdd()
{
		if (validateAddButton())
		{
			tenderForm.method="post";
			var itemIdForNextRecord=document.tenderForm.itemIdForNextRecord.value;
			var hiddenFieldForRecords=document.tenderForm.hiddenFieldForRecords.value;
		//alert("jsAdd value of itemIdForNextRecord----"+itemIdForNextRecord)
			if(hiddenFieldForRecords =="true"){
				submitForm('tenderForm','tender?method=doAddTenderItems&itemIdForNextRecord='+ itemIdForNextRecord +'&hiddenFieldForRecords=true&groupId='+document.getElementById('groupId').value+'&showAll='+document.getElementById('showAll').checked);
			}else{
				submitForm('tenderForm','tender?method=doAddTenderItems&groupId='+document.getElementById('groupId').value+'&showAll='+document.getElementById('showAll').checked);
			}
				
		}
		else
		{
		alert('No Item(s) Selected to Add!....');
		}
		
}
	function callNext()
		{
		if(validateNextRecordButton()){
		tenderForm.method="post";
		submitForm('tenderForm','tender?method=showAddTenderItemsJspForNextRecords&buttonName=next&currPage=0&groupId='+document.getElementById('groupId').value+'&showAll='+document.getElementById('showAll').checked);
		}
		
	}
				function validateNextRecordButton()
						{
						//for(var i = 0; i < document.getElementsByName('itemId').length; i++){
						//alert("document.getElementsByName('itemId').length"+document.getElementsByName('itemId').length +"document.getElementsByName('itemId')[i].value------"+document.getElementsByName('itemId')[i].value)
						//alert("document.getElementsByName('tender_item_id').length----"+document.getElementsByName('tender_item_id').length)
						if(document.getElementsByName('tender_item_id').length==0){
							alert("Please Go to previous Record and then Click for next 1000 records.")
							return false;
						}else{
						   return true; 
						   }
			            }  
function jsClose()
{
 var groupId = document.getElementById('groupId').value;
 if (tenderForm.<%=TENDER_NO%>.value!="")
  window.opener.location.href = "tender?method=showTenderCreationJspWithGridData&<%=TENDER_NO%>="+tenderForm.<%=TENDER_NO%>.value;
 else
  window.opener.location.href = "tender?method=showTenderProposalJsp&groupId="+groupId;
 

  if (window.opener.progressWindow)
	 {
    	window.opener.progressWindow.close()
  	 } 
  window.close();
}

function showAllMMF(){
	//alert(":status::::::::"+document.getElementById('showAll').checked)
	var groupId = document.getElementById('groupId').value;
	tenderForm.currPage.value = "1";
	tenderForm.method="post";
	submitForm('tenderForm','tender?method=showAddTenderItemsJsp&groupId='+groupId+'&showAll='+document.getElementById('showAll').checked);
		}

</script>
<div id="contentHolder">
<form name="tenderForm" action="" method="post"><input
	type="hidden" name="numOfRows" size="5" value="15"> <input
	type="hidden" name="pageCount" size="5" value="10"> <input
	type="hidden" name="search" size="5" value="true"> <input
	type="hidden" name=<%=TENDER_NO%> size="5"
	value="<%=box.get(TENDER_NO)%>"> <input type="hidden"
	name="groupId" id="groupId" value="<%=groupId %>"> <input
	type="hidden" name="deptId" size="5" value="<%=deptId%>"> <input
	type="hidden" name="hospitalId" size="5" value="<%=hospitalId%>">
<input type="hidden" name="<%=CHANGED_BY%>" size="5"
	value="<%=userName%>"> <input type="hidden"
	name="<%=CHANGED_DATE%>" size="5" value="<%=date%>"> <input
	type="hidden" name="<%=CHANGED_TIME%>" size="5" value="<%=time%>">


<div class="blockTitle">Store Item(s) Search</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label>Nomenclature</label> <input
	type="text" name="search_text" value=""
	onkeypress="submitenter(this,event,'tender?method=showAddTenderItemsJsp&currPage=1)"
	class="large2" MAXLENGTH="30" />
<div class="Clear"></div>
<label class="bodytextB">PVMS No</label> <input type="text" name="pvms"
	value=""
	onkeypress="submitenter(this,event,'tender?method=showAddTenderItemsJsp&currPage=1)"
	MAXLENGTH="20" /> <input type="button" name="Submit" id="addbutton"
	onClick="jsSubmit()" value="Submit" class="button" /> <label>Show
All</label> <%if(show){ 
	    // System.out.println("show status:::::::::"+show);
	    %> <input type="checkbox" name="showAll" id="showAll"
	checked="checked" class="radio" onclick="showAllMMF();" value="">
<%}else{ %> <input type="checkbox" name="showAll" id="showAll"
	class="radio" onclick="showAllMMF();" value=""> <%} %>
<div class="Clear"></div>

</div>
<div class="Clear"></div>
<input type="hidden" name="itemIdForNextRecord"
	value="<%=itemIdForNextRecord %>" /> <%if(hiddenFieldForRecords.equals("true")){ %>
<input type="hidden" name="hiddenFieldForRecords" value="true" /> <%} else{%>
<input type="hidden" name="hiddenFieldForRecords" value="" /> <%} %>
<div style="padding-left: 350px;"><input type="button"
	name="nextRecords" id="nextRecords" onClick="callNext()"
	value="Next 1000 Records" class="cmnButton" /></div>
<div class="Clear"></div>

<%		
		if (pagedArray == null) {
		%>


<div class="blockTitle">Store MMF Item Details</div>
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
			<th width="10%">Qty in MMF</th>
			<th width="15%">Tender Qty</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=8 align="center"><%=message %></td>
		</tr>
	</tbody>
</table>
</div>
<div class="Clear"></div>
<input type="button" name="Close" onClick="jsClose()" value="Close"	class="button" />
<div class="Clear"></div>
<%  } else { %>
<div class="Clear"></div>
<div class="blockTitle">Store MMF Item Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="tableHolderAuto">
<table align="center" width="100%" colspan="7" class="grid_header" cellpadding="0" cellspacing="0">

	<thead>
		<tr>
			<th>SR No</th>
			<th>PVMS No</th>
			<th>Nomenclature</th>
			<th>A/U</th>
			<th>Disp Type</th>
			<th>Stock in Hand</th>
			<th>Qty in MMF</th>
			<th>Tender Qty</th>
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
			<td><input type="text" value="<%=iFirstRow++%>" size="3"
				name="<%=TENDER_SRNO%>" readonly="readonly" /></td>
			<td><input type="text"
				value="<%=gridData[i].get(TENDER_PVMS )%>" size="10"
				name="<%=TENDER_PVMS %>" readonly="readonly" /></td>
			<td><input type="text"
				value="<%=gridData[i].get(TENDER_NOMENCLATURE)%>" size="50"
				name="<%=TENDER_NOMENCLATURE %>" readonly="readonly" /></td>
			<td><input type="text" value="<%=gridData[i].get(TENDER_AU)%>"
				name="<%=TENDER_AU%>" size="10" readonly="readonly" /></td>
			<td><input type="text"
				value="<%=gridData[i].get("disp_type")%>" name="disp_type" size="10"
				readonly="readonly" /></td>
			<td><input type="text"
				value="<%=(gridData[i].get(TENDER_STOCK_IN_HAND)==null)?"0.000":gridData[i].get(TENDER_STOCK_IN_HAND)%>"
				name="<%=TENDER_STOCK_IN_HAND%>" size="10" readonly="readonly" /></td>
			<td><input type="text"
				value="<%=(gridData[i].get(TENDER_MMFQTY)==null)?"0.000":gridData[i].get(TENDER_MMFQTY)%>"
				name="<%=TENDER_MMFQTY %>" readonly="readonly" size="10"
				validate="MMF Qty,num,no" /></td>
			<td><input type="text"
				value="<%=(gridData[i].get(TENDER_ANNREQ)==null)?"0.000":gridData[i].get(TENDER_ANNREQ)%>"
				name="<%=TENDER_ANNREQ %>" size="10"
				validate="Annual Requirement,num,no" /></td>
			<%
				if(gridData[i].get("Item_group") != null){%>
			<td><input type="checkbox" name=<%=ITEMS_TO_BE_ADDED%>
				value="<%=gridData[i].get(TENDER_ITEM_ID)%>"></td>
			<td><input type="hidden"
				value="<%=gridData[i].get(TENDER_ITEM_ID)%>"
				name="<%=TENDER_ITEM_ID%>" /></td>
			<%}else{ 
					boxmessage = "Check box disabled because item group not marked";
				%>
			<td><input type="checkbox" name=<%=ITEMS_TO_BE_ADDED%>
				value="<%=gridData[i].get(TENDER_ITEM_ID)%>" disabled></td>
			<td><input type="hidden"
				value="<%=gridData[i].get(TENDER_ITEM_ID)%>"
				name="<%=TENDER_ITEM_ID%>" /></td>
			<%} %>
		</tr>
		<% } %>
	</tbody>
</table>
</div>
<div class="Clear"></div>
<div id="pagination"><%= pagedArray.showIndex()%> <%= pagedArray.getPageIndexHiddenTag()%>
</div>
<div class="Clear"></div>

<marquee direction="right"
	style="color: red; font-size: 16px; font-weight: bold; font-family: sans-serif;">
<%= boxmessage%></marquee> <input type="button" name="Add" onClick="jsAdd()"
	value="Add" class="button" /> <input type="button" name="Close"
	onClick="jsClose()" value="Close" class="button" />
<div class="Clear"></div>
</form>
</div>
<%}%>

