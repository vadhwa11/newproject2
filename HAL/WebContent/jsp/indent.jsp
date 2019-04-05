<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * indent.jsp  
 * Purpose of the JSP -  This is for Indenting to DGAFMS
 * Tables  store_indent_m,store_indent_t
 * @author  Vivek
 * Create Date: 7th Jan,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>

<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreIndentT"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%--HMS Related--%>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>

<%--For PopUp--%>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<%--For Ajax--%>
<script type="text/javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
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
	    for(i=1;i<=8;i++){
	    if(pvms !="")
	    if(document.getElementById('codeItem'+i).value==pvms){
	    if(document.getElementById('codeItem'+inc).value!=pvms){
	    	alert("Item already selected...!")
	    	document.getElementById('nameItem'+inc).value=""
	    	
	    	return false;
	    	}
	    }}
	    
		ajaxFunctionForAutoComplete('indentGrid','stores?method=fillItemsCommon&pvmsNo=' +  pvms , inc);
}
 
	
	function test(){
		if(document.getElementById('mmfForTheYear').value ==0){
			alert("Please Select MMF Year..!");
			return false;
		}else{
			return true;
		}
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
function testForYearDuplication(){
	if(document.getElementById('thisYear').value=="y"){
		alert("Already records added for this year.Gor for Search...!")
		return false;
	}else{
		return true;
	}
	if(document.getElementById('nextYear').value=rowVal){
	alert("Already records added for next year.Gor for Search...!")
	return false;
	}else{
		return true;
	}


}
 </script>

<%Box box = HMSUtil.getBox(request);
	System.out.println("Indent");
	Map<String,Object> map = new HashMap<String,Object>();
	String includedJsp = null;
	String previousPage="no";
	int nrs=0;
	String indentOption="";
	int pageNo=1;
	int indentId=0;
	int noOfRecordsAlreadyStored=0;
	int noOfRecordsAlreadyStoredNextYear=0;
	int mmfForTheYear=0;
		List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();
		List<MasStoreSection> sectionList= new ArrayList<MasStoreSection>();
		String maxIndentNo="";
		String date="";
		String time="";
		String userName = "";
		String thisYearValue ="";
		String nextYearValue ="";
		try{
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");

	}
	
	if(map.get("indentId")!=null){
		indentId=Integer.parseInt(""+map.get("indentId"));
	}
	if(map.get("thisYearValue")!=null){
		thisYearValue=(""+map.get("thisYearValue"));
	}
	if(map.get("nextYearValue")!=null){
		nextYearValue=(""+map.get("nextYearValue"));
	}
	if(map.get("mmfForTheYear")!=null){
		mmfForTheYear=Integer.parseInt(""+map.get("mmfForTheYear"));
		
	}
	if(map.get("noOfRecordsAlreadyStored")!=null){
		noOfRecordsAlreadyStored=Integer.parseInt(""+map.get("noOfRecordsAlreadyStored"));
	}
	if(map.get("noOfRecordsAlreadyStoredNextYear")!=null){
		noOfRecordsAlreadyStoredNextYear=Integer.parseInt(""+map.get("noOfRecordsAlreadyStoredNextYear"));
		
	}
	
	//System.out.print("noOfRecordsAlreadyStoredNextYear  "+noOfRecordsAlreadyStoredNextYear);
	if(map.get("indentOption")!=null){
		indentOption=(""+map.get("indentOption"));
	}
	if(map.get("previousPage")!=null){
		previousPage=(""+map.get("previousPage"));
	}
	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt(""+map.get("pageNo"));
	}
	
	if(map.get("maxIndentNo")!=null){
		maxIndentNo=(""+map.get("maxIndentNo"));
	}
	System.out.println("Max indent number in jsp indent.jsp---"+maxIndentNo);
	try{
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("searchIndentList") != null){
		searchIndentList = (List)map.get("searchIndentList");
		
	}
	}catch(Exception e){
		e.printStackTrace();
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 date = (String)utilMap.get("currentDate");	 
	 time = (String)utilMap.get("currentTime");
	 
		}catch(Exception e){
			e.printStackTrace();
		}
		
	String messageTOBeVisibleToTheUser ="";
	
	if(map.get("messageTOBeVisibleToTheUser")!=null){
		messageTOBeVisibleToTheUser=(""+map.get("messageTOBeVisibleToTheUser"));
	}
	String messageType ="";
	if(map.get("messageType")!=null){
		messageType=(""+map.get("messageType"));
	}

