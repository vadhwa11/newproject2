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
	

	
	
	if(map.get("financialYearList") != null)
	 {
		 financialYearList =  (List<Object[]>)map.get("financialYearList");	  		 
		   
	  }
	
	if(map.get("supplierList") != null)
	 {
		supplierList =  (List<MasStoreSupplier>)map.get("supplierList");	  		 
		   
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
<h2>Request For Quotation</h2>
</div>

<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>

<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>

<script language="javascript">


var $j = jQuery.noConflict();
</script>
<form name="EnquiryforQuotation" method="post">

<div class="Block">
<div class="clear" style="padding-top:10px;"></div>

<!-- 

	<label>Enquiry No</label>
	
	<input	type="text" name="EnquiryNo" value="System generated"  validate="Enquiry Name ,String,yes" tabindex=1  id="EnquiryNo"/> -->
	
	<label>Year:</label>

<select name ="ddlRequestYear" id="ddlRequestYear" onchange="getMPRList()">
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


<label> Enquiry Date <span>*</span></label>
<input  type="text" class="calDate"  id="enquiryDate" name="enquiryDate" placeholder="DD/MM/YYYY" validate="Enquiry Date,string,yes" value="<%out.print(newdate); %>" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'mprDate');" maxlength="10" style="width: 120px"/>
	
<label> Due Date <span>*</span></label>
<input  type="text" class="calDate"  id="dueDate" name="dueDate" placeholder="DD/MM/YYYY" validate="Due Date,string,yes" value="<%out.print(newdate); %>" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'mprDate');" maxlength="10" style="width: 120px"/>
	

	<div class="clear"></div>
	
	<div id="divMPRList">
	<label> MPR No  <span>*</span></label>
	<select	class="" name="mprNo" id="mprNo" validate="MPR No,String,yes" tabindex=1 onclick="checkYear()">
		<option value="">Select MPR No</option>
</select>
</div>
<label>MPR Sources</label>
<textarea value="" name="mprSources" id="mprSources" validate="MPR Sources,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" style="width:480px; height:120px"/></textarea> 


	<div class="clear"></div>
			<!-- <label>Vendor Name<span>*</span></label> <input type="text"
				tabindex="1" value="" id="vname" name="vname" class="auto" size="53"
				onblur="fillVendorCombo(this.value);" />
			<div id="ac2update" style="display: none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('"vname"','ac2update','stores?method=getVendorList',{parameters:'requiredField="vname"'});
		   //document.getElementById('slide0').style.display="hide"
</script>
			<select name="supplier" multiple="6" size="5" tabindex="1"
				id="supplier" class="listBig" validate="Vendor Name,string,yes">
				<option value="0">Select</option>
				
				
				
			</select> <input type="button" class="buttonDel" value=""
				onclick="	(this,'supplier');" align="right" /> -->
				
				<label>Vendor Name<span>*</span></label> <input type="text"
				tabindex="1" value="" id="vname" name="vname" class="auto" size="53"
				onblur="fillVendorCombo(this.value);" />
			<div id="ac2update" style="display: none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('vname','ac2update','stores?method=getVendorList',{parameters:'requiredField=vname'});
		   //document.getElementById('slide0').style.display="hide"
</script>
			<select name="supplier" multiple="4" size="5" tabindex="1"
				id="supplier" class="listBig" validate="Vendor Name,sring,yes">
				<option value="0">Select</option>
				
			</select> <input type="button" class="buttonDel" value=""
				onclick="deleteVendor(this,'supplier');" align="right" />
		
				
				
