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
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Collections"%>
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot"%>
<%@page import="jkt.hms.util.Box"%>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/stores.js"></script>
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
%>
	serverdate = '<%=date1+"/"+month1+"/"+year1%>'
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
		ajaxFunctionForAutoCompleteIndentToDepotSt('indent','stores?method=fillItemsForIndentToDepot&pvmsNo=' +  pvms , inc);
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
	if((document.getElementById('supplyDepot').value != 0)  &&(document.getElementById('typeOfIndent').value != "") )
		{
		return true;
	}else{
		alert(errorMessage)
		return false
	}

}
// javed khan 
function autocompleteBasedOnPvms(val,inc)
{

	var sec=document.getElementById('sectionId2').value;
	//var pvms=document.getElementById("pvms"+inc).value;
	 for(i=1;i<=8;i++){
	if(val !=""){
		if(document.getElementById("codeItem"+i)!=null){
			
			 if(document.getElementById("codeItem"+i).value==val && i!=inc){
				
			 alert("PVMS No. is already Selected");
			 document.getElementById("codeItem"+inc).value="";
			 return false;
			 }
			 }}}
	ajaxFunctionForAutoCompleteForGrn('indentGrid','stores?method=fillItemsCommon&pvmsNo=' +  val+'&sec='+sec , inc);
	ajaxFunctionForAutoCompleteIndentToDepotSt('indent','stores?method=fillItemsForIndentToDepot&pvmsNo=' +  val , inc);
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
function autoIndent(){
	alert("For Auto Indent");
}
</script>
<script type="text/javascript">
function setSecId(){
var secId=document.getElementById('sectionId1').value;
document.getElementById('sectionId2').value=secId;
//alert(document.getElementById('sectionId2').value);
}
</script>


<script type="text/javascript">
function fillValuesForDemand(inc)
{

	if(document.getElementById('demandVar'+inc).value!="")
  	document.getElementById('demandVarTemp'+inc).value=document.getElementById('demandVar'+inc).value
}

// add javed khan
function getSearchBlock()
{

document.getElementById('searchBlock').style.display = 'inline';
}
//add javed khan
function closeSearch()
{

document.getElementById('searchBlock').style.display = 'none';
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
	 if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
	//--------Hearder Variables-------
	int indentId=0;
	int supplyDepot=0;
	int sectionId=0;
	int indentOption=0;
	String indentFrom="";
	String indentDate="";
	String indentNo="";
	String  nrs="";
	String authority="";
	String address="";

	String codehead="";
	String ctNo="";
	String hosNameAdd="";
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
	if(map.get("contactNo") !=null)
	ctNo=""+map.get("contactNo");

	if(map.get("codehead") !=null)
		codehead=""+map.get("codehead");
	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt(""+map.get("pageNo"));
	}
	if(map.get("maxIndentNo")!=null)
		maxIndentNo=(""+map.get("maxIndentNo"));
	
	


	if(map.get("masStoreAirForceDepotList")!=null)
		masStoreAirForceDepotList=(List) map.get("masStoreAirForceDepotList");
	if(map.get("objectList")!=null)
		objectList=(List) map.get("objectList");
	if(map.get("searchIndentList")!=null)
	searchIndentList = (List<StoreIndentM>) map.get("searchIndentList");
	if(map.get("sectionList")!=null)
	storeSectionList = (List<MasStoreSection>)map.get("sectionList");
	if(map.get("hosNameAdd")!=null)
		hosNameAdd=map.get("hosNameAdd").toString();
	}catch(Exception e){
		e.printStackTrace();
	}
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	String jspFlag="";
	if (map.get("jspFlag") != null) {
		jspFlag = ""+map.get("jspFlag");
	}
	int indentLength=0;
	if(map.get("indentLength")!=null)
		indentLength= Integer.parseInt(""+map.get("indentLength")) ;
	
	System.out.println("jspFlag >>>>>>"+jspFlag+"indentLength>>>>"+indentLength);
%>


<div class="titleBg"><h2>Indent To Depot</h2></div>
 <div id="searchBlock" style="display:none;">
<form name="indent" method="post">
<div class="clear"></div>
<h6>SEARCH</h6>
<div class="clear"></div>
<div class="Block">
<form name="" method="">
<!-- -
<div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div>
<div class="clear"></div>
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<form name="searchPanel" method="post">-->

<label>From Date :</label> 
<input type="text" name="<%= FROM_DATE %>" onkeyup="mask(this.value,this,'2,5','/');"	 MAXLENGTH="30" id="fromDate" tabindex=1 onblur="validateExpDate(this,'fromDate');" />
<img id="calendar"  src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
				          onClick="setdate('<%=currentDate%>',document.indent.<%= FROM_DATE%>,event)" />

