<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreTenderM"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.masters.business.StoreTenderCommBidT"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>

<script type="text/javascript" src="/hms/jsp/js/acnik.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>


<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

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

<script language="javascript">


//this function will be called by the Bean (not from JSP)
function goPage(pidx) {	
	document.TenderLocalPurchaseOrderForm.currPage.value = pidx;
	
	TenderLocalPurchaseOrderForm.method="post";
	submitForm('TenderLocalPurchaseOrderForm','tender?method=showLPONoteJspWithGridData&currPage='+pidx+'');
}



//functions added by K.R. Othivadivel


function printNote()
{
TenderLocalPurchaseOrderForm.method="post";
submitForm('TenderLocalPurchaseOrderForm','tender?method=printLPONote&noteNo='+document.getElementById("noteNo").value);
}


function upd()
{
	TenderLocalPurchaseOrderForm.method="post";
	var currPage=document.getElementById("currPage").value;
	
	submitForm('TenderLocalPurchaseOrderForm','tender?method=updateLPOGridItems&currPage='+currPage+'');
}



function validateDeleteButton()
{
	if (TenderLocalPurchaseOrderForm.<%=ITEMS_TO_BE_DELETED%>.length)
	{
			 for(var i = 0; i < TenderLocalPurchaseOrderForm.<%=ITEMS_TO_BE_DELETED%>.length; i++)
			 {
			  if (TenderLocalPurchaseOrderForm.<%=ITEMS_TO_BE_DELETED%>[i].checked == true)
             		return true;
			 }
	}
	else
	{
		if (TenderLocalPurchaseOrderForm.<%=ITEMS_TO_BE_DELETED%>.checked == true)
			return true;
	}
	return false;
}

function del()
{
	if (validateDeleteButton())
	{
	TenderLocalPurchaseOrderForm.method="post";

	submitForm('TenderLocalPurchaseOrderForm','tender?method=deleteLPOGridItems');
	}
	else
	{
	alert('No Item(s) Selected for delete!....');
	}
}


function onTenderChange()
{
if (TenderLocalPurchaseOrderForm.<%=TENDER_NO%>.value=="")
{
alert('Pl. Check Your Input - Tender No');
return;
}
TenderLocalPurchaseOrderForm.<%=TENDER_LPO_NOTE_DATE%>.value=TenderLocalPurchaseOrderForm.TENDER_LPO_NOTE_DATE1.value;
TenderLocalPurchaseOrderForm.submit();
}


function jsDisplay() {	
	TenderLocalPurchaseOrderForm.method="post";
	if (document.searchForm.<%=TENDER_LPO_NOTE_NO%>.value=="")
	{
	alert('Pl. select Note No....');
	return;
	}

	
	
	submitForm('searchForm','tender?method=showLPONoteJspWithGridData&numOfRows=8');
}

function newNoteCreation()
{
window.location.href="tender?method=showTenderLPO";
}

