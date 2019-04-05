<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * bed.jsp  
 * Purpose of the JSP -  This is for Bed Details.
 * @author  Deepali
 * @author  Mansi
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.10  
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasBed"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasRoom"%>
<%@page import="jkt.hms.masters.business.MasBedStatus"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%	
		Map<String,Object> map = new HashMap<String,Object>();
		if(request.getAttribute("map") != null){
			map = (Map<String,Object>) request.getAttribute("map");
		}		
		
		List<MasDepartment> searchDepartmentList = new ArrayList<MasDepartment>();
		searchDepartmentList = (ArrayList)map.get("searchDepartmentList");
		
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		departmentList = (ArrayList)map.get("departmentList");
		
		List<MasBedStatus> bedStatusList = new ArrayList<MasBedStatus>();
		bedStatusList = (ArrayList)map.get("bedStatusList");

		List<MasRoom> roomList = new ArrayList<MasRoom>();
		roomList = (ArrayList)map.get("roomList");

		List<MasBed> searchBedList = (ArrayList)map.get("searchBedList");
				
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = (ArrayList)map.get("hospitalList");
		
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
		
		String date = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			Integer temp =  (Integer)session.getAttribute("hospitalId");
			hospitalId = temp.intValue();
		}
		
%>

<%
if(map.get("message") != null){
		   String message = (String)map.get("message");
%>

<h4><%=message%></h4>
<div class="Clear"></div>
  <%
		  }
%>
<div class="titleBg">
<h2>Bed Master</h2>
</div>
<div class="Clear"></div>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">
<label>Department</label> 
<select name="depId" id="searchField" validate="Deparment,string,no"
	tabindex=1>
	<option value="">Select</option>
	<%
          		if(searchDepartmentList != null){ 	
          			for (Iterator iter = searchDepartmentList.iterator(); iter.hasNext();) {
          				MasDepartment masDepartment = (MasDepartment) iter.next();
          %>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
	<%		
         			}
         		 } 
         %>
</select> 
<%-- <label>Bed Number</label> <input type="text"
	id="searchField" name="<%=SEARCH_NAME%>" value=""
	validate="Bed Number,string,no" MAXLENGTH="8"
	onkeypress="return submitenter(this,event,'hospital?method=searchBed')" /> --%>

<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','hospital?method=searchBed','checkSearch')" tabindex=1  />
<%--- Report Button   --%>
<input type="button" name="Report" value="Generate Report Based on Search" class="buttonBig3" onClick="submitForm('search','hospital?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1/>
 <input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_bed"></div></form>
</div>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults">
<div id="searchtable"></div>
<% try{
		if(searchBedList.size()>0 )
		 {
			int strForCode = (Integer)map.get("depId");
			if(strForCode!= 0)
			{
	%> 
<h4><a href="hospital?method=showBedJsp">Show All Records</a></h4> <%
			}
		 }
		 if(searchBedList.size()==0)
		  {
	%> 
<h4><a href="hospital?method=showBedJsp">Show All Records</a></h4> <%
      }}
	      catch(Exception ex){
	    	  ex.printStackTrace();
	      }
	 if(searchBedList.size()==0 && map.get("search") != null)
	  {
	 %> <h2><a href="hospital?method=showBedJsp">Show All Records</a></h2> <%
      }
 	%> <script type="text/javascript">
	
	formFields = [
	[0, "<%= COMMON_ID%>", "id"], [1,"<%= SEARCH_NAME%>"],  [2,"<%= ROOM_ID %>"],[3,"<%= BED_STATUS_ID%>"],[4,"<%= DEPARTMENT_ID%>"],[5,"<%= AD_NO%>"],[6,"<%= DIET_TYPE%>"],[7,"<%= ATTACHED%>"],[8,"<%= INTRODUCTION_DATE%>"], [9,"<%= DISCARD_DATE%>"] ,[10,"<%= CHANGED_BY%>"] ,[11,"<%= CHANGED_DATE%>"] ,[12,"<%= CHANGED_TIME%>"],[13,"<%=STATUS%>"] ];
		
	 statusTd = 13;
	</script></div>


<form name="bed" method="post" action=""><input type="hidden"
	name="<%= POJO_NAME %>" value="MasBed"> <input type="hidden"
	name="<%=POJO_PROPERTY_NAME %>" value="BedNo"> <input
	type="hidden" name="title" value="Bed"> <input type="hidden"
	name="<%=JSP_NAME %>" value="bed"> <input type="hidden"
	name="pojoPropertyCode" value="BedNumber"> 
	<div class="Clear"></div>
	<div class="Block">
