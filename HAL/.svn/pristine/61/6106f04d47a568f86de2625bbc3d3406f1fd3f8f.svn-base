<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.FaMasAccountGroup"%>
<%@page import="jkt.hms.masters.business.FaMasAccountSubGroup"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>
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
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>

<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>


<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
	List<FaMasNarration> narrationList = new ArrayList<FaMasNarration>();
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
	if(map.get("narrationList") != null){
		narrationList = (List<FaMasNarration>)map.get("narrationList");
	}
	int voucherNo = 0;
	if(map.get("voucherNo") != null){
		voucherNo = (Integer)map.get("voucherNo");
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
<h4>Journal Voucher</h4>
</div>
<div class="clear"></div>
<form name="journalVoucher" method="post" action="">
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<%--<label>Voucher No<span>*</span></label> --%>
 <input id="voucherNoId" type="hidden" readonly="readonly" size="5" name="<%=VOUCHER_NO%>" value="<%= voucherNo %>"  validate="Voucher No,string,no" MAXLENGTH="8"  tabindex=1 />

<label>Voucher Date<span>*</span></label>
<input type="text" tabindex="1" class="calDate" name="<%=VOUCHER_DATE%>" id="voucherDate" value="<%=date%>" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'fromDate');" maxlength="10" size="7"/>


<div class="clear"></div>
</div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<div class="cmntable">
<table width="100%" border="0" cellspacing="0" cellpadding="0"	id="voucherDetails" class="cmntable">
	<tr>
		<th scope="col"></th>
		<th scope="col" width="4"></th>
		<th scope="col">Account</th>
		<th scope="col">S L</th>
		<%--<th scope="col">CostCenter</th> --%>
		<th scope="col">Narration</th>
		<th scope="col">Dr</th>
		<th scope="col">Cr</th>
		<th scope="col">&nbsp;</th>
	</tr>

	<%int i = 1;%>
	<tr>
	<td><input type="radio" value="" name="selectedChrage" class="radiobutMargin" /></td>
	<td width="4"><select id="drcr<%=i %>" name="drCr<%=i  %>" class="smallest" onchange="changeField(this.value,<%=i %>);" validate="DrCr,string,yes" tabindex=1 >
		<option value="dr">Dr</option>
		<option value="cr">Cr</option>
		</select></td>
	<td> <input id="accountNameId<%=i%>" type="text" size="30"  name="accountName<%=i%>" value="" validate="Account,string,yes" tabindex=1 onblur="validateAccountName(this.value,<%=i %>,'slId')" />
	<script type="text/javascript">
	document.getElementById('accountNameId<%=i%>').focus();
</script>
		<div id="ac2update<%=i%>" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
		function eventCallBack(element,entry){
			return entry + "&salesVoucherType=journal";
		}
			  	new Ajax.Autocompleter('accountNameId<%=i%>','ac2update<%=i%>','account?method=getAccountCodeForAutoComplete',{parameters:'requiredField=accountName<%=i%>',callback:eventCallBack});
			</script></td>
			
		<%-- 	<td> 	<input type="text" value=""	id="nameItem<%=inc %>" validate='Nomenclature ,String,yes' onblur="checkForPurchase(this.value, 'nameItem','<%=inc %>');" name="nameItem<%=inc %>" tabindex="1" size="50" />
		<div id="ac2update" style="display:none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">

	    new Ajax.Autocompleter('nameItem<%=inc %>','ac2update','purchaseOrder?method=getItemListForPurchaseOrder',{parameters:'requiredField=nameItem<%=inc %>&poId='+document.getElementById('poId').value })
	    

		</script>
		</td>  --%>
		
	<td id="slId<%=i %>"> <input  type="text"  readonly="readonly" name="<%=SUB_LEDGER_CODE_BANK%><%=i%>" value="" size="12" /></td>
	<%--<td><select id="costCenterId<%=i %>"  name="<%=COST_CENTER_ID %><%=i%>"  class="small" tabindex=1 validate="Cost Center,string,no" >
	<option value="0">Select</option>
	<%if(costCenterList.size()>0){
		for(MasCostCenter costCenter:costCenterList){
		%>
		<option value="<%=costCenter.getId() %>"><%=costCenter.getCostCenterName() %></option>
	<%}
		}%>
