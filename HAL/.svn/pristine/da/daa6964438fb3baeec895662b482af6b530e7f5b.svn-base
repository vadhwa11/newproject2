<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * itemWiseSupplier.jsp  
 * Purpose of the JSP -  This is for Item Wise Supplier.
 * @author  Mansi
 * @author  Deepti
 * Create Date: 13th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.9
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasStoreItem"%>
<%@ page import="jkt.hms.masters.business.MasItemWiseSupplier"%>
<%@ page import="jkt.hms.masters.business.MasStoreSupplier"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<br />
<br />
<style>
#contentspace label {
	text-align: right;
	padding-right: 10px;
	width: 130px;
	float: left;
	height: 9px;
}
</style>
<div id="contentspace">
<%
  Map<String, Object> map = new HashMap<String, Object>();
  Map<String, Object> icdMap = new HashMap<String, Object>();
  Map<String,Object> utilMap = new HashMap<String,Object>();
  
  List<MasStoreSupplier> masItemWiseSupplierList = new ArrayList<MasStoreSupplier>();
  List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
  List<MasStoreItem> gridItemList = new ArrayList<MasStoreItem>();
  List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
  List<MasStoreSupplier> gridSupplierList = new ArrayList<MasStoreSupplier>();
  
  String userName = "";
  
  if(request.getAttribute("map") != null){
   map = (Map) request.getAttribute("map");
  }
  if(map.get("masItemWiseSupplierList") != null){
   masItemWiseSupplierList = (ArrayList)map.get("masItemWiseSupplierList");
  }
  if(map.get("masItemList") != null){
   itemList = (ArrayList)map.get("masItemList");
  }
  if(map.get("gridItemList") != null){
   gridItemList = (ArrayList)map.get("gridItemList");
  }
  if(map.get("masSupplierList") != null){
	  supplierList = (ArrayList)map.get("masSupplierList");
  }
  if(map.get("gridSupplierList") != null){
   gridSupplierList = (ArrayList)map.get("gridSupplierList");
  }
  String date ="";
  String time ="";
  try{
  utilMap = (Map)HMSUtil.getCurrentDateAndTime();
   date = (String)utilMap.get("currentDate");  
   time = (String)utilMap.get("currentTime");
  }catch(Exception ex){
   
   System.out.println("ex");
  }
  if(session.getAttribute("userName") != null){
   userName = (String)session.getAttribute("userName");
  }
  if(map.get("message") != null){
      String message = (String)map.get("message");
      out.println(message);
     }
%>

<div id="heading"><label class="headtext">Item Wise
Supplier</label></div>
<div id="searcharea">
<div class="search">

<form name="search" method="post" action=""><input type="radio"
	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" /> <font
	class="bodytextB_blue">Item Name:</font> <input type="radio"
	name="<%=SELECTED_RADIO %>" value="2" /> <font class="bodytextB_blue">Suppliers:</font>

<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""
	validate="Item Name,string,no" MAXLENGTH="8" tabindex=1 /> <input
	type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','pharmacy?method=searchItemWiseSupplier','checkSearch')"
	tabindex=1 /> <%--- Report Button   --%> <input type="button"
	name="Report" value="Generate Report Based on Search" class="button"
	onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');"
	accesskey="g" tabindex=1 /> <input type="hidden"
	name="<%=JASPER_FILE_NAME%>" value="Mas_item_wise_supplier"></form>
</div>
</div>

