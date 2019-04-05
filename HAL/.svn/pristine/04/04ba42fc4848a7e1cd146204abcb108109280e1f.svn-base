<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * chargeCodePopUp.jsp  
 * Purpose of the JSP -  This is for Charge code.
 * @author  Ritu
 * Create Date: 2nd Apr,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.5
--%>

<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>

<script type="text/javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<link rel="stylesheet" href="/hms/jsp/css/acnik.css" type="text/css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	
	List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}
	
	if(map.get("chargeCodeList")!=null){
		chargeCodeList = (List<MasChargeCode>)map.get("chargeCodeList");
	
	}
	
	%>

<div id="contentspace"><br />
<h2 align="left" class="style1">Select Charge Code</h2>

<form name="chargeCodePopUp" method="post"><input type="hidden"
	name="itemId" id="itemId" value="" /> <input type="hidden" name="date"
	id="date" value="" /> <input type="hidden" name="time" id="time"
	value="" /> <input type="hidden" name="fromDateToDate"
	id="fromDateToDate" value="" /> <input type="hidden" name="ipissueno"
	id="ipissueno" value="" /> <input type="hidden"
	name="storeFyDocumentNoId" id="storeFyDocumentNoId" value="" /> <input
	type="hidden" name="deptId" id="deptId" value="" />
</td>
<br />
<div
	style="overflow: auto; width: 100%; height: 260px; padding-left: 9px;">
<table width="200px" colspan="7" id="indentDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>

		<tr>
			<%int i=1;
      if(chargeCodeList.size() > 0){
      %>
			<td width="2%"><label valign="left" class="smalllabel"></label></td>
			<td width="15%"><label valign="left" class="smalllabel">Charge
			Code</label></td>
			<td width="15%"><label valign="left" class="smalllabel">Amount</label>
			</td>
		</tr>

	</thead>
	<tbody>
		<% 
  					Iterator itr= chargeCodeList.iterator();
  					while(itr.hasNext())
  					{
  						MasChargeCode masChargeCode = (MasChargeCode) itr.next();
  			        	String chargeCodeName=masChargeCode.getChargeCodeName();
  			        	int chargeCodeId = masChargeCode.getId();
 			%>

		<tr>
			<td width="2%"><input type="checkbox" class="checkbox"
				name="chargeCodeId<%=i %>" value="<%=chargeCodeId %>" /></td>
			<td width="15%"><input type="text" name="chargeCodeName<%=i %>"
				class="medcaption" readonly="readonly" value="<%=chargeCodeName %>" /></td>
			<td width="15%"><input type="text" name="amt<%=i %>"
				class="medcaption" readonly="readonly"
				value="<%=masChargeCode.getCharge() %>" /></td>

			<tr />
				<%		
  	 	i++;
  					}
  	   }else{
 			%>
				No records to display
				<%
		}

   %>
			
	</tbody>
</table>
<br />


<div id="edited"></div>
<input type="button" name="Ok" value="Ok" class="button"
	onclick="setChargeCodeValues('chargeCodePopUp');" /> <input
	type="hidden" name="counter" id="counter" value="<%=i %>" />
