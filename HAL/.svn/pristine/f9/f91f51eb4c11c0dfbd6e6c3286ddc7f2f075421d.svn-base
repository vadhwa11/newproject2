<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * indentBD.jsp  
 * Purpose of the JSP -  This is for indentBD.
 * @author  Mansi
 * @author  Deepali
 * Create Date: 21st Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreIndentT"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Collections"%>
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot"%>
<%@page import="jkt.hms.util.Box"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<link rel="stylesheet" href="/hms/jsp/css/acnik.css" type="text/css" />

<script type="text/javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>

<script language="javascript">
	
	function checkForIndentToDepot(val,a,inc){
		var pageNo =parseInt(document.getElementById('pageNo').value) 
		var start=((pageNo-1)*8)+1;
    	var end=((pageNo-1)*8)+8;
    
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	    for(i=1;i<=8;i++){
	    if(document.getElementById('codeItem'+i) !=null){
	    if(pvms !=""){
	    if(document.getElementById('codeItem'+i).value==pvms){
	    if(document.getElementById('codeItem'+inc).value!=pvms){
	    	alert("Item already selected...!")
	    	document.getElementById('nameItem'+inc).value=""
	    	
	    	return false;
	    	}
	    }}}}
		ajaxFunctionForAutoCompleteIndentToDepotAFMSD('indent','neStores?method=fillItemsForIndentToDepot&pvmsNo=' +  pvms , inc);
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
function test(){
	var errorMessage="";
	formName="indent"
	obj = eval('document.'+formName)
	if(document.getElementById('supplyDepot').value == 0)
		errorMessage=errorMessage+"Please Select supply Depot  \n"; 
	
	if(document.getElementById('typeOfIndent').value == "")
		errorMessage=errorMessage+"Please Select type Of Indent \n";
	if(document.getElementById('nrs').value == "")
		errorMessage=errorMessage+"Please fill nrs \n";
	if(document.getElementById('Authority').value == "")
		errorMessage=errorMessage+"Please Fill Authority \n";
		if(document.getElementById('address').value == "")
		errorMessage=errorMessage+"Please Fill address \n";
	
	if((document.getElementById('supplyDepot').value != 0)  &&(document.getElementById('typeOfIndent').value != "") &&(document.getElementById('nrs').value != "")&&(document.getElementById('Authority').value != "")&&(document.getElementById('address').value != "")){
		return true;
	}else{
		alert(errorMessage)
		return false
	}

}

function autocompleteBasedOnPvms(val,inc)
{
		ajaxFunctionForAutoCompleteForGrn('indentGrid','stores?method=fillItemsCommon&pvmsNo=' +  val , inc);
}

function ajaxFunctionForAutoCompleteForGrn(formName,action,rowVal) 
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
	    	document.getElementById('nameItem'+rowVal).value = name.childNodes[0].nodeValue + "[" + pvms.childNodes[0].nodeValue + "]"
      }
    }
  }
}


function ajaxFunctionForAutoCompleteIndentToDepotAFMSD(formName,action,rowVal) {
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
	      var typeOfIndent=document.getElementById('typeOfIndent').value;
	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		        var id  = item.getElementsByTagName("id")[0];
		        var pvms  = item.getElementsByTagName("pvms")[0];
		        var au  = item.getElementsByTagName("au")[0];
		        var name  = item.getElementsByTagName("name")[0];
		        
		        var oldPvms  = item.getElementsByTagName("oldPvms")[0];
		        var stock  = item.getElementsByTagName("stock")[0];
		        var qtyInMMF  = item.getElementsByTagName("qtyInMMF")[0];
		        var section  = item.getElementsByTagName("section")[0];


		        if(typeOfIndent=="")
	        	{
	        		alert("please select Type of Indent")
	        		
	    	    	document.getElementById('nameItem'+rowVal).value=""
	    	    	
	    	    	return false;
	        		
	        	}
	        	
	        	document.getElementById('codeItem'+rowVal).value = pvms.childNodes[0].nodeValue
	        	document.getElementById('idItem'+rowVal).value = id.childNodes[0].nodeValue
	        	document.getElementById('idAu'+rowVal).value = au.childNodes[0].nodeValue
	        	//if(oldPvms.childNodes[0].nodeValue != 0)
	        	//document.getElementById('oldNiv'+rowVal).value = oldPvms.childNodes[0].nodeValue
	        	
	        	document.getElementById('qtyInHand'+rowVal).value = stock.childNodes[0].nodeValue
	        	//document.getElementById('qtyInHandTemp'+rowVal).value = stock.childNodes[0].nodeValue
	        	document.getElementById('mmfVarTemp'+rowVal).value = qtyInMMF.childNodes[0].nodeValue
	        	document.getElementById('mmfVar'+rowVal).value = qtyInMMF.childNodes[0].nodeValue
	        	document.getElementById('section'+rowVal).value = section.childNodes[0].nodeValue
	        	
	        	if(typeOfIndent=="")
	        	{
	        		alert("please select Type of Indent")
	        		
	    	    	document.getElementById('nameItem'+rowVal).value=""
	    	    	
	    	    	return false;
	        		
	        	}
	        	
	        	
	        	if(typeOfIndent==1)
	        	{
	        		var mmf=qtyInMMF.childNodes[0].nodeValue;
	        		var qtyInHand=stock.childNodes[0].nodeValue;
	        		var demandVar=mmf - qtyInHand;
	        		//document.getElementById('demandVar'+rowVal).value=demandVar;
	        		//document.getElementById('demandVarTemp'+rowVal).value=demandVar;
	        	}
	        	
	        	if(typeOfIndent==2)
	        	{
	        		var mmf=qtyInMMF.childNodes[0].nodeValue;
	        		var qtyInHand=stock.childNodes[0].nodeValue;
	        		var demandVar=mmf - qtyInHand;
	        		//document.getElementById('demandVar'+rowVal).value=demandVar;
	        		//document.getElementById('demandVarTemp'+rowVal).value=demandVar;
	        	}
	        	
	      	} 
	      }
	    }
	    var url=action+"&"+getNameAndData(formName)
	     
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	    
	    
	  }

