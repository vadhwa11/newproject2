<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * duty time master.jsp  
 * Purpose of the JSP -  This is for Duty time Details.
 * @author  Priyanka
 * 
 * Create Date: May,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.15  
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.HrDutyTimeMaster"%>

<%@page import="jkt.hms.masters.business.HrDutyMaster"%><script
	type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<br />
<style>
#contentspace label {
	text-align: right;
	padding-right: 10px;
	width: 130px;
	float: left;
	height: 9px;
}
</style>
<div id="contentspace">
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
		
	ArrayList searchDutyTimeList = (ArrayList)map.get("searchDutyTimeList");
	List<HrDutyMaster> dutyList=new ArrayList<HrDutyMaster>();
	if (map.get("dutyList")!=null)
	{
		dutyList = (List)map.get("dutyList");
	}
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }


%>
<h2 align="left" class="style1">Duty Shift Time Master</h2>

<div id="searcharea">

<div id="searchbar">

<form name="search" method="post" action=""><input type="radio"
	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" /> <font
	class="bodytextB_blue">Duty Code:</font> <input type="text"
	id="searchField" name="<%= SEARCH_FIELD%>" value=""
	validate="course Code,string,no" MAXLENGTH="8" tabindex=1
	onkeypress="return submitenter(this,event,'hrRelatedMaster?method=searchDutyTime')" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','hrRelatedMaster?method=searchDutyTime','checkSearch')"
	tabindex=1 /> <%--- Report Button   --%> <input type="button"
	name="Report" value="Generate Report Based on Search" class="button"
	onClick="" accesskey="g" tabindex=1 /> <input type="hidden"
	name="<%=JASPER_FILE_NAME%>" value="Mas_country"></form>

</div>

</div>

