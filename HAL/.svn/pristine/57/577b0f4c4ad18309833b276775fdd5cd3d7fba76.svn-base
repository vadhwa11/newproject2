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
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.UserUsergroupHospital"%>
<%@page import="jkt.hms.masters.business.UserGroups"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript">
<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script> <%
	Map<String,Object> map = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date1 = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	ArrayList searchUserUsergroupHospitalList = (ArrayList)map.get("searchUserUsergroupHospitalList");
	List<Users> usersList = new ArrayList<Users>();
	List<MasHospital> hospitalList = new ArrayList<MasHospital>();
	List<UserGroups> groupList = new ArrayList<UserGroups>();
	hospitalList = (ArrayList)map.get("hospitalList");
	usersList = (ArrayList)map.get("usersList");
	groupList=(ArrayList)map.get("groupList");
	
	List<MasHospital> gridMasHospitalList = new ArrayList<MasHospital>();
	List<UserGroups> gridGroupList = new ArrayList<UserGroups>();
	List<Users> gridUsersList = new ArrayList<Users>();
	gridMasHospitalList = (ArrayList)map.get("gridMasHospitalList");
	gridGroupList=(ArrayList)map.get("gridGroupList");
	gridUsersList =(ArrayList)map.get("gridUsersList");
	
	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	}
		 
 %> <%
		if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %> <h4> <span><%=message %> </span></h4> <%
		}
    %>


<div class="Clear"></div>
<div class="titleBg">
<h2>User Hospital Maintenance</h2>
</div>
<div class="Clear"></div>
<div id="searcharea">

<div id="searchbar">

<form name="search" method="post" action="">
<div class="Block">
<label>Users Name</label> 
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="User Name,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'user?method=searchUserHospitalMaintenance')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','user?method=searchUserHospitalMaintenance','checkSearch')" tabindex=1 />
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
  if(searchUserUsergroupHospitalList.size()>0)
   {
   String strForUserName = (String)map.get("userName");
  // String strForHospitalName = (String)map.get("hospitalName");
   if(strForUserName!= null && strForUserName!= "")
   {
 %>
<h4><a href="user?method=showUserHospitalMaintenanceJsp">Show All Records</a></h4>
<%}
	   }
	 if(searchUserUsergroupHospitalList.size()==0 && map.get("search") != null)
	  {
	 %>
<h4><a href="user?method=showUserHospitalMaintenanceJsp">Show All Records</a></h4>
<%
    }
	%> <script type="text/javascript">
 
 formFields = [
   [0, "<%= COMMON_ID%>", "id"], [1,"<%= USER_ID%>"], [2,"<%= HOSPITAL_ID %>"],[3,"<%= GROUP_ID %>"],[4,"<%= VALID_DATE %>"],[5,"<%= CHANGED_BY%>"], [6,"<%= CHANGED_DATE %>"],[7,"<%= CHANGED_TIME %>"],[8,"<%=STATUS%>"] ];
  statusTd =8;
 </script></div>
<div class="Clear"></div>
<div class="Clear paddingTop15"></div>
<form name="userHospitalMaintenance" method="post" action="">
<input	type="hidden" name="<%=JSP_NAME %>" value="userHospitalMaintenance">
<div class="Block">
<label><span>*</span> User Name </label> 
<select name="<%=USER_ID %>" validate="User Name,string,yes" tabindex=1	class="large2">
	<option value="0">Select</option>
	<%
          		if(usersList != null){ 	
          			for (Iterator iter = usersList.iterator(); iter.hasNext();) {
          				Users users = (Users) iter.next();
          %>
	<option value="<%=users.getId() %>"><%=users.getUserName()%></option>
	<%		
         			}
         		 } 
         %>
</select>
<label><span>*</span> Hospital Name </label> 
<select name="<%=HOSPITAL_ID %>" validate="Hospital Name,string,yes" tabindex=1	onchange="submitProtoAjax('userHospitalMaintenance','user?method=getUserGroupForHospital')">
	<option value="0">Select</option>
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
</select>
<div class="Clear"></div>
<%-- <div id="testDiv">
<label><span>*</span> Group Name</label> 
<select	name="<%=GROUP_ID%>" validate="Group Name,string,yes" tabindex="1"	onChange="populateHospital(this.value,'userHospitalMaintenance')" class="large2">
	<option value="0">Select</option>

	<%   			for (Iterator iter = groupList.iterator(); iter.hasNext();) {
        				UserGroups userGroups = (UserGroups) iter.next();
          %>
	<option value="<%=userGroups.getId() %>"><%=userGroups.getGroupName() %></option>
	<%		
         			}
        %>

</select></div> 
<label>Valid-Up to Date</label> 
<input type="text" id="startDateId"	name="<%=VALID_DATE%>" value="" class="calDate" readonly="readonly" validate="Valid-Up to Date Date,date,no" MAXLENGTH="30" /> 
<img	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.userHospitalMaintenance.<%=VALID_DATE%>,event)" />