</script>
<%
	Map map = new HashMap();
	String includedJsp = null;
	String previousPage="no";
	int pageNo=1;
	Box box=HMSUtil.getBox(request);
	
	List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();
	List<MasStoreAirForceDepot> masStoreAirForceDepotList= new ArrayList<MasStoreAirForceDepot>();
	String maxIndentNo="";
	String date="";
	String time="";
	String userName = "";
	List objectList=new ArrayList();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 date = (String)utilMap.get("currentDate");	 
	 time = (String)utilMap.get("currentTime");
	 if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
	//--------Hearder Variables-------
	String indentNo="";
	int indentId=0;
	String indentFrom="";
	String indentDate="";
	int supplyDepot=0;
	int sectionId=0;
	int indentOption=0;
	String  nrs="";
	String authority="";
	String address="";
	//--------End -------- Hearder Variables-------
	try{
	if (request.getAttribute("map") != null) 
		map = (Map) request.getAttribute("map");
	if(map.get("indentNo")!=null)
		indentNo=""+map.get("indentNo");
	if(map.get("indentId")!=null)
	indentId= Integer.parseInt(""+map.get("indentId")) ;
	if(map.get("indentFrom")!=null)
	indentFrom =""+ map.get(" indentFrom");
	if(map.get("indentDate")!=null)
	indentDate =""+ map.get("indentDate");
	if(map.get("supplyDepot")!=null)
	supplyDepot =Integer.parseInt(""+map.get("supplyDepot")) ;
	
	if(map.get("indentOption")!=null)
		indentOption=Integer.parseInt(""+map.get("indentOption")) ;
	if(map.get("nrs")!=null)
	nrs=(""+map.get("nrs")) ;
	if(map.get("authority")!=null)
	authority=""+map.get("authority");
	if(map.get("address")!=null)
	address =""+map.get("address");
	
	
	
	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt(""+map.get("pageNo"));
	}
	if(map.get("maxIndentNo")!=null)
		maxIndentNo=(""+map.get("maxIndentNo"));
	

	if(map.get("masStoreAirForceDepotList")!=null)
		masStoreAirForceDepotList=(List) map.get("masStoreAirForceDepotList");
	System.out.println("masStoreAirForceDepotList  "+masStoreAirForceDepotList.size());
	if(map.get("objectList")!=null)
		objectList=(List) map.get("objectList");
	if(map.get("searchIndentList")!=null)
	searchIndentList = (List<StoreIndentM>) map.get("searchIndentList");
	

	}catch(Exception e){
		e.printStackTrace();
	}
	
%>

<div class="titleBg"><h2> Initial Deficiency Indent To Depot</h2></div>
<div class="clear"></div>
<form name="indent" method="post">
<div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div>
<div class="clear"></div>
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<form name="searchForm" method="post">
<div class="clear"></div>
<label>Indent No</label>
<select		name="<%= RequestConstants.INDENT_NO_FOR_SEARCH%>">
			<option value="0">Select</option>
			<%
					for (StoreIndentM storeIndentM :searchIndentList ) {
						
				%>

			<option value=<%=storeIndentM.getId()%>><%=storeIndentM.getIndentNo()%></option>

			<%
					}
				%>
		</select>
