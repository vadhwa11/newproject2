<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * amcRepair.jsp  
 * Purpose of the JSP -  This is for maintain the AMC Repair Search
 * @author  Hitesh 
 * Create Date: 7th April,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.0
--%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreRepairCivilFirm"%>
<%@page import="java.math.BigDecimal"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<script>
<%

	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}
	String sDate=date+"/"+month1+"/"+year1;
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>
<script language="javascript">
function submitform1(){
         
         var currentDate=new Date(serverdate.substring(6),(serverdate.substring(3,5) - 1) ,serverdate.substring(0,2));
         obj1 = document.amcRepair.repairdate.value;
         dateOfRepair= new Date(obj1.substring(6),(obj1.substring(3,5) - 1) ,obj1.substring(0,2)); 
        
          if(dateOfRepair > currentDate){
          	     submitForm('amcRepair','neStores?method=updateStoreRepairCivilFirm');
    	    }
            else{
                 alert(" Repair Date should be greator than Current Date");
                 document.amcRepair.repairdate.focus();
            }
     }


function showReport(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/neStores?method=printAMCRepairJsp";
  obj.submit();
}

</script>
<%

String conditionofitem= "";
int id=0;
BigDecimal costofeqpt=  null;
String crvNO= "";
String lastcostrepair=""; 
String natureofRepair="";
String timeorder=  "";
int qty= 0;
int qtyrepair=0;
BigDecimal reasonablerepaircost= null;
String reasonrecommend= "";
String repairBreakdown="";
String comparativeQuatation="";
String sourceofreciept= "";
String Blrcertificate="";
String repairNO="";
Date repairDate=null;
Date repDate=null;
int itemid=0;
String lastamcCost="";
String dt="";
String converted_date="";

	Map<String,Object> map = new HashMap<String,Object>();	
    Map<String, Object> utilMap = new HashMap<String, Object>();
    String repairNo="";
    List<String> repairNoList= new ArrayList<String>();
    List<StoreRepairCivilFirm> storerepairList = new ArrayList<StoreRepairCivilFirm>();
    StoreRepairCivilFirm amcRepairDetails = new StoreRepairCivilFirm();
    if (request.getAttribute("map") != null) 
    map = (Map) request.getAttribute("map");
    List<MasStoreItem> nomenclatureList= new ArrayList<MasStoreItem>();
	if(map.get("nomenclatureList")!=null)
	nomenclatureList = (List) map.get("nomenclatureList");
	 System.out.println("nomenclatureList   in  jsp"+nomenclatureList.size());
	 if(map.get("storerepairList")!=null){
			storerepairList = (List)map.get("storerepairList");
		}
	if(map.get("amcRepairDetails")!=null){
		List amcRepairList = (List)map.get("amcRepairDetails");
		if(amcRepairList.size()>0){
			amcRepairDetails=(StoreRepairCivilFirm)amcRepairList.get(0);
		}
		if(amcRepairDetails!=null){
			id=amcRepairDetails.getId();
	 repairNO= amcRepairDetails.getRepairNo();
       dt =  amcRepairDetails.getRepairDate().toString();
     converted_date = dt.substring(8) + "/" +dt.substring(5, 7) + "/" + dt.substring(0, 4);
       comparativeQuatation=amcRepairDetails.getComparativeStatOfQuotation();
  	   conditionofitem=amcRepairDetails.getConditionOfItem();
       costofeqpt= amcRepairDetails.getCostOfEquipment();
       crvNO=amcRepairDetails.getCrvNo();
     lastcostrepair= amcRepairDetails.getLastCostOfRepair();
      natureofRepair=amcRepairDetails.getNatureOfRepair();
       timeorder= amcRepairDetails.getNoOfTimeOutorder();
     qty=amcRepairDetails.getQty();
     qtyrepair=amcRepairDetails.getQtyRepair();
      System.out.println("qtyrepair>>> in search  jsp"+qtyrepair);
       reasonablerepaircost= amcRepairDetails.getReasonableOfRepairCost();
       reasonrecommend=amcRepairDetails.getReasonForRecommend();
      repairBreakdown=amcRepairDetails.getRepairBreakdown();
      sourceofreciept=amcRepairDetails.getSourceOfReceipt();
      Blrcertificate=  amcRepairDetails.getBlrBerCertificate();
     MasStoreItem masStoreItem=amcRepairDetails.getItem();   	
	   itemid=masStoreItem.getId();
	lastamcCost=	amcRepairDetails.getLastCostOfRepair();
		}
   
	}
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	if(map.get("storerepairList")!=null){
		storerepairList = (List)map.get("storerepairList");
	}
