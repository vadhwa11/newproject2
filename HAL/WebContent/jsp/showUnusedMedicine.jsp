
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.util.Box"%>



<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.text.DecimalFormat"%>

<%@page import="java.util.StringTokenizer"%>
<%@page import="java.math.BigDecimal"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

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
	

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	
	
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
<%if(true){ %>



 <div class="titleBg">
<h2>Add Returned Medicine</h2>
</div>

 <script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script> 
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js"></script>


<script language="javascript">


var $j = jQuery.noConflict();
</script>
<form name="ReturnedMedicine" method="post">


<div class="Block">


<label> Date <span>*</span></label>
<input  type="text" class="input_date"  id="mprDate" name="mprDate" placeholder="DD/MM/YYYY" validate="Date,string,yes" value="<%out.print(newdate); %>" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'mprDate');" maxlength="10"/>
	

	
	<label>Remarks</label>
	
	<textarea value="" name="<%=REMARKS %>" validate="Remarks ,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" maxlength="200"/></textarea> 
	
</div>  
	
	
 
	<!-- <input type="button" class="buttonBig2" value="IMPORT ITEMS BELOW ROL"  onclick="getMMF();"/>  --> 

	<div class="clear"></div>

	<div class="clear paddingTop15"></div>
		<input type="hidden" size="2"	value="0"  name="noOfRows" id="noOfRows" />
		<input type="HIDDEN" name="<%=PO_ID %>" value="<%=poId %>" id="poId" />
		<input type="hidden" name="CHANGED_BY" value="<%=userId%>" />

	<input class="buttonAdd" type="button" tabindex="1" onclick="addRow('MPRGrid');" value="">
	<input class="buttonDel" type="button" tabindex="1" onclick="removeRow('MPRGrid');" value="">
<div class="clear"></div>
<div class="cmntable">
<table id="MPRGrid">
		
		<tr id="th">
		
         
          <th>Delete</th>
	    
	      <th width="15%">Mat Code</th>
	      <th width="15%">Nomenclature</th>
	       <th width="15%">A/U</th>
	      <th width="15%">Batch No</th>
	      <th width="18%">Expiry Date</th>
	      <th width="30%">Item Name</th>
	      <th width="10%">Enter Qty</th>
	      <th width="10%">Manufactured Date</th>
	      <th width="10%">Brand</th>
	      <th width="10%">Manufacturer</th>	    
	      <th width="15%">Unit Rate</th>
	      <th width="13%">Estimated Value</th>
	      	      
    	</tr>
    <% int inc=1; %>
 
 
  
   <tr id="<%out.print(inc); %>">
      <td><input size="2" type="checkbox" class="small_chk" id="chk" value="<%out.print(inc); %>" /></td>
       <td>
      <input type="text" name="itemCode" tabindex="1" id="itemCode<%out.print(inc); %>" onblur="autocompleteBasedOnPvms(this.value,'<%=inc %>');" validate="PVMS No,String,no" size="12"/>
      <input type="hidden" name="ItemId" tabindex="1" id="ItemId<%out.print(inc); %>" />
      </td>
      
		<td> 	<input type="text" value=""	id="nameItem<%=inc %>" validate='Nomenclature ,String,no' onblur="checkForPurchase(this.value, 'nameItem','<%=inc %>');" name="nameItem<%=inc %>" tabindex="1" size="50" />
		<div id="ac2update" style="display:none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
