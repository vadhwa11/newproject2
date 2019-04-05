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

<script type = "text/javascript" >
function preventBack(){window.history.forward();}
setTimeout("preventBack()", 0);

window.onunload=function(){null};
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
	

	List<StoreInternalIndentT> mrDetails = new ArrayList<StoreInternalIndentT>();
	List<StoreInternalIndentM> mrHeader = new ArrayList<StoreInternalIndentM>();					
	
	
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	
	String pageTitle = "";
	
	
	
	 if(map.get("title") != null)
	 {
		 pageTitle =  (String)map.get("title");	  
		   
	  }	
	
		
	 if(map.get("mrDetails") != null)
	 {
		 mrDetails =  (List<StoreInternalIndentT>)map.get("mrDetails");	  
		   
	  }	
	 if(map.get("mrHeader") != null)
	 {
		 mrHeader =  (List<StoreInternalIndentM>)map.get("mrHeader");	  
		   
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
	 
	 
		
		int mrHeaderId= 0;
		String mrDate ="";
		int year = 0;
		int priority=0;
		int districtId =0;	
		String SpecialRemarks = "";
		String MRStatus = "NA";
		String ProjectName="";
		String MRNo="";
		String PreparedBy = "";
		String Status = "NA";
		String ApprovedBy = "";
		String ApprovalRemarks = "";
	
		String ProposedName="";
		for(StoreInternalIndentM header: mrHeader)
		{
			mrHeaderId = header.getId();
			if(header.getDemandDate() != null)
			mrDate = HMSUtil.changeDateToddMMyyyy(header.getDemandDate());
			
			MRNo = (header.getDemandNo()!=null?header.getDemandNo():"");
			MRStatus = (header.getStatus()!=null?header.getStatus():"NA");
					
			PreparedBy = (header.getCreatedBy() != null?header.getCreatedBy().getEmployee().getFirstName():"");
			ApprovedBy = (header.getApprovedBy() != null?header.getApprovedBy().getFirstName():"");
			Status = (header.getStatus() != null?header.getStatus():"NA");
			ApprovalRemarks  = (header.getApprovalRemarks() != null?header.getApprovalRemarks():"NA");
		}
		
		if(Status.equalsIgnoreCase("u"))
		{
			MRStatus = "Saved";
		}
		else if(Status.equalsIgnoreCase("s"))
		{
			MRStatus = "Submit for Appproval";
		}
		else if(Status.equalsIgnoreCase("o"))
		{
			MRStatus = "Approved";
		}
		else if(Status.equalsIgnoreCase("r"))
		{
			MRStatus = "Rejected";
		}
		else if(Status.equalsIgnoreCase("y"))
		{
			MRStatus = "Received";
		}
%>




 <div class="titleBg">
<h2>View and Update-Material Request <%out.print(message); %></h2>
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
<label>MR No. <span>*</span></label>
	
<input	type="text" name="mprNo" value="<%=MRNo%>" readonly="readonly" validate="MR No ,String,yes" tabindex=1  id="mprNo"/>


<label> MR Date <span>*</span></label>
<input  type="text" class="input_date"  id="mrDate" name="mrDate"  validate="Date,string,yes" value="<%out.print(mrDate); %>"  maxlength="10" readonly/>

<label>MR Status</span></label>
<input	type="text" name="Prepared"  tabindex=1  id="Prepared" value="<% out.print(MRStatus);%>" readonly/>


<div class="clear"></div>
<label>Prepared By</label>
<input	type="text" name="Prepared"  tabindex=1  id="Prepared" value="<% out.print(PreparedBy);%>" readonly/>
<label>Approved By/Rejected By</span></label>
<input	type="text" name="Prepared"  tabindex=1  id="Prepared" value="<% out.print(ApprovedBy);%>" readonly/>

<label>Approval/Rejection Remarks</span></label>
<input	type="text" name="Prepared"  tabindex=1  id="Prepared" value="<% out.print(ApprovalRemarks);%>" readonly/>


	 
	
</div>  
	
	
 


	
	</div>
	<div class="clear paddingTop15"></div>
		<input type="hidden" size="2"	value="0"  name="noOfRows" id="noOfRows" />
		<input type="hidden" name="mrHeaderId" value="<%=mrHeaderId %>" id="mrHeaderId" />
		<input type="hidden" name="CHANGED_BY" value="<%=userId%>" />
		
		
	<%
	if(Status.equalsIgnoreCase("U"))
	{
		%>
			<input class="buttonAdd" type="button" tabindex="1" onclick="addRow('MRGrid');" value="">
			<input class="buttonDel" type="button" tabindex="1"  onclick="removeRow_FromDatabase('MRGrid','StoreInternalIndentT',<%out.print(mrHeaderId); %>);" value=""><img id='imgRemoveDetails' src='/hms/jsp/images/saving.gif' style="display:none;" />
		<%
	}
	
	%>
	

	
<div class="clear"></div>
<div class="cmntable">
<table id="MRGrid">
		
		<tr id="th">
		
         <%
         if(Status.equalsIgnoreCase("U"))
         {
        	 %>
        	 	 <th>Delete</th>
        	 <%
         }
         %>
          
	      <th width="2%">Sl No.</th>
	      <th width="5%">Mat Code</th>
	      <th width="20%">Nomenclature</th>
	      <th width="5%">A/U</th>
	      <th width="10%">Required Qty.</th>
	      <th width="15%">Available Stock</th>
	      <th width="13%">Stock in <br/>Ward Pharmacy</th>
	      <th width="13%">Stock in CD</th>
	      <th width="13%">Stock in Stores</th>	      
		   <th width="13%">Reason for MR</th>
		 	
	   
	      
    	</tr>
    
 	<%
 	int counter =1;
		for(StoreInternalIndentT detailsList :mrDetails)
		{
			
			%>
 
  
        <tr id="<%out.print(detailsList.getId()); %>">
        
        <%
         if(Status.equalsIgnoreCase("U"))
         {
        	 %>
        	 	 <td><input size="2" type="checkbox" class="small_chk" id="chk" value="<%out.print(detailsList.getId()); %>" /></td>
        	 <%
         }
         %>
          
      
		
		<td id="SRNO"><input size="2" type="text" value="<%out.print(counter); %>" readonly /></td>
	  
     
      <td>
      <input type="text" name="itemCode" tabindex="1" id="itemCode<%out.print(detailsList.getId()); %>" onblur="autocompleteBasedOnPvms(this.value,'<%=detailsList.getId() %>');" validate="PVMS No,String,no" size="12" value="<%=detailsList.getItem().getPvmsNo() %>" readonly/>
      <input type="hidden" name="ItemId<%out.print(detailsList.getId()); %>" tabindex="1" id="ItemId<%out.print(detailsList.getId()); %>" />																	
      </td>
      
		<td> 	<input type="text" id="nameItem<%=detailsList.getId() %>" validate='Nomenclature ,String,yes' onblur="checkForPurchase(this.value, 'nameItem','<%=detailsList.getId() %>');"  name="nameItem<%=detailsList.getId() %>" tabindex="1" size="40" value="<%=detailsList.getItem().getNomenclature() %>[<%=detailsList.getItem().getPvmsNo() %>]" readonly />
		<div id="ac2update" style="display:none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">

	    new Ajax.Autocompleter('nameItem<%=detailsList.getId() %>','ac2update','purchaseOrder?method=getItemListForPurchaseOrder',{parameters:'requiredField=nameItem<%=detailsList.getId() %>' })
	    
	
		</script>
		</td> 
      <td>
      <input type="text"  class="smcaption" readonly="readonly" name="AV<%out.print(detailsList.getId()); %>" id="idAu<%out.print(detailsList.getId()); %>" tabindex="1" validate="A/U ,String,no" size="8" value="<%=detailsList.getItem().getItemConversion().getItemUnitName()%>" readonly />
      </td>
      <td> <input  size="15" type="text" onkeypress ="return isNumber(event);"   id="txtRequiredQty<%out.print(detailsList.getId()); %>" name="txtRequiredQty<%out.print(detailsList.getId()); %>"  validate="Required Qty,string,yes" value="<%out.print(detailsList.getQtyRequest()); %>" />
      <td> <input  size="15" type="text"   id="txtAvailableStock<%out.print(detailsList.getId()); %>" name="txtAvailableStock<%out.print(detailsList.getId()); %>" value="<%out.print(detailsList.getAvailableStock()); %>" readonly />
      
      <td> <input  size="15" type="text"     id="txtWPStock<%out.print(detailsList.getId()); %>" name="txtWPStock<%out.print(detailsList.getId()); %>" value="<%out.print(detailsList.getWpStock()); %>"  readonly /></td>
       <td> <input  size="15" type="text"  id="txtCDStock<%out.print(detailsList.getId()); %>" name="txtCDStock<%out.print(detailsList.getId()); %>" value="<%out.print(detailsList.getCdStock()); %>" readonly /></td>
        <td> <input  size="15" type="text"     id="txtStoresStock<%out.print(detailsList.getId()); %>" id="txtStoresStock<%out.print(detailsList.getId()); %>" value="<%out.print(detailsList.getStoresStock()); %>" readonly/></td>
          <td> <textarea size ="20" class="large"  id="txtRemarks<%out.print(detailsList.getId()); %>" class="medium3"  name="txtRemarks<%out.print(detailsList.getId()); %>"  validate="Remarks,string,no" value=""   tabindex=1 style="width: 250px; height: 50px;" ><%out.print(detailsList.getReasonForDemand()!=null?detailsList.getReasonForDemand():""); %></textarea></td>
          
       
		  
   
       </tr>
       
       <%
       counter++;
		}
 	
 	%>
  
     	 
	
</table>
</div>
	
	

<input type="hidden" id="tableRowId" name="tableRowId" />
	<input type="hidden" id="txtRequestType" name="txtRequestType" />
</form>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
	
	<%
	if(Status.equalsIgnoreCase("U"))
	{
		%>
			
            <input type="button" name="Save"  class="button" value="Save" onclick="if(document.getElementById('chk')==null){alert('Please submit at least one medicine')}else{saveMR('MR','stores?method=updateSavedMRWard&mrHeaderId=<%out.print(mrHeaderId); %>&appId=A1523')}"/>
			<input type="button" name="Submit"  class="button" value="Submit" onclick="if(document.getElementById('chk')==null){alert('Please submit at least one medicine')}else{submitMR('MR','stores?method=updateSavedMRWard&mrHeaderId=<%out.print(mrHeaderId); %>&appId=A1523')}"/>
	
		<%
	}
	
	%>
	<input type="button" name="add" id="addbutton" value="Print" class="button" onClick="submitForm('MR','/hms/hms/stores?method=printDispensaryToStoreJsp&mrId=<%=mrHeaderId %>');"  tabindex=1 />
	
	
	
    
    
    
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
			  tableHtml= tableHtml +("<td> <input  type=\"text\"  size=\"15\" class='medium3' id='txtRequiredQty"+i+"' name='txtRequiredQty"+i+"'  validate=\"Required Qty,TwoDigitAfterDecimal,yes\"  maxlength='10' onkeypress=\"return isNumber(event);\" /></td>");
			  
			  tableHtml= tableHtml +("<td> <input  type=\"text\"  size=\"15\" class='medium3' id='txtAvailableStock"+i+"' name='txtAvailableStock"+i+"'  readonly  /></td>");
			  tableHtml= tableHtml +("<td> <input  type=\"text\"  size=\"15\" class='medium3' id='txtWPStock"+i+"' name='txtWPStock"+i+"'  readonly  /></td>");
			  tableHtml= tableHtml +("<td> <input  type=\"text\"  size=\"15\" class='medium3' id='txtCDStock"+i+"' name='txtCDStock"+i+"'  readonly  /></td>");
			  tableHtml= tableHtml +("<td> <input  type=\"text\"  size=\"15\" class='medium3' id='txtStoresStock"+i+"' name='txtStoresStock"+i+"'  readonly  /></td>");
			  
			  tableHtml= tableHtml +("<td size='25'> <textarea class=\"large\" id='txtRemarks"+i+"' name='txtRemarks"+i+"' validate=\"Remarks,string,no\" value=\"\" tabindex=1 style=\"width: 250px; height: 50px;\" ></textarea></td>");
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
		
		
		
		 </script>