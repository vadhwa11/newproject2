<%@page import="jkt.hms.masters.business.MprPriority"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.util.Box"%>

<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.MprPriority"%>


<%@page import="jkt.hms.util.HMSUtil"%>  
<%@page import="java.text.DecimalFormat"%>

<%@page import="java.util.StringTokenizer"%>
<%@page import="java.math.BigDecimal"%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>

<script type="text/javascript" language="javascript"	src="/hms/jsp/js/stores.js"></script>

<script>
<%

Map<String,Object> utilMap1 = new HashMap<String,Object>();


utilMap1 = (Map)HMSUtil.getCurrentDateAndTime();
String newdate = (String)utilMap1.get("currentDate");  
String time = (String)utilMap1.get("currentTime");



	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>

<script type="text/javascript" language="javascript">


// For new AutoComplete

function checkForPurchase(val,a,inc)
{
		if($j("#quotationNo").val() == 0)
			{
				alert("Please select the Quotation Number");
				return;
			}
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	    console.log(pvms);
	  
	  if(pvms !="")
	  {
		 
			  ajaxFunctionForAutoCompleteInLPOGeneral('purchaseGrid','stores?method=fillItemsForLpo&pvmsNo=' +  pvms , inc);
				//ajaxFunctionForAutoCompleteForPurchase('purchaseGrid','stores?method=fillItemsCommon&pvmsNo=' +  pvms , inc);
			   	
			}
	  else{
			    return false;
			}
	 
			  	  
	    
}

function ajaxFunctionForAutoCompleteInLPOGeneral(formName,action,rowVal) {
	
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
	        var au  = item.getElementsByTagName("au")[0];
	        
        	document.getElementById('itemCode'+rowVal).value = pvms.childNodes[0].nodeValue
        	document.getElementById('ItemId'+rowVal).value = id.childNodes[0].nodeValue
        	document.getElementById('idAu'+rowVal).value = au.childNodes[0].nodeValue			
        	
      }
    }
  }
}

function autocompleteBasedOnPvms(val,inc)
{	
	// javed khan on 7-08-2013
	if(validatePvms(val)){
		ajaxFunctionForAutoCompleteForLP('purchaseGrid','stores?method=fillItemsCommon&pvmsNo=' +  val , inc);
	   	
	}else{
	    return false;
	}
	
				
}



function ajaxFunctionForAutoCompleteForLP(formName,action,rowVal) 
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
	        var name  = item.getElementsByTagName("name")[0];
	       	document.getElementById('nameItem'+rowVal).value = name.childNodes[0].nodeValue + "[" + pvms.childNodes[0].nodeValue + "]"
      }
    }
  }
}
 
function fillSrNo(rowVal){
	var pageNo=parseInt(document.getElementById('noOfRows').value);
	
	
   		rowVal=rowVal%200
   		if(rowVal==0){
   			rowVal=200
   	 		}
   		if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRows').value=rowVal
 		  	
 		  	
			}
   		
	return true;
}






</script>


<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	String previousPage = "no";
	int pageNo = 1;
	int poId = 0;
	String max = "";
	BigDecimal netAmount = null;
	Box box = null;
	String DeliveryDate = null;
	String QuotationDate = null;
	

	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
	List<Object[]> financialYearList = new ArrayList<Object[]>();
	
	
	List<MprPriority> priorityList = new ArrayList<MprPriority>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	

	if(map.get("supplierList") != null)
	 {
		supplierList =  (List<MasStoreSupplier>)map.get("supplierList");	  		 
		   
	  }
	
	if(map.get("financialYearList") != null)
	 {
		 financialYearList =  (List<Object[]>)map.get("financialYearList");	  		 
		   
	  }
	
	
	
	int userId = 0;
	if(session.getAttribute("userId") != null){
		userId = (Integer)session.getAttribute("userId");
	}
	
	
	if(map.get("max") != null){
		max = (String) map.get("max");
	}
	
	 boolean bSuccessfullyAdded = false;
	 String message = "";
	 //String AUStockId = "";
	 
	 if(map.get("bSuccessfullyAdded") != null)
	 {
		 
		 bSuccessfullyAdded =  (Boolean)map.get("bSuccessfullyAdded");
	 }
	 
	 
	 if(map.get("message") != null)
	 {
		 message =  (String)map.get("message");	  
		   
	  }	
