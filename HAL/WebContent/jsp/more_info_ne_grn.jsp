<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * grn1.jsp  
 * Purpose of the JSP -  This is for Info of purchase.
 * @author  Abha
 * Create Date: 29 March,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.8
--%>

<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.MasManufacturer"%>

<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.StoreGrnT"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<script>
errorMsg = "";
  
</script>

<script>
   function setVar(rowNo){

  		var freeQty="freeQty";
   		var manufacturerId="manufacturerId";
    	var freeItem="freeItem";
    	var installationDate="installationDate";
    	var amcStartDate="amcStartDate";
    	var amcEndDate="amcEndDate";
    	var warrantyDate="warrantyDate";
    	
    	var freeQty2="freeQty";
    	var manufacturerId2="manufacturerId";
    	var freeItem2="freeItem";
    	var installationDate2 ="installationDate";
    	var amcStartDate2="amcStartDate";
    	var amcEndDate2="amcEndDate";
    	var warrantyDate2="warrantyDate";
   
   
   			freeQty=freeQty2+(rowNo); 
   			manufacturerId=manufacturerId2+(rowNo);
     		freeItem=freeItem2+(rowNo);
     		installationDate= installationDate2+(rowNo);
     		amcStartDate= amcStartDate2+(rowNo);
     		amcEndDate = amcEndDate2+(rowNo);
     		warrantyDate = warrantyDate2+(rowNo);
     		
     		if(document.getElementById('f1').value != ""){
     	window.opener.document.getElementById(freeQty).value = document.getElementById('f1').value;
     	 }else{
	   		window.opener.document.getElementById(freeQty).value = 0;
	   }
	   
	   if(document.getElementById('f2').value != ""){
     	window.opener.document.getElementById(manufacturerId).value = document.getElementById('f2').value;
     	 }else{
	   		window.opener.document.getElementById(manufacturerId).value = 0;
	   }
	   
	     if(document.getElementById('f3').value != ""){
     	window.opener.document.getElementById(freeItem).value = document.getElementById('f3').value;
     	 }else{
	   		window.opener.document.getElementById(freeItem).value = 0;
	   }
	   
	     if(document.getElementById('f4').value != ""){
     	window.opener.document.getElementById(installationDate).value = document.getElementById('f4').value;
     	 }else{
	   		window.opener.document.getElementById(installationDate).value = 0;
	   }
	   
	     if(document.getElementById('f5').value != ""){
     	window.opener.document.getElementById(amcStartDate).value = document.getElementById('f5').value;
     	 }else{
	   		window.opener.document.getElementById(amcStartDate).value = 0;
	   }
	   
	     if(document.getElementById('f6').value != ""){
     	window.opener.document.getElementById(amcEndDate).value = document.getElementById('f6').value;
     	 }else{
	   		window.opener.document.getElementById(amcEndDate).value = 0;
	   }
	   
	     if(document.getElementById('f7').value != ""){
     	window.opener.document.getElementById(warrantyDate).value = document.getElementById('f7').value;
     	 }else{
	   		window.opener.document.getElementById(warrantyDate).value = 0;
	   }
	   
	   
     close();
   }
   
   function resetForm(){
	   document.getElementById('f1').value="";
	   document.getElementById('f2').value="";
	   document.getElementById('f3').value="";
	   document.getElementById('f4').value="";
	   document.getElementById('f5').value="";
	    document.getElementById('f6').value="";
	     document.getElementById('f7').value="";
	     
	   
   }
   function cancelForm(){
   	   close();
   }
</script>

<%
	StringBuffer orderDateOnly = new StringBuffer();
	GregorianCalendar gregorianCalendar1 = new GregorianCalendar();
	Map map = new HashMap();
	List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
	List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
	List<StoreGrnT> storeGrnTMoreInfoList  = new ArrayList<StoreGrnT>();
	int rowNo=0;
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
	
	

	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if(map.get("manufacturerList")!=null){
		manufacturerList =(List) map.get("manufacturerList");
		
	}
	
	if(map.get("rowNo")!=null){
		rowNo =Integer.parseInt(""+map.get("rowNo"));
	}
	if (map.get("storeGrnTMoreInfoList") != null) {
		storeGrnTMoreInfoList = (List<StoreGrnT>)map.get("storeGrnTMoreInfoList");
	}
%>
<style>
#contentspace label {
	text-align: right;
	padding-right: 0px;
	width: 100px;
	float: left;
	height: 9px;
}
</style>
<title>More Details</title>

<div id="contentspace">
<form name="windowForm" method="post" action=""><input
	type="hidden" name="aa" value="1" id="tblSample" /> <%
