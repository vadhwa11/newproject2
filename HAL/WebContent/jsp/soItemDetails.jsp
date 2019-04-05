<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />

<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
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
function addAll(){
	
var rowLength=document.getElementById("rowLenght").value;

if(document.getElementById("add_ALL").checked){

	for(i=1;i<=rowLength;i++){
		document.getElementById("itemId"+i).checked=true;
		}

	
}else{
	for(i=1;i<=rowLength;i++){
		document.getElementById("itemId"+i).checked=false;
		}
}

}
</script>

<%
	String date = "";
	String time = "";
	String userName = "";
	String nomenclature = "";
	String pvms_no = "";
	int hospitalId = 0;
	String hiddenFieldForRecords="";
	String itemIdForNextRecord=null;
	Box box = HMSUtil.getBox(request);
	System.out.println("box inside jsp" + box);
	
	Vector mmfTItems = new Vector();
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
		}
 	String items = "";
  	Map map = new HashMap();
  	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	List existingTenderNumbersList = null;
	List mmfyears = null;
	String tender_no;
	String storeType="";
	int currentPage=1;
	int currentYear=0;
	int mmfMasterId = 0;
	
	 List<StorePoHeader> storePoHeaderList= new ArrayList<StorePoHeader>();
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		pagedArray = (PagedArray) map.get("pagedArray");
	}
	
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	
	if(map.get("storePoHeaderList")!=null){
		storePoHeaderList=(List<StorePoHeader>)map.get("storePoHeaderList");
		}
	if (map.get("pagedArray") != null)
	{
	pagedArray = (PagedArray) map.get("pagedArray");
	System.out.println(pagedArray.getPagedArray());
	}
	if(map.get("hiddenFieldForRecords")!= null)
	{
		hiddenFieldForRecords=(String)map.get("hiddenFieldForRecords");
	}
	if(map.get("itemIdForNextRecord")!= null)
	{
		itemIdForNextRecord=(String)map.get("itemIdForNextRecord");
	}
	
	if(pagedArray!=null){
		if((Integer)pagedArray.getCurrentPage()!=null){
			currentPage=pagedArray.getCurrentPage();
		}
	}
	if (map.get("itemField") != null && map.get("itemField") != "")
	{
		nomenclature = (String) map.get("itemField");
	}
	if (map.get("pvmsNoField") != null && map.get("pvmsNoField") != "")
	{
	    pvms_no = (String) map.get("pvmsNoField");
	}
%>
<title>Result For Pvms Nomenclature Search</title>

<script>

function goPage(pidx) {	
	document.soItemForm.currPage.value = pidx;
	soItemForm.method="post";
	var pageType = document.getElementById('pageType').value;
	var nomenclature = document.getElementById('nomenclatureSearch1').value;
	var pvms = document.getElementById("pvms").value;
	
	var sos = document.getElementById('sos').value;
	var po_id = document.getElementById('po_id').value;
	
	
	var itemslist="";
    if (soItemForm.<%=ITEMS_TO_BE_ADDED%> && soItemForm.<%=ITEMS_TO_BE_ADDED%>.length)
	    {
			 for(var i = 0; i < soItemForm.<%=ITEMS_TO_BE_ADDED%>.length; i++)
			 {
			  if (soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].checked == true){
			  	  if(itemslist.length == 0){
			  	    itemslist = soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].value;
			  	  }else{
			  	    itemslist = itemslist+","+soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].value;
			  	  }
			  }
		 }
	}
	
	else
	{
		if (soItemForm.<%=ITEMS_TO_BE_ADDED%> && soItemForm.<%=ITEMS_TO_BE_ADDED%>.checked == true){
	         itemslist = soItemForm.<%=ITEMS_TO_BE_ADDED%>.value;	
		}
		//	return true;
	}
	var addedItems =document.getElementById('addedItems').value;
	 if(addedItems.length > 0){
	  addedItems = addedItems+","+itemslist;
	 }else{
	 addedItems = itemslist;
	 }
	
	submitForm('soItemForm','stores?method=getSoItemDetails&requiredField='+nomenclature+'&pvmsNo='+pvms+'&sos='+sos+'&po_id='+po_id+'&addedItems='+addedItems+'&pageType='+pageType+'&numOfRows=8&currPage='+pidx+'');
}