<div class="clear" style="padding-top:10px;"></div>
<label>Delivery Instruction</label>
<textarea value="" id="deliveryInstruction" name="deliveryInstruction" validate="Remarks ,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" style="width:480px; height:60px"/></textarea> 

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
          <th width="5%">Select Item <input type="checkbox" onclick='checkAll(); getMPRId();' id="chkAll"/></th>	      
	      <th width="5%">Mat Code</th>
	      <th width="20%">Nomenclature</th>
	      <th width="5%">A/U</th>
	      <th width="10%">Qty Req.</th>
	      <!-- <th width="15%">Delivery Date</th> -->	      
		  <th width="13%">Remarks</th>  	      
    	</tr>
    	<tbody id="tblListOfMPR">

				</tbody>
    
   <%
     	 }   %>
     	 
	
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
	
	 <input type="button" name="Save"  class="button" value="Save" onclick="saveEnquiryforQuotation('EnquiryforQuotation','stores?method=saveEnquiryforQuotation');"/> 
	<input type="button" name="Submit"  class="button" value="Submit" onclick="submitEnquiryforQuotation('EnquiryforQuotation','stores?method=saveEnquiryforQuotation');"/>
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
		
		
		function saveEnquiryforQuotation(formName,url)
		{
			$j("#txtRequestType").val("SAVE");
			getMPRId();
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
		
		function submitEnquiryforQuotation(formName,url)
		{
			$j("#txtRequestType").val("SUBMIT");
			getMPRId();
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
		
			
	function getMPRId()
	{		
		 var valCheckBox = new Array();
			$j('[id="chk"]:checked').each(function(j)
					{
						
						valCheckBox[j] = $j(this).val();
					});
			$j("#tableRowId").val(valCheckBox);
		
	}
		
		function getMPRList()
		{
			var yearId=$j("#ddlRequestYear").val();
			if(yearId !=0)
				{
					submitProtoAjaxWithDivName('EnquiryforQuotation','/hms/hms/stores?method=getMPRListListbasedonYear&yearId='+yearId,'divMPRList');
				}
			
		}
		
		function getMPRDetails()
		{
			$j("#tblListOfMPR").html("");
			var mprNo=$j("#mprNo").val();
			if(mprNo !=0)
				{
					var data = "mprNo=" + mprNo;
					var url = "stores?method=getMPRDetailsforQuotation";
					var bClickable = false;
					GetJsonData('tblListOfMPR', data, url, bClickable);
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
		
		function makeTable(jsonData) {
			
		
		
			 var htmlTable = "";
			for (i = 0; i < jsonData.length; i++) {
				//alert(jsonData[i].MPRSources);
				var MPRSources = jsonData[i].MPRSources;
				MPRSources = MPRSources.split('^').join("\r");
				MPRSources = MPRSources.split('@').join("\n");
				MPRSources=MPRSources.trim();
				/* alert(MPRSources);
			
				alert(MPRSources.length);  */
				if(MPRSources.length>5)
					{
						$j("#mprSources").val(MPRSources);
					}
				
				
				
				
				
				var Delivery = jsonData[i].Delivery;	
				Delivery = Delivery.split('$').join("\r");
				Delivery = Delivery.split('^').join("\n");
				$j("#deliveryInstruction").val(Delivery);
				htmlTable = htmlTable + "<tr id='"+jsonData[i].Id+"' >";
				htmlTable = htmlTable+ "<td><input type='checkbox' name='chk' id='chk'  onclick='getMPRId();' style='margin-right:0px;' value='"	+ jsonData[i].Id + "'/></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"15\" class='medium3' id='txtCurrencyCode"+i+"' name='txtCurrencyCode"+i+"'   readonly value='"+ jsonData[i].MatCode+"' /></td>"; 
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"60\" class='medium3' id='txtCurrencyCode"+i+"' name='txtCurrencyCode"+i+"'   readonly value='"+ jsonData[i].Item+"' /></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"15\" class='medium3' id='txtCurrencyCode"+i+"' name='txtCurrencyCode"+i+"'   readonly value="+ jsonData[i].AU+" /></td>";
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"15\" class='medium3' id='txtCurrencyCode"+i+"' name='txtCurrencyCode"+i+"'   readonly value="+ jsonData[i].QtyReq+" /></td>";
				/* htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"15\" class='medium3' id='txtCurrencyCode"+i+"' name='txtCurrencyCode"+i+"'   readonly value="+ jsonData[i].DeliveryDate+" /></td>"; */
				htmlTable = htmlTable + "<td> <input  type=\"text\"  size=\"15\" class='medium3' id='txtCurrencyCode"+i+"' name='txtCurrencyCode"+i+"'   readonly value='' /></td>";
				
				htmlTable = htmlTable + "</tr>"; 
				//alert(htmlTable);
				
				$j("#tblListOfMPR").html(htmlTable);
				
			}
		}
		
		function fillVendorCombo(val) {

	          
		  	  var index1 = val.lastIndexOf("[");
			    var index2 = val.lastIndexOf("]");
			    index1++;
			    var id = val.substring(index1,index2);
			   
			    if(id ==""){
				  return;
				}else{
				   		obj =document.getElementById('supplier');
						obj.length = document.getElementById('supplier').length;
	                    var valu=obj.options[obj.length-1].value;
						var b="false";
						for(var i=1;i<obj.length;i++){
								    
			                    	var val1=obj.options[i].value;
			                    	var length=obj.length-1;	                              	
			                    }
	                    
			                    if(b=="false")
			                    {
			                    	obj.length++;
			    					obj.options[obj.length-1].value=id
			    					obj.options[obj.length-1].text=val
			    					obj.options[obj.length-1].selected=true
			    					document.getElementById('vname').value =""
			    			                    
			                    }
					}
		  }
		
		function deleteVendor(value){
		     if(document.getElementById('supplier').selectedIndex!=0){
			 if(confirm("are you sure want to delete ?")){
		 	 		document.getElementById('supplier').remove(document.getElementById('supplier').selectedIndex)
			    }
			   }
		     }
	 
		 </script>