//		if(!validateMetaCharacters(this.value))
//		{
	    new Ajax.Autocompleter('nameItem<%=inc %>','ac2update','purchaseOrder?method=getItemListForPurchaseOrder',{parameters:'requiredField=nameItem<%=inc %>&poId='+document.getElementById('poId').value })
	    
	//	}
		</script>
		</td> 
      <td>
      <input type="text" value="" class="smcaption" readonly="readonly" name="AV<%out.print(inc); %>" id="idAu<%out.print(inc); %>" tabindex="1" validate="A/U ,String,no" size="8"/>
      </td>
    
      <td><input size="15" id="BatchNo<%out.print(inc); %>" name="BatchNo"  type="text" maxlength="15" onblur="getItemName('BatchNo',this.value,<%out.print(inc); %>)"  ></td>
	  <td><input size="20" style="width: 70px;" id="ExpiryDate<%out.print(inc); %>" name="ExpiryDate"  type="text" maxlength="10"  onkeyup="mask(this.value,this,'2,5','/');" validate="Expiry Date,string,yes" placeholder="DD/MM/YYYY" style="width: 70px;"  onblur="getItemName('ExpiryDate',this.value,<%out.print(inc); %>)" ></td>
	  <td><select  id="itemName<%out.print(inc); %>" name="itemName<%out.print(inc); %>" onchange="getItemDetails(<%out.print(inc); %>)">
	  <option value="0">Select</option>
	  </select><input type="hidden" name="ItemStockId" tabindex="1" id="ItemStockId<%out.print(inc); %>" /></td>
	  
	  <td> <input  size="15" type="text" value="" onkeypress ="return isNumber(event);"   id="txtEnteredQty<%out.print(inc); %>" name="txtEnteredQty"  validate="Entered Qty,string,yes" onblur ="calculateAmount(<%out.print(inc); %>);"/></td>
	  <td> <input  size="15" type="text" value=""   name="txtManuDate" id="txtManuDate<%out.print(inc); %>"  maxlength="10"  onkeyup="mask(this.value,this,'2,5','/');" validate="Manufacturer Date,string,yes" placeholder="DD/MM/YYYY" style="width: 70px;"  /></td>
	  <td>
		<input type="text" value="" size="30" class="MasterData" tabindex="1" validate="Brand,string,yes" name="BrandName" id="<%="Brand_"+inc%>" />
		<p class="addNew" style="display:none" onclick="addNew(<%=inc %>,'Brand', 'masStoreBrand')" id="<%="Brand_addNew"+inc%>">Add New?</p>
		<input type="hidden" name="BrandId" id="<%="BrandId"+inc%>" value="" />
		<div id="ac6update" class="autocomplete" style="display: none;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			new Ajax.Autocompleter('<%="Brand_"+inc%>','ac6update','stores?method=getMasterByAutocomplete',{parameters:'masterName=masStoreBrand'});	
		</script>
	</td>
	  <td>
 		<input type="text" value="" size="30" class="MasterData" tabindex="1" validate="Manufacturer,string,yes"  name="ManufacturerName" id="<%="Manufacturer_"+inc%>" />
 		<p class="addNew" style="display:none" onclick="addNew(<%=inc %>,'Manufacturer', 'masManufacturer')" id="<%="Manufacturer_addNew"+inc%>">Add New?</p>
		<input type="hidden" name="ManufacturerId" id="<%="ManufacturerId"+inc%>" value="" />
		<div id="ac6update" class="autocomplete" style="display: none;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			new Ajax.Autocompleter('<%="Manufacturer_"+inc%>','ac6update','stores?method=getMasterByAutocomplete',{parameters:'masterName=masManufacturer'});	
		</script>
 		<%-- <select name="<%=RequestConstants.MANUFACTURER_ID%>" id=<%=manuId+inc%> tabindex=1  validate="Manufacture,string,yes">
		<option value="0">Select</option>
		<%for (MasManufacturer masManufacturer :manufacturerList ) {%>
			<option value=<%=masManufacturer.getId()%>><%=masManufacturer.getManufacturerName()%></option>
		<%}%>
		</select> --%>
	</td>
	
	  <td> <input  size="15" type="text" value=""  class="medium3" name="txtUnitRate"  id="txtUnitRate<%out.print(inc); %>" onkeypress ="return isNumber(event);"    validate="Unit Rate Qty,string,yes" onblur ="calculateAmount(<%out.print(inc); %>);"  /></td>
	   <td> <input  size="15" type="text" value=""   id="txtItemValue<%out.print(inc); %>"  readonly/></td>
	      
       
		  
   
       </tr>
   <%
     	 }   %>
     	 
	
</table>
</div>
<div class="clear"></div>	
	

