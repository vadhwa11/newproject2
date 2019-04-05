<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * amcRepair.jsp  
 * Purpose of the JSP -  This is for maintain the AMC Maintenance
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
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreRepairCivilFirm"%>
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
          	     submitForm('amcRepair','neStores?method=addAmcRepair');
    	    }
            else{
                 alert(" Repair Date should be greator than Current Date");
                 document.amcRepair.repairdate.focus();
            }
     }

</script>

<%
	Map<String,Object> map = new HashMap<String,Object>();	
    Map<String, Object> utilMap = new HashMap<String, Object>();
    String repairNo="";
    List<String> repairNoList= new ArrayList<String>();
    List<StoreRepairCivilFirm> storerepairList = new ArrayList<StoreRepairCivilFirm>();
    if (request.getAttribute("map") != null) 
    map = (Map) request.getAttribute("map");
    List<MasStoreItem> nomenclatureList= new ArrayList<MasStoreItem>();
	if(map.get("nomenclatureList")!=null)
	nomenclatureList = (List) map.get("nomenclatureList");
	if(map.get("repairNoList")!=null){
		repairNoList = (List)map.get("repairNoList");
		if(repairNoList!=null){
  	  	 if (repairNoList.size()>0 && !repairNoList.isEmpty()){
  	  		repairNo=(String)repairNoList.get(0);
  	   	  }
	}
    System.out.println("repairNo   in  jsp"+repairNo);
	}
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	if(map.get("storerepairList")!=null){
		storerepairList = (List)map.get("storerepairList");
	}
%>




<h2 align="left" class="style1">Equipment Repair Entry by Civil
Firm /AMC Repair</h2>
<div class="clear"></div>
<div id="contentspace">
<form name="amcrepairsearch" method="post" action="">
<div class="clear"></div>
<div>
<table class="tborder" width="100%" align="center">
	<tr>
		<td width="20%" nowrap="nowrap" class="vbmenu_control"
			id="threadsearch"><a href="">Search</a> <script
			type="text/javascript"> vbmenu_register("threadsearch"); </script></td>
		<td width="80%"><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>
  <div class="clear"></div>

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
					type="button" name="Delete" type="submit" value="Delete"
					class="toolbutton"></td>
				<td width="4%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="print" type="submit" class="toolbutton"
					value="Print"
					onClick="submitForm('createGrn','stores?method=showGrnReportJsp');">
				</td>
				<td width="39%"><IMG SRC="/hms/jsp/images/closeButton.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
			</tr>
		</table>
		<div class="clear"></div>
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
			name="searchthreadid" value="85875" /> <label class="bodytextB1">Repair
		No :</label> <select name="repairNo" class="bigselect">
			<option value="">Select</option>
			<%
			  	for (StoreRepairCivilFirm storeRepairCivilFirm:storerepairList ){
			  	
		  	 %>
			<option value="<%=storeRepairCivilFirm.getRepairNo()%>"><%=storeRepairCivilFirm.getRepairNo()%></option>
			<% } %>
		</select> <label class="bodytextB1">Nomenclature :</label> <select
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


<form name="amcRepair" method="post"><input type="hidden"
	name="repairid" value="" class="textbox_size20" readonly /> <label
	class="bodytextB1">Repair No :</label> <input type="text"
	name="repairno" maxlength=10 value="<%=repairNo%>"
	class="textbox_size20" readonly /> 
<label class="bodytextB1">Repair Date :</label>
 <input type="text"
	name="repairdate" class="textbox_size20" value="" readonly /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.amcRepair.repairdate,event)" />

<div class="clear"></div>
<label class="bodytextB1">BLR/BER Certificate From Dependent EME</label>
 <input type="text" name="CERTIFICATE_FROM_DEPENDENT_EME"
	class="textbox_size20" value="" /> 
<div id="testDiv"><label class="bodytextB1">Nomenclature :</label>
<select name="<%= RequestConstants.NOMENCLATURE%>" class="bigselect"
	onchange="submitProtoAjaxDynamic('amcRepair','neStores?method=getPvmsNo',pvmsDiv);">
	<option value="">Select</option>
	<%
			  	for (MasStoreItem masStoreItem:nomenclatureList ){
			  	
		  	 %>
	<option value="<%=masStoreItem.getId()%>"><%=masStoreItem.getNomenclature()%></option>
	<% } %>
</select></div>

