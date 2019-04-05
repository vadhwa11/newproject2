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
	List<Object[]> employeeList = new ArrayList<Object[]>();
	
	
	
	List<MprPriority> priorityList = new ArrayList<MprPriority>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	

	
	
	if(map.get("financialYearList") != null)
	 {
		 financialYearList =  (List<Object[]>)map.get("financialYearList");	  		 
		   
	  }

	if(map.get("employeeList") != null)
	 {
		employeeList =  (List<Object[]>)map.get("employeeList");	  		 
		   
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
<%if(session.getAttribute("deptId").toString().equals("24")){ %>



 <div class="titleBg">
<h2>Create Indent to Supplier for PO</h2>
</div>

<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>

<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>

<script language="javascript">


var $j = jQuery.noConflict();
</script>
<form name="SupplierIndent" method="post">

<div class="Block">
<div class="clear"></div>

<!-- 

	<label>Enquiry No</label>
	
	<input	type="text" name="EnquiryNo" value="System generated"  validate="Enquiry Name ,String,yes" tabindex=1  id="EnquiryNo"/> -->
	<label> Indent Date <span>*</span></label>
<input  type="text" class="input_date"  id="todate-pick" name="indentDate" placeholder="DD/MM/YYYY" validate="Indent Date,string,yes" value="<%out.print(newdate); %>" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'mprDate');" maxlength="10" style="width: 127px"/>
	
	<label>Select Year</label>

<select name ="ddlRequestYear" id="ddlRequestYear" onchange="getPOList()">
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


<div id="divPOList">
	<label> Purchase Order No  <span>*</span></label>
	<select	class="" name="poNo" id="poNo" validate="Purchase Order No,String,yes" tabindex=1 onclick="checkYear();">
		<option value="">Select Purchase Order No</option>


</select>
</div>
	


	<div class="clear" style="height:5px;"></div>
	
<label> PO Date</label>
<input  type="text"   id="poDate" name="poDate"   onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'mprDate');"  readonly/>

<label> Vendor Name </label>
<input	name="supplier" id="supplier" validate="Supplier Name,String,yes" tabindex=1>	
<input	type="hidden" name="supplierId" id="supplierId" >	

<label> Stockist/Distributor Name </label>
<input	name="stockist" id="stockist" validate="Stockist/Distributo Name,String,yes" tabindex=1>	




	
<!-- <label> Delivery Date</label>
<input  type="text"   id="deliveryDate" name="deliveryDate"   onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'mprDate');"  readonly/>
 -->		


<div class="clear" style="height:5px;"></div>




<%-- <label>Checked By</label>

<select name ="ddlEmployee" id="ddlEmployee" validate="Checked By, string, yes" >
<option value="0">Select</option>
	<%
		if(employeeList.size()>0)
		{
			for(Object[] emp : employeeList)
			{
				%>
					<option value="<%=emp[0]%>"><%=emp[1]%></option>
				<%
			}
		}
	%>
</select>
 --%>


 </div>  
	<div class="clear"></div>
	<div class="clear paddingTop15"></div>
		<input type="hidden" size="2"	value="0"  name="noOfRows" id="noOfRows" />
		<input type="HIDDEN" name="<%=PO_ID %>" value="<%=poId %>" id="poId" />
		<input type="hidden" name="CHANGED_BY" value="<%=userId%>" />

	<!-- <input class="buttonAdd" type="button" tabindex="1" onclick="addRow('MPRGrid');" value="">
	<input class="buttonDel" type="button" tabindex="1" onclick="removeRow('MPRGrid');" value=""> -->
<div class="clear"></div>
<div class="cmntable">
<table id="MPRGrid">
		
		<tr id="th">
		
         
          <th width="5%">Select Item <input type="checkbox" onclick='checkAll(); getPOId();' id="chkAll"/></th>	      
	      <th width="5%">Mat Code</th>
	      <th width="20%">Nomenclature</th>
	     <!--  <th width="5%">A/U</th>
	      <th width="5%">Manufacturer</th>
	      <th width="5%">Brand</th> -->
	      <th width="5%">Ordered Qty</th>
	      <th width="5%">Supplied Qty</th>
	      <th width="10%">Rejected Qty.</th>
	      <th width="10%">Accepted Qty.</th>	      
	      <th width="10%">Required Qty</th>	      
	      <th width="15%">Unit Rate</th>	      
		   <th width="13%">Item Value</th>
		   
		 	
	   
	      
    	</tr>
    	<tbody id="tblListOfPO">
    	   <% int inc=1; %>
