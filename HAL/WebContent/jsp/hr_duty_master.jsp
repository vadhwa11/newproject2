
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.*;"%>
<script type="text/javascript" language="javascript"
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
			
		ArrayList searchDutyList = (ArrayList)map.get("searchDutyList");
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		if(map.get("message") != null){
			   String message = (String)map.get("message");
			   out.println(message);
			  }
	
	
	%>
<h2 align="left" class="style1">Duty Master</h2>

<div id="searcharea">

<div id="searchbar">

<form name="search" method="post" action=""><input type="radio"
	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" /> <font
	class="bodytextB_blue">Duty Code:</font> <input type="radio"
	name="<%=SELECTED_RADIO %>" value="2" /> <font class="bodytextB_blue">Duty
Name:</font> <input type="text" id="searchField" name="<%= SEARCH_FIELD%>"
	value="" validate="Country Code,string,no" MAXLENGTH="8" tabindex=1
	onkeypress="return submitenter(this,event,'generalMaster?method=searchCountry')" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','hrRelatedMaster?method=searchDuty','checkSearch')"
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
		 %> <a href="hrRelatedMaster?method=showDutyJsp">Show All Records</a>

<%
	     }
		%> <script type="text/javascript">
		
		formFields = [
				[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
		 statusTd = 6;
		</script></div>
<br />
<form name="Duty" method="post" action=""><input type="hidden"
	name="<%= POJO_NAME %>" value="HrDutyMaster"> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="DutyName">
<input type="hidden" name="title" value="specialist"> <input
	type="hidden" name="<%=JSP_NAME %>" value="specialist"> <input
	type="hidden" name="pojoPropertyCode" value="DutyCode"> <br>

<div id=contentoperation><label class="bodytextB_blue"><font
	id="error">*</font>Duty Code</label> <input id="codeId" type="text"
	name="<%= CODE%>" value="" validate="Duty Code,string,yes"
	class="textbox_size20" MAXLENGTH="8" tabindex=1 /> <label id=biglabel
	class="bodytextB_blue"><font id="error">*</font>Duty Name:</label> <input
	type="text" name="<%= SEARCH_NAME %>" value=""
	validate="Duty Name,string,yes" class="textbox_size20" MAXLENGTH="30"
	tabindex=1 /> <script>
					document.Duty.<%=CODE%>.focus();
				</script>
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
	onClick="submitForm('Duty','hrRelatedMaster?method=addDuty');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('Duty','hrRelatedMaster?method=editDuty')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('Duty','hrRelatedMaster?method=deleteDuty&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />

<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" /> <br />
</form>
</div>

<script type="text/javascript">
	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = "Duty Code"
	data_header[0][1] = "data";
	data_header[0][2] = "25%";
	data_header[0][3] = "<%= CODE%>"
	
	data_header[1] = new Array;
	data_header[1][0] = "Duty Name"
	data_header[1][1] = "data";
	data_header[1][2] = "40%";
	data_header[1][3] = "<%= SEARCH_NAME %>";
	
	data_header[2] = new Array;
	data_header[2][0] = ""
	data_header[2][1] = "hide";
	data_header[2][2] = 0;
	data_header[2][3] = "<%= CHANGED_BY %>"
	
	data_header[3] = new Array;
	data_header[3][0] = ""
	data_header[3][1] = "hide";
	data_header[3][2] = 0;
	data_header[3][3] = "<%= CHANGED_DATE %>"
	
	data_header[4] = new Array;
	data_header[4][0] = ""
	data_header[4][1] = "hide";
	data_header[4][2] = 0;
	data_header[4][3] = "<%= CHANGED_TIME %>"
	
	data_header[5] = new Array;
	data_header[5][0] = "Status"
	data_header[5][1] = "data";
	data_header[5][2] = "15%";
	data_header[5][3] = "<%=STATUS %>";
	
	data_arr = new Array();
	
	<%
	if(searchDutyList!=null){
	Iterator itr=searchDutyList.iterator();
	          int  counter=0;
	          while(itr.hasNext())
	           {
	            
	             HrDutyMaster hrDutyMaster = (HrDutyMaster)itr.next(); 
	%>
	
	data_arr[<%= counter%>] = new Array();
	data_arr[<%= counter%>][0] = <%= hrDutyMaster.getId()%>
	data_arr[<%= counter%>][1] = "<%=hrDutyMaster.getDutyCode()%>"
	data_arr[<%= counter%>][2] = "<%= hrDutyMaster.getDutyName()%>"
	data_arr[<%= counter%>][3] = "<%= hrDutyMaster.getLastChgBy() %>"
	data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(hrDutyMaster.getLastChgDate()) %>"
	data_arr[<%= counter%>][5] = "<%= hrDutyMaster.getLastChgTime() %>"
	<% if(hrDutyMaster.getStatus().equals("y")){ %>
	data_arr[<%= counter%>][6] = "Active"
	<%}else{%>
	data_arr[<%= counter%>][6] = "InActive"
	<%}%>
	<%
			     counter++;
	}}
	%>
	formName = "Duty"
	
	nonEditable = ['<%= CODE%>'];
	start = 0
	if(data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
	makeTable(start,end);
	
	intializeHover('searchresulttable', 'TR', ' tableover');		
	</script>
