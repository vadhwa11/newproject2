<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * itemConversion.jsp  
 * Purpose of the JSP -  This is for Item Conversion.
 * @author  Mansi
 * Create Date: 13th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.5
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreItemConversion"%>
<%@page import="jkt.hms.masters.business.MasStoreUnit"%>

<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	List<MasStoreItemConversion> searchItemConversionList = (ArrayList) map.get("searchItemConversionList");
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
		
	}
	
	List<MasStoreUnit> itemPurchaseUnitList = new ArrayList<MasStoreUnit>();
	itemPurchaseUnitList = (ArrayList)map.get("itemPurchaseUnitList");
	
	List<MasStoreUnit> itemIntermediateUnitList = new ArrayList<MasStoreUnit>();
	itemIntermediateUnitList = (ArrayList)map.get("itemIntermediateUnitList");
	
	List<MasStoreUnit> itemIssueUnitList = new ArrayList<MasStoreUnit>();
	itemIssueUnitList = (ArrayList)map.get("itemIssueUnitList");
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
<h2>Accounting Unit Conversion Master</h2>
</div>
<div class="clear"></div>

<div id="searcharea">

<div id="searchbar">

<form name="search" method="post" action="">
<div class="Block">
<label>A/U Name</label> 
<input type="hidden" class="radioAuto"	name="<%=SELECTED_RADIO  %>" value="2"  /> 
<input type="hidden" name="colCode" value="">	
<input type="hidden" name="colName" value="item_unit_name">				

<input type="text" id="searchField" name="<%=SEARCH_FIELD%>" value=""  validate="A/U Name,string,no" MAXLENGTH="20" onkeypress="return submitenter(this,event,'pharmacy?method=searchItemConversion')"/> 
<input type="button" name="search" value="Search" class="button"  onclick="submitForm('search','pharmacy?method=searchItemConversion','checkSearch')" tabindex=1  />
<%--- Report Button   --%>  <input type="button" name="Report" value="Generate Report Based on Search" class="buttonBig3" onClick="submitForm('search','hospital?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1/>
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_store_item_conversion">
</div>
</form>
<div class="clear"></div>
</div>
</div>

<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<%
	if (searchItemConversionList.size() > 0) {
		String strForCodeDescription = (String) map	.get("itemUnitName");
		if (strForCodeDescription != null && strForCodeDescription != "") {
%> <h4><a  href="pharmacy?method=showItemConversionJsp">Show All Records</a></h4> <%
 	}
 	}
 	
if(searchItemConversionList.size()==0 && map.get("search") != null)
{
%>
		 <h4> <a  href="pharmacy?method=showItemConversionJsp">Show All Records</a></h4>

<%
}
%>
 <script type="text/javascript">
 
 formFields = [

   [0, "<%= COMMON_ID%>", "id"], [1,"<%= SEARCH_NAME %>"], [2,"<%= PURCHASE_UNIT_ID %>"], [3,"<%= CONVERSION_FACTOR %>"], [4,"<%= INTERMEDIATE_UNIT_ID %>"], [5,"<%= CONVERSION_FACTOR2 %>"], [6,"<%= ISSUE_UNIT_ID %>"],  [7,"<%= CHANGED_BY %>"],[8,"<%= CHANGED_DATE %>"],[9,"<%= CHANGED_TIME %>"],[10,"<%= STATUS %>"],[11,"<%= FORMULA%>"]];
  statusTd = 10;
 </script></div>

