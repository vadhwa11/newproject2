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
</script>-->
<!--<script type="text/javascript">
function addAll(){
var rowLength=document.getElementById("rowLenght").value;
var noOfRows=document.getElementById('noOfRows').value;

if(document.getElementById("add_ALL").checked){

	for(i=++noOfRows;i<=rowLength;i++){
	
		document.getElementById("itemId"+i).checked=true;
		}
}else{
	for(i=++noOfRows;i<=rowLength;i++){
		document.getElementById("itemId"+i).checked=false;
		}
}

}
</script>-->
<!--<script type="text/javascript">
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
			   if(i>10){
				  alert('idItem'+j)
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

			
			
			window.opener.document.getElementById('idBg'+j).value=document.getElementById('brandedGeneric'+i).value;
		    j++;
		   }
		 
		   window.opener.document.getElementById('noOfRows').value=j;	 
		   window.opener.document.getElementById('rowSize').value=rowCounter;
		window.close();
	   }
   
//submitForm('soItemForm','purchaseOrder?method=showPurchaseOrderwithLPItemJsp');
}
</script>-->
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
		soNo =(String) map.get("soNo");
	}

%>
<title>Result For Pvms Nomenclature Search</title>
<script>
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
<script>
function getValidatedNiv(rowVal)
{
	var itemId=document.getElementById('itemId'+rowVal).value;
	var NivNo=document.getElementById('qty'+rowVal).value;

if(document.getElementById('qty'+rowVal).value==''){
	alert("Niv no. can not be blank.")
}
else{
	submitProtoAjaxForNivValidation('soItemForm','stores?method=updateNivItems&itemId='+itemId+'&NivNo='+NivNo+'&rowVal='+rowVal);
	
}
}
</script>
<script type="text/javascript">
	function submitProtoAjaxForNivValidation(formName,action)
	{
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
	    var url=action
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	    xmlHttp.onreadystatechange=function()
	    {
	      if(xmlHttp.readyState==4){
	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	for (loop = 0; loop < items.childNodes.length; loop++)
	      	{
		   	    var item = items.childNodes[loop];
		        var id  = item.getElementsByTagName("id")[0];
		        var pvms  = item.getElementsByTagName("pvms")[0];
		        var rowVal=item.getElementsByTagName("rowVal")[0];
		        
		        alert(id.childNodes[0].nodeValue);
		        if(id.childNodes[0].nodeValue=='Data updated successfully.'){
		        document.getElementById('pvms'+rowVal.childNodes[0].nodeValue).value=pvms.childNodes[0].nodeValue;
		        }
	      }
	    }
	  }
	}
	</script>
<script type="text/javascript">
function jsClose(){
	self.close();
}
</script>













<div class="titleBg">
<h2> Pending Items List for Validation</h2>
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
			<th >NIV No.</th>
			<th >Nomenclature</th>
			<th >A/U</th>
			<th >Actual NIV No.</th>
			<th>Update</th>
		</tr>
	</thead>
	<tbody>
		<%
	    int i=0;
		String itemId="";
		String itemName="";
		String ac="";
		String dispenseType="";
		String pvms="";
		String qty="";
		String prescription_id="";
		int brandId=0;
		String brandName="";
		String Upadate="";
		for(PatientPrescriptionDetails prescriptionDetails : presList){
			if(prescriptionDetails.getItem().getPvmsNo().equals("temp"))
					{
			i++;
			itemId="itemId";
			itemName="itemName";
			ac="ac";
			dispenseType="dispenseType";
			pvms="pvms";
			qty="qty";
			prescription_id="prescription_id";
			Upadate="Upadate";
			itemId=itemId+i;
			itemName=itemName+i;
			ac=ac+i;
			pvms=pvms+i;
			qty=qty+i;
			dispenseType=dispenseType+i;
			prescription_id=prescription_id+i;
			Upadate=Upadate+i;
			if(brandList.size()>=presList.size())
			{
				brandId=brandList.get(counter).getId();
				brandName=brandList.get(counter).getBrandName();
			}
			counter++;
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
			<td width="10%"><input type="text" value="<%=prescriptionDetails.getItem().getPvmsNo()%>" class="medcaption" name="<%=PVMS_NO%>"  id="<%=pvms%>" readonly="readonly" size="10"/></td>
			<td style="width: 40px;"><input type="text" value='<%=prescriptionDetails.getItem().getNomenclature()%>' class="bigcaption"
				name="<%=NOMENCLATURE%>" readonly="readonly" id="<%=itemName%>" size="40"/></td>
			<td width="25%">
			<input type="text"
				value="<%=prescriptionDetails.getItem().getItemConversion().getPurchaseUnit().getUnitName()%>" name="" class="medcaption"
				readonly="readonly" id="<%=ac%>" size="8"/>
		<input type="hidden"
		value="<%=prescriptionDetails.getItem().getItemConversion().getIntermediateUnit().getUnitName()%>" 
		 name=""  readonly="readonly" id="<%=dispenseType%>"  size="8"/>		
				
		</td>
				<TD>
				<input type="text" value="" name="ActNiv" class="medcaption" id="<%=qty%>"/>
				</td>
				<td><input type="button" value="Update"  id="<%=Upadate%>" onclick="getValidatedNiv(<%=i%>);"></input></td>
					
			<td width="10%">
			<input type="hidden" name="<%=ITEM_ID%>" value="<%=prescriptionDetails.getItem().getId()%>"  id="<%=itemId%>"/>
			<input type="hidden" name="prescription_id" value="<%=prescriptionDetails.getId()%>" id="<%=prescription_id%>"/> 
			
			</td>
		</tr>
		<% }
			}
		%>
	</tbody>
</table>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
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