%>




<h2 align="left" class="style1">Equipment Repair Entry by Civil
Firm /AMC Repair</h2>

<div id="contentspace">
<form name="amcrepairsearch" method="post" action="">

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
					type="button" id="addbutton" name="Add" type="submit" value="Add"
					class="toolbutton"
					onClick="submitForm('amcrepairsearch','neStores?method=amcRepairViewJsp');"></td>
				<td width="1%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="10%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Modify" type="submit" value="Modify"
					class="toolbutton"
					onClick="submitForm('createGrn','stores?method=grnModifyJsp');"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Reset" type="submit" value="Reset"
					class="toolbutton"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Delete" value="Delete" class="toolbutton">
				</td>
				<td width="4%" background="/hms/jsp/images/toolbuttBack.gif">
				<td width="4%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="print" type="submit" class="toolbutton"
					value="Print" onClick="showReport('amcRepair');"></td>


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
			name="searchthreadid" value="85875" /> <label class="bodytextB_blue">Repair
		No :</label> <select name="repairNo" class="bigselect">
			<option value="">Select</option>
			<%
			  	for (StoreRepairCivilFirm storeRepairCivilFirm:storerepairList ){
			  	
		  	 %>
			<option value="<%=storeRepairCivilFirm.getRepairNo()%>"><%=storeRepairCivilFirm.getRepairNo()%></option>
			<% } %>
		</select> <label class="bodytextB_blue">Nomenclature :</label> <select
			name="<%= RequestConstants.NOMENCLATURE%>" class="bigselect">
			<option value="">Select</option>
			<%
			  	for (MasStoreItem masStoreItem:nomenclatureList ){
			  	
		  	 %>
			<option value="<%=masStoreItem.getId()%>"><%=masStoreItem.getNomenclature()%></option>
			<% } %>
		</select> <input type="button" class="smbutton" value="Go!"
			onClick="submitForm('amcrepairsearch','neStores?method=searchAmcRepair');" />
		<br />
		</td>
	</tr>

</table>
</form>
</div>
</div>

</div>
<form name="amcRepair" method="post">
<body
	onload="submitProtoAjaxDynamic('amcRepair','neStores?method=getPvmsNo',pvmsDiv);">
<input type="hidden" name="repairid" value="<%=id %>"
	class="textbox_size20" readonly />
<label class="bodytextB">Repair No :</label>
<input type="text" name="repairno" maxlength=10 value="<%=repairNO%>"
	class="textbox_size20" tabindex="500" readonly />


<br />
<label class="bodytextB">Repair Date :</label>
<input type="text" name="repairdate" class="textbox_size20"
	value="<%=converted_date%>" readonly />

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.amcRepair.repairdate,event)" />


<label class="bodytextB">BLR/BER Certificate From Dependent EME
:</label>
<input type="text" name="CERTIFICATE_FROM_DEPENDENT_EME"
	class="textbox_size20" value="<%=Blrcertificate %>" tabindex="500" />
<br />
<div id="testDiv"><label class="bodytextB">Nomenclature :</label>
<select name="<%= RequestConstants.NOMENCLATURE%>" class="bigselect"
	tabindex="500"
	onchange="submitProtoAjaxDynamic('amcRepair','neStores?method=getPvmsNo',pvmsDiv);">
	<option value="">Select</option>
	<%
			  	for (MasStoreItem masStoreItem:nomenclatureList ){
			  	
		  	 %>
	<option value="<%=masStoreItem.getId()%>"><%=masStoreItem.getNomenclature()%></option>
	<% } %>
</select> <%
                    if (itemid != 0) {
                %> <script>
                	   	   document.amcRepair.<%=RequestConstants.NOMENCLATURE %>.value =<%=itemid%>
    			</script> <%
                 }
                 %>
</div>
<br />
<div id="pvmsDiv"><label class="bodytextB">PVMS/NIV :</label> <input
	type="text" name="<%=RequestConstants.PVMS_NO%>" class="textbox_size20"
	value="" readonly /> <br />
<label class="bodytextB">Serial No:</label> <select
	name="<%= RequestConstants.SERIAL_NUMBER%>" id="serialNo">
	<option value="0">Select</option>
</select> <br />
<label class="bodytextB">A/U No. :</label> <input type="text"
	name="<%=RequestConstants.AU%>" value="" class="textbox_size20"
	readonly /></div>

<label class="bodytextB">BreakDown Of Repair Charges :</label>
<input type="text" name=<%=RequestConstants.BREAKDOWN_REPAIR_CHARGES%>
	class="textbox_size20" tabindex="500" value="<%=repairBreakdown%>"
	validate="Repair Charges ,int,no" />