%>
<br />
<h2 align="left" class="style1">Final MMF For Projection To DGAFMS</h2>
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
					value="Print" onClick=""></td>
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
		</select> <input type="button" class="smbutton" value="Go!"
			onClick="submitForm('indent','stores?method=modifyIndent');" /></td>
	</tr>

</table>
</form>
</div>
</div>
</div>
<%-- End of Search Panel--%></form>

<form name="indentGrid" method="post">
<%if(!messageTOBeVisibleToTheUser.equals(""))
	{
	if(messageType.equals("success")){
	%>
<div style="width: 100%; padding-top: 4px; padding-bottom: 4px;">
<div class="mesg" style="width: 100%; font-weight: bold; height: 23px;">
<%=messageTOBeVisibleToTheUser %></div>
</div>

<%}%> <%if(messageType.equals("failure")){%>

<div id="errorMsg"
	style="width: 100%; padding-top: 4px; padding-bottom: 4px;">
<div
	style="margin-right: 0px; /*changed from 3px */ text-align: center; font-weight: bold; height: 23px; background-color: #FFE8E8; float: left; width: 100%; color: red; border: 1px solid red;">
<%=messageTOBeVisibleToTheUser %></div>
</div>
<%}}%> <br />
<div id="contentHolder">
<div class="division"></div>
<div class="blockTitle">Indent Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
</div>
			<div style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid;  
					width: 100%; height: 45px; background-color: #f4f9fe; padding-top: 10px; padding-bottom: 5px;	">
	  			<input type="hidden" name="<%=RequestConstants.INDENT_NO %>" value="<%=maxIndentNo%>" />
	  	   		<label class="bodytextB"><font id="error"></font>MMF for year :</label>
		  		
		  		<select name="<%=RequestConstants.MMF_FOR_THE_YEAR %>" validate="MMF Year Should be Select,num,Yes" id="mmfForTheYear" onchange="submitForm('indent','stores?method=checkYearExists&mmfForTheYear='+this.value)" tabindex="1">
		  		<!-- <select name="<%=RequestConstants.MMF_FOR_THE_YEAR %>" validate="MMF Year Should be Select,num,Yes" id="mmfForTheYear" onchange="submitForm('indent','stores?method=checkYearExists&mmfForTheYear='+this.value)" tabindex="1"> -->
<option value="0">Select</option>
<option value="<%=date.substring(6) %>"
	<%=HMSUtil.isSelected(date.substring(6).toString(),box.get("mmfForTheYear")) %>><%=date.substring(6) %></option>
<% int nextDate=Integer.parseInt(date.substring(6))+1; 
				System.out.println("nextDate   "+nextDate);
				%>
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
	value="DGAFMS" class="textbox_size20" MAXLENGTH="30" /> <input
	type="hidden" name="pageNo" id="pageNo" value="<%=pageNo%>" /> <input
	type="button" value="Import Dept.MMF" class="button"
	onclick="if(test()){submitForm('indentGrid','stores?method=importMMFIndent');}" />
<input type="button" value="Lock" class="button"
	onclick="if(test()){submitForm('indentGrid','stores?method=lockMMFIndent');}" />


<br />
</div>

<br />


<div style="float: left; padding-left: 15px;"><input type="button"
	class="button" value="Next"
	onclick="if(testForYearDuplication()&&checkForNext()&&isYearSelected()&&checkSave()){submitForm('indentGrid','stores?method=addNextOrSubmitIndent&buttonName=next');}"
	align="right" /> <input type="button" name="sss" align="right"
	class="button" value="Submit"
	onclick="if(testForYearDuplication()&&checkForSubmit()&&isYearSelected()&&checkSave()){submitForm('indentGrid','stores?method=addNextOrSubmitIndent&buttonName=submit');}" />
