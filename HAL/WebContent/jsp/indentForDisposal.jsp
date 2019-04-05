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
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreIndentT"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="java.util.Iterator"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot"%>
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
	function fillCostForSOC(rowVal){

	if(document.getElementById('costTemp'+rowVal).value==''){
		document.getElementById('cost'+rowVal).value=0
	}else{
		document.getElementById('cost'+rowVal).value=document.getElementById('costTemp'+rowVal).value
	}

}
	function checkForIndentToDepot(val,a,inc){
		var pageNo =parseInt(document.getElementById('pageNo').value) 
		var start=((pageNo-1)*8)+1;
    	var end=((pageNo-1)*8)+8;
    	
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	    for(i=start;i<=end;i++){
	    if(pvms !="")
	    if(document.getElementById('codeItem'+i).value==pvms){
	    if(document.getElementById('codeItem'+inc).value!=pvms){
	    	alert("Item already selected...!")
	    	document.getElementById('nameItem'+inc).value=""
	    	
	    	return false;
	    	}
	    }}
		ajaxFunctionForAutoCompleteIndentToDepot('indent','nonExp?method=fillItemsForIndentToDepot&pvmsNo=' +  pvms , inc);
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
</script>
<%
	Map map = new HashMap();
	String includedJsp = null;
	String previousPage="no";
	int pageNo=1;
	String noDetailRecords="no";
	String entryType="";
	List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();
	List<StoreIndentM> gridIndentMList = new ArrayList<StoreIndentM>();
	List<StoreIndentT> gridIndentTList = new ArrayList<StoreIndentT>();
	List<MasStoreItem> itemList= new ArrayList<MasStoreItem>();
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
	if(map.get("entryType")!=null)
		entryType =""+map.get("entryType");
	
	
	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt(""+map.get("pageNo"));
	}
	if(map.get("maxIndentNo")!=null)
		maxIndentNo=(""+map.get("maxIndentNo"));
	
	
	
	if(map.get("objectList")!=null)
		objectList=(List) map.get("objectList");
	if(map.get("searchIndentList")!=null)
	searchIndentList = (List) map.get("searchIndentList");
	if(map.get("itemList")!=null)
		itemList=(List) map.get("itemList");
	if(map.get("gridIndentMList")!=null)
		gridIndentMList=(List) map.get("gridIndentMList");
	if(map.get("gridIndentTList")!=null)
		gridIndentTList=(List) map.get("gridIndentTList");
	if(map.get("noDetailRecords")!=null){
		noDetailRecords=(""+map.get("noDetailRecords"));
		System.out.print("------------------------ In Jsp itemList "+noDetailRecords);
	}
	if(map.get("masStoreAirForceDepotList")!=null)
		masStoreAirForceDepotList=(List) map.get("masStoreAirForceDepotList");

	}catch(Exception e){
		e.printStackTrace();
	}
	
%>

<br />

<style>
#contentspace label {
	text-align: right;
	width: 91px;
	float: left;
	height: 9px;
}
</style>

<h2 align="left" class="style1">Indent To Depot(Disposal Entry)</h2>

<div id="contentspace">

<form name="indent" method="post">
<table class="tborder" width="100%" align="center">
	<tr>
		<td width="20%" nowrap="nowrap" class="vbmenu_control"
			id="threadsearch"><a href="">Search</a> <script
			type="text/javascript"> vbmenu_register("threadsearch"); </script></td>
		<td width="80%"><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>


		<table width="20%" align="right" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="5%"><IMG SRC="/hms/jsp/images/toolBar_01.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
				<td width="7%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Add" type="submit" value="Add"
					class="toolbutton"></td>
				<td width="1%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="10%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Modify" type="submit" value="Modify"
					class="toolbutton"
					onClick="submitForm('poMain','purchaseOrder?method=poModifyJsp');"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Reset" type="submit" value="Reset"
					class="toolbutton"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Delete" type="submit" value="Delete"
					class="toolbutton"></td>
				<td width="4%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Modify" value="Print" class="toolbutton"
					onClick="submitForm('indent','nonExp?method=showPrintIndentDepotJsp');" /></td>
				<td width="39%"><IMG SRC="/hms/jsp/images/closeButton.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
			</tr>
		</table>
		</td>
	</tr>
