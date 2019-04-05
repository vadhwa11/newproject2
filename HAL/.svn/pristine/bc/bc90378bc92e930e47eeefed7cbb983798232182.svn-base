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

<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="java.util.List"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>

<%@page import="jkt.hms.masters.business.StoreBalanceM"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreBalanceT"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="java.util.HashSet"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>

<script type="text/javascript" src="/hms/jsp/js/actb.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>

<%System.out.println("Modify");
	Map map = new HashMap();
	String includedJsp = null;
	String previousPage="no";
	int pageNo=1;
	int balanceId=0;
		List<StoreBalanceM> searchStoreBalanceMList = new ArrayList<StoreBalanceM>();
		List<MasStoreItem> itemList= new ArrayList<MasStoreItem>();
		List<StoreBalanceM> previousStoreBalanceMList=new ArrayList<StoreBalanceM>();
		List<StoreBalanceT> gridStoreBalanceTList=new ArrayList<StoreBalanceT>();
		List<MasStoreBrand> brandList= new ArrayList<MasStoreBrand>();
		List<StoreBalanceM> gridStoreBalanceMList= new ArrayList<StoreBalanceM>();
		List<MasEmployee> approvedByEmployeeList = new ArrayList<MasEmployee>();
		String max="";
		String noDetailRecords="no";
		String date="";
		String time="";
		String userName = "";
		try{
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	if(map.get("balanceId")!=null){
		balanceId=Integer.parseInt(""+map.get("balanceId"));
		System.out.print("------------------------ In Jsp balanceId "+balanceId);
	}
	if(map.get("noDetailRecords")!=null){
		noDetailRecords=(""+map.get("noDetailRecords"));
		System.out.print("------------------------ In Jsp noDetailRecords "+noDetailRecords);
	}
	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt(""+map.get("pageNo"));
		
	}
	System.out.println("------------ Page No "+pageNo );
	if(map.get("max")!=null)
		max=(""+map.get("max"));
	
	
	
	if(map.get("gridStoreBalanceTList")!=null){
		gridStoreBalanceTList=(List) map.get("gridStoreBalanceTList");
		System.out.println("333333333333333333333333333333 "+((List)map.get("gridStoreBalanceTList")).size());
		System.out.println("----gridStoreBalanceTList---------in JSP-----------  "+gridStoreBalanceTList.size());		
	}
	if(map.get("gridStoreBalanceMList")!=null)
		gridStoreBalanceMList=(List) map.get("gridStoreBalanceMList");
	System.out.println("----gridStoreBalanceMList---------in JSP-----------  "+gridStoreBalanceMList.size());
	
	
	if(map.get("brandList")!=null)
		brandList=(List) map.get("brandList");
	System.out.println("----brandList---------in JSP-----------  "+brandList.size());
	
	if(map.get("approvedByEmployeeList")!=null)
		approvedByEmployeeList=(List) map.get("approvedByEmployeeList");
	System.out.println("----approvedByEmployeeList---------in JSP-----------  "+approvedByEmployeeList.size());
	
	
	if(map.get("itemList")!=null)
		itemList=(List) map.get("itemList");
	System.out.println("------------------------ In Jsp itemList map "+itemList.size());
	
	if(map.get("searchStoreBalanceMList")!=null)
	searchStoreBalanceMList = (List) map.get("searchStoreBalanceMList");
	System.out.println("----searchStoreBalanceMList---------in JSP-----------  "+searchStoreBalanceMList.size());
	
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}

	System.out.println("------------------------ In Jsp searchStoreBalanceMList "+searchStoreBalanceMList.size());
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 date = (String)utilMap.get("currentDate");	 
	 time = (String)utilMap.get("currentTime");
	 }catch(Exception e){
		 e.printStackTrace();
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
	var nameArray2=new Array();
	var itemsArray1=new Array();
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
				nameArray2[<%=k%>]="<%=output_str.toString()%>"
				itemsArray1[<%=k%>][2]="<%=output_str.toString()%>"
				itemsArray1[<%=k%>][3] = "<%=masStoreItem.getItemConversion().getItemUnitName()%>"
         		
         		</script>

<% k++;}%>


