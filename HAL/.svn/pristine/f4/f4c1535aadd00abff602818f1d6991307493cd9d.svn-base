<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.StoreGrnT"%>
<%@page import="jkt.hms.masters.business.StoreLoaninT"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />

<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
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
<!--<script type="text/javascript">
function setLpDetail()
{
	var rowVal=document.getElementById('rowLenght').value;
alert("setLpDetail"+rowVal);
for(int i=1;i<rowVal;i++){
	window.opener.document.getElementById('date').value=document.getElementById('date').value ;
	window.opener.document.getElementById('opdIssueno').value=document.getElementById('opdIssueno').value ;
	window.opener.document.getElementById('issue_date').value=document.getElementById('fromDate').value;
	window.opener.document.getElementById('issue_to_date').value=document.getElementById('toDate').value;
	window.opener.document.getElementById('time').value=document.getElementById('time').value;
}
return true;

}
</script>
--><script type="text/javascript">
function addAll(){
var rowLength=document.getElementById("rowLenght").value;

if(document.getElementById("add_ALL").checked){

	for(i=1;i<=rowLength;i++){
		document.getElementById("idItem"+i).checked=true;
		}

	
}else{
	for(i=1;i<=rowLength;i++){
		document.getElementById("idItem"+i).checked=false;
		}
}

}
</script>
<script type="text/javascript">
function submitLpDetail(){
   // window.close();
  var rowlength=document.getElementById('rowLenght').value
   //window.opener.document.getElementById("reqType").value="importLp";
   if(rowlength<10001){
	   j=1;
	   
	   var totalInvoiceAmt = parseFloat(0);
		   for( i=1;i<=rowlength;i++){
		   if(document.getElementById('idItem'+i).checked==true){
		   totalInvoiceAmt=totalInvoiceAmt+parseFloat(document.getElementById('idRa'+i).value);
		   window.opener.document.getElementById('idItem'+j).value=document.getElementById('idItem'+i).value ;
		   window.opener.document.getElementById('codeItem'+j).value=document.getElementById('codeItem'+i).value ;
		   window.opener.document.getElementById('nameItem'+j).value=document.getElementById('nameItem'+i).value ;
		   window.opener.document.getElementById('idAu'+j).value=document.getElementById('idAu'+i).value;

		   window.opener.document.getElementById('idCa'+j).value=document.getElementById('idCa'+i).value;
		   window.opener.document.getElementById('idQty'+j).value=document.getElementById('idQty'+i).value;
			window.opener.document.getElementById('idRa'+j).value=document.getElementById('idRa'+i).value;
			window.opener.document.getElementById('patientName'+j).value=document.getElementById('patientName'+i).value;
			window.opener.document.getElementById('dosage'+j).value=document.getElementById('dosage'+i).value;
			window.opener.document.getElementById('diaggnosis'+j).value=document.getElementById('diaggnosis'+i).value;
			window.opener.document.getElementById('doctorName'+j).value=document.getElementById('doctorName'+i).value;
			window.opener.document.getElementById('IndentNo'+j).value=document.getElementById('IndentNo'+i).value;
			window.opener.document.getElementById('PricriptionDetailId'+j).value=document.getElementById('PricriptionDetailId'+i).value;
			window.opener.document.getElementById('crvDetailId'+j).value=document.getElementById('crvDetailId'+i).value;
			window.opener.document.getElementById('idDis'+j).value=document.getElementById('idDis'+i).value;
			window.opener.document.getElementById('idTax'+j).value=document.getElementById('idTax'+i).value;
			window.opener.document.getElementById('iddisPer'+j).value=document.getElementById('iddisPer'+i).value;
			window.opener.document.getElementById('idunitRate'+j).value=document.getElementById('idunitRate'+i).value;

		    j++;
		   }
		 }
		   window.opener.document.getElementById('rowLenght').value=document.getElementById('rowLenght').value;	 
		   window.opener.document.getElementById('total_invoice_amount').value=roundNumber(totalInvoiceAmt,2);
	   window.close();
	   }else{
	   alert("you can not proceed");
		   }
   
//submitForm('soItemForm','purchaseOrder?method=showPurchaseOrderwithLPItemJsp');
}
</script>
<!--
//-->
<%
	String date = "";
	String time = "";
	String userName = "";
	String nomenclature = "";
	String pvms_no = "";
	int hospitalId = 0;
	String soNo="";
	String soDate="";
	String VendorId="";
	String delDate="";
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
  	Map map1=new HashMap();
  	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	List existingTenderNumbersList = null;
	List mmfyears = null;
	String tender_no;
	String storeType="";
	int currentPage=1;
	int currentYear=0;
	int mmfMasterId = 0;
	String requestType="forLPItem";
	
	 List<StorePoHeader> storePoHeaderList= new ArrayList<StorePoHeader>();
	 List<PatientPrescriptionDetails>  presList = new ArrayList<PatientPrescriptionDetails>();
	 List<StoreLoaninT>itemListGrn=new ArrayList<StoreLoaninT>();
	 List<MasStoreSupplier>supplierList=new ArrayList<MasStoreSupplier>();
	 List StoreGrnT1=new ArrayList();
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		pagedArray = (PagedArray) map.get("pagedArray");
	}
	
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
 	if(map.get("presList")!=null){
 		presList=(List<PatientPrescriptionDetails>)map.get("presList");
 	}
 	if(map.get("itemListGrn")!=null){
 		itemListGrn=(List<StoreLoaninT>)map.get("itemListGrn");
 		
 	}
 	if(map.get("map1")!=null){
		map1=(Map)map.get("map1");
 	}
 	if(map.get("supplierList")!=null)
 	{
 		supplierList=(List<MasStoreSupplier>)map.get("supplierList");	
 	}
	if(map.get("storePoHeaderList")!=null){
		storePoHeaderList=(List<StorePoHeader>)map.get("storePoHeaderList");
		}
	
	List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
	
	if(map.get("brandList")!=null){
		brandList=(List<MasStoreBrand>)map.get("brandList");
		}
	
	if (map.get("pagedArray") != null)
	{
	pagedArray = (PagedArray) map.get("pagedArray");
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
	if(request.getParameter("soNo")!=null){
		soNo=request.getParameter("soNo");
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
	self.close();
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
<script type="text/javascript">
function roundNumber(num, dec) {
	var result = Math.round(num*Math.pow(10,dec))/Math.pow(10,dec);
	return result;
}
</script>
<div class="titleBg">
<h2>Pending Items list for PROFORMA B </h2>
</div>
<form name="soItemForm" method="post">

<div class="Block" >

<input type="hidden" value="<%=requestType%>" name="requestType"> 
</div>

<input type="hidden" name="numOfRows" size="5" value="15"> 
<div id=suppDiv style="visibility: hidden"></div>
<input type="hidden" name="<%=CHANGED_BY %>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<!-- -
<label>Nomenclature</label>
<input type="hidden" name="search_text" id="search_text" value="" class="bigcaption" MAXLENGTH="30" />
<div class="clear"></div>
<label>PVMS No.</label>
<input type="hidden" name="pvms" id="pvms" value="" class="medcaption" MAXLENGTH="15" />-->
</div> 
<input type="hidden" name="Submit" id="addbutton" onClick="jsSubmit()" value="Submit" class="button" />
<%
	if ( itemListGrn== null) {
		%> <br />

<div class="Clear"></div>
<h4>SO Item Details</h4>
<div class="clear"></div>

<div class="cmntable">
<table width="75%" colspan="7" id="indentDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="10%">SR No</th>
			<th width="10%">PVMS No</th>
			<th width="35%">Nomenclature</th>
			<th width="20%">A/U</th>
            <th width="20%">Quantity Demanded</th>
			<th width="10%">ADD ALL<input type="checkbox"  id="add_ALL" value="" onclick="addAll();" /></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=13 align="center">No Items Found</td>
		</tr>
	</tbody>
</table>
</div>

<%  } else {
	%> <br />

<%
 int j=0;
 int i=0;
 int counter=0;
%>
<div class="Clear"></div>

<div STYLE=" height:400px; width: 1000px; font-size: 12px; overflow: auto;">
<table width="85%" colspan="7" id="indentDetails" 
	border="1" cellpadding="0" cellspacing="0" style="height:50px; overflow: scroll ">
	<thead>
		<tr>
			<th width="10%">Sl 	No.</th>
			<th width="10%">PVMS/ NIV No.</th>
			<th width="55%">Nomenclature</th>
			<th width="25%">A/U</th>
			<th width="20%">Qty Received</th>
			<th width="10%">Select all<input type="checkbox" id="add_ALL" onclick="addAll();"></th>
		</tr>
	</thead>
	<tbody>
		<%
	
		String itemId="";
		String itemName="";
		String ac="";
		String dispenseType="";
		String pvms="";
		String qty="";
		String prescription_id="";
		int brandId=0;
		String brandName="";
		
		
		String codeItem="";
		String idItem="";
		String nameItem="";
		String idAu="";
		String idCa="";
		String idQty="";
		String idRa="";
		String patientName="";
		String dosage="";
		String diaggnosis="";
		String doctorName="";
		String IndentNo="";
		String PricriptionDetailId="";
		String crvDetailId="";
		String idDis="";
		String idTax="";
		String iddisPer="";
		String idunitRate="";
		for(StoreLoaninT grnItems : itemListGrn){
			if(grnItems!=null)
			{
				PatientPrescriptionDetails ppd=presList.get(i);

			i++;
			codeItem="codeItem";
			idItem="idItem";
			nameItem="nameItem";
			idAu="idAu";
			idCa="idCa";
			idQty="idQty";
			idRa="idRa";
			patientName="patientName";
			dosage="dosage";
			diaggnosis="diaggnosis";
			doctorName="doctorName";
			IndentNo="IndentNo";
			PricriptionDetailId="PricriptionDetailId";
			crvDetailId="crvDetailId";
			idDis="idDis";
			idTax="idTax";
			iddisPer="iddisPer";
			idunitRate="idunitRate";
			
			
			
			codeItem=codeItem+i;
			idItem=idItem+i;
			nameItem=nameItem+i;
			idAu=idAu+i;
			idCa=idCa+i;
			idQty=idQty+i;
			idRa=idRa+i;
			patientName=patientName+i;
			dosage=dosage+i;
			diaggnosis=diaggnosis+i;
			doctorName=doctorName+i;
			IndentNo=IndentNo+i;
			PricriptionDetailId=PricriptionDetailId+i;
			crvDetailId=crvDetailId+i;
			idDis=idDis+i;
			idTax=idTax+i;
			iddisPer=iddisPer+i;
			idunitRate=idunitRate+i;
			
			counter++;
	 %>
		<tr>
			<td width="10%">
			<input type="text" value="<%=i%>."
				class="smcaption" name="<%=SR_NO%>" readonly="readonly"  size="5"/></td>
			<td width="10%"><input type="text" value="<%=grnItems.getItem().getPvmsNo()%>" class="medcaption" name="<%=PVMS_NO%>"  id="<%=codeItem%>" readonly="readonly"  size="8"/></td>
			<td width="55%">
			<input type="text" value='<%=grnItems.getItem().getNomenclature()%>' class="bigcaption" name="<%=NOMENCLATURE%>" readonly="readonly" id="<%=nameItem%>" size="60" />
			</td>
			<td width="25%">
			<input type="text"
				value="<%=grnItems.getItem().getItemConversion().getPurchaseUnit().getUnitName()%>" name="" class="medcaption"
				readonly="readonly" id="<%=idAu%>" size="9"/>
				<input type="hidden" name="brandedGeneric" id="<%=idCa%>" value="<%=grnItems.getSBg()!=null?grnItems.getSBg():""%>"/>		
			</td>
				<%if(grnItems.getReceivedQty()!=null){%><TD>
				<input type="text" value="<%=grnItems.getReceivedQty()%>" name="reqQty" class="medcaption"
				readonly="readonly" id="<%=idQty%>" size="8"/>
				</td>
				<%}else{%>
				<TD>
				<input type="text" value="0" name="reqQty" class="medcaption"
				readonly="readonly" id="<%=idQty%>" size="8"/>
				</td>
				<%}%>	
			<td width="10%">
			<input type="checkbox" name="<%=ITEMS_TO_BE_ADDED%>" value="<%=grnItems.getItem().getId()%>" id="<%=idItem%>" onclick=""> 
			
			

			<%if(ppd!=null){%>
			<input type="hidden" name="prescription_id" value="<%=ppd.getId()%>" id="<%=PricriptionDetailId%>"/> 
			<%}else{%>
			<input type="hidden" name="prescription_id" value="0" id="<%=PricriptionDetailId%>"/> 
			<%}%>
			<input type="hidden" name="cost" value="<%=grnItems.getAmountValue()%>" id="<%=idRa%>"/> 
			<input type="hidden" name="dis" value="<%=grnItems.getDiscount() %>" id="<%=idDis%>"/> 
			<input type="hidden" name="tax" value="<%=grnItems.getTax()%>" id="<%=idTax%>"/>
			<input type="hidden" name="disPer" value="<%=grnItems.getDisPrcentage()%>" id="<%=iddisPer%>"/>
			<input type="hidden" name="unitRate" value="<%=grnItems.getUnitRate()%>" id="<%=idunitRate%>"/>
			<%if(ppd!=null){
				String lastName="";
				if(ppd.getPrescription().getHin().getPLastName()!=null){
					lastName=ppd.getPrescription().getHin().getPLastName();
				}
			%>
			<input type="hidden" name="PatientName" value="<%=ppd.getPrescription().getHin().getServiceNo()+" "+ppd.getPrescription().getHin().getRank().getRankName()+" "+ppd.getPrescription().getHin().getPFirstName()+" "+lastName%>" id="<%=patientName%>"/> 
			<%}else{%>
			<input type="hidden" name="PatientName" value="" id="<%=patientName%>"/> 
			<%}%>
			<%if(ppd!=null){
			if(ppd.getDosage()!=null){%>
			<input type="hidden" name="dosage" value="<%=ppd.getDosage()+"  "+ppd.getFrequency().getFrequencyName()%>" id="<%=dosage%>"/> 
			<%}else{%>
			<input type="hidden" name="dosage" value="" id="<%=dosage%>"/> 
			<%}}else{%>
			<input type="hidden" name="dosage" value="" id="<%=dosage%>"/> 
			<%}%>
			
			<%if(ppd!=null){
				if(ppd.getPrescription().getVisit().getDiagnosisString()!=null){%>
			<input type="hidden" name="diagnosis" value="<%=ppd.getPrescription().getVisit().getDiagnosisString()%>" id="<%=diaggnosis%>"/> 
				<%}else{%>
			<input type="hidden" name="diagnosis" value="" id="<%=diaggnosis%>"/> 
				
				<%}}else{%>
				<input type="hidden" name="diagnosis" value="" id="<%=diaggnosis%>"/> 
				<%}%>
				<%if(ppd!=null){
				if(ppd.getPrescription().getSpecialty()!=null){%>
			<input type="hidden" name="DoctorName" value="<%=ppd.getPrescription().getSpecialty()%>" id="<%=doctorName%>"/> 
			<%}else{%>
				<input type="hidden" name="DoctorName" value="" id="<%=doctorName%>"/> 
				
				<%}}else{%>
			<input type="hidden" name="DoctorName" value="" id="<%=doctorName%>"/> 
			<%}%>
			<input type="hidden" name="soNumber" value="N/A" id="<%=IndentNo%>"/> 
			</td>
			<input type="hidden" name="crvDetailId" value="<%=grnItems.getId()%>" id="<%=crvDetailId%>"/>
		</tr>
		<% }
			}
		%>
		<tr><td><input type="hidden" name="rowLenghtName" id="rowLenght" value="<%=i%>"/></td></tr>
	</tbody>
</table>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="Add"	onClick="submitLpDetail();" value="Add" class="button" /> 
<input	type="button" name="Add" onClick="jsClose();" value="Close"	class="button" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<%}%>
</form>
<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>
