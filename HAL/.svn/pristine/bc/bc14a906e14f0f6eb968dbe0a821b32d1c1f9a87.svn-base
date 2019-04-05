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
html,body {
	overflow: hidden;
}

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
	Map<String,Object> utilMap = new HashMap<String,Object>();
	Map<String,Object> cancelMap = new HashMap<String,Object>();
	Map<String,Object> remarksMap = new HashMap<String,Object>();
	Map<String,Object> supplierMap = new HashMap<String,Object>();
	Map<String,Object> lcatMap = new HashMap<String,Object>();
	Map<String,Object> l1catMap = new HashMap<String,Object>();
	List<StorePoHeader> storePoHeaderList = new ArrayList<StorePoHeader>();
	List objectList = new ArrayList();
	List lcatList = new ArrayList();
	List l1catList = new ArrayList();
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
		}
 	
  	Map map = new HashMap();
	
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		
		if (map.get("objectList")!=null)
			objectList = (List)map.get("objectList");
		
		if (map.get("storePoHeaderList")!=null)
			storePoHeaderList = (List)map.get("storePoHeaderList");
		
		if (map.get("cancelMap")!=null)
			cancelMap = (Map)map.get("cancelMap");

		if (map.get("remarksMap")!=null)
			remarksMap = (Map)map.get("remarksMap");
		
		if (map.get("lcatMap")!=null)
			lcatMap = (Map)map.get("lcatMap");
		
		if (map.get("l1catMap")!=null)
			l1catMap = (Map)map.get("l1catMap");
		
		if (map.get("supplierMap")!=null)
			supplierMap = (Map)map.get("supplierMap");
		
		if(map.get("remain") != null){
			remain = (BigDecimal)map.get("remain");	
		}
		totr = new  DecimalFormat("0.##").format(Double.valueOf(remain.toString()));
	}
	
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}

%>

<title>Supply Order - Split Up</title>

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
var totremain = parseFloat(document.getElementById('totremain').value);
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
					  	 document.getElementById('remain').value = roundVal(totremain + net_amount,3);
					        check = false;
					 }
	        	 }
			 	  if(check){
        		 	   net_amount = parseFloat(0);
					   document.getElementById('totalAmt').value = net_amount;
					   document.getElementById('remain').value = roundVal(totremain + net_amount,3);
					   
	    		  }
			}
			else
			{ 
				if (SupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>.checked == true){
				 var amount = parseFloat(0);
				 var cal = SupplyOrderForm.<%=AMOUNT_FOR_CAL%>.value 
				 net_amount = net_amount + parseFloat(cal)
				document.getElementById('totalAmt').value = roundVal(net_amount,3);
				document.getElementById('remain').value = roundVal(totremain + net_amount,3);
				}else{
		          net_amount = parseFloat(0);
				document.getElementById('totalAmt').value = net_amount;
				document.getElementById('remain').value = roundVal(totremain + net_amount,3);
				}
			}
   }else {
      document.getElementById('totalAmt').value = net_amount;
      document.getElementById('remain').value = roundVal(totremain + net_amount,3);
   }
   
}

function generateLPO()
{
 		if (validateAddButton())
		{
		 SupplyOrderForm.method="post";	
		  submitForm('SupplyOrderForm','tender?method=generateLocalPurchaseOrder');
		}
}

function printLPO()
{
		if (SupplyOrderForm.<%=PO_NO%>.value!="")
		{
			SupplyOrderForm.method="post";	
			submitForm('SupplyOrderForm','tender?method=printLocalSupplyOrder');
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
			  	    if (SupplyOrderForm.<%=ITEMS_TO_BE_DELETED%>[i].checked == true){
			  	     return true;
             		}
			 	 }
			}
			else
			{
				if (SupplyOrderForm.<%=ITEMS_TO_BE_DELETED%>.checked == true){
				 return true;
				}
			}
	}
	return false;
}