</table>



<div align="center">
<div style="padding: 0px 25px 0px 25px"><!-- thread search menu -->
<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">

<form name="searchPanel" method="post">
<table width="303" border="0" cellpadding="2" cellspacing="1">
	<tr>
		<td class="thead">Search Panel<a name="goto_threadsearch"></a></td>
	</tr>
	<tr>
		<td class="vbmenu_option" title="nohilite"><label
			class="bodytextB">Indent No:</label> <select
			name="<%= RequestConstants.INDENT_NO_FOR_SEARCH%>">
			<option value="0">Select</option>
			<%
					for (StoreIndentM storeIndentM :searchIndentList ) {
				%>

			<option value=<%=storeIndentM.getId()%>><%=storeIndentM.getIndentNo()%></option>

			<%
					}
				%>
		</select> <input type="button" class="morebutton" value=" "
			onClick="submitForm('indent','nonExp?method=searchIndentDepot');" />
		</td>
	</tr>

</table>
</form>
</div>
</div>
</div>
<br />
</form>

<form name="indentForDisposal" method="post">
<div id="testDiv" size="height:500px;"><input type="hidden"
	name="pageNo" value="<%=pageNo%>" id="pageNo" /> <input type="hidden"
	name="entryType" value="<%=entryType%>" id="entryType" /> <input
	type="hidden" size="2" value="0"
	name="<%=RequestConstants.NO_OF_ROWS%>"
	id="<%=RequestConstants.NO_OF_ROWS%>" /> <input type="hidden"
	name="<%=RequestConstants.INDENT_ID %>" value="<%=indentId%>"
	id="indentId" /> <input type="hidden"
	name="<%=RequestConstants.NO_DETAIL_RECORDS%>"
	value="<%=noDetailRecords%>" /> <%if(pageNo==1){
				for(StoreIndentM storeIndentM:gridIndentMList){
			%>




<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Indent Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 130px; background-color: #f4f9fe; padding-top: 10px; padding-bottom: 5px;">




<label class="bodytextB"><font id="error"></font> Indent No:</label> <input
	type="text" name="<%=RequestConstants.INDENT_NO %>"
	value="<%=storeIndentM.getIndentNo()%>" readonly="readonly"
	class="textbox_size20" MAXLENGTH="8"/  > <label
	class="bodytextB"><font id="error"></font>Indentor:</label> <input
	type="text" readonly="readonly"
	name="<%=RequestConstants.INDENT_FROM %>" value="Commandant,CHAFB"
	class="textbox_size20" MAXLENGTH="20" /> <label class="bodytextB"><font
	id="error"></font>Indent Date:</label> <input type="text"
	name="<%=RequestConstants.INDENT_DATE%>" readonly="readonly"
	value="<%=HMSUtil.changeDateToddMMyyyy(storeIndentM.getIndentDate())%>"
	class="textbox_size20" MAXLENGTH="30" /> <br />
<label class="bodytextB"><font id="error"></font>Supply Depot:</label> <select
	name="<%= RequestConstants.SUPPLY_DEPOT%>"
	validate="Supply Depot,String,yes">
	<option value="0">Select</option>
	<%
					try{
					for(MasStoreAirForceDepot airForceDepot: masStoreAirForceDepotList){ 
						if(storeIndentM.getSuppliedBy() !=null ){
					if(airForceDepot.getId()==storeIndentM.getSuppliedBy().getId()){
					%>
	<option value="<%=airForceDepot.getId() %>" selected="selected"><%=airForceDepot.getAirForceDepotName()%></option>
	<%}else{ %>
	<option value="<%=airForceDepot.getId() %>"><%=airForceDepot.getAirForceDepotName()%></option>
	<%}}else{ %>
	<option value="<%=airForceDepot.getId() %>"><%=airForceDepot.getAirForceDepotName()%></option>
	<%}}
					}catch(Exception e){
						e.printStackTrace();
					}
					%>
</select> <label class="bodytextB"><font id="error"></font>Typ of Indent:</label>

<select name="<%= RequestConstants.TYPE_OF_INDENT%>"
	validate="Type Of Indent,num,yes">
	<option value="">Select</option>
	<%
					if(storeIndentM.getIndentOption() !=null){
					if(Integer.parseInt(""+1) ==1){ %>
	<option value="1" selected="selected">Emergent</option>
	<%}else{ %>
	<option value="1">Emergent</option>
	<%}%>
	<%if(Integer.parseInt(""+storeIndentM.getIndentOption())==2){ %>
	<option value="2" selected="selected">Monthly</option>
	<%}else{ %>
	<option value="2">Monthly</option>
	<%}%>
	<%if(Integer.parseInt(""+storeIndentM.getIndentOption())==3){ %>
	<option value="3" selected="selected">Bi-Monthly</option>
	<%}else{ %>
	<option value="3">Bi-Monthly</option>
	<%}%>
	<%if(Integer.parseInt(""+storeIndentM.getIndentOption())==4){ %>
	<option value="4" selected="selected">Four Monthly</option>
	<%}else{ %>
	<option value="4">Four Monthly</option>
	<%}}else{%>
	<option value="1">Emergent</option>
	<option value="2">Monthly</option>
	<option value="3">Bi-Monthly</option>
	<option value="4">Four Monthly</option>
	<%} %>
</select> <label class="bodytextB"><font id="error"></font>NRS:</label> <input
	type="text" name="<%= RequestConstants.NRS %>"
	value="<%=storeIndentM.getNrs() %>" class="textbox_size20"
	MAXLENGTH="30" validate="NRS,String,yes" /> <br />
<label class="bodytextB"><font id="error"></font>Authority:</label> <textarea
	name="<%=RequestConstants.AUTHORITY%>" cols="27" rows="2"
	class="txtarea"><%=storeIndentM.getAuthority() %></textarea> <label
	class="bodytextB"><font id="error"></font>Postal Address:</label> <%if(storeIndentM.getPatientDetails() !=null){ %>
<textarea name="<%=RequestConstants.ADDRESS%>" rows="2" cols="30"
	class="txtarea"><%=storeIndentM.getPatientDetails() %></textarea> <%}else{ %>
<textarea name="<%=RequestConstants.ADDRESS%>" rows="2" cols="30"
	class="txtarea"></textarea> <%} %> <%}}else{ %> <label class="bodytextB"><font
	id="error"></font> Indent No: </label> <input type="text"
	name="<%=RequestConstants.INDENT_NO %>" value="<%=indentNo%>"
	readonly="readonly" class="textbox_size20" MAXLENGTH="8"/  > <label
	class="bodytextB"><font id="error"></font>Indentor :</label> <input
	type="text" readonly="readonly"
	name="<%=RequestConstants.INDENT_FROM %>" value="Commandant,CHAFB"
	class="textbox_size20" MAXLENGTH="20" /> <label class="bodytextB"><font
	id="error"></font>Indent Date:</label> <input type="text" name=""
	readonly="readonly" value="<%=date%>" class="textbox_size20"
	MAXLENGTH="30" /> <input type="hidden"
	name="<%=RequestConstants.INDENT_DATE%>" value="<%=date %>"
	class="textbox_size20" MAXLENGTH="30" /> <br />
<label class="bodytextB"><font id="error"></font>Supply Depot :</label>
<select name="<%= RequestConstants.SUPPLY_DEPOT%>"
	validate="Supply Depot,String,yes">
	<option value="0">Select</option>
	<%for(MasStoreAirForceDepot airForceDepot: masStoreAirForceDepotList){ 
						if(airForceDepot.getId()==supplyDepot){					%>
	<option value="<%=airForceDepot.getId() %>" selected="selected"><%=airForceDepot.getAirForceDepotName()%></option>
	<%}else{ %>
	<option value="<%=airForceDepot.getId() %>"><%=airForceDepot.getAirForceDepotName()%></option>
	<%}} %>
</select> <label class="bodytextB"><font id="error"></font>Type of
Indent:</label> <select name="<%= RequestConstants.TYPE_OF_INDENT%>"
	validate="Type Of Indent,num,yes">
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
</select> <br />
<label class="bodytextB"><font id="error"></font>NRS:</label> <input
	type="text" readonly="readonly" name="nrs1" value="<%=nrs%>"
	class="textbox_size20" MAXLENGTH="30" validate="NRS,String,yes" /> <input
	type="hidden" name="<%= RequestConstants.NRS %>" value="<%=nrs%>"
	class="textbox_size20" MAXLENGTH="30" /> <br />
<label class="bodytextB"><font id="error"></font>Authority:</label> <textarea
	name="Authority1" cols="27" rows="2" readonly="readonly"
	class="txtarea"><%=authority %></textarea> <input type="hidden"
	name="<%=RequestConstants.AUTHORITY %>" value="<%=authority %>" /> <label
	class="bodytextB"><font id="error"></font>Postal Address:</label> <textarea
	name="address2" rows="2" cols="30" readonly="readonly" class="txtarea"><%=address %></textarea>
<input type="hidden" name="<%=RequestConstants.ADDRESS %>"
	value="<%=address %>" /> <%} %>