<br />

<label class="bodytextB">Reasonableness of Cost:</label>
<input type="text" name="<%=RequestConstants.REASONABLENESS_OF_COST%>"
	maxlength=9 value="<%=reasonablerepaircost%>" tabindex="500"
	class="textbox_size20" validate="Reasonableness of Cost ,num,no" />
<br />
<label class="bodytextB">Quantity :</label>
<input type="text" name="<%=RequestConstants.QUANTITY%>"
	value="<%=qty%>" maxlength=9 class="textbox_size20" tabindex="500"
	validate="Quantity,int,no" />

<label class="bodytextB">Number Of Times Eqpt Went out :</label>
<input type="text"
	name="<%=RequestConstants.NUMBER_OF_TIMES_EQPT_WENT_OUT%>" maxlength=9
	value="<%=timeorder%>" tabindex="500" class="textbox_size20"
	validate="Number Of Times Eqpt Went out,int,no" />


<br />
<div id="crvDiv"><label class="bodytextB">CRV No :</label> <input
	type="text" name="<%=RequestConstants.CRV%>" value="<%=crvNO%>"
	class="textbox_size20" tabindex="500" /></div>
<label class="bodytextB">Cost Of Repair:</label>
<input type="text" name="<%=RequestConstants.COST_OF_REPAIR%>"
	maxlength=9 value="<%=lastcostrepair%>" tabindex="500"
	class="textbox_size20" validate="Cost Of Repair,num,no" />
<br />
<label class="bodytextB">Source Of Reciept :</label>
<input type="text" name="<%=RequestConstants.SOURCE_OF_RECIEPT%>"
	class="textbox_size20" maxlength=100 value="<%=sourceofreciept%>"
	tabindex="500" validate="Source Of Reciept,string,no" />

<label class="bodytextB">AMC Entered Last Time :</label>
<input type="text" name="<%=RequestConstants.AMC_ENTERED_LAST_TIME%>"
	maxlength=9 value="<%=lastamcCost%>" class="textbox_size20"
	tabindex="500" validate="AMC Entered Last Time ,int,no" />
<br />
<label class="bodytextB">Quantity Held With Their Condition :</label>
<select name=<%=RequestConstants.QUANTITY_HELD_WITH_CONDITION%>
	tabindex="500">
	<option value="" selected>Select</option>
	<option value="Ser">Servicable</option>
	<option value="Rep">Repairable</option>
</select>
<%
                    if (conditionofitem != "") {
                %>
<script>
		    	   document.amcRepair.<%=RequestConstants.QUANTITY_HELD_WITH_CONDITION %>.value ='<%=conditionofitem%>'
    			</script>
<%
                 }
                 %>

<br />
<label class="bodytextB">Quantity Required To Be Repaired :</label>
<input type="text"
	name="<%=RequestConstants.QUANTITY_REQUIRED_TO_BE_REPAIRED%>"
	class="textbox_size20" value="<%=qtyrepair%>"
	validate="Quantity Required To Be Repaired,int,no" />
<br />
<label class="bodytextB">Nature Of Repair indicating Spares, If
Any:</label>
<input type="text" name="<%=RequestConstants.NATURE_OF_REPAIR%>"
	class="textbox_size20" value="<%=natureofRepair%>" />
<br />
<label class="bodytextB">Cost of Equipment :</label>
<input type="text" name="<%=RequestConstants.COST%>"
	class="textbox_size20" value="<%=costofeqpt%>"
	validate="Cost of Equipment,num,no" />
<br />
<label class="bodytextB">Comparative Statement Of Quatations:</label>
<input type="text"
	name="<%=RequestConstants.COMPARATIVE_STATEMENT_OF_QUATATIONS%>"
	class="textbox_size20" value="<%=comparativeQuatation%>"
	validate="Comparative Statement Of Quatations,string,no" />
<br />
<label class="bodytextB">Reason for Recommending :</label>
<input type="text" name="<%=RequestConstants.REASON_FOR_RECOMMENDING%>"
	class="textbox_size20" value="<%=reasonrecommend%>"
	validate="Reason for Recommending,string,no" />
<br />
<label class="bodytextB"> Notes: Documents required for
Equipement Repair <br />
1) BLR & Firm Quotation <br />
2) If Repair Cost is more than Rs 25,000 attach SOC <br />
IF AMC:1)Draft Quotation <br />
2) IF Repair Cost is more than 25,000 attach SOC <br />
3) Draft Item & Conditions for AMC </label>

</body>
<input type="button" class="morebutton" value="Submit!"
	onclick="submitform1();" /></form>
</div>

<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>