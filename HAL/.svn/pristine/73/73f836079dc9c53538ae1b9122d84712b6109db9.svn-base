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
var noOfRows=document.getElementById('noOfRows').value;

if(document.getElementById("add_ALL").checked){
	for(i=++noOfRows;i<=rowLength;i++){
		if(document.getElementById("pvms"+i).value=='temp'){
			alert("Some niv have temporary no. please select one by one");
			for(j=noOfRows;j<=rowLength;j++){
				document.getElementById("itemId"+j).checked=false;
				}
			document.getElementById("add_ALL").checked=false;
			break;
			}
		else{
		document.getElementById("itemId"+i).checked=true;
		}
		}
}else{
	for(i=++noOfRows;i<=rowLength;i++){
		document.getElementById("itemId"+i).checked=false;
		}
}
}
</script>
<script type="text/javascript">
function submitLpDetail(){
   // window.close();
   var noOfRows=document.getElementById('noOfRows').value;
   var rowlength=document.getElementById('rowLenght').value
   var rowCounter=0;
   var j=0;
   if(noOfRows==0){
	j=1
   }else
   {
	   j=noOfRows;
	}
   
   window.opener.document.getElementById("reqType").value="importLp";
		   for( i=++noOfRows;i<=rowlength; i++){
		   if(document.getElementById('itemId'+i).checked==true){
			   if(j>10){
				  window.opener.addRow('localSupply');
				 }
				 
			rowCounter++;
		   window.opener.document.getElementById('idItem'+j).value=document.getElementById('itemId'+i).value ;
		   window.opener.document.getElementById('codeItem'+j).value=document.getElementById('pvms'+i).value ;
		   window.opener.document.getElementById('idAu'+j).value=document.getElementById('ac'+i).value ;
		   window.opener.document.getElementById('nameItem'+j).value=document.getElementById('itemName'+i).value;
		   window.opener.document.getElementById('actualqtyin'+j).value=document.getElementById('qty'+i).value;
		   window.opener.document.getElementById('actualqty'+j).value=document.getElementById('qty'+i).value;
		   window.opener.document.getElementById('quantityInVarTemp'+j).value=document.getElementById('qty'+i).value;
		   window.opener.document.getElementById('quantityInVar'+j).value=document.getElementById('qty'+i).value;
			  

		   window.opener.document.getElementById('prescription_id'+j).value=document.getElementById('prescription_id'+i).value;
			
			obj =window.opener.document.getElementById('brandId'+j);
			obj1 =window.opener.document.getElementById('manufacturerId'+j);
			obj2=window.opener.document.getElementById('dispenseType'+j);
			
			obj.length = 1;
			obj1.length = 1;
			obj2.length=1;
			
			
        	obj.length++;
        	obj1.length++;
        	
			obj.options[obj.length-1].value=document.getElementById('brandId'+i).value;
			obj.options[obj.length-1].text=document.getElementById('brandName'+i).value;
			obj.options[obj.length-1].selected = true;
			
			obj1.options[obj1.length-1].value=document.getElementById('manufactureId'+i).value;
			obj1.options[obj1.length-1].text=document.getElementById('manufactureName'+i).value;
			obj1.options[obj1.length-1].selected = true;

			
			obj2.options[obj2.length-1].value=document.getElementById('dispenseType'+i).value;
			obj2.options[obj2.length-1].text=document.getElementById('dispenseType'+i).value;
			obj2.options[obj2.length-1].selected = true;

		    j++;
		   }
		 
		   window.opener.document.getElementById('noOfRows').value=j;	 
		   window.opener.document.getElementById('rowSize').value=rowCounter;
		window.close();
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
	int noOfRows=0;
	
	 List<StorePoHeader> storePoHeaderList= new ArrayList<StorePoHeader>();
	 List<PatientPrescriptionDetails>  presList = new ArrayList<PatientPrescriptionDetails>();
	 List<MasStoreSupplier>supplierList=new ArrayList<MasStoreSupplier>();
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
 	if(map.get("noOfRows")!=null){
 		noOfRows=(Integer)map.get("noOfRows");
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
	if(map.get("soNo")!=null){
		soNo = (String)map.get("soNo");
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
<div class="titleBg">
<h2> Pending Items List</h2>
</div>
<form name="soItemForm" method="post">

<div class="Block" >
<label>SO No.</label> 
<label class="valueAuto"><%=soNo%></label>
<input type="hidden" value="<%=requestType%>" name="requestType"> 
</div>

<input type="hidden" name="numOfRows" size="5" value="15"> 
<div id=suppDiv style="visibility: hidden"></div>
<input type="hidden" name="<%=CHANGED_BY %>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
	<input type="hidden" id="noOfRows" value="<%=noOfRows%>">
<!-- -
<label>Nomenclature</label>
<input type="hidden" name="search_text" id="search_text" value="" class="bigcaption" MAXLENGTH="30" />
<div class="clear"></div>
<label>PVMS No.</label>
<input type="hidden" name="pvms" id="pvms" value="" class="medcaption" MAXLENGTH="15" />-->
</div> 
<input type="hidden" name="Submit" id="addbutton" onClick="jsSubmit()" value="Submit" class="button" />
<%
	if ( presList== null) {
		%> <br />

<div class="Clear"></div>
<h4>SO Item Details</h4>
<div class="clear"></div>

<div class="cmntable">
<table width="75%" colspan="7" id="indentDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="10%">Sl No</th>
			<th width="10%">PVMS No</th>
			<th width="35%">Nomenclature</th>
			<th width="20%">A/U</th>
            <th width="20%">Quantity Demanded</th>
			<th width="10%">Select All<input type="checkbox"  id="add_ALL" value="" onclick="addAll();" /></th>
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
 int i=noOfRows;
 int counter=0;
%>
<div class="Clear"></div>
<h4>SO Item Details</h4>
<div class="Clear"></div>
<div STYLE=" height:400px; width: 1000px; font-size: 12px; overflow: auto;">
<table width="75px" colspan="7" id="indentDetails" border="1" style="height:50px; overflow: scroll ">
	<thead>
		<tr>
			<th >Sl No.</th>
			<th >PVMS/ NIV No.</th>
			<th >Nomenclature</th>
			<th >A/U</th>
			<th >Qty Demanded</th>
			<th >Select all<input type="checkbox" id="add_ALL" onclick="addAll();"></th>
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
		for(PatientPrescriptionDetails prescriptionDetails : presList){
			i++;
			itemId="itemId";
			itemName="itemName";
			ac="ac";
			dispenseType="dispenseType";
			pvms="pvms";
			qty="qty";
			prescription_id="prescription_id";
			itemId=itemId+i;
			itemName=itemName+i;
			ac=ac+i;
			pvms=pvms+i;
			qty=qty+i;
			dispenseType=dispenseType+i;
			prescription_id=prescription_id+i;
			System.out.println("brandList.size()---->"+brandList.size());
			if(brandList.size()>=presList.size())
			{
				brandId=brandList.get(counter).getId();
				brandName=brandList.get(counter).getBrandName();
			}
			counter++;
			System.out.println("this is item_id"+itemId+"------"+i);
	 %>
		<tr>
		<%if(prescriptionDetails.getItem().getBrandedGeneric()!=null){ %>
			<input type="hidden" name="brandedGeneric" id="brandedGeneric<%=i%>" value="<%=prescriptionDetails.getItem().getBrandedGeneric()%>"/>
			<%}else{ %>
			<input type="hidden" name="brandedGeneric" id="brandedGeneric<%=i%>" value="G"/>
			<%}%>
			<%if(prescriptionDetails.getItem().getManufacturer()!=null){%>
			<input type="hidden" name="manufactureName" id="manufactureName<%=i%>" value=""/>
			<%}else{%>
			<input type="hidden" name="manufactureName" id="manufactureName<%=i%>" value=""/>
			<%}%>
			
			<%if(prescriptionDetails.getItem().getManufacturer()!=null){%>
			<input type="hidden" name="manufactureId" id="manufactureId<%=i%>" value=""/>
			<%}else{%>
			<input type="hidden" name="manufactureId" id="manufactureId<%=i%>" value=""/>
			<%}%>
			<%if(prescriptionDetails.getItem().getBrand()!=null){%>
			<input type="hidden" name="brandName" id="brandName<%=i%>" value=""/>
			<input type="hidden" name="brandId" id="brandId<%=i%>" value=""/>
			<%}else{%>
			<input type="hidden" name="brandName" id="brandName<%=i%>" value=""/>
			<input type="hidden" name="brandId" id="brandId<%=i%>" value=""/>
			<%}%>
			<td width="10%"><input type="text" value="<%=i%>." class="smcaption" name="<%=SR_NO%>" readonly="readonly" size="5"/></td>
			<%if(prescriptionDetails.getItem().getPvmsNo()!=null){ %>
			<td width="10%"><input type="text" value="<%=prescriptionDetails.getItem().getPvmsNo()%>" class="medcaption" name="<%=PVMS_NO%>"  id="<%=pvms%>" readonly="readonly" size="10"/></td>
			<% }else{%>
			<td width="10%"><input type="text" value="" class="medcaption" name="<%=PVMS_NO%>"  id="<%=pvms%>" readonly="readonly" size="10"/></td>
			<%}%>
			
			<td style="width: 40px;"><input type="text" value='<%=prescriptionDetails.getItem().getNomenclature()%>' class="bigcaption"
				name="<%=NOMENCLATURE%>" readonly="readonly" id="<%=itemName%>" size="40"/></td>
				
				
			
			
		<%if(prescriptionDetails.getItem().getItemConversion().getPurchaseUnit()!=null){
		if(prescriptionDetails.getItem().getItemConversion().getPurchaseUnit().getUnitName()!=null)
		{%>	
			<td width="25%">
			<input type="text"
				value="<%=prescriptionDetails.getItem().getItemConversion().getPurchaseUnit().getUnitName()%>" name="" class="medcaption"
				readonly="readonly" id="<%=ac%>" size="8"/>
				<%}else{%>
					<td width="25%">
			<input type="text"
				value="" name="" class="medcaption"
				readonly="readonly" id="<%=ac%>" size="8"/>
				<%}%>
		<%}else{%>
			<td width="25%">
			<input type="text"
				value="" name="" class="medcaption"
				readonly="readonly" id="<%=ac%>" size="8"/>
		<%}%>
		
		
		
		<%if(prescriptionDetails.getItem().getItemConversion().getIntermediateUnit()!=null){
		if(prescriptionDetails.getItem().getItemConversion().getIntermediateUnit().getUnitName()!=null){%>
		
		<input type="hidden"
		value="<%=prescriptionDetails.getItem().getItemConversion().getIntermediateUnit().getUnitName()%>" 
		 name=""  readonly="readonly" id="<%=dispenseType%>"  size="8"/>			
		</td>
		<%}else{%>
		<input type="hidden"
		value="" 
		 name=""  readonly="readonly" id="<%=dispenseType%>"  size="8"/></td>
		<%}%>
		<%}else{%>
		<input type="hidden"
		value="" 
		 name=""  readonly="readonly" id="<%=dispenseType%>"  size="8"/></td>
		<%}%>
		
		
		
		
				<%if(prescriptionDetails.getSoQty()!=null){%>
				<TD>
				<input type="text" value="<%=prescriptionDetails.getSoQty()%>" name="reqQty" class="medcaption"
				readonly="readonly" id="<%=qty%>"/>
				</td>
				<%}else{%>
				<TD>
				<input type="text" value="0" name="reqQty" class="medcaption"
				readonly="readonly" id="<%=qty%>"/>
				</td>
				<%}%>	
			<td width="10%">
			<%if(prescriptionDetails.getItem().getPvmsNo().equals("temp")){%>
			<input type="checkbox" name="<%=ITEMS_TO_BE_ADDED%>" value="<%=prescriptionDetails.getItem().getId()%>" id="<%=itemId%>" onclick="" disabled="disabled"> 
			<%}else{%>
			<input type="checkbox" name="<%=ITEMS_TO_BE_ADDED%>" value="<%=prescriptionDetails.getItem().getId()%>" id="<%=itemId%>" onclick="" > 
			<%}%>
			<input type="hidden" name="<%=ITEM_ID%>" value="<%=prescriptionDetails.getItem().getId()%>" />
			<input type="hidden" name="prescription_id" value="<%=prescriptionDetails.getId()%>" id="<%=prescription_id%>"/> 
			
			</td>
		</tr>
		<%}%>
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
<% } %>
</form>
<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>
