<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.FaMasAccountGroup"%>
<%@page import="jkt.hms.masters.business.FaMasAccountSubGroup"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>
<%@page import="jkt.hms.masters.business.FaVoucherDetails"%>
<%@page import="jkt.hms.masters.business.FaVoucherHeader"%>
<%@page import="jkt.hms.masters.business.MasApprovalStatus"%>
<%@page import="jkt.hms.masters.business.FaMasSubLed"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.MasCostCenter"%>
<%@page import="jkt.hms.masters.business.FaMasNarration"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/sorttableAccounts.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>


<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasApprovalStatus> approvalStatusList = new ArrayList<MasApprovalStatus>();
	List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
	List<FaVoucherDetails> voucherDetailList = new ArrayList<FaVoucherDetails>();
	List<FaVoucherHeader> voucherHeader = new ArrayList<FaVoucherHeader>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}

	if(map.get("costCenterList") != null){
		costCenterList = (List<MasCostCenter>)map.get("costCenterList");
	}
	
	 if(map.get("voucherDetailList") != null){
		 voucherDetailList = (List<FaVoucherDetails>)map.get("voucherDetailList");
		}
	 
	 if(map.get("voucherHeader") != null){
		 voucherHeader = (List<FaVoucherHeader>)map.get("voucherHeader");
		}
	
	
	if(map.get("approvalStatusList") != null){
		approvalStatusList = (List<MasApprovalStatus>)map.get("approvalStatusList");
		}
	
	String message = "";
	if(map.get("message") != null){
		message = (String)map.get("message");
		%>
<h4><span><%=message %></span></h4>
	<%}
%>
<div class="cear"></div>

<div class="paddingTop15"></div>
<div class="division"></div>
<div class="titleBg">
<h4>Journal Voucher Approval</h4>
</div>
<div class="clear"></div>
<form name="journalVoucher" method="post" action="">
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>

<%if(voucherHeader.size()>0){
	for(FaVoucherHeader header: voucherHeader){%>
<label>Voucher Date<span>*</span></label>
<input readonly type="text" tabindex="1" name="<%=VOUCHER_DATE %>" id="voucherDate" value="<%=HMSUtil.convertDateToStringTypeDateOnly(header.getVoucherDate())%>" />
<input type="hidden" value="<%=header.getId()%>" name="voucherHeaderId" id="voucherHeaderId" />
<%}}%>

