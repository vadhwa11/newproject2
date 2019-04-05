<%@page import="jkt.hms.masters.business.RcHeader"%>
<%@page import="jkt.hms.masters.business.RcDetails"%>
<%@page import="jkt.hms.masters.business.MprPriority"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.util.Box"%>

<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentT"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>

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
        	if(id !="")
        		{
        		   GetStockDetails(rowVal);
        		}
        	
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




function showReport(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/purchaseOrder?method=printLocalPoFormatJsp";
  obj.submit();
}


function popwindow1(url)
{
newwindow=window.open(url,'name',"top=100,height=600,width=1000,status=1");
if (window.focus) 
 {
 newwindow.focus()
 }
newwindow.createPopup();
}

 

function getCurSOAmount(){
var vend = document.getElementById('VendorId').value;
var soDate = document.getElementById('soDate').value; 
if(vend != "" && soDate != ""){
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
      if(xmlHttp.readyState==4){
    
      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	   var existingtot =0;
	if(document.getElementById('total_amount'))
		existingtot = parseFloat(document.getElementById('total_amount').value);
	  	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var remain = items.childNodes[loop];
	   	    
	       var rem  = remain.getElementsByTagName("rem")[0];
       if(document.getElementById('remain'))
	      document.getElementById('remain').value = roundVal(existingtot + parseFloat(rem.childNodes[0].nodeValue),2);
	if( document.getElementById('totremain'))
		      document.getElementById('totremain').value = roundVal(rem.childNodes[0].nodeValue,2);
	   } 
      }
    }

    if(!validateMetaCharacters(this.value))
    {
   var url="/hms/hms/purchaseOrder?method=getCurVendorSoAmount&vendorId="+vend+"&soDate="+soDate
    }
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
}

}      




</script>