function passNomenclatureHiddenField(pvms,itemId){
document.getElementById("pvms1").value=pvms;
document.getElementById("itemId").value=itemId;
}

function validateAddButton()
{
	if (soItemForm.<%=ITEMS_TO_BE_ADDED%> && soItemForm.<%=ITEMS_TO_BE_ADDED%>.length)
	{
			 for(var i = 0; i < soItemForm.<%=ITEMS_TO_BE_ADDED%>.length; i++)
			 {
			  if (soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].checked == true)
             		return true;
			 }
	}
	else
	{
		if (soItemForm.<%=ITEMS_TO_BE_ADDED%> && soItemForm.<%=ITEMS_TO_BE_ADDED%>.checked == true)
			return true;
	}
	return false;
}

function jsAdd()
{
	soItemForm.method="post";
	var po_id=document.getElementById('po_id').value;
	var sos=document.getElementById('sos').value;
	 window.opener.document.getElementById('soIdDate').value=document.getElementById('soDateId').value ;
	var pageType = document.getElementById('pageType').value;
 
 	if (validateAddButton())
		{
       var itemslist="";
    if (soItemForm.<%=ITEMS_TO_BE_ADDED%> && soItemForm.<%=ITEMS_TO_BE_ADDED%>.length)
	    {
			 for(var i = 0; i < soItemForm.<%=ITEMS_TO_BE_ADDED%>.length; i++)
			 {
	
			  if (soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].checked == true){
			  	  if(itemslist.length == 0){
			  	    itemslist = soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].value;
			  	      soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].disabled= true;
			  	  }else{
			  	    itemslist = itemslist+","+soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].value;
			  	      soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].disabled= true;
			  	  }
			  }
		 }
	}
	
	else
	{
		if (soItemForm.<%=ITEMS_TO_BE_ADDED%> && soItemForm.<%=ITEMS_TO_BE_ADDED%>.checked == true){
	         itemslist = soItemForm.<%=ITEMS_TO_BE_ADDED%>.value;
	           soItemForm.<%=ITEMS_TO_BE_ADDED%>.disabled= true;	
		}
		//	return true;
	}

	var addedItems =document.getElementById('addedItems').value;
	 if(addedItems.length > 0){
	  addedItems = addedItems+","+itemslist;
	 }else{
	 addedItems = itemslist;
	 }
	}else{
		alert('No Item(s) Selected to Add!....');
	} 
 	jsClose();	
}

function jsClose(){
	var po_id=document.getElementById('po_id').value;
	var sos=document.getElementById('sos').value;
    var pageType = document.getElementById('pageType').value;
    
    var itemslist="";
    if (soItemForm.<%=ITEMS_TO_BE_ADDED%> && soItemForm.<%=ITEMS_TO_BE_ADDED%>.length)
	  {
			 for(var i = 0; i < soItemForm.<%=ITEMS_TO_BE_ADDED%>.length; i++)
			 {
			  if (soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].checked == true){
			  	  if(itemslist.length == 0){
			  	    itemslist = soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].value;
			  	   
			  	  }else{
			  	    itemslist = itemslist+","+soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].value;
			  	  
			  	  }
			  }
		 }
	  }
	else
	{
		if (soItemForm.<%=ITEMS_TO_BE_ADDED%> && soItemForm.<%=ITEMS_TO_BE_ADDED%>.checked == true){
	         itemslist = soItemForm.<%=ITEMS_TO_BE_ADDED%>.value;
	       
		}
			//return true;
	}
	var addedItems =document.getElementById('addedItems').value;
	 if(addedItems.length > 0){
	  addedItems = addedItems+","+itemslist;
	 }else{
	 addedItems = itemslist;
	 }
    
    if(addedItems.length > 0){
    if(pageType == "mod"){
      var  parent = window.opener.document.getElementById('parent').value 
         window.opener.location.href ="stores?method=modifyGrn&sos="+sos+"&searchPoId="+po_id+'&items='+addedItems+'&parent='+parent;
		    if (window.opener.progressWindow)
			{
			  	window.opener.progressWindow.close()
			} 
			 window.close();
	    }else{
	    window.opener.document.getElementById('item_id').value = addedItems;
	    window.opener.document.getElementById('details').focus();
	    window.opener.jsGetGrid(); 
	  //  window.opener.document.getElementByid('details').style = none;
	     self.close();
     }
    }else{
     self.close();
    }
    document.getElementById('barCodeId1').focus();
}

