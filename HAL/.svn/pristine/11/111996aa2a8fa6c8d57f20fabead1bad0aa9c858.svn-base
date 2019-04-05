<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * room.jsp  
 * Purpose of the JSP -  This is for Room.
 * @author  Dipali
 * @author  Mansi
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.9
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasRoom"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasRoomType"%>
<%
Map map = new HashMap();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<MasRoomType> roomTypeList = new ArrayList<MasRoomType>();
	departmentList = (ArrayList)map.get("departmentList");
	roomTypeList = (ArrayList)map.get("roomTypeList");
	ArrayList searchRoomList = (ArrayList)map.get("searchRoomList");
	ArrayList gridDepartmentList = (ArrayList)map.get("gridDepartmentList");
	ArrayList gridRoomTypeList = (ArrayList)map.get("gridRoomTypeList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }

%>
<div class="titleBg">
<h2 >Room Master</h2>
</div>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">
<label>Room Code</label> <input type="text"
	id="searchField" name="<%= CODE%>" value=""
	validate="Room Code,string,no" MAXLENGTH="8" tabindex=1
	onkeypress="return submitenter(this,event,'hospital?method=searchRoom')" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','hospital?method=searchRoom','checkSearch')"
	tabindex=1 /> <%--- Report Button   --%> <input type="button"
	name="Report" value="Generate Report Based on Search" class="buttonBig3"
	onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');"
	accesskey="g" tabindex=1 /> <input type="hidden"
	name="<%=JASPER_FILE_NAME%>" value="Mas_room"></div></form>
</div>
</div>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
		if(searchRoomList.size()>0 && roomTypeList.size() > 0)
		 {
			String strForCode = (String)map.get("roomCode");
			String strForCodeDescription = (String)map.get("roomName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <br />
<h4><a href="hospital?method=showRoomJsp">Show All Records</a><h4> <%
			}
		 }
	 if(searchRoomList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="hospital?method=showRoomJsp">Show All Records</a></h4> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= ROOM_TYPE_ID %>"], [3,"<%= DEPARTMENT_ID %>"],[4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"] ];
	 statusTd = 7;
	</script></div>

<form name="room" method="post" action=""><input type="hidden"
	name="<%= POJO_NAME %>" value="MasRoom"> <input type="hidden"
	name="title" value="Room"> <input type="hidden"
	name="<%=JSP_NAME %>" value="room"> <input type="hidden"
	name="pojoPropertyCode" value="RoomCode"> <br>


<div class="Block"><label> Room Code<span>*</span></label> <input id="codeId" type="text"
	name="<%= CODE%>" value="" validate="Room Code,string,yes"
	class="textbox_size20" MAXLENGTH="8" / tabindex=1> <script>
				document.room.<%=CODE%>.focus();
			</script> <label> Room
Type<span>*</span></label> <select name="<%= ROOM_TYPE_ID %>" validate="Room Type,string,yes"
	tabindex=1>
	<option value="">Select</option>
	<% 
				
				for (MasRoomType  masRoomType : roomTypeList){
				%>

	<option value="<%=masRoomType.getId ()%>"><%=masRoomType.getRoomTypeName()%></option>

	<%}%>
</select> <label>Department <span>*</span></label> <select name="<%= DEPARTMENT_ID %>"
	validate="Deparment,string,yes" tabindex=1
	onkeypress="return submitenter(this,event,'hospital?method=addRoom')">
	<option value="">Select</option>
	<% 
				
				for (MasDepartment  masDepartment : departmentList){
				%>

	<option value="<%=masDepartment.getId ()%>"><%=masDepartment.getDepartmentName()%></option>

	<%}%>
</select></div>
<div id="edited"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton"
	value="Add" class="button"
	onClick="submitForm('room','hospital?method=addRoom');" accesskey="a"
	tabindex=1 /> <input type="button" name="edit" id="editbutton"
	value="Update" class="button"
	onClick="submitForm('room','hospital?method=editRoom')" accesskey="u"
	tabindex=1 /> <input type="button" name="Delete" id="deletebutton"
	value="Activate" class="button"
	onClick="submitForm('room','hospital?method=deleteRoom')" accesskey="d"
	tabindex=1 /> <input type="reset" name="Reset" id="reset" value="Reset"
	class="button" onclick="resetcheck();" accesskey="r" /> <input
	type="hidden" name="<%=STATUS %>" value="" /> <input type="hidden"
	name="<%= COMMON_ID%>" value="" /> <br />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By:</label>
<label class="value"><%=userName%></label>

<label>Changed Date:</label>
<label class="value"><%=date%></label>

<label>Changed Time:</label>
<label class="value"><%=time%></label>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
		<input type="hidden" name="<%=HOSPITAL_ID %>"  value="<%=hospitalId%>" />
	
</div>

</form>
</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Room Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Room Type"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= ROOM_TYPE_ID %>";

data_header[2] = new Array;
data_header[2][0] = "Department"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%=DEPARTMENT_ID %>";

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
data_header[5][3] = "<%=CHANGED_TIME %>"

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";

data_arr = new Array();

<%

Iterator itr=searchRoomList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasRoom  masRoom = (MasRoom)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masRoom.getId()%>
data_arr[<%= counter%>][1] = "<%=masRoom.getRoomCode()%>"
            
<% if(masRoom.getRoomType() != null){%> 
<%
		Iterator itrGridRoomTypeList=gridRoomTypeList.iterator();
		 while(itrGridRoomTypeList.hasNext())
            {
             MasRoomType  roomTypeGrid = (MasRoomType)itrGridRoomTypeList.next(); 
			 if(masRoom.getRoomType().getId().equals(roomTypeGrid.getId()) && roomTypeGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][2] = "<%=roomTypeGrid.getRoomTypeName()%>"
			<%}else if(masRoom.getId().equals(roomTypeGrid.getId()) && roomTypeGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=roomTypeGrid.getRoomTypeName()%>";
				
				
			<%}
            }
		}
%>
<% if(masRoom.getDepartment() != null){%>       
 <%
		Iterator itrGridDepartmentList=gridDepartmentList.iterator();
		 while(itrGridDepartmentList.hasNext())
            {
             MasDepartment  departmentGrid = (MasDepartment)itrGridDepartmentList.next(); 
			 if(masRoom.getDepartment().getId().equals(departmentGrid.getId()) && departmentGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][3] = "<%=departmentGrid.getDepartmentName()%>"
			<%}else if(masRoom.getId().equals(departmentGrid.getId()) && departmentGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=departmentGrid.getDepartmentName()%>";
			<%}
            }
		}
%>
data_arr[<%= counter%>][4] = "<%= masRoom.getLastChgBy() %>"
<%
if(masRoom.getLastChgDate()!= null){
%>
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masRoom.getLastChgDate()) %>"

<%}else{%>
data_arr[<%= counter%>][5] = ""
<%}%>
data_arr[<%= counter%>][6] = "<%= masRoom.getLastChgTime() %>"
<% if(masRoom.getStatus().equals("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "room"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