if(storeGrnTMoreInfoList.size() > 0){
for(StoreGrnT storeGrnT : storeGrnTMoreInfoList){
	%> <label class="bodytextB"><font id="error"></font>Free Qty</label> <%
		if(storeGrnT != null) {
	%> <input type="text" name="<%=FREE_QTY %>"
	value="<%=storeGrnT.getFreeQty() %>" id="f1" class="textbox_size20"
	MAXLENGTH="8" validate="Free Qty,float,no" /> <%} %> <label
	class="bodytextB"><font id="error"></font>Manufacturer Name</label> <select
	name="<%= MANUFACTURER_ID %>" id="f2"
	validate="Manufacturer Name,String,no" tabindex=1>
	<option value="0">Select</option>
	<%
				for (MasManufacturer masManufacturer :manufacturerList) {
					if(storeGrnT.getManufacturer() != null){
					if(storeGrnT.getManufacturer().getId().equals(masManufacturer.getId())){
			%>
	<option value=<%=masManufacturer.getId()%> selected><%=masManufacturer.getManufacturerName()%></option>
	<%
					}else{
			%>
	<option value=<%=masManufacturer.getId()%>><%=masManufacturer.getManufacturerName()%></option>
	<%	
					}
					}	
				}
			%>
</select> <br />
<br />


<label class="bodytextB"><font id="error"></font>Free Item</label> <%
		if(storeGrnT != null) {
			if(storeGrnT.getFreeItem().equals("n")){
	%> <input type="text" name="<%=FREE_ITEM%>" value="No" id="f3"
	class="textbox_size20" validate="Free Item,String,no" /> <%}else{ %> <input
	type="text" name="<%=FREE_ITEM%>" value="Yes" id="f3"
	class="textbox_size20" validate="Free Item,String,no" /> <%}}%> <label
	class="bodytextB"><font id="error"></font>installation Date</label> <%
		if(storeGrnT != null) {
	%> <input type="text" name="<%=INSTALLATION_DATE%>"
	value="<%=storeGrnT.getInstallationDate()%>" id="f4"
	class="textbox_size20" validate="Expiry Date,date,no" /> <%} %> <br />
<br />
<label class="bodytextB"><font id="error"></font>AMC Start Date</label>
<%
		if(storeGrnT != null) {
	%> <input type="text" name="<%=AMC_START_DATE%>"
	value="<%=storeGrnT.getAmcStartDate() %>" id="f5"
	class="textbox_size20" validate="Expiry Date,date,no" /> <%} %> <label
	class="bodytextB"><font id="error"></font>AMC End Date</label> <%
		if(storeGrnT != null) {
	%> <input type="text" name="<%=AMC_END_DATE%>"
	value="<%=storeGrnT.getAmcEndDate() %>" id="f6" class="textbox_size20"
	validate="Expiry Date,date,no" /> <%} %> <br />
<br />

<label class="bodytextB"><font id="error"></font>Warranty End
Date</label> <%
		if(storeGrnT != null) {
	%> <input type="text" name="<%=WARRANTY_DATE%>"
	value="<%=storeGrnT.getWarrantyDate() %>" id="f7"
	class="textbox_size20" validate="Expiry Date,date,no" /> <%} %> <%}
		}else{ %>

<div style="padding-left: 15px;">
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">More Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 500px; height: auto; background-color: #f4f9fe;">

<br />

<label class="bodytextB"><font id="error"></font>Free Qty</label> <input
	type="text" name="<%=FREE_QTY %>" value="" id="f1"
	class="textbox_size20" MAXLENGTH="8" validate="Free Qty,float,no" /> <label
	class="bodytextB"><font id="error"></font>Manufacturer Name</label> <select
	name="<%= MANUFACTURER_ID %>" id="f2"
	validate="Manufacturer Name,String,no" tabindex=1>
	<option value="0">Select</option>
	<%
				for (MasManufacturer masManufacturer :manufacturerList) {
			%>
	<option value=<%=masManufacturer.getId()%>><%=masManufacturer.getManufacturerName()%></option>
	<%	
				}
			%>
</select> <br />

<br />


<label class="bodytextB"><font id="error"></font>Free Item</label> <select
	name="<%=FREE_ITEM%>" value="" id="f3" class="textbox_size20"
	MAXLENGTH="1" validate="Free Item,String,no">
	<option value="0">Select</option>
	<option value="1">Yes</option>
	<option value="2">No</option>
</select> <label class="bodytextB"><font id="error"></font>Installation
Date</label> <input type="text" name="<%=INSTALLATION_DATE%>" id="f4" value=""
	class="textbox_date" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.windowForm.<%=INSTALLATION_DATE%>,event)" />
<br />
<br />

<label class="bodytextB"><font id="error"></font>AMC Start Date</label>
<input type="text" name="<%=AMC_START_DATE%>" id="f5" value=""
	class="textbox_date" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.windowForm.<%=AMC_START_DATE%>,event)" />


<label class="bodytextB"><font id="error"></font>AMC End Date</label> <input
	type="text" name="<%=AMC_END_DATE%>" id="f6" value=""
	class="textbox_date" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.windowForm.<%=AMC_END_DATE%>,event)" />

<br />
<br />
<label class="bodytextB"><font id="error"></font>Warranty End
Date</label> <input type="text" name="<%=WARRANTY_DATE%>" id="f7"
	value="<%=currentDate %>" class="textbox_date" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.windowForm.<%=WARRANTY_DATE%>,event)" />

<%} %> <br />
<br />
</div>
<br />
<br />

<input type="button" name="add" id="addbutton" value="Submit"
	class="button" onClick="checkDateForGrid();setVar(<%=rowNo%>);"
	accesskey="a" tabindex=1 /> <input type="button" name="reset"
	id="addbutton" value="Reset" class="button" onClick="resetForm();"
	accesskey="a" tabindex=1 /> <input type="button" name="cancel"
	id="addbutton" value="Cancel" class="button" onClick="cancelForm();"
	accesskey="a" tabindex=1 />
</form>
</div>