</form>
<%-- <%}else{ %>
<h4>Access Denied! </h4>
<%}%>  --%>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>	
	
	<!-- <input type="button" name="Save"  class="button" value="Save" onclick="saveReturnedMedicine('ReturnedMedicine','stores?method=addStockofReturnedMedicine');"/> -->
	<input type="button" name="Submit"  class="button" value="Submit" onclick="submitReturnedMedicine('ReturnedMedicine','stores?method=addStockofReturnedMedicine');"/>
		
    <!-- <input type="button" name="sss" class="button" value="SEARCH" onclick="getSearchBlock();" /> -->
  
    <input type="hidden" class="button" value="Delete"/>
    
    <input type="hidden" class="buttonBig" value="Export To CRV"/>
	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>
		<script type="text/javascript">
		
		
		function addRow(tableId)
		{
			
			var j= $j("#"+tableId+" tr:last").attr("id");
			
			if(j == "th")
				{
					var i = 1;
				}
			else
				{
					j=j*1;
					var i = j+1;
				}  
		
			
	
			  var tableHtml ="";
			  tableHtml= tableHtml +("<tr id='"+i+"'><td size = '2'><input type=\"checkbox\" class=\"small_chk\" id=\"chk\" value="+i+" /></td>");
			  tableHtml= tableHtml +("</td><td><input type='text' name='itemCode"+i+"' id='itemCode"+i+"' validate='Mat Code,String,no' size='12'/><input type='hidden' name='ItemId'  id='ItemId"+i+"' value=''/></td>");
			  tableHtml= tableHtml +("<td><input type='text' id='nameItem"+i+"' name='nameItem"+i+"' validate='Nomenclature ,String,no' onblur=\"checkForPurchase(this.value, 'nameItem','"+i+"');\"   size='50' /><div id='ac2update' style='display:none;' class='autocomplete'></div></td>");
			  tableHtml= tableHtml +("<td><input type='text' value='' class='smcaption' readonly='readonly' name='AV"+i+"' id='idAu"+i+"' validate='AU ,String,no' size='8'/></td>");
			 
			  tableHtml= tableHtml +("<td> <input  type=\"text\"  size=\"15\" class='medium3' id='BatchNo"+i+"' name='BatchNo'  onblur =\"getItemName('BatchNo',this.value,"+i+");\" /></td>");
			  tableHtml = tableHtml + "<td> <input  type=\"text\"  size=\"10\"  id='ExpiryDate"+i+"' name='ExpiryDate'  onkeyup=\"mask(this.value,this,'2,5','/');\" validate='Expiry Date,string,yes' placeholder=\"DD/MM/YYYY\" maxlength='10' onblur =\"getItemName('ExpiryDate',this.value,"+i+");\" /></td>";
			  tableHtml= tableHtml +("<td><select name='itemName"+i+"' id='itemName"+i+"' onchange='getItemDetails("+i+");' ><option value='0'>Select</option></select><input type='hidden' name='ItemStockId' id='ItemStockId"+i+"' /></td>");
			  
			  tableHtml= tableHtml +("<td> <input  type=\"text\"  size=\"15\" class='medium3' id='txtEnteredQty"+i+"' name='txtEnteredQty'  validate=\"Qty,TwoDigitAfterDecimal,yes\"  maxlength='10' onkeypress=\"return isNumber(event);\" onblur =\"calculateAmount("+i+");\" /></td>");

			  
			  tableHtml = tableHtml + "<td> <input  type=\"text\"  size=\"10\"  id='txtManuDate"+i+"' name='txtManuDate'  onkeyup=\"mask(this.value,this,'2,5','/');\" validate='Manufacturer Date,string,yes' placeholder=\"DD/MM/YYYY\" maxlength='10' /></td>";
			  tableHtml= tableHtml +("<td><input class='MasterData' size=\"30\" type='text' id='Brand_"+i+"' name='BrandName' validate='Brand,string,yes' /><p class='addNew' style='display:none' onclick=\"addNew("+i+",'Brand', 'masStoreBrand')\" id='Brand_addNew"+i+"'>Add New?</p><input type=\"hidden\" name=\"BrandId\" id='BrandId"+i+"' value='' /><div id='ac6update' style='display:none;' class='autocomplete'></div> </td>");
			  tableHtml= tableHtml +("<td><input class='MasterData' size=\"30\" type='text' id='Manufacturer_"+i+"' name='ManufacturerName' validate='Manufacturer,string,yes' /><p class='addNew' style='display:none' onclick=\"addNew("+i+",'Manufacturer', 'masManufacturer')\" id='Manufacturer_addNew"+i+"'>Add New?</p><input type=\"hidden\" name=\"ManufacturerId\" id='ManufacturerId"+i+"' value='' /><div id='ac6update' style='display:none;' class='autocomplete'></div> </td>");
			 
			  tableHtml= tableHtml +("<td> <input  type=\"text\"  size=\"15\" class='medium3' name='txtUnitRate' id='txtUnitRate"+i+"'   validate=\"Unit Rate,TwoDigitAfterDecimal,yes\"  maxlength='10' onkeypress=\"return isNumber(event);\" onblur =\"calculateAmount("+i+");\"  /></td>");
			  tableHtml= tableHtml +("<td> <input  type=\"text\"  size=\"15\" class='medium3' name='txtItemValue'  id='txtItemValue"+i+"'    readonly /></td>");
			  
			  
			  
			  tableHtml= tableHtml +("</tr>");
			  $j("#"+tableId).append(tableHtml);
			  
			 	
				 new Ajax.Autocompleter('nameItem'+i,'ac2update','purchaseOrder?method=getItemListForPurchaseOrder',{parameters:'requiredField=nameItem'+i+'&poId='+document.getElementById('poId').value })
				 
				 new Ajax.Autocompleter('Manufacturer_'+i,'ac6update','stores?method=getMasterByAutocomplete',{parameters:'masterName=masManufacturer'});
				 
				 new Ajax.Autocompleter('Brand_'+i,'ac6update','stores?method=getMasterByAutocomplete',{parameters:'masterName=masStoreBrand'});
				
			
			  var valRowId = new Array();
				$j("#"+tableId+" tr[id!='th']").each(function(j)
						{				
							valRowId[j] =$j(this).attr("id");
						});
				
				
				$j("#tableRowId").val(valRowId);
			 
		}
		
		function addReturnedMedicine(formName,url)
		{
			/* $j("#txtRequestType").val("SAVE");
			 var valRowId = new Array();
				$j("#MPRGrid tr[id!='th']").each(function(j)
						{				
							valRowId[j] =$j(this).attr("id");
						});		
				
				$j("#tableRowId").val(valRowId);
						
				if(!checkDuplicateItemInGrid(valRowId,'nameItem', 'Nomenclature'))
				 {				
				 	return;
				 }	 */		
				 submitForm(formName,url);
			
	}
		
		function submitReturnedMedicine(formName,url)
		{
			$j("#txtRequestType").val("SUBMIT");
			/*  var valRowId = new Array();
				$j("#MPRGrid tr[id!='th']").each(function(j)
						{				
							valRowId[j] =$j(this).attr("id");
						});		
				
				$j("#tableRowId").val(valRowId);
						
				if(!checkDuplicateItemInGrid(valRowId,'nameItem', 'Nomenclature'))
				 {				
				 	return;
				 }	 */		
				 submitForm(formName,url);
			
	}
		
		function GetMPRAndPODetails(inc)
		{
		
			var itemId = $j("#ItemId"+inc).val();
			console.log("sss"+itemId);
			
			var data = "ItemId=152";
			
			
			var url = "stores?method=GetMPRAndPODetailsOfItem";
			
		   GetAjaxData(data,url)
			
		}
		
		function ExecuteAjaxData(msg)
		{
				//alert("Ajax="+msg);
		}
		
		function calculateAmount(inc){
			
			var quantity = 0;
			var unitRate = 0;
			var amount = 0;
			if (!isNaN(document.getElementById('txtEnteredQty'+inc).value))
			quantity = parseFloat(document.getElementById('txtEnteredQty'+inc).value);
			
			if (!isNaN(document.getElementById('txtUnitRate'+inc).value))
				unitRate = parseFloat(document.getElementById('txtUnitRate'+inc).value);
			// Amount Calculation
			
			if (unitRate > 0 && quantity > 0)
			{
				amount = quantity * unitRate;
				document.getElementById('txtItemValue'+inc).value =  amount.toFixed(2);
			}else
			{
				return;
			}

		}
		
		function getItemName(flag,val,inc)
		{
		    console.log(flag);
			var BatchNo = $j("#BatchNo"+inc).val();
			var ExpiryDate = $j("#ExpiryDate"+inc).val();
			var itemName= $j("#nameItem"+inc).val();
			
			
			if(flag == 'BatchNo')
				{
					if(BatchNo !="" && itemName =="")
					  {
						 
							  ajaxFunctionForAutoCompleteInReturnedMedicine('ReturnedMedicine','stores?method=fillItemsForUnsedMedicine&BatchNo='+BatchNo+"&flag=BatchNo" , inc);
								//ajaxFunctionForAutoCompleteForPurchase('purchaseGrid','stores?method=fillItemsCommon&pvmsNo=' +  pvms , inc);
							   	
							}
					  else{
							    return false;
							}
				}
			
			if(flag == 'ExpiryDate')
			{
				if(ExpiryDate !="" && itemName =="")
				  {
					 
						  ajaxFunctionForAutoCompleteInReturnedMedicine('ReturnedMedicine','stores?method=fillItemsForUnsedMedicine&ExpiryDate='+ExpiryDate+"&flag=ExpiryDate" , inc);
							//ajaxFunctionForAutoCompleteForPurchase('purchaseGrid','stores?method=fillItemsCommon&pvmsNo=' +  pvms , inc);
						   	
						}
				  else{
						    return false;
						}
			}
			
		}
		


		function ajaxFunctionForAutoCompleteInReturnedMedicine(formName,action,rowVal) {
			$j("#itemName"+rowVal).empty();
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
		      	 
				//alert(items.childNodes.length)
				
				if(items.childNodes.length>0)
					{
					$j("#itemName"+rowVal).append("<option value=0>Select Item</option>")
						for (loop = 0; loop < items.childNodes.length; loop++) 
				      	{
				      
					   	    var item = items.childNodes[loop];
					   	    
					        var id  = item.getElementsByTagName("id")[0];
					        var pvms  = item.getElementsByTagName("pvms")[0];
					        var nomen  = item.getElementsByTagName("nomen")[0];
					        
				        	$j("#itemName"+rowVal).append("<option value="+id.childNodes[0].nodeValue+">"+nomen.childNodes[0].nodeValue+"["+pvms.childNodes[0].nodeValue+"]</option>")	
				        	
				      }
					
					}
				else
					{
					alert("Mat Code and Nomenclature is not available for given input.")
					$j("#itemName"+rowVal).append("<option value=0>Select Item</option>")
					 document.getElementById('ItemStockId'+rowVal).value = id.childNodes[0].nodeValue
				        document.getElementById('txtManuDate'+rowVal).value = manuDate.childNodes[0].nodeValue
			        	document.getElementById('Brand_'+rowVal).value = brand.childNodes[0].nodeValue
			        	document.getElementById('Manufacturer_'+rowVal).value = manu.childNodes[0].nodeValue	
			        	document.getElementById('txtUnitRate'+rowVal).value = rate.childNodes[0].nodeValue
			        	document.getElementById('ExpiryDate'+rowVal).value = expiryDate.childNodes[0].nodeValue
						
					}
		      	
		    }
		  }
		}
		
		function getItemDetails(inc)
		{
			var itemId = $j("#itemName"+inc).val();
			itemId =itemId*1;
			
			if(itemId !=0)
			  {
				 
					  ajaxFunctionForAutoCompleteInReturnedMedicineforItem('ReturnedMedicine','stores?method=getItemDetailsFromStock&itemId=' +  itemId , inc);
						//ajaxFunctionForAutoCompleteForPurchase('purchaseGrid','stores?method=fillItemsCommon&pvmsNo=' +  pvms , inc);
					   	
					}
			  else{
					    
				  		
				  		document.getElementById('ItemStockId'+inc).value = 0;
					 //	document.getElementById('txtManuDate'+inc).value = ""
			        	document.getElementById('Brand_'+inc).value = ""
			        	document.getElementById('Manufacturer_'+inc).value = ""	
			        	//document.getElementById('txtUnitRate'+inc).value = ""
			        	document.getElementById('ExpiryDate'+inc).value = ""
			        	document.getElementById('BatchNo'+inc).value = ""
			        	document.getElementById('txtEnteredQty'+inc).value = ""
			        	document.getElementById('txtItemValue'+inc).value = ""
					  	return false;
					    
					}
		
		}
		
		
		function ajaxFunctionForAutoCompleteInReturnedMedicineforItem(formName,action,rowVal) {
			
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
		      	 
				//alert(items.childNodes.length)
				
				if(items.childNodes.length>0)
					{
					
						for (loop = 0; loop < items.childNodes.length; loop++) 
				      	{
				      
					   	    var item = items.childNodes[loop];
					   	    
					        var id  = item.getElementsByTagName("id")[0];
					        var batchNo  = item.getElementsByTagName("batchNo")[0];
					        var expiryDate  = item.getElementsByTagName("expiryDate")[0];
					        var manuDate  = item.getElementsByTagName("manuDate")[0];
					        var brand  = item.getElementsByTagName("brand")[0];
					        var manu  = item.getElementsByTagName("manu")[0];
					        var rate  = item.getElementsByTagName("rate")[0];
					        var batchNo  = item.getElementsByTagName("batchNo")[0];
					        
					        document.getElementById('ItemStockId'+rowVal).value = id.childNodes[0].nodeValue
					        document.getElementById('txtManuDate'+rowVal).value = manuDate.childNodes[0].nodeValue
				        	document.getElementById('Brand_'+rowVal).value = brand.childNodes[0].nodeValue
				        	document.getElementById('Manufacturer_'+rowVal).value = manu.childNodes[0].nodeValue	
				        	document.getElementById('txtUnitRate'+rowVal).value = rate.childNodes[0].nodeValue
				        	document.getElementById('ExpiryDate'+rowVal).value = expiryDate.childNodes[0].nodeValue
				        	document.getElementById('BatchNo'+rowVal).value = batchNo.childNodes[0].nodeValue
					        
				        	
				      }
					
					}
				else
					{
					 	document.getElementById('ItemStockId'+rowVal).value = 0;
						document.getElementById('txtManuDate'+rowVal).value = ""
			        	document.getElementById('Brand_'+rowVal).value = ""
			        	document.getElementById('Manufacturer_'+rowVal).value = ""	
			        	document.getElementById('txtUnitRate'+rowVal).value = ""
			        	document.getElementById('ExpiryDate'+rowVal).value = ""
			        	document.getElementById('BatchNo'+rowVal).value = ""
			        	document.getElementById('txtEnteredQty'+rowVal).value = ""
			        	document.getElementById('txtItemValue'+rowVal).value = ""
						alert("Some error Occured.")
						
					}
		      	
		    }
		  }
		}
		
	
		//	jQuery(".MasterData").live('blur',function(){
				$j("body").on('blur','.MasterData',function(){
				var val = this.value;
				var thisId= this.id;
				
				
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
		    }});
				
				
	
			 function dataCheck(val1, id2){
				var val = val1;
				var thisId= id2;
				if(val!=''){
					var index1 = val.lastIndexOf("[");
					var index2 = val.lastIndexOf("]");
					var masId = val.substring(index1+1,index2);
					var countStr = thisId.substring(thisId.lastIndexOf("_")+1);
					var id1 = thisId.substring(0, thisId.lastIndexOf("_"));
					console.log(id1);
					 if(index1==-1 || index2==-1){
						 jQuery('#'+id1+'_addNew'+countStr).css('display', 'Block');
						 }else{
							 jQuery('#'+id1+'Id'+countStr).val(masId); 
						 }
			    }
			} 
			function addNew(countId, strId, masterName){ 
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
		 </script>
		
		 </script>