function addToIndent()
{	
TenderLocalPurchaseOrderForm.method="post";
	if (TenderLocalPurchaseOrderForm.<%=TENDER_LPO_QUANTITY%>.value=="" ||
		TenderLocalPurchaseOrderForm.<%=TENDER_LPO_SUPPLIER_ID%>.value=="" ||
		TenderLocalPurchaseOrderForm.<%=NAME_ITEM%>.value=="" || isNaN(TenderLocalPurchaseOrderForm.<%=TENDER_LPO_QUANTITY%>.value))
		{
		alert('Pl. Check Your Inputs!.... ');
		return;
		}
		var  currPage=document.getElementById("currPage").value; 
		var numOfRows=document.TenderLocalPurchaseOrderForm.numOfRows.value;
	if(currPage=="undefined"){
	currPage=1;
	numOfRows=8;
	}
	if(numOfRows=="undefined"){
	currPage=1;
	numOfRows=8;
	}
		submitForm('TenderLocalPurchaseOrderForm','tender?method=createLPONoteMasterAndTransaction&numOfRows=8&currPage='+currPage+'');
}
function onChangeGroup()
{
TenderLocalPurchaseOrderForm.method="post";
 var deptId = TenderLocalPurchaseOrderForm.deptId.value;
  
   var note_no=TenderLocalPurchaseOrderForm.<%=TENDER_LPO_NOTE_NO%>.value;
   var tenderId = TenderLocalPurchaseOrderForm.<%=TENDER_NO%>.value;
   
 var url="/hms/hms/tender?method=getTenderSupplierListForLPNote&deptId="+ deptId+ "&noteNo="+note_no+"&tenderId="+tenderId+" ";
newwindow=window.open(url,'name','top=10, left=10, height=500,width=1000,status=1');
} 
 //========================= functions for ajax by Othi==========
 function ajaxFunctionForAutoCompleteInLPO(formName,action) {
 
  var xmlHttp;
  try {
    // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
  }catch (e){
    // Internet Explorer
    try{
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }catch (e){
    	alert(e)
      try{
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
      }catch (e){
        alert("Your browser does not support AJAX!");
        return false;
      }
     }
   }
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4)
      {
		obj = document.getElementById("suppliers");
		obj.length = 1;
		
      	var suppliers =xmlHttp.responseXML.getElementsByTagName('suppliers')[0];
    	if(suppliers.childNodes.length!=0){
    	
      	for (loop = 0; loop < suppliers.childNodes.length; loop++) 
      	{
	   	    var supplier = suppliers.childNodes[loop];
	        var id  = supplier.getElementsByTagName("supplierId")[0];
	        var supplierName = supplier.getElementsByTagName("supplierName")[0];
        	obj.length++;
			obj.options[obj.length -2].value=id.childNodes[0].nodeValue;
			obj.options[obj.length -2].text=supplierName.childNodes[0].nodeValue;
	    } 
      }
      else{
      alert("No suppliers for This Item");
      return;
      }
      }
    }
    
   	 var url=action
     
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
  }

function populateSupplier1(val)
{

	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	    obj = document.getElementById("suppliers");
	   
		obj.length = 1;
	    if (pvms!="")
	
ajaxFunctionForAutoCompleteInLPO('TenderLocalPurchaseOrderForm','/hms/hms/tender?method=populateSupplierInTenderLPO&pvms=' + pvms + '&tenderId=' + document.getElementById("tenderId").value + '&deptId=' + document.getElementById("deptId").value);	 	
}
 function searchForExistingNomenclature()
 {
 TenderLocalPurchaseOrderForm.method="post";
 var deptId = TenderLocalPurchaseOrderForm.deptId.value;
 var note_no=TenderLocalPurchaseOrderForm.<%=TENDER_LPO_NOTE_NO%>.value;
   var tenderId = TenderLocalPurchaseOrderForm.<%=TENDER_NO%>.value;
   var noteDate=TenderLocalPurchaseOrderForm.<%=TENDER_LPO_NOTE_DATE%>.value;
   var nomenclature1=document.getElementById("nameItem").value;
   var pvmsNo = document.getElementById("pvmsNo").value;
  
 
    var index1 = nomenclature1.lastIndexOf("[");
    
	 var index2 = nomenclature1.lastIndexOf("]");
	
	 index1++;
	 if(index1==0&&index2==-1){
	 var nomenclature= nomenclature1
	 }
	 else{
	 var nomenclature = nomenclature1.substring(0,index1-1);
		}
    var notePeriod=TenderLocalPurchaseOrderForm.<%=TENDER_LPO_NOTE_PERIOD%>.value;
   
     var tenderLpoOic=TenderLocalPurchaseOrderForm.<%=TENDER_LPO_OIC%>.value;
    
    	var currPage=document.getElementById("currPage").value;
    	if(currPage=="undefined"){
	currPage=1;
	numOfRows=10;
	}
	
    		
	 if(nomenclature!="" || pvmsNo!=""){
 	var url="/hms/hms/tender?method=searchForExistingNomenclature&requiredField="+nomenclature+"&<%=TENDER_LPO_OIC%>="+tenderLpoOic+"&<%=TENDER_NO%>="+document.getElementById("tenderId").value + "&currPage="+currPage+"&numOfRows=8&deptId="+document.getElementById("deptId").value + "&<%=TENDER_LPO_NOTE_PERIOD%>="+notePeriod+"&<%=TENDER_LPO_NOTE_DATE%>="+noteDate+"&<%=TENDER_LPO_NOTE_NO%>=" +document.getElementById("noteNo").value+"&pvmsNo="+pvmsNo;
		newwindow=window.open(url,'name','top=50, left=50, height=600,width=945,status=1');
		}
 		else{
 	 	alert("pvmsNo/nomenclature can't be left blank");
 		}
 }
 function pvmsNomenclatureSearch() 
{
	
		var pvmsNo1=document.TenderLocalPurchaseOrderForm.pvmsNo1.value;
	
	
	
	
		
		
		submitForm('TenderLocalPurchaseOrderForm','tender?method=showLPONoteJspWithGridData&numOfRows=8&pvmsNo1='+pvmsNo1+'&pageCount=10&currPage=1');
	
}	
 </script>