%>



 <div class="titleBg">
<h2>Create Purchase Order</h2>
</div>

<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>

<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js"></script>

<script language="javascript">


var $j = jQuery.noConflict();
</script>
<form name="createPurchaseOrder" method="post">

<div class="Block">
<div class="clear" style="padding-top:10px;"></div>


	<label>PO No</label>
	
	<input	type="text" name="poNo" value=""  validate="PO Number,String,yes" tabindex=1  id="poNo"/>
	
	<label>Year:</label>

<select name ="ddlRequestYear" id="ddlRequestYear" onchange="getEnquiryList()">
<option value="0">Select</option>
	<%
		if(financialYearList.size()>0)
		{
			for(Object[] year : financialYearList)
			{
				%>
					<option value="<%=year[0]%>"><%=year[1]%></option>
				<%
			}
		}
	%>
</select>


<!-- <label> PO Number </span></label>
<input  type="text"  id="poNumber" name="poNumber" placeholder="System Generated"  readonly="true" />
 -->	
<label> PO Date <span>*</span></label>
<input  type="text" class="calDate"  id="poDate" name="poDate" placeholder="DD/MM/YYYY" validate="Due Date,string,yes" value="<%out.print(newdate); %>" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'mprDate');" maxlength="10" style="width: 120px"/>
	
<label> Delivery Date <span>*</span></label>
<input  type="text" class="calDate"  id="deliveryDate" name="deliveryDate" placeholder="DD/MM/YYYY" validate="Due Date,string,yes"  onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'mprDate');" maxlength="10" style="width: 120px"/>


	<div class="clear"></div>
	
	<div id="divEnquiryList">
	<label> Quotation No  <span>*</span></label>
	<select	class="" name="quotationNo" id="quotationNo" validate="Quotation No,String,yes" tabindex=1>
		<option value="">Select Quotation No</option>


</select>
</div>

	<label> Vendor Name </label>
	<select name = "supplierId" id="supplier" validate="Supplier Name,String,yes">
	<option value="">Select Vendor</option>
	<%
	for (MasStoreSupplier list :supplierList ) 
	{
		String vAdd1=list.getAddress1()!=null?list.getAddress1():"";
	    String vAdd2=list.getAddress2()!=null?list.getAddress2():"";
	    String vAdd = vAdd1.concat(vAdd2);
		%>		
		<option value=<%=list.getId()%>><%=list.getSupplierName()%>-(<%=vAdd%>)</option>
		<%   
	}
%>
	</select>	
	
	<!-- <input	name="supplier" id="supplier" validate="Supplier Name,String,yes" tabindex=1>	
	<input	type="hidden" name="supplierId" id="supplierId" >	 -->
	
	<label> Stockist/Distibutor </label>
	<select	name="ddlstockist" id="ddlstockist" validate="Stockist Name,String,no" tabindex=1>	
	<option value="">Select Stockist/Distributor</option>
	<%
	for (MasStoreSupplier list :supplierList ) 
	{
		String vAdd1=list.getAddress1()!=null?list.getAddress1():"";
	    String vAdd2=list.getAddress2()!=null?list.getAddress2():"";
	    String vAdd = vAdd1.concat(vAdd2);
		%>		
		<option value=<%=list.getId()%>><%=list.getSupplierName()%>-(<%=vAdd%>)</option>
		<%   
	}
%>
	</select>	


<div class="clear"></div>

<label> Quot. Reference No<span>*</span> </label>
<input	name="ReferenceNo" id="ReferenceNo" validate="ReferenceNo,String,yes" tabindex=1>	
	
