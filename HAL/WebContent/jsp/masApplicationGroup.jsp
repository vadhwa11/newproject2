<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasApplicationgroup"%>
<script type="text/javascript">

function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)
}

</script>
<%
Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map<String,Object>) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
ArrayList searchApplicationGroupList = (ArrayList)map.get("searchApplicationGroupList");

String userName = "";
if(session.getAttribute("userName") != null){
 userName = (String)session.getAttribute("userName");
}

if(map.get("message") != null){
String message = (String)map.get("message");
%> 
<h4><span><%=message %></span></h4> 
<% 
}
%>
<div class="clear"></div>
<div class="titleBg">
<h2>Login Group</h2>
</div>
<div class="clear"></div>
<div id="searcharea">

<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">
<label>Login Group Code </label> 
<input type="radio" name="<%=SELECTED_RADIO  %>" class="radioAuto" value="1" checked="checked" /> 
<label>Login Group Name </label> 
<input type="radio" name="<%=SELECTED_RADIO %>" class="radioAuto" value="2" /> 
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Login Group Code,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'user?method=searchAppGroup')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','user?method=searchAppGroup','checkSearch')" tabindex=1 />
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
		if(searchApplicationGroupList.size()>0)
		 {
			String strForCode = (String)map.get("appGroupCode");
			String strForCodeDescription = (String)map.get("appGroupName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%>


<h4><a href="user?method=showAppGroup">Show All Records</a></h4>
<%
			}
		 }
	 if(searchApplicationGroupList.size()==0 && map.get("search") != null)
	  {
	 %>
<h4><a href="user?method=showAppGroup">Show All Records</a></h4>

<%
     }
%> 
<script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"],[1,"<%= CODE%>"],[2,"<%= SEARCH_NAME %>"],[3,"<%= CHANGED_BY%>"],[4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"]];
	 statusTd = 6;
</script>
</div>
<div class="clear"></div>
<form name="appGroup" method="post" action="">
<input type="hidden" name="<%= POJO_NAME %>" value="MasApplicationgroup"> 
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="ApplicationgroupName">
<input type="hidden" name="title" value="Application group"> 
<input type="hidden" name="<%=JSP_NAME %>" value="masApplicationGroup"> 
<input type="hidden" name="pojoPropertyCode" value="ApplicationgroupCode">
<div class="clear"></div>
<div class="clear"></div>
<div class=Block>
<label><span>*</span> Login Group Code  </label> 
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Login Group Code,string,yes" class="textbox_size20" MAXLENGTH="8" tabindex=1 /> 
<label><span>*</span>Login Group Name </label> 
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Login Group Name,string,yes" class="textbox_size20" maxlength="30" tabindex=1 onkeypress="return submitenter(this,event,'user?method=addAppGroup')" />
<script>
appGroup.<%=CODE%>.focus();
</script> 
</div>
<div class="clear"></div>
<div id="edited"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button"  onClick="submitForm('appGroup','user?method=addAppGroup');" accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('appGroup','user?method=editApplicationGroup')" accesskey="u" tabindex=1 /> 
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('appGroup','user?method=deleteAppGroup&flag='+this.value)" accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" /> 
<input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By:</label> 
<label class="value"><%=userName %></label> 
<label>Changed Date:</label> 
<label class="value"><%=date%></label> 
<label>Changed Time:</label> 
<label class="value"><%=time%></label> 
<input type="hidden" name="<%=CHANGED_BY%>" value="admin" /> 
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<div class="clear"></div>
</div>
<div class="clear"></div>
</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Login group Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%=CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Login group Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%=SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%=CHANGED_BY%>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=CHANGED_DATE%>"

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
Iterator itr = searchApplicationGroupList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
        	  MasApplicationgroup  masAppGrp = (MasApplicationgroup)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%= masAppGrp.getId()%>"
data_arr[<%= counter%>][1] = "<%= masAppGrp.getApplicationgroupCode()%>"
data_arr[<%= counter%>][2] = "<%= masAppGrp.getApplicationgroupName()%>"
data_arr[<%= counter%>][3] = "<%= masAppGrp.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masAppGrp.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masAppGrp.getLastChgTime() %>"
<% if(masAppGrp.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
counter++;
}
%>
 
formName = "appGroup"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
