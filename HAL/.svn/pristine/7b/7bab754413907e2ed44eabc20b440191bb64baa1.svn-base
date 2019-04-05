<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StorePoDetail"%>
<%@page import="jkt.hms.masters.business.StoreReTenderProposal"%>
<%@page import="jkt.hms.util.Box"%>
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
body,html {
	overflow: auto;
}

.locatorArrow {
	COLOR: #666666;
	FONT-FAMILY: Verdana;
	FONT-SIZE: 12px
}
</style>

<%
	String date = "";
	String time = "";
	String userName = "";
	int hospitalId = 0;
	
	Box box = HMSUtil.getBox(request);
	Map<String,Object> utilMap = new HashMap<String,Object>();
	Map<String,Object> cancelMap = new HashMap<String,Object>();
	Map<String,Object> remarksMap = new HashMap<String,Object>();
	;

	
	List objectList = new ArrayList();
	List poList = new ArrayList();
	
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
		
		if (map.get("poList")!=null)
			poList = (List)map.get("poList");
		
		if (map.get("cancelMap")!=null)
			cancelMap = (Map)map.get("cancelMap");

		if (map.get("remarksMap")!=null)
			remarksMap = (Map)map.get("remarksMap");
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
	if (ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>.length)
	{
		 for(var i = 0; i < ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>.length; i++)
	 	 {
	  	 	ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>[i].checked = true;
	 	 }
	}
	else
	{
		ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>.checked = true;
	}
}