<div class="clear"></div>
</div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<div class="cmntable">
<table width="100%" border="0" cellspacing="0" cellpadding="0"	name="voucherDetails" id="voucherDetails" class="cmntable">
	<tr id="th">
		<th scope="col"></th>
		<th scope="col"></th>
		<th scope="col">Account</th>
		<th scope="col">S L</th>
		<th scope="col">Narration</th>
		<th scope="col">Dr</th>
		<th scope="col">Cr</th>
		<th scope="col">&nbsp;</th>
	</tr>

	<%int i = 1;%>
	<%if(voucherDetailList.size()>0){
		 for(FaVoucherDetails list : voucherDetailList){%>
	<tr id="<%=list.getId()%>">
	<td><input type="radio" value="" name="selectedChrage" class="radiobutMargin" /></td>
	 <td width="4"><select id="drcr<%=list.getId() %>" name="drCr<%=list.getId()  %>" class="smallest"  tabindex=1 >
	 <%if(list.getCrAmount()!=null && list.getDrAmount()==null){%>
	 <option value="cr">Cr</option>
	 <%}else if(list.getDrAmount()!=null && list.getCrAmount()==null){%>
		<option value="dr">Dr</option>
		<%}%>
		</select></td>
	<td> <input readonly id="accountNameId<%=list.getId()%>" type="text" size="30"  name="accountName<%=list.getId()%>" value="<%=list.getAccount().getAccDesc() %>" validate="Account,string,yes" tabindex=1  /></td>
	<td id="slId<%=i %>"> 
	<input  type="text"  readonly="readonly" name="subledgerId<%=list.getId()%>" id="subledgerId<%=list.getId()%>" value="<%=list.getSubLed()!=null?list.getSubLed().getSubLedDesc():"" %>" size="12" />
	</td>
	<td> 
	<input id="accountNarrationId<%=list.getId()%>" type="text" size="18" class="large"  name="accountNarrationId<%=list.getId()%>" value="<%=list.getNarration()!=null?list.getNarration():"" %>"  MAXLENGTH="100" tabindex=1 />
	</td>
<%if(list.getDrAmount()!=null){ %>
	<td> <input id="drAmountId<%=list.getId() %>" type="text"  size="10" name="<%=DR_AMOUNT%><%=list.getId()%>" value="<%=list.getDrAmount()!=null?list.getDrAmount():"" %>" validate="DrAmount,float,no"   onblur="totalDrCrAmount('dr','voucherDetails');" onkeypress="return numCheck();" MAXLENGTH="12" tabindex=1 /></td>
<%} else{%>
	<td> <input readonly id="drAmountId<%=list.getId() %>" type="text"  size="10" name="<%=DR_AMOUNT%><%=list.getId()%>" value="<%=list.getDrAmount()!=null?list.getDrAmount():"" %>" validate="DrAmount,float,no"   onblur="totalDrCrAmount('dr','voucherDetails');" onkeypress="return numCheck();" MAXLENGTH="12" tabindex=1 /></td>
<%}if(list.getCrAmount()!=null){%>
<td> <input id="crAmountId<%=list.getId() %>" type="text"  size="10" name="<%=CR_AMOUNT%><%=list.getId()%>" value="<%=list.getCrAmount()!=null?list.getCrAmount():"" %>" validate="CrAmount,float,no" onblur="totalDrCrAmount('cr','voucherDetails');"   onkeypress="return numCheck();" MAXLENGTH="12" tabindex=1 /></td>
<%}else{ %>
<td> <input readonly id="crAmountId<%=list.getId() %>" type="text"  size="10" name="<%=CR_AMOUNT%><%=list.getId()%>" value="<%=list.getCrAmount()!=null?list.getCrAmount():"" %>" validate="CrAmount,float,no" onblur="totalDrCrAmount('cr','voucherDetails');"   onkeypress="return numCheck();" MAXLENGTH="12" tabindex=1 /></td>
<%} %>
	
	</tr>
	<%}} %>
	</table>
	<table>
	<tr class="background">
		<td colspan=6 class="right">Total</td>
		<%if(voucherHeader.size()>0){
		for(FaVoucherHeader header: voucherHeader){%>
		<td><input id="totalDrAmountId" type="text" size="10" class="readOnlySmall" readonly="readonly" name="<%=TOTAL_DR_AMOUNT %>" value="<%=header.getDrAmount()!=null?header.getDrAmount():"" %>" validate="Total DrAmount,float,yes"   MAXLENGTH="15" tabindex=1 /></td>
		<td colspan=2><input id="totalCrAmountId" size="10" type="text" class="readOnly" readonly="readonly" name="<%=TOTAL_CR_AMOUNT %>" value="<%=header.getCrAmount()!=null?header.getCrAmount():"" %>" validate="Total CrAmount,float,yes"   MAXLENGTH="15" tabindex=1 /></td>
		<%}}%>
	</tr>
	</table>
	</div>
	<div class="clear"></div>

<input type="hidden" value="<%=i%>" name="hiddenValueCharge" id="hiddenValueCharge" />
<input type="hidden" id="tableRowId" name="tableRowId" value="1" />
<input type="hidden" value="flagOP" name="flagValueOP" id="flagValueOP" />

<div class="clear"></div>
<div class="clear"></div>
<div class="Block">

