<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * country.jsp  
 * Purpose of the JSP -  This is for Country Details.
 * @author  Dipali
 * @author  Mansi
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.15  
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">

<script language="javascript">

function jsAdd()
{
	var b1 = brand.<%=SEARCH_NAME%>.value;
	var m1 = brand.<%=MANUFACTURER_ID%>.value;
	var b2 = brand.<%=CODE%>.value;
	if (b1=="" || m1==0) 
	{
	alert("Brand or Manufacturer should not be blank");
	return;
	}
	submitForm('brand','personnel?method=addBrandPopup');
	opener.jsSetBrandData(b2,b1);
	self.close();
}

function jsUpdate()
{

  submitForm('brand','personnel?method=editBrandPopup&item_id='+document.getElementById('itemId').value);
}


function jsDelete()
{
  submitForm('brand','personnel?method=deleteBrandPopup');
}

function jsClose()
{
   //window.opener.location.href = "pharmacy?method=showItemJsp";
 //  if (window.opener.progressWindow)
	// {
    //	window.opener.progressWindow.close()
  	// } 
  window.close();

}
function  addManufacturerUsingBrandPopUp(){
    //var brandId = document.getElementsByName('<%=COMMON_ID%>').value;
    //alert(brandId);
	//window.location.href = "pharmacy?method=showManufacturerJsp&itemIdFromBrandPopup="+document.getElementById('itemIdForManufaturer').value;
	//window.location.href = '/hms/hms/pharmacy?method=showManufacturerJsp';
	var codeObj = document.getElementById('brandIdForManufacturer');
	codeObj.setAttribute("validate","Brand Code,string,no");

	var manufacturerObj = document.getElementById('manfacturerId');
	manufacturerObj.setAttribute("validate","Brand Code,string,no");
	
	//window.open();
	
	submitForm('brand','/hms/hms/pharmacy?method=showManufacturerJsp&itemIdFromBrandPopup='+document.getElementById('itemIdForManufaturer').value);
}

</script>

<%
	Map<String,Object> map = new HashMap<String,Object>();
    int manufacturerId = 0;
	Box box = HMSUtil.getBox(request);
    
	if(request.getAttribute("map") != null){
	 map = (Map<String,Object>)request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	List<MasStoreBrand> searchBrandList = null;
	if (map.get("searchBrandList")!=null)
	{
		searchBrandList = (List<MasStoreBrand>)map.get("searchBrandList");
		//System.out.println("========================inside jsp ============================");
		for (Iterator iterator = searchBrandList.iterator(); iterator.hasNext();) 
		{
			MasStoreBrand msb  = (MasStoreBrand) iterator.next();
			//System.out.println("brand lists nomenclature " + msb.getItem().getNomenclature());
		}
		//System.out.println("========================inside jsp ============================");
		
	}
	//List<MasStoreItemGeneric> genericList = new ArrayList<MasStoreItemGeneric>();
	List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
	List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
	Map<String, Object> detailMapForBrandPopup = new HashMap<String, Object>();
	
	Integer itemIdForManufaturer = 0;
	//genericList = (ArrayList)map.get("genericList");
	if(map.get("itemList") != null){
		itemList = (List<MasStoreItem>)map.get("itemList");
	}
	if(map.get("itemIdForManufaturer") != null){
		itemIdForManufaturer = (Integer)map.get("itemIdForManufaturer");
	}
	System.out.println("Item Id :"+itemIdForManufaturer);
	if(map.get("manufacturerList") != null){
		manufacturerList = (List<MasManufacturer>)map.get("manufacturerList");
	}
	if(map.get("detailMapForBrandPopup") != null ){
		System.out.println("in detail Map 1111111:::::");
		detailMapForBrandPopup = (Map)map.get("detailMapForBrandPopup");
	}
	if(detailMapForBrandPopup.get("manufacturerId") != null){
		manufacturerId =  (Integer)detailMapForBrandPopup.get("manufacturerId");
	}
	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	 if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
	 }
}
%>
<div id="searcharea">
<div id="searchbar">
<h2 align="center"><%=map.get("nomenclature")%></h2>
</div>
</div>
<div class="clear"></div>
<!-- 
   <div id="searcharea">
   
    <div id="searchbar">
    
     <form name="search" method="post" action="">
       
        <input type="radio" name="<%=SELECTED_RADIO  %>"   value="1" checked="checked" />
     <font >Brand Code:</font>
     <input type="radio" name="<%=SELECTED_RADIO %>" value="2"  />
     <font >Brand Name:</font>
      <input type="text" id="searchField"  name="<%= SEARCH_FIELD%>" value=""  validate="Brand Code,string,no"   MAXLENGTH="8" tabindex=1  />
                    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','personnel?method=searchBrand','checkSearch')" tabindex=1  />
                 <%--- Report Button   --%>  <input type="button" name="Report" value="Generate Report Based on Search" class="button" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1/>
					<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_brand">
       </form>

   </div>
  
 </div>
 --> 
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<% 
  if(searchBrandList.size()>0)
   {
   String strForCode = (String)map.get("brandCode");
   String strForCodeDescription = (String)map.get("brandName");
   if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
   {
 %> 
<a href="personnel?method=showBrandJsp">Show All Records</a> <%
   }
   }
 if(searchBrandList.size()==0 && map.get("search") != null)
 {
%> <a href="personnel?method=showBrandJsp">Show All Records</a> <%
 }