function validateAddButton()
{
var net_amount = parseFloat(0);
var check = false;
var delivary = document.getElementById('delivery').value;
	if (ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>)
	{
			if (ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>.length)
			{
				 for(var i = 0; i < ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>.length; i++)
			 	 {
				  	 if (ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>[i].checked == true){
				  	 var amount = parseFloat(0);
				  	 var cal = ReTenderReSupplyOrderForm.<%=AMOUNT_FOR_CAL%>[i].value 
				  	 net_amount = net_amount + parseFloat(cal)
				    check = true;	
				  	 }
			 	 }
			}
			else
			{
				if (ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>.checked == true){
				   var amount = parseFloat(0);
				   var cal = ReTenderReSupplyOrderForm.<%=AMOUNT_FOR_CAL%>.value 
				  	 net_amount = net_amount + parseFloat(cal)
				  check =true;
				 // return true;
				}
			}
			
		if(check){
		if(delivary != ""){
	 	  if(confirm("Total Amount is : "+net_amount+"\nAre You Sure,You want Generate SO ? ")){
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
if (ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>)
	{
			if (ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>.length)
			{
			var check = true;
				 for(var i = 0; i < ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>.length; i++)
			 	 {
				 	 if (ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>[i].checked == true){
					  	 var amount = parseFloat(0);
					  	 var cal = ReTenderReSupplyOrderForm.<%=AMOUNT_FOR_CAL%>[i].value 
					  	 net_amount = net_amount + parseFloat(cal)
					  	 document.getElementById('totalAmt').value = roundVal(net_amount,3);
					        check = false;
	        		 }
	        	 }
			 	  if(check){
        		 	   net_amount = parseFloat(0);
						document.getElementById('totalAmt').value = net_amount;
        		  }
			}
			else
			{ 
				if (ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>.checked == true){
				 var amount = parseFloat(0);
				 var cal = ReTenderReSupplyOrderForm.<%=AMOUNT_FOR_CAL%>.value 
				 net_amount = net_amount + parseFloat(cal)
				document.getElementById('totalAmt').value = roundVal(net_amount,3);
				}else{
		          net_amount = parseFloat(0);
				document.getElementById('totalAmt').value = net_amount;
				}
			}
   }else {
      document.getElementById('totalAmt').value = net_amount;
   }
}


function generateLPO()
{
		if (validateAddButton())
		{
			ReTenderReSupplyOrderForm.method="post";	
			submitForm('ReTenderReSupplyOrderForm','tender?method=generateReTenderReLocalPurchaseOrder');
		}
}

function printLPO()
{
		if (ReTenderReSupplyOrderForm.<%=PO_NO%>.value!="")
		{
			ReTenderReSupplyOrderForm.method="post";	
			submitForm('ReTenderReSupplyOrderForm','tender?method=printCancelReLocalSupplyOrder');
		}
}


function validateCancelButton()
{
	if (ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_DELETED%>)
	{
			if (ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_DELETED%>.length)
			{
				 for(var i = 0; i < ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_DELETED%>.length; i++)
			 	 {
			  	 if (ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_DELETED%>[i].checked == true)
             		return true;
			 	 }
			}
			else
			{
				if (ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_DELETED%>.checked == true)
				return true;
			}
	}
	return false;
}

function jsClose()
{
  self.close();
}



</script>
<div id="contentHolder">
<form name="ReTenderReSupplyOrderForm" action="" method="post"><input
	type="hidden" name="numOfRows" size="5" value="15"> <input
	type="hidden" name="pageCount" size="5" value="10"> <input
	type="hidden" name="search" size="5" value="true"> <input
	type="hidden" name="tender_id" size="5"
	value="<%=box.get("tender_id")%>"> <input type="hidden"
	name="dept_id" size="5" value="<%=box.get("dept_id")%>"> <input
	type="hidden" name="supplier_id" size="5"
	value="<%=box.get("supplier_id")%>"> <input type="hidden"
	name="group_id" size="5" value="<%=box.get("group_id")%>"> <input
	type="hidden" name="<%=PROPOSAL_ID%>" size="5"
	value="<%=box.get("proposal_id")%>"> <input type="hidden"
	name="hospitalId" size="5" value="<%=hospitalId%>"> <input
	type="hidden" name="<%=CHANGED_BY%>" size="5" value="<%=userName%>">
<input type="hidden" name="<%=CHANGED_DATE%>" size="5" value="<%=date%>">
<input type="hidden" name="<%=CHANGED_TIME%>" size="5" value="<%=time%>">

<% if (objectList!=null && objectList.size() >0) {
			Object obj[] = (Object[]) objectList.get(0); 
		%>
<h6><%=obj[0].toString() %></h6>
<div class="Clear"></div>
<% } %> <%		
		if (objectList==null) {
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
			<th width="15%">Tender Qty</th>
			<th width="15%">Disp.Type</th>
			<th width="10%">MDQ</th>
			<th width="15%">Rate/MDQ</th>
			<th width="15%">Tax Amt/MDQ</th>
			<!--
				      <td width="15%">Unit Rate</th>
				      -->
			<th width="15%">Amount</th>
			<th width="15%">SO</th>
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

<div class="blockTitle">Item Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="tableHolderAuto">
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
			<th width="15%">Tax Amt/MDQ</th>
			<!--<td width="15%">Unit Rate</th>
				      -->
			<th width="15%">Amount</th>
			<th width="15%">SO</th>
		</tr>
	</thead>
	<tbody>

		<%
			    int slno=0; 
			    for (Iterator iterator = objectList.iterator(); iterator.hasNext();) 
			    {
			    	Object[] obj = (Object[]) iterator.next();
			    	int item_id = (Integer)obj[10];
			    %>
		<tr>
			<td><%=++slno%></td>
			<td><input type="text" value="<%=obj[1]%>" size="10"
				readonly="readonly" title="<%=obj[2]%>"></td>
			<td><%=obj[3]%></td>
			<td><%=obj[4]%></td>
			<td><%=obj[5]%></td>
			<td><%=obj[13]%></td>
			<td><%=obj[14]%></td>
			<!--<td><%=obj[7]%></td>
				-->
			<td><%=obj[8]%></td>
			<% if (obj[12]!=null) { %>
			<td><input type="text" value="Re-SO Raised" size="10"
				readonly="readonly"></td>
			<% } else { %>
			<td><input type="checkbox" name="<%=ITEMS_TO_BE_ADDED%>"
				value="<%=obj[10]%>" onclick="gettotalAmt();" class="smcaption"></td>
			<input type="hidden" id="<%=AMOUNT_FOR_CAL%>"
				name="<%=AMOUNT_FOR_CAL%>" value="<%=obj[8]%>" class="smcaption">
			<%}%>
			<% } %>
		</tr>
	</tbody>
</table>
</div>
<div class="Clear"></div>
<div class="blockFrame"><label class="medium">&nbsp;</label> <select
	name="<%=PO_NO%>">
	<%
				 for (Iterator iterator = poList.iterator(); iterator.hasNext();) 
			     {
			    	String obj =  (String)iterator.next();
				 %>

	<option value=<%=obj%>><%=obj%></option>
	<%
					}
				%>
</select> <input type="button" name="Add" onClick="printLPO()" value="Print SO"
	class="cmnButton" /> <% } %> <input type="button" name="sel"
	onClick="selectAll()" value="Select All" class="cmnButton" /> <input
	type="text" name="delivery" readonly id="delivery" value=""
	title="Delivery Date" class="calDate" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" title="Delivery Date"
	height="16" border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.ReTenderReSupplyOrderForm.<%="delivery"%>,event)" />


<input type="button" name="Add" onClick="generateLPO()"
	value="Generate SO" class="cmnButton" /> <input type="button"
	name="Close" onClick="jsClose()" value="Close" class="cmnButton" /> <input
	type="text" name="totalAmt" disabled id="totalAmt" /></div>
<div class="Clear"></div>
</form>
</div>