<%
	String date = "";
	String time = "";
	String userName = "";
	int hospitalId = 0;
	int deptId = 0;
	int note_no = 1;
	int currentPage=1;
	Box box = HMSUtil.getBox(request);
	Map<String,Object> utilMap = new HashMap<String,Object>();
	Map<String,Object> masterDataMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	String itemExist="";
 	String nomenclature = "";
 	String pvms_no = "";
  	Map map = new HashMap();
	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();
	List<MasStoreSupplier> masStoreSupplierList = new ArrayList<MasStoreSupplier>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List existingNoteList = null;
	List<StoreTenderCommBidT> storeTenderCommBidTList=new ArrayList<StoreTenderCommBidT>();
	
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		
		if (map.get("pagedArray") != null)
		{
		pagedArray = (PagedArray) map.get("pagedArray");
		}
		if (map.get("nomenclature") != null)
		{
			nomenclature = (String) map.get("nomenclature");
		}
		if (map.get("pvms_no") != null)
		{
			nomenclature = (String) map.get("pvms_no");
		}
		System.out.println("nomenclature::jsp::::"+nomenclature);
		
		if (map.get("existingNoteList") != null)
		{
		existingNoteList = (ArrayList)map.get("existingNoteList");
		}
		
		if (map.get("storeTenderMList") != null)
		{
		storeTenderMList =   (ArrayList)map.get("storeTenderMList");
		}
		
		if (map.get("employeeList") != null)
		{
		employeeList =   (ArrayList)map.get("employeeList");
		}
		
		if (map.get("masterDataMap")!=null)
		{
		masterDataMap = (Map) map.get("masterDataMap");
		}
		
		box.put(TENDER_LPO_NOTE_DATE,date);
		if (masterDataMap != null && masterDataMap.size() > 0)
		{
			System.out.println("masterDataMap" + masterDataMap);
			box.put(TENDER_LPO_NOTE_NO,masterDataMap.get(TENDER_LPO_NOTE_NO));
			box.put(TENDER_LPO_NOTE_DATE,masterDataMap.get(TENDER_LPO_NOTE_DATE));
			box.put(TENDER_LPO_NOTE_PERIOD,masterDataMap.get(TENDER_LPO_NOTE_PERIOD));
			box.put(TENDER_LPO_OIC,masterDataMap.get(TENDER_LPO_OIC));
			box.put(TENDER_NO,masterDataMap.get(TENDER_NO));
		}
		
		if (map.get("flag")!=null && map.get("flag").toString().equalsIgnoreCase("new"))
		{
			if (map.get("note_no") != null)
			{
			box.put(TENDER_LPO_NOTE_NO, map.get("note_no"));
			}
		}
		System.out.println("box.getString"+box.getString("nomenclature"));
		
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
			box.put("deptId",deptId);
		}
		
		if(map.get("storeTenderCommBidTList")!=null)
		{
			storeTenderCommBidTList =(List)map.get("storeTenderCommBidTList");
			System.out.println("size in jsp"+storeTenderCommBidTList.size());
		}
		if(pagedArray!=null){
			if((Integer)pagedArray.getCurrentPage()!=null){
				currentPage=pagedArray.getCurrentPage();
				
			}
		
		}
	}