<label> MPR Approval Date <span>*</span></label>
<input  type="text" class="calDate"  id="mprApprovalDate" name="mprApprovalDate" placeholder="DD/MM/YYYY" validate="MPR Approval Date,string,yes"  onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'mprDate');" maxlength="10"/>

<label> Proposal No<span>*</span> </label>
<input	name="ProposalNo" id="ProposalNo" validate="Proposal No,String,yes" tabindex=1>

<div class="clear"></div>
<label> Proposal Date <span>*</span></label>
<input  type="text" class="calDate"  id="ProposalDate" name="ProposalDate" placeholder="DD/MM/YYYY" validate="Proposal Date,string,yes"  onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'mprDate');" maxlength="10"/>

<label> Proposal Approval Date <span>*</span></label>
<input  type="text" class="calDate"  id="ProposalApprovalDate" name="ProposalApprovalDate" placeholder="DD/MM/YYYY" validate="Proposal Approval Date,string,yes"  onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'mprDate');" maxlength="10"/>

<label> Tax Details<span>*</span> </label>
<input	name="TaxDetails" id="TaxDetails" validate="Tax Details,String,yes" tabindex=1>
	<div class="clear"></div>
	<label> Delivery Schedule<span>*</span> </label>
	<textarea size ="20" class="large"  id="DeliverySchedule" class="medium3"  name="DeliverySchedule"  validate="Remarks,string,no" value=""   tabindex=1 style="width: 250px; height: 50px;" ></textarea>
	
	<label> Payment Terms<span>*</span> </label>
	<textarea size ="20" class="large"  id="PaymentTerms" class="medium3"  name="PaymentTerms"  validate="Remarks,string,no" value=""   tabindex=1 style="width: 250px; height: 50px;" ></textarea>
 </div>  
	
	<div class="clear paddingTop15"></div>
		<input type="hidden" size="2"	value="0"  name="noOfRows" id="noOfRows" />
		<input type="HIDDEN" name="<%=PO_ID %>" value="<%=poId %>" id="poId" />
		<input type="hidden" name="CHANGED_BY" value="<%=userId%>" />

	<!-- <input class="buttonAdd" type="button" tabindex="1" onclick="addRow('MPRGrid');" value="">
	<input class="buttonDel" type="button" tabindex="1" onclick="removeRow('MPRGrid');" value=""> -->
<div class="clear"></div>
<div id="divPOList">
<div class="cmntable">
<table id="MPRGrid">
		
		<tr id="th">
		
         
          <th width="5%">Select Item <input type="checkbox" onclick='checkAll(); getQuotationId();' id="chkAll"/></th>	      
	      <th width="5%">Mat Code</th>
	      <th width="20%">Nomenclature</th>
	      <th width="5%">A/U</th>
	      <th width="5%">Manufacturer</th>
	      <th width="5%">Brand</th>
	      <th width="10%">Qty Req.</th>
	      <th width="15%">Unit Rate</th>	      
		   <th width="13%">Item Value</th>
		 	
	   
	      
    	</tr>
    	<tbody >
    	 
				</tbody>
    

     	 
	
</table>
</div>
</div>
	
	

<input type="hidden" id="tableRowId" name="tableRowId" />
	<input type="hidden" id="txtRequestType" name="txtRequestType" />
