<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * indentOAFU.jsp  
 * Purpose of the JSP -  This is for Indent OAFU.
 * @author  Mansi
 * @author  Deepali
 * Create Date: 05th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.2
--%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.PoDetail"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.PoHeader"%>
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
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />

<link rel="stylesheet" href="/hms/jsp/css/acnik.css" type="text/css" />
<script type="text/javascript" src="/hms/jsp/js/acnik.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>

<%
	StringBuffer orderDateOnly = new StringBuffer();
	GregorianCalendar gregorianCalendar1 = new GregorianCalendar();

	int dateOfMonth = gregorianCalendar1.get(Calendar.DAY_OF_MONTH);
	if (dateOfMonth < 10) {
		orderDateOnly.append("0");
		orderDateOnly.append(dateOfMonth);
	} else {
		orderDateOnly.append(dateOfMonth);
	}

	orderDateOnly.append("/");

	int month = gregorianCalendar1.get(Calendar.MONTH) + 1;
	if (month < 10) {
		orderDateOnly.append("0");
		orderDateOnly.append(month);
	} else {
		orderDateOnly.append(month);
	}

	orderDateOnly.append("/");
	int year = gregorianCalendar1.get(Calendar.YEAR);
	orderDateOnly.append(year);
	String currentDate = new String(orderDateOnly);
%>
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
<script type="text/javascript" language="javascript">
var itemsArray1=new Array();
 var numLinesAdded = 1;
  var tt;
  function fillItems(idVal,rowVal){
  		var idItem="idItem";
    	var codeItem="codeItem";
    	var nameItem="nameItem";
    	var idSection="idSection";
    	var nameSection="nameSection";
    	var idAu="idAu";
    	
    	idItem=idItem+rowVal;
    	
    	codeItem=codeItem+rowVal;
    	nameItem=nameItem+rowVal;
    	
    	idSection=idSection+rowVal;
    	nameSection=nameSection+rowVal;
    	idAu=idAu+rowVal;
    	document.getElementById('noOfRecords').value=rowVal
		for(i=0;i<itemsArray1.length;i++){
		if(itemsArray1[i][0]==idVal){
			
		document.getElementById(idItem).value=itemsArray1[i][0]
		document.getElementById(nameItem).value=itemsArray1[i][2]
		document.getElementById(idAu).value=itemsArray1[i][3]
		document.getElementById(nameSection).value=itemsArray1[i][4]
		document.getElementById(idSection).value=itemsArray1[i][5]
		}
		}
	
  }
  function fillValues(inc)
  {
  	 	var stockInVar="stockInVar";
    	var mmfVar="mmfVar";
    	var demandVar="demandVar";
    	var stockInVarTemp="stockInVarTemp";
    	var mmfVarTemp="mmfVarTemp";
    	var demandVarTemp="demandVarTemp";
    	document.getElementById(stockInVar+inc).value=document.getElementById(stockInVarTemp+inc).value
    	document.getElementById(mmfVar+inc).value=document.getElementById(mmfVarTemp+inc).value
    	document.getElementById(demandVar+inc).value=document.getElementById(demandVarTemp+inc).value
  }
  function checkForNext(){
  if(document.getElementById('noOfRecords').value<10)
  {
  	alert("All rows are not filled.To continue press Submit ")
  	return false;
  }else{
  return true;
  }
  }
  
  function checkForSubmit(){
  if(document.getElementById('noOfRecords').value==0)
  {alert("There must be one detail row");
  return false;
  }else{
  return true;
  }
  }
   function removeRow(obj)
 		
	{
	   
		if(document.getElementById("indentDetails").childNodes[1].childNodes.length>1)	
		{
			
			//tt = document.getElementById("indentDetails");
		   // tt = document.getElementById("indentDetails").childNodes[1].removeChild(obj.parentNode.parentNode);
			//tt.deleteRow(document.getElementById("indentDetails").childNodes[1])
			
			document.getElementById('indentDetails').deleteRow(2)
			
      		alert(" ifww")
      		
      		
		}
		else
		{
			
		 	alert("Bill should have atleast one row");
		}
		numLinesAdded--;
	}
 
	function generateRow() {
	
		var d=document.getElementById("indentDetails").getElementsByTagName("tr");
		lastTr = d[d.length-1]		
		clone = lastTr.cloneNode(true);
		clone.id = parseInt(lastTr.id);
		numLinesAdded++;
		
		 
        lastTr.parentNode.insertBefore(clone,lastTr.nextSibling)
        
        obj1 = document.getElementById('SRNo');          
     	obj1.value=numLinesAdded;
        
        
       
       
	}
	


	