%>

<div id="contentHolder">
<table class="tborder" width="100%" align="center">
	<tr>
		<td width="20%" nowrap="nowrap" class="vbmenu_control"
			id="threadsearch"><a href="">Search</a> <script
			type="text/javascript"> vbmenu_register("threadsearch"); </script></td>
		<td width="70%"><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>
		</td>
		<td><input type="button" name="Add" type="submit" value="Create"
			class="button" onClick="newNoteCreation();" /> <input type="button"
			name="Print" type="submit" value="Print" class="button"
			onClick="printNote();" /></td>
	</tr>
</table>

<div align="center">
<div class="page" style="width: 100%; text-align: left">
<div style="padding: 0px 25px 0px 25px"><!-- thread search menu -->
<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">

<form name="searchForm" method="post">
<table cellpadding="4" cellspacing="1" border="0">
	<tr>
		<td><label class="bodytextB"> Note No: </label></td>

		<td><select name="<%=TENDER_LPO_NOTE_NO%>">
			<option value="">Select Note</option>

			<%
			if (existingNoteList!=null && existingNoteList.size()>0)
			{
				for(int i=0;i<existingNoteList.size();i++) 
				{
				
					
				 %>
			<option value="<%=existingNoteList.get(i)%>"><%=existingNoteList.get(i)%></option>
			<% }
			}
			 %>

		</select></td>

		<td><input type="button" name="Submit" id="addbutton" value=" "
			class="morebutton" onClick="jsDisplay();" /></td>
	</tr>
</table>
</form>
</div>
</div>
</div>
</div>


<form name="TenderLocalPurchaseOrderForm" method="post" action="">
<input type="hidden" name="numOfRows" size="10" value="8" /> <input
	type="hidden" name="pageCount" size="5" value="8" /> <input
	type="hidden" name="currPage" id="currPage" value="<%=currentPage %>" />

<input type="hidden" name="hospitalId" size="5" value="<%=hospitalId%>">
<input type="hidden" name="deptId" size="5" value="<%=deptId%>"
	id="deptId"> <input type="hidden" name="<%=CHANGED_BY%>"
	value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" />

<div class="Clear"></div>
<!--  <div style="float: left;"><h2 align="left" class="style1">Tender - Local Purchase Order</h2></div>  -->
<div class="blockTitle">Local Purchase Order</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label>Note No:</label> <input
	type="text" id="noteNo" name="<%=TENDER_LPO_NOTE_NO%>"
	value="<%=box.get(TENDER_LPO_NOTE_NO)%>" readonly="readonly" tabindex=1
	validate="Note No,yes" /> <%if(box.get(TENDER_LPO_NOTE_DATE).equals("0")){
		box.put(TENDER_LPO_NOTE_DATE,"");
		}%> <label>Note Date:</label> <input type="text"
	name="<%=TENDER_LPO_NOTE_DATE%>" class="calDate"
	value="<%=box.get(TENDER_LPO_NOTE_DATE) %>" validate="Note Date,,yes"
	readonly tabindex=1 /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date" class="calender"
	tabindex="1"
	onClick="setdate( <%=date1%>,document.TenderLocalPurchaseOrderForm.<%=TENDER_LPO_NOTE_DATE%>,event)" />
<input type="hidden" name="TENDER_LPO_NOTE_DATE1"
	value="<%=box.get(TENDER_LPO_NOTE_DATE) %>" /> <label>Period</label>