</form>
</div>
<script type="text/javascript">

		
	function setChargeCodeValues(formName){
		 addRowForTotal();
		 var counter=document.getElementById('counter').value;
		 amt =0;
		 totalChargeAmt=0;
		 netAmt =0;
		 totalNetAmt=0;
		
		 for(var i = 1; i < counter; i++)
		 {
		 	var check = eval('document.chargeCodePopUp.chargeCodeId'+i)
		 	if(check.checked){
		 	  var len = window.opener.document.getElementById("chargeDetails").rows.length;
			  var r = window.opener.document.getElementById("chargeDetails").insertRow(len);
			  var c1 = r.insertCell(0);
			  var c2 = r.insertCell(1);
			  var c3 = r.insertCell(2);
			  var c4 = r.insertCell(3);
			  var c5 = r.insertCell(4);
			  var c6 = r.insertCell(5);
		  
			  c1.innerHTML = '<input type="text" size="2" class="smcaption" name="sr_no" readonly="readonly"/>';
			  var x1 = window.opener.document.getElementsByTagName('input');
			  var y1 = x1[x1.length-4];
			  y1.id = 'sno'+len;
			  y1.value = len;
			  
			  c2.innerHTML='<input type="text" class="bigcaption" name="chargecode" readonly="readonly"/>';
			  var x2 = window.opener.document.getElementsByTagName('input');
			  var y2 = x2[x2.length-4];
			  y2.id = 'chargecode'+len;
			  var chargeCodeName=eval('document.'+formName+'.chargeCodeName' + i + '.value')
			  y2.value = chargeCodeName;
			  
			  c3.innerHTML='<input type="text" class="medcaption" name="qty" value="1" onchange="calculateNetAmount(\'search\',this.id,this.name);calculateTotalAmt(\'search\');"/>';
			  var x3 = window.opener.document.getElementsByTagName('input');
			  var y3 = x3[x3.length-4];
			  y3.id = 'qty'+len;
			  y3.value = "1";
			  
			  c4.innerHTML='<input type="text" value="" class="medcaption"  name="amount" />';
			  var x4 = window.opener.document.getElementsByTagName('input');
			  var y4 = x4[x4.length-4];
			  y4.id = 'amount'+len;
			  var amountVal = eval('document.'+formName+'.amt' + i + '.value');
			  y4.value = amountVal;
						  
			  c5.innerHTML='<input type="text" value="" class="medcaption"	name="disamount" onchange="calculateNetAmount(\'search\',this.id,this.name);calculateTotalAmt(\'search\');"/>';
			  var x5 = window.opener.document.getElementsByTagName('input');
			  var y5 = x5[x5.length-4];
			  y5.id = 'disamount'+len;
					  
			  c6.innerHTML='<input type="text" value="" class="medcaption"	name="netamount"/>';
			  var x6 = window.opener.document.getElementsByTagName('input');
			  var y6 = x6[x6.length-4];
			  y6.id = 'netamount'+len;
			  totalAmt = y3.value*y4.value;
			  y6.value = totalAmt
			  
			  amt = window.opener.document.getElementById(y4.id).value;
			  totalChargeAmt = parseInt(totalChargeAmt)+parseInt(amt);
			 	
			  netAmt = window.opener.document.getElementById(y6.id).value;
			  totalNetAmt = parseInt(totalNetAmt)+parseInt(netAmt);
		
		}
	}	
		var totalAmtVal = window.opener.document.getElementById('totalAmtId').value;
		if(totalAmtVal == ''){
			window.opener.document.getElementById('totalAmtId').value=totalChargeAmt
		}else{
			window.opener.document.getElementById('totalAmtId').value=parseInt(totalChargeAmt)+parseInt(totalAmtVal)
		}
			
		var totalNetAmtVal = window.opener.document.getElementById('totalNetId').value;
		if(totalNetAmtVal == ''){
			window.opener.document.getElementById('totalNetId').value=totalNetAmt
		}else{
			window.opener.document.getElementById('totalNetId').value=parseInt(totalNetAmt)+parseInt(totalNetAmtVal)
		}		
		window.close();
}
		
	function addRowForTotal(){
			var len = window.opener.document.getElementById("totalDetails").rows.length;
			if(len == 0){
			  var row = window.opener.document.getElementById("totalDetails").insertRow(len);
			  var co1 = row.insertCell(0);
			  var co2 = row.insertCell(1);
			  var co3 = row.insertCell(2);
			  var co4 = row.insertCell(3);
			  var co5 = row.insertCell(4);
			  var co6 = row.insertCell(5);
			  
			  co1.innerHTML = 'Total Bill Amt:';
			  co2.innerHTML = '<input type="text" id="totalAmtId" class="midcaption" name="totalBillAmt" readOnly/>';
			  co3.innerHTML = 'Total Discount Amt:';
			  co4.innerHTML = '<input type="text" id="totalDisId" class="midcaption" name="totalDisAmt" readOnly/>';
			  co5.innerHTML = 'Total Net Amt:';
			  co6.innerHTML = '<input type="text" id="totalNetId" class="midcaption" name="totalNetAmt" readOnly/>';
		
			
			  
		}
	}
	
	
</script>