</div>


<div style="float: left; padding-left: 15px; padding-bottom: 10px;">
<label class="bodytextB">Page No:</label>
<div class="changebydt" style="width: 65px;"><%=pageNo%></div>
</div>

<input type="hidden" size="2" value="0"
	name="<%=RequestConstants.NO_OF_ROWS%>"
	id="<%=RequestConstants.NO_OF_ROWS%>" />
<input type="hidden" name="<%=RequestConstants.INDENT_ID %>"
	value="<%=indentId%>" id="indentId" />
<input type="hidden" value="<%=thisYearValue%>" id="thisYear" />
<input type="hidden" value="<%=nextYearValue%>" id="nextYear" />
<br />

<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid; BORDER-LEFT: #9A9A9A 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Item Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>
<br />

<table width="100%" colspan="7" id="indentDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0"
	style="border: 1px solid #7E7E7E;">
	<thead>
		<tr>

			<td width="5%"><label valign="left" class="gridsmlabel">SR
			No</label></td>
			<td width="15%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="17%"><label valign="left" class="smalllabel">Nomenclature</label>
			</td>
			<td width="3%"><label valign="left" class="gridsmlabel">A/U</label>
			</td>
			<td width="60%"><label valign="left" class="smalllabel">Qty
			in MMF</label></td>


		</tr>

	</thead>
	<tbody>
		<td width="5%">
		<%
    	int detailCounter=8; 
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
     	 for(int inc=1;inc<=detailCounter;inc++){
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
			<td width="15%"><input type="text" class="medcaption"
				name="<%=RequestConstants.ITEM_CODE %>" readonly="readonly"
				id="<%=codeItem%>" /> <input type="hidden" size="2" value="0"
				class="smcaption" name="<%=RequestConstants.ITEM_ID%>"
				id="<%=idItem%>" /></td>
			<td width="17%"><input type="text" value="" tabindex="1"
				id="<%=nameItem%>" class="bigcaption"
				onblur="if(fillSrNo('<%=inc %>')){checkForMMFIndent(this.value, '<%=nameItem%>','<%=inc %>');}"
				name="<%=nameItem%>" />
			<div id="ac2update" style="display: none;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=nameItem%>','ac2update','stores?method=getItemListForMMFIndent',{parameters:'requiredField=<%=nameItem%>&mmfForTheYear='+document.getElementById('mmfForTheYear').value });
			</script></td>

			<td width="3%"><input name="<%=RequestConstants.AV%>"
				type="text" class="smcaption" id="<%=idAu%>" value="" size="5"
				readonly="readonly" /></td>
			<td width="60%"><input type="text" value="" tabindex="1"
				validate="Qty in MMF,floatWithoutSpaces,no" class="medcaption"
				MAXLENGTH="7" name="<%=RequestConstants.QTY_IN_MMF_TEMP%>"
				id="<%=mmfVarTemp%>" onchange="fillValuesForMMF(<%=inc%>);" /> <input
				type="hidden" value="0" name="<%=RequestConstants.QTY_IN_MMF%>"
				id="<%=mmfVar%>" /> <input type="hidden"
				name="<%=RequestConstants.SECTION_ID%>" id="<%=idSection%>" /> <input
				type="hidden" name="<%=RequestConstants.STOCK_IN%>"
				id="<%=stockInVar %>" /></td>
		</tr>
		<% }   %>
		
	</tbody>

</table>
</div>
<br />
<label class="bodytextB">Changed By:</label>
<div class="changebydt"><%=userName%></div>

<label class="bodytextB">Changed Date:</label>
<div class="changebydt"><%=date%></div>

<label class="bodytextB">Changed Time:</label>
<div class="changebydt"><%=time%></div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</form>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script>
<input type="hidden" name="rows" id="rr" value="1" />

</form>

</div>
