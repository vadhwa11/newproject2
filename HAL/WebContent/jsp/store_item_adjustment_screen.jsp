<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*" %>
<%@page import="jkt.hms.masters.business.MasStoreItem" %>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock" %>
<%@page import="jkt.hms.masters.business.MasDepartment" %>
<%@page import="jkt.hms.masters.business.MasEmployee" %>
<%@page import="jkt.hms.util.Box" %> 
<%@page import="jkt.hms.util.HMSUtil" %>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script>
<%

	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date1=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date1.length()<2){
		date1="0"+date1;
	}
	String currentDate = date1+"/"+month1+"/"+year1 ;
%>
	serverdate = '<%=date1+"/"+month1+"/"+year1%>'
	
	function fillValuesForPvms(pvmsNo,rowVal){
    //alert("In fillValuesForPvms----- "+document.getElementById('nameItem'+rowVal).value)
   document.getElementById('nameItem'+rowVal).value="";
   document.getElementById('idAu'+rowVal).value="";
    	//ajaxFunctionForAutoCompleteIssueToDispensaryByPvmsNo('adjustment','stores?method=fillItemsForIssueToDispensaryByPvmsNo&pvmsNo=' +  pvmsNo , rowVal);
        ajaxFunctionForAutoCompleteForAdjustment('adjustment','stores?method=fillItemsForAdjustmentByPvmsNo&pvmsNo=' +  pvmsNo , rowVal);
    
    }
    
   function pvmsNomenclatureSearch() 
   {
		var pvmsNo1=document.getElementById("pvmsNo1").value;
		//var ValueOfPage=document.getElementById("page").value;
		var ValueOfPage=1;
		//var pageNo =parseInt(document.getElementById('pageNo').value) 
		var pageNo = 1 ;
		submitForm('issueGrid','stores?method=updateNextOrSubmitIssueToCiv&buttonName=goToPage&ValueOfPage='+ValueOfPage+'&pvmsSearch='+pvmsNo1+'');
   }
  
function fillSrNo(rowVal){

	var pageNo=parseInt(document.getElementById('noOfRows').value);
   		rowVal=rowVal%8
   		if(rowVal==0){
   			rowVal=8
   	 		}
   		if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRows').value=rowVal
			}
	return true;
}

function goPage()
{
var page = parseInt(document.getElementById('page').value);
var totalPages = parseInt(document.getElementById('totalPages').value);
if (page > totalPages)
{
alert('Kindly provide valid Page No!...');
document.getElementById('page').value="";
return;
}

submitForm('issueGrid','stores?method=updateNextOrSubmitIssueToCiv&buttonName=goToPage');
}

function goNext()
{
if (checkDateForIssueCiv()&&checkDateForIssueCiv()) 
{
	var pvmsNo1=document.getElementById("pvmsNo1").value;
	var ValueOfPage=document.getElementById("page").value;
	submitForm('issueGrid','stores?method=updateNextOrSubmitIssueToCiv&buttonName=next&pvmsSearch='+pvmsNo1+'');
}
}


function goRefresh()
{
var issueUnit = document.getElementById('issueId').value;
submitForm('adjustment','stores?method=searchIssueCiv&issueUnit='+issueUnit);
}
function checkForIssueToDispensary(val,a,inc)
	{
		//var pageNo =parseInt(document.getElementById('pageNo').value) 
		var pageNo=1;
		var start=((pageNo-1)*20)+1;
    	var end=((pageNo-1)*20)+20;
    	
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	    for(i=start;i<=end;i++){
	    if(pvms ==""){
	    	document.getElementById('nameItem'+inc).value=""
	    	
	    	return ;
	    	}
	   }
	
		ajaxFunctionForAutoCompleteForAdjustment('adjustment','stores?method=fillItemsForAdjustmentByPvmsNo&pvmsNo=' +  pvms , inc);
}	
</script>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	String userName="";
	String date="";
	String time="";
	String deptName="";
	String entrySeqNo="" ;
	List<MasStoreItem> masStoreItem = new ArrayList<MasStoreItem>();
	List<StoreItemBatchStock> storeItemBatchStock = new ArrayList<StoreItemBatchStock>();
	List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>(); 
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	if(map.get("deptName")!=null){
		deptName=(String)map.get("deptName");
	}
	if(map.get("masStoreItem")!=null){
		masStoreItem=(List<MasStoreItem>)map.get("masStoreItem");
	}
	if(map.get("storeItemBatchStock")!=null){
		storeItemBatchStock=(List<StoreItemBatchStock>)map.get("storeItemBatchStock");
	}
	if(map.get("masEmployeeList")!=null){
		masEmployeeList=(List<MasEmployee>)map.get("masEmployeeList");
	}
	if(map.get("entrySeqNo")!=null){
		entrySeqNo=(String)map.get("entrySeqNo");
	}
	Box box=HMSUtil.getBox(request);
	
