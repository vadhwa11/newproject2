<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * airForceUnitDepot.jsp  
 * Purpose of the JSP -  This is for Air Force Unit Depot.
 * @author  Deepali
 * @author  Mansi
 * Create Date: 13th Feb,2008 
 * Revision Date:      
 * Revision By: Purpose
 * @version 1.1  
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot"%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	ArrayList searchAirForceDepotList = (ArrayList)map.get("searchAirForceUnitDepotList");
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
<h2>AirForce Unit Depot Master</h2>
</div>
<div id="searcharea">

<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">
<label>AF Unit Depot Name</label> 
<input type="text" id="searchField" name="<%=SEARCH_NAME%>" value="" validate="AF Unit Depot Name,alphanumeric,no" MAXLENGTH="8" onkeypress="return submitenter(this,event,'pharmacy?method=searchAirForceUnitDepot')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','pharmacy?method=searchAirForceUnitDepot','checkSearch')" tabindex=1 /> <%--- Report Button   --%>
<input type="button" name="Report" value="Generate Report Based on Search" class="buttonBig3"
	onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');"
	accesskey="g" tabindex=1 />
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_store_unit">
</div>
</form>
</div>
</div>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults">
<div id="searchtable"></div>

<% 
		if(searchAirForceDepotList.size()>0 && searchAirForceDepotList.size() > 0)
		 {
			 String strForCodeDescription = (String)map.get("airForceDepotName");
			if(strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> 
<h4><a href="pharmacy?method=showAirForceUnitDepotJsp">Show All Records</a></h4>
<%
			}
		 }
	if(searchAirForceDepotList.size()==0 && map.get("search") != null)
	  {
	 %> 
<h4><a href="pharmacy?method=showAirForceUnitDepotJsp">Show All Records</a></h4> 
<%
  }
%> <script type="text/javascript">
 
formFields = [
   [0, "<%= COMMON_ID%>", "id"], [1,"<%= SEARCH_NAME%>"], [2,"<%= AIR_FORCE_UNIT_DEPOT_TYPE %>"], [3,"<%= CHANGED_BY %>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
  statusTd = 6;
	</script></div>

<form name="airForceUnitDepot" method="post" action="">
<input type="hidden" name="<%= POJO_NAME %>" value="MasStoreAirForceDepot">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="AirForceDepotName"> <input type="hidden" name="title" value="AirForceUnitDepot"> 
<input type="hidden" name="<%=JSP_NAME %>" value="airForceUnitDepot">
	
<div class="clear"></div>
<div class="Block">
<label>AF Unit Depot Name <span>*</span> </label>
<input type="text" name="<%= SEARCH_NAME%>" value="" validate="AF Unit Depot Name,alphanumeric,yes" class="textbox_size20" MAXLENGTH="30" / tabindex=1> 
<label>Type <span>*</span> </label>
<select name="<%=AIR_FORCE_UNIT_DEPOT_TYPE%>" validate="Type,alphanumeric,yes" onkeypress="return submitenter(this,event,'pharmacy?method=addAirForceUnitDepot')">
<option value="0">Select</option>
<option value="d">Depot</option>
<option value="u">Unit</option>
</select> 
</div>



<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<label>&nbsp;</label> 
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('airForceUnitDepot','pharmacy?method=addAirForceUnitDepot');" accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('airForceUnitDepot','pharmacy?method=editAirForceUnitDepot')" accesskey="u" tabindex=1 /> 
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('airForceUnitDepot','pharmacy?method=deleteAirForceUnitDepot&flag='+this.value)" accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset" id="reset" value="Reset" class="button" onclick="resetCheck();" accesskey="r" />

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
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
</form>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "AF Unit Depot Name"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= SEARCH_NAME%>"

data_header[1] = new Array;
data_header[1][0] = "Type"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= AIR_FORCE_UNIT_DEPOT_TYPE %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%=CHANGED_BY %>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=CHANGED_DATE %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%=CHANGED_TIME %>"

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>"

data_arr = new Array();
<%
Iterator itr=searchAirForceDepotList.iterator();
int  counter=0;
while(itr.hasNext())
 {            
   MasStoreAirForceDepot  masStoreAirForceDepot = (MasStoreAirForceDepot)itr.next();
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masStoreAirForceDepot.getId()%>
data_arr[<%= counter%>][1] = "<%=masStoreAirForceDepot.getAirForceDepotName()%>"

<%
if(masStoreAirForceDepot.getAirForceDepotType().equals("d")){
%>
data_arr[<%= counter%>][2] = "Depot"
<%
}else{
%>
data_arr[<%= counter%>][2] = "Unit"
<%}%>


data_arr[<%= counter%>][3] = "<%= masStoreAirForceDepot.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= masStoreAirForceDepot.getLastChgDate()!=null?HMSUtil.convertDateToStringWithoutTime(masStoreAirForceDepot.getLastChgDate()):"" %>"
data_arr[<%= counter%>][5] = "<%= masStoreAirForceDepot.getLastChgTime() %>"
<% if(masStoreAirForceDepot.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
       counter++;
}
%>
formName = "airForceUnitDepot"
nonEditable = ['<%= SEARCH_NAME%>'];
start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  
</script>