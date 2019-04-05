<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * indent.jsp  
 * Purpose of the JSP -  This is for indent.
 * @author  Mansi
 * Create Date: 21th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.28
--%>

<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.StoreBalanceM"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreBalanceT"%>

<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<link rel="stylesheet" href="/hms/jsp/css/acnik.css" type="text/css" />



<script type="text/javascript" src="/hms/jsp/js/actb.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
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

	int monthSearch = gregorianCalendar1.get(Calendar.MONTH) + 1;
	if (monthSearch < 10) {
		orderDateOnly.append("0");
		orderDateOnly.append(monthSearch);
	} else {
		orderDateOnly.append(monthSearch);
	}

	orderDateOnly.append("/");
	int year1 = gregorianCalendar1.get(Calendar.YEAR);
	orderDateOnly.append(year1);
	String currentDate = new String(orderDateOnly);
%>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date1 = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	String previousPage="no";
	int pageNo=1;
	int balanceId=0;
		List<StoreBalanceM> searchStoreBalanceMList = new ArrayList<StoreBalanceM>();
		List<MasStoreBrand> brandList= new ArrayList<MasStoreBrand>();
		List<MasStoreItem> itemList= new ArrayList<MasStoreItem>();
		List<StoreBalanceM> previousStoreBalanceMList=new ArrayList<StoreBalanceM>();
		List<StoreBalanceT> previousStoreBalanceTList=new ArrayList<StoreBalanceT>();
		String max="";
			
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	
	if(map.get("max")!=null)
		max = (String) map.get("max");
		
	if(map.get("balanceId")!=null){
		balanceId=Integer.parseInt(""+map.get("balanceId"));
	}
	if(map.get("previousPage")!=null){
		previousPage=(""+map.get("previousPage"));
	}
	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt(""+map.get("pageNo"));
	}


	if(map.get("brandList")!=null)
	brandList=(List) map.get("brandList");
	
	if(map.get("previousStoreBalanceMList")!=null)
		previousStoreBalanceMList=(List) map.get("previousStoreBalanceMList");
	
	if(map.get("previousStoreBalanceTList")!=null)
		previousStoreBalanceTList=(List) map.get("previousStoreBalanceTList");
	
	
	if(map.get("searchStoreBalanceMList")!=null)
	searchStoreBalanceMList = (List) map.get("searchStoreBalanceMList");
		
	if(map.get("itemList")!=null)
		itemList=(List) map.get("itemList");
	
	
	if(map.get("brandList")!=null)
		brandList=(List) map.get("brandList");
	
	
	List<MasEmployee> approvedByEmployeeList = new ArrayList<MasEmployee>();
	if(map.get("approvedByEmployeeList") != null){
		approvedByEmployeeList = (ArrayList) map.get("approvedByEmployeeList");
		session.setAttribute("approvedByEmployeeList",approvedByEmployeeList);
	}else if(session.getAttribute("approvedByEmployeeList") != null){
		approvedByEmployeeList = (ArrayList)session.getAttribute("approvedByEmployeeList");
		
	}
	
	
	
	
	
%>
<script type="text/javascript">
 var itemsArray2=new Array();
  function fillBalance(idVal,rowVal){
  		var idBrand="idBrand";
    	var nameManufacturer="nameManufacturer";
    	
    	
    	idBrand=idBrand+rowVal;
    	nameManufacturer=nameManufacturer+rowVal;
    	
    	document.getElementById('noOfRows').value=rowVal
		for(i=0;i<itemsArray2.length;i++){
		if(itemsArray2[i][0]==idVal){
			
		document.getElementById(idBrand).value=itemsArray2[i][0]
		document.getElementById(nameManufacturer).value=itemsArray2[i][2]
		}
		}
	
  }
  function fillValuesBalance(inc)
  {
    	
    	var batchNoVar="batchNoVar";
    	var batchNoVarTemp="batchNoVarTemp";
    	
    	
    	var qtyVar="qtyVar";
    	var qtyVarTemp="qtyVarTemp";
    	
    	var unitRateVar="unitRateVar";
    	var unitRateVarTemp="unitRateVarTemp";
    	
    	   	
    if(document.getElementById(batchNoVarTemp+inc).value!=""){
      		document.getElementById(batchNoVar+inc).value=document.getElementById(batchNoVarTemp+inc).value
     }
     else
      		document.getElementById(batchNoVar+inc).value="emptyString";
     
      
             

    document.getElementById(qtyVar+inc).value=document.getElementById(qtyVarTemp+inc).value
    document.getElementById(unitRateVar+inc).value=document.getElementById(unitRateVarTemp+inc).value
    
  }


 </script>

