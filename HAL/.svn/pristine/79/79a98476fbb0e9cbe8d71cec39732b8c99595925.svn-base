<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * modifyIndent.jsp  
 * Purpose of the JSP -  This is for modify Indent.
 * @author  Mansi
 * @author  Deepali
 * Create Date: 21st Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.8
--%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="java.util.List"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>

<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreIndentT"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="java.util.HashSet"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript" src="/hms/jsp/js/hms.js"></script>

<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>

<%System.out.println("Modify");
Box box = HMSUtil.getBox(request);
	Map map = new HashMap();
	String includedJsp = null;
	String previousPage="no";
	int pageNo=1;
	int indentId=0;
		List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();
		List<MasStoreSection> sectionList= new ArrayList<MasStoreSection>();
		List<StoreIndentM> previousStoreIndentMList=new ArrayList<StoreIndentM>();
		List<StoreIndentT> gridIndentTList=new ArrayList<StoreIndentT>();
		List<StoreIndentM> gridIndentMList= new ArrayList<StoreIndentM>();
		String maxIndentNo="";
		String noDetailRecords="no";
		String date="";
		String time="";
		String userName = "";
		try{
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	if(map.get("indentId")!=null){
		indentId=Integer.parseInt(""+map.get("indentId"));
	}
	if(map.get("noDetailRecords")!=null){
		noDetailRecords=(""+map.get("noDetailRecords"));
	}
	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt(""+map.get("pageNo"));
		
	}
	if(map.get("maxIndentNo")!=null)
		maxIndentNo=(""+map.get("maxIndentNo"));
	
	
	
	if(map.get("gridIndentTList")!=null){
		gridIndentTList=(List) map.get("gridIndentTList");
		
	}
	if(map.get("gridIndentMList")!=null)
		gridIndentMList=(List) map.get("gridIndentMList");
	
	if(map.get("searchIndentList")!=null)
	searchIndentList = (List) map.get("searchIndentList");

	
	
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	int mmfForTheYear =0;
	if(map.get("mmfForTheYear") != null){
		mmfForTheYear = Integer.parseInt(""+map.get("mmfForTheYear")) ;
		
	}
	if(box.get("mmfForTheYear") != null){
		box.put("mmfForTheYear",mmfForTheYear) ;
		
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 date = (String)utilMap.get("currentDate");	 
	 time = (String)utilMap.get("currentTime");
	 }catch(Exception e){
		 e.printStackTrace();
	 }
%>