<input type="button" class="button" value=" "	onClick="submitForm('indent','neStores?method=searchIndentDepot');" />
</form>
</div>
<%-- End of Search Panel--%>
</form>

<form name="indentGrid" method="post">
<div id="testDiv">
<h4>Indent Details</h4>
<div class="Block">
<input type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo" />
<input	type="hidden" size="2" value="0"	name="<%=RequestConstants.NO_OF_ROWS%>"	id="<%=RequestConstants.NO_OF_ROWS%>" />
<input type="hidden"	name="<%=RequestConstants.INDENT_ID %>" value="<%=indentId%>"	id="indentId" /> <%if(indentId==0){%>
<label>Indent No </label>
<input type="text"	name="<%=RequestConstants.INDENT_NO %>" value="<%=maxIndentNo%>"	readonly="readonly"  MAXLENGTH="8"/  >
<label>Indentor</label>
<input	type="text" readonly="readonly"	name="<%=RequestConstants.INDENT_FROM %>" value="Commandant,Base Hospital"	 MAXLENGTH="20" />
<label>Indent Date</label>
<input type="text"	name="<%=RequestConstants.INDENT_DATE%>" readonly="readonly"	value="<%=date %>"  MAXLENGTH="30" />
<label>Supp Depot </label>
<select	name="<%= RequestConstants.SUPPLY_DEPOT%>" id="supplyDepot"	tabindex="1">
	<option value="0">Select</option>
	<%for(MasStoreAirForceDepot airForceDepot: masStoreAirForceDepotList){ %>
	<option value="<%=airForceDepot.getId() %>"
		<%=HMSUtil.isSelected(airForceDepot.getId().toString(),box.get("supplyDepot")) %>><%=airForceDepot.getAirForceDepotName()%></option>
	<%} %>
</select>
<label>Typ of Indent</label>
<select name="<%= RequestConstants.TYPE_OF_INDENT%>" id="typeOfIndent"
	tabindex="1">
	<option value="">Select</option>
	<option value="1">Initial Deficiency</option>
	<option value="1">Replacement</option>
	
	
</select>
<label>NRS</label>
<input	type="text" name="<%= RequestConstants.NRS %>" MAXLENGTH="50"	tabindex="1" value="Delhi Cantt" MAXLENGTH="30"	id="nrs" />
<label>Authority</label>
<textarea	name="<%=RequestConstants.AUTHORITY%>" MAXLENGTH="256" tabindex="1"	cols="27" rows="2" id="Authority" class="txtarea">37/36A && 37/37
</textarea>

<label>Postal Address</label>
<textarea name="<%=RequestConstants.ADDRESS%>" tabindex="1"	MAXLENGTH="200" rows="2" cols="30" id="address" >
</textarea>
<%}else{ %>
<label>Indent No </label>
<input type="text" name="<%=RequestConstants.INDENT_NO %>"	value="<%=indentNo%>" readonly="readonly" 	MAXLENGTH="8"/  >
<label>Indentor </label>
<input type="text" readonly="readonly"	name="<%=RequestConstants.INDENT_FROM %>" value="Commandant,CHAFB"	MAXLENGTH="20" />
<label>Indent Date</label>
<input type="text" name=""	readonly="readonly" value="<%=date%>" 	MAXLENGTH="30" />
<input type="hidden"	name="<%=RequestConstants.INDENT_DATE%>" value="<%=date %>"	MAXLENGTH="30" />
<label>Supp Depot </label>
<select	name="<%= RequestConstants.SUPPLY_DEPOT%>" id="supplyDepot">
	<option value="0">Select</option>
	<%for(MasStoreAirForceDepot airForceDepot: masStoreAirForceDepotList){ 
					if(airForceDepot.getId()==supplyDepot){
					%>
	<option value="<%=airForceDepot.getId() %>" selected="selected"><%=airForceDepot.getAirForceDepotName()%></option>
	<%}else{ %>
	<option value="<%=airForceDepot.getId() %>"><%=airForceDepot.getAirForceDepotName()%></option>
	<%}} %>
</select>


<label>Typ of Indent</label>
<select name="<%= RequestConstants.TYPE_OF_INDENT%>" id="typeOfIndent">
	<option value="">Select</option>
	<%if(indentOption==1){ %>
	<option value="1" selected="selected">Initial Deficiency</option>
	<%}else{ %>
	<option value="1">Initial Deficiency</option>
	<%}%>
	<%if(indentOption==2){ %>
	<option value="2" selected="selected">Replacement </option>
	<%}else{ %>
	<option value="2">Replacement </option>
	<%}%>
	
	
</select>
<label>NRS</label>
<input	type="text" readonly="readonly" name="nrs1" value="<%=nrs%>"	MAXLENGTH="30" id="nrs" />
<input type="hidden"	name="<%= RequestConstants.NRS %>" value="<%=nrs%>"	MAXLENGTH="30" />

<div class="clear"></div>

<label>Authority</label>
<textarea	name="Authority1" cols="27" rows="2" readonly="readonly" id="Authority"	>
				<%=authority %>
</textarea>

<input type="hidden" name="<%=RequestConstants.AUTHORITY %>"	value="<%=authority %>" />
<label>Postal Address</label>
<textarea name="address2" rows="2"	cols="30" readonly="readonly" id="address" ><%=address %></textarea>
<input type="hidden" name="<%=RequestConstants.ADDRESS %>"
	value="<%=address %>" /> <%} %>
