<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * station.jsp  
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
<%@page import="jkt.hms.masters.business.MasStation"%>
<%@page import="jkt.hms.masters.business.MasCommand"%>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<MasCommand> commandList = new ArrayList<MasCommand>();
	commandList = (ArrayList)map.get("commandList");
	
	ArrayList searchStationList = (ArrayList)map.get("searchStationList");
	ArrayList gridCommandList = (ArrayList)map.get("gridCommandList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
%>
<%
if(map.get("message") != null){
		   String message = (String)map.get("message");
%>
<h4><%=message%></h4>
  <%
		  }
%>
<div class="titleBg">
<h2>Station Master</h2>
</div>
<div class="Clear"></div>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">
<label>Station Code</label>
<input type="radio" class="radioAuto"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" />
<label>Station Name</label>
<input type="radio" class="radioAuto"	name="<%=SELECTED_RADIO %>" value="2"checked="checked" />
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>"	value="" validate="Station Code,string,no" MAXLENGTH="8" tabindex=1	onkeypress="return submitenter(this,event,'personnel?method=searchStation')" />
<input type="button" name="search" value="Search" class="button"	onclick="submitForm('search','personnel?method=searchStation','checkSearch')"	tabindex=1 />
<%--- Report Button   --%>
<input type="button"	name="Report" value="Generate Report Based on Search" class="buttonBig3" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 />
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_station">
</div>
</form>
</div>
</div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
		if(searchStationList.size()>0 && commandList.size() > 0)
		 {
			String strForCode = (String)map.get("stationCode");
			String strForCodeDescription = (String)map.get("stationName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <h4><a href="personnel?method=showStationJsp">Show All Records</a></h4> <%
			}
		 }
	 if(searchStationList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="personnel?method=showStationJsp">Show All Records</a></h4>

<%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= COMMAND_ID %>"], [4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"] ];
	 statusTd = 7;
	</script>
	</div>
<div class="Clear paddingTop15"></div>
<form name="station" method="post" action="">
<input type="hidden" name="<%= POJO_NAME %>" value="MasStation">
<input	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="StationName">
<input type="hidden" name="title" value="Station">
<input	type="hidden" name="<%=JSP_NAME %>" value="station">
<input	type="hidden" name="pojoPropertyCode" value="StationCode">
<div class="Block">
<label> Station Code <span>*</span></label>
<input id="codeId" type="text"	name="<%= CODE%>" value="" validate="Station Code,string,yes" MAXLENGTH="8" tabindex=1 />
<label>Station Name <span>*</span></label>
<input type="text" name="<%= SEARCH_NAME %>" value=""	validate="Station Name,string,yes" MAXLENGTH="30" tabindex=1 />
<script>
document.station.<%=CODE%>.focus();
</script>

<label>Command <span>*</span></label>
<select name="<%= COMMAND_ID %>" validate="Command,string,yes" tabindex=1	onkeypress="return submitenter(this,event,'personnel?method=addStation')">
<option value="0">Select</option>
	<% 
				for (MasCommand  masCommand : commandList){
				%>
<option value="<%=masCommand.getId ()%>"><%=masCommand.getCommandName()%></option>
	<%}%>
</select>
	</div>
<div class="Clear"></div>

<div id="edited"></div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<input type="button" name="add" id="addbutton"	value="Add" class="button" onClick="submitForm('station','personnel?method=addStation');" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" class="button"	onClick="submitForm('station','personnel?method=editStation')" accesskey="u" tabindex=1 />
<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button" onClick="submitForm('station','personnel?method=deleteStation&flag='+this.value)" accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset"	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" />
<input	type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<div class="bottom">
<label>Changed By:</label>
<label class="value"><%=userName%></label>

<label class="bodytextB">Changed Date:</label>
<label class="value"><%=date%></label>

<label class="bodytextB">Changed Time:</label>
<label class="value"><%=time%></label>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />

</div>




</form>


<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Station Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Station Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Command "
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%=COMMAND_ID %>";

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_BY %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_DATE %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_TIME %>"

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchStationList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasStation  masStation = (MasStation)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masStation.getId()%>
data_arr[<%= counter%>][1] = "<%=masStation.getStationCode()%>"
data_arr[<%= counter%>][2] = "<%= masStation.getStationName()%>"

<%
		Iterator itrGridCommandList=gridCommandList.iterator();
		 while(itrGridCommandList.hasNext())
            {try{
             MasCommand  commandGrid = (MasCommand)itrGridCommandList.next(); 
			 if(masStation.getCommand().getId().equals(commandGrid.getId()) && commandGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][3] = "<%=commandGrid.getCommandName()%>"
			<%}else if(masStation.getId().equals(commandGrid.getId()) && commandGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=commandGrid.getCommandName()%>";
				
			<%}
            }catch(Exception e){}}%>
data_arr[<%= counter%>][4] = "<%= masStation.getLastChgBy() %>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masStation.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= masStation.getLastChgTime() %>"
<% if(masStation.getStatus().equals("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "station"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
