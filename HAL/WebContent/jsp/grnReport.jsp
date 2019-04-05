
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.MasManufacturer"%>

<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.StoreGrnM"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<StoreGrnM> crvNumberList = new ArrayList<StoreGrnM>();
	
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if(map.get("crvNumberList")!=null){
		crvNumberList =(List) map.get("crvNumberList");
		
	}
%>
<script type="text/javascript" language="javascript">
function crvValidationcheck(flag){

var grnNo = document.getElementById('GRNNO').value;
 if(grnNo != ""){
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
	   	   var sli  = item.getElementsByTagName("SLIStatus")[0];
	       if(sli.childNodes[0].nodeValue == 'YES'){
	      
	       if(flag == "CRV Report"){
	       submitForm('grnReport','stores?method=generateCrvReport&flag=crv');
	       }
	        if(flag == "Contingent Bill"){
	        submitForm('grnReport','stores?method=generateCrvReport&flag=contingentBill');
	       }
	        if(flag == "Proforma B"){
	        submitForm('grnReport','stores?method=generateCrvReport&flag=proformaB');
	       }
	        if(flag == "Barcode"){
	        submitForm('grnReport','stores?method=generateCrvReport&flag=barcode');
	       }
	         if(flag == "LPO"){
	         submitForm('grnReport','stores?method=generateCrvReport&flag=LPO');
	       }
	       
	        }else if(sli.childNodes[0].nodeValue == 'NO'){
	           if(flag == "CRV Report"){
	             submitForm('grnReport','stores?method=generateCrvReport&flag=pcrv');
	           }else{
	             alert("Ledger action is pending for this CRV !!!"); 
	           }
	           
	        return false;
	       }
	   } 
      }
    }
   
   var url="/hms/hms/stores?method=findGrnLedgeraction&grnNo="+grnNo
     
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
   }
  
  }
  </script>
<div id="contentspace">
<form name="grnReport" id=grnReport method="post" action=""	target="_blank">
<div class="Block">
<div class="Clear"></div>
<div class="blockTitle">CRV REPORT</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="paddingTop5"></div>
<div class="Clear"></div>
<div style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 68%; float: left; height: 15%; background-color: #f4f9fe;">
<br>
<label class="bodytextB">CRV No : </label>
<input type="text"
	name="<%=GRN_NO%>"
	value="<%=crvNumberList.size()>0?crvNumberList.get(crvNumberList.size()-1).getGrnNo():""%>"
	class="bigcaption" tabindex=1 MAXLENGTH="30" id="GRNNO" />
<div id="ac3update"
	style="display: none; padding-right: 550px; background-color: white;"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('GRNNO','ac3update','stores?method=getGrnNoListForAutoCompleteForReports',{parameters:'requiredField=<%=GRN_NO%>'});
</script>
<div class="clear"></div>
<br>
</div>
<div class="clear"></div>

<div class="clear"></div>
<div id="contentHolder">
<input type="hidden" name="add"	id="addbutton" value="CRV Report" class="button"
		    onClick="crvValidationcheck(this.value);" accesskey="g" tabindex=1 /> 
<input	type="button" name="add" id="addbutton" value="Contingent Bill"	class="button" 
			onClick="crvValidationcheck(this.value);" accesskey="c" tabindex=1 /> 
<input type="button" name="add"	id="addbutton" value="Proforma B" class="button"
	        onClick="crvValidationcheck(this.value);" accesskey="p" tabindex=1 />
<input	type="hidden" name="add" id="addbutton" value="Barcode"
	     class="button" onClick="crvValidationcheck(this.value);"	accesskey="b" tabindex=1 />
<input type="button" name="add"	id="addbutton" value="LPO" class="button"
	onClick="crvValidationcheck(this.value);" accesskey="b" tabindex=1 />
</div>
</div>
</form>
</div>






