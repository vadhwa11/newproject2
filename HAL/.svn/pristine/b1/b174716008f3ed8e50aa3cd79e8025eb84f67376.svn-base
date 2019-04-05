<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.math.BigDecimal"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
</script>


<style type="text/css">
<!--
.locatorArrow {
	COLOR: #666666;
	FONT-FAMILY: Verdana;
	FONT-SIZE: 12px
}

html,body {
	overflow: auto;
}
</style>

<%
	String date = "";
	String time = "";
	String userName = "";
	int hospitalId = 0;
	BigDecimal remain = new BigDecimal("0");
	BigDecimal totRemain = new BigDecimal("100000");
	String totr = "";
	Box box = HMSUtil.getBox(request);
	Map<String, Object> utilMap = new HashMap<String, Object>();
	Map<String, Object> cancelMap = new HashMap<String, Object>();
	Map<String, Object> remarksMap = new HashMap<String, Object>();
	Map<String, Object> supplierMap = new HashMap<String, Object>();
	Map<String, Object> lcatMap = new HashMap<String, Object>();
	List<StorePoHeader> storePoHeaderList = new ArrayList<StorePoHeader>();
	List objectList = new ArrayList();
	List lcatList = new ArrayList();

	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	date = (String) utilMap.get("currentDate");
	time = (String) utilMap.get("currentTime");
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}

	Map map = new HashMap();

	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

		if (map.get("objectList") != null)
			objectList = (List) map.get("objectList");

		if (map.get("storePoHeaderList") != null) {
			storePoHeaderList = (List) map.get("storePoHeaderList");
			System.out.println("storePoHeaderList is not null");
		}

		if (map.get("cancelMap") != null)
			cancelMap = (Map) map.get("cancelMap");

		if (map.get("remarksMap") != null)
			remarksMap = (Map) map.get("remarksMap");

		if (map.get("lcatMap") != null)
			lcatMap = (Map) map.get("lcatMap");

		if (map.get("supplierMap") != null)
			supplierMap = (Map) map.get("supplierMap");
		
		if(map.get("remain") != null){
			remain = (BigDecimal)map.get("remain");	
		}
		
		totRemain = remain;
		totr = new  DecimalFormat("0.##").format(Double.valueOf(totRemain.toString()));
	}

	if (session.getAttribute("hospitalId") != null) {
		Integer temp = (Integer) session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
%>

<script>

function selectAll()
{
	if (SupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>.length)
	{
		 for(var i = 0; i < SupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>.length; i++)
	 	 {
	  	 	SupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>[i].checked = true;
	 	 }
	}
	else
	{
		SupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>.checked = true;
	}
}


function validateAddButton()
{
var net_amount = parseFloat(0);
var check = false;
var remain = parseFloat(document.getElementById('remain').value);
 var delivary = document.getElementById('delivery').value;
	if (SupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>)
	{
	 		if (SupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>.length)
			{
				 for(var i = 0; i < SupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>.length; i++)
			 	 {
			  	 if (SupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>[i].checked == true){
				  	 var amount = parseFloat(0);
				  	 var cal = SupplyOrderForm.<%=AMOUNT_FOR_CAL%>[i].value 
				  	 net_amount = net_amount + parseFloat(cal)
				    check = true;
			 	 }
			   }
		    }
			else
			{
			 if (SupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>.checked == true){
			    var amount = parseFloat(0);
				var cal = SupplyOrderForm.<%=AMOUNT_FOR_CAL%>.value 
				net_amount = net_amount + parseFloat(cal)
				 check =true;
				 // return true;
				}
			}
			var msg = "";
	if(check){
	if(delivary != ""){
	 if(remain > 100000){
 		    msg = "Total 'SO' amount for the day has exceeded Rs.1 Lakh do you want to continue";
          }else{
            msg = "Total Amount is : "+net_amount+"\nAre You Sure,You want Generate SO ? ";
          }
	 	  if(confirm(msg)){
		    return true;
		  }else{
			return false;
		  }
	}else{
	 alert("Delivery Date should not be blank !!!")
		   document.getElementById('delivary').focus();
		   return false;
	}	  
	   }else{
	      alert('No Item(s) Selected to Generate SO!....');
	      return false;
	   }			
			
	}
	return false;
}

function roundVal(val,dec){
	var result = Math.round(val*Math.pow(10,dec))/Math.pow(10,dec);
	return result;
}
function gettotalAmt(){
var net_amount = parseFloat(0);
var totRe =parseFloat( document.getElementById('totremain').value)
if (SupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>)
	{
			if (SupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>.length)
			{
			var check = true;
				 for(var i = 0; i < SupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>.length; i++)
			 	 {
				 	 if (SupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>[i].checked == true){
					  	 var amount = parseFloat(0);
					  	 var cal = SupplyOrderForm.<%=AMOUNT_FOR_CAL%>[i].value 
					  	 net_amount = net_amount + parseFloat(cal)
					  	 document.getElementById('totalAmt').value = roundVal(net_amount,3);
					  	 document.getElementById('remain').value = roundVal(totRe + net_amount,3);
					        check = false;
	        		 }
	        	 }
			 	  if(check){
        		 	   net_amount = parseFloat(0);
						document.getElementById('totalAmt').value = net_amount;
						document.getElementById('remain').value = roundVal(totRe + net_amount,3);
						
        		  }
			}
			else
			{ 
				if (SupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>.checked == true){
				 var amount = parseFloat(0);
				 var cal = SupplyOrderForm.<%=AMOUNT_FOR_CAL%>.value 
				 net_amount = net_amount + parseFloat(cal)
				document.getElementById('totalAmt').value = roundVal(net_amount,3);
				document.getElementById('remain').value = roundVal(totRe + net_amount,3);
				}else{
		          net_amount = parseFloat(0);
				document.getElementById('totalAmt').value = net_amount;
				document.getElementById('remain').value = roundVal(totRe + net_amount,3);
				}
			}
   }else {
      document.getElementById('totalAmt').value = net_amount;
      document.getElementById('remain').value = roundVal(totRe + net_amount,3);
   }
}


function generateLPO()
{
		if (validateAddButton())
		{
			SupplyOrderForm.method="post";	
			submitForm('SupplyOrderForm','tender?method=generateLocalPurchaseOrderForLpoNote');
		}

}

function printLPO()
{
		if (SupplyOrderForm.<%=PO_NO%>.value!="")
		{
		
			SupplyOrderForm.method="post";	
			submitForm('SupplyOrderForm','tender?method=printLocalSupplyOrderForLpoNote');
		}
}


function validateCancelButton()
{
	if (SupplyOrderForm.<%=ITEMS_TO_BE_DELETED%>)
	{
			if (SupplyOrderForm.<%=ITEMS_TO_BE_DELETED%>.length)
			{
				 for(var i = 0; i < SupplyOrderForm.<%=ITEMS_TO_BE_DELETED%>.length; i++)
			 	 {
			  	 if (SupplyOrderForm.<%=ITEMS_TO_BE_DELETED%>[i].checked == true)
             		return true;
			 	 }
			}
			else
			{
				if (SupplyOrderForm.<%=ITEMS_TO_BE_DELETED%>.checked == true)
				return true;
			}
	}
	return false;
}


function jsUpdate()
{
		if (validateCancelButton())
		{
			SupplyOrderForm.method="post";	
			submitForm('SupplyOrderForm','tender?method=cancelSupplyOrderItemsForLpoNote');
		}
		else
		{
			alert('No Item(s) Selected to Cancel!....');
		}
}


function jsClose()
{
  self.close();
}



</script>
<div id="contentHolder">
<form name="SupplyOrderForm" action="" method="post"><input
	type="hidden" name="numOfRows" size="5" value="15"> <input
	type="hidden" name="pageCount" size="5" value="10"> <input
	type="hidden" name="search" size="5" value="true"> <input
	type="hidden" name="tenderId" size="5" value="<%=box.get("tenderId")%>">
<input type="hidden" name="deptId" size="5"
	value="<%=box.get("deptId")%>"> <input type="hidden"
	name="supplierId" size="5" value="<%=box.get("supplierId")%>">
<input type="hidden" name="group_id" size="5"
	value="<%=box.get("group_id")%>"> <input type="hidden"
	name="noteNo" size="5" value="<%=box.get("noteNo")%>"> <input
	type="hidden" name="hospitalId" size="5" value="<%=hospitalId%>">
<input type="hidden" name="<%=CHANGED_BY%>" size="5"
	value="<%=userName%>"> <input type="hidden"
	name="<%=CHANGED_DATE%>" size="5" value="<%=date%>"> <input
	type="hidden" name="<%=CHANGED_TIME%>" size="5" value="<%=time%>">

<%
	if (objectList != null && objectList.size() > 0) {
		Object obj[] = (Object[]) objectList.get(0);
%>
<h6><%=obj[0].toString()%></h6>
<div class="Clear"></div>
<%
	}
%> <%
 	if (objectList == null) {
 %>
<div class="blockTitle">Item Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="tableHolderAuto">
<table align="center" width="100%" colspan="7" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th width="5%">SR No</th>
			<th width="10%">PVMS No</th>
			<th width="15%">Qty Requested</th>
			<th width="15%">Disp.Type</th>
			<th width="10%">MDQ</th>
			<th width="15%">Rate/MDQ</th>
			<th width="15%">TaxAmt/MDQ</th>
			<!--<td width="15%">Unit Rate</th>
				      -->
			<th width="15%">Amount
			</th>
			<th width="10%">SO
			</th>
			<th width="10%">Cancle</th>
			<th width="15%">Remarks
			</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=8 align="center">No Items Found</td>
		</tr>
	</tbody>
</table>
</div>
<div class="Clear"></div>

<input type="button" name="Close" onClick="jsClose()" value="Close"
	class="button" /> <%
 	} else {
 %>

<div class="blockTitle">Item Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="tableHholderCmnlarge2">

<table align="center" width="100%" colspan="7" cellpadding="0"
	cellspacing="0">

	<thead>
		<tr>
			<th width="5%">SR No</th>
			<th width="10%">PVMS No</th>
			<th width="15%">Qty Requested</th>
			<th width="15%">Disp.Type</th>
			<th width="10%">MDQ</th>
			<th width="15%">Rate/MDQ</th>
			<th width="15%">TaxAmt/MDQ</th>
			<!--
				      <td width="15%">Unit Rate</th>
				      -->
			<th width="15%">Amount</th>
			<th width="10%">SO</th>
			<th width="10%">Cancle</th>
			<th width="15%">Remarks</th>

		</tr>
	</thead>
	<tbody>

		<%
			int slno = 0;
				for (Iterator iterator = objectList.iterator(); iterator
						.hasNext();) {
					Object[] obj = (Object[]) iterator.next();
					int item_id = (Integer) obj[10];
		%>
		<tr>
			<td><%=++slno%></td>
			<td><input type="text" value="<%=obj[1]%>" readonly="readonly"
				size="10" title="<%=obj[2]%>"></td>
			<td><%=obj[3]%></td>
			<td><%=obj[4]%></td>
			<td><%=obj[5]%></td>
			<td><%=obj[12]%></td>
			<td><%=obj[13]%></td>
			<!--<td><%=obj[7]%></td>
				-->
			<td><%=obj[8]%></td>
			<%
				if (obj[9] != null) {
			%>
			<td><input type="text" value="SO Raised" size="8"
				readonly="readonly"></td>
			
			<%}else {%>
			<td><input type="checkbox" name="<%=ITEMS_TO_BE_ADDED%>"
				value="<%=obj[10]%>" onclick="gettotalAmt();"> <input
				type="hidden" id="<%=AMOUNT_FOR_CAL%>" name="<%=AMOUNT_FOR_CAL%>"
				value="<%=obj[8]%>"></td>
			<%}%>
			<%System.out.println("in jsp obj[9]::"+obj[9]);
			if(obj[9] !=null){
				System.out.println("cancel Map ::"+cancelMap.get(String.valueOf(item_id))+"::item::"+item_id);
			if (cancelMap.get(String.valueOf(item_id))!= null) {%>
			<td><input type="text" size="8"
				value="<%=cancelMap.get(String.valueOf(item_id))%>" readonly></td>
				<%if(remarksMap.get(String.valueOf(item_id))!=null){ %>
			<td><input type="text" name="remarks" value="<%=remarksMap.get(String.valueOf(item_id))%>" readonly></td>
			<%}else{ %>
			<td><input type="text" name="remarks"></td>
			<%}}else{ %>
			<td><input type="checkbox" name="<%=ITEMS_TO_BE_DELETED%>"
				value="<%=obj[10]%>"></td>
            
			<td><input type="text" name="remarks"></td>

			<%}}else{%>
			<td><input type="checkbox" name="<%=ITEMS_TO_BE_DELETED%>"
				value="" disabled="disabled"></td>

			<td><input type="text" name="remarks" disabled="disabled"></td>
			<%} %>
			<input type="hidden" name="itemIds" value="<%=obj[10]%>">
			<%
				}
			%>
		</tr>
	</tbody>
</table>
</div>
<div class="Clear"></div>

<%
	if (storePoHeaderList != null && storePoHeaderList.size() > 0) {
%>
<div class="blockFrame"><label class="medium">&nbsp;</label> <select
	name="<%=PO_NO%>">
	<%
		for (Iterator iterator = storePoHeaderList.iterator(); iterator
						.hasNext();) {
					StorePoHeader storePoHeader = (StorePoHeader) iterator
							.next();
	%>
	<option value=<%=storePoHeader.getPoNumber()%>><%=storePoHeader.getPoNumber()%></option>
	<%
		}
	%>
</select> <input type="button" name="Add" onClick="printLPO()" value="Print SO"
	class="cmnButton" /> <%
  
 	}
 %> <input type="button" name="sel" onClick="selectAll()"
	value="Select All" class="cmnButton" /> <input type="text"
	name="delivery" readonly id="delivery" value="" class="calDate"
	title="Delivery Date" /> <img id="calendar"
	style="vertical-align: middle;" src="/hms/jsp/images/cal.gif"
	width="16" title="Delivery Date" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('',document.SupplyOrderForm.<%="delivery"%>,event)" />

<input type="button" name="Add" onClick="generateLPO()" value="Generate SO" class="cmnButton" />
<input type="button" name="Update" onClick="jsUpdate()" value="Cancel SO" class="cmnButton" />
<input type="button" name="Close" onClick="jsClose()" value="Close" class="cmnButton" />
<input type="text" name="totalAmt" disabled id="totalAmt">
<div class="Clear"></div>
<label class="large2 paddLeft300">Today total 'SO' amount for
the current vendor:</label> <input type="text" size="20" disabled name="remain"
	value="<%=totr%>" id="remain"> <input type="hidden"
	name="totremain" value="<%=totr%>" id="totremain"></div>
</form>
</div>
<%
	}
%>

