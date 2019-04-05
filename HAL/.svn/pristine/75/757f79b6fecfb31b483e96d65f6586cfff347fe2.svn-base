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
<h2>Receiving Report Entry</h2>
</div>

<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>

<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>

<script language="javascript">


var $j = jQuery.noConflict();
</script>
<form name="challanEntry" method="post">

<div class="Block">
<div class="clear"></div>

<!-- 

	<label>Enquiry No</label>
	
	<input	type="text" name="EnquiryNo" value="System generated"  validate="Enquiry Name ,String,yes" tabindex=1  id="EnquiryNo"/> -->
	
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
<div id="divIndentList"></div>

	<div class="clear" style="height:5px;"></div>
	
	

	<label> Vendor Name </label>
	<input	name="supplier" id="supplier" validate="Supplier Name,String,yes" tabindex=1>	
	<input	type="hidden" name="supplierId" id="supplierId" >	

<label> PO Date</label>
<input  type="text"   id="poDate" name="poDate"   onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'mprDate');"  readonly/>

	
<label> Delivery Date</label>
<input  type="text"   id="deliveryDate" name="deliveryDate"   onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'mprDate');"  readonly/>
		
<div class="clear" style="height:5px;"></div>
<label> Invoice  Date <span>*</span></label>
<input  type="text" class="input_date"  id="todate-pick" name="invoiceDate" placeholder="DD/MM/YYYY" validate="Invoice Date,string,yes" value="<%out.print(newdate); %>" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'mprDate');" maxlength="10" style="width: 127px"/>


<label>Invoice No</label>
<input  size="20" type="text" value=""   id="invoiceNo" name="invoiceNo"  validate="Invoice No,string,yes" /></td>

<label>Invoice Amount</label>
<input  size="20" type="text" value="" onkeypress ="return isNumber(event);"   id="invoiceAmount" name="invoiceAmount"  maxlength="10" validate="Invoice Amt,string,yes"  /></td>



<div class="clear" style="height:5px;"></div>

<label> RR  Date <span>*</span></label>
<input  type="text" class="input_date"  id="todate-pick" name="challanDate" placeholder="DD/MM/YYYY" validate="Due Date,string,yes" value="<%out.print(newdate); %>" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'mprDate');" maxlength="10" style="width: 127px"/>