%>
<div id="ContentHolder" >
<h6>Adjustment Screen For Item In Stock </h6>
<form name="adjustment" method="post">
<input type="hidden" value="0" name="noOfRows" id="noOfRows" />
<input type="hidden" value="" name="issueId" id="issueId" />
<div class="Clear"></div>
<div class="blockTitle">Adjustment Details</div><div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<label>Adjustment No. :- </label>
<input name="adjustmentNo" id = " adjustmentNo " value="<%=entrySeqNo %>" readonly="readonly" />
<label><span>*</span>Adjustment Date :-</label>
<input name="adjustmentDate" id = "adjustmentDate" value="<%=currentDate %>" tabindex="1" readonly="readonly" validate="Adjustment Date,date,yes"/>
<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=date1%>',document.adjustment.adjustmentDate,event)" />
<div class="Clear"></div>
<label>Department Name :- </label>
<input name="adjustmentDept" id="adjustmentDept" value="<%=deptName %>" readonly="readonly"/>
<label><span>*</span>Authority Name :-</label>
<select name="adjustmentAuthority" id="adjustmentAuthority" validate="Authority Name ,string ,yes" tabindex="2"   >
<option value="0">Select</option>
<% if(masEmployeeList != null){
   StringBuilder name = null ;
   for(MasEmployee masEmployee : masEmployeeList){	
   name = new StringBuilder("");
   if(masEmployee.getFirstName() != null){
	   name.append(masEmployee.getFirstName());
   }
   if(masEmployee.getMiddleName() != null){
	   name.append(masEmployee.getMiddleName());
   }
   if(masEmployee.getLastName() != null){
	   name.append(masEmployee.getLastName());
   }
   
%>
<option value="<%=masEmployee.getId() %>"><%=name %></option>
<%}} %>

