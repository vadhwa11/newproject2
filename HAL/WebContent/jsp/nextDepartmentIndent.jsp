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
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.StoreIndentT"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="java.util.Iterator"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
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
	
	List<StoreInternalIndentM> searchStoreInternalIndentMList = new ArrayList<StoreInternalIndentM>();
	List<MasDepartment> sectionList= new ArrayList<MasDepartment>();
	List<MasStoreItem> itemList= new ArrayList<MasStoreItem>();
	String maxDemandNo="";

	//--------Hearder Variables-------
	String demandNo="";
	int internalIndentId=0;
	String demandDate="";
	int sectionId=0;
	
	//--------End -------- Hearder Variables-------

	if (request.getAttribute("map") != null) 
		map = (Map) request.getAttribute("map");
	if(map.get("max")!=null)
		demandNo=""+map.get("max");
	if(map.get("internalIndentId")!=null)
		internalIndentId= Integer.parseInt(""+map.get("internalIndentId")) ;
	
	if(map.get("demandDate")!=null)
		demandDate =""+ map.get("demandDate");
	if(map.get("sectionId")!=null)
	sectionId=Integer.parseInt(""+map.get("sectionId")) ;
	
	
	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt(""+map.get("pageNo"));
	}
	List objectList=new ArrayList();
	if(map.get("objectList")!=null)
		objectList=(List) map.get("objectList");
	System.out.println("objectList"+objectList.size());
	
	if(map.get("max")!=null)
		maxDemandNo=(""+map.get("max"));
	
	if(map.get("sectionList")!=null)
	sectionList=(List) map.get("sectionList");


	if(map.get("searchStoreInternalIndentMList")!=null)
	searchStoreInternalIndentMList = (List) map.get("searchStoreInternalIndentMList");
	
	if(map.get("itemList")!=null)
		itemList=(List) map.get("itemList");

	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	if(map.get("departmentList") != null)
		departmentList = (ArrayList) map.get("departmentList");
	
	List<MasEmployee> approvedByEmployeeList = new ArrayList<MasEmployee>();
	if(map.get("approvedByList") != null)
		approvedByEmployeeList = (ArrayList) map.get("approvedByList");


	List<MasEmployee> requestByEmployeeList = new ArrayList<MasEmployee>();
	if(map.get("requestByList") != null)
		requestByEmployeeList = (ArrayList) map.get("requestByList");
	

%>
<script>
		var nameArray=new Array();
		var itemsArray1=new Array();
	</script>



<%int k=0;
  			try{
  			if(objectList.size()>0)
			for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
				System.out.println("1");
				BigDecimal qtyInStockFromObject=null;
				Integer qtyInMmfFromObject=null;
				Integer  itemDepartmentIdFromObject=0;
				Object[] object = (Object[]) iterator.next();
				
				Integer itemIdFromObject = (Integer)object[0];
				String  itemPvmsNoFromObject = (""+object[1]);
				String  itemNomenclatureFromObject = (""+object[2]) ;
				
				String  itemStrengthFromObject = (""+object[3]);
				if(object[4]!=null)
				 qtyInStockFromObject = (BigDecimal)object[4];
				if(object[5]!=null)
				 qtyInMmfFromObject = (Integer)object[5];
				if(object[6]!=null)
				itemDepartmentIdFromObject = Integer.parseInt(""+object[6]) ;
				String  itemAuFromObject = (""+object[7]) ;
				
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
				itemsArray1[<%=k%>][3]="<%=qtyInStockFromObject%>"
				itemsArray1[<%=k%>][4]="<%=qtyInMmfFromObject%>"
				itemsArray1[<%=k%>][5]="<%=itemDepartmentIdFromObject%>"
				itemsArray1[<%=k%>][6]="<%=itemAuFromObject%>"
				
         		</script>

<% k++;}
  			
  			}catch(Exception ee){
  				ee.printStackTrace();
  			}%>
<div id="contentspace">

<form name="departmentIndent" method="post"><br />

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
		<label class="bodytextB_blue">D No:</label> <select
			name="<%= SEARCH_DEMAND_NO%>">
			<option value="0">Select</option>
			<%
					for (StoreInternalIndentM storeInternalIndentM :searchStoreInternalIndentMList ) {
				%>

			<option value=<%=storeInternalIndentM.getDemandNo()%>><%=storeInternalIndentM.getDemandNo()%></option>

			<%
					}
				%>
		</select> <input type="button" class="smbutton" value="Go!"
			onClick="submitForm('departmentIndent','stores?method=searchDepartmentIndent');" />
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
	type="hidden" name="<%=DEPARTMENT_INDENT_ID %>"
	value="<%=internalIndentId%>" id="hdb" /> <br />
