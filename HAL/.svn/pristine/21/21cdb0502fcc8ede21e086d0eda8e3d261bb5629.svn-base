<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<script type="text/javascript">
	function autocompleteBasedOnPvms(val)
	{
			ajaxFunctionForAutoCompleteMedcineMaster('barcodeGerator','stores?method=fillItemsCommon&pvmsNo=' + val);
	}
	</script>
	<script type="text/javascript">
	function ajaxFunctionForAutoCompleteMedcineMaster(formName,action) 
	{
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
	    var url=action
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	    xmlHttp.onreadystatechange=function()
	    {
	      if(xmlHttp.readyState==4){
	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	
	      	for (loop = 0; loop < items.childNodes.length; loop++) 
	      	{
		   	    var item = items.childNodes[loop];
		        var id  = item.getElementsByTagName("id")[0];
		        var pvms  = item.getElementsByTagName("pvms")[0];
		        var name  = item.getElementsByTagName("name")[0];
		    	document.getElementById('nomenclature1').value = name.childNodes[0].nodeValue +"[" + id.childNodes[0].nodeValue + "]" +"(" + pvms.childNodes[0].nodeValue + ")" 	
		    	document.getElementById('pvmsNo').value = id.childNodes[0].nodeValue
	      }
	    }
	  }
	}	
	</script>




<div id="contentHolder"><script type="text/javascript"
	language="javascript">
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}	
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>
<div class="titleBg">
<h2>Bar Code Label Generation</h2>
</div>
<div class="Clear"></div>
<form name="barcodeGerator" target="_blank" method="post" action="">
<div class="Block">



<label>PVMS/ NIV No.</label> 
<input type="text" id="serviceNo" name="<%=SERVICE_NO%>" value=""	MAXLENGTH="20" tabindex="1" 
	onblur="getBatchNo('barcodeGerator','stores?method=getHinNoForUpdateAdt&flag=registration')" />





<label>Nomenclature</label> 
<input type="text" value="" id="nomenclature1" name="nomenclature1" onblur="test();" tabindex=1/>
<div id="ac2update" style="display: none;"	class="autocomplete">
</div>
<script type="text/javascript" language="javascript" charset="utf-8">
	new Ajax.Autocompleter('nomenclature1','ac2update','stores?method=getItemListForBINCardByAutocomplete',{parameters:'requiredField=nomenclature1'});
</script>
<input type="hidden" id="pvmsNo" class="small" name="pvmsNo" readonly="readonly"/>



<input type="hidden" name="PVMS_NIV_NO" id="pvms_no" value="" onmousemove="autocompleteBasedOnPvms(this.value);" onblur="autocompleteBasedOnPvms(this.value);" tabindex=2> 




	<script type="text/javascript">
	function test(){

		var itemNameSearch1 =  document.getElementById('nomenclature1').value;
	    var index1 = itemNameSearch1.lastIndexOf("[");
	    var index2 = itemNameSearch1.lastIndexOf("]");
	    var index3 = itemNameSearch1.lastIndexOf("(");
	    var index4 = itemNameSearch1.lastIndexOf(")");
	    index1++;
	    index3++;
	    var itemNameSearch = itemNameSearch1.substring(0,index1-1);
	    var itemId = itemNameSearch1.substring(index1,index2);
	    var itempvms=itemNameSearch1.substring(index3,index4);
	    if(itemId!="")
	    document.getElementById("pvmsNo").value=itemId;
	    else
	    document.getElementById("pvmsNo").value=0;

	    //document.getElementById("pvmsNo").focus();
	    
	    if(itempvms!=null)
	    document.getElementById("serviceNo").value=itempvms;
	    else
	    	document.getElementById("serviceNo").value=0;  
	    // document.physicalStock.method="post";
		//	submitForm('physicalStock','stores?method=getGridDataForPhysicalStock');
	
	}
</script>

<div id="hinDiv">
<label> Batch No.</label> <input type="text"
	name="<%=HIN_NO%>" value="" MAXLENGTH="30"
	onchange="submitBarcodeAjax('barcodeGerator','stores?method=getBarcodeNumber')" />
</div>
<input type="hidden" name="<%=PRESCRIPTION_SLIP%>" value="o" />
<div id="testDiv"></div>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('barcodeGerator','stores?method=showBarcodeNumber');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	accesskey="r" /></form>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
</div>





