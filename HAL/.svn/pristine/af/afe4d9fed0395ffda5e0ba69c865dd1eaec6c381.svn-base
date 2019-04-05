<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * itemType.jsp  
 * Purpose of the JSP -  This is for Item Type.
 * @author  Vivek
 * @author  Abha
 * Create Date: 13st Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.11
--%>


<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.MasItemType"%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	
	List<MasStoreGroup> itemGroupList = new ArrayList<MasStoreGroup>();
	if(map.get("itemGroupList") != null){
		itemGroupList = (List)map.get("itemGroupList");
	}

	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	ArrayList searchItemTypeList = (ArrayList)map.get("searchItemTypeList");
	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	  
	}
	 
%>
<%
if(map.get("message") != null){
	   String message = (String)map.get("message");
	    	   %>
	   <h4><span><%=message %></span></h4>
	   <% 
	  }

%>
<div class="titleBg">
<h2>Item Type Master</h2>
</div>
<div class="clear"></div>

<div id="searcharea">
<div id="searchbar">
    
<form name="search" method="post" action="">
<div class="Block">
<label>Item Type Code </label>
<input type="radio" class="radioAuto" name="<%=SELECTED_RADIO  %>"   value="1" checked="unchecked" tabindex=1/>
<label>Item Type Name</label>
<input type="radio" class="radioAuto" name="<%=SELECTED_RADIO %>" value="2" checked="checked" tabindex=1/>
<input	type="hidden" name="colCode" value="item_type_code"/>
<input	type="hidden" name="colName" value="item_type_name"/>
<input type="text"  id="searchField"  name="<%= SEARCH_FIELD%>" value=""  validate="Item Type Code,alphanumeric,no"   MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'pharmacy?method=searchItemType')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','pharmacy?method=searchItemType','checkSearch')" tabindex=1  />
		            <%--- Report Button   --%> 
<input type="button" name="Report" value="Generate Report Based on Search" class="buttonBig3" onClick="submitForm('search','hospital?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1/>
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_item_type">
</div>
</form>
<div class="clear"></div>
</div>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
 <div id="searchresults" tabindex=1 >
 <div id="searchtable" tabindex=1 ></div>
 
 <% 
 
  if(searchItemTypeList.size()>0)
   {
   String strForCode = (String)map.get("itemTypeCode");
   String strForCodeDescription = (String)map.get("itemTypeName");
   if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
   {
	   
 %> 
  
  
    <h4> <a  href="pharmacy?method=showItemTypeJsp">Show All Records</a></h4>
    
 <%
 
   }
   }
	if(searchItemTypeList.size()==0 && map.get("search") != null)
	  {
	 %>
		 <h4> <a  href="pharmacy?method=showItemTypeJsp">Show All Records</a></h4>

	 <%
}
	%>

 

 <script type="text/javascript">
 
 formFields = [
   [0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= CHANGED_BY %>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"itemGroupId"],[7,"<%=STATUS%>"]];
  statusTd = 7;
 </script>
 </div>
 
<form name="itemType" method="post" action="">
<input type="hidden" name="<%= POJO_NAME %>" value = "MasItemType">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="ItemTypeName">
<input type="hidden" name="<%=JSP_NAME %>" value = "itemType">
<input type="hidden" name="pojoPropertyCode" value = "ItemTypeCode">

<div class="clear"></div> 
<div class="clear"></div> 
<div class="Block">


<label>  Item Type Code <span>*</span></label>
<input id="codeId"type="text" name="<%= CODE%>" value="" validate="Item Type Code,alphanumeric,yes"  MAXLENGTH="8" tabindex=1 >
<label>  Item type Name <span>*</span></label>
   
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Item Type Name,alphanumeric,yes"  MAXLENGTH="30" tabindex=1 >
<script>
    document.itemType.<%=SEARCH_NAME%>.focus();
</script>


<label><span>*</span> Item Group </label>
<select name="itemGroupId"	id="itemGroupId" validate="Item Group,string,yes" tabindex=1>
	<option value="0">Select</option>
	<% 					
				for (MasStoreGroup  masStoreGroup : itemGroupList){
				%>
	<option value="<%=masStoreGroup.getId()%>"><%=masStoreGroup.getGroupName().trim()%></option>
	<%}%>
</select>
</div>
		
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('itemType','pharmacy?method=addItemType');" accesskey="a" tabindex=1/>
<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('itemType','pharmacy?method=editItemType')" accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('itemType','pharmacy?method=deleteItemType&flag='+this.value)" accesskey="d" tabindex=1/>  
<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By </label>   
<label class="value"><%=userName%></label>

<label>Changed Date </label>   
<label class="value"><%=date%></label>
			 
<label>Changed Time </label>   
<label class="value"><%=time%></label>
			 
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />		
</div>	
</form>    

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Item Type Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Item Type Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";


data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%=CHANGED_BY %>"

data_header[3] = new Array;
data_header[3][0] = "Admin"
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=CHANGED_DATE %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%=CHANGED_TIME %>"

	data_header[5] = new Array;
data_header[5][0] = "Item Group"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "itemGroup"

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>"

data_arr = new Array();
<%
Iterator itr=searchItemTypeList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {            
             MasItemType  masItemType = (MasItemType)itr.next();       

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masItemType.getId()%>
data_arr[<%= counter%>][1] = "<%=masItemType.getItemTypeCode()%>"
data_arr[<%= counter%>][2] = "<%= masItemType.getItemTypeName()%>"

data_arr[<%= counter%>][3] = "<%= masItemType.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masItemType.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masItemType.getLastChgTime() %>"



	<%
	if(masItemType.getGroup() != null){
	%>

	<%
	for(MasStoreGroup masStoreGroup :itemGroupList){
	     
		 if(masItemType.getGroup().getId().equals(masStoreGroup.getId()) && masStoreGroup.getStatus().equalsIgnoreCase("y")){%>
			data_arr[<%= counter%>][6] = "<%=masStoreGroup.getGroupName().trim()%>"
		<%}else if(masItemType.getGroup().getId().equals(masStoreGroup.getId()) && masStoreGroup.getStatus().equalsIgnoreCase("n")){%>
			data_arr[<%= counter%>][6] = "<font id='error'>*</font>Parent InActivated--<%=masStoreGroup.getGroupName().trim()%>";
			
		<%}
	}%>
	<%}%>




	<%
	if(masItemType.getStatus().equalsIgnoreCase("y")){
	%>
	data_arr[<%= counter%>][7] = "Active"
	<%}else{
	%>
	data_arr[<%= counter%>][7] = "InActive"
	<%}%>
	<%
	       counter++;
	}
	%>
 
formName = "itemType"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  
</script>