function get_value()
{
 var url="/hms/jsp/window.jsp";
   popwindow(url);
 }  

var newwindow;
function popwindow(url)
{

 newwindow=window.open(url,'name',"height=500,width=600,status=1");
 if (window.focus) 
 {
 newwindow.focus()
 }
newwindow.createPopup();

}

	
</script>
<%
	Map map = new HashMap();
	String includedJsp = null;
	String previousPage="no";
	int nrs=0;
	String indentOption="";
	int pageNo=1;
	int indentId=0;
		List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();
		List<MasStoreSection> sectionList= new ArrayList<MasStoreSection>();
		List<MasStoreItem> itemList= new ArrayList<MasStoreItem>();
		List<StoreIndentM> previousStoreIndentMList=new ArrayList<StoreIndentM>();
		List<StoreIndentT> previousStoreIndentTList=new ArrayList<StoreIndentT>();
		int maxIndentNo=0;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	if(map.get("indentId")!=null){
		indentId=Integer.parseInt(""+map.get("indentId"));
		System.out.print("  indentId    "+indentId);
	}
	if(map.get("nrs")!=null){
		nrs=Integer.parseInt(""+map.get("nrs"));
		System.out.print("  nrs    "+nrs);
	}
	if(map.get("indentOption")!=null){
		indentOption=(""+map.get("indentOption"));
		System.out.print("  previousPage    "+previousPage);
	}
	if(map.get("previousPage")!=null){
		previousPage=(""+map.get("previousPage"));
		System.out.print("  previousPage    "+previousPage);
	}
	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt(""+map.get("pageNo"));
		System.out.println("pageNo  -----------------------                  "+pageNo);
	}

	if(map.get("maxIndentNo")!=null)
		maxIndentNo=Integer.parseInt(""+map.get("maxIndentNo"));
	
	if(map.get("sectionList")!=null)
	sectionList=(List) map.get("sectionList");
	
	if(map.get("previousStoreIndentMList")!=null)
		previousStoreIndentMList=(List) map.get("previousStoreIndentMList");
	
	if(map.get("previousStoreIndentTList")!=null)
		previousStoreIndentTList=(List) map.get("previousStoreIndentTList");
	
	
	if(map.get("searchIndentList")!=null)
	searchIndentList = (List) map.get("searchIndentList");
	if(map.get("itemList")!=null)
		itemList=(List) map.get("itemList");
%>

<% 
			int k=0;
  					if(itemList.size()>0)
  						
 						for (MasStoreItem masStoreItem:itemList){
 							System.out.print("-----------   ----------------          "+itemList.size());
 			%>
<script>
         		 
         		itemsArray1[<%=k%>]= new Array();
         		itemsArray1[<%=k%>][0] = "<%=masStoreItem.getId()%>";
				itemsArray1[<%=k%>][1] = "<%=masStoreItem.getPvmsNo()%>";
				itemsArray1[<%=k%>][2] = "<%=masStoreItem.getNomenclature()%>";
				itemsArray1[<%=k%>][3] = "<%=masStoreItem.getItemConversion().getItemUnitName()%>";
         		itemsArray1[<%=k%>][4] = "<%=masStoreItem.getSection().getSectionName()%>";
         		itemsArray1[<%=k%>][5] = "<%=masStoreItem.getSection().getId()%>";
         		</script>
<%
          k++;
 						} %>