</div>
<br />



<div style="float: left; padding-left: 15px;"><input type="button"
	class="button" value="Next"
	onclick="if( checkSave()&&checkForNext()){submitForm('indentForDisposal','nonExp?method=nextIndentForDisposal&buttonName=next');}"
	align="right" /> <input type="button" name="sss" align="right"
	class="button" value="Submit"
	onclick="if( checkSave()&&checkForSubmit()){submitForm('indentForDisposal','nonExp?method=nextIndentForDisposal&buttonName=submit');}" />
</div>


<div style="float: left; padding-left: 15px; padding-bottom: 10px;">
<label class="bodytextB">Page No:</label>
<div class="changebydt" style="width: 65px;"><%=pageNo%></div>
</div>

<br />
<div
	style="overflow: auto; width: 100%; height: 220px; padding-left: 9px;">
<table width="100%" colspan="7" id="indentDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<td width="5%"><label valign="left" class="smalllabel">SR
			No</label></td>
			<td width="13%"><label valign="left" class="smalllabel">New
			PVMS No</label>
			<td width="13%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Nomenclature</label>
			</td>
			<td width="13%"><label valign="left" class="smalllabel">A/U</label>
			</td>
			<td width="13%"><label valign="left" class="smalllabel">Section</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Qty
			In Stock . </label></td>
			<td width="13%"><label valign="left" class="smalllabel">Qty
			Auth.</label></td>
			<td width="6%"><label valign="left" class="smalllabel">Qty
			Demand</label></td>
			<td width="24%"><label valign="left" class="smalllabel">Cost</label></td>
			<td width="24%"><label valign="left" class="smalllabel">Remarks</label></td>
		</tr>

	</thead>
	<tbody>
		<%
    	int inc=1;
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
    	String section="section";
    	String section2="section";
    	
    	String remarks="remarks";
  	  String remarks2="remarks";
  	  String remarksTemp="remarksTemp";
  	  String remarksTemp2="remarksTemp";
  	  String costTemp="costTemp";
  	  String costTemp2="costTemp";
  	  String cost="cost";
  	  String cost2="cost";
    	
    	
    	if(pageNo!=1){
    	inc=((pageNo-1)*8)+1;
    	}
 	   
 	   int incTemp2=inc+8;
 	   for(StoreIndentT storeIndentT:gridIndentTList){
 		 
 		  if(inc<=incTemp2){
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
     		remarks=remarks2+(""+inc);
   		  remarksTemp=remarksTemp2+(""+inc);
   		 costTemp=costTemp2+(""+inc);
   		cost=cost2+(""+inc);
    	  %>
		<tr>
			<td width="5%"><input type="text" size="2"
				value="<%=storeIndentT.getSerialNo()%>" class="smcaption"
				name="<%=RequestConstants.SR_NO%>" readonly="readonly" /></td>
			<td width="10%">
			<%if(storeIndentT.getItem().getPvmsNo()!=null){ %> <input type="text"
				value="<%=storeIndentT.getItem().getPvmsNo() %>" class="medcaption"
				name="<%=RequestConstants.NEW_NIV %>" readonly="readonly"
				id="<%=codeItem%>" /> <%}else{ %> <input type="text" value=" "
				class="medcaption" name="<%=RequestConstants.NEW_NIV %>"
				readonly="readonly" id="<%=codeItem%>" /> <%} %> <input type="hidden"
				name="<%=RequestConstants.DETAIL_ID %>"
				value="<%=storeIndentT.getId() %>" id="hdb" /></td>
			<td width="10%">
			<% if(storeIndentT.getItem().getOldNivNo() ==null){%> <input
				type="text" class="medcaption"
				name="<%=RequestConstants.ITEM_CODE %>" readonly="readonly"
				id="<%=oldNiv%>" value="" /> <%}else{ %> <input type="text"
				class="medcaption" name="<%=RequestConstants.ITEM_CODE %>"
				readonly="readonly" id="<%=oldNiv%>"
				value="<%=storeIndentT.getItem().getOldNivNo() %>" /> <%} %> <input
				type="hidden" value="<%=storeIndentT.getItem().getId() %>"
				name="<%=RequestConstants.ITEM_ID%>" id="<%=idItem%>" /></td>
			<td width="10%"><input type="text"
				value="<%=storeIndentT.getItem().getNomenclature() %>"
				readonly="readonly" tabindex="1" id="<%=nameItem%>"
				class="bigcaption"
				onblur="if(fillSrNo('<%=inc %>')){checkForIndentToDepot(this.value, '<%=nameItem%>','<%=inc %>');}"
				name="<%=nameItem%>" /></td>
			<td width="10%">
			<%try{ %> <input type="text"
				value="<%=storeIndentT.getItem().getItemConversion().getItemUnitName() %>"
				class="smcaption" readonly="readonly"
				name="<%=RequestConstants.AV%>" id="<%=idAu%>" /> <%}catch(Exception e){ %>
			<input type="text" class="smcaption" /> <%} %>
			</td>
			<%try{ %>
			<td width="10%"><input type="text"
				value="<%=storeIndentT.getItem().getSection().getSectionCode() %>"
				id="<%=section%>" class="smcaption" readonly="readonly"></td>
			<%}catch(Exception e){ %>
			<td width="10%"><input type="text" class="smcaption"
				id="<%=section%>" value="" size="8" readonly="readonly"></td>
			<%} %>
			<%if(storeIndentT.getStockIn()!=null){ %>
			<td width="10%"><input type="text" readonly="readonly"
				value="<%=storeIndentT.getStockIn() %>" class="medcaption" name=""
				id="<%=qtyInHandTemp%>" /> <input type="hidden"
				value="<%=storeIndentT.getStockIn() %>" class="medcaption"
				name="<%=RequestConstants.QTY_IN_HAND%>" id="<%=qtyInHand%>" /></td>
			<%}else{ %>
			<td width="10%"><input type="text" readonly="readonly" value="0"
				class="medcaption" name="" id="<%=qtyInHandTemp%>" /> <input
				type="hidden" value="0" class="medcaption"
				name="<%=RequestConstants.QTY_IN_HAND%>" id="<%=qtyInHand%>" /></td>
			<%} %>
			<%if(storeIndentT.getQtyInMmf()!=null){ %>
			<td width="10%"><input type="text" MAXLENGTH="7" value="1"
				readonly="readonly" class="medcaption" tabindex=1
				name="<%=RequestConstants.QTY_IN_MMF_TEMP%>" id="<%=mmfVarTemp%>"
				onblur="fillValuesForMmf(<%=inc%>);" /> <input type="hidden"
				readonly="readonly" value="" class="medcaption"
				name="<%=RequestConstants.QTY_IN_MMF%>" tabindex="2"
				id="<%=mmfVar%>" /></td>
			<%}else{ %>
			<td width="10%"><input type="text" MAXLENGTH="7" value=""
				readonly="readonly" class="medcaption" tabindex=1 name="0"
				id="<%=mmfVarTemp%>" onblur="fillValuesForMmf(<%=inc%>);" /> <input
				type="hidden" value="" class="medcaption" name="0" tabindex="2"
				id="<%=mmfVar%>" /></td>
			<%} %>
			<td width="10%"><input type="text" size="7" MAXLENGTH="7"
				class="medcaption" value="<%=storeIndentT.getQtyInDemand() %>"
				readonly="readonly" name="<%=RequestConstants.QTY_DEMAND%>"
				tabindex="1" id="<%=demandVar%>"
				onblur="fillValuesForDemand(<%=inc%>);" /> <input type="hidden"
				class="medcaption" value="<%=storeIndentT.getQtyInDemand() %>"
				name="<%=RequestConstants.QTY_DEMAND_TEMP%>" tabindex="2"
				id="<%=demandVarTemp%>" /></td>
			<td width="10%"><input type="text" size="7" class="medcaption"
				value="<%=storeIndentT.getTotalCost() %>" readonly="readonly"
				name="<%=RequestConstants.COST_PRICE%>" MAXLENGTH="7" tabindex="1"
				id="<%=costTemp%>" onblur="fillCostForSOC(<%=inc%>);" /> <input
				type="hidden" size="7" class="medcaption"
				value="<%=storeIndentT.getTotalCost() %>"
				name="<%=RequestConstants.COST%>" MAXLENGTH="7" tabindex="1"
				id="<%=cost%>" /></td>
			<td width="13%"><input type="text"
				value="<%=storeIndentT.getRemarks()%>" readonly="readonly"
				name="<%=RequestConstants.REMARKS_TEMP%>" id="<%=remarksTemp %>"
				class="medcaption" onchange="fillRemarksForIssueCiv('<%=inc %>')" />
			<input type="hidden" value="<%=storeIndentT.getRemarks()%>"
				name="<%=RequestConstants.REMARKS%>" value="emptyString"
				class="medcaption" id="<%=remarks %>" /></td>
		</tr>
		<% inc++;}}%>
		<script>
	    	 document.indentForDisposal.noOfRows.value=<%=inc-((pageNo-1)*8)-1%>
	    	 </script>

		<%if(inc<incTemp2){
			  for(;inc<incTemp2;inc++){
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
			<td width="5%"><input type="text" size="2" value="<%=temp+inc%>"
				class="smcaption" name="<%=RequestConstants.SR_NO%>"
				readonly="readonly" /></td>
			<td width="10%"><input type="text" class="medcaption"
				name="<%=RequestConstants.NEW_NIV %>" readonly="readonly"
				id="<%=codeItem%>" /></td>
			<td width="10%"><input type="text" class="medcaption"
				name="<%=RequestConstants.ITEM_CODE %>" readonly="readonly"
				id="<%=oldNiv%>" /> <input type="hidden" value="0"
				name="<%=RequestConstants.ITEM_ID%>" id="<%=idItem%>" /> <input
				type="hidden" value="0"
				name="<%=RequestConstants.DEPARTMENT_ID_TEMP%>"
				id="<%=departmentId%>" /></td>
			<td width="10%"><input type="text" value="" tabindex="1"
				id="<%=nameItem%>" readonly="readonly" class="bigcaption"
				onblur="if(fillSrNo('<%=inc %>')){checkForIndentToDepot(this.value, '<%=nameItem%>','<%=inc %>');}"
				name="<%=nameItem%>" />
			<div id="ac2update"
				style="display: none; border: 1px solid black; padding-right: 450px; background-color: white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=nameItem%>','ac2update','nonExp?method=getItemListForIndentToDepot',{parameters:'requiredField=<%=nameItem%>&indentId='+document.getElementById('indentId').value });
			</script></td>
			<td width="10%"><input type="text" value="" class="smcaption"
				readonly="readonly" name="<%=RequestConstants.AV%>" id="<%=idAu%>" /></td>
			<td width="10%"><input type="text" value="" id="<%=section%>"
				class="smcaption" readonly="readonly" /></td>
			<td width="10%"><input type="text" class="medcaption"
				id="<%=qtyInHandTemp%>" value="" size="8" MAXLENGTH="7" /> <input
				type="hidden" value="0" class="medcaption"
				name="<%=RequestConstants.QTY_IN_HAND%>" id="<%=qtyInHand%>" /></td>

			<td width="10%"><input type="text" MAXLENGTH="7" value=""
				readonly="readonly" class="medcaption" tabindex=1
				name="<%=RequestConstants.QTY_IN_MMF_TEMP%>" id="<%=mmfVarTemp%>"
				onblur="fillValuesForMmf(<%=inc%>);" /> <input type="hidden"
				value="0" class="medcaption" name="<%=RequestConstants.QTY_IN_MMF%>"
				tabindex="2" id="<%=mmfVar%>" /></td>
			<td width="10%"><input type="text" MAXLENGTH="7"
				class="medcaption" value="" readonly="readonly"
				name="<%=RequestConstants.QTY_DEMAND%>" tabindex="1"
				id="<%=demandVar%>" onblur="fillValuesForDemand(<%=inc%>);" /> <input
				type="hidden" class="medcaption" value="0"
				name="<%=RequestConstants.QTY_DEMAND_TEMP%>" tabindex="2"
				id="<%=demandVarTemp%>" /></td>

			<td width="10%"><input type="text" size="7" class="medcaption"
				value="" readonly="readonly" name="<%=RequestConstants.COST_PRICE%>"
				MAXLENGTH="7" tabindex="1" id="<%=costTemp%>"
				onblur="fillCostForSOC(<%=inc%>);" /> <input type="hidden" size="7"
				class="medcaption" value="0" name="<%=RequestConstants.COST%>"
				MAXLENGTH="7" tabindex="1" id="<%=cost%>" /></td>
			<td width="13%"><input type="text"
				name="<%=RequestConstants.REMARKS_TEMP%>" readonly="readonly id="
				<%=remarksTemp %>" class="medcaption"
				onchange="fillRemarksForIssueCiv('<%=inc %>')" /> <input
				type="hidden" name="<%=RequestConstants.REMARKS%>"
				value="emptyString" class="medcaption" id="<%=remarks %>" /></td>
		</tr>

		<% }}%>

	</tbody>
</table>
</div>

<label class="bodytextB">Changed By:</label>
<div class="changebydt"><%=userName%></div>

<label class="bodytextB">Changed Date:</label>
<div class="changebydt"><%=date%></div>

<label class="bodytextB">Changed Time:</label>
<div class="changebydt"><%=time%></div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</form>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script> <input type="hidden" name="rows" id="rr" value="1" /></div>
</form>

</div>