<tr id="<%out.print(inc); %>">
      
				<td><input size="2" type="checkbox" class="small_chk" id="chk" value="<%out.print(inc); %>" /></td>
				
	  
     
      <td>
      <input type="text" name="itemCode" tabindex="1" id="itemCode<%out.print(inc); %>" onblur="autocompleteBasedOnPvms(this.value,'<%=inc %>');" validate="PVMS No,String,no" size="12"/>
      <input type="hidden" name="ItemId<%out.print(inc); %>" tabindex="1" id="ItemId<%out.print(inc); %>" />
      </td>
      
		<td> 	<input type="text" value=""	id="nameItem<%=inc %>" validate='Nomenclature ,String,yes' onblur="checkForPurchase(this.value, 'nameItem','<%=inc %>');"  name="nameItem<%=inc %>" tabindex="1" size="60" />
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
      <td> <input  size="20" type="text" value="" onkeypress ="return isNumber(event);"   id="txtRequiredQty<%out.print(inc); %>" name="txtRequiredQty<%out.print(inc); %>"  validate="Required Qty,string,yes"/>
      
      <td> <input  size="20" type="text" value="" onkeypress ="return isNumber(event);"   id="txtEstimatedValue<%out.print(inc); %>" name="txtEstimatedValue<%out.print(inc); %>"  validate="Estimated Value,string,yes"/></td>
       <td> <input  size="20" type="text" value="" onkeypress ="return isNumber(event);"   id="txtCurrencyCode<%out.print(inc); %>" name="txtCurrencyCode<%out.print(inc); %>"  readonly /></td>
        <td> <input  size="20" type="text" value="" onkeypress ="return isNumber(event);"   id="txtStockQty<%out.print(inc); %>" name="txtStockQty<%out.print(inc); %>"  readonly /></td>
         <td> <input  size="20" type="text" value="" onkeypress ="return isNumber(event);"   id="txtMonthlyConsp<%out.print(inc); %>" name="txtMonthlyConsp<%out.print(inc); %>"  readonly /></td>
         <td> <input  size="20" type="text" value="" onkeypress ="return isNumber(event);"   id="txtMonthlyConsp<%out.print(inc); %>" name="txtMonthlyConsp<%out.print(inc); %>"  readonly /></td>
         <td> <input  size="20" type="text" value="" onkeypress ="return isNumber(event);"   id="txtMonthlyConsp<%out.print(inc); %>" name="txtMonthlyConsp<%out.print(inc); %>"  readonly /></td>
         <td> <input  size="20" type="text" value="" onkeypress ="return isNumber(event);"   id="txtMonthlyConsp<%out.print(inc); %>" name="txtMonthlyConsp<%out.print(inc); %>"  readonly /></td>
          <td> <input  size="20" type="text" value="" onkeypress ="return isNumber(event);"   id="txtMonthlyConsp<%out.print(inc); %>" name="txtMonthlyConsp<%out.print(inc); %>"  readonly /></td>
          <td> <input  size="20" type="text" value="" onkeypress ="return isNumber(event);"   id="txtMonthlyConsp<%out.print(inc); %>" name="txtMonthlyConsp<%out.print(inc); %>"  readonly /></td>
          <td> <input  size="20" type="text" value="" onkeypress ="return isNumber(event);"   id="txtMonthlyConsp<%out.print(inc); %>" name="txtMonthlyConsp<%out.print(inc); %>"  readonly /></td>
       
		  
   
       </tr>
				</tbody>
    
   <%
     	 }   %>
     	 
	
