<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * userGroups.jsp  
 * Purpose of the JSP -  This is for All UserGroupss.
 * @author  Dipali
 * Create Date: 22 Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.5
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.UserGroups"%>

<%
Map map = new HashMap();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
ArrayList searchUserGroupsList = (ArrayList)map.get("searchUserGroupsList");
String userName = "";
if(session.getAttribute("userName") != null){
 userName = (String)session.getAttribute("userName");
}
%> <%
if(map.get("message") != null){
	   String message = (String)map.get("message");
	   %> <h4><%=message %></h4> <%
	  }
%> 
<div class="titleBg"><h2>User Group Master</h2></div>
<div class="Clear"></div>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">
<label>User Group Code</label> 
<input type="radio" class="radioAuto" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" /> 
	<label>User Group Name</label> 
	<input type="radio" name="<%=SELECTED_RADIO %>" class="radioAuto" value="2" /> 
	<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""  validate="User Group Code,string,no"
	MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'user?method=searchUserGroups')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','user?method=searchUserGroups','checkSearch')"
	tabindex=1 />
	</div>
	</form>
<div class="Clear"></div>
<div class="Clear"></div>
</div>
</div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
		if(searchUserGroupsList.size()>0)
		 {
			String strForCode = (String)map.get("userGroupsCode");
			String strForCodeDescription = (String)map.get("userGroupsName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%>
<div class="Clear"></div>
<h4><a href="user?method=showUserGroupsJsp">Show All Records</a></h4>
<%
			}
		 }
	 if(searchUserGroupsList.size()==0 && map.get("search") != null)
	  {
	 %>
<div class="Clear"></div>
<h4><a href="user?method=showUserGroupsJsp">Show All Records</a></h4>
<%
     }
	%> <script type="text/javascript">	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
	 statusTd = 6;
	</script></div>
	
<div class="Clear"></div>
<form name="userGroups" method="post" action="">
<input type="hidden" name="<%= POJO_NAME %>" value="UserGroups"> 
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="GroupName">
<input type="hidden" name="title" value="UserGroups"> 
<input type="hidden" name="<%=JSP_NAME %>" value="userGroups">
<input type="hidden" name="pojoPropertyCode" value="Code">

<div class="Block">
<label><span>*</span> User Group Code </label> 
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="User Group Code,string,yes" MAXLENGTH="8" / tabindex=1> 
	<label><span>*</span> User Group Name</label> 
	<input type="text" name="<%= SEARCH_NAME %>" value="" validate="User Group Name,string,yes" MAXLENGTH="30" / tabindex=1
	onkeypress="return submitenter(this,event,'user?method=addUserGroups')">
<script>
				userGroups.userGroups.<%=CODE%>.focus();
				</script>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div class="division"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"
	class="button" onClick="submitForm('userGroups','user?method=addUserGroups');" accesskey="a" tabindex=1 /> <input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('userGroups','user?method=editUserGroups')" accesskey="u" tabindex=1 /> 
	<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('userGroups','user?method=deleteUserGroups&flag='+this.value)" accesskey="d" tabindex=1 /> 
	<input type="reset" name="Reset" id="reset" value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<input type="button" name="Back" value="Back" class="button" accesskey="b" onclick="submitFormForButton('userGroups','superAdmin?method=showModuleManagementJsp')"
	tabindex=1 /> <input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" />

<div class="Clear"></div>
<div class="division"></div>

<div class="bottom"><label>Changed By:</label>
 <label	class="value"><%=userName %></label> 
 <label>Changed Date:</label> 
 <label	class="value"><%=date%></label> 
 <label>Changed Time:</label> 
 <label	class="value"><%=time%></label> 
 <input type="hidden" name="<%=CHANGED_BY%>" value="admin" /> 
 <input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="Clear"></div>
</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "User Group Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "User Group Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";


data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%= CHANGED_BY%>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_DATE%>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%=CHANGED_TIME %>";


data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchUserGroupsList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
             UserGroups  masUserGroups = (UserGroups)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masUserGroups.getId()%>
data_arr[<%= counter%>][1] = "<%=masUserGroups.getCode()%>"
data_arr[<%= counter%>][2] = "<%= masUserGroups.getGroupName()%>"

data_arr[<%= counter%>][3] = "<%= masUserGroups.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masUserGroups.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masUserGroups.getLastChgTime() %>"
<% if(masUserGroups.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "userGroups"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