</select></td> --%>
	<td> <input id="accountNarrationId<%=i %>" type="text" size="18" class="large"  name="<%=ACCOUNT_NARRATION%><%=i%>" value=""  MAXLENGTH="100" tabindex=1 />
	<div id="ac2update<%=i%>" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  	new Ajax.Autocompleter('accountNarrationId<%=i%>','ac2update<%=i%>','account?method=getAccountNarrationForAutoComplete',{parameters:'requiredField=<%=ACCOUNT_NARRATION%><%=i%>'});
			</script>
	<input type="button" name="add"  value="" class="buttonAdd" onClick="addAccountsNarrationInAjax('journalVoucher',<%=i %>);" />
	</td>

	<td> <input id="drAmountId<%=i %>" type="text"  size="10" name="<%=DR_AMOUNT%><%=i%>" value="" validate="DrAmount,float,no"   onblur="totalDrCrAmount('dr');" onkeypress="return numCheck();" MAXLENGTH="8" tabindex=1 /></td>
	<td> <input id="crAmountId<%=i %>" type="text"  size="10" name="<%=CR_AMOUNT%><%=i%>" value="" disabled="disabled" validate="CrAmount,float,no" onblur="totalDrCrAmount('cr');"   onkeypress="return numCheck();" MAXLENGTH="8" tabindex=1 /></td>
	<td><input type="button" name="add" value="" class="buttonAdd" onclick="addRow();" tabindex="1" /></td>
	</tr>
	<tr class="background">
		<td colspan=6 class="right">Total</td>
		<td><input id="totalDrAmountId" type="text" size="10" class="readOnlySmall" readonly="readonly" name="<%=TOTAL_DR_AMOUNT %>" value="" validate="Total DrAmount,float,yes"   MAXLENGTH="15" tabindex=1 /></td>
		<td colspan=2><input id="totalCrAmountId" size="10" type="text" class="readOnly" readonly="readonly" name="<%=TOTAL_CR_AMOUNT %>" value="" validate="Total CrAmount,float,yes"   MAXLENGTH="15" tabindex=1 /></td>
	</tr>
	</table>
	</div>
	<div class="clear"></div>
<input type="button" name="delete" class="buttonDel" onClick="removeRow();" />
<input type="hidden" value="<%=i%>" name="hiddenValueCharge" id="hiddenValueCharge" />
<input type="hidden" value="flagOP" name="flagValueOP" id="flagValueOP" />

<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
<%-- <div class="floatRight">
	<label>Total </label>
	<label class="auto">Dr</label>
	<input id="totalDrAmountId" type="text" class="readOnlySmall" readonly="readonly" name="<%=TOTAL_DR_AMOUNT %>" value=""   MAXLENGTH="15" tabindex=1 />

	<label class="auto">Cr</label>
	<input id="totalCrAmountId" type="text" class="readOnly" readonly="readonly" name="<%=TOTAL_CR_AMOUNT %>" value=""  MAXLENGTH="15" tabindex=1 />
	</div> --%>
<div class="paddingTop40"></div>
<div class="clear"></div>
<label><span>*</span>Narration</label>
<input id="voucherNarrationId" type="text" name="<%=NARRATION %>" value="" class="extraLarge" MAXLENGTH="190" tabindex=1 />

<div id="ac2update" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  	new Ajax.Autocompleter('voucherNarrationId','ac2update','account?method=getNarrationForAutoComplete',{parameters:'requiredField=<%=NARRATION %>'});
			</script>

<input type="button" name="add"  value="Add To Template" class="buttonBig" onClick="addNarrationInAjax('journalVoucher');" accesskey="a" tabindex=1 />
<div class="clear"></div></div>
<div class="clear"></div>
<input type="button" name="save" id="addbutton" value="Submit" class="button" onClick="submitForm('journalVoucher','account?method=submitJournalVoucher','validateNarration','validateTotalDrCr');" accesskey="a" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="button" onclick="resetCheck();" accesskey="r" />

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
var costCenterArray =new Array();
</script>
<%  int j=0;