<form name="itemConversion" method="post" action="">
<input type="hidden" name="<%= POJO_NAME %>" value="MasStoreItemConversion"> 
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="ItemUnitName">
<input type="hidden" name="title" value="itemConversion"> 
<input type="hidden" name="<%=JSP_NAME %>" value="itemConversion"> 
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
<label> A/U Name <span>*</span></label>
<input type="text" name="<%= SEARCH_NAME %>"  value="" validate="A/U Name,String,yes"  MAXLENGTH="30"/ tabindex=1 >
 <script>
    document.itemConversion.<%=SEARCH_NAME%>.focus();
   </script>
  <label>Purchase Unit <span>*</span> </label>
  
		 <select  name="<%=PURCHASE_UNIT_ID %>" validate="Purchase Unit,alphanumeric,yes" tabindex=1>
		  	<option  value="0">Select</option>
         <%
          		if(itemPurchaseUnitList != null){ 
          			for (Iterator iter = itemPurchaseUnitList.iterator(); iter.hasNext();) 
					{
          				MasStoreUnit masStoreUnit = (MasStoreUnit)iter.next();
          %>
			 <option value="<%=masStoreUnit.getId() %>"><%=masStoreUnit.getUnitName() %></option>     
         <%		
         			}
         		 } 
         %>
           </select>
    <label > Conv. Factor1 <span>*</span></label>
   <input type="text" name="<%= CONVERSION_FACTOR %>" value="" validate="Conversion Factor1,int,yes"  MAXLENGTH="30"/ tabindex=1 > 
       <div class="clear"></div>
       
   <label> Intermediate Unit <span>*</span></label>
		  <select name="<%=INTERMEDIATE_UNIT_ID %>" validate="Intermediate Unit,alphanumeric,yes" tabindex=1>
		  	<option value="0">Select</option>
         <%
          		if(itemIntermediateUnitList != null){ 
	        			for (Iterator iter = itemIntermediateUnitList.iterator(); iter.hasNext();) 
	        			{
							MasStoreUnit masStoreUnit1 = (MasStoreUnit)iter.next();
          %>
			<option  value="<%=masStoreUnit1.getId() %>"><%=masStoreUnit1.getUnitName() %></option>    
         <%		
         			}
         		 } 
         %>
         </select>
   <label>Conv. Factor 2 <span>*</span></label>
   <input type="text" name="<%= CONVERSION_FACTOR2 %>" value="" validate="Conversion Factor 2,int,yes"  MAXLENGTH="30"/ tabindex=1 >
   
   <label> Issue Unit <span>*</span></label>
		  <select name="<%=ISSUE_UNIT_ID %>" validate="Issue Unit,alphanumeric,yes" tabindex=1 onkeypress="return submitenter(this,event,'pharmacy?method=addItemConversion')">
		  	<option value="0">Select</option>
         <%
          		if(itemIssueUnitList != null){ 
          			for (Iterator iter = itemIssueUnitList.iterator(); iter.hasNext();) 
          			{         				
							MasStoreUnit masStoreUnit2 = (MasStoreUnit)iter.next();
          %>
			<option value="<%=masStoreUnit2.getId()%>"><%=masStoreUnit2.getUnitName() %></option>    
         <%		
         			}
         		 } 
         %>
         </select>
   
      <div class="clear"></div>
      <label> Formula <span>*</span></label>
	  <select name="<%=FORMULA %>" tabindex=1 validate="Formula,int,yes" onkeypress="return submitenter(this,event,'pharmacy?method=addItemConversion')">
	   <option value="0">Select</option>
      	<option value="1">Conversion</option>
      	<option value="2">No Conversion</option>
      	    
        </select>
         
  
   
			</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
		<div id="edited"></div>
<div class="clear"></div>
   <input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('itemConversion','pharmacy?method=addItemConversion');" accesskey="a" tabindex=1/>
   <input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('itemConversion','pharmacy?method=editItemConversion')" accesskey="u" tabindex=1 />
   <input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('itemConversion','pharmacy?method=deleteItemConversion&flag='+this.value)" accesskey="d" tabindex=1/>  
<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
   <input type="hidden" name="<%=STATUS %>" value="" />
   <input type="hidden" name="<%= COMMON_ID%>" value="" />
   <div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By:</label>   
			<label class="value"><%=userName%></label>
        
			<label>Changed Date:</label>   
			<label class="value"><%=date%></label>
			 
			<label>Changed Time:</label>   
			<label class="value"><%=time%></label>
			 
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />
          </div>
   
   
   </form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "A/U Name"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= SEARCH_NAME%>"

data_header[1] = new Array;
data_header[1][0] = "Purchase Unit"
data_header[1][1] = "data";
data_header[1][2] = "15%";
data_header[1][3] = "<%= PURCHASE_UNIT_ID %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%=CONVERSION_FACTOR %>"

data_header[3] = new Array;
data_header[3][0] = "Intermediate Unit"
data_header[3][1] = "data";
data_header[3][2] = 0;
data_header[3][3] = "<%=INTERMEDIATE_UNIT_ID %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%=CONVERSION_FACTOR2 %>"

data_header[5] = new Array;
data_header[5][0] = "Issue Unit"
data_header[5][1] = "data";
data_header[5][2] = 0;
data_header[5][3] = "<%=ISSUE_UNIT_ID %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%=CHANGED_BY %>"

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = 0;
data_header[7][3] = "<%=CHANGED_DATE %>"

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = 0;
data_header[8][3] = "<%=CHANGED_TIME %>"

