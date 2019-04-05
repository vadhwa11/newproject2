<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>


<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<%@page import="java.net.URL"%>
<%
	 	Box box = HMSUtil.getBox(request);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	%>

<div class="titleBg">
<h2>Supply Order Report</h2>
</div>
<form name="supplierOrderPrint" target="_blank" action="" method="post">
<div class="Block">
<div class="clear"></div>
<label>Supply Order No</label> 
<input type="text" id="SoNFrom" name=<%=SUPPLYNOFROM%> value="" class="textbox_date" MAXLENGTH="30" /> 
<label>Department Type</label> 
<select name="storetype" id="storetype">
<option value="">-Select Department-</option>
<option value="e">Expendable Store</option>
<option value="h">ECHS</option>
</select>
<div class="clear"></div>

<input type="text" name="test" disabled id="test"
	value="Note: (SupplyOrder no Formate should be like this ---> '144/09-10')"
	style="height: 20px; width: 400px; background-color: #D5DDE6; Border: none; font-weight: bold; font-size: 10px; color: red;">
</div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="OK" value="OK"
	class="button" onClick="showReport();" /> <input type="reset"
	name="Reset" id="reset" value="Reset" class="button"
	onclick="resetCurrentValues();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

</form>

<script type="text/javascript" language="javascript">
	
function Confirmation(){
  var soNo = document.getElementById('SoNFrom').value
  var dept= document.getElementById('storetype').value
  if(soNo != ""){
  var xmlHttp;
  try {
    // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
  }catch (e){
    // Internet Explorer
    try{
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }catch (e){
    	alert(e)
      try{
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
      }catch (e){
        alert("Your browser does not support AJAX!");
        return false;
      }
     }
   }
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){
    
      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	   
	  	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	   	    
	       var stp  = item.getElementsByTagName("STPStatus")[0];
	      
	      if(stp.childNodes[0].nodeValue == 'YES'){
	        
	        supplierOrderPrint.method="post";
            submitForm('supplierOrderPrint','tender?method=generateSupplyOrderPrintReport');
            
	      }else if(stp.childNodes[0].nodeValue == 'NO'){
	      alert("No data Found for this search criteria!!!!");
	      return false;
	      }
	    //   document.getElementById("employeeName").value=empName.childNodes[0].nodeValue
	       
	   } 
      }
    }
   
   var url="/hms/hms/tender?method=getconfirmation&soNo="+soNo+"&dept="+dept
     
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
   }
}	



	function showReport()
 {
 	var sono = document.getElementById('SoNFrom').value
 	
 	var storetype = document.getElementById('storetype').value
 	
 	var errmsg = "";
 	if(sono.length == 0){
 	errmsg = errmsg + "\n Please enter SupplyOrder no!!!"
 	}
 	if(storetype.length == 0){
 	errmsg = errmsg + "\n Select the department type!!!"
 	}
 	if(errmsg.length > 0){
 	alert(errmsg);
 	return false;
 	}
 	if(Confirmation()){
 	//submitForm('diagnosisWise','stores?method=generatePendingSupplierOrderReport','validateFromToDate');"
 	// supplierOrderPrint.method="post";
   //  submitForm('supplierOrderPrint','tender?method=generateSupplyOrderPrintReport');
    } 
}
</script>