</div>
</div>

<div class="paddingTop15"></div>
<h4>Item Details</h4>
<div id="pagination">
Page No
<span class="selected" ><%=pageNo%></span>
</div>
<div class="cmntable">
<table width="100%" colspan="7" id="indentDetails" class="grid_header"
	border="0" cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<th width="3%">SR
			No</th>
			<!--<td width="5%">New PVMS No</label> 
      -->
			<th width="5%">PVMS
			No</th>
			<th width="15%">Nomenclature</th>
			<th width="3%">A/U</th>
			<th width="15%">Section</th>			
			<th width="15%">Qty	Held </th>
			<th width="15%">Qty	Auth</th>
			<th width="24%">Qty	Demand</th>

		</tr>

	</thead>
	<tbody>



		<td width="3%">
		<%
    	int detailCounter=8; 
    	int temp=0;
    	String idItem="idItem";
    	String codeItem="codeItem";
    	String nameItem="nameItem";
    	String qtyInHandTemp="qtyInHandTemp";
    	String qtyInHand="qtyInHand";
    	String idAu="idAu";
    	String oldNiv="oldNiv";
    	String departmentId="departmentId";
    	
    	String stockInVar="stockInVar";
    	String mmfVar="mmfVar";
    	String demandVar="demandVar";
    	
    	String stockInVarTemp="stockInVarTemp";
    	String mmfVarTemp="mmfVarTemp";
    	String demandVarTemp="demandVarTemp";
    	String incVar="incVar";
    	String section="section";
    	
    	String idItem2="idItem";
    	String codeItem2="codeItem";
    	String nameItem2="nameItem";
    	String qtyInHandTemp2="qtyInHandTemp";
    	String qtyInHand2="qtyInHand";
    	String idAu2="idAu";
    	String oldNiv2="oldNiv";
    	
    	String stockInVar2="stockInVar";
    	String mmfVar2="mmfVar";
    	String demandVar2="demandVar";

    	String stockInVarTemp2="stockInVarTemp";
    	String mmfVarTemp2="mmfVarTemp";
    	String demandVarTemp2="demandVarTemp";
    	String incVar2="incVar2";
    	String departmentId2="departmentId";
    	String section2="section";
    	if(pageNo!=1)
    	{
    		temp=detailCounter*(pageNo-1);
    	}
     	 for(int inc=1;inc<=detailCounter;inc++){
     		 
     		idItem=idItem2+(""+inc);
     		codeItem=codeItem2+(""+inc);
     		nameItem=nameItem2+(""+inc);
     		qtyInHandTemp=qtyInHandTemp2+(""+inc);
     		qtyInHand=qtyInHand2+(""+inc);
     		idAu=idAu2+(""+inc);
     		oldNiv=oldNiv2+(""+inc);
     		stockInVar=stockInVar2+(""+inc);
     		mmfVar=mmfVar2+(""+inc);
     		demandVar=demandVar2+(""+inc);
     		departmentId=departmentId2+(""+inc);

     		stockInVarTemp=stockInVarTemp2+(""+inc);
     		mmfVarTemp=mmfVarTemp2+(""+inc);
     		demandVarTemp=demandVarTemp2+(""+inc);
     		incVar=incVar2+(""+inc);
     		section=section2+(""+inc);
    	  %>
		<tr>
			<td width="3%"><input type="text" size="2" value="<%=temp+inc%>"
				class="smcaption" name="<%=RequestConstants.SR_NO%>"
				readonly="readonly" /></td>

			<td width="5%"><input name="<%=RequestConstants.ITEM_CODE %>"
				tabindex="1" type="text" class="medcaption" id="<%=codeItem%>"
				size="8" onblur="autocompleteBasedOnPvms(this.value,'<%=inc%>');" />
			<input type="hidden" value="0" name="<%=RequestConstants.ITEM_ID%>"
				id="<%=idItem%>" /> <input type="hidden" value="0"
				name="<%=RequestConstants.DEPARTMENT_ID_TEMP%>"
				id="<%=departmentId%>" /></td>
			<td width="15%"><input type="text" value="" tabindex="1"
				id="<%=nameItem%>" class="bigcaption"
				onblur="if(fillSrNo('<%=inc %>')){checkForIndentToDepot(this.value, '<%=nameItem%>','<%=inc %>');}"
				name="<%=nameItem%>" />
			<div id="ac2update"
				style="display: none" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=nameItem%>','ac2update','stores?method=getItemListForIndentToDepot',{parameters:'requiredField=<%=nameItem%>&indentId='+document.getElementById('indentId').value });
			</script></td>
			<td width="3%"><input name="<%=RequestConstants.AV%>"
				type="text" tabindex="1" class="smcaption" id="<%=idAu%>" value=""
				size="4" readonly="readonly" /></td>
			<td width="15%"><input type="text" value="" id="<%=section%>"
				tabindex="1" class="medcaption" readonly="readonly" /></td>
			<td width="15%"><input type="text" value="0" class="medcaption"
				tabindex="1" name="<%=RequestConstants.QTY_IN_HAND%>" MAXLENGTH="7"
				id="<%=qtyInHand%>" validate="Qty In Stock,num,no" /> <!--
      <input type="hidden"	value="0" class="medcaption"   name="<%=RequestConstants.QTY_IN_HAND%>"  id="<%=qtyInHandTemp%>" />
      --></td>

			<td width="15%"><input type="text" tabindex="1" value=""
				class="medcaption" tabindex=1
				name="<%=RequestConstants.QTY_IN_MMF_TEMP%>" MAXLENGTH="7"
				id="<%=mmfVarTemp%>" validate="Qty In MMF,floatWithoutSpaces,no"
				onblur="getQtyDemand(this.value,<%=inc%>);" /> <input type="hidden"
				value="0" class="medcaption" name="<%=RequestConstants.QTY_IN_MMF%>"
				tabindex="2" id="<%=mmfVar%>" /></td>
			<td width="24%"><input type="text" size="7" tabindex="1"
				class="medcaption" value="" name="<%=RequestConstants.QTY_DEMAND%>"
				MAXLENGTH="7" tabindex="1" id="<%=demandVar%>"
				
				validate="Qty In Demand,floatWithoutSpaces,no" /> <input
				type="hidden" class="medcaption" value="0"
				name="<%=RequestConstants.QTY_DEMAND_TEMP%>" tabindex="2"
				id="<%=demandVarTemp%>" /></td>
		</tr>
		<% }   %>
		
	</tbody>
