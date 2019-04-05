<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * userApplication.jsp  
 * Purpose of the JSP -  This is for User Application.
 * @author  Dipali
 * Create Date: 8 Jan,2009
 * Revision Date:      
 * Revision By:  
 * @version 1.10
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.UserApplications"%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	ArrayList searchUserApplicationList = (ArrayList)map.get("searchUserApplicationList");
	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	}
	%> <%
if(map.get("message") != null){
	   String message = (String)map.get("message");
	    	   %> <h4><span><%=message %></span></h4> <% 
	  }

%>
<div class="titleBg">
<h2>User Application</h2>
</div>
<div class="clear"></div>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">
<div id="testdiv">
<label>Application Name</label> 
<input type="text" id="searchField" name="<%= SEARCH_NAME%>" value="" validate="Application Name,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'user?method=searchUserApplication)" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','user?method=searchUserApplication','checkSearch')" tabindex=1 />
</div>
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
  if(searchUserApplicationList.size()>0)
   {
   String strForCodeDescription = (String)map.get("appName");
   if(strForCodeDescription!= null && strForCodeDescription!= "")
   {
 %>

<h4><a href="user?method=showUserApplicationJsp">Show All Records</a></h4>
<%
			}
		 }
	if(searchUserApplicationList.size()==0 && map.get("search") != null)
	  {
	 %>
<h4><a href="user?method=showUserApplicationJsp">Show All Records</a></h4>

<%
  }
	%> <script type="text/javascript">
 
 formFields = [
   [0, "<%= COMMON_ID%>", "id"], [1,"<%= SEARCH_NAME%>"], [2,"<%= URL %>"], [3,"<%=CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
  statusTd = 6;
</script>
</div>
<div class="clear"></div>
<form name="userApplication" method="post" action="">
<input type="hidden" name="<%= POJO_NAME %>" value="UserApplications">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="AppName">
<input type="hidden" name="userApplication" value="UserApplications">
<input type="hidden" name="<%=JSP_NAME %>" value="userApplication">
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
<label class="auto"><span>*</span> Application Name  </label> 
<input id="codeId" type="text" name="<%= SEARCH_NAME%>" value="" validate="Application Name,string,yes" class="large" MAXLENGTH="45" tabindex=1> 
<label class="auto"><span>*</span> URL </label>
<input type="text" name="<%= URL %>" value="" validate="URL,string,yes" class="large2" MAXLENGTH="200" tabindex=1 onkeypress="return submitenter(this,event,'user?method=addUserApplication')">
</div>

<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>

<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('userApplication','user?method=addUserApplication');" accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('userApplication','user?method=editUserApplication')" accesskey="u" tabindex=1 /> 
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('userApplication','user?method=deleteUserApplication&flag='+this.value)" accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset" id="reset" value="Reset" class="button" onclick="resetCheck();" accesskey="r" />

<input type="hidden" name="<%=STATUS %>" value="" /> 
<input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div class="clear"></div>
<div class="bottom">
<label>Changed By:</label> 
<label class="value"><%=userName%></label> 
<label>Changed Date:</label> 
<label class="value"><%=date%></label> 
<label>Changed Time:</label> 
<label class="value"><%=time%></label> 
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>

<div class="clear"></div>

</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Application Name"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= SEARCH_NAME%>"

data_header[1] = new Array;
data_header[1][0] = "URL"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= URL %>";

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
Iterator itr=searchUserApplicationList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
        	  UserApplications  userApplications1 = (UserApplications)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= userApplications1.getId()%>
data_arr[<%= counter%>][1] = "<%=userApplications1.getAppName()%>"
data_arr[<%= counter%>][2] = "<%= userApplications1.getUrl()%>"

data_arr[<%= counter%>][3] = "<%= userApplications1.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(userApplications1.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= userApplications1.getLastChgTime() %>"
<% if(userApplications1.getStatus().equals("y")){ %>            
data_arr[<%= counter%>][6] = "Active"             
<%}else{%>          
data_arr[<%= counter%>][6] = "InActive"               
<%}%>
<%
       counter++;         
}                               
%>                        
 
formName = "userApplication"                      
                 
start = 0                                
if(data_arr.length < rowsPerPage)                           
 end = data_arr.length;                       
else                         
 end = rowsPerPage;                       
makeTable(start,end);                            
         
intializeHover('searchresulttable', 'TR', ' tableover');                      
</script>          