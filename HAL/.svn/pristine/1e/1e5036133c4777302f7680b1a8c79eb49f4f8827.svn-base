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


//add javed khan
function getSearchBlock()
{

document.getElementById('searchBlock').style.display = 'inline';
}
//add javed khan
function closeSearch()
{

document.getElementById('searchBlock').style.display = 'none';
}

function checkQty(rowVal)
{// javed khan
	
	//alert("0 "+val)
	
	
		//alert("1 "+document.getElementById('qtyOnLoan'+rowVal).value)
		//if(parseInt(document.getElementById('demandVar'+rowVal).value) > parseInt(document.getElementById('mmfVarTemp'+rowVal).value))
		if(parseInt(document.getElementById('demandVar'+rowVal).value) > parseInt(document.getElementById('mmfVarTemp'+rowVal).value))
		{
			alert("Qty Demanded can't be greater than Qty Auth .");
			//document.getElementById('demandVar'+rowVal).value="";
			///document.getElementById("demandVar"+rowVal).focus();
			document.getElementById('demandVar'+rowVal).value="";
			document.getElementById("demandVar"+rowVal).focus();
		}
	
	
}	



	function fillCostForSOC(rowVal){

	if(document.getElementById('costTemp'+rowVal).value==''){
		document.getElementById('cost'+rowVal).value=0
	}else{
		document.getElementById('cost'+rowVal).value=document.getElementById('costTemp'+rowVal).value
	}

}
	function setSecId(){
		var secId=document.getElementById('sectionId1').value;
		document.getElementById('sectionId2').value=secId;
		//alert(document.getElementById('sectionId2').value);
		}
	
	function checkForIndentToDepot(val,a,inc){
		var pageNo =parseInt(document.getElementById('pageNo').value) 
		var start=((pageNo-1)*8)+1;
    	var end=((pageNo-1)*8)+8;
    	
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	    for(i=1;i<=8;i++){
	    if(pvms !="")
	    if(document.getElementById('codeItem'+i).value==pvms){
	    if(document.getElementById('codeItem'+inc).value!=pvms){
	    	alert("Item already selected...!")
	    	document.getElementById('nameItem'+inc).value=""
	    	
	    	return false;
	    	}
	    }}
		ajaxFunctionForAutoCompleteIndentToDepot1('indent','nonExp?method=fillItemsForIndentToDepot&pvmsNo=' +  pvms , inc);
}


	  function ajaxFunctionForAutoCompleteIndentToDepot1(formName,action,rowVal) {
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
			        var id  = item.getElementsByTagName("id")[0];
			        var pvms  = item.getElementsByTagName("pvms")[0];
			        var au  = item.getElementsByTagName("au")[0];
			        var name  = item.getElementsByTagName("name")[0];
			        
			        var oldPvms  = item.getElementsByTagName("oldPvms")[0];
			        var stock  = item.getElementsByTagName("stock")[0];
			        var qtyInMMF  = item.getElementsByTagName("qtyInMMF")[0];
			        var section  = item.getElementsByTagName("section")[0];
			       
		        	document.getElementById('codeItem'+rowVal).value = pvms.childNodes[0].nodeValue
		        	document.getElementById('idItem'+rowVal).value = id.childNodes[0].nodeValue
		        	document.getElementById('idAu'+rowVal).value = au.childNodes[0].nodeValue
		        	//if(oldPvms.childNodes[0].nodeValue != 0)
		        	//document.getElementById('oldNiv'+rowVal).value = oldPvms.childNodes[0].nodeValue
		        	
		        	document.getElementById('qtyInHand'+rowVal).value = stock.childNodes[0].nodeValue
		        	document.getElementById('qtyInHandTemp'+rowVal).value = stock.childNodes[0].nodeValue
		        	document.getElementById('mmfVarTemp'+rowVal).value = qtyInMMF.childNodes[0].nodeValue
		        	document.getElementById('mmfVar'+rowVal).value = qtyInMMF.childNodes[0].nodeValue
		        	document.getElementById('section'+rowVal).value = section.childNodes[0].nodeValue
		      	} 
		      }
		    }
		    var url=action+"&"+getNameAndData(formName)
		     
		    xmlHttp.open("GET",url,true);
		    xmlHttp.setRequestHeader("Content-Type", "text/xml");
		    xmlHttp.send(null);
		    
		    
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
	//if(document.getElementById('nrs').value == "")
		//errorMessage=errorMessage+"Please fill nrs \n";
	if(document.getElementById('Authority').value == "")
		errorMessage=errorMessage+"Please Fill Authority \n";
		if(document.getElementById('address').value == "")
		errorMessage=errorMessage+"Please Fill address \n";
	
	if((document.getElementById('supplyDepot').value != 0)  &&(document.getElementById('typeOfIndent').value != "") &&(document.getElementById('Authority').value != "")&&(document.getElementById('address').value != "")){
		return true;
	}else{
		alert(errorMessage)
		return false
	}

}


  function showReport(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/nonExp?method=printIndentToDepotJsp";
  obj.submit();
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
	List<MasStoreSection> storeSectionList = new ArrayList<MasStoreSection>();
	String maxIndentNo="";
	String date="";
	String time="";
	String userName = "";
	List objectList=new ArrayList();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 date = (String)utilMap.get("currentDate");	 
	 time = (String)utilMap.get("currentTime");
	 String currentDate = (String)utilMap.get("currentDate");  
		String currentTime = (String)utilMap.get("currentTime");
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
	String messageTOBeVisibleToTheUser ="";
	String messageType ="success";
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
	if(map.get("sectionList")!=null)
		storeSectionList = (List<MasStoreSection>)map.get("sectionList");
	if(map.get("messageTOBeVisibleToTheUser") !=null){
		messageTOBeVisibleToTheUser=""+map.get("messageTOBeVisibleToTheUser");
	}
	if(map.get("messageType") !=null){
		messageType=""+map.get("messageType");
	}

	}catch(Exception e){
		e.printStackTrace();
	}
	