<br />
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<%
	 if(map.get("search") != null)
	  {
	 %> <a href="hrRelatedMaster?method=showDutyTimeJsp">Show All
Records</a> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= DUTY_NAME%>"], [2,"<%= CODE%>"],[3,"shift_type"], [4,"<%=FROM_TIME%>"], [5,"<%=TO_TIME%>"], [6,"<%=VALID_ON%>"], [7,"<%= CHANGED_BY%>"], [8,"<%= CHANGED_DATE %>"],[9,"<%= CHANGED_TIME %>"],[10,"<%=STATUS%>"] ];
	 statusTd = 10;
	</script></div>
<br />
<form name="dutyTime" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="HrDutyTimeMaster">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>"
	value="DutyFromTime"> <input type="hidden" name="title"
	value="Duty"> <input type="hidden" name="<%=JSP_NAME %>"
	value="Duty"> <input type="hidden" name="pojoPropertyCode"
	value="DutyCode"> <br>

<div id=contentoperation><label id=biglabel class="bodytextB_blue"><font
	id="error">*</font>Duty</label> <select name="<%= DUTY_NAME%>"
	id="<%= DUTY_NAME%>" validate="Duty,int,yes" tabindex=1
	style="width: 100px;">
	<option value="0">Select</option>
	<%for(HrDutyMaster hrDutyMaster:dutyList){ %>
	<option value="<%=hrDutyMaster.getId()%>"><%=hrDutyMaster.getDutyName() %></option>
	<%} %>
</select> <label class="bodytextB_blue"><font id="error">*</font>Duty
Code</label> <input id="codeId" type="text" name="<%= CODE%>" value=""
	validate="Duty Code,string,yes" class="textbox_size20" MAXLENGTH="8"
	tabindex=1 /> <label id=biglabel class="bodytextB_blue"><font
	id="error">*</font>Valid On</label> <select name="<%=VALID_ON%>" value=""
	validate="Valid On,string,yes" tabindex=1 style="width: 100px;">
	<option value="Holidays">Holidays</option>
	<option value="Normal">Normal</option>
</select> <script>
				document.speciality.<%=CODE%>.focus();
			</script>
<div class="Clear"></div>
<label id=biglabel class="bodytextB_blue"><font id="error">*</font>Duty
Shift Type</label> <input type="text" id="shift_type" name="shift_type" value=""
	validate="Duty Shift Type,string,yes" class="textbox_size20"
	MAXLENGTH="8" tabindex=1 /> <label id=biglabel class="bodytextB_blue"><font
	id="error">*</font>Duty From Time</label> <input type="text" id="fromTime"
	name="<%= FROM_TIME %>" value="" validate="Duty From Time,string,yes"
	class="textbox_size20" onKeyUp="mask(this.value,this,'2,5',':');"
	onBlur="IsValidTime(this.value,this.id);" MAXLENGTH="8" tabindex=1 />

<label id=biglabel class="bodytextB_blue"><font id="error">*</font>Duty
To Time</label> <input type="text" id="toTime" name="<%= TO_TIME %>" value=""
	validate="Duty To Time,string,yes" class="textbox_size20"
	onKeyUp="mask(this.value,this,'2,5',':');"
	onBlur="IsValidTime(this.value,this.id);" MAXLENGTH="8" tabindex=1 />

<div class="Clear"></div>
<div class="Clear"></div>
<label class="bodytextB">Changed By:</label>
<div class="changebydt"><%=userName%></div>

<label class="bodytextB">Changed Date:</label>
<div class="changebydt"><%=date%></div>

<label class="bodytextB">Changed Time:</label>
<div class="changebydt"><%=time%></div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

<br />

<div id="edited"></div>
<label>&nbsp;</label> <input type="button" name="add" id="addbutton"
	value="Add" class="button"
	onClick="submitForm('dutyTime','hrRelatedMaster?method=addDutyTime');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('dutyTime','hrRelatedMaster?method=editDutyTime')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('dutyTime','hrRelatedMaster?method=deleteDutyTime&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />

<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" /> <br />
</form>
</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Duty Name"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= DUTY_NAME%>"

data_header[1] = new Array;
data_header[1][0] = "Duty Code"
data_header[1][1] = "data";
data_header[1][2] = "25%";
data_header[1][3] = "<%= CODE%>"

data_header[2] = new Array;
data_header[2][0] = "Duty Shift Type"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "shift_type";

data_header[3] = new Array;
data_header[3][0] = "Duty From Time"
data_header[3][1] = "data";
data_header[3][2] = "40%";
data_header[3][3] = "<%= FROM_TIME %>";

data_header[4] = new Array;
data_header[4][0] = "Duty To Time"
data_header[4][1] = "data";
data_header[4][2] = "40%";
data_header[4][3] = "<%=TO_TIME%>";

data_header[5] = new Array;
data_header[5][0] = "Valid On"
data_header[5][1] = "data";
data_header[5][2] = "40%";
data_header[5][3] = "<%=VALID_ON%>";

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%= CHANGED_BY %>"

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = 0;
data_header[7][3] = "<%= CHANGED_DATE %>"

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = 0;
data_header[8][3] = "<%= CHANGED_TIME %>"

data_header[9] = new Array;
data_header[9][0] = "Status"
data_header[9][1] = "data";
data_header[9][2] = "15%";
data_header[9][3] = "<%=STATUS %>";

data_arr = new Array();

<%
if(searchDutyTimeList!=null){
Iterator itr=searchDutyTimeList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             HrDutyTimeMaster hrDutyTimeMaster = (HrDutyTimeMaster)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrDutyTimeMaster.getId()%>
<%if(hrDutyTimeMaster.getDuty()!=null){%>
data_arr[<%= counter%>][1] = "<%=hrDutyTimeMaster.getDuty().getDutyName()%>"
<%}else{%>
data_arr[<%= counter%>][1] = ""
<%}%>
data_arr[<%= counter%>][2] = "<%=hrDutyTimeMaster.getDutyCode()%>"
<%if(hrDutyTimeMaster.getDutyShiftType()!=null && !hrDutyTimeMaster.getDutyShiftType().equals("") ){%>
data_arr[<%= counter%>][3] = "<%=hrDutyTimeMaster.getDutyShiftType()%>"
<%}else{%>
data_arr[<%= counter%>][3] = ""
<%}%>

data_arr[<%= counter%>][4] = "<%= hrDutyTimeMaster.getDutyFromTime()%>"
data_arr[<%= counter%>][5] = "<%= hrDutyTimeMaster.getDutyToTime()%>"
data_arr[<%= counter%>][6] = "<%= hrDutyTimeMaster.getValidOn()%>"
data_arr[<%= counter%>][7] = "<%= hrDutyTimeMaster.getLastChgBy() %>"
data_arr[<%= counter%>][8] = "<%= HMSUtil.convertDateToStringWithoutTime(hrDutyTimeMaster.getLastChgDate()) %>"
data_arr[<%= counter%>][9] = "<%= hrDutyTimeMaster.getLastChgTime() %>"
<% if(hrDutyTimeMaster.getStatus().equals("y")){ %>
data_arr[<%= counter%>][10] = "Active"
<%}else{%>
data_arr[<%= counter%>][10] = "InActive"
<%}%>
<%
		     counter++;
}}
%>
formName = "dutyTime"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