<!-- <label> Received Partially</label>
<input id="partiallyReceive" type="checkbox" maxlength="30" value="y" name="partiallyReceive"> -->

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
	      <th width="5%">A/U</th>
	      <th width="5%">Manufacturer</th>
	      <th width="5%">Brand</th>
	      <th width="5%">Batch No</th>
	      <th width="5%">Manufacturer Date</th>
	      <th width="5%">&nbsp;&nbsp;&nbsp;Expiry  Date&nbsp;&nbsp;&nbsp;</th>
	      <th width="10%">Total PO Qty.</th>
	      <th width="10%">Ordered/Advised Qty.</th>
	      <th width="10%">Received Qty.</th>
	      <th width="10%">Short</th>
	      <th width="10%">Over</th>
	      
	      <th width="10%">Accepted Qty.</th>
	      <th width="15%">Unit Rate</th>	      
		   <th width="13%">Item Value</th>
		   <th width="13%">Chemical Composition</th>
		   <th width="13%">Remarks for Shortage/Surplus</th>
		   
		 	
	   
	      
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
	
	
	<input type="button" name="Save"  class="button" value="Partially Receive" onclick="saveRREntry('challanEntry','stores?method=submitRREntry');"/>
	<input type="button" name="Submit"  class="button" value="Fully Receive" onclick="submitRREntry('challanEntry','stores?method=submitRREntry');"/>
	
	
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
		//	alert(tableRowId);
			
			arr = tableRowId.split(",");
			
			for(var i=0;i<arr.length;i++)
				{
				
					if($j("#txtBatchNo"+arr[i]).val()=="" || $j("#txtManDate"+arr[i]).val()=="" || $j("#txtExpiryDate"+arr[i]).val()=="" || $j("#txtReceivedQty"+arr[i]).val()=="" || $j("#txtAcceptedQty"+arr[i]).val()=="")
					{
						alert("Please fill the values for Batch No, Manufacturer date, Expiry Date, Received Qty, Accepted Qty");
						bflag= false;
					}
				}
			return bflag;
		}
		
		function submitRREntry(formName,url)
		{
			if(!confirm("Are you sure that you have received complete supply order if no then Please save the data for 'Partially Received' "))
				{
					return;
				}
			$j("#txtRequestType").val("SUBMIT");
			getPOId();
			checkValidationforSelectedRecords();
			
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
					submitProtoAjaxWithDivName('challanEntry','/hms/hms/stores?method=getPOListbasedonYear&yearId='+yearId,'divPOList');
				}
			
		}
		
		
		function getSupplierIndentList()
		{
			
			var poNo=$j("#poNo").val();
			if(poNo !=0)
				{
					submitProtoAjaxWithDivName('challanEntry','/hms/hms/stores?method=getSupplierIndentListbasedonPO&poNo='+poNo,'divIndentList');
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
		
		function getPODetails(flag)
		{			
			$j("#tblListOfPO").html("");
			$j("#supplier").val("");
			$j("#supplierId").val("");
			$j("#poDate").val("");
			$j("#deliveryDate").val("");
			var poNo=$j("#poNo").val();
			var indentNo=$j("#indentNo").val();
			if(poNo !=0 && flag=='P')
				{
					var data = "poNo=" + poNo;
					var url = "stores?method=getPODetailsforChallanEntry";
					var bClickable = false;
					GetJsonData('tblListOfPO', data, url, bClickable);
				}
			if(indentNo !=0 && flag=='I')
			{
				var data = "indentNo=" + indentNo
				var url = "stores?method=getIndentDetailsforChallanEntry";
				var bClickable = false;
				GetJsonData('tblListOfPO', data, url, bClickable);
			}
		
		}
		
		function makeTable(jsonData) {
			//alert(jsonData);
		
			 var htmlTable = "";
			for (i = 0; i < jsonData.length; i++) {
				
				$j("#supplier").val(jsonData[i].VendorName);
				$j("#supplierId").val(jsonData[i].VendorId);
				$j("#poDate").val(jsonData[i].PODate);
				$j("#deliveryDate").val(jsonData[i].DeliveryDate);
	
				htmlTable = htmlTable + "<tr id='"+jsonData[i].Id+"' >";
				htmlTable = htmlTable+ "<td><input type='checkbox' name='chk"+i+"' id='chk'  onclick='getPOId();' style='margin-right:0px;' value='"	+ jsonData[i].Id + "'/></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"15\" class='medium3' id='txtMatCode"+jsonData[i].Id+"' name='txtMatCode"+jsonData[i].Id+"'   readonly value='"+ jsonData[i].MatCode+"' /></td>"; 
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"60\" class='medium3' id='txtItem"+jsonData[i].Id+"' name='txtItem"+jsonData[i].Id+"'   readonly value='"+ jsonData[i].Item+"' /><input  type=\"hidden\"   id='txtPOId"+jsonData[i].Id+"' name='txtPOId"+jsonData[i].Id+"'   readonly value='"+jsonData[i].Id+"' /><input  type=\"hidden\"   id='txtItemId"+jsonData[i].Id+"' name='txtItemId"+jsonData[i].Id+"'   readonly value='"+ jsonData[i].ItemId+"' /></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"20\" class='medium3' id='txtAU"+jsonData[i].Id+"' name='txtAU"+jsonData[i].Id+"'   readonly value="+ jsonData[i].AU+" /></td>";				
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"30\" class='medium3' id='txtManufacturer"+jsonData[i].Id+"' name='txtManufacturer"+jsonData[i].Id+"' value='"+ jsonData[i].ManName+"'  /></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"30\" class='medium3' id='txtBrand"+jsonData[i].Id+"' name='txtBrand"+jsonData[i].Id+"' value='"+ jsonData[i].BrandName+"'  /></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"30\" class='medium3' id='txtBatchNo"+jsonData[i].Id+"' name='txtBatchNo"+jsonData[i].Id+"'   /></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"10\" class='input_date' id='txtManDate"+jsonData[i].Id+"' name='txtManDate"+jsonData[i].Id+"'  placeholder=\"DD/MM/YYYY\" /></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"10\" class='input_date' id='txtExpiryDate"+jsonData[i].Id+"' name='txtExpiryDate"+jsonData[i].Id+"'   placeholder=\"DD/MM/YYYY\" /></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"20\" class='medium3' id='txtPOQty"+jsonData[i].Id+"' name='txtPOQty"+jsonData[i].Id+"'   readonly value="+ jsonData[i].POQty+" /></td>";
				if(jsonData[i].QtyReq == undefined)
					{
					 	htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"20\" class='medium3' id='txtOrderedQty"+jsonData[i].Id+"' name='txtOrderedQty"+jsonData[i].Id+"'  onkeypress =\"return isNumber(event);\" /></td>";
					}
				else
					{
						htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"20\" class='medium3' id='txtOrderedQty"+jsonData[i].Id+"' name='txtOrderedQty"+jsonData[i].Id+"'  value="+ jsonData[i].QtyReq+" onblur ='calculateQty("+jsonData[i].Id+")' onkeypress =\"return isNumber(event);\" /></td>";
					}
				
				
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"20\" class='medium3' id='txtReceivedQty"+jsonData[i].Id+"' name='txtReceivedQty"+jsonData[i].Id+"'  onblur ='calculateQty("+jsonData[i].Id+"); calculateAmount("+jsonData[i].Id+");' onkeypress =\"return isNumber(event);\" /></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"20\" class='medium3' id='txtShortageQty"+jsonData[i].Id+"' name='txtShortageQty"+jsonData[i].Id+"'  readonly onblur ='calculateQty("+jsonData[i].Id+"); calculateAmount("+jsonData[i].Id+");' onkeypress =\"return isNumber(event);\" value='0' /></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"20\" class='medium3' id='txtSurplusQty"+jsonData[i].Id+"' name='txtSurplusQty"+jsonData[i].Id+"'  readonly onblur ='calculateQty("+jsonData[i].Id+"); calculateAmount("+jsonData[i].Id+");' onkeypress =\"return isNumber(event);\" value='0' /></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"20\" class='medium3' id='txtAcceptedQty"+jsonData[i].Id+"' name='txtAcceptedQty"+jsonData[i].Id+"'  onblur ='calculateAmount("+jsonData[i].Id+")' onkeypress =\"return isNumber(event);\"  /></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"20\" class='medium3' id='txtUnitRate"+jsonData[i].Id+"' name='txtUnitRate"+jsonData[i].Id+"'   value="+ jsonData[i].UnitRate+" readonly  /></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"20\" class='medium3' id='txtItemValue"+jsonData[i].Id+"' name='txtItemValue"+jsonData[i].Id+"'   readonly  /></td>";
				htmlTable = htmlTable + "<td> <textarea size =\"20\" class=\"large\"  id=\"txtChemical\" class=\"medium3\"  name=\"txtChemical\"   tabindex=1 style=\"width: 250px; height: 50px;\" >"+jsonData[i].ChemicalComposition+"</textarea></td>";
				htmlTable = htmlTable + "<td> <textarea size =\"20\" class=\"large\"  id='txtRemarks"+jsonData[i].Id+"' class=\"medium3\"  name='txtRemarks"+jsonData[i].Id+"'   tabindex=1 style=\"width: 250px; height: 50px;\" ></textarea></td>";
				htmlTable = htmlTable + "<td><input name=\"Button\" type=\"button\" class=\"buttonAdd\"  onclick=\"generateRow("+jsonData[i].Id+");\" /></td>";
			
				
				
				htmlTable = htmlTable + "</tr>"; 
				//alert(htmlTable);
				
				$j("#tblListOfPO").html(htmlTable);
				
			}
		}
		
		function calculateAmount(inc){
		
			var quantity = 0;
			var unitRate = 0;
			var amount = 0;
			if (!isNaN(document.getElementById('txtAcceptedQty'+inc).value))
			quantity = parseFloat(document.getElementById('txtAcceptedQty'+inc).value);
			
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
		
		
		function calculateQty(inc)
		{
				document.getElementById('txtSurplusQty'+inc).value="";
				document.getElementById('txtShortageQty'+inc).value="";
			if (!isNaN(document.getElementById('txtOrderedQty'+inc).value))
				{
					var OrderedQty = document.getElementById('txtOrderedQty'+inc).value
					OrderedQty =OrderedQty *1;
					var ReceivedQty = document.getElementById('txtReceivedQty'+inc).value
					ReceivedQty =ReceivedQty *1;
					var RejectedQty = document.getElementById('txtAcceptedQty'+inc).value
					RejectedQty= RejectedQty *1;
					
					if(ReceivedQty>OrderedQty)
						{
							
							document.getElementById('txtSurplusQty'+inc).value=ReceivedQty-OrderedQty
							
						}
					if(ReceivedQty<OrderedQty)
					{
						
						document.getElementById('txtShortageQty'+inc).value=OrderedQty-ReceivedQty
						
					}
					
					/* if(RejectedQty>OrderedQty || RejectedQty>ReceivedQty)
					{
						alert("Rejected Qty can not be greater.");
						document.getElementById('txtRejectedQty'+inc).value="";
						calculateAmount(inc);
						return;
					} */
					
					
					document.getElementById('txtAcceptedQty'+inc).value=ReceivedQty;
					calculateAmount(inc);
					
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
			
			function generateRow(inc)
			{
				
				var j= $j("#tblListOfPO tr:last").attr("id");
				
				if(j == "th")
					{
						var i = 1;
					}
				else
					{
						j=j*1;
						var i = j+1;
					} 
				
				var htmlTable ="";
				htmlTable = htmlTable + "<tr id='"+i+"' >";
				htmlTable = htmlTable+ "<td><input type='checkbox' name='chk"+i+"' id='chk'  onclick='getPOId();' style='margin-right:0px;' value='"	+ i + "'/></td>";
				var MatCode= $j("#txtMatCode"+inc).val();
				var Nomen= $j("#txtItem"+inc).val();
				var ItemId= $j("#txtItemId"+inc).val();
				var txtAU= $j("#txtAU"+inc).val();
				var txtManufacturer= $j("#txtManufacturer"+inc).val();
				var txtBrand= $j("#txtBrand"+inc).val();
				var txtPOQty= $j("#txtPOQty"+inc).val();
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"15\" class='medium3' id='txtMatCode"+i+"' name='txtMatCode"+i+"'   readonly value='"+MatCode+"' /></td>"; 
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"60\" class='medium3' id='txtItem"+i+"' name='txtItem"+i+"' value='"+Nomen+"'  readonly value='' /><input  type=\"hidden\"   id='txtPOId"+i+"' name='txtPOId"+i+"'   readonly value='"+inc+"' /><input  type=\"hidden\"   id='txtItemId"+i+"' name='txtItemId"+i+"'   readonly value='"+ItemId+"' /></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"20\" class='medium3' id='txtAU"+i+"' name='txtAU"+i+"'   readonly value='"+txtAU+"' /></td>";				
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"30\" class='medium3' id='txtManufacturer"+i+"' name='txtManufacturer"+i+"' value='"+txtManufacturer+"'  /></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"30\" class='medium3' id='txtBrand"+i+"' name='txtBrand"+i+"' value='"+txtBrand+"'  /></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"30\" class='medium3' id='txtBatchNo"+i+"' name='txtBatchNo"+i+"'   /></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"10\" class='input_date' id='txtManDate"+i+"' name='txtManDate"+i+"'  placeholder=\"DD/MM/YYYY\" /></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"10\" class='input_date' id='txtExpiryDate"+i+"' name='txtExpiryDate"+i+"'   placeholder=\"DD/MM/YYYY\" /></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"20\" class='medium3' id='txtPOQty"+i+"' name='txtPOQty"+i+"'   readonly value="+txtPOQty+" /></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"20\" class='medium3' id='txtOrderedQty"+i+"' name='txtOrderedQty"+i+"'  onkeypress =\"return isNumber(event);\" /></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"20\" class='medium3' id='txtReceivedQty"+i+"' name='txtReceivedQty"+i+"'  onblur ='calculateQty("+i+"); calculateAmount("+i+");' onkeypress =\"return isNumber(event);\" /></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"20\" class='medium3' id='txtShortageQty"+i+"' name='txtShortageQty"+i+"'  readonly onblur ='calculateQty("+i+"); calculateAmount("+i+");' onkeypress =\"return isNumber(event);\" value='0' /></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"20\" class='medium3' id='txtSurplusQty"+i+"' name='txtSurplusQty"+i+"'  readonly onblur ='calculateQty("+i+"); calculateAmount("+i+");' onkeypress =\"return isNumber(event);\" value='0' /></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"20\" class='medium3' id='txtAcceptedQty"+i+"' name='txtAcceptedQty"+i+"'  onblur ='calculateAmount("+i+")' onkeypress =\"return isNumber(event);\"  /></td>";
				var unitRate = $j("#txtUnitRate"+inc).val();
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"20\" class='medium3' id='txtUnitRate"+i+"' name='txtUnitRate"+i+"'   value="+unitRate+" readonly  /></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"20\" class='medium3' id='txtItemValue"+i+"' name='txtItemValue"+i+"'   readonly  /></td>";
				htmlTable = htmlTable + "<td> <textarea size =\"20\" class=\"large\"  id=\"txt\" class=\"medium3\"  name=\"txt\"   tabindex=1 style=\"width: 250px; height: 50px;\" ></textarea></td>";
				htmlTable = htmlTable + "<td> <textarea size =\"20\" class=\"large\"  id='txtRemarks"+i+"' class=\"medium3\"  name='txtRemarks"+i+"'   tabindex=1 style=\"width: 250px; height: 50px;\" ></textarea></td>";
				htmlTable = htmlTable + "<td><input name=\"Button\" type=\"button\" class=\"buttonDel\"  onclick=\"deleteRow("+i+");\" /></td>";
						
				htmlTable = htmlTable + "</tr>"; 
				
				$j("#tblListOfPO").append(htmlTable);
			
			}
			
			function deleteRow(inc)
			{
				
				$j("#tblListOfPO tr[id='"+inc+"']").remove();			

				
			}
			

		 </script>
		 