<div id="contentspace">

<form name="indent" method="post"><br />
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
					class="toolbutton"></td>
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
		Date :</label> <input type="text" name="<%= FROM_DATE %>" class="textbox_date"
			MAXLENGTH="30" / tabindex=1 /> <img id="calendar"
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=date%>',document.indent.<%= FROM_DATE%>,true);"
			class="calender" /> <label class="bodytextB_blue">To Date :</label>

		<input type="text" name="<%= TO_DATE %>" class="textbox_date"
			MAXLENGTH="30" / tabindex=1 /> <img id="calendar"
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=date%>',document.indent.<%= TO_DATE%>,true);"
			class="calender" /> <br />
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
			onClick="submitForm('indent','stores?method=searchBalance');" /></td>
	</tr>

</table>
</form>
</div>
</div>
</div>
<jsp:include page="searchResultPO.jsp" /> <br />








</form>

<form name="indentGrid" method="post">


<div id="testDiv" size="height:500px;">
<%try{
			for(StoreBalanceM storeBalanceM:gridStoreBalanceMList){
				System.out.println("In Master"+gridStoreBalanceMList.size());
			%> <input type="hidden" name="totalRecords"
	value="<%=gridStoreBalanceMList.size() %>" /> <input type="hidden"
	name="pageNo" value="<%=pageNo%>" /> <input type="hidden"
	name="<%=NO_DETAIL_RECORDS%>" value="<%=noDetailRecords%>" /> <label
	class="bodytextB_blue"><font id="error"></font> Opening Balance
No: </label> <input type="text" name="<%=BALANCE_NO %>"
	value="<%=storeBalanceM.getBalanceNo()%>" readonly="readonly"
	class="textbox_size20" MAXLENGTH="8"/  > <label
	class="bodytextB_blue"><font id="error"></font>Opening Balance
Date:</label> <input type="text" name="<%=BALANCE_DATE%>" readonly="readonly"
	value="<%=HMSUtil.changeDateToddMMyyyy(storeBalanceM.getBalanceDate())%>"
	class="textbox_size20" MAXLENGTH="30" /> <br />
<br />

<label class="bodytextB_blue"><font id="error"></font>Approved
By:</label> <select name="<%=APPROVED_BY_EMPLOYEE_ID_BALANCE%>">
	<option value="0">Select</option>
	<%
				for (MasEmployee approvedBy : approvedByEmployeeList ) {
					if(storeBalanceM.getApprovedBy().getId() == approvedBy.getId()){
			%>

	<option value=<%=approvedBy.getId()%> selected="selected"><%=approvedBy.getId()%></option>

	<%}else{ %>
	<option value="<%=approvedBy.getId()%>"><%=approvedBy.getId()%></option>
	<%}
						}
					%>
</select> <label class="bodytextB_blue"><font id="error"></font>Remarks</label> <input
	type="text" name="<%=REMARKS %>"
	value="<%=storeBalanceM.getRemarks()%>" class="textbox_size20"
	tabindex=3 /> <br>
<br />
<%
			}	}catch(Exception e){
				e.printStackTrace();
			}
			%> <br />

<input type="button" class="button" value="next"
	onclick="if(checkForNext()){submitForm('indentGrid','stores?method=updateNextBalance1&buttonName=next');}"
	align="right" /> <input type="button" name="sss" align="right"
	class="button" value="submit"
	onclick="if(checkForSubmit()){submitForm('indentGrid','stores?method=updateNextBalance1&buttonName=submit');}" />
Page No:<%=pageNo%> <input type="hidden" size="2" value="10"
	name="noOfRows" id="noOfRows" /> <input type="hidden"
	name="<%=BALANCE_ID %>" value="<%=balanceId%>" id="hdb" /> <br />