<input type="button" class="button" value="Next"
	onclick="if(checkForNext()){submitForm('departmentIndentGrid','stores?method=addNextOrSubmitDepartmentIndent&buttonName=next');}"
	align="right" /> <input type="button" name="sss" align="right"
	class="button" value="Submit"
	onclick="if(checkForSubmit()){submitForm('departmentIndentGrid','stores?method=addNextOrSubmitDepartmentIndent&buttonName=submit');}" />
Page No:<%=pageNo%> <br />
<fieldset style="width: 99%; padding-left: 9px;"><legend>Department
Indent details</legend>


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
			<td width="13%"><label valign="left" class="smalllabel">Stock
			in Hand</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Qty
			in MMF</label></td>
			<td width="6%"><label valign="left" class="smalllabel">Qty
			in Request</label></td>



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
    	String qtyInHandTemp="qtyInHandTemp";
    	String qtyInHand="qtyInHand";
    	String idAu="idAu";
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
    	    	
    	String stockInVar2="stockInVar";
    	String mmfVar2="mmfVar";
    	String demandVar2="demandVar";

    	String stockInVarTemp2="stockInVarTemp";
    	String mmfVarTemp2="mmfVarTemp";
    	String demandVarTemp2="demandVarTemp";
    	String incVar2="incVar2";
    	String departmentId2="departmentId";
    	
    	if(pageNo!=1)
    	{
    		temp=detailCounter*(pageNo-1);
    	}
     	 for(int inc=1;inc<=detailCounter;inc++){
     		 System.out.println("1111111111111");
     		idItem=idItem2+(""+inc);
     		codeItem=codeItem2+(""+inc);
     		nameItem=nameItem2+(""+inc);
     		qtyInHandTemp=qtyInHandTemp2+(""+inc);
     		qtyInHand=qtyInHand2+(""+inc);
     		idAu=idAu2+(""+inc);
     		stockInVar=stockInVar2+(""+inc);
     		mmfVar=mmfVar2+(""+inc);
     		demandVar=demandVar2+(""+inc);
     		departmentId=departmentId2+(""+inc);

     		stockInVarTemp=stockInVarTemp2+(""+inc);
     		mmfVarTemp=mmfVarTemp2+(""+inc);
     		demandVarTemp=demandVarTemp2+(""+inc);
     		incVar=incVar2+(""+inc);
    	  %>
		<tr>
			<td width="5%"><input type="text" size="2" value="<%=temp+inc%>"
				class="smcaption" name="<%=RequestConstants.SR_NO%>"
				readonly="readonly" /></td>

			<td width="10%"><input type="text" class="medcaption"
				name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem%>" /> <input
				type="hidden" value="0" name="<%=ITEM_ID%>" id="<%=idItem%>" /> <input
				type="hidden" value="0" name="<%=DEPARTMENT_ID_TEMP%>"
				id="<%=departmentId%>" /></td>
			<td width="10%"><input type="text" value="" tabindex=1
				id="<%=nameItem%>" class="bigcaption" name="<%=NOMENCLATURE%>"
				onblur="fillItemsInDepartmentIndent(this.value,<%=inc%>);" /></td>
			<script>
		var obj = actb(document.getElementById('<%=nameItem%>'),nameArray);
		</script>
			<td width="10%"><input type="text" value="" class="smcaption"
				readonly="readonly" name="<%=AV%>" id="<%=idAu%>" /></td>
			<td width="10%"><input type="text" readonly="readonly" value=""
				class="medcaption" readon name="" id="<%=qtyInHandTemp%>"
				validate="Qty In Stock,num,no" /> <input type="hidden" value="0"
				class="medcaption" name="<%=QTY_IN_HAND%>" id="<%=qtyInHand%>" /></td>

			<td width="10%"><input type="text" value="" class="medcaption"
				tabindex=1 name="<%=QTY_IN_MMF_TEMP%>" tabindex="2"
				id="<%=mmfVarTemp%>" validate="Qty In MMF,num,no"
				onblur="fillValues(<%=inc%>);" /> <input type="hidden" value="0"
				class="medcaption" name="<%=QTY_IN_MMF%>" tabindex="2"
				id="<%=mmfVar%>" /></td>
			<td width="10%"><input type="text" class="medcaption" value=""
				name="<%=QTY_DEMAND%>" tabindex="1" id="<%=demandVar%>"
				onblur="fillValuesForDemand(<%=inc%>);"
				validate="Qty In Demand,num,no" /> <input type="hidden"
				class="medcaption" value="0" name="<%=QTY_DEMAND_TEMP%>"
				tabindex="2" id="<%=demandVarTemp%>" /></td>
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