</select>
<div class="Clear"></div>
<label>Remarks :-</label>
<textarea rows="5" cols="20" name="adjustmentRemarks" id="adjustmentRemarks" tabindex="3"   style="width:300px;" ></textarea>
</div>
<div class="Clear"></div>
<div class="blockTitle">Item Details</div><div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="tableHholderCmnLarge2">
<table colspan="7" id="indentDetails"  cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<th width="5%">SR No.</th>
			<th width="13%">PVMS No.</th>
			<th width="10%">Nomenclature</th>
			<th width="13%">A/U</th>
			<th width="13%">Type</th>
			<th width="13%">Expiry Date</th>
			<th width="6%">Batch No.</th>
			<th width="13%">Closing Stock </th>
			<th width="6%">Qty Adjusted</th>
			
		</tr>

	</thead>
	<tbody>
	<%
	int temp=0;
	int inc=((1-1)*20)+1;
	String codeItem="codeItem";
	String idItem="idItem";
	String nameItem="nameItem";
	String idAu="idAu";
	String adjustmentType="adjustmentType";
	String itemBatchNoCombo="itemBatchNoCombo";
	String itemBatchNoText="itemBatchNoText";
	String itemExpiryDate="itemExpiryDate";
	String itemClosingStock ="itemClosingStock";
	String adjustmentQty="adjustmentQty";
	String itemExpiryDateNew="itemExpiryDateNew";
	String itemBrandId ="itemBrandId";
	
	String codeItem2="codeItem";
	String idItem2="idItem";
	String nameItem2="nameItem";
	String idAu2="idAu";
	String adjustmentType2="adjustmentType";
	String itemBatchNoCombo2="itemBatchNoCombo";
	String itemBatchNoText2="itemBatchNoText";
	String itemExpiryDate2="itemExpiryDate";
	String itemClosingStock2 ="itemClosingStock";
	String adjustmentQty2="adjustmentQty";
	String itemExpiryDateNew2 = "itemExpiryDateNew";
	String itemBrandId2 ="itemBrandId";
	while(inc <= 20){
	
		idItem=idItem2+(""+inc);
 		codeItem=codeItem2+(""+inc);
 		nameItem=nameItem2+(""+inc);
 		idAu=idAu2+(""+inc);
 		adjustmentType=adjustmentType2+(""+inc);
 		itemBatchNoCombo=itemBatchNoCombo2+(""+inc);
 		itemBatchNoText=itemBatchNoText2+(""+inc);
 		adjustmentQty=adjustmentQty2+(""+inc);
 		itemExpiryDate=itemExpiryDate2 +(""+inc);
 		itemClosingStock = itemClosingStock2 +("" +inc);
 		itemExpiryDateNew = itemExpiryDateNew2 +("" + inc);
 		itemBrandId = itemBrandId2 +(""+inc);
	%>
	<tr>
			<td width="5%">
			<input type="text" size="2" value="<%=temp+inc%>" name="<%=RequestConstants.SR_NO%>" readonly="readonly" />
			</td>
			<td width="10%">
			<input type="text" tabindex="4"	name="<%=RequestConstants.ITEM_CODE%>" value="" id="<%=codeItem%>"	onblur="removePreviousData(<%=inc %>);fillValuesForPvms(this.value,'<%=inc %>')" />
			<input	type="hidden" size="2" value="0" name="<%=RequestConstants.ITEM_ID%>" id="<%=idItem%>" />
			<input	type="hidden" size="2" value="0" name="itemBrandId" id="<%=itemBrandId%>" />
			</td>
			<td width="17%">
			<input type="text" value="" tabindex="4"  tabindex="1"id="<%=nameItem%>" size="40" onblur="if(fillSrNo('<%=inc %>')){removePreviousData(<%=inc %>);checkForIssueToDispensary(this.value, '<%=nameItem%>','<%=inc %>');}" name="<%=nameItem%>" />
			<div id="ac2update"	style="display: none;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=nameItem%>','ac2update','stores?method=getItemListForIssueToDispensary',{parameters:'requiredField=<%=nameItem%>' });
			</script>
			</td>
			<td width="10%">
			<input type="text"	name="<%=RequestConstants.AV%>" value="" readonly="readonly" id="<%=idAu%>" style="width:30px;" />
			</td>
			<td width="10%">
			<select name="adjustmentType" id="<%=adjustmentType%>" style="width:100px;" tabindex="5" onchange="changeOfNewAndExisting(<%=inc %>);">
			<option value="Existing">Existing</option>
			<option value="New">New</option>
			</select>
			</td>
			<td>
			<input type="text"	name="itemExpiryDate" value=""  readonly="readonly" id="<%=itemExpiryDate%>" style="width:100px;" />
			<img id="calendar<%=inc %>"	src="/hms/jsp/images/cal.gif"  width="16" height="16" border="0" style="display:none;"	validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=date1%>',document.adjustment.<%=itemExpiryDate%>,event)" />
			</td>
			<td width="10%">
			<select name="itemBatchNoCombo" id="<%=itemBatchNoCombo%>" style="width:100px;" tabindex="7" onchange="updateClosingStock(<%=inc%>);">
			<option value="0">Select</option>
			</select>
			<input type="text" name="itemBatchNoText" id="<%=itemBatchNoText%>" tabindex="7" value="" style="width:100px;display:none;"  />
			</td>
			<td>
			<select name="itemClosingStock" id="<%=itemClosingStock%>"  style="width:80px;" disabled="disabled" />
			<option value="0">Select</option>
			</select>
			</td>
			<td width="10%">
			<input type="text"  value="" name="adjustmentQty" tabindex="8" id="<%= adjustmentQty %>" tabindex="1" style="width:80px;" onblur="validationForAdjustmentQty(<%=inc %>);" />
			</td>
			
		</tr>
		<% inc++ ; 
	}
		%>
		</tbody>
		</table>
		</div>
		<div class="division"></div>
		<input class="cmnButton" type="button" tabindex="9"  name="adjust" value="Adjust" onclick="submitForm('adjustment','stores?method=updateItemForAdjustment');" />
		<div class="division"></div>
		<script type="text/javascript"><!--
		function updateClosingStock(rowVal){
		if(checkForSameBatchOfSameItem(rowVal)){
		var indexNumber =document.getElementById('itemBatchNoCombo'+rowVal).selectedIndex
		document.getElementById('itemClosingStock'+rowVal).selectedIndex=indexNumber ;
		}
		}
		function checkForSameBatchOfSameItem(rowVal){
		var itemId= document.getElementById("idItem"+rowVal).value ;
		var itemType = document.getElementById("adjustmentType"+rowVal).value ;
		var itemBatchNo;
		if(itemType=='New'){
			itemBatchNo = document.getElementById("itemBatchNoText"+rowVal).value ;
		}else{
			 itemBatchNo = document.getElementById("itemBatchNoCombo"+rowVal).value ;
		}
		var objItemId = document.getElementsByName('itemId');
		var cbjItemType = document.getElementsByName('adjustmentType');
		var objItemBatchNoText =document.getElementsByName('itemBatchNoText');
		var objItemBatchNoCombo =document.getElementsByName('itemBatchNoCombo');
		for(i=0;i<20;i++){
		if(!objItemId[i].value=='' && !objItemId[i].value=='0'){
		    if(objItemId[i].value == itemId && objItemBatchNoCombo[i].value == itemBatchNo && cbjItemType[i].value ==itemType && rowVal != (i+1)){
		    alert("You Cannot Select Same Batch Number For Same Item ");
		    document.getElementById('itemBatchNoCombo'+rowVal).selectedIndex = 0 ;
		    return false ; 
		    }
		}
		}
		return true ;
		}
		
		function changeOfNewAndExisting(rowVal){
		var type= document.getElementById('adjustmentType'+rowVal).value;
		if(type=='New'){
		document.getElementById('calendar'+rowVal).style.display="inline";
		
		document.getElementById('itemBatchNoText'+rowVal).style.display="inline";
		document.getElementById('itemBatchNoCombo'+rowVal).style.display="none";
		document.getElementById('itemClosingStock'+rowVal).selectedIndex=0 ;
		}else{
		document.getElementById('calendar'+rowVal).style.display="none";
		
		document.getElementById('itemBatchNoCombo'+rowVal).style.display="inline";
		document.getElementById('itemBatchNoText'+rowVal).style.display="none";
		document.getElementById('itemClosingStock'+rowVal).selectedIndex=document.getElementById('itemBatchNoCombo'+rowVal).selectedIndex ;
		}
		
		}
		
		function validationForAdjustmentQty(rowVal){
		if(document.getElementById('adjustmentQty'+rowVal).value!=""){
		var msg="";
		msg = validateWholeNumber(document.getElementById('adjustmentQty'+rowVal).value);
		var adjustmentType=document.getElementById('adjustmentType'+rowVal).value;
		if(adjustmentType=='New'){
			if(document.getElementById('itemExpiryDate'+rowVal).value==''){
			msg +='Expiry Date Can not blank'+'\n';
			}
			if(document.getElementById('itemBatchNoText'+rowVal).value==''){
			msg +='Batch No. Cannot be Blank' +'\n'; 
			}
			var adjustedQty = parseInt(document.getElementById('adjustmentQty'+rowVal).value);
			if(adjustedQty < 0){
			msg='Adjusted Qty Cannot Be Negative For New Item'+'\n'
			}
		}
		if(adjustmentType == 'Existing'){
			if(document.getElementById('itemBatchNoCombo'+rowVal).value=='0'){
			msg='Select the Batch No . '+'\n' ;
			}else{
			var closingStock = parseInt(document.getElementById('itemClosingStock'+rowVal).value);
			var adjustedQty = parseInt(document.getElementById('adjustmentQty'+rowVal).value);
			var adjustment = closingStock + adjustedQty ;
			if(adjustment <0){
			msg ='Adjustment is not Valid '+'\n';
			}
			}
		
		}
		if(msg !=""){
		alert(msg);
		document.getElementById('adjustmentQty'+rowVal).value ="";
		return false ;
		}
		}
		
		return true ;
		
		}
		function removePreviousData(rowVal){
		document.getElementById('itemBatchNoCombo'+rowVal).selectedIndex = 0;
		document.getElementById('itemClosingStock'+rowVal).selectedIndex = 0;
		document.getElementById('itemExpiryDate'+rowVal).value="";
		var batchNumber=document.getElementById('itemBatchNoCombo'+rowVal);
		var closingStock = document.getElementById('itemClosingStock'+rowVal);
		for(i=1 ; batchNumber.length > 1 ;++i){
		batchNumber.remove(1);
		}
		for(j=1 ;closingStock.length > 1 ;j++){
		closingStock.remove(1);
		}
		document.getElementById('itemBatchNoCombo'+rowVal).focus();
		}
		function validateWholeNumber(str){
				str = alltrim(str);
				valid = /^[-+]?[0-9]+(\.[0-9]+)?$/.test(str);
			    if(!valid){
			    return 'InValid Number'+'\n' ;
			    }
			    return '';
		}
		function alltrim(str) {
			return str.replace(/^\s+|\s+$/g, '');
		}
		
		--></script>
</form>
</div>