data_header[9] = new Array;
data_header[9][0] = "Status"
data_header[9][1] = "data";
data_header[9][2] = "15%";
data_header[9][3] = "<%=STATUS %>"

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = "15%";
data_header[10][3] = "<%=FORMULA %>"

data_arr = new Array();
<%
Iterator itr=searchItemConversionList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {            
             MasStoreItemConversion  masStoreItemConversion = (MasStoreItemConversion)itr.next();       

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masStoreItemConversion.getId()%>
data_arr[<%= counter%>][1] = "<%=masStoreItemConversion.getItemUnitName()%>"
<% if(masStoreItemConversion.getPurchaseUnit() != null){%>
<%
		for(MasStoreUnit masStoreUnit : itemPurchaseUnitList)
		{
            if(masStoreItemConversion.getPurchaseUnit() != null){
			if(masStoreItemConversion.getPurchaseUnit().getId().equals(masStoreUnit.getId()) && masStoreUnit.getStatus().equals("y")){
			 %>
				data_arr[<%= counter%>][2] = "<%=masStoreUnit.getUnitName()%>"
			<%}else if(masStoreItemConversion.getPurchaseUnit().getId().equals(masStoreUnit.getId()) && masStoreUnit.getStatus().equals("n")){%>
				data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=masStoreUnit.getUnitName()%>";
				
			<%}
            }
		}
}%>
data_arr[<%= counter%>][3] = "<%=masStoreItemConversion.getConversionFactor1()%>"
<% if(masStoreItemConversion.getIntermediateUnit() != null){%>
<%
		for(MasStoreUnit masStoreUnit1 : itemIntermediateUnitList)
		{
            if(masStoreItemConversion.getIntermediateUnit() != null){
			if(masStoreItemConversion.getIntermediateUnit().getId().equals(masStoreUnit1.getId()) && masStoreUnit1.getStatus().equals("y")){
			 %>
				data_arr[<%= counter%>][4] = "<%=masStoreUnit1.getUnitName()%>"
			<%}else if(masStoreItemConversion.getIntermediateUnit().getId().equals(masStoreUnit1.getId()) && masStoreUnit1.getStatus().equals("n")){%>
				data_arr[<%= counter%>][4] = "<font id='error'>*</font>Parent InActivated--<%=masStoreUnit1.getUnitName()%>";
				
			<%}
            }
		}
}%>
<% if(masStoreItemConversion.getConversionFactor2() != null){%>
      data_arr[<%= counter%>][5] = "<%=masStoreItemConversion.getConversionFactor2()%>"
<%}else{%>
      data_arr[<%= counter%>][5] = ""
<% }if(masStoreItemConversion.getIssueUnit() != null){%>
<%
		for(MasStoreUnit masStoreUnit2 : itemIssueUnitList)
		{
            if(masStoreItemConversion.getIssueUnit() != null){
			if(masStoreItemConversion.getIssueUnit().getId().equals(masStoreUnit2.getId()) && masStoreUnit2.getStatus().equals("y")){
			 %>
				data_arr[<%= counter%>][6] = "<%=masStoreUnit2.getUnitName()%>"
			<%}else if(masStoreItemConversion.getIssueUnit().getId().equals(masStoreUnit2.getId()) && masStoreUnit2.getStatus().equals("n")){%>
				data_arr[<%= counter%>][6] = "<font id='error'>*</font>Parent InActivated--<%=masStoreUnit2.getUnitName()%>";
				
			<%}
            }
		}
}%>

data_arr[<%= counter%>][7] = "<%= masStoreItemConversion.getLastChgBy() %>"
data_arr[<%= counter%>][8] = "<%= HMSUtil.convertDateToStringWithoutTime(masStoreItemConversion.getLastChgDate()) %>"
data_arr[<%= counter%>][9] = "<%= masStoreItemConversion.getLastChgTime() %>"
<% if(masStoreItemConversion.getStatus().equals("y")){ %>
data_arr[<%= counter%>][10] = "Active"
<%}else{%>
data_arr[<%= counter%>][10] = "InActive"
<%}%>
data_arr[<%= counter%>][11] = "<%= masStoreItemConversion.getFormula() %>"
<%
       counter++;
}
%>
 formName = "itemConversion"

start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  
</script>