<% 
			int k1=0;
  					if(brandList.size()>0)
  						
 						for (MasStoreBrand masStoreBrand:brandList){
 	
 			%>
<script>
         		 
         		itemsArray2[<%=k1%>]= new Array();
         		itemsArray2[<%=k1%>][0] = "<%=masStoreBrand.getId()%>";
				itemsArray2[<%=k1%>][1] = "<%=masStoreBrand.getBrandName()%>";
				itemsArray2[<%=k1%>][2] = "<%=masStoreBrand.getManufacturer().getManufacturerName()%>";
				
         		</script>
<%
          k1++;
 						} %>
<script>
var nameArray=new Array();
var codeArray=new Array();
</script>

<% Set<StoreItemBatchStock> set=new HashSet<StoreItemBatchStock>();
			int k=0;
 		 
  					if(itemList.size()>0)
  						
 						for (MasStoreItem masStoreItem:itemList){
 							
 			%>
<script>
         		 
         		itemsArray1[<%=k%>]= new Array();
         		itemsArray1[<%=k%>][0] = "<%=masStoreItem.getId()%>";
				itemsArray1[<%=k%>][1] = "<%=masStoreItem.getPvmsNo()%>";
				codeArray[<%=k%>]="<%=masStoreItem.getPvmsNo()%>";
				<%StringBuffer output_str = new StringBuffer();
				StringTokenizer s = new StringTokenizer(masStoreItem.getNomenclature().toString(),"\""); 
				
				while (s.hasMoreTokens())
				{
					output_str.append(s.nextToken());
					if (s.hasMoreTokens())
					{
					output_str.append("\\");
			 	        output_str.append("\"");
					}
				}
			
				%>
				nameArray[<%=k%>]="<%=output_str.toString()%>"
				itemsArray1[<%=k%>][2]="<%=output_str.toString()%>"
				itemsArray1[<%=k%>][3] = "<%=masStoreItem.getItemConversion().getItemUnitName()%>";
         		
         		</script>
<%
          
          	set=(Set<StoreItemBatchStock>)masStoreItem.getStoreItemBatchStocks();
          for(StoreItemBatchStock batchStock:set){
        	  if(batchStock.getItem().getId()==masStoreItem.getId()){
        		  %>

<script>
        		  itemsArray1[<%=k%>][6] = "<%=batchStock.getClosingStock()%>";
        		 
        		  </script>

<% 
        	  }
          }
          k++;
 					
 						} %>
<div id="contentspace">

<form name="balance" method="post"><br />

<h2 align="left" class="style1">Opening Balance Entry</h2>

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



<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">

<form name="searchPanel" method="post">
<table cellpadding="4" cellspacing="1" border="0">

	<tr>
		<td class="vbmenu_option" title="nohilite"><input type="hidden"
			name="s" value="cccfbaab0a70ed43fad9de8e3733112d" /> <input
			type="hidden" name="do" value="process" /> <input type="hidden"
			name="searchthread" value="1" /> <input type="hidden"
			name="showposts" value="1" /> <input type="hidden"
			name="searchthreadid" value="85875" /> <label class="bodytextB_blue">From
		Date :</label> <input type="text" name="<%= FROM_DATE %>" class="textbox_date"
			MAXLENGTH="30" / tabindex=1 /> <img id="calendar"
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date" class="calender" tabindex="1"
			onClick="setdate('<%=currentDate%>',document.balance.<%= FROM_DATE%>,event)" />
		<label class="bodytextB_blue">To Date :</label> <input type="text"
			name="<%= TO_DATE %>" class="textbox_date" MAXLENGTH="30"
			/ tabindex=1 /> <img id="calendar" src="/hms/jsp/images/cal.gif"
			width="16" height="16" border="0" validate="Pick a date"
			class="calender" tabindex="1"
			onClick="setdate('<%=currentDate%>',document.balance.<%= TO_DATE%>,event)" />

		<br />
		<label class="bodytextB_blue">Opening Balance No:</label> <select
			name="<%= SEARCH_BALANCE_NO%>">
			<option value="0">Select</option>
			<%
					for (StoreBalanceM storeBalanceM :searchStoreBalanceMList ) {
				%>

			<option value=<%=storeBalanceM.getBalanceNo()%>><%=storeBalanceM.getBalanceNo()%></option>

			<%
					}
				%>
		</select> <input type="button" class="smbutton" value="Go!"
			onClick="submitForm('balance','stores?method=searchBalance');" /></td>
	</tr>