function jsSubmit()
{
         var po_id=document.getElementById('po_id').value;
		if (soItemForm.pvms.value == "" &&  soItemForm.search_text.value=="")
		{
		alert("Either Nomenclature or PVMS No should be entered!...");
		return;
		}
	
	var pageType = document.getElementById('pageType').value;
	var itemslist="";
    if (soItemForm.<%=ITEMS_TO_BE_ADDED%> && soItemForm.<%=ITEMS_TO_BE_ADDED%>.length)
	    {
			 for(var i = 0; i < soItemForm.<%=ITEMS_TO_BE_ADDED%>.length; i++)
			 {
			  if (soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].checked == true){
			  	  if(itemslist.length == 0){
			  	    itemslist = soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].value;
			  	  }else{
			  	    itemslist = itemslist+","+soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].value;
			  	  }
			  }
		 }
	}
	else
	{
		if (soItemForm.<%=ITEMS_TO_BE_ADDED%> && soItemForm.<%=ITEMS_TO_BE_ADDED%>.checked == true){
	         itemslist = soItemForm.<%=ITEMS_TO_BE_ADDED%>.value;	
		}
		
	//		return true;
	}
	var addedItems =document.getElementById('addedItems').value;
	 if(addedItems.length > 0){
	  addedItems = addedItems+","+itemslist;
	 }else{
	 addedItems = itemslist;
	 }
		soItemForm.method="post";
		submitForm('soItemForm','stores?method=getSoItemDetails&currPage=1&sos='+document.getElementById('sos').value+"&po_id="+po_id+"&pageType="+pageType+"&addedItems="+addedItems);
}
function populateSupplier1(val)
{

	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	    obj = document.getElementById("suppliers");
	   
		obj.length = 1;
		var itemId=document.getElementById("itemId").value;
		alert("itemId"+itemId);
	    if (itemId!="")
	
ajaxFunctionForAutoCompleteInLPO('soItemForm','/hms/hms/tender?method=populateSupplierInTenderLPO&pvms=' + pvms + '&tenderId=' + document.getElementById("tenderId").value + '&deptId=' + document.getElementById("deptId").value);	 	
}					

</script>
<div class="titleBg">
<h2 >Supply Order Items</h2>
</div>
<form name="soItemForm"><input type="hidden" name="numOfRows" size="5" value="15"> 
<input type="hidden" name="pageCount" size="5" value="10"> 
<input type="hidden" name="search" size="5" value="true"> 
<input type="hidden" name="deptId" value="<%=box.get("deptId")%>" /> 
<input type="hidden" name="currPage" value="<%=box.getInt("currPage")%>" /> 
<input type="hidden" name="numOfRows1" value="<%=box.getInt("numOfRows")%>" /> 
<input type="hidden" name="sos" id="sos" value="<%=box.get("sos")%>" /> 
<input type="hidden" name="po_id" id="po_id" value="<%=box.get("po_id")%>" />
<input type="hidden" name="pageType" id="pageType" value="<%=box.get("pageType")%>" /> 
<input type="hidden" id="addedItems" name="addedItems" value="<%=box.get("addedItems")%>" />
<input type="hidden" id="pvmsSearch" name="pvmsSearch" value="<%=pvms_no%>" /> 
<input type="hidden" id="nomenclatureSearch1" name="nomenclatureSearch1" value="<%=nomenclature%>" /> 
<input type="hidden" id="nomenclature1" name="nomenclature" value="" />
<div id=suppDiv style="visibility: hidden"></div>
<input type="hidden" name="<%=CHANGED_BY %>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<%if(hiddenFieldForRecords.equals("true")){ %> <input type="hidden"
	name="hiddenFieldForRecords" value="true" /> <%} else{%> <input
	type="hidden" name="hiddenFieldForRecords" value="" /> <%} %> <%
		String supplierName = "";
		String soNo = "";
		Date soDate = null;
		 if(storePoHeaderList != null && storePoHeaderList.size()>0){
		 StorePoHeader storePoHeader = (StorePoHeader) storePoHeaderList.get(0);
		 supplierName = storePoHeader.getSupplier().getSupplierName();
		 soNo = storePoHeader.getPoNumber();
		 soDate = storePoHeader.getPoDate(); 
		 }
		%>
