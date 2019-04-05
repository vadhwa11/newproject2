<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
	<script>
<%

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
<%

Map<String, Object> map = new HashMap<String, Object>();
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
List<StoreItemBatchStock> batchWiseList = new ArrayList<StoreItemBatchStock>();
		
if(map.get("batchWiseList")!=null){
	batchWiseList = (List<StoreItemBatchStock>)map.get("batchWiseList");
}
String message = "";
if(map.get("message")!=null){
	message = (String)map.get("message");
}
%>
<h4><%=message %></h4>

<form name="updateBatchNoSearch" method="post" >
<div class="clear"></div>
<div class="titleBg">
<h2>Update Batch No.</h2>
</div>
<div class="Block">
<label>PVMS/NIV No. </label>
<input type="text"	value="" id="pvmsNo"  name="pvmsNo" validate="PVMS/NIV NO.,alphanumeric1,no" tabindex="1"/> 
<label>Nomenclature </label> 
<input type="text" value="" id="nomenclature" name="nomenclature" onblur="if(this.value!=''){displayPVMSBatch(this.value);}" tabindex="1"/>
<div id="ac2update" style="display: none; " class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
if(validateMetaCharacters(this.value))
{
new Ajax.Autocompleter('nomenclature','ac2update','stores?method=getItemListForBINCardByAutocomplete',{parameters:'requiredField=nomenclature'})};
</script> 
<input type="hidden" name="itemId" id="itemId" value="0">
<label>Batch No.</label>
<div id="testDiv">
<select name="batchId" tabindex="1">
<option value="">Select</option>
</select>
</div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="search" onClick="submitForm('updateBatchNoSearch','/hms/hms/stores?method=getItemDetailsToUpdate');" value="search" class="button">
<input type="reset" name="Reset" id="reset" value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
</form>
<div class="clear"></div>
<div class="division"></div>

<form name="updateBatchNo" method="post" >
<% if(batchWiseList.size() >0){ %>
<div id="pageNavPosition"></div>
<div class="cmntable">
<div class="Clear"></div>
<table  width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th>Sl No.</th>
		<th>PVMS No.</th>
		<th>Nomenclature</th>
		<th>Batch No.</th>
		<th colspan="2">Expiry Date</th>
		<th>Stock</th>
		
	</tr>
		<tbody id="tableData">
<%
	int i=1;
	for(StoreItemBatchStock batchStock : batchWiseList){
		%>
		<tr>
		<td><%=i %></td>
		<td><%=batchStock.getItem().getPvmsNo() %></td>
		<td><%=batchStock.getItem().getNomenclature() %>
		<input type="hidden" name="itemId<%=i %>" value="<%=batchStock.getItem().getId() %>" readonly="readonly"/>
		</td>
		<td><input type="text" name="batchNo<%=i %>" id="batchNo<%=i %>" value="<%=batchStock.getBatchNo() %>" size="15"/>
		<input type="hidden" name="batchId<%=i %>" value="<%=batchStock.getId() %>" readonly="readonly"/>
		</td>
		<td><input type="text" name="expiryDate<%=i %>" value="<%= batchStock.getExpiryDate()!=null?HMSUtil.convertDateToStringWithoutTime(batchStock.getExpiryDate()):"" %>" size="15"/>
		</td>
		<td><img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
	onclick="setdate('',document.updateBatchNo.expiryDate<%=i %>,event);" />
</td>
		<td><%=batchStock.getClosingStock() %></td>
		
		</tr>
	<%i++;}
%>
</tbody>
</table>
<input type="hidden" name="counter" id="counter" value="<%=i-1 %>">
</div>
<script>
		var pager = new Pager('tableData',20);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);
	  </script>
	  
<input type="button" name="update" class="button" value="Update" onclick="if(checkRows()){submitForm('updateBatchNo','/hms/hms/stores?method=updateBatchAndExpiryDate')}">
	<%}else{ %>
	<h4>No Records Found</h4>
	
	<%} %>

<div class="clear"></div>

</form>
<script>
function checkRows(){
	var cnt = document.getElementById('counter').value;
	if(cnt > 0){
		for(var i=1;i<=cnt;i++){
			if(document.getElementById('batchNo'+i).value == ""){
				alert("Batch No. can not be blank.");
				return false;
				
			}
		}
	}
	return true;
}

function displayPVMSBatch(itemName){

    var index1 = itemName.lastIndexOf("[");
    var index2 = itemName.lastIndexOf("]");
    var index3 = itemName.lastIndexOf("(");
    var index4 = itemName.lastIndexOf(")");
    index1++;
    index3++;
    var item = itemName.substring(0,index1-1);
    var itemId = itemName.substring(index1,index2);
    var itempvms=itemName.substring(index3,index4);
    if(itemId!=null)
    	document.getElementById("itemId").value=itemId;
    else
    	document.getElementById("itemId").value=0;  
    if(itempvms!=null)
    	document.getElementById("pvmsNo").value=itempvms;
    else
    	document.getElementById("pvmsNo").value=0;  

    if(document.getElementById("itemId").value!=0)
		submitProtoAjax('updateBatchNoSearch','/hms/hms/stores?method=getItemBatch');

}
</script>