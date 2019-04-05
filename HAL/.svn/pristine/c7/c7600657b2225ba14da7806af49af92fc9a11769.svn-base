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
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreBalanceM"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>

<%@page import="java.util.StringTokenizer"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<link rel="stylesheet" href="/hms/jsp/css/acnik.css" type="text/css" />

<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>

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
<%
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
	String includedJsp = null;
	String previousPage="no";
	int pageNo=1;
	
	List<StoreBalanceM> searchStoreBalanceMList = new ArrayList<StoreBalanceM>();
	List<MasStoreBrand> brandList= new ArrayList<MasStoreBrand>();
	List<MasStoreItem> itemList= new ArrayList<MasStoreItem>();
	String maxBalanceNo="";

	//--------Hearder Variables-------
	String balanceNo="";
	int balanceId=0;
	String balanceDate="";

	
	//--------End -------- Hearder Variables-------

	if (request.getAttribute("map") != null) 
		map = (Map) request.getAttribute("map");
	if(map.get("max")!=null)
		balanceNo=""+map.get("max");
	if(map.get("balanceId")!=null)
		balanceId= Integer.parseInt(""+map.get("balanceId")) ;
	
	if(map.get("balanceDate")!=null)
		balanceDate =""+ map.get("balanceDate");
	
	
	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt(""+map.get("pageNo"));
	}
	
	
	if(map.get("max")!=null)
		maxBalanceNo=(""+map.get("max"));
	
	if(map.get("itemList")!=null)
		itemList=(List) map.get("itemList");

	if(map.get("brandList")!=null)
		brandList=(List) map.get("brandList");
	System.out.println("brandList   in JSP    "+brandList.size());
	
	if(map.get("searchStoreBalanceMList")!=null)
	searchStoreBalanceMList = (List) map.get("searchStoreBalanceMList");
	
	
	List<MasEmployee> approvedByEmployeeList = new ArrayList<MasEmployee>();
	if(map.get("approvedByList") != null)
		approvedByEmployeeList = (ArrayList) map.get("approvedByList");

	List objectList=new ArrayList();
	if(map.get("objectList")!=null)
		objectList=(List) map.get("objectList");


%>



<script type="text/javascript">
 
  var brandArray = new Array();
  
   function fillManu(brandId,rowVal){
   for(i=0;i<brandArray.length;i++){
	if(brandArray[i][1] ==brandId  )
	 document.getElementById('nameManufacturer'+rowVal).value=brandArray[i][3]
	 
  }
   
   }
  
  function fillValuesBalance(inc)
  {
    	
    	var batchNoVar="batchNoVar";
    	var batchNoVarTemp="batchNoVarTemp";
    	
    	
    	var expDateVar="expDateVar";
    	var expDateVarTemp="expDateVarTemp";
    	
    	
    	var qtyVar="qtyVar";
    	var qtyVarTemp="qtyVarTemp";
    	
    	var unitRateVar="unitRateVar";
    	var unitRateVarTemp="unitRateVarTemp";
    	
    	   	
    if(document.getElementById(batchNoVarTemp+inc).value!=""){
      		document.getElementById(batchNoVar+inc).value=document.getElementById(batchNoVarTemp+inc).value
     }
     else
      		document.getElementById(batchNoVar+inc).value="emptyString";
     
      
         if(document.getElementById(expDateVarTemp+inc).value!=""){
      		document.getElementById(expDateVar+inc).value=document.getElementById(expDateVarTemp+inc).value
     }
     else
      		document.getElementById(expDateVar+inc).value="emptyString";
     
      
       if(document.getElementById(qtyVarTemp+inc).value!=""){
      		document.getElementById(qtyVar+inc).value=document.getElementById(qtyVarTemp+inc).value
     }
     else
      		document.getElementById(qtyVar+inc).value="0";
      
      
      if(document.getElementById(unitRateVarTemp+inc).value!=""){
      		document.getElementById(unitRateVar+inc).value=document.getElementById(unitRateVarTemp+inc).value
     }
     else
      		document.getElementById(unitRateVar+inc).value="0";
      

    
  }


 </script>
<script>
		var nameArray=new Array();
		var itemsArray1=new Array();
	</script>