<label >To Date :</label> 
<input type="text" id="toDate" name="<%= TO_DATE %>" MAXLENGTH="30"  tabindex=1 onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'toDate');"  />
 <img id="calendar"  src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
				 onClick="setdate('<%=currentDate%>',document.indent.<%= TO_DATE%>,event)" />
<div class="clear"></div>				 

<label>Indent No.</label>
<select name="<%= RequestConstants.INDENT_NO_FOR_SEARCH%>">
			<option value="0">Select</option>
			<%	for (StoreIndentM storeIndentM :searchIndentList ) {	%>
			<option value=<%=storeIndentM.getId()%>><%=storeIndentM.getIndentNo()%></option>
			<% }%>
		</select>
<!-- <input type="button" name="sss" class="button" value="SEARCH" 	onClick="submitForm('indent','stores?method=searchIndentDepot');" /> -->

<input type="button" name="sss" class="button" value="SEARCH" 	onClick="submitForm('indent','stores?method=newSearchIndent');" />
<input type="button" name="sss" class="button" value="CLOSE"  onClick="closeSearch();" />

<!-- </form>
</div>
  -->
<%-- End of Search Panel--%> <br />
</form>
</div>
</form>
</div>
<div class="clear"></div>
<form name="indentGrid" method="post">
<div id="testDiv">
<h4>Indent Details</h4>
<div class="clear"></div>
<div class="Block">
<input type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo" />
<input type="hidden" size="2" value="0" name="<%=RequestConstants.NO_OF_ROWS%>"id="<%=RequestConstants.NO_OF_ROWS%>" />
<input type="hidden" name="<%=RequestConstants.INDENT_ID %>" value="<%=indentId%>" id="indentId" />
	 <%if(indentId==0){%>
<label> Indent No.</label>
 <input type="text" name="<%=RequestConstants.INDENT_NO %>"  value="<%=maxIndentNo%>" readonly="readonly" />
 <!-- -
 <label	>Indentor :</label>
 <input	type="text" readonly="readonly"	name="<%=RequestConstants.INDENT_FROM %>" value="Commandant,CHAFB"
	MAXLENGTH="20" />  -->
<label>Indent Date</label>
<input type="text" name="<%=RequestConstants.INDENT_DATE%>" readonly="readonly"value="<%=date %>" MAXLENGTH="30" />

<label>Supply Depot<span>*</span></label>
<select	name="<%= RequestConstants.SUPPLY_DEPOT%>"   validate="Supply Depot,string,yes"      id="supplyDepot"	tabindex="1">
	<option value="0">Select</option>
	<%for(MasStoreAirForceDepot airForceDepot: masStoreAirForceDepotList){ %>
	<option value="<%=airForceDepot.getId() %>"
		<%=HMSUtil.isSelected(airForceDepot.getId().toString(),box.get("supplyDepot")) %>><%=airForceDepot.getAirForceDepotName()%></option>
	<%} %>
</select>

<div class="clear"></div>

<label>Type of Indent<span>*</span></label>
<select name="<%= RequestConstants.TYPE_OF_INDENT%>" validate="Type of Indent,string,yes"  id="typeOfIndent"	tabindex="1">
	<option value="">Select</option>
	<option value="1">Emergent</option>
	<option value="2">3 Months</option>
	<option value="3">6 Months</option>
	<option value="4">Replacement</option>
	<option value="5">Disaster</option>
	<!--
	<option value="4">Four Monthly</option>
-->
</select>

<label>Postal Address</label>
<textarea name="<%=RequestConstants.ADDRESS%>" 	MAXLENGTH="200" rows="2" cols="30" id="address" class="txtarea" tabindex="1"><%=hosNameAdd%></textarea>

<label> Authority</label>
<textarea name="<%=RequestConstants.AUTHORITY%>" MAXLENGTH="100" tabindex="1"
	cols="27" rows="2" id="Authority" class="txtarea">
</textarea>
<div class="clear"></div>
<label>Life Span</label>

		<select value="0" name="<%=SHELF_LIFE%>"  id="sl" validate="Life,string,no" tabindex=1>
		
		<!--<option value="SLB">SLB</option>
		--><option value="LL">LL</option>
		<option value="SL">SL</option>
		</select>

<label>Section</label>
<%if(map.get("fromShowItem")!=null){%>
				<select id="sectionId1" name="sectionId"   onchange="populatePvmsNo(this.value)" tabindex=1>
				</select>
				<%}else{%>
				<select  name="sectionId" id="sectionId1"  onchange="setSecId();" tabindex=1>

				<option value="0">Select</option>
				  <%
				  for(MasStoreSection masStoreSection : storeSectionList) {
				  %>
				  <option value="<%=masStoreSection.getId()%>" ><%=masStoreSection.getSectionName()%></option>
				  <%}%>
				</select>
					<% }%>
				<input type="hidden" id="sectionId2" value="0" name="sec"/>

<!--
<label> NRS</label>
<input	type="text" name="<%= RequestConstants.NRS %>" value="" MAXLENGTH="30" id="nrs" tabindex="1"/>
-->
<div class="clear"></div>
<label>Contact No.</label>
<input type="text" name="<%=CONTACT_NUMBER %>" id="conNo" value="" maxlength="12" tabindex="1"/>
<%--
<label>Code Head <span>*</span></label>
<input	type="text" name="<%= RequestConstants.CODE_HEAD%>" value="749/02" validate="Code Head,string,yes" MAXLENGTH="30" id="codehead" tabindex="1"/> --%>
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
	<option value="2" selected="selected">3 Months</option>
	<%}else{ %>
	<option value="2">3 Months</option>
	<%}%>
	<%if(indentOption==3){ %>
	<option value="3" selected="selected">6 Months</option>
	<%}else{ %>
	<option value="3">6 Months</option>
	<%}%>
	<%if(indentOption==5){ %>
	<option value="5" selected="selected">Replacement</option>
	<%}else{ %>
	<option value="5">Replacement</option>
	<%}%>
		<%if(indentOption==6){ %>
	<option value="6" selected="selected">Disaster</option>
	<%}else{ %>
	<option value="6">Disaster</option>
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

 <label>Life Span</label>

		<select value="0" name="<%=SHELF_LIFE%>"  id="sl" validate="Life,string,no" tabindex=1>
		<option value="SL">SL</option>
		<!--
		<option value="SLB">SLB</option>
		--><option value="LL">LL</option>
		</select>

<label>Section Name</label>
<%if(map.get("fromShowItem")!=null){%>
				<select id="sectionId1" name="sectionId"   onchange="populatePvmsNo(this.value)" tabindex=1>
				</select>
				<%}else{%>
				<select  name="sectionId" id="sectionId1"  onchange="setSecId();" tabindex=1>

				<option value="0">Select</option>
				  <%
				  for(MasStoreSection masStoreSection : storeSectionList) {
				  %>
				  <option value="<%=masStoreSection.getId()%>" ><%=masStoreSection.getSectionName()%></option>
				  <%}%>
				</select>
					<% }%>
				<input type="hidden" id="sectionId2" value="0" name="sec"/>
				<!--
 <label>NRS</label>
<input	type="text" readonly="readonly" name="nrs1" value="<%=nrs%>" MAXLENGTH="30" id="nrs" />
<input type="hidden" name="<%= RequestConstants.NRS %>" value="<%=nrs%>" MAXLENGTH="30" />
-->
<div class="clear"></div>
<label>Contact No.</label>
<input type="text" id="conNo" name="<%=CONTACT_NUMBER %>" value="<%=ctNo %>" maxlength="10" tabindex="1" readonly="readonly"/>
 <label> Code Head</label>
<input	type="text" name="<%= RequestConstants.CODE_HEAD%>" value="<%=codehead%>" validate="Code Head,string,no" MAXLENGTH="30" id="codehead" tabindex="1" />

 <%}%>


