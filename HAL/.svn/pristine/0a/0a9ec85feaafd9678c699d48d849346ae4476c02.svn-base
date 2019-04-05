<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>

<%@page import="jkt.hms.masters.business.MasMainChargecode"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<div id="contentHolder">
<form name="ipBilling" method="post" action="">
<%
	
	 int pageNo=1;
	int chargeSlipMainId = 0;
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	List<Inpatient> patientDetailsList = new ArrayList<Inpatient>();
	List<MasMainChargecode> mainChargeCodeList = new ArrayList<MasMainChargecode>();
	List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
	List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
	Box box = HMSUtil.getBox(request);
	
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	
	}

	if(map.get("pageNo") != null)
	{
		pageNo=(Integer)map.get("pageNo");
		
	}
	if(map.get("chargeSlipMainId") != null)
	{
		chargeSlipMainId=(Integer)map.get("chargeSlipMainId");
		
	}
	
	if(map.get("detailsMap") != null){
		detailsMap = (Map<String,Object>)map.get("detailsMap");
	}
	if(map.get("patientDetailsList") != null){
		patientDetailsList = (List<Inpatient>)map.get("patientDetailsList");
	}
	if(detailsMap.get("mainChargeCodeList") != null){
		mainChargeCodeList = (List<MasMainChargecode>)detailsMap.get("mainChargeCodeList");
	}
	if(detailsMap.get("subChargeCodeList") != null){
		subChargeCodeList = (List<MasSubChargecode>)detailsMap.get("subChargeCodeList");
	}
	if(detailsMap.get("chargeCodeList") != null){
		chargeCodeList = (List<MasChargeCode>)detailsMap.get("chargeCodeList");
	}
	
	%> <%
    	if(patientDetailsList.size() > 0){
    		
    		
       %> <!--Block One Starts-->
<div class="blockTitle">Patient Details</div>
<div class="blockTitleCurve"></div>
<%
  
   		for(Inpatient inpatient : patientDetailsList){
   		 Patient patient = inpatient.getHin();
%>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>
<label>Admission No:</label> <%
		    String adNo = "";
		    int inpatientId = 0;
		   	if(!inpatient.getAdStatus().equals("D")){
					inpatientId = inpatient.getId();
					adNo = inpatient.getAdNo();
			}
	    %> <label class="value"> <%=adNo%></label> <label>Patient
Name:</label> <%
			if(patient.getPFirstName() != null)
			{
		%> <label class="value"> <%= patient.getPFirstName() %> <%= patient.getPLastName()%></label>
<%
		}%> <label>Age:</label> <label class="value"> <%=patient.getAge() %></label>
<div class="Clear"></div>
<label>Sex:</label> <label class="value"> <%=patient.getSex().getAdministrativeSexName() %></label>

<label>Service Person Name:</label> <%
			if(patient.getSFirstName() != null)
			{
		%> <label class="value"> <%= patient.getSFirstName() %> <%= patient.getSLastName()%></label>
<%
		}else{
		%> <label class="value"> -</label> <%} %> <label>Service Type:</label> <%
	    if(patient.getServiceType()!= null){
	    %> <label class="value"> <%=patient.getServiceType().getServiceTypeName() %></label>
<%
		   }else{
		%> <label class="value"> -</label> <%} %>
<div class="Clear"></div>
<label>Service Status:</label> <%if(patient.getServiceStatus() != null){%>
<label class="value"> <%=patient.getServiceStatus().getServiceStatusName() %></label>
<%}else{ %> <label class="value"> -</label> <%} %> <label>Relation:</label>
<%if(patient.getRelation() != null){%> <label class="value"> <%=patient.getRelation().getRelationName() %></label>
<%}else{ %> <label class="value"> -</label> <%} %> <br />
<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>">
<input type="hidden" name="<%=HIN_NO %>"
	value="<%=patient.getHinNo() %>"> <input type="hidden"
	name="<%=INPATIENT_ID %>" value="<%=inpatientId%>"> <input
	type="hidden" name="<%=AD_NO %>" value="<%=adNo%>"> <%} %>
</div>
<!--Block one Ends-->
<div class="division"></div>
<input type=hidden value=0 name=pagecounter2> <input
	type="hidden" name="pageNo" id="pageNo" value="<%=pageNo%>" /> <label>Main
Charge:</label> <select id="mainChargeCodeId" name="<%=MAIN_CHARGECODE_ID %>"
	onchange="populateSubChargeCodeForBilling(this.value,'ipBilling');">
	<option value="0">Select</option>
	<%
				for(MasMainChargecode mainChargecode : mainChargeCodeList){
			%>
	<option value="<%=mainChargecode.getId() %>"><%=mainChargecode.getMainChargecodeName() %></option>
	<%}%>
</select> <label>Sub Charge:</label> <select id="subChargeCodeId"
	name="<%=SUB_CHARGECODE_ID %>">
	<option value="0">Select</option>
	<%
				for(MasSubChargecode subChargecode : subChargeCodeList){
			%>
	<option value="<%=subChargecode.getId() %>"><%=subChargecode.getSubChargecodeName() %></option>
	<%}%>
</select> <script type="text/javascript">
		<%
			int counter1 = 0;
			for (MasMainChargecode mainChargecode : mainChargeCodeList)
			{
				for (MasSubChargecode subChargecode : subChargeCodeList) 
				{
					if(subChargecode.getMainChargecode() != null){
						if(mainChargecode.getId().equals(subChargecode.getMainChargecode().getId() )){
								%>
									subChargeCodeArray[<%=counter1%>] = new Array();
									subChargeCodeArray[<%=counter1%>][0]=<%=mainChargecode.getId()%>;
									subChargeCodeArray[<%=counter1%>][1] = <%=subChargecode.getId()%>;									
									subChargeCodeArray[<%=counter1%>][2] = "<%=subChargecode.getSubChargecodeName()%>";
								<%
								counter1++;
						}
					}
				}
			}
			
		%>
		</script> <script type="text/javascript">
		var amtArray = new Array();
		<%
			int count = 0;
					for (MasChargeCode masChargeCode : chargeCodeList)
					{
					%>
									amtArray[<%=count%>] = new Array();
									amtArray[<%=count%>][0]=<%=masChargeCode.getId()%>;
									amtArray[<%=count%>][1] = <%=masChargeCode.getCharge()%>;									
								
								<%
								count++;
					}
		%>
		</script> <input type="hidden" size="2" value="" name="noOfRecords"
	id="noOfRecords" />
<div class="division"></div>


<div class="tableHholderCmnLarge">

<table width="100%" border="0" cellpadding="0" cellspacing="0"
	id="chargeDetails" colspan="7">
	<tr>
		<th>SR No</th>
		<th width="18%">Charge Code</th>
		<th width="22%">Qty</th>
		<th width="18%">Rate</th>
		<th width="18%">Amount</th>
		<th width="18%">Discount Amount</th>
		<th width="18%">Net Amount</th>
	</tr>

	<%
    	int detailCounter=8; 
    	int temp=0;
    	int inc = 0;    	
    	if(pageNo!=1)
    	{
    		temp=detailCounter*(pageNo-1);
    	} 
    	for(inc=1;inc<=8;inc++){
    	%>

	<tr>

		<td><input type="text" size="2" value="<%=temp+inc%>"
			name="<%=SR_NO%>" readonly="readonly" /></td>
		<td><input type="text" align="right" name="chargeCode<%=inc%>"
			id="chargeCode<%=inc%>" onfocus="clearAllFields(<%=inc %>);"
			onblur="if(fillSrNo('<%=inc %>')){checkForChargeCode(this.value, '<%=inc %>');}"
			tabindex="1" />
		<div id="ac2update" style="display: none;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				function eventCallback(element, entry){
					return entry + "&mainChargeCodeId=" + document.getElementById('mainChargeCodeId').value+"&subChargeCodeId="+document.getElementById('subChargeCodeId').value; 
				}
			    new Ajax.Autocompleter('chargeCode<%=inc%>','ac2update','billing?method=getChargeCode',{parameters:'requiredField=chargeCode<%=inc%>', callback: eventCallback});
			  
			</script></td>
		<td><input type="hidden" value=""
			name="<%=CHARGE_CODE_ID%><%=inc%>" id="chargeCodeId<%=inc %>" /> <input
			type="text" class="filled" id="qty<%=inc%>"
			name="<%=QUANTITY %><%=inc%>" value="" validate="Qty,int,no"
			onchange="calculateNetAmount('ipBilling',<%=inc %>);calculateTotalAmt('ipBilling');"
			maxlength="4" readonly="readonly" tabindex="1" /></td>
		<td><input type="text" value="" class="filled" id="rate<%=inc%>"
			name="<%=RATE%><%=inc%>" validate="Rate,float,no" maxlength="12"
			readonly="readonly" /></td>
		<td><input type="text" value="" class="filled"
			id="amount<%=inc%>" name="<%=AMOUNT%><%=inc%>"
			validate="Amount,float,no" maxlength="12" readonly="readonly" /></td>
		<td><input type="text" value="" class="filled"
			id="disamount<%=inc%>" name="<%=DISCOUNT %><%=inc%>"
			validate="Discount,int,no"
			onchange="if(checkDiscountAmt(<%=inc %>)){calculateNetAmount('ipBilling',<%=inc %>);calculateTotalAmt('ipBilling')};"
			maxlength="12" readonly="readonly" tabindex="1" /></td>
		<td><input type="text" value="" class="filled"
			id="netamount<%=inc%>" name="<%=NET_AMOUNT %><%=inc%>"
			validate="Net Amount,float,no" maxlength="12" readonly="readonly" />

		</td>

	</tr>

	<%} %>
	<input type="hidden" value="<%=chargeSlipMainId %>"
		name="chargeSlipMainId" id="chargeSlipMainId" />