%>

<div class="titleBg"><h2>INDENT TO DEPOT</h2></div>


 <div id="searchBlock" style="display:none;">
<form name="indentNe" method="post">
<div class="clear"></div>
<h6>SEARCH</h6>
<div class="clear"></div>
<div class="Block">
<form name="" method="">

<label>From Date</label> <input type="text" name="<%= FROM_DATE %>"
	class="date" maxlength="30" tabindex=1 /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.indentNe.<%=FROM_DATE%>,event)" />

<label >To Date :</label> 
<input type="text" id="toDate" name="<%= TO_DATE %>" MAXLENGTH="30"  tabindex=1 onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'toDate');"  />
 <img id="calendar"  src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
				 onClick="setdate('<%=currentDate%>',document.indentNe.<%= TO_DATE%>,event)" />
<div class="clear"></div>				 

<label>Indent No.</label>
<select name="<%= RequestConstants.INDENT_NO_FOR_SEARCH%>">
			<option value="0">Select</option>
			<%	for (StoreIndentM storeIndentM :searchIndentList ) {	%>
			<option value=<%=storeIndentM.getId()%>><%=storeIndentM.getIndentNo()%></option>
			<% }%>
		</select>

<input type="button" name="sss" class="button" value="SEARCH" 	onClick="submitForm('indentNe','neStores?method=newSearchIndentNe');" />
<input type="button" name="sss" class="button" value="CLOSE"  onClick="closeSearch();" />

<!-- </form>
</div>
  -->
<%-- End of Search Panel--%> <br />
</form>
</div>
</form>
</div>

<form name="indent" method="post">
<!-- -
<div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div>
<div class="clear"></div>
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<form name="searchPanel" method="post">
<label>Indent No.</label>
<select name="<%= RequestConstants.INDENT_NO_FOR_SEARCH%>">
			<option value="0">Select</option>
			<%	for (StoreIndentM storeIndentM :searchIndentList ) {	%>
			<option value=<%=storeIndentM.getId()%>><%=storeIndentM.getIndentNo()%></option>
			<% }%>
		</select> 
<input type="image" class="button" value=" "	onClick="submitForm('indent','stores?method=searchIndentDepot');" />
		
</form>
</div>
 -->
<%-- End of Search Panel--%> <br />
</form>
<div class="clear"></div>
<form name="indentGrid" method="post">
<div id="testDiv">