<%int k=0;
  			try{
  			if(objectList.size()>0)
			for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
				
				Object[] object = (Object[]) iterator.next();
				
				Integer itemIdFromObject = (Integer)object[0];
				String  itemPvmsNoFromObject = (""+object[1]);
				String  itemNomenclatureFromObject = (""+object[2]) ;
				
				String  itemStrengthFromObject = (""+object[3]);
				String  itemAuFromObject = (""+object[4]) ;
				
				%>
<script>
	         			itemsArray1[<%=k%>]= new Array();
	         			itemsArray1[<%=k%>][0] = "<%=itemIdFromObject%>";
	         			itemsArray1[<%=k%>][1] = "<%=itemPvmsNoFromObject%>";
						<%
						StringBuffer output_str = new StringBuffer();
						
						StringTokenizer s = new StringTokenizer(itemNomenclatureFromObject,"\""); 
						
						while (s.hasMoreTokens())
						{	output_str.append(s.nextToken());
							if (s.hasMoreTokens()){
							output_str.append("\\");
					 	    output_str.append("\"");
							}
						}
						
				%>
				<%
				
				if(itemStrengthFromObject.equals("")){
				%>
				nameArray[<%=k%>]="<%=output_str.toString()+itemStrengthFromObject%>"
				itemsArray1[<%=k%>][2]="<%=output_str.toString()+itemStrengthFromObject%>"
				<%}else{%>
				nameArray[<%=k%>]="<%=output_str.toString()%>"
				itemsArray1[<%=k%>][2]="<%=output_str.toString()%>"
				<%}%>
				itemsArray1[<%=k%>][3]="<%=itemAuFromObject%>"
				
         		</script>

<% k++;}
  			
  			}catch(Exception ee){
  				ee.printStackTrace();
  			}%>


<div id="contentspace">

<form name="departmentIndent" method="post"><br />
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
			onClick="setdate('<%=currentDate%>',document.departmentIndent.<%= FROM_DATE%>,true);"
			class="calender" /> <label class="bodytextB_blue">To Date :</label>

		<input type="text" name="<%= TO_DATE %>" class="textbox_date"
			MAXLENGTH="30" / tabindex=1 /> <img id="calendar"
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.departmentIndent.<%= TO_DATE%>,true);"
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
			onClick="submitForm('departmentIndent','stores?method=searchBalance');" />
		</td>
	</tr>

</table>
</form>
</div>
</div>
</div>
<jsp:include page="searchResultPO.jsp" /> <br />
</form>

<form name="departmentIndentGrid" method="post">
<div id="testDiv" size="height:500px;"><input type="hidden"
	name="pageNo" value="<%=pageNo%>" /> <input type="hidden" size="2"
	value="0" name="<%=NO_OF_ROWS%>" id="<%=NO_OF_ROWS%>" /> <input
	type="hidden" name="<%=BALANCE_ID %>" value="<%=balanceId%>" id="hdb" />

<br />
<input type="button" class="button" value="Next"
	onclick="if(checkForNext()){submitForm('departmentIndentGrid','stores?method=addNextOrSubmitBalance&buttonName=next');}"
	align="right" /> <input type="button" name="sss" align="right"
	class="button" value="Submit"
	onclick="if(checkForSubmit()){submitForm('departmentIndentGrid','stores?method=addNextOrSubmitBalance&buttonName=submit');}" />
Page No:<%=pageNo%> <br />
<fieldset style="width: 99%; padding-left: 9px;"><legend>Opening
Balance details</legend>


<div
	style="overflow: auto; width: 100%; height: 260px; padding-left: 9px;">
