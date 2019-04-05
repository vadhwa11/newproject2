<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hospital.jsp  
 * Purpose of the JSP -  This is for All Hospital Master.
 * @author  Mansi
 * Create Date: 04 June,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.5
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.UserGroups"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.UsergroupHospital"%>
<script type="text/javascript">
/***********************************************
* Textarea Maxlength script- © Dynamic Drive (www.dynamicdrive.com)
* This notice must stay intact for legal use.
* Visit http://www.dynamicdrive.com/ for full source code
***********************************************/
function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)
}
</script> 
<%
	Map<String,Object> map = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	ArrayList searchUsergroupHospitalList = (ArrayList)map.get("searchUsergroupHospitalList");
	List<UserGroups> userGroupsList = new ArrayList<UserGroups>();
	List<MasHospital> hospitalList = new ArrayList<MasHospital>();
	hospitalList = (ArrayList)map.get("hospitalList");
	userGroupsList = (ArrayList)map.get("userGroupsList");
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
<div class="titleBg">
<h2>User Group Hospital</h2>
</div>
<div class="Clear"></div>
<div id="searcharea">
<div id="searchbar">

<form name="search" method="post" action="">
<div class="Block">

<label>User Groups Name</label>
<input type="radio"	name="<%=SELECTED_RADIO  %>" class="radioAuto" value="1" checked="checked" /> 
 
<label>Hospital Name</label>
<input type="radio"	name="<%=SELECTED_RADIO %>" class="radioAuto" value="2" /> 
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Hospital Name,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'user?method=searchUsergroupHospital')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','user?method=searchUsergroupHospital','checkSearch')"	tabindex=1 />
</div>
</form>
<div class="Clear"></div>
</div>
</div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
  if(searchUsergroupHospitalList.size()>0)
   {
   String strForGroupName = (String)map.get("groupName");
   String strForHospitalName = (String)map.get("hospitalName");
   if(strForGroupName!= null && strForGroupName!= "" || strForHospitalName!= null && strForHospitalName!= "")
   {
 %>
<h4><a href="user?method=showUsergroupHospitalJsp">Show All Records</a></h4>
<%
		
		  }
	   }
	 if(searchUsergroupHospitalList.size()==0 && map.get("search") != null)
	  {
	 %>
<h4><a href="user?method=showUsergroupHospitalJsp">Show All Records</a></h4>
<%
    }
	%> <script type="text/javascript">
 
 formFields = [
   [0, "<%= COMMON_ID%>", "id"], [1,"<%= USER_GROUP_ID%>"], [2,"<%= HOSPITAL_ID %>"],[3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
  statusTd =6;
 </script></div>
<div class="Clear paddingTop15 " ></div>
<form name="usergroupHospital" method="post" action="">
<input	type="hidden" name="<%=JSP_NAME %>" value="userGroupHospital">
<div class="Block">
<label><span>*</span> User Group Name </label> 
<select name="<%=USER_GROUP_ID %>" validate="User Group Name,string,yes" tabindex=1>
	<option value="">Select</option>
	<%
          		if(userGroupsList != null){ 	
          			for (Iterator iter = userGroupsList.iterator(); iter.hasNext();) {
          				UserGroups userGroups = (UserGroups) iter.next();
          %>
	<option value="<%=userGroups.getId() %>"><%=userGroups.getGroupName() %></option>
	<%		
         			}
         		 } 
         %>
</select> 
<label><span>*</span> Hospital Name </label> 
<select	name="<%=HOSPITAL_ID %>" validate="Hospital Name,string,yes" tabindex=1>
	<option value="">Select</option>
	<%
          		if(hospitalList != null){ 	
          			for (Iterator iter = hospitalList.iterator(); iter.hasNext();) {
          				MasHospital masHospital = (MasHospital) iter.next();
          %>
	<option value="<%=masHospital.getId() %>"><%=masHospital.getHospitalName() %></option>
	<%		
         			}
         		 } 
         %>
</select></div>
<div class="Clear"></div>
<div id="edited"></div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<input type="button" name="add" id="addbutton" value="Add"	class="button"	onClick="submitForm('usergroupHospital','user?method=addUsergroupHospital');" accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" class="button"	onClick="submitForm('usergroupHospital','user?method=editUsergroupHospital')" accesskey="u" tabindex=1 /> 
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('usergroupHospital','user?method=deleteUsergroupHospital&flag='+this.value)" accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset" id="reset" value="Reset" class="button" onclick="resetCheck();" accesskey="r" /> 
<input type="button" name="Back" value="Back" class="button" accesskey="b"	onclick="submitFormForButton('usergroupHospital','superAdmin?method=showModuleManagementJsp')"	tabindex=1 /> 
<input type="hidden" name="<%=STATUS %>" value="" /> 
<input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<div class="bottom">
<label>Changed By:</label> 
<label	class="value"><%=userName %></label> 
<label>Changed Date:</label> 
<label	class="value"><%=date%></label> 
<label>Changed Time:</label> 
<label	class="value"><%=time%></label> 
<input type="hidden"	name="<%=CHANGED_BY%>" value="admin" /> 
<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input type="hidden"	name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
<div class="Clear"></div>
</form>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "User Group Name"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= USER_GROUP_ID%>"

data_header[1] = new Array;
data_header[1][0] = "Hospital Name"
data_header[1][1] = "data";
data_header[1][2] = "30%";
data_header[1][3] = "<%= HOSPITAL_ID %>";


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
data_header[5][2] = "10%";
data_header[5][3] = "<%=STATUS %>";

data_arr = new Array();
<%
Iterator itr=searchUsergroupHospitalList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {            
        	  UsergroupHospital  masUsergroupHospital = (UsergroupHospital)itr.next();       
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masUsergroupHospital.getId()%>
<%
Iterator itrUserGroupsList=userGroupsList.iterator();
while(itrUserGroupsList.hasNext())
      {
	UserGroups  masUserGroupsGrid = (UserGroups)itrUserGroupsList.next(); 
	 if(masUsergroupHospital.getGroup().getId().equals(masUserGroupsGrid.getId()) && masUserGroupsGrid.getStatus().equals("y")){%>
		data_arr[<%= counter%>][1] = "<%=masUserGroupsGrid.getGroupName()%>"
	<%}else if(masUsergroupHospital.getGroup().getId().equals(masUserGroupsGrid.getId()) && masUserGroupsGrid.getStatus().equals("n")){%>
		data_arr[<%= counter%>][1] = "<font id='error'>*</font>Parent InActivated--<%=masUserGroupsGrid.getGroupName()%>";
	<%}
}%>
<%
Iterator itrHospitalList=hospitalList.iterator();
while(itrHospitalList.hasNext())
      {
       MasHospital  masHospitalGrid = (MasHospital)itrHospitalList.next(); 
	 if(masUsergroupHospital.getHospital().getId().equals(masHospitalGrid.getId()) && masHospitalGrid.getStatus().equals("y")){%>
		data_arr[<%= counter%>][2] = "<%=masHospitalGrid.getHospitalName()%>"
	<%}else if(masUsergroupHospital.getHospital().getId().equals(masHospitalGrid.getId()) && masHospitalGrid.getStatus().equals("n")){%>
		data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=masHospitalGrid.getHospitalName()%>";
	<%}
}%>

data_arr[<%= counter%>][3] = "<%= masUsergroupHospital.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masUsergroupHospital.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masUsergroupHospital.getLastChgTime() %>"
<% if(masUsergroupHospital.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "usergroupHospital"

start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  
</script>