<div id="contentspace">

<form name="indent" method="post"><br />

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
					type="button" name="print" type="submit" class="toolbutton"
					value=" " onClick=""></td>
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
<table cellpadding="4" cellspacing="1" border="0">
	<tr>
		<td class="thead">Search Panel<a name="goto_threadsearch"></a></td>
	</tr>
	<tr>
		<td class="vbmenu_option" title="nohilite"><input type="hidden"
			name="s" value="cccfbaab0a70ed43fad9de8e3733112d" /> <input
			type="hidden" name="do" value="process" /> <input type="hidden"
			name="searchthread" value="1" /> <input type="hidden"
			name="showposts" value="1" /> <input type="hidden"
			name="searchthreadid" value="85875" /> <label class="bodytextB_blue">From
		Date :</label> <input type="text" name="<%= RequestConstants.FROM_DATE %>"
			class="textbox_date" MAXLENGTH="30" / tabindex=1 /> <img
			id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
			border="0" validate="Pick a date" class="calender" tabindex="1"
			onClick="setdate('<%=currentDate%>',document.indent.<%= RequestConstants.FROM_DATE%>,event)" />


		<label class="bodytextB_blue">To Date :</label> <input type="text"
			name="<%= RequestConstants.TO_DATE %>" class="textbox_date"
			MAXLENGTH="30" / tabindex=1 /> <img id="calendar"
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date" class="calender" tabindex="1"
			onClick="setdate('<%=currentDate%>',document.indent.<%= RequestConstants.TO_DATE%>,event)" />
		<br />
		<label class="bodytextB_blue">Indent No:</label> <select
			name="<%= RequestConstants.INDENT_NO%>">
			<option value="0">Select</option>
			<%
					for (StoreIndentM storeIndentM :searchIndentList ) {
				%>

			<option value=<%=storeIndentM.getIndentNo()%>><%=storeIndentM.getIndentNo()%></option>

			<%
					}
				%>
		</select> <input type="button" class="smbutton" value="Go!"
			onClick="submitForm('indent','stores?method=searchIndent');" /></td>
	</tr>

</table>
</form>
</div>
</div>
</div>
<jsp:include page="searchResultPO.jsp" />

<div id="searcharea">

<div id="searchbar">
<div class="search">
<form name="searchIndent" method="post" action=""><input
	type="radio" name="<%= RequestConstants.RADIO_PVMS%>" checked="checked"
	value="1" onclick="submitForm('indent','stores?method=showIndentJsp');" />
<font class="bodytextB_blue">Indent to DGAFMS for PVMS Items(MMF
Entry):</font> <input type="radio" name="<%= RequestConstants.RADIO_PVMS%>"
	value="2"
	onchange="submitForm('indent','stores?method=showIndentJspAF');" /> <font
	class="bodytextB_blue">Indent to Other A.F. Units:</font> <input
	type="radio" name="<%= RequestConstants.RADIO_PVMS%>" value="3"
	onchange="submitForm('indent','stores?method=showIndentJspBD');" /> <font
	class="bodytextB_blue">Indent to Depot:</font> <input type="radio"
	name="<%= RequestConstants.RADIO_PVMS%>" value="4"
	onclick="submitForm('indent','stores?method=showIndentJspSOC');" /> <font
	class="bodytextB_blue">DGAFMS Indent (SOC):</font></form>
</div>
</div>

</div>


<br />








</form>

<form name="indentGrid" method="post">


