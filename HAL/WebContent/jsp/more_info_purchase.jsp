<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * more_info_iurchase.jsp  
 * Purpose of the JSP -  This is for Info of purchase.
 * @author  Deepti Tevatia
 * Create Date: 14th Jan,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.8
--%>

<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.MasManufacturer"%>

<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.StorePoDetail"%>
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
   function setVar(rowNo){
   		var freeQty="freeQty";
    	//var amount="amount";
    	var manufacturerId="manufacturerId";
    	var brandId="brandId";
    	var freeItem="freeItem";
    	
    	var freeQty2="freeQty";
    	//var amount2="amount";
    	var manufacturerId2="manufacturerId";
    	var brandId2="brandId";
    	var freeItem2="freeItem";
   
   			freeQty=freeQty2+(rowNo);     		
     		//amount=amount2+(rowNo);
     		manufacturerId=manufacturerId2+(rowNo);
     		brandId=brandId2+(rowNo);
     		freeItem=freeItem2+(rowNo);
   
   	   if(document.getElementById('f1').value != ""){
	   		window.opener.document.getElementById(freeQty).value = document.getElementById('f1').value;
	   }else{
	   		window.opener.document.getElementById(freeQty).value = 0;
	   }
	   
	   if(document.getElementById('f3').value != ""){
	   		window.opener.document.getElementById(manufacturerId).value = document.getElementById('f3').value;
	   }else{
	   		window.opener.document.getElementById(manufacturerId).value = 0;
	   }
	   
	   if(document.getElementById('f4').value != ""){
	   		window.opener.document.getElementById(brandId).value = document.getElementById('f4').value;
	   }else{
	   		window.opener.document.getElementById(brandId).value = 0;
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
   }
   function cancelForm(){
   	   close();
   }
</script>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
	List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
	List<StorePoDetail> poDetailMoreInfoList = new ArrayList<StorePoDetail>();
	int rowNo=0;
	
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if(map.get("manufacturerList")!=null){
		manufacturerList =(List) map.get("manufacturerList");
	}
	if(map.get("brandList")!=null){
		brandList =(List) map.get("brandList");
	}
	if(map.get("rowNo")!=null){
		rowNo =Integer.parseInt(""+map.get("rowNo"));
	}
	if (map.get("poDetailMoreInfoList") != null) {
		poDetailMoreInfoList = (List<StorePoDetail>)map.get("poDetailMoreInfoList");
	}
	System.out.println("manufacturerList---"+manufacturerList.size());
	System.out.println("brandList---"+brandList.size());
%>
<div id="contentspace">
<form name="windowForm" method="post" action=""><br />
<div style="padding-left: 15px;">

<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">SO Payment Terms</font></div>

<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />


<div
	style="overflow: scroll; overflow-x: hidden; width: 60%; height: 350px; BORDER: #202020 1px solid;">
<br />

<input type="hidden" name="aa" value="1" id="tblSample" /> <br>
<br>

<%
if(poDetailMoreInfoList.size() > 0){
	System.out.println("Inside IFF");
for(StorePoDetail storePoDetail : poDetailMoreInfoList){
%> <label class="bodytextB"><font id="error"></font>Free Qty</label> <%
	if(storePoDetail != null) {
%> <input type="text" name="<%=FREE_QTY %>"
	value="<%=storePoDetail.getFreeQuantity() %>" id="f1"
	class="textbox_size20" MAXLENGTH="8" validate="Free Qty,float,no" /> <%} %>
<br />
<br />

<label class="bodytextB"><font id="error"></font>Manufacturer
Name</label> <select name="<%= MANUFACTURER_ID %>" id="f3"
	validate="Manufacturer Name,String,no" tabindex=1>
	<option value="0">Select</option>
	<%
			for (MasManufacturer masManufacturer :manufacturerList) {
				if(storePoDetail.getManufacturer() != null){
				if(storePoDetail.getManufacturer().getId().equals(masManufacturer.getId())){
		%>
	<option value=<%=masManufacturer.getId()%> selected><%=masManufacturer.getManufacturerName()%></option>
	<%
				}}else{
		%>
	<option value=<%=masManufacturer.getId()%>><%=masManufacturer.getManufacturerName()%></option>
	<%	
				}	
			}
		%>
</select> <br />
<br />

<label class="bodytextB"><font id="error"></font>Brand Name</label> <select
	name="<%= BRAND_ID %>" id="f4" validate="Brand Name,String,no"
	tabindex=1>
	<option value="0">Select</option>
	<%
			for (MasStoreBrand masStoreBrand :brandList) {
				if(storePoDetail.getBrand() != null){
				if(storePoDetail.getBrand().getId().equals(masStoreBrand.getId())){
		%>
	<option value=<%=masStoreBrand.getId()%> selected><%=masStoreBrand.getBrandName()%></option>
	<%
				}}else{
		%>
	<option value=<%=masStoreBrand.getId()%>><%=masStoreBrand.getBrandName()%></option>
	<%
				}
			}
		%>
</select> <br />
<br />

<label class="bodytextB"><font id="error"></font>Free Item</label> <select
	name="<%= FREE_ITEM %>" id="f5" validate="Free Item,String,no"
	tabindex=1>
	<%
	if(storePoDetail != null) {
		if(storePoDetail.getFreeItem().equals("y")){
%>
	<option value="y" selected>Yes</option>
	<option value="n">No</option>
	<% }else{ %>
	<option value="y">Yes</option>
	<option value="n" selected>No</option>

	<%}
		
	}%>
</select> <br />
<br />
<%}
		}else{
			System.out.println("Inside Else");
			%> <label class="bodytextB"><font id="error"></font>Free Qty</label>
<input type="text" name="<%=FREE_QTY %>" value="" id="f1"
	class="textbox_size20" MAXLENGTH="8" validate="Free Qty,float,no" /> <br />
<br />

<label class="bodytextB"><font id="error"></font>Manufacturer
Name</label> <select name="<%= MANUFACTURER_ID %>" id="f3"
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

<label class="bodytextB"><font id="error"></font>Brand Name</label> <select
	name="<%= BRAND_ID %>" id="f4" validate="Brand Name,String,no"
	tabindex=1>
	<option value="0">Select</option>
	<%
			for (MasStoreBrand masStoreBrand :brandList) {
		%>
	<option value=<%=masStoreBrand.getId()%>><%=masStoreBrand.getBrandName()%></option>
	<%
			}
		%>
</select> <br />
<br />

<label class="bodytextB"><font id="error"></font>Free Item</label> <select
	name="<%= FREE_ITEM %>" id="f5" validate="Free Item,String,no"
	tabindex=1>
	<option value="0">Select</option>
	<option value="y">Yes</option>
	<option value="n">No</option>
</select> <br />
<br />

<%} %> <input type="button" name="add" id="addbutton" value="Submit"
	class="button" onClick="setVar(<%=rowNo%>);" accesskey="a" tabindex=1 />
<input type="button" name="reset" id="addbutton" value="Reset"
	class="button" onClick="resetForm();" accesskey="a" tabindex=1 /> <input
	type="button" name="cancel" id="addbutton" value="Cancel"
	class="button" onClick="cancelForm();" accesskey="a" tabindex=1 /> <input
	type="hidden" name="<%=STATUS %>" value="" /> <input type="hidden"
	name="" value="" />
</form>
</div>
</div>
</div>
