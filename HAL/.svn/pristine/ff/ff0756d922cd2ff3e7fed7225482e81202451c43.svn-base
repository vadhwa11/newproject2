

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Closing/Cancelling SO</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<%
Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}

%>
<form name="closeCancelSO" method="post">
<div id="contentHolder">
<%
String message=  "";
if(map.get("message") != null){
	message = (String)map.get("message") ;
	%>
	<label class="noWidth"><span><%=message %></span></label>
	<%
}%>

<h6>Closing/Cancelling SO</h6>
<div class="Clear"></div>

<!--Block One Starts-->
<div class="blockTitle">Search</div><div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="blockFrame">
<label>S.O. Number</label>
<input name="soNumber" id="soNumber" type="text" value="" onblur="getDetails(this.value);"/>
<div id="ac2update" style="display:none; border:1px solid black; padding-right: 450px; background-color:white;"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
  new Ajax.Autocompleter('soNumber','ac2update','purchaseOrder?method=getSupplyOrderNoAutocomplete',{parameters:'requiredField=soNumber'});
</script>
<div class="Clear"></div>
</div>
<!--Block one Ends-->
<div class="division"></div>
<!--Block Two Starts-->
<div id="testDiv">
</div>


</div>
<script type="text/javascript">
function getDetails(soNo){
	if(soNo!=""){
		submitProtoAjax('closeCancelSO','/hms/hms/purchaseOrder?method=getSODetails&soNumber='+soNo)
	}
}
function checkForCancelation(rowCount)
{
var msg='';
for(var i=1;i<=rowCount;i++){
if(document.getElementById('poDetailsId'+i)!=null && document.getElementById('poDetailsId'+i).checked==true){
   	if(parseFloat(document.getElementById('receivedQty'+i).value)>0){
	 document.getElementById('poDetailsId'+i).checked=false ;
	 msg='You Cannot Cancel The Item Whose Qty is Received';
	 alert(msg);
	 return false;
	}
} 
 
}
return true;
}
function checkForClose(rowCount)
{
var msg='';
for(var i=1;i<=rowCount;i++){
if(document.getElementById('poDetailsId'+i)!=null && document.getElementById('poDetailsId'+i).checked==true){
   	if((parseFloat(document.getElementById('receivedQty'+i).value)) >= (parseFloat(document.getElementById('orderedQty'+i).value))){
	 document.getElementById('poDetailsId'+i).checked=false ;
	 msg='You Cannot Close The Item Whose Qty is Received';
	 alert(msg);
	 return false;
	}
} 
 
}
return true;
}
</script>
</form>