<div class="clear"></div>
<div class="Block">
<input type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo" /> 
<input type="hidden" size="2" value="0" name="<%=RequestConstants.NO_OF_ROWS%>"id="<%=RequestConstants.NO_OF_ROWS%>" />
<input type="hidden" name="<%=RequestConstants.INDENT_ID %>" value="<%=indentId%>" id="indentId" />
	 <%if(indentId==0){%>
<label> Indent No.</label> 
 <input type="text" name="<%=RequestConstants.INDENT_NO %>" value="<%=maxIndentNo%>" readonly="readonly" />
 <!-- -
 <label	>Indentor :</label> 
 <input	type="text" readonly="readonly"	name="<%=RequestConstants.INDENT_FROM %>" value="Commandant,CHAFB"
	MAXLENGTH="20" />  -->
<label>Indent Date</label>
<input type="text" name="<%=RequestConstants.INDENT_DATE%>" readonly="readonly"value="<%=date %>" MAXLENGTH="30" />

<label>Supply Depot </label> 
<select	name="<%= RequestConstants.SUPPLY_DEPOT%>" id="supplyDepot"	tabindex="1">
	<option value="0">Select</option>
	<%for(MasStoreAirForceDepot airForceDepot: masStoreAirForceDepotList){ %>
	<option value="<%=airForceDepot.getId() %>"
		<%=HMSUtil.isSelected(airForceDepot.getId().toString(),box.get("supplyDepot")) %>><%=airForceDepot.getAirForceDepotName()%></option>
	<%} %>
</select> 

<div class="clear"></div>

<label>Type of Indent</label>
<select name="<%= RequestConstants.TYPE_OF_INDENT%>" id="typeOfIndent"	tabindex="1">
	<option value="">Select</option>
	<!-- 
	<option value="1">Emergent</option>
	<option value="2">Monthly</option>
	<option value="3">Bi-Monthly</option>
	<option value="4">Four Monthly</option>
	 -->
	 <option value="I">Initial</option>
	<option value="R">Replacement</option>
</select> 

<label>Postal Address</label>
<textarea name="<%=RequestConstants.ADDRESS%>" 	MAXLENGTH="200" rows="2" cols="30" id="address" class="txtarea" tabindex="1"></textarea>

<label> Authority</label>
<textarea name="<%=RequestConstants.AUTHORITY%>" MAXLENGTH="100" tabindex="1"
	cols="27" rows="2" id="Authority" class="txtarea">
</textarea>
<div class="clear"></div>

<!--
<label> NRS</label> 
<input	type="text" name="<%= RequestConstants.NRS %>" value="" MAXLENGTH="30" id="nrs" tabindex="1"/>
-->
<!--  
<label>Life Span</label>

		<select value="0" name="<%=SHELF_LIFE%>"  id="sl" validate="Life,string,no" tabindex=1>
		<option value="SL">SL</option>
	
		<option value="SLB">SLB</option>
		<option value="LL">LL</option>
		</select>

-->



<label>Section</label>
<select  name="sectionId" id="sectionId1"  onchange="setSecId();" tabindex=1>

				<option value="0">Select</option>
				  <%
				  for(MasStoreSection masStoreSection : storeSectionList) {
				  %>
				  <option value="<%=masStoreSection.getId()%>" ><%=masStoreSection.getSectionName()%></option>
				  <%}%>
				</select> 
				<input type="hidden" id="sectionId2" value="0" name="sec"/>


<label>Contact/Tel. No.</label>
<input type="text" name="<%=CONTACT_NUMBER %>" id="conNo" value="" maxlength="10" tabindex="1"/>
<label> Code Head</label> 
<input	type="text" name="<%= RequestConstants.CODE_HEAD%>" value="" MAXLENGTH="30" id="codehead" tabindex="1"/>
<%}else{ %>
<label>Indent No. </label>
<input type="text" name="<%=RequestConstants.INDENT_NO %>"	value="<%=indentNo%>" readonly="readonly"/> 
	
	<!-- 
<label>Indentor :</label>
<input type="text" readonly="readonly" name="<%=RequestConstants.INDENT_FROM %>" value="Commandant,CHAFB"MAXLENGTH="20" /> -->

<label>Indent Date</label> 
<input type="text" name=""	readonly="readonly" value="<%=date%>" MAXLENGTH="30" /> 
<input type="hidden" name="<%=RequestConstants.INDENT_DATE%>" value="<%=date %>" MAXLENGTH="30" /> 

<label>Supply Depot</label> <select
	name="<%= RequestConstants.SUPPLY_DEPOT%>" id="supplyDepot">
	<option value="0">Select</option>
	<%for(MasStoreAirForceDepot airForceDepot: masStoreAirForceDepotList){ 
					if(airForceDepot.getId()==supplyDepot){
					%>
	<option value="<%=airForceDepot.getId() %>" selected="selected"><%=airForceDepot.getAirForceDepotName()%></option>
	<%}else{ %>
	<option value="<%=airForceDepot.getId() %>"><%=airForceDepot.getAirForceDepotName()%></option>
	<%}} %>
</select> 

<div class="clear"></div>
<label>Type of Indent</label>
<select name="<%= RequestConstants.TYPE_OF_INDENT%>" id="typeOfIndent">
	<option value="">Select</option>
	<%if(indentOption==1){ %>
	<option value="1" selected="selected">Emergent</option>
	<%}else{ %>
	<option value="1">Emergent</option>
	<%}%>
	<%if(indentOption==2){ %>
	<option value="2" selected="selected">Monthly</option>
	<%}else{ %>
	<option value="2">Monthly</option>
	<%}%>
	<%if(indentOption==3){ %>
	<option value="3" selected="selected">Bi-Monthly</option>
	<%}else{ %>
	<option value="3">Bi-Monthly</option>
	<%}%>
	<%if(indentOption==4){ %>
	<option value="4" selected="selected">Four Monthly</option>
	<%}else{ %>
	<option value="4">Four Monthly</option>
	<%}%>
</select> 
<label>Postal Address</label> 
 <textarea name="address2" rows="2" cols="30" readonly="readonly" id="address" class="txtarea"><%=address %></textarea>
<input type="hidden" name="<%=RequestConstants.ADDRESS %>"	value="<%=address %>" />

<label>Authority</label>
<textarea name="Authority1" cols="27" rows="2" readonly="readonly" id="Authority" class="txtarea"><%=authority %>
</textarea>
 <input type="hidden" name="<%=RequestConstants.AUTHORITY %>" value="<%=authority %>" /> 
 
 <div class="clear"></div>
 


<label>Contact/Tell No.</label>
<input type="text" id="conNo" name="<%=CONTACT_NUMBER %>" value="" maxlength="10" tabindex="1" readonly="readonly"/>
 <%} %>
 
 