<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	String previousPage = "no";
	
	String max = "";
	BigDecimal netAmount = null;
	Box box = null;
	String DeliveryDate = null;
	String QuotationDate = null;
	

	List<RcDetails> rcDetails = new ArrayList<RcDetails>();
	List<RcHeader> rcHeader = new ArrayList<RcHeader>();					
	
	
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	
	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
	if(map.get("supplierList")!=null){
		supplierList = (List<MasStoreSupplier>)map.get("supplierList");
	}
	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	
	String pageTitle = "";
	
	
	
	 if(map.get("title") != null)
	 {
		 pageTitle =  (String)map.get("title");	  
		   
	  }	
	
		
	 if(map.get("rcDetails") != null)
	 {
		 rcDetails =  (List<RcDetails>)map.get("rcDetails");	  
		   
	  }	
	 if(map.get("rcHeader") != null)
	 {
		 rcHeader =  (List<RcHeader>)map.get("rcHeader");	  
		   
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
	 
	 int userId = 0;
		if(session.getAttribute("userId") != null){
			userId = (Integer)session.getAttribute("userId");
		}
	 
	 
	 if(map.get("message") != null)
	 {
		 message =  (String)map.get("message");	  
		   
	  }	
	 
	 
		
		int requestHeaderId= 0;
		String mrDate ="";
		int year = 0;
		int priority=0;
		int districtId =0;	
		String SpecialRemarks = "";
		String requestStatus = "NA";
		String ProjectName="";
		String requestNo="";
		String PreparedBy = "";
		String Status = "NA";
		String ApprovedBy = "";
		String ApprovalRemarks = "";
		int supplierId = 0;
	
		String ProposedName="";
		for(RcHeader header: rcHeader)
		{
			requestHeaderId = header.getId();
			if(header.getRcDate() != null)
			mrDate = HMSUtil.changeDateToddMMyyyy(header.getRcDate());
			
			requestNo = (header.getRcNo()!=null?header.getRcNo():"");
			supplierId = (Integer)(header.getSupplier()!=null?header.getSupplier().getId():0);
			requestStatus = (header.getStatus()!=null?header.getStatus():"NA");
					
			PreparedBy = (header.getLastChgBy() != null?header.getLastChgBy().getEmployee().getFirstName():"");			
			Status = (header.getStatus() != null?header.getStatus():"NA");
		}
	
%>




 <div class="titleBg">
<h2>View and Update-Rate Contract Request <%out.print(message); %></h2>
</div>

<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>

<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>

<script language="javascript">


var $j = jQuery.noConflict();
</script>
<form name="MR" method="post">
<div id="testDiv" size="height:500px;">

	
<br /><br />
<div class="Block">
<label>RC No. <span>*</span></label>
	
<input	type="text" name="mprNo" value="<%=requestNo%>" readonly="readonly" validate="Request No ,String,yes" tabindex=1  id="mprNo"/>


<label> RC Date <span>*</span></label>
<input  type="text" class="input_date"  id="mrDate" name="mrDate"  validate="Request Date,string,yes" value="<%out.print(mrDate); %>"  maxlength="10" readonly/>



<label>Created By</label>
<input	type="text" name="Prepared"  tabindex=1  id="Prepared" value="<% out.print(PreparedBy);%>" readonly/>
<%-- <label>Approved By</span></label>
<input	type="text" name="Prepared"  tabindex=1  id="Prepared" value="<% out.print(ApprovedBy);%>" readonly/>

<label>Approval/Rejection Remarks</span></label>
<input	type="text" name="Prepared"  tabindex=1  id="Prepared" value="<% out.print(ApprovalRemarks);%>" readonly/> --%>

<div class="clear"></div>
	 <label>Remarks</label><textarea  class="large" onkeyup="auto_grow(this)" validate="Remarks,string,no" maxlength="5000" name ="remarks" id ="remarks"  /><%=rcDetails.get(0).getHeader().getRemarks()!=null?rcDetails.get(0).getHeader().getRemarks():""%></textarea>
	
</div>  
	
	
 


	
	</div>
	<div class="clear paddingTop15"></div>
		<input type="hidden" size="2"	value="0"  name="noOfRows" id="noOfRows" />
		<input type="hidden" name="mrHeaderId" value="<%=requestHeaderId %>" id="mrHeaderId" />
		<input type="hidden" name="CHANGED_BY" value="<%=userId%>" />
		
		
	<%
	if(true)
	{
		%>
			<input class="buttonAdd" type="button" tabindex="1" onclick="addRow('MRGrid');" value="">
			<input class="buttonDel" type="button" tabindex="1"  onclick="removeRow_FromDatabaseRC('MRGrid','RcDetails','<%=requestHeaderId%>');" value=""><img id='imgRemoveDetails' src='/hms/jsp/images/saving.gif' style="display:none;" />
		<%
	}
	
	%>
	

	
<div class="clear"></div>
<div class="cmntable">
<table id="MRGrid">
		
		<tr id="th">
		
         
           <th>Delete</th>
	      <th width="2%">Sl No.</th>
	      <th width="5%">Mat Code</th>
	      <th width="20%">Nomenclature</th>
	      <th width="5%">A/U</th>
	      <th width="10%">Required Qty.</th>
	      <th width="10%">Recommended Qty.</th>
	      <th width="10%">Final Qty.</th>
	      <th width="10%">From</th>

		 	
	   
	      
    	</tr>
    
 	<%
 	int counter =1;
		for(RcDetails detailsList :rcDetails)
		{
			
			%>
 
  
        <tr id="<%out.print(detailsList.getId()); %>">
      
		<td><input size="2" type="checkbox" class="small_chk" id="chk" value="<%out.print(detailsList.getId()); %>" /></td>
		<td id="SRNO"><input size="2" type="text" value="<%out.print(counter); %>" readonly /></td>
	  
     
      <td>
      <input type="text" name="itemCode" tabindex="1" id="itemCode<%out.print(detailsList.getId()); %>" onblur="autocompleteBasedOnPvms(this.value,'<%=detailsList.getId() %>');" validate="PVMS No,String,no" size="12" value="<%=detailsList.getItem().getPvmsNo() %>" readonly/>
      <input type="hidden" name="ItemId<%out.print(detailsList.getId()); %>" tabindex="1" id="ItemId<%out.print(detailsList.getId()); %>" />																	
      </td>
      
		<td> 	<input type="text" id="nameItem<%=detailsList.getId() %>" validate='Nomenclature ,String,yes' onblur="checkForPurchase(this.value, 'nameItem','<%=detailsList.getId() %>');"  name="nameItem<%=detailsList.getId() %>" tabindex="1" size="40" value="<%=detailsList.getItem().getNomenclature() %>[<%=detailsList.getItem().getPvmsNo() %>]" readonly />
		<div id="ac2update" style="display:none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">

	    new Ajax.Autocompleter('nameItem<%=detailsList.getId() %>','ac2update','purchaseOrder?method=getItemListForPurchaseOrder',{parameters:'requiredField=nameItem<%=detailsList.getId() %>' })
	    checkForPurchase('<%=detailsList.getItem().getNomenclature() %>[<%=detailsList.getItem().getPvmsNo()%>]','a','<%=detailsList.getId()%>');
	
		</script>
		</td> 
      <td>
      <input type="text"  class="smcaption" readonly="readonly" name="AV<%out.print(detailsList.getId()); %>" id="idAu<%out.print(detailsList.getId()); %>" tabindex="1" validate="A/U ,String,no" size="8" value="<%=detailsList.getItem().getItemConversion().getItemUnitName()%>" readonly />
      </td>
      <td> <input  size="15" type="text" onchange ="if(isNumber(event)){}"   id="txtRequiredQty<%out.print(detailsList.getId()); %>" name="txtRequiredQty<%out.print(detailsList.getId()); %>"  validate="Required Qty,string,yes" value="<%out.print(detailsList.getRequestedQty()); %>" readOnly="readonly" /></td>
      <td> <input  size="15" type="text" onchange ="if(isNumber(event)){}"   id="txtRecomQty<%out.print(detailsList.getId()); %>" name="txtRecomQty<%out.print(detailsList.getId()); %>"  validate="Recommended Qty,string,yes" value="<%=detailsList.getRecomQty()!=null?detailsList.getRecomQty():detailsList.getRequestedQty()%>" /></td>
      <td> <input  size="15" type="text" onchange ="if(isNumber(event)){}"   id="txtFinalQty<%out.print(detailsList.getId()); %>" name="txtFinalQty<%out.print(detailsList.getId()); %>"  validate="Recommended Qty,string,yes" value="<%=detailsList.getFinalQty()!=null?detailsList.getFinalQty():detailsList.getRequestedQty()%>" /></td>
      <td> <textarea size ="20" class="large"  id="from<%out.print(detailsList.getId()); %>" class="small"  name="from<%out.print(detailsList.getId()); %>"  validate="From,string,no" value=""   tabindex=1 style="width: 250px; height: 50px;" readonly="readonly"><%out.print(detailsList.getFromDepartments()!=null?detailsList.getFromDepartments():""); %></textarea></td>
    
          
       
		  
   
       </tr>
       
       <%
       counter++;
		}
 	
 	%>
  
     	 
	
</table>
</div>
	
<input type="hidden" id="tableRowId" name="tableRowId" />
	<input type="hidden" id="txtRequestType" name="txtRequestType" />


<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
	<div class="Block">
	<label>Vendor<span>*</span></label>
<select id="supplierId" name="supplierId" tabindex="1"  validate="Vendor,string,yes"> 
<option value="0">Select</option>
<%for(MasStoreSupplier supplier: supplierList)
	{
	if(supplierId==supplier.getId().intValue())
	{
		%>
		<option value="<%=supplier.getId()%>" selected="selected"><%=supplier.getSupplierName().trim()%></option>
		<%
		
	}
	else
	{
	%>
	<option value="<%=supplier.getId()%>"><%=supplier.getSupplierName().trim()%></option>
	<%
	}}%>
</select>
</div>
	
	<div class="clear"></div>
	<%
	if(true)
	{
		%>
			<input type="button" name="Save"  class="button" value="Save" onclick="saveMR('MR','stores?method=rcListToVendorSubmitUntilReceive&requestHeaderId=<%out.print(requestHeaderId); %>&appId=A1523');"/> 
			<input type="button" name="Submit"  class="button" value="Submit" onclick="submitMR('MR','stores?method=rcListToVendorSubmitUntilReceive&requestHeaderId=<%out.print(requestHeaderId); %>&appId=A1523');"/>
		<%
	}
	
	%>
	<input type="button" name="add" id="addbutton" value="Print" class="button" onClick="submitForm('MR','/hms/hms/stores?method=printForRateContractJsp&id=<%=requestHeaderId %>');"  tabindex=1 />
	
	
	</form>
    
    
    
	</div>
    <input type="hidden" class="button" value="Delete"/>
    
    <input type="hidden" class="buttonBig" value="Export To CRV"/>
	<div class="clear"></div>
	<div class="division"></div>
		<script type="text/javascript">
		
		
		function addRow(tableId)
		{
			
			var j= $j("#"+tableId+" tr:last").attr("id");
			
			//var j1= $j("#"+tableId+" td[id='SRNO']").val();
			//alert(j1);
			
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
			  tableHtml= tableHtml +("<td><input size='2' type=\"text\" value="+i+" readonly /></td><td><input type='text' name='itemCode"+i+"' id='itemCode"+i+"' validate='Mat Code,String,no' size='12'/><input type='hidden' name='ItemId"+i+"'  id='ItemId"+i+"' value=''/></td>");
			  tableHtml= tableHtml +("<td><input type='text' id='nameItem"+i+"' name='nameItem"+i+"' validate='Nomenclature ,String,yes' onblur=\"checkForPurchase(this.value, 'nameItem','"+i+"');\"   size='50' /><div id='ac2update' style='display:none;' class='autocomplete'></div></td>");
			  tableHtml= tableHtml +("<td><input type='text' value='' class='smcaption' readonly='readonly' name='AV"+i+"' id='idAu"+i+"' validate='AU ,String,no' size='8'/></td>");
			  tableHtml= tableHtml +("<td> <input  type=\"text\"  size=\"15\" class='medium3' id='txtRequiredQty"+i+"' name='txtRequiredQty"+i+"'  validate=\"Required Qty,TwoDigitAfterDecimal,yes\"  maxlength='10' onChange=\"if(isNumber(event)){}\" /></td>");
			  tableHtml= tableHtml +("<td> <input  type=\"text\"  size=\"15\" class='medium3' id='txtRecomQty"+i+"' name='txtRecomQty"+i+"'  validate=\"Recommended Qty,TwoDigitAfterDecimal,yes\"  maxlength='10' onChange=\"if(isNumber(event)){}\" /></td>");
			  
			 
			 /*  tableHtml= tableHtml +("<td size='25'> <textarea class=\"large\" id='txtRemarks"+i+"' name='txtRemarks"+i+"' validate=\"Remarks,string,no\" value=\"\" tabindex=1 style=\"width: 250px; height: 50px;\" ></textarea></td>"); */
			  tableHtml= tableHtml +("</tr>");
			  $j("#"+tableId).append(tableHtml);
			  
			 	
				 new Ajax.Autocompleter('nameItem'+i,'ac2update','purchaseOrder?method=getItemListForPurchaseOrder',{parameters:'requiredField=nameItem'+i }) 
				
			
			  var valRowId = new Array();
				$j("#"+tableId+" tr[id!='th']").each(function(j)
						{				
							valRowId[j] =$j(this).attr("id");
						});
				
				
				$j("#tableRowId").val(valRowId);
			 
		}
	
			
		function checkRC(rowVal)
		{
		
			 var rcQty = 0;
			 
			 var qtyAvailable = parseInt(document.getElementById('txtAvailableStock'+rowVal).value);
			 var  wpStock = parseInt(document.getElementById('txtWPStock'+rowVal).value);
			 var cdStock = parseInt(document.getElementById('txtCDStock'+rowVal).value);
			 var qtyStock = parseInt(document.getElementById('txtStoresStock'+rowVal).value);
			 
			 
			
			 if(document.getElementById('txtRequiredQty'+rowVal)!=null && document.getElementById('txtRequiredQty'+rowVal).value.trim()!="")
				 {
				 rcQty = parseInt(document.getElementById('txtRequiredQty'+rowVal).value);
				 }
			 
			 var toatalStock = (wpStock+cdStock+qtyStock);
			 
			 
			 
			 if(rcQty != 0)
				 {
				 if(rcQty<=toatalStock)
					 {
					 //alert("Stock is available");
					 //document.getElementById('txtRequiredQty'+rowVal).value = "";
					 }
				
				 }
			 	
		}
	
		
		function saveMR(formName,url)
		{
			$j("#txtRequestType").val("SAVE");
			 var valRowId = new Array();
				$j("#MRGrid tr[id!='th']").each(function(j)
						{				
							valRowId[j] =$j(this).attr("id");
						});		
				
				$j("#tableRowId").val(valRowId);
						
				if(!checkDuplicateItemInGrid(valRowId,'nameItem', 'Nomenclature'))
				 {				
				 	return;
				 }			
				 submitForm(formName,url);
			
	}
		
		function submitMR(formName,url)
		{
			$j("#txtRequestType").val("SUBMIT");
			 var valRowId = new Array();
				$j("#MRGrid tr[id!='th']").each(function(j)
						{				
							valRowId[j] =$j(this).attr("id");
						});		
				
				$j("#tableRowId").val(valRowId);
						
				if(!checkDuplicateItemInGrid(valRowId,'nameItem', 'Nomenclature'))
				 {				
				 	return;
				 }			
				 submitForm(formName,url);
			
	}
		
		
		function GetStockDetails(inc)
		{
			
			var ItemId = $j("#ItemId"+inc).val();
			
			var url = "stores?method=getStockDetailsforMR&ItemId="+ItemId;
			
		   GetAjaxData('MR',url,inc)
			
		}
		
		function GetAjaxData(formName,action,rowVal) {
			
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
			   	    
			   		var stockA  = item.getElementsByTagName("stockA")[0];
			        var stockW  = item.getElementsByTagName("stockW")[0];
			        var stockC  = item.getElementsByTagName("stockC")[0];
			        var stockS  = item.getElementsByTagName("stockS")[0];
			    /*     
		        	document.getElementById('txtAvailableStock'+rowVal).value = stockA.childNodes[0].nodeValue
		        	document.getElementById('txtWPStock'+rowVal).value = stockW.childNodes[0].nodeValue
		        	document.getElementById('txtCDStock'+rowVal).value = stockC.childNodes[0].nodeValue
		        	document.getElementById('txtStoresStock'+rowVal).value = stockS.childNodes[0].nodeValue
		        	 */
		        	
		      }
		    }
		  }
		}
		
		
		
		 </script>