</div>


</div>
<h4>Item Details</h4>
<div id="pagination">
Page No.
<span class="selected"><%=pageNo%></span>
</div>
<div class="clear"></div>
<table width="100%" colspan="7" id="indentDetails" border="0" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th>Sl No.</th>
			<!--<td width="5%">New PVMS No</label>
      -->
			<th width="5%">PVMS No.</th>
			<th width="15%">Nomenclature</th>
			<th width="3%">A/U</th>
			<!--<th width="15%">Section</th>
			-->
			<th width="15%">MMF</th>
			<th width="15%">Qty in Stock </th>
			<th width="24%">Qty Demanded</th>
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
    	if(pageNo!=1 && jspFlag.equals(""))
    	{
    		temp=detailCounter*(pageNo-1);
    	}
    	else if(pageNo!=1 && jspFlag.equals("auto"))
    	{
    		temp=indentLength;
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
		<td width="3%"><input type="text" size="2" value="<%=temp+inc%>"  name="<%=RequestConstants.SR_NO%>"
			readonly="readonly" /></td>

		<td width="5%">
		<input name="<%=RequestConstants.ITEM_CODE %>" type="text"  id="<%=codeItem%>"
			size="12" onblur="autocompleteBasedOnPvms(this.value,'<%=inc%>');" tabindex="1"/>
		<input type="hidden" value="0" name="<%=RequestConstants.ITEM_ID%>"id="<%=idItem%>" />
		<input type="hidden" value="0" name="<%=RequestConstants.DEPARTMENT_ID_TEMP%>"id="<%=departmentId%>" />
		</td>

		<td width="15%">
		<input type="text" value="" id="<%=nameItem%>"  name="<%=nameItem%>" size ="100" onblur="if(fillSrNo('<%=inc %>')){checkForIndentToDepot(this.value, '<%=nameItem%>','<%=inc %>');fillValuesForDemand(<%=inc%>);}" tabindex="1"  />

		<div id="ac2update" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
		function eventCallback(element, entry){
			return entry + "&sec=" + document.getElementById('sectionId2').value+"&sl="+document.getElementById('sl').value;
		}
		  new Ajax.Autocompleter('<%=nameItem%>','ac2update','stores?method=getItemListForIndentToDepot',{parameters:'requiredField=<%=nameItem%>&indentId='+document.getElementById('indentId').value, callback: eventCallback});
		</script>
		</td>

		<td width="3%"><input name="<%=RequestConstants.AV%>" type="text" tabindex="1"  id="<%=idAu%>" value=""
			size="9" onblur="fillValuesForDemand(<%=inc%>);" readonly="readonly" /><input type="hidden" value="" id="<%=section%>" tabindex="1"  readonly="readonly" />
		</td>

		<td width="15%"><input type="text" tabindex="1" size="7" value=""  tabindex=1
			name="<%=RequestConstants.QTY_IN_MMF_TEMP%>" MAXLENGTH="7"
			id="<%=mmfVarTemp%>" validate="Qty In MMF,floatWithoutSpaces,no"
			onblur="fillValuesForMmf(<%=inc%>);" />
	  <input type="hidden"	value="0"  name="<%=RequestConstants.QTY_IN_MMF%>"
			tabindex="2" id="<%=mmfVar%>" /></td>

		<td width="15%"><input type="text" value="0" size="7"
			tabindex="1" name="<%=RequestConstants.QTY_IN_HAND%>" MAXLENGTH="7"
			id="<%=qtyInHand%>" validate="Qty In Stock,num,no"  readonly/> <!--
        <input type="hidden"	value="0"    name="<%=RequestConstants.QTY_IN_HAND%>"  id="<%=qtyInHandTemp%>" />
          -->
         </td>



		<td width="24%">

		<input type="text" size="10" tabindex="1"  value="0"
			 name="<%=RequestConstants.QTY_DEMAND%>" MAXLENGTH="7" tabindex="1" id="<%=demandVar%>"
			 onblur="fillValuesForDemand(<%=inc%>);" validate="Qty In Demand,floatWithoutSpaces,no" />
			<input type="hidden"  value="0" name="<%=RequestConstants.QTY_DEMAND_TEMP%>" tabindex="2" id="<%=demandVarTemp%>"/>
		</td>
	</tr>
	<% }   %>