<table width="200px" colspan="7" id="indentDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>


			<td width="5%"><label valign="left" class="smalllabel">SR
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
			<td width="5%"><label valign="left" class="smalllabel">Expriy
			Date(dd/mm/yyyy)</label></td>
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
    	String expDateVar="expDateVar";
    	String qtyVar="qtyVar";
    	String unitRateVar="unitRateVar";
    	    
    	String batchNoVarTemp="batchNoVarTemp";
    	String expDateVarTemp="expDateVarTemp";
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
    	String expDateVar2="expDateVar";
    	String qtyVar2="qtyVar";
    	String unitRateVar2="unitRateVar";
    	
    	String batchNoVarTemp2="batchNoVarTemp";
    	String expDateVarTemp2="expDateVarTemp";
    	String qtyVarTemp2="qtyVarTemp";
    	String unitRateVarTemp2="unitRateVarTemp";
    	String incVar2="incVar2";
    	
    	if(pageNo!=1)
    	{
    		temp=detailCounter*(pageNo-1);
    	}
     	 for(int inc=1;inc<=detailCounter;inc++){
     		 idItem=idItem2+(""+inc);
     		codeItem=codeItem2+(""+inc);
     		nameItem=nameItem2+(""+inc);
     		idBrand=idBrand2+(""+inc);
        	nameManufacturer=nameManufacturer2+(""+inc);
     		idAu=idAu2+(""+inc);
     		batchNoVar=batchNoVar2+(""+inc);
     		expDateVar=expDateVar2+(""+inc);
     		qtyVar=qtyVar2+(""+inc);
     		unitRateVar=unitRateVar2+(""+inc);
     	
     		batchNoVarTemp=batchNoVarTemp2+(""+inc);
     		expDateVarTemp=expDateVarTemp2+(""+inc);
     		qtyVarTemp=qtyVarTemp2+(""+inc);
     		unitRateVarTemp=unitRateVarTemp2+(""+inc);
     		incVar=incVar2+(""+inc);
    	  %>
		<tr>

			<td width="5%"><input type="text" size="2" value="<%=temp+inc%>"
				class="smcaption" name="<%=SR_NO%>" readonly="readonly" /></td>
			<td width="10%"><input type="text" class="medcaption"
				name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem%>" /> <input
				type="hidden" size="2" value="0" class="smcaption"
				name="<%=ITEM_ID%>" id="<%=idItem%>" /></td>
			<td width="10%"><input type="text" value="" tabindex=1
				id="<%=nameItem%>" class="bigcaption" name="<%=NOMENCLATURE%>"
				onblur="fillItemsInStoreBalance(this.value,<%=inc%>);" /> <script>
		var obj = actb(document.getElementById('<%=nameItem%>'),nameArray);
	</script></td>
			<td width="10%"><input type="text" value="" class="smcaption"
				readonly="readonly" name="<%=AV%>" id="<%=idAu%>"
				validate="A/U ,String,no" /></td>
			<td width="10%"><select id="<%=idBrand%>" name="<%=BRAND_ID%>"
				onchange="fillManu(this.value,<%=inc%>);" tabindex=1>
				<option value="0">Select</option>
			</select> <script type="text/javascript">
		
		<%
			int m=0;
			for (MasStoreBrand masStoreBrand : brandList) 
			{
				if(masStoreBrand.getItem() != null){
								%>
									brandArray[<%=m%>] = new Array();
									brandArray[<%=m%>][0] = <%=masStoreBrand.getItem().getId()%>;
									brandArray[<%=m%>][1] = <%=masStoreBrand.getId()%>;									
									brandArray[<%=m%>][2] = "<%=masStoreBrand.getBrandName()%>";
									<%try{%>
										brandArray[<%=m%>][3] = "<%= %>";
									<%}catch(Exception exception){%>
										brandArray[<%=m%>][3] = "";
									<%}%>
								<%
								m++;
								}
				}
		%>
		</script></td>
			<td width="10%"><input type="text" value=" "
				id="<%=nameManufacturer%>" class="bigcaption" readonly="readonly"
				name="<%=MANUFACTURER%>" /></td>

			<td width="5%"><input type="text" value="" tabindex=1
				name="<%=BATCH%>" class="bigcaption" id="<%=batchNoVarTemp%>"
				onblur="fillValuesBalance(<%=inc%>);" validate="Batch No.,string,no"
				maxlength="10" /> <input type="hidden" size="2" value="emptyString"
				name="<%=BATCH_NO%>" id="<%=batchNoVar%>" /></td>
		</td>
		<td width="10%"><input type="text" name="<%=EXPIRY_YEAR %>"
			tabindex=1 value="" class="bigcaption" id="<%=expDateVarTemp%>"
			onblur="fillValuesBalance(<%=inc%>);"
			validate="Expriy Date.,string,no" maxlength="10" /> <input
			type="hidden" size="2" value="emptyString" name="<%=EXPIRY_DATE%>"
			id="<%=expDateVar%>" /></td>
		</td>

		<td width="10%"><input type="text" value="" class="medcaption"
			name="<%=QTY_BALANCE_TEMP%>" tabindex="1" id="<%=qtyVarTemp%>"
			validate="Qty,num,no" onblur="fillValuesBalance(<%=inc%>);" /> <input
			type="hidden" value="0" class="medcaption" name="<%=QTY_BALANCE%>"
			tabindex="2" id="<%=qtyVar%>" /></td>
		<td width="10%"><input type="text" value="" class="medcaption"
			name="<%=UNIT_RATE_BALANCE_TEMP%>" tabindex="1"
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

<span class="bodytextB_blue">Changed By:</span> <input type="text"
	name="<%=RequestConstants.CHANGED_BY%>" value="<%=userName%>"
	class="textbox_size20" readonly="readonly" MAXLENGTH="8" / tabindex=3 />

<span class="bodytextB_blue"> Changed Date:</span> <input type="text"
	name="<%=RequestConstants.CHANGED_DATE %>" value="<%=date%>"
	class="textbox_size20" readonly="readonly" tabindex=3 /> <span
	class="bodytextB_blue">Changed Time:</span> <input type="text"
	name="<%=RequestConstants.CHANGED_TIME %>" value="<%=time%>"
	class="textbox_size20" readonly="readonly" tabindex=3 /></form>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script> <input type="hidden" name="rows" id="rr" value="1" />

</form>

</div>
