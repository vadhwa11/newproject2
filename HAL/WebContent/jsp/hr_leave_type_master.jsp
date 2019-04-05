<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * country.jsp  
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
<%@page import="jkt.hms.masters.business.HrLeaveTypeMaster"%>
<script type="text/javascript">
function isNumber(field) { 
        var re = /^[0-9-'.'-',']*$/; 
        if (!re.test(field.value)) { 
            alert('please enter only numeric data'); 
            field.value = field.value.replace(/[^0-9-'.'-',']/g,""); 
        } 
        } 

</script>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
		
	ArrayList searchLeaveTypeList = (ArrayList)map.get("searchLeaveTypeList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	


%>
<%
if(map.get("message") != null){
		   String message = (String)map.get("message");
%>
<h4><span><%=message%></span></h4>
  <%
		  }
%>
<div class="titleBg">
<h2>Leave Type Master</h2>
</div>
<div class="Clear"></div>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">
<label>Leave Type</label><input type="radio" class="radioAuto"
	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" tabindex="1" />
<label>Details</label>  <input type="radio" class="radioAuto"
	name="<%=SELECTED_RADIO %>" value="2" tabindex="1" /> <input type="text"
	id="searchField" name="<%= SEARCH_FIELD%>" value=""
	validate="Leave Type,string,no" MAXLENGTH="20" tabindex="1"
	onkeypress="return submitenter(this,event,'hrOrderly?method=searchLeaveType')" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','hrOrderly?method=searchLeaveType','checkSearch')"
	tabindex="1" /> <%--- Report Button   --%> <input type="button"
	name="Report" value="Generate Report Based on Search" class="buttonBig3"
	onClick="" accesskey="g" tabindex="1" /> <input type="hidden"
	name="<%=JASPER_FILE_NAME%>" value=""></div></form>
</div>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<%
	 if(map.get("search") != null)
	  {
	 %> <h4><a href="hrOrderly?method=showLeaveTypeJsp">Show All Records</a></h4> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%=DAYS%>"], [4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"] ];
	 statusTd = 7;
	</script></div>

<form name="leaveTypeMaster" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="HrLeaveTypeMaster">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="LeaveType">
<input type="hidden" name="title" value="Leave"> <input
	type="hidden" name="<%=JSP_NAME %>" value="Leave"> <input
	type="hidden" name="pojoPropertyCode" value="Details"> 

<div class="Clear"></div>
<div class="Block">
<label><span>*</span> Leave Type</label> <input id="codeId" type="text"
	name="<%= CODE%>" value="" validate="Leave Type,string,yes"
	 MAXLENGTH="15" tabindex="1" /> <label
	id=biglabel><span>*</span> Details</label>
<input type="text" name="<%= SEARCH_NAME %>" value=""
	validate="Details,string,yes"  MAXLENGTH="30"
	tabindex="1" /> <label>Days:</label>
<input name="<%=DAYS%>" value="" validate="Days,int,no"
	onKeyUp="isNumber(this);" MAXLENGTH="3" tabindex="1"
	 />
<div class="Clear"></div>
<label>Status</label><select
	name="<%=STATUS %>" validate="Status,string,yes" tabindex="1">
	<option value="y">Active</option>
	<option value="n">InActive</option>
</select> <script>
				document.speciality.<%=CODE%>.focus();
			</script>
</div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<div id="edited"></div>
 <input type="button" name="add" id="addbutton"
	value="Add" class="button"
	onClick="submitForm('leaveTypeMaster','hrOrderly?method=addLeaveType');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('leaveTypeMaster','hrOrderly?method=editLeaveType')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('leaveTypeMaster','hrOrderly?method=deleteLeaveType&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />


<input type="hidden" name="<%= COMMON_ID%>" value="" /> 
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<div class="bottom">
<label>Changed By:</label>
<label  class="value"><%=userName%></label>

<label>Changed Date:</label>
<label  class="value"><%=date%></label>

<label>Changed Time:</label>
<label  class="value"><%=time%></label>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>




</form>
</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Leave Type"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Details"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Days"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%=DAYS%>";

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
if(searchLeaveTypeList!=null){
Iterator itr=searchLeaveTypeList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             HrLeaveTypeMaster hrLeaveType = (HrLeaveTypeMaster)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrLeaveType.getId()%>
data_arr[<%= counter%>][1] = "<%=hrLeaveType.getLeaveType()%>"
data_arr[<%= counter%>][2] = "<%= hrLeaveType.getDetails()%>"
data_arr[<%= counter%>][3] = "<%= hrLeaveType.getDays()%>"
data_arr[<%= counter%>][4] = "<%= hrLeaveType.getLastChgBy() %>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(hrLeaveType.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= hrLeaveType.getLastChgTime() %>"
<% if(hrLeaveType.getStatus().equals("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else if(hrLeaveType.getStatus().equals("n")) {%>
data_arr[<%= counter%>][7] = "InActive"
<%}else{%>
data_arr[<%= counter%>][7] = "select"
<%}          counter++;
}
}
 %>
formName = "leaveTypeMaster"

nonEditable = ['<%= CODE%>']
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