</table>
</form>
</div>

<jsp:include page="searchResultPO.jsp" /> <br />



<form name="balanceGrid" method="post">


<div id="testDiv" size="height:500px;"><input type="hidden"
	name="pageNo" value="<%=pageNo%>" /> <label class="bodytextB_blue"><font
	id="error"></font> Opening Balance No: </label> <input type="text"
	name="<%=BALANCE_NO %>" value="<%=max%>" readonly="readonly"
	class="textbox_size20" MAXLENGTH="8"/  > <label
	class="bodytextB_blue"><font id="error"></font>Opening Balance
Date:</label> <input type="text" name="<%=BALANCE_DATE%>" readonly="readonly"
	value="<%=currentDate %>" class="textbox_size20" MAXLENGTH="30" /> <br />
<br />

<label class="bodytextB_blue"><font id="error"></font>Approved
By:</label> <select name="<%=APPROVED_BY_EMPLOYEE_ID_BALANCE%>"
	validate="Approved By,String,yes">
	<option value="0">Select</option>
	<%
				for (MasEmployee approvedBy :approvedByEmployeeList ) {
			%>

	<option value=<%=approvedBy.getId()%>><%=approvedBy.getId()%></option>

	<%
				}
			%>
</select> <label class="bodytextB_blue"><font id="error"></font>Remarks</label> <input
	type="text" name="<%=REMARKS %>" value=" " class="textbox_size20"
	tabindex=3 maxlength="30" /> <br>
<br />

<input type="hidden" name="<%=CHANGED_BY %>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date1%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <br />
<br />

<input type="button" class="button" value="Next"
	onclick="if(checkForNext()){submitForm('balanceGrid','stores?method=nextBalance');}"
	align="right" /> <input type="button" name="sss" align="right"
	class="button" value="Submit"
	onclick="if(checkForSubmit()){submitForm('balanceGrid','stores?method=submitBalance');}" />
Page No:<%=pageNo%> <input type="text" size="2" value="0"
	name="noOfRows" id="noOfRows" /> <input type="hidden"
	name="<%=BALANCE_ID %>" value="<%=balanceId%>" id="hdb" /> <br />
<fieldset style="width: 99%; padding-left: 9px;"><legend>Balance
details</legend>


<div
	style="overflow: auto; width: 100%; height: 260px; padding-left: 9px;">