<div id="testDiv" size="height:500px;">
<%if(previousPage.equals("no")){ %> <input type="hidden" name="pageNo"
	value="<%=pageNo%>" /> <label class="bodytextB_blue"><font
	id="error"></font> Indent No: </label> <input type="text"
	name="<%=RequestConstants.INDENT_NO %>" value="<%=maxIndentNo%>"
	readonly="readonly" class="textbox_size20" MAXLENGTH="8"/  > <label
	class="bodytextB_blue"><font id="error"></font>Indent From:</label> <input
	type="text" readonly="readonly"
	name="<%=RequestConstants.INDENT_FROM %>" value="Airforce,Bangalore"
	class="textbox_size20" MAXLENGTH="20" /> <label class="bodytextB_blue"><font
	id="error"></font>Indent Date:</label> <input type="text"
	name="<%=RequestConstants.INDENT_DATE%>" readonly="readonly"
	value="<%=currentDate %>" class="textbox_size20" MAXLENGTH="30" /> <br />
<label class="bodytextB_blue"><font id="error"></font>Indent To:</label>
<input type="text" readonly="readonly"
	name="<%=RequestConstants.INDENT_TO %>" value="DGFMSHQ"
	class="textbox_size20" MAXLENGTH="30" /> <label class="bodytextB_blue"><font
	id="error"></font>Type of Indent:</label> <select
	name="<%= RequestConstants.TYPE_OF_INDENT%>"
	validate="Type Of Indent,Strinf,yes">
	<option value="0">Select</option>
	<% if((indentOption).equals("Monthly")){ %>
	<option value="1" selected="selected">Monthly</option>
	<option value="2">Yearly</option>
	<%}else{ %>
	<option value="1">Monthly</option>
	<option value="2" selected="selected">Yearly</option>
	<%} %>
</select> <label class="bodytextB_blue"><font id="error"></font>NRS:</label> <input
	type="text" name="<%= RequestConstants.NRS %>" value="<%=nrs %>"
	class="textbox_size20" MAXLENGTH="30" validate="NRS,num,yes" /> <input
	type="hidden" name="<%=RequestConstants.NO_OF_ROWS%>" id="rr"
	value="22" /> <%}else{ 
					for(StoreIndentM storeIndentM:previousStoreIndentMList){
						System.out.print("123421111111111111111111111 ");

				%> <input type="hidden" name="pageNo" value="<%=pageNo%>" /> <label
	class="bodytextB_blue"><font id="error"></font> Indent No: </label> <input
	type="text" name="<%=RequestConstants.INDENT_NO %>"
	value="<%=storeIndentM.getIndentNo()%>" readonly="readonly"
	class="textbox_size20" MAXLENGTH="8"/  > <label
	class="bodytextB_blue"><font id="error"></font>Indent From:</label> <input
	type="text" readonly="readonly"
	name="<%=RequestConstants.INDENT_FROM %>" value="Airforce,Bangalore"
	class="textbox_size20" MAXLENGTH="20" /> <label class="bodytextB_blue"><font
	id="error"></font>Indent Date:</label> <input type="text"
	name="<%=RequestConstants.INDENT_DATE%>" readonly="readonly"
	value="<%=currentDate %>" class="textbox_size20" MAXLENGTH="30" /> <br />
<label class="bodytextB_blue"><font id="error"></font>Indent To:</label>
<select name="<%= RequestConstants.INDENT_TO%>"
	validate="Indent To,String,yes">
	<option value="0">Select</option>
	<%
				for (MasStoreSection storeSection :sectionList ) {
			%>

	<option value=<%=storeSection.getSectionName()%>><%=storeSection.getSectionName()%></option>

	<%
				}
			%>
</select> <label class="bodytextB_blue"><font id="error"></font>Type of
Indent:</label> <select name="<%= RequestConstants.TYPE_OF_INDENT%>"
	validate="Type Of Indent,Strinf,yes">
	<option value="0">Select</option>
	<option value="1">Monthly</option>
	<option value="2">Yearly</option>

</select> <label class="bodytextB_blue"><font id="error"></font>NRS:</label> <input
	type="text" name="<%= RequestConstants.NRS %>"
	value="<%=storeIndentM.getNrs()%>" class="textbox_size20"
	MAXLENGTH="30" validate="NRS,num,yes" /> <input type="hidden"
	name="<%=RequestConstants.NO_OF_ROWS%>" id="rr" value="22" /> <%}} %> <br />