</form>
<%-- <%}else{ %>
<h4>Access Denied! </h4>
<%}%>  --%>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>	
	
	<input type="button" name="Save"  class="button" value="Save" onclick="savePO('createPurchaseOrder','stores?method=savePO');"/>
	<input type="button" name="Submit"  class="button" value="Submit" onclick="submitPO('createPurchaseOrder','stores?method=savePO');"/>
	 <!-- <input type="button" name="sss" class="button" value="SEARCH" onclick="getSearchBlock();" /> -->
  
    <input type="hidden" class="button" value="Delete"/>
    
    <input type="hidden" class="buttonBig" value="Export To CRV"/>
	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>
	<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
		<script type="text/javascript">
		
		function dataCheck(val1, id2){
			var val = val1;
			var thisId= id2;
			if(val!=''){
				var index1 = val.lastIndexOf("[");
				var index2 = val.lastIndexOf("]");
				var masId = val.substring(index1+1,index2);
				var countStr = thisId.substring(thisId.lastIndexOf("_")+1);
				var id1 = thisId.substring(0, thisId.lastIndexOf("_"));
				 if(index1==-1 || index2==-1){
					 jQuery('#'+id1+'_addNew'+countStr).css('display', 'Block');
					 }else{
						 jQuery('#'+id1+'Id'+countStr).val(masId); 
					 }
		    }
		} 
		function addNew(countId, strId, masterName)
		{ 
				var val = jQuery('#'+strId+'_'+countId).val();
				//var flag=confirm("Add new entry!");
				 //if(flag){
						jQuery.getJSON("stores?method=jsonForMasterAdd&entryName="+val+"&masterName="+masterName, function(result){
						var str = result.entryResponce;
						jQuery('#'+strId+'_'+countId).val(str);	
						jQuery('#'+strId+'Id'+countId).val(str.substring(str.lastIndexOf("[")+1, str.lastIndexOf("]")));
						jQuery('#'+strId+'_addNew'+countId).css('display', 'none');
				        });
				/*  }else{
					 jQuery('#'+strId+'_'+countId).val('');
				 } */
		}
		
		
		var nPageNo = 1;
		
		
		function savePO(formName,url)
		{
			$j("#txtRequestType").val("SAVE");
			getQuotationId();
			var tempVal= $j("#tableRowId").val();
			if(tempVal.length>0)
				{
					submitForm(formName,url);
				}
			else
				{
					alert("Please select at least one record");
					return;
				}	
			
		}
		
		function submitPO(formName,url)
		{
			$j("#txtRequestType").val("SUBMIT");
			getQuotationId();
			var tempVal= $j("#tableRowId").val();
			if(tempVal.length>0)
				{
					submitForm(formName,url);
				}
			else
				{
					alert("Please select at least one record");
					return;
				}
		}
		
			
	function getQuotationId()
	{		
		 var valCheckBox = new Array();
			$j('[id="chk"]:checked').each(function(j)
					{
						
						valCheckBox[j] = $j(this).val();
					});
			$j("#tableRowId").val(valCheckBox);
		
	}
		
		function getEnquiryList()
		{
			if($j("#ddlRequestYear").val() == 0)
			{
				alert("Please select the Year");
				return;
			}
			var yearId=$j("#ddlRequestYear").val();
			if(yearId !=0)
				{
					submitProtoAjaxWithDivName('createPurchaseOrder','/hms/hms/stores?method=getEnquiryListbasedonYear&yearId='+yearId,'divEnquiryList');
				}
			
		}
		
		function getVendorDetails()
		{
			$j("#tblListOfQuotation").html("");
			$j("#supplier").val("");
			var quotationNo=$j("#quotationNo").val();
			if(quotationNo !=0)
				{
					var data = "quotationNo=" + quotationNo;
					var url = "stores?method=getVendorDetailsforPO";
					var bClickable = false;
					GetJsonData('tblListOfQuotation', data, url, bClickable);
				}
		
		}
		
		function getEnquiryDetails()
		{
		/* 	if($j("#ddlRequestYear").val() == 0)
			{
				alert("Please select the Year");
				return;
			} */
			var quotationNo=$j("#quotationNo").val();
			if(quotationNo !=0)
				{
					submitProtoAjaxWithDivName('createPurchaseOrder','/hms/hms/stores?method=getQuotationDetailsforPO&quotationNo='+quotationNo,'divPOList');
				}
			
		}
		
		function makeTable(jsonData) {
			//alert(jsonData);
		
			 var htmlTable = "";
			 var str = "<option value='0'>Select</option>";
			for (i = 0; i < jsonData.length; i++) {
				str+="<option value="+jsonData[i].VendorId+">"+jsonData[i].VendorName+" ("+jsonData[i].Add1+"-"+jsonData[i].Add2+")</option>"
				//$j("#supplier").val(jsonData[i].VendorName);
			//	$j("#supplierId").val(jsonData[i].VendorId);
	
				/* htmlTable = htmlTable + "<tr id='"+jsonData[i].Id+"' >";
				htmlTable = htmlTable+ "<td><input type='checkbox' name='chk"+i+"' id='chk'  onclick='getQuotationId();' style='margin-right:0px;' value='"	+ jsonData[i].Id + "'/></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"15\" class='medium3' id='txtMatCode"+i+"' name='txtMatCode"+i+"'   readonly value='"+ jsonData[i].MatCode+"' /></td>"; 
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"60\" class='medium3' id='txtItem"+jsonData[i].Id+"' name='txtItem"+jsonData[i].Id+"'   readonly value='"+ jsonData[i].Item+"' /><input  type=\"hidden\"   id='txtItemId"+jsonData[i].Id+"' name='txtItemId"+jsonData[i].Id+"'   readonly value='"+ jsonData[i].ItemId+"' /></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"20\" class='medium3' id='txtCurrencyCode"+i+"' name='txtCurrencyCode"+i+"'   readonly value="+ jsonData[i].AU+" /></td>";
				
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"30\" class='MasterData' id='Manufacturer_"+jsonData[i].Id+"' name='ManufacturerName' size='30' autocomplete='off'  /><p id='Manufacturer_addNew"+jsonData[i].Id+"' class='addNew' style='display: none;'>Add New</p><input id='ManufacturerId"+jsonData[i].Id+"' type='hidden' name='manufacturerId' value='40'><div id='ac6update"+jsonData[i].Id+"' class='autocomplete' style='display: none;'></div></td>";
				
				
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"30\" class='medium3' id='txtBrand"+jsonData[i].Id+"' name='txtBrand"+jsonData[i].Id+"'   /></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"20\" class='medium3' id='txtQtyReq"+jsonData[i].Id+"' name='txtQtyReq"+jsonData[i].Id+"'   readonly value="+ jsonData[i].QtyReq+" /></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"20\" class='medium3' id='txtUnitRate"+jsonData[i].Id+"' name='txtUnitRate"+jsonData[i].Id+"'   onblur ='calculateAmount("+jsonData[i].Id+")' onkeypress =\"return isNumber(event);\" validate=\"Unit Rate Value,string,yes\"  /></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"20\" class='medium3' id='txtItemValue"+jsonData[i].Id+"' name='txtItemValue"+jsonData[i].Id+"'   readonly validate=\"Item Value,string,yes\" /></td>";
				
				htmlTable = htmlTable + "</tr>";  */
				//alert(htmlTable);
				
				//$j("#tblListOfQuotation").html(htmlTable);
				
			}
			
			$j("#supplier").html(str);
		}
		
		function calculateAmount(inc){
		
			var quantity = 0;
			var unitRate = 0;
			var amount = 0;
			if (!isNaN(document.getElementById('txtQtyReq'+inc).value))
			quantity = parseFloat(document.getElementById('txtQtyReq'+inc).value);
			
			if (!isNaN(document.getElementById('txtUnitRate'+inc).value))
				unitRate = parseFloat(document.getElementById('txtUnitRate'+inc).value);
			// Amount Calculation
			
			if (unitRate > 0 && quantity > 0)
			{
				amount = quantity * unitRate;
				document.getElementById('txtItemValue'+inc).value =  Math.round(amount.toFixed(2));
			}else
			{
				return;
			}

		}
		
		
			
			
			

		 </script>
		
		 
		 <script>
		 
		 
		/*  function eventCallback(element, entry)
		{
			
			  return entry + "&masterName=masManufacturer";
				  //return entry + "parameters:'masterName=masManufacturer';
		}	 */
		//new Ajax.Autocompleter('Manufacturer_77','ac6update62','stores?method=getMasterByAutocomplete',{parameters:'masterName=masManufacturer'});
		
		</script>