<br />
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<% 
  if(itemList.size()>0 && masItemWiseSupplierList.size() > 0)
   {
   String strForCode = (String)map.get("itemName");
   String strForCodeDescription = (String)map.get("supplier");
   if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
   {
 %> <br />
<a href="pharmacy?method=showItemWiseSupplier">Show All Records </a> <%
   }
   }
   
 %> <script type="text/javascript">

 formFields = [
     [0, "<%= COMMON_ID%>", "id"], [1,"<%= ITEM_ID%>"], [2,"<%= STORE_SUPPLIER_ID %>"], [3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE%>"], [5,"<%= CHANGED_TIME%>"], [6,"<%= STATUS%>"]];   
     
 statusTd = 6;
 </script></div>

<form name="itemWiseSupplier" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="MasStoreSupplier">
<input type="hidden" name="title" value="ItemWiseSupplier"> <input
	type="hidden" name="<%=JSP_NAME %>" value="itemWiseSupplier"> <br />
<br />

<div id=contentoperation><span class="bodytextB_blue"><font
	id="error">*</font>Item Name :</span> <select name="<%= ITEM_ID%>"
	validate="Item Name,string,yes" tabindex=1>
	<option value="">Select</option>
	<%     
    for (MasStoreItem  masStoreItem : itemList){
    %>
	<option value="<%=masStoreItem.getId ()%>"><%=masStoreItem.getNomenclature()%></option>
	<%}%>
</select> <script>
	    document.itemWiseSupplier.<%=ITEM_ID%>.focus();
	   </script> <span class="bodytextB_blue"><font id="error">*</font>Suppliers:</span>
<select name="<%=STORE_SUPPLIER_ID %>"
	validate="Supplier Name,string,yes" multiple="true" tabindex=1>
	<option value="">Select</option>
	<% 
				for (MasStoreSupplier  masStoreSupplier : supplierList){
				%>
	<option value="<%=masStoreSupplier.getId ()%>"><%=masStoreSupplier.getSupplierName()%></option>
	<%}%>
</select> <br />
<br />
<label class="bodytextB">Changed By:</label>
<div class="changebydt"><%=userName%></div>

<label class="bodytextB">Changed Date:</label>
<div class="changebydt"><%=date%></div>

<label class="bodytextB">Changed Time:</label>
<div class="changebydt"><%=time%></div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<br />
<br />
<div id="edited"></div>
<label>&nbsp;</label> <input type="button" name="add" id="addbutton"
	value="Add" class="button"
	onClick="submitForm('itemWiseSupplier','pharmacy?method=addItemWiseSupplier');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('itemWiseSupplier','pharmacy?method=editItemWiseSupplier')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('itemWiseSupplier','pharmacy?method=deleteItemWiseSupplier')"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />

<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" /> <br />
</form>
</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Item Name"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= ITEM_ID%>"

data_header[1] = new Array;
data_header[1][0] = "Suppliers"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= STORE_SUPPLIER_ID %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = "40%";
data_header[2][3] = "<%=CHANGED_BY %>";

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = "40%";
data_header[3][3] = "<%=CHANGED_DATE %>";

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%=CHANGED_TIME %>"

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>"

data_arr = new Array();

<%
	Iterator itr=masItemWiseSupplierList.iterator();
	          int  counter=0;
	          while(itr.hasNext())
	           {
	            
	             MasItemWiseSupplier  masItemWiseSupplier = (MasItemWiseSupplier)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masItemWiseSupplier.getId()%>

<%
	Iterator itrItemList=itemList.iterator();
	 while(itrItemList.hasNext())
           {
            MasStoreItem  masItemGrid = (MasStoreItem)itrItemList.next(); 
		 if(masItemWiseSupplier.getItem().getId().equals(masItemGrid.getId()) && masItemGrid.getStatus().equals("y")){%>
			data_arr[<%= counter%>][1] = "<%=masItemGrid.getNomenclature()%>"
		<%}else if(masItemWiseSupplier.getItem().getId().equals(masItemGrid.getId()) && masItemGrid.getStatus().equals("n")){%>
			data_arr[<%= counter%>][1] = "<font id='error'>*</font>Parent InActivated--<%=masItemGrid.getNomenclature()%>";
			
		<%}
}%>

<%
	Iterator itrSupplierList=supplierList.iterator();
	 while(itrSupplierList.hasNext())
           {
            MasStoreSupplier  masSupplierGrid = (MasStoreSupplier)itrItemList.next(); 
		 if(masItemWiseSupplier.getItem().getId().equals(masSupplierGrid.getId()) && masSupplierGrid.getStatus().equals("y")){%>
			data_arr[<%= counter%>][2] = "<%=masSupplierGrid.getSupplierName()%>"
		<%}else if(masItemWiseSupplier.getItem().getId().equals(masSupplierGrid.getId()) && masSupplierGrid.getStatus().equals("n")){%>
			data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=masSupplierGrid.getSupplierName()%>";
			
		<%}
}%>

data_arr[<%= counter%>][3] = "<%= masItemWiseSupplier.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masItemWiseSupplier.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masItemWiseSupplier.getLastChgTime() %>"

<% if(masItemWiseSupplier.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
       counter++;
}
%>
 
formName = "itemWiseSupplier"
start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  
</script>