<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * grn1.jsp  
 * Purpose of the JSP -  This is for Info of purchase.
 * @author  Abha
 * Create Date: 14th Jan,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.8
--%>

<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.MasManufacturer"%>

<%@page import="jkt.hms.masters.business.MasStoreBrand"%>


<%@page import="jkt.hms.masters.business.StoreLoaninT"%>
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
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<script>
errorMsg = "";
  function checkExpiryDate(){
 var exp = document.getElementById('f3').value;
 
 expiryDate = new Date(exp.substring(6),(exp.substring(3,5) - 1) ,exp.substring(0,2));
  currentDate = new Date();
 var month = currentDate.getMonth() + 1
 var day = currentDate.getDate()
 var year = currentDate.getFullYear()
 var seperator = "/"
 currentDate = new Date(month + seperator + day + seperator + year);
 if(expiryDate < currentDate)
  {
  alert("Expiry Date Should be greater than current date")
  return false;
  }
  return true;
 
}
</script>
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
<script>
   function setVar(rowNo){

  		var freeQty="freeQty";
   		var manufacturingDate="manufacturingDate";
   		var expiryDate="expiryDate";
    	var manufacturerId="manufacturerId";
    	var freeItem="freeItem"; 

    	
    	var freeQty2="freeQty";
    	var manufacturingDate2="manufacturingDate";
    	var expiryDate2="expiryDate";
    	var manufacturerId2="manufacturerId";
    	var freeItem2="freeItem";
    	
   
   			freeQty=freeQty2+(rowNo); 
   			
   			manufacturingDate=manufacturingDate2+(rowNo);  
   			expiryDate=expiryDate2+(rowNo);  		
     		manufacturerId=manufacturerId2+(rowNo);
     		freeItem=freeItem2+(rowNo);
     	
     		
     		 if(document.getElementById('f1').value != ""){
     	window.opener.document.getElementById(freeQty).value = document.getElementById('f1').value;
     	 }else{
	   		window.opener.document.getElementById(freeQty).value = 0;
	   }
	   
     	if(document.getElementById('f2').value != ""){
	 	window.opener.document.getElementById(manufacturingDate).value = document.getElementById('f2').value;
	 	}else{
	 	window.opener.document.getElementById(manufacturingDate).value = 0;
	 	}
	 	
	 	if(document.getElementById('f3').value != ""){
	   window.opener.document.getElementById(expiryDate).value = document.getElementById('f3').value;
	    }else{
	   		window.opener.document.getElementById(expiryDate).value = 0;
	   }
	   
	     if(document.getElementById('f4').value != ""){
	   window.opener.document.getElementById(manufacturerId).value = document.getElementById('f4').value;
	    }else{
	   		window.opener.document.getElementById(manufacturerId).value = 0;
	   }
	   
	      if(document.getElementById('f5').value != ""){
	   window.opener.document.getElementById(freeItem).value = document.getElementById('f5').value;
	      }else{
	   		window.opener.document.getElementById(freeItem).value = 0;
	   }
	   
     close();
   }
   
   function resetForm(){
	   document.getElementById('f1').value="";
	   document.getElementById('f2').value="";
	   document.getElementById('f3').value="";
	   document.getElementById('f4').value="";
	   document.getElementById('f5').value="";
	  // document.getElementById('f6').value="";
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

List<StoreLoaninT> loanInMoreInfoList = new ArrayList<StoreLoaninT>();
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
	if (map.get("loanInMoreInfoList") != null) {
		loanInMoreInfoList =(List<StoreLoaninT>)map.get("loanInMoreInfoList");
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
	type="hidden" name="aa" value="1" id="tblSample" /> <br />

<%
	if(loanInMoreInfoList.size() > 0){
	for(StoreLoaninT storeLoaninT : loanInMoreInfoList){
		%> <label class="bodytextB"><font id="error"></font>Free Qty</label> <%
			if(storeLoaninT != null) {
		%> <input type="text" name="<%=FREE_QTY %>"
	value="<%=storeLoaninT.getFreeQty() %>" id="f1" class="textbox_size20"
	MAXLENGTH="8" validate="Free Qty,float,no" /> <%} %> <label
	class="bodytextB"><font id="error"></font>Date Of Manufac</label> <%
		if(storeLoaninT != null) {
	%> <input type="text" name="<%=MANUFACTURING_DATE%>"
	value="<%=storeLoaninT.getAmcEndDate() %>" id="f2"
	class="textbox_size20" MAXLENGTH="8"
	validate="Manufacturing Date,date,no" /> <%} %> <br />
<br />
<label class="bodytextB"><font id="error"></font>Expiry Date</label> <%
		if(storeLoaninT != null) {
	%> <input type="text" name="<%=EXPIRY_DATE%>"
	value="<%=storeLoaninT.getExpiryDate() %>" id="f3"
	class="textbox_size20" MAXLENGTH="8" validate="Expiry Date,date,no" />
<%} %> <label class="bodytextB"><font id="error"></font>Manufacturer
Name</label> <select name="<%= MANUFACTURER_ID %>" id="f4"
	validate="Manufacturer Name,String,no" tabindex=1>
	<option value="0">Select</option>
	<%
				for (MasManufacturer masManufacturer :manufacturerList) {
					if(storeLoaninT.getManufacturer() != null){
					if(storeLoaninT.getManufacturer().getId().equals(masManufacturer.getId())){
			%>
	<option value=<%=masManufacturer.getId()%> selected><%=masManufacturer.getManufacturerName()%></option>
	<%
					}else{
			%>
	<option value=<%=masManufacturer.getId()%>><%=masManufacturer.getManufacturerName()%></option>
	<%	
					}}	
				}
			%>
</select> <label class="bodytextB"><font id="error"></font>Free Item</label> <%
		if(storeLoaninT != null) {
	%> <input type="text" name="<%=FREE_ITEM%>"
	value="<%=storeLoaninT.getFreeItem() %>" id="f5" class="textbox_size20"
	MAXLENGTH="1" validate="Free Item,String,no" /> <%} %> <%}
			}else{ %> <br />

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
	class="bodytextB"><font id="error"></font>Date Of Mnufac</label> <input
	type="text" name="<%=MANUFACTURING_DATE%>" id="f2"
	value="<%=currentDate %>" class="textbox_date" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" id="calendar" width="16" height="16"
	border="0" validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.windowForm.<%=MANUFACTURING_DATE%>,event)" />
<br />

<label class="bodytextB"><font id="error"></font>Exp. Date</label> <input
	type="text" name="<%=EXPIRY_DATE%>" id="f3" value="<%=currentDate %>"
	class="textbox_date" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" id="calendar" width="16" height="16"
	border="0" validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.windowForm.<%=EXPIRY_DATE%>,event)" />



<label class="bodytextB"><font id="error"></font>Manufac. Name</label> <select
	name="<%= MANUFACTURER_ID %>" id="f4"
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

<label class="bodytextB"><font id="error"></font>Free Item</label> <select
	name="<%=FREE_ITEM%>" value="" id="f5" MAXLENGTH="1"
	validate="Free Item,String,no">
	<option value="0">Select</option>
	<option value="y">Yes</option>
	<option value="n">No</option>
</select> <%} %> <br />
<br />
</div>

<br />

<input type="button" name="add" id="addbutton" value="Submit"
	class="button" onClick="if( checkExpiryDate()){setVar(<%=rowNo%>);}"
	accesskey="a" tabindex=1 /> <input type="button" name="reset"
	id="addbutton" value="Reset" class="button" onClick="resetForm();"
	accesskey="a" tabindex=1 /> <input type="button" name="cancel"
	id="addbutton" value="Cancel" class="button" onClick="cancelForm();"
	accesskey="a" tabindex=1 /></div>

</form>
</div>