function jsUpdate()
{
		if (validateCancelButton())
		{
			SupplyOrderForm.method="post";	
			submitForm('SupplyOrderForm','tender?method=cancelSupplyOrderItems');
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
	type="hidden" name="tender_id" size="5"
	value="<%=box.get("tender_id")%>"> <input type="hidden"
	name="dept_id" size="5" value="<%=box.get("dept_id")%>"> <input
	type="hidden" name="supplier_id" size="5"
	value="<%=box.get("supplier_id")%>"> <input type="hidden"
	name="group_id" size="5" value="<%=box.get("group_id")%>"> <input
	type="hidden" name="hospitalId" size="5" value="<%=hospitalId%>">
<input type="hidden" name="<%=CHANGED_BY%>" size="5"
	value="<%=userName%>"> <input type="hidden"
	name="<%=CHANGED_DATE%>" size="5" value="<%=date%>"> <input
	type="hidden" name="<%=CHANGED_TIME%>" size="5" value="<%=time%>">

<% if (objectList!=null && objectList.size() >0) {
			Object obj[] = (Object[]) objectList.get(0); 
		%>
<h6><%=obj[0].toString() %></h6>
<div class="Clear"></div>
<% } %> <%	boolean checkMark = false;
		    boolean checkSing = false;
		    String message = "";
		if (objectList==null) {
			
		%>
<div class="Clear"></div>
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
			<th width="15%">Tender Qty</th>
			<th width="15%">Disp.Type</th>
			<th width="10%">MDQ</th>
			<th width="15%">Rate/MDQ</th>
			<th width="15%">TaxAmt/MDQ</th>
			<!--<td width="15%">Unit Rate</th>
				      -->
			<th width="15%">Amount</th>
			<th width="10%">SO</th>
			<th width="10%">Cancel</th>
			<th width="15%">Remarks</th>
			<th width="15%">LCat List</th>
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
	class="button" />
<div class="Clear"></div>
<%  } else { %>
<div class="Clear"></div>
<div class="blockTitle">Item Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="tableHholderCmnLarge2">
<table align="center" width="100%" colspan="7" class="grid_header"
	cellpadding="0" cellspacing="0">

	<thead>
		<tr>
			<th width="5%">SR No</th>
			<th width="10%">PVMS No</th>
			<th width="15%">Tender Qty</th>
			<th width="15%">Disp.Type</th>
			<th width="10%">MDQ</th>
			<th width="15%">Rate/MDQ</th>
			<th width="15%">TaxAmt/MDQ</th>
			<!--
				      <td width="15%">Unit Rate</th>
				      -->
			<th width="15%">Amount</th>
			<th width="10%">SO</th>
			<th width="10%">Cancel</th>
			<th width="15%">Remarks</th>
			<th width="15%">LCat List</th>
		</tr>
	</thead>
	<tbody>

		<%
			    int slno=0;
				int c = 0;
			    for (Iterator iterator = objectList.iterator(); iterator.hasNext();) 
			    {
			    	Object[] obj = (Object[]) iterator.next();
			    	int item_id = (Integer)obj[11];
			       String tenqty=new DecimalFormat("0.##").format(Double.valueOf(obj[3].toString())) +" "+ obj[4].toString();
			       String mdq = new  DecimalFormat("0.##").format(Double.valueOf(obj[6].toString()));
			    %>
		<tr>
			<td><%=++slno%></td>
			<%if (l1catMap!=null && l1catMap.size() > 0){
					l1catList = (List)l1catMap.get(String.valueOf(item_id));
					if (l1catList!=null && l1catList.size() > 1){ %>
			<td bgcolor="red"><input type="text" value="<%=obj[1]%>"
				size="10" readonly="readonly" title="<%=obj[2]%>"></td>
			<%	}else{
						if (lcatMap!=null && lcatMap.size() > 0)
				    	{
				    	lcatList = (List)lcatMap.get(String.valueOf(item_id));
				    	 if (lcatList!=null && lcatList.size() > 0) 
				    	 {  %>
			<td><input type="text" value="<%=obj[1]%>" size="10"
				readonly="readonly" title="<%=obj[2]%>"></td>
			<% }else{ checkSing = true;%>
			<td bgcolor="green"><input type="text" value="<%=obj[1]%>"
				size="10" readonly="readonly" title="<%=obj[2]%>"></td>
			<% }
				        }
				    }	
				}%>
			<td><%=tenqty%></td>
			<td><%=obj[5]%></td>
			<td><%=mdq%></td>
			<td><%=obj[13]%></td>
			<td><%=obj[14]%></td>
			<!--<td><%=obj[8]%></td>
				-->
			<td><%=obj[9]%></td>
			<% if (obj[10]!=null) { %>
			<td><input type="text" value="SO Raised" size="8"
				readonly="readonly"></td>
			<%} else {
					if (l1catMap!=null && l1catMap.size() > 0){
				    	l1catList = (List)l1catMap.get(String.valueOf(item_id));	
				    	if (l1catList!=null && l1catList.size() > 1){
				    		checkMark = true;
				%>
			<td><input type="checkbox" disabled
				name="<%=ITEMS_TO_BE_ADDED%>" value="<%=obj[11]%>"
				onclick="gettotalAmt();"> <input type="hidden"
				id="<%=AMOUNT_FOR_CAL%>" name="<%=AMOUNT_FOR_CAL%>"
				value="<%=obj[9]%>"></td>
			<%}else{ %>
			<td><input type="checkbox" name="<%=ITEMS_TO_BE_ADDED%>"
				value="<%=obj[11]%>" onclick="gettotalAmt();"> <input
				type="hidden" id="<%=AMOUNT_FOR_CAL%>" name="<%=AMOUNT_FOR_CAL%>"
				value="<%=obj[9]%>"></td>
			<%  }
				}else{ %>
			<td><input type="checkbox" name="<%=ITEMS_TO_BE_ADDED%>"
				value="<%=obj[11]%>" onclick="gettotalAmt();"> <input
				type="hidden" id="<%=AMOUNT_FOR_CAL%>" name="<%=AMOUNT_FOR_CAL%>"
				value="<%=obj[9]%>"></td>
			<%}
				}
				
				if (cancelMap.get(String.valueOf(item_id))!= null) {%>
			<td><input type="text" size="8"
				value="<%=cancelMap.get(String.valueOf(item_id))%>" readonly></td>
			<td><input type="text" name="remarks"
				value="<%=remarksMap.get(String.valueOf(item_id))%>" readonly></td>
			<%}else{ %>
			<td><input type="checkbox" name="<%=ITEMS_TO_BE_DELETED%>"
				value="<%=obj[11]%>"></td>

			<td><input type="text" name="remarks"></td>

			<%}%>
			<%
					if (supplierMap.get(String.valueOf(item_id))!=null)
					{  
					%>
			<td><select name="lcat" class="large2">
				<option value="<%=supplierMap.get(String.valueOf(item_id))%>"><%=supplierMap.get(String.valueOf(item_id))%></option>
			</select></td>
			<%}
					else
					{
				    	if (lcatMap!=null && lcatMap.size() > 0)
				    	{
				    	lcatList = (List)lcatMap.get(String.valueOf(item_id));
				    	if (lcatList!=null && lcatList.size() > 0) 
				    	{ %>
			<td><select name="lcat">
				<%	for (Iterator iterator2 = lcatList.iterator(); iterator2.hasNext();) 
					    	{
						    	Object[] object = (Object[]) iterator2.next();
					    		%>
				<option value="<%=object[0]%>"><%=object[1]%></option>
				<%	} %>
			</select> <% } else { %>
			<td><select name="lcat">
				<option value="0">Single Quoted Item</option>
			</select></td>
			<% } 
				  	    } //end of lcatMap checking 
				  	} %> <input type="hidden" name="itemIds" value="<%=obj[11]%>">
			<%
		   		 c++;
			    } %>
		</tr>
	</tbody>
</table>
</div>
<div class="Clear"></div>
<div class="blockFrame">
<%if (storePoHeaderList!=null && storePoHeaderList.size()>0) { %> <select
	name="<%=PO_NO%>">
	<%	for (Iterator iterator = storePoHeaderList.iterator(); iterator.hasNext();) 
					{
						StorePoHeader storePoHeader = (StorePoHeader)iterator.next();
				%>
	<option value=<%=storePoHeader.getPoNumber()%>><%=storePoHeader.getPoNumber()%></option>
	<%
					}
				%>
</select> <input type="button" name="Add" onClick="printLPO()" value="Print SO"
	class="cmnButton" /> <% } %> <input type="button" name="sel"
	onClick="selectAll()" value="Select All" class="cmnButton" /> <input
	type="text" name="delivery" readonly id="delivery" value=""
	class="calDate" title="Delivery Date" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" title="Delivery Date"
	height="16" border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.SupplyOrderForm.<%="delivery"%>,event)" />

<input type="button" name="Add" onClick="generateLPO()"
	value="Generate SO" class="cmnButton" /> <input type="button"
	name="Update" onClick="jsUpdate()" value="Cancel SO" class="cmnButton" />

<input type="button" name="Close" onClick="jsClose()" value="Close"
	class="cmnButton" /> <input type="text" name="totalAmt" disabled id="totalAmt"> 
	<div class="Clear"></div>
	 <label class="noHeight">Approval of CFA/IFA vide</label>
	 <input type="text" class="apprcfa" value=" "  name="<%="approval" %>" validate="approval of CFA/IFA vide ,string,no"/> 
	
	<%if(checkMark){ 
				message = message + " *Items Marked As Red are having more than one L1";
			}
			if(checkSing){
				message = message + "\n *Items Marked As green are Single Quoted";
			}
			%>
<div class="Clear"></div>
<% 
			if(message.length() > 0){%> <label class="unit"><span><%=message %></span></label>
<div class="Clear"></div>
<%} %> <label class="large2 paddLeft300">Today total 'SO' amount
for the current vendor</label> <input type="text" size="18" name="remain"
	value="<%=totr%>" disabled id="remain"> <input type="hidden"
	size="18" name="totremain" value="<%=totr%>" id="totremain"></div>
<div class="Clear"></div>
<%}%>
</form>
</div>