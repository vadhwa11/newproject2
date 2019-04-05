<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.MprPriority"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.util.Box"%>

<%@page import="jkt.hms.masters.business.StoreMaterialPurchaseReqM"%>
<%@page import="jkt.hms.masters.business.MprPriority"%>
<%@ page import="jkt.hms.masters.business.MasProposedMPR"%>


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
	        var name  = item.getElementsByTagName("name")[0];
	        
        	document.getElementById('itemCode'+rowVal).value = pvms.childNodes[0].nodeValue
        	document.getElementById('ItemId'+rowVal).value = id.childNodes[0].nodeValue
        	document.getElementById('idAu'+rowVal).value = au.childNodes[0].nodeValue	
        	document.getElementById('nameItem'+rowVal).value = name.childNodes[0].nodeValue	
        	
        	
      }
    }
  }
}

function autocompleteBasedOnPvms(val,inc)
{	
	console.log(val);
	ajaxFunctionForAutoCompleteInLPOGeneral('purchaseGrid','stores?method=fillItemsForLpo&pvmsNo=' +  val , inc);
	
				
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
	

	List<StoreMaterialPurchaseReqM> MPRNumberList = new ArrayList<StoreMaterialPurchaseReqM>();
	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();	
	List<Object[]> financialYearList = new ArrayList<Object[]>();
	
	
	List<MprPriority> priorityList = new ArrayList<MprPriority>();
	List<MasProposedMPR> probaseList = new ArrayList<MasProposedMPR>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	

	if (map.get("MPRNumberList") != null) {
		MPRNumberList = (List<StoreMaterialPurchaseReqM>)map.get("MPRNumberList");
	}
	
	
	if(map.get("priorityList")!=null){
		priorityList = (List<MprPriority>) map.get("priorityList");
	}
	if(map.get("probaseList")!=null){
		probaseList = (List<MasProposedMPR>) map.get("probaseList");
	}
	if(map.get("supplierList")!=null){
		supplierList = (List<MasStoreSupplier>) map.get("supplierList");
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
<%if(session.getAttribute("deptId").toString().equals("24")){ %>



 <div class="titleBg">
<h2>Material Purchase Request</h2>
</div>

<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>

<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js"></script>

<script language="javascript">


var $j = jQuery.noConflict();
</script>
<form name="MPR" method="post">
<div id="testDiv" size="height:500px;">
	<input type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo"/>
	<%
	List<StoreMaterialPurchaseReqM> mprHeaderList = new ArrayList<StoreMaterialPurchaseReqM>();
	StoreMaterialPurchaseReqM mprHeaderObj = null;
	
	if(map.get("mprHeaderList") != null){
		mprHeaderList = (List)map.get("mprHeaderList");
	}
	if(mprHeaderList.size() > 0){
		mprHeaderObj = (StoreMaterialPurchaseReqM)mprHeaderList.get(0);
		netAmount = mprHeaderObj.getHashTableValue();
	}
		
	%>

<div class="Block">
<%-- <label>MPR No. <span>*</span></label>
	<% if(mprHeaderObj != null){%>
<input	type="text" name="mprNo" value="<%=mprHeaderObj.getMprNo()%>" readonly="readonly" validate="S.O. Number ,String,yes" tabindex=1  id="mprNo"/>
<%	}else{%>
<input	type="text"  name="mprNo" value="<%=max %>" readonly="readonly" validate="MPR. Number ,String,yes" tabindex=1  id="mprNo"/> 
<%}%> --%>

<label>Year<span>*</span></label>

<select name ="ddlRequestYear" id="ddlRequestYear" validate="Year,string,yes">
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


<label> MPR Date <span>*</span></label>
<input  type="text" class="input_date"  id="mprDate" name="mprDate" placeholder="DD/MM/YYYY" validate="Date,string,yes" value="<%out.print(newdate); %>" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'mprDate');" maxlength="10"/>
	

	<div class="clear"></div>
	<label> Type Wise  <span>*</span></label>
	<select	class="" name="priority" id="priorityId" validate="Type Wise Name,String,yes" tabindex=1>
		<option value="">Select</option>
<%
	for (MprPriority masPriority :priorityList ) 
	{
		
		%>		
		<option value=<%=masPriority.getId()%> readonly><%=masPriority.getPrName()%></option>
		<%   
	}
%>

</select> 
	
	<label>Project<span>*</span></label>
	
	<input	type="text" name="projectName"   validate="Welfare(M&H)-Medicines ,String,yes" tabindex=1  id="projectName" value="M&H Welfare" />
	<label> Proposed on  <span>*</span></label>
	<select	class="" name="proposedMPR" id="proposedMPR" validate="Proposed Name,String,yes" tabindex=1 >
		<option value="">Select</option>
<%
	for (MasProposedMPR list :probaseList ) 
	{
		
		%>		
		<option value=<%=list.getId()%> ><%=list.getProposedMPRName()%></option>
		<%   
	}
%>

</select>
	<div class="clear"></div>
	
	<label>Duration Of MPR and Delivery Schedule</label>
	
	<textarea value="" name="<%=REMARKS %>" validate="Remarks ,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" maxlength="200" style="width: 250px; height: 50px;"/></textarea> 
	
	
	<label>Special Notes</label>
	
	<textarea  name="specialNotes" validate="Special Notes ,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" maxlength="5000" style="width: 250px; height: 50px;"/></textarea> 
	
</div>  
	
	
 
	<!-- <input type="button" class="buttonBig2" value="IMPORT ITEMS BELOW ROL"  onclick="getMMF();"/>  --> 

	<div class="clear"></div>
	</div>
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
	      <th width="2%">Sl No.</th>
	      <th width="5%">Mat Code</th>
	      <th width="20%">Nomenclature</th>
	  
	      <th width="5%">A/U</th>
	          <th width="20%">Range/Strength</th>
	      <th width="10%">MPR Qty.</th>
	      <th width="15%">Unit Rate</th>
	      <th width="13%">Estimated Value</th>
	      <th width="13%">Select Tax</th>
	      <th width="13%">Qty in Stock</th>
	      <th width="13%">Avg Monthly <br/>Consumption</th>
	      <th width="13%">MPR No</th>
		  <th width="13">Qty</th>
		   <th width="13%">Previous PO No</th>
		   <th width="13%">Previous PO Date</th>
		   <th width="13%">Rate</th>
		   <th width="13%">Previous PO O/S Qty</th>
		   <!-- <th width="13%">Batch No</th> -->
		   <th width="20%">Previous Supplier</th>
		   <th width="13%">Sources</th>
		 	
	   
	      
    	</tr>
    <% int inc=1; %>
 
 
  
   <tr id="<%out.print(inc); %>">
      
				<td><input size="2" type="checkbox" class="small_chk" id="chk" value="<%out.print(inc); %>" /></td>
				<td><input size="2" type="text" value="<%out.print(inc); %>" readonly /></td>
	  
     
      <td>
      <input type="text" name="itemCode" tabindex="1" id="itemCode<%out.print(inc); %>" onblur="autocompleteBasedOnPvms(this.value,'<%=inc %>');" validate="PVMS No,String,no" size="12"/>
      <input type="hidden" name="ItemId<%out.print(inc); %>" tabindex="1" id="ItemId<%out.print(inc); %>" />
      </td>
      
		<td> 	<input type="text" value=""	id="nameItem<%=inc %>" validate='Nomenclature ,String,yes' onblur="checkForPurchase(this.value, 'nameItem','<%=inc %>'); GetMPRAndPODetails(<%=inc %>);"  name="nameItem<%=inc %>" tabindex="1" size="40" />
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
      <td>
      <input type="text" value="" class="smcaption"  name="Range<%out.print(inc); %>" id="Range<%out.print(inc); %>" tabindex="1" validate="Range ,String,no" size="40"/>
      </td>
      <td> <input  size="15" type="text" value="" onkeypress ="return isNumber(event);"   id="txtRequiredQty<%out.print(inc); %>" name="txtRequiredQty<%out.print(inc); %>"  validate="Required Qty,string,yes" onblur ="calculateAmount(<%out.print(inc); %>);"/>
      <td> <input  size="15" type="text" value="" onkeypress ="return isNumber(event);"   id="txtUnitRate<%out.print(inc); %>" name="txtUnitRate<%out.print(inc); %>"  validate="Unit Rate,string,yes" onblur ="calculateAmount(<%out.print(inc); %>);" />
      <%-- <td ><input id="deliveryDate<%out.print(inc); %>" name="deliveryDate<%out.print(inc); %>" class="input_date" type="text" maxlength="10" onblur="validateExpDate(this,'from-date-pick<%out.print(inc); %>');" onkeyup="mask(this.value,this,'2,5','/');" validate="Delivery Date,string,yes" placeholder="DD/MM/YYYY" style="width: 70px;" ></td> --%>
      <td> <input  size="15" type="text" value="" onkeypress ="return isNumber(event);"   id="txtEstimatedValue<%out.print(inc); %>" name="txtEstimatedValue<%out.print(inc); %>"  validate="Estimated Value,string,yes"/></td>
       <td> <Select    id="txtTax<%out.print(inc); %>" name="txtTax<%out.print(inc); %>" ><option value=' '></option><option value='Inclusive Tax'>Inclusive Tax</option><option value='Exclusive Tax'>Exclusive Tax</option><option value='Taxes as Applicable'>Taxes as Applicable</option></select></td>
        <td> <input  size="15" type="text" value="" onkeypress ="return isNumber(event);"   id="txtStockQty<%out.print(inc); %>" name="txtStockQty<%out.print(inc); %>"   /></td>
         <td> <input  size="15" type="text" value="" onkeypress ="return isNumber(event);"   id="txtMonthlyConsp<%out.print(inc); %>" name="txtMonthlyConsp<%out.print(inc); %>"   /></td>
          <td> <input  size="15" type="text" value=""    id="txtMprNo<%out.print(inc); %>" name="txtMprNo<%out.print(inc); %>"   /></td>
          <td> <input  size="15" type="text" value="" onkeypress ="return isNumber(event);"   id="txtMprQty<%out.print(inc); %>" name="txtMprQty<%out.print(inc); %>"   /></td>
          <td> <input  size="15" type="text" value=""    id="txtPONo<%out.print(inc); %>" name="txtPONo<%out.print(inc); %>"   /></td>
          <td> <input  size="15" type="text" value=""  class="input_date"  id="txtPODate<%out.print(inc); %>" name="txtPODate<%out.print(inc); %>"   maxlength="10" onblur="validateExpDate(this,'from-date-pick<%out.print(inc); %>');" onkeyup="mask(this.value,this,'2,5','/');" validate="Previous PO Date,string,no" placeholder="DD/MM/YYYY" style="width: 70px;" ></td>
          <td> <input  size="15" type="text" value="" onkeypress ="return isNumber(event);"   id="txtPORate<%out.print(inc); %>" name="txtPORate<%out.print(inc); %>"   /></td>
          <td> <input  size="15" type="text" value="" onkeypress ="return isNumber(event);"   id="txtQtAC<%out.print(inc); %>" name="txtQtAC<%out.print(inc); %>"   /></td>
         <%--  <td> <input  size="15" type="text" value="" onkeypress ="return isNumber(event);"   id="txtBatchNo<%out.print(inc); %>" name="txtBatchNo<%out.print(inc); %>"  readonly /></td> --%>
          <td> <input  size="20" type="text" value=""    id="txtSupplier<%out.print(inc); %>" name="txtSupplier<%out.print(inc); %>"   /></td>
          <%-- <td> <textarea size ="20" class="large"  id="txtRemarks<%out.print(inc); %>" class="medium3"  name="txtRemarks<%out.print(inc); %>"  validate="Remarks,string,no" value=""   tabindex=1 style="width: 250px; height: 50px;" ></textarea></td> --%>
          <td> <Select  id="txtSources<%out.print(inc); %>" name="txtSources<%out.print(inc); %>" multiple style="width:200px; height:150px;"><% for(MasStoreSupplier list: supplierList){%><option value='<%=list.getSupplierName()%>'><%=list.getSupplierName()%></option><%} %></select></td>
       
		  
   
       </tr>
   <%
     	 }   %>
     	 
	
</table>
</div>
<div class="clear"></div>	
	

<input type="hidden" id="tableRowId" name="tableRowId" />
	<input type="hidden" id="txtRequestType" name="txtRequestType" />
</form>
<%-- <%}else{ %>
<h4>Access Denied! </h4>
<%}%>  --%>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>	
	
	<input type="button" name="Save"  class="button" value="Save" onclick="saveMPR('MPR','stores?method=saveMPR');"/>
	<input type="button" name="Submit"  class="button" value="Submit" onclick="submitMPR('MPR','stores?method=saveMPR');"/>
		
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
			  tableHtml= tableHtml +("<td><input size='2' type=\"text\" value="+i+" readonly /></td><td><input type='text' name='itemCode"+i+"' id='itemCode"+i+"' validate='Mat Code,String,no' size='12' onblur=\"autocompleteBasedOnPvms(this.value,"+i+");\" /><input type='hidden' name='ItemId"+i+"'  id='ItemId"+i+"' value=''  /></td>");
			  tableHtml= tableHtml +("<td><input type='text' id='nameItem"+i+"' name='nameItem"+i+"' validate='Nomenclature ,String,yes' onblur=\"checkForPurchase(this.value, 'nameItem','"+i+"');\"   size='40' /><div id='ac2update' style='display:none;' class='autocomplete'></div></td>");
			  tableHtml= tableHtml +("<td><input type='text' value='' class='smcaption' readonly='readonly' name='AV"+i+"' id='idAu"+i+"' validate='AU ,String,no' size='8'/></td>");
			  tableHtml= tableHtml +("<td> <input  type=\"text\"  size=\"40\" class='medium3' id='Range"+i+"' name='Range"+i+"'    /></td>");
			  tableHtml= tableHtml +("<td> <input  type=\"text\"  size=\"15\" class='medium3' id='txtRequiredQty"+i+"' name='txtRequiredQty"+i+"'  validate=\"Qty Required,TwoDigitAfterDecimal,yes\"  maxlength='10' onkeypress=\"return isNumber(event);\" onblur =\"calculateAmount("+i+");\" /></td>");
			  
			  /* tableHtml= tableHtml +("<td ><input id='deliveryDate"+i+"' name='deliveryDate"+i+"' class='input_date' type='text' maxlength='10' onblur=\"validateExpDate(this,'from-date-pick"+i+"');\" onkeyup=\"mask(this.value,this,'2,5','/');\" validate=\"Delivery Date,string,yes\" placeholder=\"DD/MM/YYYY\" style=\"width: 70px;\" ></td>"); */
			  tableHtml= tableHtml +("<td> <input  type=\"text\"  size=\"15\" class='medium3' id='txtUnitRate"+i+"' name='txtUnitRate"+i+"'  validate=\"Unit Rate,TwoDigitAfterDecimal,yes\"  maxlength='10' onkeypress=\"return isNumber(event);\" onblur =\"calculateAmount("+i+");\" /></td>");
			  tableHtml= tableHtml +("<td> <input  type=\"text\"  size=\"15\" class='medium3' id='txtEstimatedValue"+i+"' name='txtEstimatedValue"+i+"'  validate=\"Estimated Value,TwoDigitAfterDecimal,yes\"  maxlength='10' onkeypress=\"return isNumber(event);\" /></td>");
			  tableHtml= tableHtml +("<td> <select id='txtTax"+i+"' name='txtTax"+i+"'><option value=' '></option><option value='Inclusive Tax'>Inclusive Tax</option><option value='Exclusive Tax'>Exclusive Tax</option><option value='Taxes as Applicable'>Taxes as Applicable</option></select></td>");
			  tableHtml= tableHtml +("<td> <input  type=\"text\"  size=\"15\" class='medium3' id='txtStockQty"+i+"' name='txtStockQty"+i+"'    /></td>");
			  tableHtml= tableHtml +("<td> <input  type=\"text\"  size=\"15\" class='medium3' id='txtMonthlyConsp"+i+"' name='txtMonthlyConsp"+i+"'    /></td>");
			  tableHtml= tableHtml +("<td> <input  type=\"text\"  size=\"15\" class='medium3' id='txtMprNo"+i+"' name='txtMprNo"+i+"'    /></td>");
			  tableHtml= tableHtml +("<td> <input  type=\"text\"  size=\"15\" class='medium3' id='txtMprQty"+i+"' name='txtMprQty"+i+"'    /></td>");
			  tableHtml= tableHtml +("<td> <input  type=\"text\"  size=\"15\" class='medium3' id='txtPONo"+i+"' name='txtPONo"+i+"'    /></td>");
			  tableHtml= tableHtml +("<td> <input  type=\"text\"  size=\"15\" class='input_date' id='txtPODate"+i+"' name='txtPODate"+i+"'  onblur=\"validateExpDate(this,'txtPODate"+i+"');\" onkeyup=\"mask(this.value,this,'2,5','/');\" validate=\"Previous PO Date,string,no\" placeholder=\"DD/MM/YYYY\" style=\"width: 70px;\"  /></td>");
			  tableHtml= tableHtml +("<td> <input  type=\"text\"  size=\"15\" class='medium3' id='txtPORate"+i+"' name='txtPORate"+i+"'    /></td>");
			  tableHtml= tableHtml +("<td> <input  type=\"text\"  size=\"15\" class='medium3' id='txtQtAC"+i+"' name='txtQtAC"+i+"'    /></td>");
			  
			  
			  /* tableHtml= tableHtml +("<td> <input  type=\"text\"  size=\"15\" class='medium3' id='txtBatchNo"+i+"' name='txtBatchNo"+i+"'   readonly /></td>"); */
			  tableHtml= tableHtml +("<td> <input  type=\"text\"  size=\"20\" class='medium3' id='txtSupplier"+i+"' name='txtSupplier"+i+"'    /></td>");
			  tableHtml= tableHtml +("<td size='25'> <select  id='txtSources"+i+"' name='txtSources"+i+"'  multiple style='width:200px; height:150px;' ><% for(MasStoreSupplier list: supplierList){%><option value='<%=list.getSupplierName()%>'><%=list.getSupplierName()%></option><%} %></select></td>");
			  tableHtml= tableHtml +("</tr>");
			  $j("#"+tableId).append(tableHtml);
			  
			 	
				 new Ajax.Autocompleter('nameItem'+i,'ac2update','purchaseOrder?method=getItemListForPurchaseOrder',{parameters:'requiredField=nameItem'+i+'&poId='+document.getElementById('poId').value }) 
				
			
			  var valRowId = new Array();
				$j("#"+tableId+" tr[id!='th']").each(function(j)
						{				
							valRowId[j] =$j(this).attr("id");
						});
				
				
				$j("#tableRowId").val(valRowId);
			 
		}
		
		function saveMPR(formName,url)
		{
			$j("#txtRequestType").val("SAVE");
			 var valRowId = new Array();
				$j("#MPRGrid tr[id!='th']").each(function(j)
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
		
		function submitMPR(formName,url)
		{
			$j("#txtRequestType").val("SUBMIT");
			 var valRowId = new Array();
				$j("#MPRGrid tr[id!='th']").each(function(j)
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
			if (!isNaN(document.getElementById('txtRequiredQty'+inc).value))
			quantity = parseFloat(document.getElementById('txtRequiredQty'+inc).value);
			
			if (!isNaN(document.getElementById('txtUnitRate'+inc).value))
				unitRate = parseFloat(document.getElementById('txtUnitRate'+inc).value);
			// Amount Calculation
			
			if (unitRate > 0 && quantity > 0)
			{
				amount = quantity * unitRate;
				document.getElementById('txtEstimatedValue'+inc).value =  amount.toFixed(2);
			}else
			{
				return;
			}

		}
		 </script>