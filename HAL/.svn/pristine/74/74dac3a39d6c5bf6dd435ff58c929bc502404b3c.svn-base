<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * itemCategory.jsp  
 * Purpose of the JSP -  This is for Item Category.
 * @author  shailesh
 * @author  shailesh
 * Create Date: 13th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.8
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasItemType"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>


<% String message ="";
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchItemClassList = (ArrayList)map.get("searchItemClassList");
	
	 List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
	 if(map.get("sectionList") != null){
		 sectionList = (List)map.get("sectionList");
	 }
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		    message = (String)map.get("message");
		  
		  }	 	
	%>

<%@page import="jkt.hms.masters.business.MasItemClass"%><h4><%=message %></h4>
<div class="titleBg">
<h2>Item Class Master</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">

<label>Item Class Code</label> 
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radioCheckCol1" /> 
<label> Item Class Description</label> 
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioCheckCol1" /> 
<input	type="hidden" name="colCode" value="item_class_code"/>
<input	type="hidden" name="colName" value="item_class_name"/>
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Sub Section Code,alphanumeric,no" MAXLENGTH="8" tabindex=1	onkeypress="return submitenter(this,event,'pharmacy?method=searchItemCategory')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','pharmacy?method=searchItemClass','checkSearch')" tabindex=1  />
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','hospital?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_item_class"/>
</form>
</div>
</div>

<div class="clear"></div>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
			if(searchItemClassList.size()>0)
			 {
				String strForCode = (String)map.get("itemClassCode");
				String strForCodeDescription = (String)map.get("itemClassName");
				if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
				{
		%> 			
	  
	    <a href="pharmacy?method=showItemClassJsp">Show All Records</a>
		<%
				}
			 }
			 
		%>	 <script type="text/javascript">		
		formFields = [
				[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME%>"],[3,"<%=SECTION_ID%>"],  [4,"<%=CHANGED_BY%>"], [5,"<%=CHANGED_DATE%>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"] ];
		 statusTd = 7;

		</script></div>
<div class="clear">

</div>
 <form name="itemClass" method="post" action="">

	  <input type="hidden" name="<%= POJO_NAME %>" value = "MasItemClass"/>
	  <input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value = "ItemClassName"/>
	  <input type="hidden" name="<%=JSP_NAME %>" value = "itemClass"/>
	  <input type="hidden" name="pojoPropertyCode" value = "ItemClassCode"/>		
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block">


<label><span>*</span> Item Class Code</label>
<input id="codeId"	type="text" name="<%= CODE%>" value=""	validate="Item Sub Section Code,string,yes" MAXLENGTH="8" tabindex=1 />

<label><span>*</span> Item Class Description</label> 
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Item Sub Section Description,string,yes"		MAXLENGTH="30" tabindex=1 />

<label><span>*</span>Section</label> 
<select name="<%=SECTION_ID %>" validate="Section,string,yes" tabindex=1>
	<option value="0">Select</option>
	<%
	for(MasStoreSection masStoreSection : sectionList) {
	%>
	<option value="<%=masStoreSection.getId ()%>"><%=masStoreSection.getSectionName()%></option>
	<%
		}
	%>
</select>
<div class="clear"></div></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('itemClass','pharmacy?method=addItemClass');" accesskey="a" tabindex=1/>
<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('itemClass','pharmacy?method=editItemClass')" accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('itemClass','pharmacy?method=deleteItemClass&flag='+this.value)" accesskey="d" tabindex=1/>		
		
<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="checkReset();" accesskey="r" /> 
<input type="hidden"	name="<%=STATUS %>" value="" /> 
<input type="hidden"	name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=date%></label> <label>ChangedTime</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
</form>
<script type="text/javascript">
	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = "Item Class Code"
	data_header[0][1] = "data";
	data_header[0][2] = "25%";
	data_header[0][3] = "<%= CODE%>"
	
	data_header[1] = new Array;
	data_header[1][0] = "Item Class Description"
	data_header[1][1] = "data";
	data_header[1][2] = "40%";
	data_header[1][3] = "<%= SEARCH_NAME %>";
	
	data_header[2] = new Array;
	data_header[2][0] = "Section"
	data_header[2][1] = "data";
	data_header[2][2] = "40%";
	data_header[2][3] = "<%=SECTION_ID %>";
	
	data_header[3] = new Array;
	data_header[3][0] = ""
	data_header[3][1] = "hide";
	data_header[3][2] = 0;
	data_header[3][3] = "<%=CHANGED_BY %>"
	
	data_header[4] = new Array;
	data_header[4][0] = ""
	data_header[4][1] = "hide";
	data_header[4][2] = 0;
	data_header[4][3] = "<%=CHANGED_DATE %>"
	
	data_header[5] = new Array;
	data_header[5][0] = ""
	data_header[5][1] = "hide";
	data_header[5][2] = 0;
	data_header[5][3] = "<%=CHANGED_TIME %>";

	data_header[6] = new Array;
	data_header[6][0] = "Status"
	data_header[6][1] = "data";
	data_header[6][2] = 0;
	data_header[6][3] = "<%=STATUS %>";
	
	
	data_arr = new Array();
	
	<%	
	Iterator itr=searchItemClassList.iterator();
	          int  counter=0;
	          while(itr.hasNext())
	           {	            
	             MasItemClass  masItemClass = (MasItemClass)itr.next(); 
	%>	
	data_arr[<%= counter%>] = new Array();
	data_arr[<%= counter%>][0] = <%= masItemClass.getId()%>
	data_arr[<%= counter%>][1] = "<%=masItemClass.getItemClassCode()%>"
	data_arr[<%= counter%>][2] = "<%= masItemClass.getItemClassName()%>"
		<%
	
		  for(MasStoreSection masStoreSection:sectionList){
				if(masItemClass.getSection() != null){
					
			 if(masItemClass.getSection().getId().equals(masStoreSection.getId()) && masStoreSection.getStatus().equalsIgnoreCase("y")){%>
				data_arr[<%= counter%>][3] = "<%=masStoreSection.getSectionName().trim()%>"
			<%}else if(masItemClass.getSection().getId().equals(masStoreSection.getId()) && masStoreSection.getStatus().equalsIgnoreCase("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=masStoreSection.getSectionName().trim()%>";
				
			<%}
		}else{%>
			data_arr[<%= counter%>][3] = "-";
<%}}%>
		
	
	<%if(masItemClass.getLastChgBy() != null){%>
	data_arr[<%= counter%>][4] = "<%= masItemClass.getLastChgBy()!=null?(masItemClass.getLastChgBy().getId()!=null?masItemClass.getLastChgBy().getId():"0" ):"0"%>"
<%}else{%>
data_arr[<%= counter%>][4] = "-"
<%}%>
<%if(masItemClass.getLastChgDate() != null){%>
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masItemClass.getLastChgDate()) %>"
<%}%>
<%if(masItemClass.getLastChgTime() != null){%>
data_arr[<%= counter%>][6] = "<%= masItemClass.getLastChgTime() %>"
<%}%>
<% if(masItemClass.getStatus().equalsIgnoreCase("y") && masItemClass.getStatus()!= null){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
       counter++;
}
%>
formName = "itemClass"	
nonEditable = ['<%= CODE%>'];	
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>