</div>

<div class="clear"></div>

</div>
<h4>Item Details</h4>
<%--
<div id="pagination">
Page No.

<span class="selected"><%=pageNo%></span>
 --%>
</div>
<div class="clear"></div>

<table width="100%" colspan="7" id="indentDetails" border="0" cellpadding="0" cellspacing="0">
	<thead>
		
<tr>
			<th>Sl No.</th>
			<th width="5%">PVMS/NIV No.</th>
			<th width="15%">Nomenclature</th>
			<th width="2%">A/U</th>
			<th width="15%">Qty	In Stock</th>
			<th width="15%">Qty Auth.</th>
			<th width="24%">Qty	Demanded</th>
			</tr>

	</thead>
	<tbody>



		
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
    	 String remarks="remarks";
    	  String remarks2="remarks";
    	  String remarksTemp="remarksTemp";
    	  String remarksTemp2="remarksTemp";
    	  String costTemp="costTemp";
    	  String costTemp2="costTemp";
    	  String cost="cost";
    	  String cost2="cost";
    	if(pageNo!=1)
    	{
    		temp=detailCounter*(pageNo-1);
    	}
     	 for(int inc=1;inc<=detailCounter;inc++){
     		 
     		 //for(int inc=1;inc<=1;inc++){
     		 
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
     		section=section+(""+inc);
     		
     		remarks=remarks2+(""+inc);
     		  remarksTemp=remarksTemp2+(""+inc);
     		 costTemp=costTemp2+(""+inc);
     		cost=cost2+(""+inc);
    	  %>
		<tr>
			<td>
			<input type="text" size="2" value="<%=temp+inc%>" name="<%=RequestConstants.SR_NO%>"
				readonly="readonly" />
				
			</td>
			
			
			<td >
			
			<input name="<%=RequestConstants.ITEM_CODE %>"
				type="text" id="<%=codeItem%>" size="12"
				readonly="readonly" /> <input type="hidden" value="0"
				name="<%=RequestConstants.ITEM_ID%>" id="<%=idItem%>" />
			 <input	type="hidden" value="0"	name="<%=RequestConstants.DEPARTMENT_ID_TEMP%>"	id="<%=departmentId%>" />
			 
			 </td>
			 
			 
			<td>
			
			<input type="text"  size="45" value="" tabindex="1" id="<%=nameItem%>" 
				onblur="if(fillSrNo('<%=inc %>')){checkForIndentToDepot(this.value, '<%=nameItem%>','<%=inc %>');}"
				name="<%=nameItem%>" />
			<div id="ac2update" style="display: none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			function eventCallback(element, entry){
				return entry + "&sec=" + document.getElementById('sectionId2').value;
			}
			  new Ajax.Autocompleter('<%=nameItem%>','ac2update','neStores?method=getItemListForIndentToDepot',{parameters:'requiredField=<%=nameItem%>&indentId='+document.getElementById('indentId').value, callback: eventCallback });
			</script>
			
			</td>
			
			<td width="3%">
			<input name="<%=RequestConstants.AV%>"	type="text" id="<%=idAu%>" value="" size="9" readonly="readonly" />
			
			</td>
			<%--
			<td width="10%">
			
			<input type="text" value="" id="<%=section%>"  readonly="readonly" />
			
			</td>
			 --%>
			 
			<td >
			
			<input type="text" readonly="readonly" value="" name="" MAXLENGTH="7" id="<%=qtyInHandTemp%>"
				validate="Qty In Stock,num,no" />
				
			<input type="hidden" value="0" name="<%=RequestConstants.QTY_IN_HAND%>"	id="<%=qtyInHand%>" />
			
			</td>

			<td>
			
			<input type="text" value="" tabindex=1 name="<%=RequestConstants.QTY_IN_MMF_TEMP%>"
				MAXLENGTH="7" id="<%=mmfVarTemp%>" validate="Qty In MMF,num,no"
				onblur="fillValuesForMmf(<%=inc%>);" /> 
				
			<input type="hidden" value="0"  name="<%=RequestConstants.QTY_IN_MMF%>"
				tabindex="2" id="<%=mmfVar%>" />
				
			</td>
			
			
			<td>
			
			<input type="text" size="8"  value="0" name="<%=RequestConstants.QTY_DEMAND%>" MAXLENGTH="7"
				tabindex="1" id="<%=demandVar%>" onblur="checkQty(<%=inc%>);" validate="Qty In Demand,num,no" /> <input type="hidden"
				class="medcaption" value="0" name="<%=RequestConstants.QTY_DEMAND_TEMP%>" tabindex="2"
				id="<%=demandVarTemp%>" />
				
			</td>
			
			<%--
			<td width="10%">
			
			<input type="text" size="7" value="" name="<%=RequestConstants.COST_PRICE%>" MAXLENGTH="7"
				tabindex="1" id="<%=costTemp%>" onblur="fillCostForSOC(<%=inc%>);"validate="Cost,num,no" /> 
				
				<input type="hidden" size="7" value="0" name="<%=RequestConstants.COST%>"
				MAXLENGTH="7" tabindex="1" id="<%=cost%>"
				validate="Qty In Demand,num,no" />
				
			</td>
 
			<td width="13%">
			
			<input type="text" name="<%=RequestConstants.REMARKS_TEMP%>" id="<%=remarksTemp %>"
				 validate='Remarks,String,no' onchange="fillRemarksForIssueCiv('<%=inc %>')" /> 
				 
				<input type="hidden" name="<%=RequestConstants.REMARKS%>" value="emptyString" class="medcaption" id="<%=remarks %>" />
				
			</td>
			