</tbody>
</table>
<div class="clear"></div>


<!--<input type="button" class="buttonBig" value="Import Pending Item" name="importPendingItem" />
<input type="button" class="buttonBig" value="Import Previous Indent" name="importPreviousIndent" />
-->
<input type="button" class="button" value="Next"	onclick="if( test()&&checkForNext()){submitForm('indentGrid','stores?method=addNextOrSubmitIndentToDepot&buttonName=next');}"/>
<input type="button" name="sss" class="button" value="Update" onclick="if(test()&&checkForSubmit()){submitForm('indentGrid','stores?method=addNextOrSubmitIndentToDepot&buttonName=submit');}" />
<input	type="button" name="Add" onClick="jsSubmit()" value="Submit"	class="button" />
<!-- <input type="button" class="button" value="Print" name="print" />
<input type="button" class="buttonBig" value="Export to Excel" name="exportToExcel" /> -->
<input type="button" name="sss" class="button" value="SEARCH" onclick="getSearchBlock();" /> 





<input type="hidden" name="sss" class="button" value="Exit"	onclick="submitForm('indentGrid','login?method=showHomeJsp');" />

<div class="clear"></div>
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
<script type="text/javascript">
function jsSubmit()
{
	if(test()&& checkSaveSubmit()){submitForm('indentGrid','stores?method=addNextOrSubmitIndentToDepot&buttonName=close');}
	
		
		
}
function checkSaveSubmit()
{
		if(confirm("After submit, you can't add new item or change existing item.Kindly confirm ?"))
			return true;
		else
			return false;
}
</script>
<script type="text/javascript">vBulletin_init();</script>
<input	type="hidden" name="rows" id="rr" value="1" /></div>