<div class="Block" >
<label>Vendor</label> 
<label class="valueAuto"><%=supplierName%></label>
<label>SO No.</label> 
<label class="valueAuto"><%=soNo%></label>

 
<label>SO Date </label>
<label class="value"><%=HMSUtil.convertDateToStringWithoutTime(soDate)%></label>
<input type="hidden" id="soDateId" value="<%=HMSUtil.convertDateToStringWithoutTime(soDate)%>"/>

<!-- -
<label>Nomenclature</label>
<input type="hidden" name="search_text" id="search_text" value="" class="bigcaption" MAXLENGTH="30" />
<div class="clear"></div>
<label>PVMS No.</label>
<input type="hidden" name="pvms" id="pvms" value="" class="medcaption" MAXLENGTH="15" />-->
</div> 
<input type="hidden" name="Submit" id="addbutton" onClick="jsSubmit()" value="Submit" class="button" />
<%
	if (pagedArray == null) {
		%> <br />

<div class="Clear"></div>
<h4>SO Item Details</h4>
<div class="clear"></div>

<div class="cmntable">
<table width="75%" colspan="7" id="indentDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="10%">Sl No.</th>
			<th width="10%">PVMS/ NIV No. </th>
			<th width="35%">Nomenclature</th>
			<th width="20%">A/U</th>
			<th width="10%">Add</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=13 align="center">No Items Found</td>
		</tr>
	</tbody>
</table>
</div>

<%  } else { %> <br />


<div class="Clear"></div>
<h4>SO Item Details</h4>
<div class="Clear"></div>
<div class="cmntableWithHeight">
<table width="75%" colspan="7" id="indentDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="10%">Sl 	No.</th>
			<th width="10%">PVMS / NIV No.</th>
			<th width="55%">Nomenclature</th>
			<th width="25%">A/U</th>
			<th width="10%">Select all<input type="checkbox"  id="add_ALL" value="" onclick="addAll();" /></th>
		</tr>
	</thead>
	<tbody>
		<%
			    gridData = (HashMap[])pagedArray.getPagedArray();
			System.out.println("this is length size"+gridData.length);
				int iFirstRow = pagedArray.getFirstRowIdx();
			    for(int i=0;i<gridData.length;i++)
			    {
			    	%>
		<tr>
			<td width="10%"><input type="text" value="<%=iFirstRow++%>"
				class="smcaption" name="<%=SR_NO%>" size="5" readonly="readonly" /></td>
			<td width="10%">
			
			<input type="text"
				value="<%=gridData[i].get(PVMS_NO)%>" class="medcaption"
				name="<%=PVMS_NO%>" readonly="readonly"  size="9"/></td>
			<td width="55%"><input type="text"
				value='<%=gridData[i].get(NOMENCLATURE)%>' class="bigcaption"
				name="<%=NOMENCLATURE%>" readonly="readonly"  size="60"/></td>
			<td width="25%"><input type="text"
				value="<%=gridData[i].get(AU)%>" name="<%=AU%>" class="medcaption"
				readonly="readonly" size="9"/>
				
				<input type="hidden"
				value="<%=gridData[i].get("preId")%>" name="preId" class="medcaption"
				readonly="readonly" />
				
				
				</td>
			<td width="10%">
			<input type="checkbox"
				name="<%=ITEMS_TO_BE_ADDED%>" value="<%=gridData[i].get("itemId")%>"
				id="itemId<%=i+1%>" onclick=""> 
			<input type="hidden" name="<%=ITEM_ID%>"
				value="<%=gridData[i].get("itemId") %>" />
				</td>
		</tr>
		<% } %>
		<input type="hidden" name="rowLenghtName" id="rowLenght" value="<%=gridData.length%>"/>
	</tbody>
</table>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="Add"	onClick="jsAdd();" value="Add" class="button" /> 
<input	type="button" name="Add" onClick="jsClose();" value="Close"	class="button" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<% } %>
</form>
<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>
