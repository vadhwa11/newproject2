<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * pharmaIndex.jsp  
 * Purpose of the JSP -  This is for Pharmacy Index .
 * @author  Dipali
 * Create Date: 12th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.3
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.MasStorePharmaIndex"%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	ArrayList searchPharmaIndexList = (ArrayList)map.get("searchPharmaIndexList");
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
<h2>Pharma Index Master</h2>
</div>
<div class="clear"></div>




	  <div id="searcharea">
	  
		  <div id="searchbar">
		  
<form name="search" method="post" action="">
<div class="Block">			  
			    <label  class="auto">Pharma Index Name</label>
				<input type="text" id="searchField" name="<%=SEARCH_NAME%>" value=""  validate="Pharma Index Name,alphanumeric,no" MAXLENGTH="8"  onkeypress="return submitenter(this,event,'pharmacy?method=searchPharmaIndex')"/>
                    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','pharmacy?method=searchPharmaIndex','checkSearch')" tabindex=1  />
		            <%--- Report Button   --%>  <input type="button" name="Report" value="Generate Report Based on Search" class="buttonBig3" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/>
                    <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_store_pharma_index">
		     </div>
		     </form>
			  <div class="clear"></div>
			 </div>
		 </div>
	
	<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
	<div id="searchresults" >
	<div id="searchtable" ></div>
	
	<% 
		if(searchPharmaIndexList.size()>0 )
		 {
			String strForCode = (String)map.get("pharmaIndexName");
			if(strForCode!= null && strForCode!= "")
			{
	%> 
	
    <h4> <a  href="pharmacy?method=showPharmaIndexJsp">Show All Records</a></h4>
 <%
   }
   }
	if(searchPharmaIndexList.size()==0 && map.get("search") != null)
	  {
	 %>
			 <h4> <a  href="pharmacy?method=showPharmaIndexJsp">Show All Records</a></h4>

	 <%
}
	%>

 <script type="text/javascript">
 
 formFields = [
   [0, "<%= COMMON_ID%>", "id"], [1,"<%= SEARCH_NAME %>"], [2,"<%= CHANGED_BY %>"], [3,"<%= CHANGED_DATE %>"],[4,"<%= CHANGED_TIME %>"],[5,"<%=STATUS%>"] ];
  statusTd = 5;
 </script>
 </div>
 
  <form name="pharmaIndex" method="post" action="">
  <input type="hidden" name="<%= POJO_NAME %>" value = "MasStorePharmaIndex">
  <input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="PharmaIndexName">
  <input type="hidden" name="pharmaIndex" value = "PharmaIndex">
  <input type="hidden" name="<%=JSP_NAME %>" value = "pharmaIndex">
  <div class="clear"></div>
  <div class="clear"></div>
   <div class="Block">
    <label class="auto"> Pharma Index Name <span>*</span> </label>
   <input type="text" name="<%= SEARCH_NAME %>" value="" validate="Pharma Index Name,alphanumeric,yes"  MAXLENGTH="30"  tabindex=1  onkeypress="return submitenter(this,event,'pharmacy?method=addPharmaIndex')">
   
			</div>
<div class="clear"></div>
<div class="division"></div>
		<div id="edited"></div>
<div class="clear"></div>
   <input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('pharmaIndex','pharmacy?method=addPharmaIndex');" accesskey="a" tabindex=1/>
   <input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('pharmaIndex','pharmacy?method=editPharmaIndex')" accesskey="u" tabindex=1 />
   <input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('pharmaIndex','pharmacy?method=deletePharmaIndex&flag='+this.value)" accesskey="d" tabindex=1/>  
<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
   <input type="hidden" name="<%=STATUS %>" value="" />
   <input type="hidden" name="<%= COMMON_ID%>" value="" />
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
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />
  </div>
          
    
   
   </form>
   
 

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Pharma Index Name"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= SEARCH_NAME%>"

data_header[1] = new Array;
data_header[1][0] = ""
data_header[1][1] = "hide";
data_header[1][2] = 0;
data_header[1][3] = "<%=CHANGED_BY %>"

data_header[2] = new Array;
data_header[2][0] = "Admin"
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%=CHANGED_DATE %>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = "15%";
data_header[3][3] = "<%=CHANGED_TIME %>";

data_header[4] = new Array;
data_header[4][0] = "Status"
data_header[4][1] = "data";
data_header[4][2] = "15%";
data_header[4][3] = "<%=STATUS %>";

data_arr = new Array();
<%
Iterator itr=searchPharmaIndexList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {            
             MasStorePharmaIndex  masStorePharmaIndex = (MasStorePharmaIndex)itr.next();       

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masStorePharmaIndex.getId()%>
data_arr[<%= counter%>][1] = "<%= masStorePharmaIndex.getPharmaIndexName()%>"
data_arr[<%= counter%>][2] = "<%= masStorePharmaIndex.getLastChgBy() %>"
data_arr[<%= counter%>][3] = "<%= HMSUtil.convertDateToStringWithoutTime(masStorePharmaIndex.getLastChgDate()) %>"
data_arr[<%= counter%>][4] = "<%= masStorePharmaIndex.getLastChgTime() %>"
<% if(masStorePharmaIndex.getStatus().equals("y")){ %>
data_arr[<%= counter%>][5] = "Active"
<%}else{%>
data_arr[<%= counter%>][5] = "InActive"
<%}%>
<%
       counter++;
}
%>
formName = "pharmaIndex"

start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  
</script>