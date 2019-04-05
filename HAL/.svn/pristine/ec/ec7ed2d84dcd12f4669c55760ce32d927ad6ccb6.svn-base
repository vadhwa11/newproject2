<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * sample.jsp  
 * Purpose of the JSP -  This is for sampleCollection.jsp.
 * @author  Dipali
 * Create Date: 08th Jul,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.11
--%>


<%@ page import = "static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.DgMasCollection"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>

<div id="contentHolder">

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchCollectionList = (ArrayList)map.get("searchCollectionList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
%>

<%
if(map.get("message") != null){
	   String message = (String)map.get("message");
	    	   %> <h4><%=message %></h4> <% 
	  }

%>
<div class="Clear"></div>
<div class="titleBg"><h2>Sample Container Master</h2></div>
<div class="Clear"></div>

	  <div id="searcharea">	  
		  <div id="searchbar">		  
			  <form name="search" method="post" action="">	
			  		   
<div class="Block">
<label>Collection Code</label>
<input type="radio" name="<%=SELECTED_RADIO  %>" class="radio"  value="1" checked="checked" />
<label>Collection Name</label>
<input type="radio" name="<%=SELECTED_RADIO %>" class="radio" value="2"  />					
<input type="text" id="searchField"  name="<%= SEARCH_FIELD%>" value=""  validate="Collection Code,string,no"   MAXLENGTH="8" tabindex=1  onkeypress="return submitenter(this,event,'laboratory?method=searchSampleCollection')"/>
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','laboratory?method=searchSampleCollection','checkSearch')" tabindex=1  />
<div class="Clear"></div>
</form>
</div>
</div>
</div>
<div class="Clear"></div>
			 	 
	<jsp:include page="searchResultBlock.jsp" />
	
<div class="Clear"></div>	
	
	<div id="searchresults" tabindex=2 >
	<div id="searchtable" tabindex=2 ></div>
	
	<% 
		if(searchCollectionList.size()>0)
		 {
			String strForCode = (String)map.get("collectionCode");
			String strForCodeDescription = (String)map.get("collectionName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> 
	  
    <h2><a href="laboratory?method=showSampleCollectionJsp">Show All Records</a></h2>
	<%
			}
		 }
	 if(searchCollectionList.size()==0 && map.get("search") != null)
	  {
	 %>
				<h2><a href="laboratory?method=showSampleCollectionJsp">Show All Records</a></h2>

	 <%
     }
	%>


	<script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
	 statusTd = 6;
	</script>
	</div>
	<div class="Clear"></div>
  <form name="sampleCollectionMaster" method="post" action="">
  <input type="hidden" name="<%= POJO_NAME %>" value = "DgMasCollection">
  <input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="CollectionName">
  <input type="hidden" name="title" value = "SampleCollection">
  <input type="hidden" name="<%=JSP_NAME %>" value = "sampleCollectionMaster">
  <input type="hidden" name="pojoPropertyCode" value = "CollectionCode">	  		
	  		
 <div class="Block">
	  	<label >Collection Code <span>*</span> </label>
		<input type="text" name="<%= CODE%>" value="" validate="Collection Code,string,yes"  MAXLENGTH="8" tabindex=1 />
  		<label >Collection Name <span>*</span> </label>
			<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Collection Name,string,yes"  MAXLENGTH="30" tabindex=1 onkeypress="return submitenter(this,event,'laboratory?method=addSampleCollection')" />
			<script>
				document.sampleCollection.<%=CODE%>.focus();
			</script>
			</div>			
			<div class="Clear"></div>
			<div class="division"></div>		
			<div id="edited"></div>
			<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('sampleCollectionMaster','laboratory?method=addSampleCollection');" accesskey="a" tabindex=1/>
		
			<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('sampleCollectionMaster','laboratory?method=editSampleCollection')" accesskey="u" tabindex=1 />

			<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('sampleCollectionMaster','laboratory?method=deleteSampleCollection&flag='+this.value)" accesskey="d" tabindex=1/>		

			<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
			
			<input type="hidden" name="<%=STATUS %>" value="" />
			<input type="hidden" name="<%= COMMON_ID%>" value="" />
		<div class="Clear"></div>	
		<div class="division"></div>
			<div class="bottom">	
			<label >Changed By:</label>   
			<label class="value"><%=userName%></label>
			        
			<label >Changed Date:</label>   
			<label class="value"><%=date%></label>
			 
			<label >Changed Time:</label>   
			<label class="value"><%=time%></label>
			 
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />			
			
   </div>	
<div class="Clear"></div>	
</form>
</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Collection Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Collection Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";


data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%= CHANGED_BY %>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_DATE %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%= CHANGED_TIME %>";

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";

data_arr = new Array();

<%

Iterator itr=searchCollectionList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             DgMasCollection  dgMasCollection = (DgMasCollection)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= dgMasCollection.getId()%>
data_arr[<%= counter%>][1] = "<%=dgMasCollection.getCollectionCode()%>"
data_arr[<%= counter%>][2] = "<%= dgMasCollection.getCollectionName()%>"
data_arr[<%= counter%>][3] = "<%= dgMasCollection.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(dgMasCollection.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= dgMasCollection.getLastChgTime() %>"
<% if(dgMasCollection.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "sampleCollectionMaster"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	
	  