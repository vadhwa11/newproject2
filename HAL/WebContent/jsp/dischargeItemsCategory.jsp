<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * dischargeItemsCategory.jsp  
 * Purpose of the JSP -  This is for Discharge Items Category Details.
 * @author  Deepali
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By: Purpose
 * @version 1.8  
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.DischargeItemsCategory"%>
<%@ page import="jkt.hms.masters.business.DischargeItems"%>


<%	
		Map<String,Object> map = new HashMap<String,Object>();
		if(request.getAttribute("map") != null){
			map = (Map<String,Object>) request.getAttribute("map");
		}		
		List<DischargeItems> dischargeItemsList = new ArrayList<DischargeItems>();
		List<DischargeItemsCategory> searchDischargeItemsCategoryList = new ArrayList();
		
		if(map.get("dischargeItemsList")!= null){
			dischargeItemsList = (List<DischargeItems>)map.get("dischargeItemsList");
		}
		System.out.println("list in cnt --- "+map.get("searchDischargeItemsCategoryList"));
		System.out.println("searchDischargeitemsCategoryList===="+map.get("searchDischargeItemsCategoryList"));
		if(map.get("searchDischargeItemsCategoryList")!= null){
			searchDischargeItemsCategoryList = (List<DischargeItemsCategory>)map.get("searchDischargeItemsCategoryList");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
		
		String date = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		if(map.get("message") != null){
			   String message = (String)map.get("message");
			   %>
			   <h4><span><%=message%></span></h4>
			 <% }%>

<div class="titleBg">
<h2>Discharge Items Category</h2>
</div>
<div class="Clear"></div>

<div id="searcharea">

<div id="searchbar">

<form name="search" method="post" action="">
<div class="Block">
<label>Category Name</label>
<input type="text"	id="searchField" name="<%=SEARCH_NAME%>" value=""	validate="Category Name,string,no" MAXLENGTH="8" />
<input	type="button" name="search" value="Search" class="button"	onclick="submitForm('search','inPatientMaster?method=searchDischargeItemsCategory','checkSearch')"	tabindex=1 />
</div>
</form>
</div>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
</div>
<% 
		if(searchDischargeItemsCategoryList.size()>0 )
		 {
			String strForCode = (String)map.get("dischargeItem");
			if(strForCode!= null && strForCode!= "")
			{
%>
<h4><a href="inPatientMaster?method=showDischargeItemCategoryJsp">Show All Records</a></h4>
	  <%
			}
		 }
		 
	%>
<script type="text/javascript">
	
	formFields = [
	[0, "<%= COMMON_ID%>", "id"],[1,"<%= DESCRIPTION%>"],  [2,"<%= DISCHARGE_ITEMS_CATEGORY %>"],[3,"<%= DISCHARGE_ITEMS_ID%>"],[4,"<%= ORDER_NO%>"],[5,"<%= LABEL_DATA_TYPE%>"],[6,"<%= CHANGED_BY%>"] ,[7,"<%= CHANGED_DATE%>"] ,[8,"<%= CHANGED_TIME%>"],[9,"<%=STATUS%>"] ];
		
	 statusTd = 9;
</script>
<div class="clear"></div>

<form name="dischargeItemsCategory" method="post" action="">
<input	type="hidden" name="<%= POJO_NAME %>" value="DischargeItemsCategory">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>"	value="CategoryName">
<input type="hidden" name="title"	value="DischargeItemsCategory">
<input type="hidden"	name="<%=JSP_NAME %>" value="dischargeItemsCategory">
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
<label>Label<span>*</span> </label> 
<input type="text" name="<%= DESCRIPTION%>" value="" validate="Category Name,string,yes" class="textbox_size20" MAXLENGTH="60"/  >
<script>
document.dischargeItemsCategory.<%=DESCRIPTION%>.focus();
</script> 
<label>Category Name</label>
<select name="<%=DISCHARGE_ITEMS_CATEGORY%>">
<option value="0">Select</option>
<option value="G">General</option>
<option value="O">Obe & Gynaecology</option>
<option value="P">Pesiatrics</option>
</select>
<label>Order No <span>*</span> </label> 
<input type="text" name="<%= ORDER_NO%>" value="" validate="Order No,string,yes" class="textbox_size20" MAXLENGTH="3"/  >
<div class="clear"></div>

<label> ItemCode <span>*</span> </label>
<select name="<%=DISCHARGE_ITEMS_ID %>" validate="Item Code,string,yes" tabindex=1>
<option value="">Select</option>
<%
          		if(dischargeItemsList != null){ 	
          			for (Iterator iter = dischargeItemsList.iterator(); iter.hasNext();) {
          				DischargeItems dischargeItems = (DischargeItems) iter.next();
%>
<option value="<%=dischargeItems.getId() %>"><%=dischargeItems.getItemDesc() %></option>
<%		
         			}
         		 } 
         %>
</select>


<label>Label Data Type</label>
<select name="<%=LABEL_DATA_TYPE%>">
<option value="0">Select</option>
<option value="TEXTAREA">TEXTAREA</option>
<option value="TEXTAREABIG">TEXTAREABIG</option>
<option value="DATE">DATE</option>
<option value="TEXT">TEXT</option>
</select>

 
</div>

<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton"	value="Add" class="button" onClick="submitForm('dischargeItemsCategory','inPatientMaster?method=addDischargeItemsCategory');" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" class="button"	onClick="submitForm('dischargeItemsCategory','inPatientMaster?method=editDischargeItemsCategory')" accesskey="u" tabindex=1 />
<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button" onClick="submitForm('dischargeItemsCategory','inPatientMaster?method=deleteDischargeItemsCategory&flag='+this.value)" accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset"	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" />
<input	type="hidden" name="<%= COMMON_ID%>" value="" />

<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName%></label>
<label>Changed Date</label>
<label class="value"><%=date%></label>
<label>Changed Time</label>
<label class="value"><%=time%></label>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
</form>
<div class="clear"></div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Label"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%=DESCRIPTION%>"

data_header[1] = new Array;
data_header[1][0] = "Item Category"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= DISCHARGE_ITEMS_CATEGORY %>";

data_header[2] = new Array;
data_header[2][0] = "Discharge Items "
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%=DISCHARGE_ITEMS_ID %>";

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= ORDER_NO %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= LABEL_DATA_TYPE %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_BY %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%=CHANGED_DATE %>";

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%=CHANGED_TIME %>";

data_header[8] = new Array;
data_header[8][0] = "Status"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "<%=STATUS %>";

data_arr = new Array();
<%
Iterator itr=searchDischargeItemsCategoryList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             DischargeItemsCategory  dischargeItemsCategory = (DischargeItemsCategory)itr.next(); 

%>

		data_arr[<%= counter%>] = new Array();
		data_arr[<%= counter%>][0] = <%= dischargeItemsCategory.getId()%>
		data_arr[<%= counter%>][1] = "<%=dischargeItemsCategory.getLabel()%>"
		data_arr[<%= counter%>][2] = "<%= dischargeItemsCategory.getCategoryName()%>"
		<%if(dischargeItemsList.size()>0){
			for(DischargeItems dischargeItems :dischargeItemsList){
		
			if(dischargeItemsCategory.getItemCode().getId().equals(dischargeItems.getId())){
		%>
		data_arr[<%= counter%>][3] = "<%= dischargeItems.getItemDesc() %>"
		<%}}}%>
		data_arr[<%= counter%>][4] = "<%= dischargeItemsCategory.getOrderno() %>"
		data_arr[<%= counter%>][5] = "<%= dischargeItemsCategory.getLabelDataType() %>"
		data_arr[<%= counter%>][6] = "<%= dischargeItemsCategory.getLastChgBy() %>"
		data_arr[<%= counter%>][7] = "<%=HMSUtil.convertDateToStringWithoutTime(dischargeItemsCategory.getLastChgDate()) %>"
		data_arr[<%= counter%>][8] = "<%= dischargeItemsCategory.getLastChgTime() %>"
		
		
		<% if(dischargeItemsCategory.getStatus().equals("y")){ %>
		data_arr[<%= counter%>][9] = "Active"
		<%}else{%>
		data_arr[<%= counter%>][9] = "InActive"
		<%}%>
		<%
		       counter++;
		}
		%>

formName = "dischargeItemsCategory"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