<input type="hidden" class="button" value="Add Row"
	onclick="generateRow();" align="right" /> <input type="hidden"
	class="button" value="Remove Row" onclick="removeRow(this)"
	align="right" /> <input type="hidden" class="button" value="Previous"
	readonly="readonly"
	onclick="submitForm('indentGrid','stores?method=previousIndent');"
	align="right" /> <input type="button" class="button" value="Next"
	onclick="if(checkForNext()){submitForm('indentGrid','stores?method=nextIndent');}"
	align="right" /> <input type="button" name="sss" align="right"
	class="button" value="Submit"
	onclick="if(checkForSubmit()){submitForm('indentGrid','stores?method=submitIndent');}" />
Page No:<%=pageNo%> <input type="hidden" size="2" value="0"
	name="noOfRecords" id="noOfRecords" /> <input type="hidden"
	name="<%=RequestConstants.INDENT_ID %>" value="<%=indentId%>" id="hdb" />
<br />
<fieldset style="width: 99%; padding-left: 9px;"><legend>Indent
details</legend>


<div
	style="overflow: auto; width: 100%; height: 260px; padding-left: 9px;">
<table width="200px" colspan="7" id="indentDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<td width="5%"><label valign="left" class="smalllabel">SR
			No</label></td>
			<td width="13%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Nomenclature</label>
			</td>
			<td width="13%"><label valign="left" class="smalllabel">A/U</label>
			</td>
			<td width="13%"><label valign="left" class="smalllabel">Section</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Stock
			in</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Qty
			in MMF</label></td>
			<td width="6%"><label valign="left" class="smalllabel">Qty
			Demand</label></td>

		</tr>

	</thead>
	<tbody>


		<%if(previousPage.equals("no")){ %>
		<td width="10%">
		<%
    	int detailCounter=10; 
    	int temp=0;
    	String idItem="idItem";
    	String codeItem="codeItem";
    	String nameItem="nameItem";
    	String idSection="idSection";
    	String nameSection="nameSection";
    	String idAu="idAu";
    	
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
    	String idSection2="idSection";
    	String nameSection2="nameSection";
    	String idAu2="idAu";
    	
    	String stockInVar2="stockInVar";
    	String mmfVar2="mmfVar";
    	String demandVar2="demandVar";

    	String stockInVarTemp2="stockInVarTemp";
    	String mmfVarTemp2="mmfVarTemp";
    	String demandVarTemp2="demandVarTemp";
    	String incVar2="incVar2";
    	
    	if(pageNo!=1)
    	{
    		temp=detailCounter*(pageNo-1);
    	}
     	 for(int inc=1;inc<=10;inc++){
     		 System.out.println("1111111111111");
     		idItem=idItem2+(""+inc);
     		codeItem=codeItem2+(""+inc);
     		nameItem=nameItem2+(""+inc);
     		idSection=idSection2+(""+inc);
     		nameSection=nameSection2+(""+inc);
     		idAu=idAu2+(""+inc);
     		
     		stockInVar=stockInVar2+(""+inc);
     		mmfVar=mmfVar2+(""+inc);
     		demandVar=demandVar2+(""+inc);
     		

     		stockInVarTemp=stockInVarTemp2+(""+inc);
     		mmfVarTemp=mmfVarTemp2+(""+inc);
     		demandVarTemp=demandVarTemp2+(""+inc);
     		incVar=incVar2+(""+inc);
    	  %>
		<tr>
			<td width="5%"><input type="text" size="2" value="<%=temp+inc%>"
				class="smcaption" name="<%=RequestConstants.SR_NO%>"
				readonly="readonly" /></td>
			<td width="10%"><select name="<%= RequestConstants.ITEM_CODE%>"
				onchange="fillItems(this.value,this.id)" id="<%=inc%>">
				<option value="0">Select</option>
				<%
					for (MasStoreItem masStoreItem :itemList ) {
				%>

				<option value=<%=masStoreItem.getId()%>><%=masStoreItem.getPvmsNo()%></option>

				<%
					}
				%>

				<input type="hidden" size="2" value="0" class="smcaption"
					name="<%=RequestConstants.ITEM_ID%>" id="<%=idItem%>" /></td>
			<td width="10%"><input type="text" value="" id="<%=nameItem%>"
				class="bigcaption" readonly="readonly"
				name="<%=RequestConstants.NOMENCLATURE%>" /></td>
			<td width="10%"><input type="text" value="" class="smcaption"
				readonly="readonly" name="<%=RequestConstants.AV%>" id="<%=idAu%>" /></td>
			<td width="10%"><input type="text" value="" class="medcaption"
				readonly="readonly" name="<%=RequestConstants.SECTION%>"
				id="<%=nameSection%>" /> <input type="hidden" value="4"
				class="medcaption" readonly="readonly"
				name="<%=RequestConstants.SECTION_ID%>" id="<%=idSection%>" /></td>
			<td width="10%"><input type="text" value="" class="medcaption"
				name="<%=RequestConstants.STOCK_IN_TEMP%>" id="<%=stockInVarTemp %>"
				tabindex="2" /> <input type="hidden" value="0" class="medcaption"
				name="<%=RequestConstants.STOCKING%>" tabindex="2"
				id="<%=stockInVar%>" /></td>
			<td width="10%"><input type="text" value="" class="medcaption"
				name="<%=RequestConstants.QTY_IN_MMF_TEMP%>" tabindex="2"
				id="<%=mmfVarTemp%>" /> <input type="hidden" value="0"
				class="medcaption" name="<%=RequestConstants.QTY_IN_MMF%>"
				tabindex="2" id="<%=mmfVar%>" /></td>
			<td width="3%"><input type="text" class="medcaption" value=""
				name="<%=RequestConstants.QTY_DEMAND_TEMP%>" tabindex="2"
				id="<%=demandVarTemp%>" onblur="fillValues(<%=inc%>);" /> <input
				type="hidden" class="medcaption" value="0"
				name="<%=RequestConstants.QTY_DEMAND%>" tabindex="2"
				id="<%=demandVar%>" /></td>
		</tr>
		<% }   %> <%}//this is if(previousPage.equals("no")) end
       else{
    	   int inc=((pageNo-2)*10)+1;
    	   System.out.println("--------------inc -----------   "+inc);
    	   int incTemp=inc+10;
    	   for(StoreIndentT storeIndentT:previousStoreIndentTList){
    		  
    		   if(((storeIndentT.getIndent().getId())==indentId)&&((storeIndentT.getSerialNo()<=inc)&&(storeIndentT.getSerialNo()>=incTemp))&&(inc<=incTemp)){
    			   System.out.println("99999999999999999999999999999999999999999 ");
       %>

		<td width="10%">
		<%
    	int detailCounter=10; 
    	int temp=0;
    	String idItem="idItem";
    	String codeItem="codeItem";
    	String nameItem="nameItem";
    	String idSection="idSection";
    	String nameSection="nameSection";
    	String idAu="idAu";
    	
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
    	String idSection2="idSection";
    	String nameSection2="nameSection";
    	String idAu2="idAu";
    	
    	String stockInVar2="stockInVar";
    	String mmfVar2="mmfVar";
    	String demandVar2="demandVar";

    	String stockInVarTemp2="stockInVarTemp";
    	String mmfVarTemp2="mmfVarTemp";
    	String demandVarTemp2="demandVarTemp";
    	String incVar2="incVar2";
    	
    	if(pageNo!=1)
    	{
    		temp=detailCounter*(pageNo-1);
    	}
     	 {
     		 System.out.println("1111111111111");
     		idItem=idItem2+(""+inc);
     		codeItem=codeItem2+(""+inc);
     		nameItem=nameItem2+(""+inc);
     		idSection=idSection2+(""+inc);
     		nameSection=nameSection2+(""+inc);
     		idAu=idAu2+(""+inc);
     		
     		stockInVar=stockInVar2+(""+inc);
     		mmfVar=mmfVar2+(""+inc);
     		demandVar=demandVar2+(""+inc);
     		

     		stockInVarTemp=stockInVarTemp2+(""+inc);
     		mmfVarTemp=mmfVarTemp2+(""+inc);
     		demandVarTemp=demandVarTemp2+(""+inc);
     		incVar=incVar2+(""+inc);
    	  %>
		<tr>
			<td width="5%"><input type="text" size="2"
				value="<%=storeIndentT.getSerialNo()%>" class="smcaption"
				name="<%=RequestConstants.SR_NO%>" readonly="readonly" /></td>
			<td width="10%"><select name="<%= RequestConstants.ITEM_CODE%>"
				onchange="fillItems(this.value,this.id)" id="<%=inc%>">
				<option value="0">Select</option>
				<%
					for (MasStoreItem masStoreItem :itemList ) {
				%>

				<option value=<%=masStoreItem.getId()%>><%=masStoreItem.getPvmsNo()%></option>

				<%
					}
				%>

				<input type="hidden" size="2" value="0" class="smcaption"
					name="<%=RequestConstants.ITEM_ID%>" id="<%=idItem%>" /></td>
			<td width="10%"><input type="text"
				value="<%=storeIndentT.getItem().getNomenclature() %>"
				id="<%=nameItem%>" class="bigcaption" readonly="readonly"
				name="<%=RequestConstants.NOMENCLATURE%>" /></td>
			<td width="10%"><input type="text"
				value="<%=storeIndentT.getItem().getItemConversion().getItemUnitName() %>"
				class="smcaption" readonly="readonly"
				name="<%=RequestConstants.AV%>" id="<%=idAu%>" /></td>
			<td width="10%"><input type="text"
				value="<%=storeIndentT.getItem().getSection().getSectionName() %>"
				class="medcaption" readonly="readonly"
				name="<%=RequestConstants.SECTION%>" id="<%=nameSection%>" /> <input
				type="hidden" value="4" class="medcaption" readonly="readonly"
				name="<%=RequestConstants.SECTION_ID%>" id="<%=idSection%>" /></td>
			<td width="10%"><input type="text"
				value="<%=storeIndentT.getStockIn()%>" class="medcaption"
				name="<%=RequestConstants.STOCK_IN_TEMP%>" id="<%=stockInVarTemp %>"
				tabindex="2" /> <input type="hidden" value="0" class="medcaption"
				name="<%=RequestConstants.STOCKING%>" tabindex="2"
				id="<%=stockInVar%>" /></td>
			<td width="10%"><input type="text"
				value="<%=storeIndentT.getQtyInMmf() %>" class="medcaption"
				name="<%=RequestConstants.QTY_IN_MMF_TEMP%>" tabindex="2"
				id="<%=mmfVarTemp%>" /> <input type="hidden" value="0"
				class="medcaption" name="<%=RequestConstants.QTY_IN_MMF%>"
				tabindex="2" id="<%=mmfVar%>" /></td>
			<td width="3%"><input type="text" class="medcaption"
				value="<%=storeIndentT.getQtyInDemand()%>"
				name="<%=RequestConstants.QTY_DEMAND_TEMP%>" tabindex="2"
				id="<%=demandVarTemp%>" onblur="fillValues(<%=inc%>);" /> <input
				type="hidden" class="medcaption" value="0"
				name="<%=RequestConstants.QTY_DEMAND%>" tabindex="2"
				id="<%=demandVar%>" /></td>
		</tr>
		<% }   %> <%inc++;
       } }}%>
		
	</tbody>

</table>
</fieldset>


</div>



</form>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script> <input type="hidden" name="rows" id="rr" value="1" />

</form>

</div>