</table>
</div>
<div class="Clear"></div>
<label>Total Amt</label>
<div class="paddLeft300"><input type="text" class="filled"
	id="totalAmtId" name="<%=TOTAL_AMOUNT %>" readOnly /></div>
<div class="paddLeft25"><input type="text" class="filled"
	id="totalDisId" name="<%=DISCOUNT_AMOUNT %>" readOnly /></div>
<div class="paddLeft25"><input type="text" class="filled"
	id="totalNetId" name="<%=BILL_AMOUNT %>" readOnly /></div>

<input type="hidden" name="counter" id="counter" value="<%=inc %>" />
<div class="division"></div>

<div class="bottom"><input type="button" class="button"
	value="Next"
	onclick="if(checkForNext()){submitForm('ipBilling','billing?method=submitBillingDetails&buttonFlag=next');}"
	align="right" /> <input type="button" class="button" value="Submit"
	onclick="if(checkFilledRow()){submitForm('ipBilling','billing?method=submitBillingDetails');}"
	align="right" /> <input type="reset" class="button" value="Reset" /> <input
	type="hidden" name="rows" id="rr" value="1" /></div>
<% }else{%> No Record Found!! <%} %>
<div class="division"></div>

<script type="text/javascript">

function checkForNext(){
	  if(document.getElementById('noOfRecords').value<8)
	  {
	  	alert("All rows are not filled.");
	  	return false;
	  }else{
	  	var msg ="";
	  	var count = document.getElementById('noOfRecords').value;
	  	for(var i=1;i<=count;i++){
	  	 	if(document.getElementById('chargeCode'+i).value != ""){
	  			if(document.getElementById('qty'+i).value == ""){
	  				msg += "Quantity can not be blank.\n";
	  			}
	  			if(document.getElementById('amount'+i).value == ""){
	  				msg += "Amount can not be blank.\n";
	  			}
	  			if(document.getElementById('netamount'+i).value == ""){
	  				msg += "Net Amount can not be blank.\n";
	  			}
	  			if(msg != ""){
	  				break;
	  			}
	  			
	  			}
	  		}
	  		if(msg != ""){
	  			alert(msg)
	  			return false;
	  		}else
	  			return true;
	  }
  }