<div id="pvmsDiv"><label class="bodytextB1">PVMS/NIV :</label> <input
	type="text" name="<%=RequestConstants.PVMS_NO%>" class="textbox_size20"
	value="" readonly /> <br />
<label class="bodytextB1">Serial No:</label> <select
	name="<%= RequestConstants.SERIAL_NUMBER%>" id="serialNo">
	<option value="0">Select</option>
</select> 
<label class="bodytextB1">A/U No. :</label> <input type="text"
	name="<%=RequestConstants.AU%>" value="" class="textbox_size20"
	readonly /></div>
<label class="bodytextB1">BreakDown Of Repair Charges :</label> <input
	type="text" name=<%=RequestConstants.BREAKDOWN_REPAIR_CHARGES%>
	class="textbox_size20" value="" /> 

<label class="bodytextB1">Reasonableness of Cost:</label> <input
	type="text" name="<%=RequestConstants.REASONABLENESS_OF_COST%>"
	maxlength=9 value="" tabindex="500" class="textbox_size20"
	validate="Reasonableness of Cost ,num,no" /> 
<label class="bodytextB1">Quantity :</label> <input type="text"
	name="<%=RequestConstants.QUANTITY%>" value="" class="textbox_size20"
	validate="Quantity,int,no" /> <label class="bodytextB1">Number
Of Times Eqpt Went out :</label> <input type="text"
	name="<%=RequestConstants.NUMBER_OF_TIMES_EQPT_WENT_OUT%>" maxlength=9
	value="" class="textbox_size20"
	validate="Number Of Times Eqpt Went out,int,no" /> 
<div id="crvDiv"><label class="bodytextB1">CRV No :</label> 
<input	type="text" name="<%=RequestConstants.CRV%>" value=""
	class="textbox_size20" /></div>
<label class="bodytextB1">Cost Of Repair:</label> <input type="text"
	name="<%=RequestConstants.COST_OF_REPAIR%>" maxlength=9 value=""
	class="textbox_size20" validate="Cost Of Repair,num,no" /> 
<label class="bodytextB1">Source Of Reciept :</label> <input type="text"
	name="<%=RequestConstants.SOURCE_OF_RECIEPT%>" maxlength=100
	class="textbox_size20" value="" /> <label class="bodytextB1">AMC
Entered Last Time :</label> <input type="text"
	name="<%=RequestConstants.AMC_ENTERED_LAST_TIME%>" maxlength=9 value=""
	class="textbox_size20" /> 
<label class="bodytextB1">Quantity Held With Their Condition :</label>
 <select
	name=<%=RequestConstants.QUANTITY_HELD_WITH_CONDITION%> tabindex="500">
	<option value="" selected>Select</option>
	<option value="Ser">Servicable</option>
	<option value="Rep">Repairable</option>
</select>
<label class="bodytextB1">Quantity Required To Be Repaired :</label> <input
	type="text"
	name="<%=RequestConstants.QUANTITY_REQUIRED_TO_BE_REPAIRED%>"
	class="textbox_size20" value="" /> 
<label class="bodytextB1">Nature Of Repair indicating Spares, If
Any:</label> <input type="text" name="<%=RequestConstants.NATURE_OF_REPAIR%>"
	class="textbox_size20" value="" /> 
<label class="bodytextB1">Cost of Equipment :</label> <input type="text"
	name="<%=RequestConstants.COST%>" class="textbox_size20" value="" /> 
<label class="bodytextB1">Comparative Statement Of Quatations:</label> <input
	type="text"
	name="<%=RequestConstants.COMPARATIVE_STATEMENT_OF_QUATATIONS%>"
	class="textbox_size20" value="" /> 
<label class="bodytextB1">Reason for Recommending :</label> <input
	type="text" name="<%=RequestConstants.REASON_FOR_RECOMMENDING%>"
	class="textbox_size20" value="" /> <label class="bodytextB1">
Notes: Documents required for Equipement Repair
<div class="clear"></div>
1) BLR & Firm Quotation 
2) If Repair Cost is more than Rs 25,000 attach SOC 
IF AMC:1)Draft Quotation <br />
2) IF Repair Cost is more than 25,000 attach SOC 
3) Draft Item & Conditions for AMC </label> 
<div class="clear"></div>
<input type="button" class="morebutton" value="Submit!"
	onclick="submitform1();" /></form>
</div>

<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>