--%>			
		</tr>
		<% }  %>
		
	</tbody>
</table>

<div class="division"></div>
<input type="button" class="button" value="Next"	onclick="if( test()&&checkForNext()){submitForm('indentGrid','neStores??method=addNextOrSubmitIndentToDepot&buttonName=next');}"/>
<input type="button" name="sss" class="button" value="SAVE" onclick="if(test()&&checkForSubmit()&& checkSave()){submitForm('indentGrid','neStores?method=addNextOrSubmitIndentToDepot&buttonName=submit');}" />
<input type="button" name="sss" class="button" value="SEARCH" onclick="getSearchBlock();" /> 
<!-- 
<input type="button" name="sss" class="button" value="PRINT"	onclick="submitForm('indentGrid','login?method=showHomeJsp');" />
<input type="button" name="sss" class="button" value="EXPORTTOEXCEL"	onclick="submitForm('indentGrid','login?method=showHomeJsp');" />
 -->
<div class="clear"></div>
<div class="division"></div>
<div class="bottom">
<label>Changed By:</label>
<label class="value"><%=userName%></label>

<label>Changed Date:</label>
<label class="value"><%=date%></label>

<label>Changed Time:</label>
<label class="value"><%=time%></label>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
<div class="clear"></div>
</form>
<script type="text/javascript">vBulletin_init();</script> 
<input	type="hidden" name="rows" id="rr" value="1" /></div>