<label> Bed
Number<span>*</span> </label> <input id="codeId" type="text" name="<%= SEARCH_NAME%>" tabindex="1"
	value="" validate="Bed Number,string,yes" 
	MAXLENGTH="8"/  > <script>
			document.bed.<%=SEARCH_NAME%>.focus();
		</script> <label  class=""> Department<span>*</span>
</label> <select name="<%=DEPARTMENT_ID %>" validate="Deparment,string,yes"
	tabindex=1>
	<option value="">Select</option>
	<%
          		if(departmentList != null){ 	
          			for (Iterator iter = departmentList.iterator(); iter.hasNext();) {
          				MasDepartment masDepartment = (MasDepartment) iter.next();
          %>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
	<%		
         			}
         		 } 
         %>
</select> 
<label> Room Number </label> 
<select name="<%= ROOM_ID %>" validate="Room Number,string,no" tabindex="1">
	<option value="0">Select</option>
	<%
          		if(roomList != null){ 	
          			for (Iterator iter = roomList.iterator(); iter.hasNext();) {
          				MasRoom masRoom = (MasRoom) iter.next();
          %>
	<option value="<%=masRoom.getId() %>"><%=masRoom.getRoomCode() %></option>
	<%		
          			} } 
         %>
</select> 
<div class="Clear"></div>
<label>Bed Status  <span>*</span></label> <select name="<%=BED_STATUS_ID%>"
	validate="Bed Status,string,yes" tabindex=1>
	<option value="">Select</option>
	<%
          		if(bedStatusList != null){ 	
          			for (Iterator iter = bedStatusList.iterator(); iter.hasNext();) {
          				MasBedStatus masBedStatus = (MasBedStatus) iter.next();
          %>
	<option value="<%=masBedStatus.getId() %>"><%=masBedStatus.getBedStatusName() %></option>
	<%		
          			} }
         %>
</select> 
<input type="hidden" name="<%=HOSPITAL_ID %>" value="<%=(Integer)session.getAttribute("hospitalId") %>">
<%--
<label class="">AD Number </label> <input type="text"  tabindex="1"
	name="<%= AD_NO%>" value="" validate="AD Number,string,no"
	 MAXLENGTH="8" /> <label><font
	id="error"></font>Diet Type </label> <select name="<%=DIET_TYPE%>"  tabindex="1"> 
	<option value="0">Select</option>
	<option value="Veg">Veg</option>
	<option value="Non-Veg">Non-Veg</option>
</select> 

<div class="clear"></div>
<label>Attached</label> <input type="checkbox"  tabindex="1"
	name="<%=ATTACHED %>" value="y"
	onkeypress="return submitenter(this,event,'hospital?method=addBed')" class="radio">
	

<label  class=""> SMC<span>*</span> 
</label> <select name="<%=HOSPITAL_ID %>" validate="SMC,string,yes"
	tabindex=1>
	<option value="">Select</option>
	<%
          		if(hospitalList != null){ 	
          			for (MasHospital hospital : hospitalList){
          				if((Integer)session.getAttribute("hospitalId") == hospital.getId()){
          %>
	<option value="<%=hospital.getId() %>" selected="selected"><%=hospital.getHospitalName() %></option>
	<%		
         			}else{
         				%>
	<option value="<%=hospital.getId() %>"><%=hospital.getHospitalName() %></option>
         			<%}
         		 } 
          		}
         %>
</select>  --%>

</div>
<div class="Clear"></div>
<div id="edited"></div>
<div class="division"></div>
<div class="Clear"></div>
 <input type="button" name="add" id="addbutton"  tabindex="1"
	value="Add" class="button"
	onClick="submitForm('bed','hospital?method=addBed');" accesskey="a" />
<input type="button" name="edit" id="editbutton" value="Update"
	class="button" onClick="submitForm('bed','hospital?method=editBed')"
	accesskey="u" /> <input type="button" name="Delete" id="deletebutton"
	value="Activate" class="button"
	onClick="submitForm('bed','hospital?method=deleteBed&flag='+this.value)" accesskey="d" />
<input type="reset" name="Reset" value="Reset" class="button"
	onclick="location.reload();" accesskey="r" /> <input type="hidden"
	name="<%=STATUS %>" value="" /> <input type="hidden"
	name="<%= COMMON_ID%>" value="" />
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
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


<script type="text/javascript">

data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Bed Number"
data_header[0][1] = "data";
data_header[0][2] = 0;
data_header[0][3] = "<%= SEARCH_NAME %>"

data_header[1] = new Array;
data_header[1][0] = "Room Number"
data_header[1][1] = "data";
data_header[1][2] = 0;
data_header[1][3] = "<%= ROOM_ID%>";

data_header[2] = new Array;
data_header[2][0] = "Bed Status"
data_header[2][1] = "data";
data_header[2][2] = 0;
data_header[2][3] = "<%= BED_STATUS_ID%>"