--%>
</div>
<div class="Clear"></div>
<div id="edited"></div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('userHospitalMaintenance','user?method=addUserHospitalMaintenance');"	accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('userHospitalMaintenance','user?method=editUserHospitalMaintenance')" accesskey="u" tabindex=1 /> 
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('userHospitalMaintenance','user?method=deleteUserHospitalMaintenance&flag='+this.value)" accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset" id="reset" value="Reset" class="button" onclick="resetCheck();" accesskey="r" /> 
<input type="button" name="Back" value="Back" class="button" accesskey="b" validate="back,metachar,no" onclick="submitFormForButton('userHospitalMaintenance','superAdmin?method=showModuleManagementJsp')"	tabindex=1 /> 
<input type="hidden" name="<%=STATUS %>" value="" /> 
<input	type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="bottom">
<label>Changed By:</label> 
<label	class="value"><%=userName %></label> 
<label>Changed Date:</label> 
<label	class="value"><%=date1%></label> 
<label>Changed Time:</label> 
<label	class="value"><%=time%></label> 
<input type="hidden"	name="<%=CHANGED_BY%>" value="admin" /> 
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date1%>" /> 
<input type="hidden"	name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
<div class="Clear"></div>
</form>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "User Name"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= USER_ID%>"

data_header[1] = new Array;
data_header[1][0] = "Hospital Name"
data_header[1][1] = "data";
data_header[1][2] = "30%";
data_header[1][3] = "<%= HOSPITAL_ID %>";


data_header[2] = new Array;
data_header[2][0] = "Group Name"
data_header[2][1] = "hide";
data_header[2][2] = "20%";
data_header[2][3] = "<%= GROUP_ID%>"

data_header[3] = new Array;
data_header[3][0] = "Valid Date"
data_header[3][1] = "hide";
data_header[3][2] = "30%";
data_header[3][3] = "<%= VALID_DATE  %>";


data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_BY%>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_DATE%>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%=CHANGED_TIME %>";


data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = "10%";
data_header[7][3] = "<%=STATUS %>";

data_arr = new Array();
<%
Iterator itr=searchUserUsergroupHospitalList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {            
        	  UserUsergroupHospital  masUserUsergroupHospital = (UserUsergroupHospital)itr.next();       
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masUserUsergroupHospital.getId()%>
<%

	
	 if(masUserUsergroupHospital.getUser().getStatus().equals("y") ){%>
		data_arr[<%= counter%>][1] = "<%=masUserUsergroupHospital.getUser().getUserName()%>"
	<%}else if(masUserUsergroupHospital.getUser().getStatus().equals("n")){%>
		data_arr[<%= counter%>][1] = "<font id='error'>*</font>Parent InActivated--<%=masUserUsergroupHospital.getUser().getUserName()%>";
	<%}
%>

<%

	 if(masUserUsergroupHospital.getHospital()!=null && masUserUsergroupHospital.getHospital().getStatus().equals("y")){%>
		data_arr[<%= counter%>][2] = "<%=masUserUsergroupHospital.getHospital().getHospitalName()%>"
	<%}else if(masUserUsergroupHospital.getHospital()!=null && masUserUsergroupHospital.getHospital().getStatus().equals("n")){%>
		data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=masUserUsergroupHospital.getHospital().getHospitalName()%>";
	<%}
%>
data_arr[<%= counter%>][3] ="";
	data_arr[<%= counter%>][4] ="";
<%-- <%
Iterator itrGroupList=gridGroupList.iterator();
while(itrGroupList.hasNext())
      {
	UserGroups  userGroups = (UserGroups)itrGroupList.next(); 
	 if(masUserUsergroupHospital.getGroupHospital().getGroup().getId().equals(userGroups.getId()) && userGroups.getStatus().equals("y")){%>
		data_arr[<%= counter%>][3] = "<%=userGroups.getGroupName()%>"
	<%}else if(masUserUsergroupHospital.getGroupHospital().getGroup().getId().equals(userGroups.getId()) && userGroups.getStatus().equals("n")){%>
		data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=userGroups.getGroupName()%>";
	<%}
}
String valDate ="";
if(masUserUsergroupHospital.getValidUpto() !=null){
	valDate=HMSUtil.convertDateToStringWithoutTime(masUserUsergroupHospital.getValidUpto());
}
%> --%>
<%-- data_arr[<%= counter%>][4] = "<%=valDate  %>" --%>
data_arr[<%= counter%>][5] = "<%= masUserUsergroupHospital.getLastChgBy() %>"
data_arr[<%= counter%>][6] = "<%= (masUserUsergroupHospital.getLastChgDate()!=null?HMSUtil.convertDateToStringWithoutTime(masUserUsergroupHospital.getLastChgDate()):"") %>"
data_arr[<%= counter%>][7] = "<%= masUserUsergroupHospital.getLastChgTime() %>"
<% if(masUserUsergroupHospital.getStatus().equals("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "userHospitalMaintenance"

start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  
</script>