<select name="<%=TENDER_LPO_NOTE_PERIOD%>" tabindex=1
	validate="Period,,yes">
	<option value="">--select period--</option>
	<option value="Jan-Mar"
		<%=HMSUtil.isSelected("Jan-Mar",box.getString(TENDER_LPO_NOTE_PERIOD))%>>Jan-Mar</option>
	<option value="Apr-Jun"
		<%=HMSUtil.isSelected("Apr-Jun",box.getString(TENDER_LPO_NOTE_PERIOD))%>>Apr-Jun</option>
	<option value="Jul-Sep"
		<%=HMSUtil.isSelected("Jul-Sep",box.getString(TENDER_LPO_NOTE_PERIOD))%>>Jul-Sep</option>
	<option value="Oct-Dec"
		<%=HMSUtil.isSelected("Oct-Dec",box.getString(TENDER_LPO_NOTE_PERIOD))%>>Oct-Dec</option>
</select>

<div class="Clear"></div>

<label>OIC </label> <select name="<%=TENDER_LPO_OIC%>" tabindex=1
	validate="OIC,,yes">
	<option value="">--select OIC--</option>
	<%
		for (Iterator iterator = employeeList.iterator(); iterator.hasNext();) 
		{
			MasEmployee masEmployee = (MasEmployee)iterator.next();
		%>
	<option value="<%=masEmployee.getId()%>"
		<%=HMSUtil.isSelected(masEmployee.getId(),Integer.valueOf(box.getInt(TENDER_LPO_OIC)))%>><%=masEmployee.getFirstName() + " " + masEmployee.getMiddleName() + " " + masEmployee.getLastName()%></option>
	<%
		}
		%>
</select> <% if (map.get("flag")!=null && map.get("flag").toString().equals("existing")) { %>
<label>Tender No</label> <select id="tenderId" name="<%=TENDER_NO%>"
	validate="Tender No,,yes">
	<%
				for (Iterator iterator = storeTenderMList.iterator(); iterator.hasNext();) 
				{
					StoreTenderM storeTenderM = (StoreTenderM)iterator.next();
					if (storeTenderM.getId() == box.getInt(TENDER_NO))
					{
				%>
	<option value="<%=storeTenderM.getId()%>"
		<%=HMSUtil.isSelected(storeTenderM.getId(),Integer.valueOf(box.getInt(TENDER_NO)))%>
		selected><%=storeTenderM.getTenderNo()%></option>
	<%
					}
				}
				%>
</select> <% } else {  %> <label>Tender No</label> <select id="tenderId"
	name="<%=TENDER_NO%>" validate="Tender No,,yes">
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
</select> <% } %> <label>Pvms No: </label> <input type="text" value='<%=pvms_no%>'
	id="pvmsNo" name="<%=CODE%>" size="20" MAXLENGTH="20" /> <label>Nomenclature:
</label> <input type="text" value='<%=nomenclature%>' class="large2"
	id="nameItem" size="50" name="<%=NAME_ITEM%>"
	onblur="populateSupplier(this.value);" /> <IMG
	SRC="/hms/jsp/images/s_search.gif" WIDTH="26" tabindex=1
	style="cursor: pointer; float: left;"
	onClick="javascript:searchForExistingNomenclature();" />
<div class="Clear"></div>
<div id=suppDiv><label>Suppliers:</label> <select
	name="<%=TENDER_LPO_SUPPLIER_ID%>" id="suppliers1">
	<%
				for (Iterator iterator = storeTenderCommBidTList.iterator(); iterator.hasNext();) 
				{
					StoreTenderCommBidT storeTenderCommBidT = (StoreTenderCommBidT)iterator.next();
					if(storeTenderCommBidT.getLcat().trim().equals("1")){
				%>
	<option value="<%=storeTenderCommBidT.getSupplier().getId()%>"><%=storeTenderCommBidT.getSupplier().getSupplierName() + " [L" + storeTenderCommBidT.getLcat().trim() + "] "%></option>
	<%
				}
					else{%>

	<option value="<%=storeTenderCommBidT.getSupplier().getId()%>"><%=storeTenderCommBidT.getSupplier().getSupplierName() + " [L" + storeTenderCommBidT.getLcat().trim() + "] "%></option>
	<%
					}
				}
				%>
