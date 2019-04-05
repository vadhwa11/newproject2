<%@page import="jkt.hms.masters.business.MasDepartment"%>
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
	    
	  
	  if(pvms !="")
	  {
		 
			  ajaxFunctionForAutoCompleteInLPOGeneral('purchaseGrid','stores?method=fillItemsForLpo&pvmsNo=' +  pvms , inc);
				//ajaxFunctionForAutoCompleteForPurchase('purchaseGrid','stores?method=fillItemsCommon&pvmsNo=' +  pvms , inc);
			   	
			}
	  else{
			document.getElementById('nameItem'+inc).value="";
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
	
	List<MasDepartment> deptList = new ArrayList<MasDepartment>();
	
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	

	if (map.get("deptList") != null) {
		deptList = (List<MasDepartment>)map.get("deptList");
	}
	
	
	
	
	int userId = 0;
	if(session.getAttribute("userId") != null){
		userId = (Integer)session.getAttribute("userId");
	}
	
	int empId = 0;
	if(session.getAttribute("empId") != null){
		empId = (Integer)session.getAttribute("empId");
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
<h2>Rate Contract Request</h2>
</div>

<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>

<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js"></script>

<script language="javascript">


var $j = jQuery.noConflict();
</script>
<form name="MR" method="post">
<div id="testDiv" size="height:500px;">
	
	

<div class="Block">

<!-- <label> MR Number </label>
<input  type="text" name="mrNo" id="mrNo" placeholder="System Generated" />
 -->

<label> RC Date <span>*</span></label>
<input  type="text" class="input_date"  id="mrDate" name="mrDate" placeholder="DD/MM/YYYY" validate="MR Date,string,yes" value="<%out.print(newdate); %>" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'mprDate');" maxlength="10"/>
	

<%-- 	<label> To Department  <span>*</span></label>
	<select	class="" name="mrdepartmentId" id="mrdepartmentId" validate="Department Name,String,yes" tabindex=1>
		<option value="">Select</option>
<%
	for (MasDepartment list :deptList ) 
	{
		
		%>		
		<option value=<%=list.getId()%> selected="selected" readonly><%=list.getDepartmentName()%></option>
		<%   
	}
%>

</select>  --%>
		<div class="clear"></div>
		
</div>  
	
	
 
	

	<div class="clear"></div>
	</div>
	<div class="clear paddingTop15"></div>
		<input type="hidden" size="2"	value="0"  name="noOfRows" id="noOfRows" />
		<input type="HIDDEN" name="<%=PO_ID %>" value="<%=poId %>" id="poId" />
		<input type="hidden" name="CHANGED_BY" value="<%=userId%>" />
		<input type="hidden" name="empId" value="<%=empId%>" />

	<input class="buttonAdd" type="button" tabindex="1" onclick="addRow('MRGrid');" value="">
	<input class="buttonDel" type="button" tabindex="1" onclick="removeRow('MRGrid');" value="">
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
	      <th width="15%">Available Stock</th>
	      <th width="13%">Stock in <br/>Ward Pharmacy</th>
	      <th width="13%">Stock in CD</th>
	      <th width="13%">Stock in Stores</th>	 
	      <th width="13%">From</th>	     
		   <th width="13%">Reason for RC</th>
		 	
	   
	      
    	</tr>
    <% int inc=1; %>
 
 
  
   <tr id="<%out.print(inc); %>">
      
				<td><input size="2" type="checkbox" class="small_chk" id="chk" value="<%out.print(inc); %>" /></td>
				<td><input size="2" type="text" value="<%out.print(inc); %>" readonly /></td>
	  
     
      <td>
      <input type="text" name="itemCode" tabindex="1" id="itemCode<%out.print(inc); %>" onblur="autocompleteBasedOnPvms(this.value,'<%=inc %>');" validate="PVMS No,String,no" size="12"/>
      <input type="hidden" name="ItemId<%out.print(inc); %>" tabindex="1" id="ItemId<%out.print(inc); %>" />
      </td>
      
		<td> 	<input type="text" value=""	id="nameItem<%=inc %>" validate='Nomenclature ,String,yes' onblur="checkForPurchase(this.value, 'nameItem','<%=inc %>');" name="nameItem<%=inc %>" tabindex="1" size="50" />
		<div id="ac2update" style="display:none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
//		if(!validateMetaCharacters(this.value))
//		{
	    new Ajax.Autocompleter('nameItem<%=inc %>','ac2update','purchaseOrder?method=getItemListForPurchaseOrderForRC',{parameters:'requiredField=nameItem<%=inc %>&poId='+document.getElementById('poId').value })
	    
	//	}
		</script>
		</td> 
      <td>
      <input type="text" value="" class="smcaption" readonly="readonly" name="AV<%out.print(inc); %>" id="idAu<%out.print(inc); %>" tabindex="1" validate="A/U ,String,no" size="8"/>
      </td>
      <td> <input  size="15" length="10" type="text" value="" onChange ="if(isNumber(event)){checkRC(<%out.print(inc); %>)}"   id="txtRequiredQty<%out.print(inc); %>" name="txtRequiredQty<%out.print(inc); %>"  validate="Required Qty,string,yes" />
      <td> <input  size="15" type="text" value=""   id="txtAvailableStock<%out.print(inc); %>" name="txtAvailableStock<%out.print(inc); %>"  />
      
      <td> <input  size="15" type="text" value=""    id="txtWPStock<%out.print(inc); %>" name="txtWPStock<%out.print(inc); %>"   readonly /></td>
       <td> <input  size="15" type="text" value=""  id="txtCDStock<%out.print(inc); %>" name="txtCDStock<%out.print(inc); %>"  readonly /></td>
        <td> <input  size="15" type="text" value=""    id="txtStoresStock<%out.print(inc); %>" id="txtStoresStock<%out.print(inc); %>" readonly/></td>
        <td> <textarea size ="20" class="large"  id="from<%out.print(inc); %>" class="medium3"  name="from<%out.print(inc); %>"  validate="From,string,no" value=""   tabindex=1 style="width: 250px; height: 50px;" ></textarea></td>
          <td> <textarea size ="20" class="large"  id="txtRemarks<%out.print(inc); %>" class="medium3"  name="txtRemarks<%out.print(inc); %>"  validate="Remarks,string,no" value=""   tabindex=1 style="width: 250px; height: 50px;" ></textarea></td>
          
       
		  
   
       </tr>
   
     	 
	
</table>
</div>
<div class="clear"></div>	
	

<input type="hidden" id="tableRowId" name="tableRowId" />
	<input type="hidden" id="txtRequestType" name="txtRequestType" />
</form>


<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>	
	
	<input type="button" name="Save"  class="button" value="Save" onclick="saveMR('MR','stores?method=saveRC');"/>
	<input type="button" name="Submit"  class="button" value="Submit" onclick="submitMR('MR','stores?method=saveRC');"/>
		
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
			  tableHtml= tableHtml +("<td><input size='2' type=\"text\" value="+i+" readonly /></td><td><input type='text' name='itemCode"+i+"' id='itemCode"+i+"' validate='Mat Code,String,no' size='12'/><input type='hidden' name='ItemId"+i+"'  id='ItemId"+i+"' value=''/></td>");
			  tableHtml= tableHtml +("<td><input type='text' id='nameItem"+i+"' name='nameItem"+i+"' validate='Nomenclature ,String,yes' onblur=\"checkForPurchase(this.value, 'nameItem','"+i+"');\"   size='50' /><div id='ac2update' style='display:none;' class='autocomplete'></div></td>");
			  tableHtml= tableHtml +("<td><input type='text' value='' class='smcaption' readonly='readonly' name='AV"+i+"' id='idAu"+i+"' validate='AU ,String,no' size='8'/></td>");
			  tableHtml= tableHtml +("<td> <input  type=\"text\" length=\"10\" size=\"15\" class='medium3' id='txtRequiredQty"+i+"' name='txtRequiredQty"+i+"'  validate=\"Required Qty,TwoDigitAfterDecimal,yes\"  maxlength='10' onChange=\"if(isNumber(event)){checkRC("+i+")}\" /></td>");
			  
			  tableHtml= tableHtml +("<td> <input  type=\"text\"  size=\"15\" class='medium3' id='txtAvailableStock"+i+"' name='txtAvailableStock"+i+"'  readonly  /></td>");
			  tableHtml= tableHtml +("<td> <input  type=\"text\"  size=\"15\" class='medium3' id='txtWPStock"+i+"' name='txtWPStock"+i+"'  readonly  /></td>");
			  tableHtml= tableHtml +("<td> <input  type=\"text\"  size=\"15\" class='medium3' id='txtCDStock"+i+"' name='txtCDStock"+i+"'  readonly  /></td>");
			  tableHtml= tableHtml +("<td> <input  type=\"text\"  size=\"15\" class='medium3' id='txtStoresStock"+i+"' name='txtStoresStock"+i+"'  readonly  /></td>");
			  tableHtml= tableHtml +("<td size='25'> <textarea class=\"large\" id='from"+i+"' name='from"+i+"' validate=\"From,string,no\" value=\"\" tabindex=1 style=\"width: 250px; height: 50px;\" ></textarea></td>");
			  tableHtml= tableHtml +("<td size='25'> <textarea class=\"large\" id='txtRemarks"+i+"' name='txtRemarks"+i+"' validate=\"Remarks,string,no\" value=\"\" tabindex=1 style=\"width: 250px; height: 50px;\" ></textarea></td>");
			  tableHtml= tableHtml +("</tr>");
			  $j("#"+tableId).append(tableHtml);
			  
			 	
				 new Ajax.Autocompleter('nameItem'+i,'ac2update','purchaseOrder?method=getItemListForPurchaseOrderForRC',{parameters:'requiredField=nameItem'+i+'&poId='+document.getElementById('poId').value }) 
				
			
			  var valRowId = new Array();
				$j("#"+tableId+" tr[id!='th']").each(function(j)
						{				
							valRowId[j] =$j(this).attr("id");
						});
				
				
				$j("#tableRowId").val(valRowId);
			 
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
			        
		        	document.getElementById('txtAvailableStock'+rowVal).value = stockA.childNodes[0].nodeValue
		        	document.getElementById('txtWPStock'+rowVal).value = stockW.childNodes[0].nodeValue
		        	document.getElementById('txtCDStock'+rowVal).value = stockC.childNodes[0].nodeValue
		        	document.getElementById('txtStoresStock'+rowVal).value = stockS.childNodes[0].nodeValue
		        	
		        	
		      }
		    }
		  }
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
					// alert("Stock is available");
					 //document.getElementById('txtRequiredQty'+rowVal).value = "";
					 }
				
				 }
			 	
		}
		
		 </script>