for(MasCostCenter masCostCenter:costCenterList){
%>
<script>
			costCenterArray[<%=j%>]= new Array();
			costCenterArray[<%=j%>][0] = "<%=masCostCenter.getId()%>";
			costCenterArray[<%=j%>][1] = "<%=masCostCenter.getCostCenterName()%>";

		</script>
<%j++;} %>
<script type="text/javascript">
function addRow(){
	var tbl = document.getElementById('voucherDetails');
	var lastRow = tbl.rows.length-1;

	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hiddenValueCharge');
	var iteration = parseInt(hdb.value)+1;
	hdb.value = iteration;



	var cell0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'radio';
	e0.name='selectedChrage';
	e0.className='radioAuto';
	e0.value=(iteration);
	cell0.appendChild(e0);

	var cell1 = row.insertCell(1);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Dr', 'dr','selected');
	e1.options[1] = new Option('Cr', 'cr');
	e1.name="drCr"+iteration;
	e1.focus();
	e1.id ="drCr"+iteration;
 	e1.setAttribute('validate','DrCr,string,yes');
	e1.className='smallest';
	e1.tabIndex='1';
	e1.onchange=function(){changeField(this.value,iteration);};
	cell1.appendChild(e1);

	var cell2 = row.insertCell(2);
	var e2 = document.createElement('input');
	e2.type = 'text';
	e2.onblur=function(){
						validateAccountName(this.value,(iteration),'slId');
			  };
	e2.name = 'accountName'+ (iteration);
	e2.id = 'accountNameId' + (iteration);
	e2.tabIndex='1';
   	cell2.appendChild(e2);
   	e2.setAttribute('validate','Account,string,yes');
	
	var newdiv = document.createElement('div');
   	newdiv.setAttribute('id', 'ac2update'+iteration);
   	newdiv.style.display = 'none';
   	newdiv.className = 'autocomplete';
    cell2.appendChild(newdiv);
	e2.size = '30';
  	new Ajax.Autocompleter('accountNameId'+ (iteration),'ac2update'+iteration,'account?method=getAccountCodeForAutoComplete',{parameters:'requiredField=accountName'+ (iteration),callback:eventCallBack});


	var cell3 = row.insertCell(3);
	cell3.id='slId'+(iteration);
	var e3 = document.createElement('input');
	e3.type = 'text';
	e3.name='<%=SUB_LEDGER_CODE_BANK%>'+ (iteration);
	e3.id = 'subLedgerId'+(iteration)
	e3.readOnly = true;
	e3.size='12';
	cell3.appendChild(e3);


<%-- 	var cell4 = row.insertCell(4);
	var e4 = document.createElement('select');
	e4.name='<%=COST_CENTER_ID%>'+ (iteration);
	e4.id='costCenterId'+(iteration);
	e4.options[0] = new Option('Select', '0');
	for(var k = 0;k<costCenterArray.length;k++){
		e4.options[k+1] = new Option(costCenterArray[k][1],costCenterArray[k][0]);
	}
	e4.tabIndex='1';
	e4.className='small';
	cell4.appendChild(e4);
 --%>
	var cell4 = row.insertCell(4);
	var e4 = document.createElement('input');
	e4.type = 'text';
	e4.name='<%=ACCOUNT_NARRATION%>'+ (iteration);
	e4.id='accountNarrationId'+(iteration);
	e4.size='18';
	e4.tabIndex='1';
	var newdiv = document.createElement('div');
   	newdiv.setAttribute('id', 'ac2update'+iteration);
   	newdiv.style.display = 'none';
   	newdiv.className = "autocomplete";
  	cell4.appendChild(e4);
    cell4.appendChild(newdiv);
  	new Ajax.Autocompleter('accountNarrationId'+ (iteration),'ac2update'+iteration,'account?method=getAccountNarrationForAutoComplete',{parameters:'requiredField=<%=ACCOUNT_NARRATION%>'+ (iteration)});

	var e41 = document.createElement('input');
	e41.type = 'button';
	e41.name='add';
	e41.className = 'buttonAdd';
	e41.onclick = function(){
					addAccountsNarrationInAjax('journalVoucher', (iteration));

	}
	cell4.appendChild(e41);

	var cell5 = row.insertCell(5);
	var e5 = document.createElement('input');
	e5.type = 'text';
	e5.name='<%=DR_AMOUNT%>'+ (iteration);
	e5.id='drAmountId'+(iteration);
	e5.setAttribute('validate','Dr Amount,float,no');
	e5.onblur = function(){
				totalDrCrAmount('dr');
	}
	e5.onkeypress = function(){
		return numCheck();
	}
	e5.size="10";
	e5.tabIndex="1";
	e5.maxLength='8';
	cell5.appendChild(e5);

	var cell6 = row.insertCell(6);
	var e6 = document.createElement('input');
	e6.type = 'text';
	e6.name='<%=CR_AMOUNT%>'+ (iteration);
	e6.id='crAmountId'+(iteration);
	e6.setAttribute('validate','Cr Amount,float,no');
	e6.onblur = function(){
				totalDrCrAmount('cr');;
	}
	e6.onkeypress = function(){
		return numCheck();
	}
	e6.disabled = true;
	e6.size="10";
	e6.tabIndex="1";
	e6.maxLength='8';
	cell6.appendChild(e6);

	var cell7 = row.insertCell(7);
	var e7 = document.createElement('input');
	e7.type = 'button';
	e7.name='add';
	e7.className = 'buttonAdd';
	e7.tabIndex="1";
	e7.onclick = function(){
					addRow();
	}

	cell7.appendChild(e7);
}
function removeRow(){
	var tbl = document.getElementById('voucherDetails');
	 var tblRows  = tbl.getElementsByTagName("tr");

 	if(tblRows.length-3==0){
        	alert("Can not delete all rows")
        	return false;
    }
 	var count = 0;
	count = document.getElementById('hiddenValueCharge').value;
	var totalCrAmt =0;
	var totalDrAmt =0;
	var amttype = "";
	for(counter=0;counter<document.getElementsByName('selectedChrage').length;counter++)
	{
		if (document.getElementsByName('selectedChrage')[counter].checked == true)
		{
		  	tbl.deleteRow(counter+1);

		}
	}
	for(i=1; i<=count; i++){
		var cramount = 0;
		var dramount = 0;
			if(document.getElementById('crAmountId'+i) && document.getElementById('crAmountId'+i).value != "" ){
				cramount = document.getElementById('crAmountId'+i).value;
				totalCrAmt = parseFloat(totalCrAmt)+parseFloat(cramount);
			}
		
			if(document.getElementById('drAmountId'+i) && document.getElementById('drAmountId'+i).value != "" ){
				dramount = document.getElementById('drAmountId'+i).value;
				totalDrAmt = parseFloat(totalDrAmt)+parseFloat(dramount);
			}
		
	}
	document.getElementById('totalCrAmountId').value = totalCrAmt;
	document.getElementById('totalDrAmountId').value = totalDrAmt;
}
function validateAccountName( strValue,inc,tdid ) {

 	if(strValue != "")
	{

 			var idx1 = strValue.lastIndexOf("[");
			var idx2 = strValue.lastIndexOf("]");
		   	var accountName = strValue.substring(0,idx1);
		   	//alert(accountName)
		   	//alert("idx1 -- "+idx1);
			//alert("idx2--- "+idx2)
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
		
		//	idx1++;
			//var id = strValue.substring(idx1,idx2);
		    if(id!="")
		    {
		    	submitProtoAjaxWithDivNameWithoutFormData('journalVoucher','account?method=getSubLedgerForAccount&accName='+encodeURIComponent(strValue)+'&rowVal='+inc,tdid+inc);
		    }
	}
	
}


function validateNarration(){
var errMsg = "";
	var vNarrationId = document.getElementById('voucherNarrationId').value;
	var voucherNoId = document.getElementById('voucherNoId').value;
	var voucherDate = document.getElementById('voucherDate').value;

/* 	if(voucherNoId == 0){
		errMsg += "Voucher No can not be blank.\n";
	} */
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

	function totalDrCrAmount(amttype)
	{
		var count = 0;
		count = document.getElementById('hiddenValueCharge').value;
		var totalCrAmt =0;
		var totalDrAmt =0;
		for(i=1; i<=count; i++){
			var cramount = 0;
			var dramount = 0;
			if(amttype == "cr"){
				if(document.getElementById('crAmountId'+i).value != "" ){
					cramount = document.getElementById('crAmountId'+i).value;
					totalCrAmt = parseFloat(totalCrAmt)+parseFloat(cramount);
				}
			}else if(amttype == "dr"){
				if(document.getElementById('drAmountId'+i).value != "" ){
					dramount = document.getElementById('drAmountId'+i).value;
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
</script>


</form>