</select></div>


<!-- 
		<label >Dispense.Type</label>
		<input type="text" name="<%=TENDER_LPO_DISP_TYPE%>" class="textbox_date" value=""/>
		<br /> 
		
		<label >MDQ</label>
		<input type="text" name="<%=TENDER_LPO_MDQ%>" class="textbox_date" value=""/>
		
		<label >Rate/MDQ</label>
		<input type="text" name="<%=TENDER_LPO_RATE_PER_MDQ%>" class="textbox_date" value=""/>
--> 
		<label>Qty Required</label> 
		<input type="text" name="<%=TENDER_LPO_QUANTITY%>" class="textbox_date" value="" maxlength="10" />

<div class="Clear"></div>
</div>
<div class="Clear"></div>
<input type="button" name="Add to Indent" onClick="addToIndent()"
	value="Add to Indent" class="buttonbig" accesskey="p" /> <input
	type="button" name="GetSupplierList" onClick="onChangeGroup()"
	value="Get Supplier List" class="buttonbig" accesskey="o" />
<div class="Clear"></div>

<%
	if (pagedArray == null) {
		%>
<div class="Clear"></div>
<div class="blockTitle">Item/Supplier Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="tableHolderAuto">
<table width="100%" colspan="7" id="indentDetails" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th width="5%">SR No</th>
			<th width="10%">PVMS No</th>
			<th width="10%">Nomenclature</th>
			<th width="15%">A/U</th>
			<th width="12%">Brand Name</th>
			<th width="12%">Manuf. Name</th>
			<th width="13%">Supplier Name</th>
			<th width="13%">L. Category</th>
			<th width="13%">Dispense.Type</th>
			<th width="13%">MDQ</th>
			<th width="13%">Qty Req.</th>
			<th width="13%">SO Qty</th>
			<th width="13%">Final Rate/MDQ</th>
			<th width="13%">Amount</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=13 align="center">No Items Found</td>
		</tr>
	</tbody>
</table>
</div>
<div class="Clear"></div>
<%  } else { %>
<div class="Clear"></div>

<div class="floatRight"><input type="button" name="Update"
	type="submit" value="Update" class="button" onClick="upd();"> <input
	type="button" name="Delete" type="submit" value="Delete" class="button"
	onClick="del();"></div>
<div class="Clear"></div>
<label>PVMS/NIV Search</label> <input type="text" value="" id="pvmsNo1"
	size="50" name="pvmsNo1" /> <IMG SRC="/hms/jsp/images/s_search.gif"
	WIDTH="26" tabindex=1 style="cursor: pointer; float: left;"
	onClick="javascript:pvmsNomenclatureSearch();"
	title="Click here to Search Pvms/Niv" />
<div class="Clear"></div>
<div class="blockTitle">Item/Supplier Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="tableHolderAuto">
<table width="100%" colspan="7" id="indentDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="5%">SR No</th>
			<th width="10%">PVMS No</th>
			<th width="30%">Nomenclature</th>
			<th width="15%">A/U</th>
			<th width="12%">Brand Name</th>
			<th width="12%">Manuf. Name</th>
			<th width="13%">Supplier Name</th>
			<th width="13%">L. Category</th>
			<th width="13%">Dispense.Type</th>
			<th width="13%">MDQ</th>
			<th width="10%">Qty Req.</th>
			<th width="10%">SO Qty</th>
			<th width="13%">Final Rate/MDQ</th>
			<th width="10%">Amount</th>
			<th width="10%">Delete</th>
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
				name="<%=TENDER_LPO_SRNO%>" readonly="readonly" size="3" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get(TENDER_LPO_PVMS_NO)%>"
				name="<%=TENDER_LPO_PVMS_NO%>" size="10" readonly="readonly" /></td>
			<td width="30%"><input type="text"
				value='<%=gridData[i].get(TENDER_LPO_NOMENCLATURE)%>' size="50"
				name="<%=TENDER_LPO_NOMENCLATURE%>" readonly="readonly" /></td>
			<td width="15%"><input type="text"
				value="<%=gridData[i].get(TENDER_LPO_AU)%>"
				name="<%=TENDER_LPO_AU%>" size="8" readonly="readonly" /></td>
			<td width="15%"><input type="text"
				value="<%=gridData[i].get(TENDER_LPO_BRAND)%>"
				name="<%=TENDER_LPO_BRAND%>" size="15" readonly="readonly" /></td>
			<td width="12%"><input type="text"
				value="<%=gridData[i].get(TENDER_LPO_MANUFACTURER)%>"
				name="<%=TENDER_LPO_MANUFACTURER%>" size="15" readonly="readonly" />
			</td>
			<td width="13%"><input type="text"
				value="<%=gridData[i].get(TENDER_LPO_SUPPLIER)%>"
				name="<%=TENDER_LPO_SUPPLIER %>" size="15" readonly="readonly" /></td>
			<td width="13%"><input type="text"
				value="<%=gridData[i].get(TENDER_LPO_LCAT)%>"
				name="<%=TENDER_LPO_LCAT%>" size="8" readonly="readonly" /></td>
			<td width="13%"><input type="text"
				value="<%=gridData[i].get(TENDER_LPO_DISP_TYPE)%>"
				name="<%=TENDER_LPO_DISP_TYPE%>" size="8" readonly="readonly" /></td>
			<td width="13%"><input type="text"
				value="<%=gridData[i].get(TENDER_LPO_MDQ)%>"
				name="<%=TENDER_LPO_MDQ%>" size="8" readonly="readonly" /></td>

			<td width="13%"><input type="text"
				value="<%=gridData[i].get(TENDER_LPO_QTY)%>" size="8"
				name="<%=TENDER_LPO_QTY%>" validate="Quantity,num,yes" /></td>
			<td width="13%"><input type="text"
				value="<%=gridData[i].get("actual_qty")%>" size="8"
				name="actual_qty" readonly="readonly" validate="Quantity,num,no" />
			</td>
			<td width="13%"><input type="text"
				value="<%=gridData[i].get(TENDER_LPO_RATE_PER_MDQ)%>" size="8"
				name="<%=TENDER_LPO_RATE_PER_MDQ%>" readonly="readonly" /></td>
			<td width="13%"><input type="text"
				value="<%=gridData[i].get(TENDER_LPO_AMOUNT)%>" size="8"
				name="<%=TENDER_LPO_AMOUNT%>" readonly="readonly" /></td>
			<td width="6%"><input type="checkbox"
				name=<%=ITEMS_TO_BE_DELETED%>
				value="<%=gridData[i].get(TENDER_LPO_ITEM_ID)%>"></td>
			<td width="10%"><input type="hidden"
				value="<%=gridData[i].get(TENDER_LPO_ITEM_ID)%>"
				name="<%=TENDER_LPO_ITEM_ID%>" /></td>
			<td width="5%"><input type="hidden"
				value="<%=gridData[i].get("group_id")%>" name="group_id"
				id="group_id" />
			<td width="5%"><input type="hidden"
				value="<%=gridData[i].get("supplierId")%>" name="supplierId"
				id="supplierId" /> <% System.out.println("group id in jsp"+gridData[i].get("group_id"));  %>
			</td>
		</tr>
		<% } %>
	</tbody>
</table>
</div>
<div class="Clear"></div>
<div id="pagination"><%= pagedArray.showIndex()%> <%= pagedArray.getPageIndexHiddenTag()%>
</div>
<% } %>
<div class="Clear"></div>
<div class="bottom"><label class="bodytextB">Changed By:</label> <label
	class="value"><%=userName%></label> <label class="bodytextB">Changed
Date:</label> <label class="value"><%=date%></label> <label class="bodytextB">Changed
Time:</label> <label class="value"><%=time%></label></div>
<div class="Clear"></div>
</form>
</div>


<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>


