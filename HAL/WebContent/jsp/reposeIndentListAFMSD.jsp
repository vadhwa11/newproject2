
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot"%>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script>
 var flag;
 </script>
<script>
	 function getManufacturerNameByAjax(brandId,rowVal){
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
			        var manufacturerName  = item.getElementsByTagName("manufacturerName")[0];
			       // alert("mId>>>>>>>>>>>"+mId);
			        alert("rowVal>>>"+rowVal);
			        alert("manufacturerName.childNodes[0].nodeValue"+manufacturerName.childNodes[0].nodeValue);
		        	var mId  = item.getElementsByTagName("mId")[0];
			        alert("mId.childNodes[0].nodeValue"+mId.childNodes[0].nodeValue);
			        alert(">>>"+document.getElementById('manufacturerIdTemp'+rowVal));
		        	document.getElementById('manufacturerIdTemp'+rowVal).value = mId.childNodes[0].nodeValue
//			        
		        	document.getElementById('manufacturerId'+rowVal).value = manufacturerName.childNodes[0].nodeValue
		      	}
		      }
		    }
		     url="stores?method=getManufacturerNameInAjax&brandId="+brandId;
		    xmlHttp.open("GET",url,true);
		    xmlHttp.setRequestHeader("Content-Type", "text/xml");
		    xmlHttp.send(null);

		 }
	</script>
<%
	Map map = new HashMap();
	List<StoreIndentM> indentList= new ArrayList<StoreIndentM>();
	List<StoreIndentM> indentForAfmsdList= new ArrayList<StoreIndentM>();
	List<StorePoHeader> poList= new ArrayList<StorePoHeader>();
	String choice = "";

	if(request.getAttribute("map") != null)
	{
		indentList=(List)map.get("second_combo");
		map = (Map)request.getAttribute("map");
		if (map.get("choice")!=null)

			choice = map.get("choice").toString();
		if (choice.equalsIgnoreCase("P"))
		{
			indentList=(List)map.get("second_combo");
		}
		else if (choice.equalsIgnoreCase("A"))
		{
			indentList=(List)map.get("second_combo");
		}
		else if (choice.equalsIgnoreCase("L"))
		{
			poList=(List)map.get("second_combo");
		}

	}
	//onchange="submitProtoAjaxforGrid('grnForm','/hms/hms/stores?method=responseGridList');"


	%>



<div id=indentDiv>
<label>SO/Indent No.<span>*</span></label>
<select name="<%=RequestConstants.INDENT_ID %>" id="indentCombo" onchange="submitForm('grnForm','stores?method=showGrnJspForAFMSD');"  tabindex=1>
	<option value="0">Select</option>
	<% for (StoreIndentM indentList1 : indentList)  {   %>
	<option value="<%=indentList1.getId()%>"><%=indentList1.getIndentNo()%></option>
	<%}%>
</select>
</div>