</table>
</div>
<div class="clear"></div>
<div class="division"></div>
<input type="button" class="button" value="Next" onclick="if( test()&&checkForNext()&&checkSave()){submitForm('indentGrid','nestores?method=addNextOrSubmitIndentToDepot&buttonName=next');}"	align="right" />
<input type="button" name="sss" align="right"	class="button" value="Submit"	onclick="if(test()&&checkForSubmit()&& checkSave()){submitForm('indentGrid','neStores?method=addNextOrSubmitIndentToDepot&buttonName=submit');}" />
<input type="button" name="Modify" value="Print" class="button" />
<div class="clear"></div>
<div class="division"></div>
<div class="bottom">
<label>Changed By:</label>
<label class="value"><%=userName%></label>

<label>Changed Date:</label>
<label class="value"><%=date%></label>

<label>Changed Time:</label>
<label class="value"><%=time%></label>
</div>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</form>
<script type="text/javascript">vBulletin_init();</script> <input
	type="hidden" name="rows" id="rr" value="1" />
	
	<script type="text/javascript">
function getQtyDemand(val,incr)
{
	
//var demandQty=	document.getElementById('demandVarTemp'+incr).value;
var qtyInHand=	document.getElementById('qtyInHand'+incr).value;

var demdQty=parseFloat(val-qtyInHand);

document.getElementById('demandVar'+incr).value=demdQty;
document.getElementById('demandVarTemp'+incr).value=demdQty;


}
	</script>