<fieldset style="width: 99%; padding-left: 9px;"><legend>Balance
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
			<td width="10%"><label valign="left" class="smalllabel">A/U</label>
			</td>
			<td width="10%"><label valign="left" class="smalllabel">Brand
			Name</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Manufacturer</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Batch
			No.</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Quantity
			</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Unit
			Rate</label></td>

		</tr>

	</thead>
	<tbody>


		<%
		int detailCounter = 10; 
    	int temp=0;
    	String idItem="idItem";
    	String codeItem="codeItem";
    	String nameItem="nameItem";
    	String idAu="idAu";
    	
    	String idBrand="idBrand";
    	String nameBrand="nameBrand";
    	String idManufacturer="idManufacturer";
    	String nameManufacturer="nameManufacturer";
    	
    	
    	
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
    	String idAu2="idAu";
    	String idBrand2="idBrand";
    	String nameBrand2="nameBrand";
    	String idManufacturer2="idManufacturer";
    	String nameManufacturer2="nameManufacturer";
    	
    	String stockInVar2="stockInVar";
    	String mmfVar2="mmfVar";
    	String demandVar2="demandVar";

    	String batchNoVar2="batchNoVar";
    	String qtyVar2="qtyVar";
    	String unitRateVar2="unitRateVar";
    	
    	String batchNoVarTemp2="batchNoVarTemp";
    	String qtyVarTemp2="qtyVarTemp";
    	String unitRateVarTemp2="unitRateVarTemp";
    	String incVar2="incVar2";
			int inc=((pageNo-1)*8)+1;
	    	   
	    	   int incTemp2=inc+8;
	    	   for(StoreBalanceT storeBalanceT:gridStoreBalanceTList){
	    		 
	    		  if(inc<=incTemp2){
		%>
		<td width="10%">
		<%
     		 System.out.println("1111111111111");
     		idItem=idItem2+(""+inc);
     		codeItem=codeItem2+(""+inc);
     		nameItem=nameItem2+(""+inc);
     		idAu=idAu2+(""+inc);
     		idBrand=idBrand2+(""+inc);
     		nameBrand=nameBrand2+(""+inc);
     		idManufacturer=idManufacturer2+(""+inc);
        	nameManufacturer=nameManufacturer2+(""+inc);
     		
        	batchNoVar=batchNoVar2+(""+inc);
     		qtyVar=qtyVar2+(""+inc);
     		unitRateVar=unitRateVar2+(""+inc);
     	
     		
     		batchNoVarTemp=batchNoVarTemp2+(""+inc);
     		qtyVarTemp=qtyVarTemp2+(""+inc);
     		unitRateVarTemp=unitRateVarTemp2+(""+inc);
     		incVar=incVar2+(""+inc);
    	  %>
		<tr>
			<td width="5%"><input type="text" size="2"
				value="<%=storeBalanceT.getSrNo()%>" class="smcaption"
				name="<%=SR_NO%>" readonly="readonly" /></td>
			<input type="hidden" name="<%= BALANCE_T_ID%>"
				value="<%=storeBalanceT.getId()%>" />
			<td width="10%"><input type="text" size="2"
				value="<%=storeBalanceT.getItem().getPvmsNo() %>" class="medcaption"
				readonly="readonly" name="<%=ITEM_CODE%>" id="<%=codeItem%>" /> <input
				type="hidden" size="2" value="<%=storeBalanceT.getItem().getId() %>"
				class="smcaption" name="<%=ITEM_ID%>" id="<%=idItem%>" /></td>


			<td width="10%"><input type="text" id="<%=nameItem%>"
				value="<%=storeBalanceT.getItem().getNomenclature() %>"
				class="bigcaption" name="<%=NOMENCLATURE%>"
				onblur="fillItemsInBalance(this.value,<%=inc%>);" /> <script>
		var obj = actb(document.getElementById('<%=nameItem%>'),nameArray2);
	</script></td>
			<td width="10%"><input type="text"
				value="<%=storeBalanceT.getItem().getItemConversion().getItemUnitName() %>"
				class="smcaption" validate="Av,String,no" readonly="readonly"
				name="<%=AV%>" id="<%=idAu%>" /></td>


			<td width="10%"><select name="<%= BRAND%>"
				onchange="fillBalance(this.value,this.id)" id="<%=inc%>">
				<option value="0">Select</option>
				<%
							for (MasStoreBrand masStoreBrand :brandList ) {
								if(storeBalanceT.getBrand().getId().equals(masStoreBrand.getId())){
						%>


				<option value=<%=masStoreBrand.getId()%> selected="selected"><%=masStoreBrand.getBrandName()%></option>

				<%
							}else{
						%>
				<option value=<%=masStoreBrand.getId()%>><%=masStoreBrand.getBrandName()%></option>
				<%
							}}
						%>

			</select> <input type="hidden" size="2"
				value="<%=storeBalanceT.getBrand().getId() %>" class="smcaption"
				name="<%=BRAND_ID%>" id="<%=idBrand%>" /></td>
			<td width="10%"><input type="text"
				value="<%=storeBalanceT.getBrand().getManufacturer().getManufacturerName() %>"
				id="<%=nameManufacturer%>" class="bigcaption" readonly="readonly"
				name="<%=MANUFACTURER%>" onblur="fillValuesBalance(<%=inc%>);" /></td>


			<td width="10%"><input type="text"
				value="<%=storeBalanceT.getBatchNo() %>" name="<%=BATCH%>"
				class="bigcaption" id="<%=batchNoVarTemp%>"
				onblur="fillValuesBalance(<%=inc%>); %>);" MAXLENGTH="10" /> <input
				type="hidden" size="2" value="<%=storeBalanceT.getBatchNo() %>"
				name="<%=BATCH_NO%>" id="<%=batchNoVar%>" /></td>
			<input type="hidden" name="<%=EXPIRY_DATE%>"
				value="<%=HMSUtil.changeDateToddMMyyyy(storeBalanceT.getExpiryDate())%>"
				class="textbox_date" validate="Second Rec .Date Date,date,yes"
				MAXLENGTH="30" />

			<td width="10%"><input type="text"
				value="<%=storeBalanceT.getQty() %>" class="medcaption"
				name="<%=QTY_BALANCE_TEMP%>" tabindex="2" id="<%=qtyVarTemp%>"
				validate="Qty,num,no" onblur="fillValuesBalance(<%=inc%>);" /> <input
				type="hidden" value="<%=storeBalanceT.getQty() %>"
				class="medcaption" name="<%=QTY_BALANCE%>" tabindex="2"
				id="<%=qtyVar%>" /></td>
			<td width="10%"><input type="text"
				value="<%=storeBalanceT.getUnitRate() %>" class="medcaption"
				name="<%=UNIT_RATE_BALANCE_TEMP%>" tabindex="2"
				id="<%=unitRateVarTemp%>" validate="Unit Rate,num,no"
				onblur="fillValuesBalance(<%=inc%>);" /> <input type="hidden"
				value="<%=storeBalanceT.getUnitRate() %>" class="medcaption"
				name="<%=UNIT_RATE_BALANCE%>" tabindex="2" id="<%=unitRateVar%>" />
			</td>
		</tr>
		<% inc++;
     	 }
     	 }
	    	 %> <script>
	    	 document.indentGrid.noOfRows.value=<%=inc-((pageNo-1)*8)-1%>
	    	 </script> <%  
	    	 if(inc<incTemp2){
   			  for(;inc<incTemp2;inc++){
   				idItem=idItem2+(""+inc);
   	     		codeItem=codeItem2+(""+inc);
   	     		nameItem=nameItem2+(""+inc);
   	     		idAu=idAu2+(""+inc);
   	     		
   	     		idBrand=idBrand2+(""+inc);
     			nameBrand=nameBrand2+(""+inc);
     			idManufacturer=idManufacturer2+(""+inc);
        		nameManufacturer=nameManufacturer2+(""+inc);
     		
        		batchNoVar=batchNoVar2+(""+inc);
     			qtyVar=qtyVar2+(""+inc);
     			unitRateVar=unitRateVar2+(""+inc);
     	
     		
     			batchNoVarTemp=batchNoVarTemp2+(""+inc);
     			qtyVarTemp=qtyVarTemp2+(""+inc);
     			unitRateVarTemp=unitRateVarTemp2+(""+inc);
   	     		incVar=incVar2+(""+inc);
			%>

		<tr>
			<td width="5%"><input type="text" size="2"
				value="<%=temp+inc %>" class="smcaption" name="<%=SR_NO%>"
				readonly="readonly" /></td>
			<td width="10%"><input type="text" class="medcaption"
				name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem%>" /> <input
				type="hidden" size="2" value="0" class="smcaption"
				name="<%=ITEM_ID%>" id="<%=idItem%>" /></td>

			<td width="10%"><input type="text" value="" id="<%=nameItem%>"
				class="bigcaption" name="<%=NOMENCLATURE%>"
				onblur="fillItemsInBalance(this.value,<%=inc%>);" /> <script>
		var obj1 = actb(document.getElementById('<%=nameItem%>'),nameArray2);
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
				name="<%=MANUFACTURER%>" onblur="fillValuesBalance(<%=inc%>);" /></td>

			<td width="10%"><input type="text" value="" name="<%=BATCH%>"
				class="bigcaption" id="<%=batchNoVarTemp%>" MAXLENGTH="10"
				onblur="fillValuesBalance(<%=inc%>); %>);" /> <input type="hidden"
				size="2" value="emptyString" name="<%=BATCH_NO%>"
				id="<%=batchNoVar%>" /></td>
		</td>


		<input type="hidden" name="<%=EXPIRY_DATE %>" value="12/03/2008"
			class="textbox_date" readonly="readonly" />


		<td width="10%"><input type="text" value="" class="medcaption"
			name="<%=QTY_BALANCE_TEMP%>" tabindex="2" validate="Qty,num,no"
			id="<%=qtyVarTemp%>" onblur="fillValuesBalance(<%=inc%>);" /> <input
			type="hidden" value="0" class="medcaption" name="<%=QTY_BALANCE%>"
			tabindex="2" id="<%=qtyVar%>" /></td>
		<td width="10%"><input type="text" value="" class="medcaption"
			name="<%=UNIT_RATE_BALANCE_TEMP%>" tabindex="2"
			validate="Unit Rate,num,no" id="<%=unitRateVarTemp%>"
			onblur="fillValuesBalance(<%=inc%>);" /> <input type="hidden"
			value="0" class="medcaption" name="<%=UNIT_RATE_BALANCE%>"
			tabindex="2" id="<%=unitRateVar%>" /></td>
		</tr>

		<% }
	    		  }
     	    %>



	</tbody>

</table>
</fieldset>
<span class="bodytextB_blue">Changed By:</span> <input type="text"
	name="<%=CHANGED_BY%>" value="<%=userName%>" class="textbox_size20"
	readonly="readonly" MAXLENGTH="8" / tabindex=3 /> <span
	class="bodytextB_blue"> Changed Date:</span> <input type="text"
	name="<%=CHANGED_DATE %>" value="<%=date%>" class="textbox_size20"
	readonly="readonly" tabindex=3 /> <span class="bodytextB_blue">Changed
Time:</span> <input type="text" name="<%=CHANGED_TIME %>" value="<%=time%>"
	class="textbox_size20" readonly="readonly" tabindex=3 /></div>



</form>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script> <input type="hidden" name="rows" id="rr" value="1" />

</form>

</div>