function fillSrNo(rowVal){

	if(document.getElementById('chargeCode'+rowVal).value != ""){
		var pageNo=parseInt(document.getElementById('noOfRecords').value);
  			rowVal=rowVal%8
  		if(rowVal==0){
  			rowVal=8
  	 	}
  		if(!(parseInt(document.getElementById('noOfRecords').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRecords').value=rowVal
			}
	}else if(document.getElementById('chargeCode'+rowVal).value == "" ){
		if(document.getElementById('noOfRecords').value > 0){
			document.getElementById('noOfRecords').value = parseInt(document.getElementById('noOfRecords').value)-1;
		}
	}
		return true;
}


function checkForChargeCode(val,inc){

	if(val != "" && val !="No Items found")
	{
		var index1 = val.lastIndexOf("[");
	    var indexForChargeCode = index1;
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var chargeId = val.substring(index1,index2);
	    var indexForChargeCode = indexForChargeCode--;
	    var chargeName = val.substring(0,indexForChargeCode);
	   
	   	if(chargeId =="")
	    {
	     document.getElementById('amount'+inc).value="";
	  	 document.getElementById('disamount'+inc).value="";
	  	 document.getElementById('netamount'+inc).value="";
	  	 document.getElementById('rate'+inc).value = "";
	  	 document.getElementById('qty'+inc).value="";
	     clearAllFields(inc);
	  
	     return;
	    }
	    
	    var inc1 = document.getElementById('counter').value;
	     for(i=1;i<inc1;i++){
	     if(inc != 1){
	        if(document.getElementById('chargeCode'+i).value==val && inc != i)
	        {
	    		alert("Charge Code already selected...!")
	    		document.getElementById('chargeCode'+inc).value=""
	    		var e=eval(document.getElementById('chargeCode'+inc)); 
	    		e.focus();
	    	  return false;
	        }
	      }  
	   }
		ajaxFunctionForAutoCompleteChargeCode('ipBilling','billing?method=fillItemsForChargeCode&chargeName=' +  chargeName , inc);
		
		
		document.getElementById('qty'+inc).className = "";
	  	document.getElementById('disamount'+inc).className = "";
	    
	}else{
	 	var tAmt = 0;
	  	var dAmt = 0;
	  	var nAmt = 0;
	  	
	  	var amt = document.getElementById('amount'+inc).value;
	  	var disamount = document.getElementById('disamount'+inc).value;
	  	var netamount = document.getElementById('netamount'+inc).value;
	  	var totalAmt = document.getElementById('totalAmtId').value;
	  	var totalDisamount = document.getElementById('totalDisId').value;
	  	var totalNetamount = document.getElementById('totalNetId').value;
	  	
	  	if(amt == "" && totalAmt == "" && totalAmt == 0){
	  		tAmt = tAmt;
	  	}else{
	  		tAmt = parseInt(totalAmt);
	  	}
	  
	  	if(disamount == "" && totalDisamount == "" && totalDisamount ==0){
	  		dAmt = dAmt;
	  	}else{
	  		dAmt = parseInt(totalDisamount);
	  	}
	  
	  	if(netamount == "" && totalNetamount == "" && totalNetamount == 0){
	  		alert("asdasd")
	  		nAmt = nAmt;
	  	}else{
	  		nAmt = parseInt(totalNetamount);
	  	}
	  
	  	document.getElementById('totalAmtId').value=tAmt;
	  	document.getElementById('totalDisId').value=dAmt;
	  	document.getElementById('totalNetId').value=nAmt;
	  	
	  	document.getElementById('amount'+inc).value="";
	  	document.getElementById('disamount'+inc).value="";
	  	document.getElementById('netamount'+inc).value="";
	  	document.getElementById('rate'+inc).value = "";
	  	document.getElementById('qty'+inc).value="";
	  
	  	
	  	document.getElementById('qty'+inc).readOnly = true;
        document.getElementById('disamount'+inc).readOnly = true;
	  	
	  	document.getElementById('qty'+inc).className = "filled";
	    document.getElementById('disamount'+inc).className = "filled";
	  		  	
	  }
	  
}

function checkDiscountAmt(inc){
		var amtObj = document.getElementById('netamount'+inc).value;
		var disAmtObj = document.getElementById('disamount'+inc).value;
		if(parseInt(amtObj) < parseInt(disAmtObj)){
			 alert("Discount Amount should be less than Net Amount.");
			 
			 if(document.getElementById('totalDisId').value !=""){
			 	document.getElementById('totalDisId').value = parseInt(document.getElementById('totalDisId').value);
			 }else{
			 	document.getElementById('totalDisId').value = "";
			 } 
			 document.getElementById('disamount'+inc).value = "";
			return false;
		}
		return true;
}

function checkFilledRow(){

	var msg ="";
	if(document.getElementById('noOfRecords').value==0 || document.getElementById('noOfRecords').value ==""){
	  	alert("Please fill atleast one row to submit.");
	  	return false;
	  }else{
	  	var count = document.getElementById('noOfRecords').value;
	  	for(var i=1;i<=count;i++){
	  	 	if(document.getElementById('chargeCode'+i).value != ""){
	  			if(document.getElementById('qty'+i).value == ""){
	  				msg += "Quantity can not be blank.\n";
	  			}
	  			if(document.getElementById('amount'+i).value == ""){
	  				msg += "Amount can not be blank.\n";
	  			}
	  			if(document.getElementById('netamount'+i).value == ""){
	  				msg += "Net Amount can not be blank.\n";
	  			}
	  			if(msg != ""){
	  				break;
	  			}
	  		}
	  	}
	  	if(msg != ""){
	  		alert(msg)
	  		return false;
	  	}else{
	  		return true;
	  	}
	  }

}

function clearAllFields(inc){

	var amount = document.getElementById('amount'+inc).value
	var totalAmt = document.getElementById('totalAmtId').value;
	var disAmount = document.getElementById('disamount'+inc).value
	var totalDisAmt = document.getElementById('totalDisId').value;
	var netAmount = document.getElementById('netamount'+inc).value
	var totalNetAmt = document.getElementById('totalNetId').value;
	
	if(inc != 1){
		if(totalAmt != "" ){
			totalAmt = totalAmt-amount;
			document.getElementById('totalAmtId').value = totalAmt;
		}
		if(totalDisAmt != ""){
			totalDisAmt = totalDisAmt-disAmount;
			document.getElementById('totalDisId').value = totalDisAmt;
		}
		if(totalNetAmt != ""){
			totalNetAmt = totalNetAmt-netAmount;
			document.getElementById('totalNetId').value = totalNetAmt;
		}
	}else{
		document.getElementById('totalAmtId').value = "0";
		document.getElementById('totalDisId').value = "0";
		document.getElementById('totalNetId').value = "0";
	}


}

</script></form>
</div>