<div class="paddingTop40"></div>
<div class="clear"></div>
<%if(voucherHeader.size()>0){
		for(FaVoucherHeader header: voucherHeader){%>
<label>Narration<span>*</span></label>
<input id="voucherNarrationId" type="text" name="<%=NARRATION %>" value="<%=header.getNarration() %>" class="extraLarge" MAXLENGTH="190" tabindex=1 />
<%}}%>
<div class="clear"></div>
<label>Approval Status<span>*</span></label> 
		<select name="ApprovalStatusId" validate="Approval Status,int,yes" id="ApprovalStatusId" tabindex="1" >
			<option value="0">Select</option>
			
			<% for (MasApprovalStatus masApprovalStatus : approvalStatusList) {
			if(masApprovalStatus.getStatusCode().equalsIgnoreCase("AP") || masApprovalStatus.getStatusCode().equalsIgnoreCase("RJ")){%>
			<option value="<%=masApprovalStatus.getId()%>"><%=masApprovalStatus.getStatusName()%></option>
			<%}}%>
		</select>
<div class="clear"></div>


<div class="clear"></div></div>
<div class="clear"></div>
<input type="button" name="save" id="addbutton" value="Submit" class="button" onClick="if(checkTotalAmount()){submitForm('journalVoucher','account?method=submitJournalVoucherApproval','validateNarration','validateTotalDrCr');}" accesskey="a" tabindex=1 />


  <div class="clear"></div>
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName %> </label>

<label>Changed Date</label>
<label class="value"><%=date%></label>
<label>Changed Time</label>
 <label class="value"><%=time%></label>
  <input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName %>" />
   <input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
    <input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>



<div class="clear"></div>
<div class="clear"></div>

<script type="text/javascript">



function validateAccountName( strValue,inc,tdid ) {

 	if(strValue != "")
	{

 			var idx1 = strValue.lastIndexOf("[");
			var idx2 = strValue.lastIndexOf("]");
		   	var accountName = strValue.substring(0,idx1);
		   	
		    var id = strValue.substring(idx1+1,idx2);
		    
			if(id != ""){
				for(i=1;i<inc;i++){
					if(inc != 1){
						if(document.getElementById('accountNameId'+i)!=null){
							var charge =document.getElementById('accountNameId'+i).value;
					
							var idx1 = charge.lastIndexOf("[");
				    		var idx2 = charge.lastIndexOf("]");
				   			 idx1++;
				    		var chargeCode = charge.substring(idx1,idx2);
							//alert("Before=="+chargeCode);	
							if(chargeCode == id)
							{
								alert("Account Name already selected...!")
								document.getElementById('accountNameId'+inc).value=""
								var e=eval(document.getElementById('chargeCode'+inc));
								e.focus();
								return false;
							}
						}
					}
				}
			}
		
	
		    if(id!="")
		    {
		    	submitProtoAjaxWithDivName('journalVoucher','account?method=getSubLedgerForAccount&accName='+encodeURIComponent(strValue)+'&rowVal='+inc,tdid+inc);
		    }
	}
	
}


function validateNarration(){
var errMsg = "";
	var vNarrationId = document.getElementById('voucherNarrationId').value;
	var voucherDate = document.getElementById('voucherDate').value;


	if(voucherDate == ""){
		errMsg += "Voucher Date can not be blank.\n";
	}
	if(vNarrationId == ""){
		errMsg += "Voucher Narration can not be blank.\n";
	}
	if(errMsg != ""){
		alert(errMsg);
		return false;
	}

	return true;
}

	function totalDrCrAmount(amttype,tableId){
		
		var j= $j("#"+tableId+" tr:last").attr("id");	
		if(j == "th")
		{
			
		}
	else
		{
			j=j*1;
			
		}
		  var valRowId = new Array();
			$j("#"+tableId+" tr[id!='th']").each(function(j)
					{				
						valRowId[j] =$j(this).attr("id");
					});
			$j("#tableRowId").val(valRowId);	
		
		
		var totalCrAmt =0;
		var totalDrAmt =0;
		for(i=0; i<=valRowId.length-1; i++){
			var cramount = 0;
			var dramount = 0;
			if(amttype == "cr"){
				if(document.getElementById('crAmountId'+valRowId[i]).value != "" ){
					cramount = document.getElementById('crAmountId'+valRowId[i]).value;
					totalCrAmt = parseFloat(totalCrAmt)+parseFloat(cramount);
				}
			}else if(amttype == "dr"){
				if(document.getElementById('drAmountId'+valRowId[i]).value != "" ){
					dramount = document.getElementById('drAmountId'+valRowId[i]).value;
					totalDrAmt = parseFloat(totalDrAmt)+parseFloat(dramount);
				}
			}
		}
		if(totalCrAmt != "0")
			document.getElementById('totalCrAmountId').value = totalCrAmt;
		if(totalDrAmt != "0")
			document.getElementById('totalDrAmountId').value = totalDrAmt;
	}