<script language="javascript">
	function checkForMMFIndent(val,a,inc)
{
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
	    
		ajaxFunctionForAutoCompleteIssueToDispensary('indentGrid','stores?method=fillItemsCommon&pvmsNo=' +  pvms , inc);
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


function openPopupWindow(inc)
{
		var year = document.getElementById('mmfForTheYear').value;
		var pvmsno = document.getElementById('codeItem'+inc).value;
		var nomenclature = document.getElementById('nameItem'+inc).value;
		var mmfQty = document.getElementById('mmfVarTemp'+inc).value;
		var url="/hms/hms/stores?method=showMMFDepartmentWiseSplitup&year=" + year + "&pvmsno=" + pvmsno + "&nomenclature=" + nomenclature + "&mmfQty="+mmfQty;
		newwindow=window.open(url,'name','top=50, left=50, height=600,width=850,status=1');
}

</script>

<br />
<h2 align="left" class="style1">Final MMF For Projection To
DGAFMS-Modify</h2>

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
					type="button" name="print" type="submit" class="toolbutton"
					value="Print"
					onClick="submitForm('indent','stores?method=printMmfIndent&indentId='+<%=indentId %>);"></td>
				<td width="39%"><IMG SRC="/hms/jsp/images/closeButton.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<%-- Start of Search Panel--%>
<div align="center">
<div style="padding: 0px 25px 0px 25px"><!-- thread search menu -->
<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">
<form name="searchPanel" method="post">
<table width="330" border="0" cellpadding="2" cellspacing="1"
	style="border: 1px solid #245E83;">
	<tr>
		<td width="324" class="thead">Search Panel<a
			name="goto_threadsearch"></a></td>
	</tr>
	<tr>
		<td class="vbmenu_option" title="nohilite"><label
			class="bodytextB">MMF Year:</label> <select
			name="<%= RequestConstants.INDENT_IF_YEAR_EXISTS%>"
			validate="MMF Year,num,Yes" id="mmfYear">
			<option value="0">Select</option>
			<%
					for (StoreIndentM storeIndentM :searchIndentList ) {
				%>

			<option value=<%=storeIndentM.getId()%>><%=storeIndentM.getIndentNo()%></option>

			<%
					}
				%>
		</select> <input type="button" class="morebutton" value=""
			onClick="submitForm('indent','stores?method=modifyIndent');" /></td>
	</tr>

</table>
</form>
</div>
</div>
</div>
<%-- End of Search Panel--%> <br />

</form>

<form name="indentGrid" method="post">
<div id="testDiv" size="height:500px;">

<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Indent Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 45px; background-color: #f4f9fe; padding-top: 10px; padding-bottom: 5px;">



<input name="<%=NO_DETAIL_RECORDS %>" type="hidden"
	value="<%=noDetailRecords %>" /> <label class="bodytextB"><font
	id="error"></font>MMF for year :</label> <select
	name="<%=RequestConstants.MMF_FOR_THE_YEAR %>"
	validate="MMF Year Should be Select,num,Yes" id="mmfForTheYear"
	tabindex="1">

	<option value="0">Select</option>
	<option value="<%=date.substring(6) %>"
		<%=HMSUtil.isSelected(date.substring(6).toString(),box.get("mmfForTheYear")) %>><%=date.substring(6) %></option>
	<% int nextDate=Integer.parseInt(date.substring(6))+1; %>
	<option value="<%=Integer.parseInt(date.substring(6))+1 %>"
		<%=HMSUtil.isSelected(nextDate+"",box.get("mmfForTheYear")) %>><%=Integer.parseInt(date.substring(6))+1 %></option>

</select> <label class="bodytextB"><font id="error"></font>Indentor:</label> <input
	type="text" readonly="readonly"
	name="<%=RequestConstants.INDENT_FROM %>" value="CHAF,Bangalore"
	class="textbox_size20" MAXLENGTH="20" /> <input type="hidden"
	name="<%=RequestConstants.INDENT_DATE%>" readonly="readonly"
	value="<%=date %>" class="textbox_size20" MAXLENGTH="30" /> <label
	class="bodytextB"><font id="error"></font>Projection To:</label> <input
	type="text" readonly="readonly" name="<%=RequestConstants.INDENT_TO %>"
	value="DGAFMS" class="textbox_size20" MAXLENGTH="30" /></div>
<br />

<div style="float: left; padding-left: 15px;"><input type="button"
	class="button" value="Next"
	onclick="if(checkForNext()&checkSave()){submitForm('indentGrid','stores?method=updateNextOrSubmitIndent&buttonName=next');}"
	align="right" /> <input type="button" name="sss" align="right"
	class="button" value="Submit"
	onclick="if(checkForSubmit()&checkSave()){submitForm('indentGrid','stores?method=updateNextOrSubmitIndent&buttonName=submit');}" />
<input type="button" name="view" align="right" class="button"
	value="View" onclick="openPopupWindow();" /></div>


<div style="float: left; padding-left: 15px; padding-bottom: 10px;">
<label class="bodytextB">Page No:</label>
<div class="changebydt" style="width: 65px;"><%=pageNo%></div>
</div>

<input type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo" /> <input
	type="hidden" size="2" value="10" name="noOfRows" id="noOfRows" /> <input
	type="hidden" name="<%=RequestConstants.INDENT_ID %>"
	value="<%=indentId%>" id="hdb" /> <br />
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid; BORDER-LEFT: #9A9A9A 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Item Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>
<br />
<table width="70%" colspan="7" id="indentDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<td width="3%"><label valign="left" class="smalllabel">SR
			No</label></td>
			<td width="7%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="25%"><label valign="left" class="smalllabel">Nomenclature</label>
			</td>
			<td width="3%"><label valign="left" class="smalllabel">A/U</label>
			</td>
			<td width="10%"><label valign="left" class="smalllabel">Qty
			in MMF</label></td>
			<td width="10%"><label valign="left" class="smalllabel">MMF
			Dept.</label></td>

		</tr>
	</thead>
	<tbody>


		<%
		int detailCounter = 8; 
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
			int inc=1;
			if(pageNo!=1){
		    	inc=((pageNo-1)*8)+1;
		    	}
		 	   
		 	   int incTemp2=inc+8;
	    	   for(StoreIndentT storeIndentT:gridIndentTList){
	    		 
	    		  if(inc<=incTemp2){
		%>

		<%
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
			<td width="3%"><input type="text" size="2"
				value="<%=storeIndentT.getSerialNo()%>" class="smcaption"
				name="<%=RequestConstants.SR_NO%>" readonly="readonly" /></td>
			<input type="hidden" name="<%= RequestConstants.DETAIL_ID%>"
				value="<%=storeIndentT.getId()%>" />
			<td width="7%"><input type="text" size="2"
				value="<%=storeIndentT.getItem().getPvmsNo() %>" class="medcaption"
				readonly="readonly" name="<%=RequestConstants.ITEM_CODE%>"
				id="<%=codeItem%>" /> <input type="hidden" size="2"
				value="<%=storeIndentT.getItem().getId() %>" class="smcaption"
				name="<%=RequestConstants.ITEM_ID%>" id="<%=idItem%>" /></td>

			<td width="15%"><input type="text"
				value="<%=storeIndentT.getItem().getNomenclature() %>" tabindex="1"
				id="<%=nameItem%>" class="bigcaption"
				onblur="if(fillSrNo('<%=inc %>')){checkForMMFIndent(this.value, '<%=nameItem%>','<%=inc %>');}"
				name="<%=nameItem%>" />
			<div id="ac2update"
				style="display: none; border: 1px solid black; padding-right: 450px; background-color: white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=nameItem%>','ac2update','stores?method=getItemListForMMFIndentModify',{parameters:'requiredField=<%=nameItem%>&mmfForTheYear='+document.getElementById('mmfForTheYear').value });
			</script></td>

			<td width="3%">
			<%try{ %> <input type="text"
				value="<%=storeIndentT.getItem().getItemConversion().getItemUnitName() %>"
				class="smcaption" validate="A/U,String,no" readonly="readonly"
				name="<%=RequestConstants.AV%>" id="<%=idAu%>" /> <%}catch(Exception ex){ %>
			<input type="text" value="" class="smcaption"
				validate="A/U,String,no" readonly="readonly"
				name="<%=RequestConstants.AV%>" id="<%=idAu%>" /> <%} %>
			</td>

			<td width="10%"><input type="text"
				value="<%=storeIndentT.getQtyInMmf()%>" tabindex="1"
				validate="Qty in MMF,floatWithoutSpaces,no" class="medcaption"
				name="<%=RequestConstants.QTY_IN_MMF_TEMP%>" id="<%=mmfVarTemp%>"
				MAXLENGTH="7" onchange="fillValuesForMMF(<%=inc%>);" /> <input
				type="hidden" value="<%=storeIndentT.getQtyInMmf()%>"
				name="<%=RequestConstants.QTY_IN_MMF%>" id="<%=mmfVar%>" /></td>

			<td width="3%"><input type="button"
				onclick="openPopupWindow(<%=temp+inc%>)" name="Submit2" value=""
				class="morebutton" /></td>


		</tr>
		<% inc++;
     	 }
     	 }
	    	 %>
		<script>
	    	 document.indentGrid.noOfRows.value=<%=inc-((pageNo-1)*8)-1%>
	    	 </script>
		<%  
	    	 if(inc<incTemp2){
   			  for(;inc<incTemp2;inc++){
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
			<td width="3%"><input type="text" size="2"
				value="<%=temp+inc %>" class="smcaption"
				name="<%=RequestConstants.SR_NO%>" readonly="readonly" /></td>
			<td width="7%"><input name="<%=RequestConstants.ITEM_CODE %>"
				type="text" class="medcaption" id="<%=codeItem%>" size="5"
				readonly="readonly" /> <input type="hidden" size="2" value="0"
				class="smcaption" name="<%=RequestConstants.ITEM_ID%>"
				id="<%=idItem%>" /></td>
			<td width="15%"><input type="text" value="" id="<%=nameItem%>"
				class="bigcaption"
				onblur="if(fillSrNo('<%=inc %>')){checkForMMFIndent(this.value, '<%=nameItem%>','<%=inc %>');}"
				tabindex="1" name="<%=nameItem%>" />
			<div id="ac2update"
				style="display: none; border: 1px solid black; padding-right: 450px; background-color: white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=nameItem%>','ac2update','stores?method=getItemListForMMFIndentModify',{parameters:'requiredField=<%=nameItem%>&mmfForTheYear='+document.getElementById('mmfForTheYear').value });
			</script></td>

			<td width="3%"><input name="<%=RequestConstants.AV%>"
				type="text" class="smcaption" id="<%=idAu%>" value=""
				readonly="readonly" /></td>

			<td width="15%"><input type="text" value="" tabindex="1"
				validate="Qty in MMF,floatWithoutSpaces,no" class="medcaption"
				name="<%=RequestConstants.QTY_IN_MMF_TEMP%>" MAXLENGTH="7"
				id="<%=mmfVarTemp%>" onchange="fillValuesForMMF(<%=inc%>);" /> <input
				type="hidden" value="0" name="<%=RequestConstants.QTY_IN_MMF%>"
				id="<%=mmfVar%>" /></td>

			<td width="3%"></td>

		</tr>
		<% }}%>
	</tbody>

</table>


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