</table>
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
	
	
	<!-- <input type="button" name="Save"  class="button" value="Partially Receive" onclick="saveRREntry('challanEntry','stores?method=submitRREntry');"/> -->
	<input type="button" name="Submit"  class="button" value="Submit" onclick="submitIndentForSupplier('SupplierIndent','stores?method=submitIndentForSupplier');"/>
	
	
    <!-- <input type="button" name="sss" class="button" value="SEARCH" onclick="getSearchBlock();" /> -->
    
    <input type="hidden" class="button" value="Delete"/>
    
    <input type="hidden" class="buttonBig" value="Export To CRV"/>
	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>
	<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
		<script type="text/javascript">
		
		var nPageNo = 1;
		
		
		function saveRREntry(formName,url)
		{
			
			getPOId();
			
			$j("#txtRequestType").val("SAVE");			
			var tempVal= $j("#tableRowId").val();
			if(checkValidationforSelectedRecords())
				{
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
		
			
			
		}
		
		function checkValidationforSelectedRecords()
		{
			var bflag = true;
			var arr = new Array();
			var tableRowId = $j("#tableRowId").val();
			
			arr = tableRowId.split(",");
			
			for(var i=0;i<arr.length;i++)
				{
				
					if($j("#txtRequiredQty"+arr[i]).val()=="" || $j("#txtItemValue"+arr[i]).val()=="")
					{
						alert("Please fill the values for Indent/Required Qty and Item Value");
						bflag= false;
					}
				}
			return bflag;
		}
		
		function submitIndentForSupplier(formName,url)
		{
			
			$j("#txtRequestType").val("SUBMIT");
			getPOId();
			//checkValidationforSelectedRecords();
			
			var tempVal= $j("#tableRowId").val();
			if(checkValidationforSelectedRecords())
			{
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
			
		}
		
			
	function getPOId()
	{		
		 var valCheckBox = new Array();
			$j('[id="chk"]:checked').each(function(j)
					{
						
						valCheckBox[j] = $j(this).val();
					});
			$j("#tableRowId").val(valCheckBox);
			/* if(valCheckBox.length>0)
			checkValidationforSelectedRecords(); */
	}
		
		function getPOList()
		{
			if($j("#ddlRequestYear").val() == 0)
			{
				alert("Please select the Year");
				return;
			}
			var yearId=$j("#ddlRequestYear").val();
			if(yearId !=0)
				{
					submitProtoAjaxWithDivName('SupplierIndent','/hms/hms/stores?method=getPOListbasedonYear&yearId='+yearId,'divPOList');
				}
			
		}
		
		function checkYear()
		{
			if($j("#ddlRequestYear").val() == 0)
			{
				alert("Please select the Year");
				return;
			}
		}
		
		function getPODetails()
		{
			$j("#tblListOfPO").html("");
			$j("#supplier").val("");
			$j("#supplierId").val("");
			$j("#poDate").val("");
			$j("#deliveryDate").val("");
			var poNo=$j("#poNo").val();
			if(poNo !=0)
				{
					var data = "poNo=" + poNo;
					var url = "stores?method=getPODetailsforIndentForm";
					var bClickable = false;
					GetJsonData('tblListOfPO', data, url, bClickable);
				}
		
		}
		
		function makeTable(jsonData) {
			//alert(jsonData);
		
			 var htmlTable = "";
			for (i = 0; i < jsonData.length; i++) {
				
				$j("#supplier").val(jsonData[i].VendorName);
				$j("#stockist").val(jsonData[i].Stockist);
				$j("#supplierId").val(jsonData[i].VendorId);
				$j("#poDate").val(jsonData[i].PODate);
				$j("#deliveryDate").val(jsonData[i].DeliveryDate);
	
				htmlTable = htmlTable + "<tr id='"+jsonData[i].Id+"' >";
				htmlTable = htmlTable+ "<td><input type='checkbox' name='chk"+i+"' id='chk'  onclick='getPOId();' style='margin-right:0px;' value='"	+ jsonData[i].Id + "'/></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"15\" class='medium3' id='txtMatCode"+i+"' name='txtMatCode"+i+"'   readonly value='"+ jsonData[i].MatCode+"' /></td>"; 
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"60\" class='medium3' id='txtItem"+jsonData[i].Id+"' name='txtItem"+jsonData[i].Id+"'   readonly value='"+ jsonData[i].Item+"' /><input  type=\"hidden\"   id='txtItemId"+jsonData[i].Id+"' name='txtItemId"+jsonData[i].Id+"'   readonly value='"+ jsonData[i].ItemId+"' /></td>";
				/* htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"20\" class='medium3' id='txtAU"+i+"' name='txtAU"+i+"'   readonly value="+ jsonData[i].AU+" /></td>";				
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"30\" class='medium3' id='txtManufacturer"+jsonData[i].Id+"' name='txtManufacturer"+jsonData[i].Id+"' value='"+ jsonData[i].ManName+"'  /></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"30\" class='medium3' id='txtBrand"+jsonData[i].Id+"' name='txtBrand"+jsonData[i].Id+"' value='"+ jsonData[i].BrandName+"'  /></td>";
				 */
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"20\" class='medium3' id='txtOrderedQty"+jsonData[i].Id+"' name='txtOrderedQty"+jsonData[i].Id+"'   readonly value='"+ jsonData[i].OrderedQty+"' /></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"20\" class='medium3' id='txtSuppliedQty"+jsonData[i].Id+"' name='txtReceivedQty"+jsonData[i].Id+"'  readonly onblur ='calculateQty("+jsonData[i].Id+"); calculateAmount("+jsonData[i].Id+");' onkeypress =\"return isNumber(event);\" value='"+ jsonData[i].SuppliedQty+"' /></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"20\" class='medium3' id='txtRejectedQty"+jsonData[i].Id+"' name='txtRejectedQty"+jsonData[i].Id+"'  readonly onblur ='calculateQty("+jsonData[i].Id+"); calculateAmount("+jsonData[i].Id+");' onkeypress =\"return isNumber(event);\"  value='"+ jsonData[i].RejectedQty+"' /></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"20\" class='medium3' id='txtAcceptedQty"+jsonData[i].Id+"' name='txtAcceptedQty"+jsonData[i].Id+"'  readonly onblur ='calculateAmount("+jsonData[i].Id+")' onkeypress =\"return isNumber(event);\"  value='"+ jsonData[i].AcceptedQty+"' /></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"20\" class='medium3' id='txtRequiredQty"+jsonData[i].Id+"' name='txtRequiredQty"+jsonData[i].Id+"'  onblur ='calculateQty("+jsonData[i].Id+"); calculateAmount("+jsonData[i].Id+")' onkeypress =\"return isNumber(event);\"  /></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"20\" class='medium3' id='txtUnitRate"+jsonData[i].Id+"' name='txtUnitRate"+jsonData[i].Id+"'   value="+ jsonData[i].UnitRate+" readonly  /></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"20\" class='medium3' id='txtItemValue"+jsonData[i].Id+"' name='txtItemValue"+jsonData[i].Id+"'   readonly  /></td>";
				
				
				
				htmlTable = htmlTable + "</tr>"; 
				//alert(htmlTable);
				
				$j("#tblListOfPO").html(htmlTable);
				
			}
		}
		
		function calculateAmount(inc){
		
			var quantity = 0;
			var unitRate = 0;
			var amount = 0;
			if (!isNaN(document.getElementById('txtRequiredQty'+inc).value))
			quantity = parseFloat(document.getElementById('txtRequiredQty'+inc).value);
			
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
		
		
		function calculateQty(inc)
		{
			if (!isNaN(document.getElementById('txtOrderedQty'+inc).value))
				{
					var OrderedQty = document.getElementById('txtOrderedQty'+inc).value
					OrderedQty =OrderedQty *1;
					/* var ReceivedQty = document.getElementById('txtReceivedQty'+inc).value
					ReceivedQty =ReceivedQty *1; */
					var RejectedQty = document.getElementById('txtRejectedQty'+inc).value
					RejectedQty= RejectedQty *1;
					
					var SuppliedQty = document.getElementById('txtSuppliedQty'+inc).value
					SuppliedQty =SuppliedQty *1;
					
					var RequiredQty = document.getElementById('txtRequiredQty'+inc).value
					RequiredQty= RequiredQty *1;
					
					if((RequiredQty+SuppliedQty)>OrderedQty)
						{
							alert("The sum of Required Qty and SuppliedQty can not be greater than Ordered Qty");
							document.getElementById('txtRequiredQty'+inc).value="";
							document.getElementById('txtItemValue'+inc).value="";
							return;
						}
					
					/* if(RejectedQty>OrderedQty || RejectedQty>ReceivedQty)
					{
						alert("Rejected Qty can not be greater.");
						document.getElementById('txtRejectedQty'+inc).value="";
						calculateAmount(inc);
						return;
					}
					
					var AcceptedQty = ReceivedQty-RejectedQty;
					document.getElementById('txtAcceptedQty'+inc).value=AcceptedQty; */
					
				}
		}
		
		jQuery(document).ready(function(){
			jQuery(".MasterData").blur(function(){
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
		});
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
		 