<table width="200px" colspan="7" id="balanceDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<td width="5%"><label valign="left" class="smalllabel">Sl''''
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Nomenclature</label>
			</td>
			<td width="10%"><label valign="left" class="smalllabel">A/U</label>
			</td>
			<td width="10%"><label valign="left" class="smalllabel">Brand
			Name</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Manufacturer</label></td>
			<td width="5%"><label valign="left" class="smalllabel">Batch
			No.</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Quantity
			</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Unit
			Rate</label></td>

		</tr>

	</thead>
	<tbody>



		<td width="10%">
		<%
    	int detailCounter=8; 
    	int temp=0;
    	String idItem="idItem";
    	String codeItem="codeItem";
    	String nameItem="nameItem";
    	String idBrand="idBrand";
    	String nameManufacturer="nameManufacturer";
    	String idAu="idAu";
    	
    	String batchNoVar="batchNoVar";
    	String qtyVar="qtyVar";
    	String unitRateVar="unitRateVar";
    	    
    	String batchNoVarTemp="batchNoVarTemp";
    	String qtyVarTemp="qtyVarTemp";
    	String unitRateVarTemp="unitRateVarTemp";
    	String incVar="incVar";
    	
    	
    	String idItem2="idItem";
    	String codeItem2="codeItem";
    	String nameItem2="nameItem";
    	String idBrand2="idBrand";
    	String nameManufacturer2="nameManufacturer";
    	String idAu2="idAu";
    	
    	String batchNoVar2="batchNoVar";
    	String qtyVar2="qtyVar";
    	String unitRateVar2="unitRateVar";
    	
    	String batchNoVarTemp2="batchNoVarTemp";
    	String qtyVarTemp2="qtyVarTemp";
    	String unitRateVarTemp2="unitRateVarTemp";
    	String incVar2="incVar2";
    	if(pageNo!=1)
    	{
    		temp=detailCounter*(pageNo-1);
    	}
     	 for(int inc=1;inc<=8;inc++){
     		idItem=idItem2+(""+inc);
     		codeItem=codeItem2+(""+inc);
     		nameItem=nameItem2+(""+inc);
     		idBrand=idBrand2+(""+inc);
        	nameManufacturer=nameManufacturer2+(""+inc);
     		idAu=idAu2+(""+inc);
     		
     		batchNoVar=batchNoVar2+(""+inc);
     		qtyVar=qtyVar2+(""+inc);
     		unitRateVar=unitRateVar2+(""+inc);
     	
     		batchNoVarTemp=batchNoVarTemp2+(""+inc);
     		qtyVarTemp=qtyVarTemp2+(""+inc);
     		unitRateVarTemp=unitRateVarTemp2+(""+inc);
     		incVar=incVar2+(""+inc);
    	  %>
		<tr>
			<td width="5%"><input type="text" size="2" value="<%=temp+inc%>"
				class="smcaption" name="<%=SR_NO%>" readonly="readonly" /></td>
			<td width="10%"><input type="text" class="medcaption"
				name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem%>" /> <script>
		var obj2 = actb(document.getElementById('<%=codeItem%>'),codeArray);
		</script> <input type="hidden" size="2" value="0" class="smcaption"
				name="<%=ITEM_ID%>" id="<%=idItem%>" /></td>
			<td width="10%"><input type="text" value="" id="<%=nameItem%>"
				class="bigcaption" name="<%=NOMENCLATURE%>"
				onblur="fillItemsInBalance(this.value,<%=inc%>);" /> <script>
		var obj = actb(document.getElementById('<%=nameItem%>'),nameArray);
	</script></td>
			<td width="10%"><input type="text" value="" class="smcaption"
				readonly="readonly" name="<%=AV%>" id="<%=idAu%>" /></td>
			<td width="10%"><select name="<%= BRAND%>"
				onchange="fillBalance(this.value,this.id)" id="<%=inc%>">
				<option value="0">Select</option>
				<%
					for (MasStoreBrand masStoreBrand :brandList ) {
				%>

				<option value=<%=masStoreBrand.getId()%>><%=masStoreBrand.getBrandName()%></option>

				<%
					}
				%>
			</select> <input type="hidden" size="2" value="0" class="smcaption"
				name="<%=BRAND_ID%>" id="<%=idBrand%>" /></td>
			<td width="10%"><input type="text" value=" "
				id="<%=nameManufacturer%>" class="bigcaption" readonly="readonly"
				name="<%=MANUFACTURER%>" /></td>

			<td width="5%"><input type="text"  size="8" value="" name="<%=BATCH%>"
				class="bigcaption" id="<%=batchNoVarTemp%>"
				onblur="fillValuesBalance(<%=inc%>);" maxlength="10" /> <input
				type="hidden" size="2" value="" name="<%=BATCH_NO%>"
				id="<%=batchNoVar%>" />
		<input type="hidden" name="<%=EXPIRY_DATE %>" value="12/03/2008"
			class="textbox_date" readonly="readonly" />
	</td>

		<td width="10%"><input type="text" value="" class="medcaption"
			name="<%=QTY_BALANCE_TEMP%>" tabindex="2" id="<%=qtyVarTemp%>"
			validate="Qty,num,no" onblur="fillValuesBalance(<%=inc%>);" /> <input
			type="hidden" value="0" class="medcaption" name="<%=QTY_BALANCE%>"
			tabindex="2" id="<%=qtyVar%>" /></td>
		<td width="10%"><input type="text" value="" class="medcaption"
			name="<%=UNIT_RATE_BALANCE_TEMP%>" tabindex="2"
			id="<%=unitRateVarTemp%>" validate="unit Rate,num,no"
			onblur="fillValuesBalance(<%=inc%>);" /> <input type="hidden"
			value="0" class="medcaption" name="<%=UNIT_RATE_BALANCE%>"
			tabindex="2" id="<%=unitRateVar%>" /></td>
		</tr>
		<% }   %>



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
	</script> <input type="hidden" name="rows" id="rr" value="1" /></form>

</div>