%> <script type="text/javascript">
 
 formFields = [
   [0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= MANUFACTURER_ID %>"],[4,"<%= NAME_ITEM %>"], [5,"<%= CHANGED_BY %>"],[6,"<%= CHANGED_DATE %>"],[7,"<%=CHANGED_TIME%>"],[8,"<%=ITEM_ID%>"],[9,"<%=STATUS%>"] ];
  statusTd = 9;
 </script>
 </div>

<form name="brand" method="post" action=""><input type="hidden"
	name="<%= POJO_NAME %>" value="MasStoreBrand"> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="BrandName">
<input type="hidden" name="brand" value="Brand"> <input
	type="hidden" name="<%=JSP_NAME %>" value="brand"> <input
	type="hidden" name="pojoPropertyCode" value="BrandCode"> <br>
<div class="clear"></div>
<div class="Block">

<label >
Brand Code: <span>*</span></label> 
<input type="hidden" name="<%=ITEM_ID%>" Id="itemId" /> 
<input type="hidden" name="<%=ITEM_ID_FOR_MANUFACTURER%>" Id="itemIdForManufaturer" value="<%=itemIdForManufaturer%>" /> 
<input id="codeId" type="text" name="<%= CODE%>" value="<%=map.get("brand_code") %>" validate="Brand Code,string,yes" class="textbox_size20" MAXLENGTH="8" tabindex=1 readonly="readonly" /> 
<label id=biglabel >
 Brand Name:<span>*</span></label> 
<input type="text" name="<%= SEARCH_NAME %>" id="brandIdForManufacturer" value="" validate="Brand Name,string,yes" class="textbox_size20" MAXLENGTH="30"  tabindex=1 /> 
<script>
    document.brand.<%=CODE%>.focus();
   </script> 
<label >Manufacturer Name<span>*</span> </label> 
<select name="<%=MANUFACTURER_ID %>" id="manfacturerId" validate="Manufacturer Name,string,yes" tabindex=1>
	<option value="0">Select</option>
	<%
          		if(manufacturerList != null){ 	
          			for (Iterator iter = manufacturerList.iterator(); iter.hasNext();) {
          				MasManufacturer masManufacturer = (MasManufacturer) iter.next();
          %>
	<option value="<%=masManufacturer.getId() %>"><%=masManufacturer.getManufacturerName() %></option>
	<%		
         			}
         		 } 
         %>
</select> 
<script type="text/javascript">
           <% System.out.println("manufature adde :"+manufacturerId); 
           if(manufacturerId != 0){ %>
           		document.getElementById('manfacturerId').value='<%=manufacturerId%>';
           <% } %>
           </script> 
           <input type="button" name="refreshManufacturer"
	id="refreshManufacturerButton" value="Add Manufacturer" class="buttonBig"
	onClick="addManufacturerUsingBrandPopUp();" accesskey="a" tabindex=1 />
<br>

<div style="display: none;">
<label >Nomenclature:
</label> <input type="text" value="<%=map.get("nomenclature")%>" id="nameItem"
	 name="<%=NAME_ITEM%>"  />
<div id="ac2update"	style="display: none;" class="complete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('<%=NAME_ITEM%>','ac2update','stores?method=getItemListForLoanoutByAutocomplete',{parameters:'requiredField=<%=NAME_ITEM%>'});
		</script>
		</div>
</div>

<div class="clear"></div>

<div id="edited"></div>
<div class="clear"></div>
 <input type="button" name="add" id="addbutton"	value="Add" class="button" onClick="jsAdd();" accesskey="a" tabindex=1 />

<input type="button" name="edit" id="editbutton" value="Update"	class="button" onClick="jsUpdate();" accesskey="u" tabindex=1 /> <input
	type="hidden" name="Delete" id="deletebutton" value="Activate"	class="button" onClick="jsDelete();" accesskey="d" tabindex=1 /> <input
	type="reset" name="Reset" id="reset" value="Reset" class="button"	onclick="location.reload();" accesskey="r" /> <input type="button"
	name="close" id="close" value="Close" class="button"	onclick="jsClose();" accesskey="r" /> <input type="hidden"
	name="<%=STATUS %>" value="" /> <input type="hidden"	name="<%= COMMON_ID%>" value="" />
	
	<div class="clear"></div>
<div class="division"></div>
<div class="bottom">
<label>Changed By:</label>
<label class="value"><%=userName%></label>

<label>Changed Date:</label>
<label class="value"><%=date%></label>

<label>Changed Time:</label>
<label class="value"><%=time%></label>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
	</div>
		<div class="clear"></div>
<div class="division"></div>
</form>


<script type="text/javascript"><!--
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Brand Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Brand Name"
data_header[1][1] = "data";
data_header[1][2] = "30%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Manufacturer Name"
data_header[2][1] = "data";
data_header[2][2] = "30%";
data_header[2][3] = "<%=MANUFACTURER_ID %>"

data_header[3] = new Array;
data_header[3][0] = "PVMS/NIV Nomenclature"
data_header[3][1] = "hide";
data_header[3][2] = "100%";
data_header[3][3] = "<%=NAME_ITEM %>"

data_header[4] = new Array;
data_header[4][0] = "Admin"
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%=CHANGED_BY %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = "15%";
data_header[5][3] = "<%=CHANGED_DATE %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%=CHANGED_TIME %>"

data_header[7] = new Array;
data_header[7][0] = "ItemId"
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%=ITEM_ID%>"

data_header[8] = new Array;
data_header[8][0] = "Status"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "<%=STATUS %>"

data_arr = new Array();
<%
Iterator itr=searchBrandList.iterator();
          int  counter = 0;
          while(itr.hasNext())
           {            
             MasStoreBrand  masStoreBrand = (MasStoreBrand)itr.next();       

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masStoreBrand.getId()%>
data_arr[<%= counter%>][1] = "<%=masStoreBrand.getBrandCode()%>"
data_arr[<%= counter%>][2] = "<%= masStoreBrand.getBrandName()%>"
<%
	Iterator itrManufacturerList=manufacturerList.iterator();
	try
	{
	 while(itrManufacturerList.hasNext())
           {
            MasManufacturer  masManufacturerGrid = (MasManufacturer)itrManufacturerList.next(); 
		 if(masStoreBrand.getManufacturer().getId().equals(masManufacturerGrid.getId()) && masManufacturerGrid.getStatus().equals("y")){%>
			data_arr[<%= counter%>][3] = "<%=masManufacturerGrid.getManufacturerName()%>"
		<%}else if(masStoreBrand.getItem().getId().equals(masManufacturerGrid.getId()) && masManufacturerGrid.getStatus().equals("n")){%>
			data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=masManufacturerGrid.getManufacturerName()%>";
		<%}
}}catch(NullPointerException e){ %>
	data_arr[<%= counter%>][3]="";
	<%
	e.printStackTrace();
}

%>

<%
		 try
		 { %>
			data_arr[<%= counter%>][4] = "<%=masStoreBrand.getItem().getNomenclature()+"["+masStoreBrand.getItem().getPvmsNo()+"]"%>"
	   <%}
          catch(NullPointerException e)
          {
           	   e.printStackTrace();
        	   %>
        	   data_arr[<%= counter%>][4] = "";
        	   <%
           }
        	    
%>
data_arr[<%= counter%>][5] = "<%= masStoreBrand.getLastChgBy() %>"
data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(masStoreBrand.getLastChgDate()) %>"
data_arr[<%= counter%>][7] = "<%= masStoreBrand.getLastChgTime() %>"
data_arr[<%= counter%>][8] = "<%= masStoreBrand.getItem().getId()%>"
<% if(masStoreBrand.getStatus().equals("y")){ %>
data_arr[<%= counter%>][9] = "Active"
<%}else{%>
data_arr[<%= counter%>][9] = "InActive"
<%}%>
<%
       counter++;
}
%>
 
formName = "brand"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  
--></script>