function changeField(val,inc){
        var crChangeAmt = 0;
        var drChangeAmt = 0;
        if(val == 'dr'){
            if(document.getElementById('crAmountId'+inc).value != "" ){
                crChangeAmt = document.getElementById('crAmountId'+inc).value;
            }
            
            document.getElementById('drAmountId'+inc).disabled = false;
            document.getElementById('crAmountId'+inc).disabled = true;
            document.getElementById('crAmountId'+inc).value = "";
        }else if(val == 'cr'){
            if(document.getElementById('drAmountId'+inc).value != "" ){
                drChangeAmt = document.getElementById('drAmountId'+inc).value;
            }
            
            document.getElementById('crAmountId'+inc).disabled = false;
            document.getElementById('drAmountId'+inc).disabled = true;
            document.getElementById('drAmountId'+inc).value = "";
        }
        var totalCrAmt = 0;
        var totalDrAmt = 0;
        if(document.getElementById('totalCrAmountId').value!='')
            totalCrAmt = document.getElementById('totalCrAmountId').value;
        if(document.getElementById('totalDrAmountId').value!='')
            totalDrAmt = document.getElementById('totalDrAmountId').value;
        
        if(totalCrAmt != "0")
            document.getElementById('totalCrAmountId').value = parseFloat(totalCrAmt)-parseFloat(crChangeAmt);
        if(totalDrAmt != "0")
            document.getElementById('totalDrAmountId').value = parseFloat(totalDrAmt)-parseFloat(drChangeAmt);

    }
	function validateAmount(){
		var count = 0;var drCrId;
		count = document.getElementById('hiddenValueCharge').value;
		for(i=1; i<=count; i++){
		drCrId = document.getElementById('drCr'+i).value;
		if(drCrId==dr){
			if(document.getElementById('drAmountId'+i).value == "" ){
				errMsg += "Dr Amount can not be blank.\n";
			}
		}else{
			if(document.getElementById('crAmountId'+i).value == "" ){
				errMsg += "Cr Amount can not be blank.\n";
			}

		}
	}
	}
	function validateTotalDrCr(){
		var j= $j("#voucherDetails tr:last").attr("id");	
		if(j == "th")
		{
			
		}
	else
		{
			j=j*1;
			
		}
		  var valRowId = new Array();
			$j("#voucherDetails tr[id!='th']").each(function(j)
					{				
						valRowId[j] =$j(this).attr("id");
					});
			$j("#tableRowId").val(valRowId);
		var drTotal = document.getElementById('totalDrAmountId').value;
		var crTotal = document.getElementById('totalCrAmountId').value;
		if(parseFloat(drTotal) != parseFloat(crTotal)){
			alert("Total of Dr and Cr amount should be Equal.");
			return false;
		}
		return true;
	}

	
	function numCheck(){
		if((event.charCode >= 48 && event.charCode <= 57)==true){
			return (event.charCode >= 48 && event.charCode <= 57);
		}else{
			alert("Please Enter Number");
			return false;
	}
		};
		
		
		function checkTotalAmount(){
			var totalDrAmountId = document.getElementById('totalDrAmountId').value;
			var totalCrAmountId = document.getElementById('totalCrAmountId').value;
			
			if(totalDrAmountId==totalCrAmountId){
				return true;
			}else{
				alert("Credit amount must be equal to Debit amount");
				return false;
			}
		}
</script>


</form>