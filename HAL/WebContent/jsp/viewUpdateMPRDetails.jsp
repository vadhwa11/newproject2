<%@page import="jkt.hms.masters.business.MprPriority"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.util.Box"%>

<%@page import="jkt.hms.masters.business.StoreMaterialPurchaseReqM"%>
<%@page import="jkt.hms.masters.business.StoreMaterialPurchaseReqT"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
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
	Map<String, Object> map1 = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	String previousPage = "no";
	
	String max = "";
	BigDecimal netAmount = null;
	Box box = null;
	String DeliveryDate = null;
	String QuotationDate = null;
	

	List<StoreMaterialPurchaseReqT> mprDetails = new ArrayList<StoreMaterialPurchaseReqT>();
 	List<StoreMaterialPurchaseReqM> mprHeader = new ArrayList<StoreMaterialPurchaseReqM>();
	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
	List<MasProposedMPR> probaseList = new ArrayList<MasProposedMPR>();
	
	List<Object[]> mprPriorityList = new ArrayList<Object[]>();
	List<Object[]> financialYearList = new ArrayList<Object[]>();
	
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
	 
	 if(map.get("map1") != null)
	 {
		 map1 =  (Map<String, Object>)map.get("map1");	  
		   
	  }	
	 if(map.get("financialYearList") != null)
	 {
		 financialYearList =  (List<Object[]>)map.get("financialYearList");	  		 
		   
	  }
	 if(map.get("mprPriorityList") != null)
	 {
		 mprPriorityList =  (List<Object[]>)map.get("mprPriorityList");	  
		   
	  }	
	 
	 if(map1.get("probaseList")!=null){
			probaseList = (List<MasProposedMPR>) map1.get("probaseList");
		}
	 if(map1.get("supplierList") != null)
	 {
		supplierList =  (List<MasStoreSupplier>)map1.get("supplierList");	  		 
		   
	  }
		
	 if(map.get("mprDetails") != null)
	 {
		 mprDetails =  (List<StoreMaterialPurchaseReqT>)map.get("mprDetails");	  
		   
	  }	
	 if(map.get("mprHeader") != null)
	 {
		 mprHeader =  (List<StoreMaterialPurchaseReqM>)map.get("mprHeader");	  
		   
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
	 
	 
		
		int mprHeaderId= 0;
		String mprDate ="";
		int year = 0;
		int priority=0;
		int districtId =0;	
		String SpecialRemarks = "";
		String MPRStatus = "NA";
		String ProjectName="";
		String MPRNo="";
		int mrpId=0;
		int ProposedId=0;
		String SpecialNotes="";
		String delverySchedule="";
		for(StoreMaterialPurchaseReqM header: mprHeader)
		{
			mprHeaderId = header.getId();
			if(header.getMprDate() != null)
			mprDate = HMSUtil.changeDateToddMMyyyy(header.getMprDate());
			year = (header.getFinancial()!=null?header.getFinancial().getId():0);
			ProjectName = (header.getProject()!=null?header.getProject():"");
			MPRNo = (header.getMprNo()!=null?header.getMprNo():"");
			mrpId= header.getId();
			priority = (header.getMprPriority()!=null?header.getMprPriority().getId():0);		
			if(header.getStatus() != null)
			{
				MPRStatus = header.getStatus();
			}
			ProposedId = header.getProbase().getId();
			SpecialNotes = (header.getSpecialNotes()!=null?header.getSpecialNotes():"");	
			delverySchedule = (header.getDeliverySchedule()!=null?header.getDeliverySchedule():"");	
			
			
		}
%>
<%-- <%if(session.getAttribute("deptId").toString().equals("24")){ %> --%>



 <div class="titleBg">
<h2>View and Update-Material Purchase Request <%out.print(message); %></h2>
</div>

<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>

<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>

<script language="javascript">


var $j = jQuery.noConflict();
</script>
<form name="MPR" method="post">
<div id="testDiv" size="height:500px;">
	
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
	
<br /><br />
<div class="Block">
<label>MPR No. <span>*</span></label>
	
<input	type="text" name="mprNo" value="<%=MPRNo%>" readonly="readonly" validate="MPR No ,String,yes" tabindex=1  id="mprNo"/>
<label>Year:</label>

<select name ="ddlRequestYear" id="ddlRequestYear" >
<option value="0">Select</option>
	<%
		if(financialYearList.size()>0)
		{
			for(Object[] yearList : financialYearList)
			{
				if(year == (Integer)yearList[0])
						{
							%>
								<option value="<%=yearList[0]%>" selected><%=yearList[1]%></option>
							<%
						}
			}
		}
	%>
</select>


<label> MPR Date <span>*</span></label>
<input  type="text" class="input_date"  id="mprDate" name="mprDate"  validate="Date,string,yes" value="<%out.print(mprDate); %>"  maxlength="10" readonly/>
	

	<div class="clear"></div>
	<label> Type Wise  <span>*</span></label>
	<select	class="" name="priority" id="priorityId" validate="Priority Name,String,yes" tabindex=1 readonly>
		<option value="">Select</option>
<%
	for (Object[]  pr :mprPriorityList ) 
	{
		
				if(priority == (Integer)pr[0])
						{
							%>
								<option value="<%=pr[0]%>" selected><%=pr[1]%></option>
							<%
						}  
	}
%>

</select> 
	
	<label>Project</label>
	
	<input	type="text" name="projectName" validate="Project Name ,String,yes" tabindex=1  id="projectName" value="<% out.print(ProjectName);%>" readonly/>
	
	<label> Proposed on  </label>
	<select	class="" name="proposedMPR" id="proposedMPR" validate="Proposed Name,String,no" tabindex=1 >
		<option value="">Select</option>
<%
	for (MasProposedMPR list :probaseList ) 
	{
		
		%>		
		<option value=<%=list.getId()%>  <% if(ProposedId ==list.getId() ){%>selected<%} %> ><%=list.getProposedMPRName()%></option>
		<%   
	}
%>

</select>
	<%-- <label>Proposed Name</label>
	<input	type="text" name="ProposedName" validate="Proposed Name ,String,yes" tabindex=1   value="<% out.print(ProposedName);%>" readonly/> --%>
	
	<div class="clear"></div>
	
	<label>Delivery Schedule</label>
	<textarea  name="remarks" validate="Special Notes ,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" maxlength="200" style="width: 250px; height: 50px;"/><% out.print(delverySchedule); %></textarea>
	
	 <label>Special Notes</label>
	<textarea  name="specialNotes" validate="Special Notes ,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" maxlength="200" style="width: 250px; height: 50px;"/><% out.print(SpecialNotes); %></textarea>
	
	
</div>  
	
	
 
	<!-- <input type="button" class="buttonBig2" value="IMPORT ITEMS BELOW ROL"  onclick="getMMF();"/> -->  
<input type="button" name="add" id="addbutton" value="Print" class="button" onClick="submitForm('MPR','/hms/hms/stores?method=generateMrp&mrpId=<%=mrpId %>');"  tabindex=1 />
	
	</div>
	<div class="clear paddingTop15"></div>
		<input type="hidden" size="2"	value="0"  name="noOfRows" id="noOfRows" />
		<input type="hidden" name="mprHeaderId" value="<%=mprHeaderId %>" id="mprHeaderId" />
		<input type="hidden" name="CHANGED_BY" value="<%=userId%>" />
		
		
	<%
	if(!MPRStatus.equalsIgnoreCase("y"))
	{
		%>
			<input class="buttonAdd" type="button" tabindex="1" onclick="addRow('MPRGrid');" value="">
			<input class="buttonDel" type="button" tabindex="1"  onclick="removeRow_FromDatabase('MPRGrid','StoreMaterialPurchaseReqT',<%out.print(mprHeaderId); %>);" value=""><img id='imgRemoveDetails' src='/hms/jsp/images/saving.gif' style="display:none;" />
		<%
	}
	
	%>
	

	
<div class="clear"></div>
<div class="cmntable">
<table id="MPRGrid">
		
		<tr id="th">
		
         
          <th>Delete</th>
	      <th width="2%">Sl No.</th>
	      <th width="5%">Mat Code</th>
	      <th width="20%">Nomenclature</th>
	      <th width="5%">A/U</th>
	        <th width="5%">Range/Strength</th>
	      <th width="10%">MPR Qty.</th>
	      <th width="15%">Unit Rate</th>
	      <th width="13%">Estimated Value</th>
	      <th width="13%">Tax Details</th>
	      <th width="13%">Qty in Stock</th>
	      <th width="13%">Avg Monthly <br/>Consumption</th>
	      <th width="13%">MPR No</th>
		  <th width="13">Qty</th>
		   <th width="13%">Previos PO No</th>
		   <th width="13%">PO Date</th>
		   <th width="13%">Rate</th>
		   <th width="13%">Previous PO O/S Qty</th>
		   <!-- <th width="13%">Batch No</th> -->
		   <th width="20%">Previous Supplier Name</th>
		   <th width="13%">Sources</th>
		 	
	   
	      
    	</tr>
    
 	<%
 	int counter =1;
		for(StoreMaterialPurchaseReqT detailsList :mprDetails)
		{
			
			%>
 
  
        <tr id="<%out.print(detailsList.getId()); %>">
      
		<td><input size="2" type="checkbox" class="small_chk" id="chk" value="<%out.print(detailsList.getId()); %>" /></td>
		<td id="SRNO"><input size="2" type="text"  id="tdSrNo<%out.print(detailsList.getId()); %>" value="<%out.print(counter); %>" readonly /></td>
	  
     
      <td>
      <input type="text" name="itemCode" tabindex="1" id="itemCode<%out.print(detailsList.getId()); %>" onblur="autocompleteBasedOnPvms(this.value,'<%=detailsList.getId() %>');" validate="PVMS No,String,no" size="12" value="<%=detailsList.getItem().getPvmsNo() %>" readonly/>
      <input type="hidden" name="ItemId<%out.print(detailsList.getId()); %>" tabindex="1" id="ItemId<%out.print(detailsList.getId()); %>" />																	
      </td>
      
		<td> 	<input type="text" id="nameItem<%=detailsList.getId() %>" validate='Nomenclature ,String,yes' onblur="checkForPurchase(this.value, 'nameItem','<%=detailsList.getId() %>');"  name="nameItem<%=detailsList.getId() %>" tabindex="1" size="40" value="<%=detailsList.getItem().getNomenclature() %>" readonly />
		<div id="ac2update" style="display:none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">

	    new Ajax.Autocompleter('nameItem<%=detailsList.getId() %>','ac2update','purchaseOrder?method=getItemListForPurchaseOrder',{parameters:'requiredField=nameItem<%=detailsList.getId() %>' })
	    
	
		</script>
		</td> 
      <td>
      <input type="text"  class="smcaption" readonly="readonly" name="AV<%out.print(detailsList.getId()); %>" id="idAu<%out.print(detailsList.getId()); %>" tabindex="1" validate="A/U ,String,no" size="8" value="<%=detailsList.getItem().getItemConversion().getItemUnitName()%>" readonly />
      </td>
       <td>
      <input type="text"  class="smcaption"  name="Range<%out.print(detailsList.getId()); %>" id="Range<%out.print(detailsList.getId()); %>" tabindex="1" validate="Range ,String,no" size="40" value="<%=detailsList.getItemRangeCapacity() !=null?detailsList.getItemRangeCapacity():""%>"/>
      </td>
      <td> <input  size="15" type="text"  onkeypress ="return isNumber(event);"   id="txtRequiredQty<%out.print(detailsList.getId()); %>" name="txtRequiredQty<%out.print(detailsList.getId()); %>"  validate="Required Qty,string,yes" value="<%=detailsList.getQtyRequired() %>" onblur="calculateAmount(<%out.print(detailsList.getId()); %>);" />
       <td> <input  size="15" type="text"  onkeypress ="return isNumber(event);"   id="txtUnitRate<%out.print(detailsList.getId()); %>" name="txtUnitRate<%out.print(detailsList.getId()); %>"  validate="Unit Rate,string,yes" value="<%=detailsList.getUnitRate() %>" onblur="calculateAmount(<%out.print(detailsList.getId()); %>);" />
      <%-- <td ><input id="deliveryDate<%out.print(detailsList.getId()); %>" name="deliveryDate<%out.print(detailsList.getId()); %>" class="input_date" type="text" maxlength="10" onblur="validateExpDate(this,'from-date-pick<%out.print(detailsList.getId()); %>');" onkeyup="mask(this.value,this,'2,5','/');" validate="Delivery Date,string,yes" placeholder="DD/MM/YYYY" style="width: 70px;"  value="<%out.print(HMSUtil.changeDateToddMMyyyy(detailsList.getDeliveryDate())); %>"></td> --%>
      <td> <input  size="15" type="text" onkeypress ="return isNumber(event);"   id="txtEstimatedValue<%out.print(detailsList.getId()); %>" name="txtEstimatedValue<%out.print(detailsList.getId()); %>"  validate="Estimated Value,string,yes"  value="<%=detailsList.getEstimatedValues() %>" /></td>
       
       <td> <Select    id="txtTax<%out.print(detailsList.getId()); %>" name="txtTax<%out.print(detailsList.getId()); %>" ><option value=' '></option><option value='Inclusive Tax' <%if(detailsList.getTax().equalsIgnoreCase("Inclusive Tax")){%>selected<%} %>>Inclusive Tax</option><option value='Exclusive Tax'  <%if(detailsList.getTax().equalsIgnoreCase("Exclusive Tax")){%>selected<%} %>>Exclusive Tax</option><option value='Taxes as Applicable'  <%if(detailsList.getTax().equalsIgnoreCase("Taxes as Applicable")){%>selected<%} %>>Taxes as Applicable</option></select></td>
        <td> <input  size="15" type="text" onkeypress ="return isNumber(event);"   id="txtStockQty<%out.print(detailsList.getId()); %>" name="txtStockQty<%out.print(detailsList.getId()); %>"   value="<% out.print(detailsList.getQtyInStock()!=null?detailsList.getQtyInStock():""); %>" /></td>
         <td> <input  size="15" type="text"  onkeypress ="return isNumber(event);"   id="txtMonthlyConsp<%out.print(detailsList.getId()); %>" name="txtMonthlyConsp<%out.print(detailsList.getId()); %>"   value="<% out.print(detailsList.getAvgMontlyConsumption()!=null?detailsList.getAvgMontlyConsumption():""); %>" /></td>
          <td> <input  size="15" type="text"  onkeypress ="return isNumber(event);"   id="txtMprNo<%out.print(detailsList.getId()); %>" name="txtMprNo<%out.print(detailsList.getId()); %>"   value="<% out.print(detailsList.getMprNo()!=null?detailsList.getMprNo():""); %>" /></td>
          <td> <input  size="15" type="text"  onkeypress ="return isNumber(event);"   id="txtMprQty<%out.print(detailsList.getId()); %>" name="txtMprQty<%out.print(detailsList.getId()); %>"   value="<% out.print(detailsList.getMprQty()!=null?detailsList.getMprQty():""); %>" /></td>
          <td> <input  size="15" type="text"     id="txtPONo<%out.print(detailsList.getId()); %>" name="txtPONo<%out.print(detailsList.getId()); %>"    value="<% out.print(detailsList.getPreviosPoNo()!=null?detailsList.getPreviosPoNo():""); %>" /></td>
          <td> <input  size="15" type="text"  onkeypress ="return isNumber(event);"   id="txtPODate<%out.print(detailsList.getId()); %>" name="txtPODate<%out.print(detailsList.getId()); %>"   value="<% out.print(detailsList.getPoDate()!=null?HMSUtil.changeDateToddMMyyyy(detailsList.getPoDate()):""); %>" /></td>
          <td> <input  size="15" type="text"  onkeypress ="return isNumber(event);"   id="txtPORate<%out.print(detailsList.getId()); %>" name="txtPORate<%out.print(detailsList.getId()); %>"   value="<% out.print(detailsList.getPoRate()!=null?detailsList.getPoRate():""); %>" /></td>
          <td> <input  size="15" type="text"  onkeypress ="return isNumber(event);"   id="txtQtAC<%out.print(detailsList.getId()); %>" name="txtQtAC<%out.print(detailsList.getId()); %>"   value="<% out.print(detailsList.getPendingQtyLastPo()!=null?detailsList.getPendingQtyLastPo():""); %>" /></td>
          
          <td> <input  size="20" type="text"    id="txtSupplier<%out.print(detailsList.getId()); %>" name="txtSupplier<%out.print(detailsList.getId()); %>"  value="<% out.print(detailsList.getPreviosSupplier()!=null?detailsList.getPreviosSupplier():""); %>" /></td>
          
          <td> <textarea size ="20" class="large"  id="txtSources<%out.print(detailsList.getId()); %>" class="medium3"  name="txtSources<%out.print(detailsList.getId()); %>"  validate="Remarks,string,no" value=""   tabindex=1 style="width: 250px; height: 50px;" ><%=detailsList.getSources()!=null?detailsList.getSources():"" %></textarea></td>
          
       
		  
   
       </tr>
       
       <%
       counter++;
		}
 	
 	%>
   <%--     
   <%
     	 }   %> --%>
     	 
	
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
	
	<%
	if(!MPRStatus.equalsIgnoreCase("y"))
	{
		%>
			<input type="button" name="Save"  class="button" value="Save" onclick="saveMPR('MPR','stores?method=updateSavedMPR&mprHeaderId=<%out.print(mprHeaderId); %>&appId=A1523');"/>
			<input type="button" name="Submit"  class="button" value="Submit" onclick="submitMPR('MPR','stores?method=updateSavedMPR&mprHeaderId=<%out.print(mprHeaderId); %>&appId=A1523');"/>
		<%
	}
	
	%>
	
	
	
    
    
    
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
		
			var tdSrNo = $j("#tdSrNo"+j).val();
			tdSrNo = tdSrNo * 1;
			tdSrNo = tdSrNo+ 1;
	
			  var tableHtml ="";
			  tableHtml= tableHtml +("<tr id='"+i+"'><td size = '2'><input type=\"checkbox\" class=\"small_chk\" id=\"chk\" value="+i+" /></td>");
			  tableHtml= tableHtml +("<td id=\"SRNO\"><input size='2' type=\"text\" id='tdSrNo"+i+"' value="+tdSrNo+" readonly /></td><td><input type='text' name='itemCode"+i+"' id='itemCode"+i+"' validate='Mat Code,String,no' size='12' onblur=\"autocompleteBasedOnPvms(this.value,"+i+");\" /><input type='hidden' name='ItemId"+i+"'  id='ItemId"+i+"' value=''/></td>");
			  tableHtml= tableHtml +("<td><input type='text' id='nameItem"+i+"' name='nameItem"+i+"' validate='Nomenclature ,String,yes' onblur=\"checkForPurchase(this.value, 'nameItem','"+i+"');\"   size='40' /><div id='ac2update' style='display:none;' class='autocomplete'></div></td>");
			  tableHtml= tableHtml +("<td><input type='text' value='' class='smcaption' readonly='readonly' name='AV"+i+"' id='idAu"+i+"' validate='AU ,String,no' size='8'/></td>");
			  tableHtml= tableHtml +("<td> <input  type=\"text\"  size=\"40\" class='medium3' id='Range"+i+"' name='Range"+i+"'    /></td>");
			  tableHtml= tableHtml +("<td> <input  type=\"text\"  size=\"15\" class='medium3' id='txtRequiredQty"+i+"' name='txtRequiredQty"+i+"'  validate=\"Qty Required,TwoDigitAfterDecimal,yes\"  maxlength='10' onkeypress=\"return isNumber(event);\" onblur =\"calculateAmount("+i+");\" /></td>");
			 /*  tableHtml= tableHtml +("<td ><input id='deliveryDate"+i+"' name='deliveryDate"+i+"' class='input_date' type='text' maxlength='10' onblur=\"validateExpDate(this,'from-date-pick"+i+"');\" onkeyup=\"mask(this.value,this,'2,5','/');\" validate=\"Delivery Date,string,yes\" placeholder=\"DD/MM/YYYY\" style=\"width: 70px;\" ></td>"); */
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
			  tableHtml= tableHtml +("<td size='25'> <select  id='txtSources"+i+"' name='txtSources"+i+"' multiple style='width:200px; height:150px;' ><% for(MasStoreSupplier list: supplierList){%><option value='<%=list.getSupplierName()%>'><%=list.getSupplierName()%></option><%} %></select></td>");
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
				document.getElementById('txtEstimatedValue'+inc).value =  Math.round(amount.toFixed(2));
			}else
			{
				return;
			}

		}
		 </script>