data_header[3] = new Array;
data_header[3][0] = "Department"
data_header[3][1] = "data";
data_header[3][2] = 0;
data_header[3][3] = "<%= DEPARTMENT_ID %>"


data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= AD_NO %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= DIET_TYPE %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%=ATTACHED %>"

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = 0;
data_header[7][3] = "<%=INTRODUCTION_DATE %>"

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = 0;
data_header[8][3] = "<%=DISCARD_DATE %>"

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = 0;
data_header[9][3] = "<%=CHANGED_BY %>"

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = 0;
data_header[10][3] = "<%=CHANGED_DATE %>"

data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = 0;
data_header[11][3] = "<%=CHANGED_TIME %>"

data_header[12] = new Array;
data_header[12][0] = "Status"
data_header[12][1] = "data";
data_header[12][2] = 0;
data_header[12][3] = "<%=STATUS %>"

data_arr = new Array();

<%
int  counter=0;
for (MasBed masBed : searchBedList) {
if(masBed.getHospital().getId() == hospitalId){
%>

data_arr[<%= counter%>] = new Array();

data_arr[<%= counter%>][0] = "<%=masBed.getId()%>"
data_arr[<%= counter%>][1] = "<%=masBed.getBedNo()%>"

<%
	for(MasRoom masRoom : roomList){
		if(masBed.getRoom()!=null ){
		if(masBed.getRoom().getId().equals(masRoom.getId()) && masRoom.getStatus().equalsIgnoreCase("y")){
		 %>
			data_arr[<%= counter%>][2] = "<%=masRoom.getRoomCode()%>"
		<%}else if(masBed.getRoom().getId().equals(masRoom.getId()) && masRoom.getStatus().equalsIgnoreCase("n")){%>
			data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=masRoom.getRoomCode()%>";
			
		<%}
		}else{%>
			data_arr[<%= counter%>][2] = "-";
<%}}%>

<%
	Iterator itrBedStatusList=bedStatusList.iterator();
	 while(itrBedStatusList.hasNext())
           {
            MasBedStatus  masBedStatusGrid = (MasBedStatus)itrBedStatusList.next(); 
		 if(masBed.getBedStatus().getId().equals(masBedStatusGrid.getId()) && masBedStatusGrid.getStatus().equals("y")){%>
			data_arr[<%= counter%>][3] = "<%=masBedStatusGrid.getBedStatusName()%>"
		<%}else if(masBed.getBedStatus().getId().equals(masBedStatusGrid.getId()) && masBedStatusGrid.getStatus().equals("n")){%>
			data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=masBedStatusGrid.getBedStatusName()%>";
			
		<%}
}%>
<%
	Iterator itrDepartmentList=departmentList.iterator();
	 while(itrDepartmentList.hasNext())
           {
            MasDepartment  masDepartmentGrid = (MasDepartment)itrDepartmentList.next(); 
		 if(masBed.getDepartment().getId().equals(masDepartmentGrid.getId()) && masDepartmentGrid.getStatus().equals("y")){%>
			data_arr[<%= counter%>][4] = "<%=masDepartmentGrid.getDepartmentName()%>"
		<%}else if(masBed.getDepartment().getId().equals(masDepartmentGrid.getId()) && masDepartmentGrid.getStatus().equals("n")){%>
			data_arr[<%= counter%>][4] = "<font id='error'>*</font>Parent InActivated--<%=masDepartmentGrid.getDepartmentName()%>";
			
		<%}
}%>

data_arr[<%= counter%>][5] = "<%=masBed.getAdNo()%>"
data_arr[<%= counter%>][6] = "<%=masBed.getDietType()%>"
data_arr[<%= counter%>][7] = "<%=masBed.getAttached()%>"
data_arr[<%= counter%>][8] = "<%=masBed.getIntroductionDate()%>"
data_arr[<%= counter%>][9] = "<%=masBed.getDiscardDate()%>"
data_arr[<%= counter%>][10] = "<%= masBed.getLastChgBy()!=null?masBed.getLastChgBy().getId():"" %>"
data_arr[<%= counter%>][11] = "<%= HMSUtil.changeDateToddMMyyyy(masBed.getLastChgDate()) %>"
data_arr[<%= counter%>][12] = "<%= masBed.getLastChgTime() %>"

<% if(masBed.getStatus().equals("y")){ %>
data_arr[<%= counter%>][13] = "Active"
<%}else{%>
data_arr[<%= counter%>][13] = "InActive"
<%}%>
<%
		   counter++;
}
}
%>
formName = "bed"

nonEditable = ['<%= SEARCH_NAME%>']
nonEditable = ['<%= AD_NO%>']
 
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
	
	
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');
</script>
